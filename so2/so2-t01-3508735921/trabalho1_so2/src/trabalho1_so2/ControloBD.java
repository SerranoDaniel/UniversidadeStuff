package trabalho1_so2;

import java.rmi.server.*;
import java.sql.*;
import java.util.ArrayList;

public class ControloBD extends UnicastRemoteObject implements ControloBDIF, java.io.Serializable {

    java.sql.Connection con = null;
    java.sql.Statement stmt = null;

    public ControloBD(String host_BaseDados, String nome_BaseDados, String user_BaseDados, String pass_BaseDados) throws java.rmi.RemoteException, Exception {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://" + host_BaseDados + ":5432/" + nome_BaseDados, user_BaseDados, pass_BaseDados);
            stmt = con.createStatement();

            if (stmt != null) {
                System.out.println("Ligado à Base de Dados");
            } else {
                System.out.println("Erro ao ligar à Base de Dados");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Problems setting the connection " + e);
        }
    }

    /*
    Funcao que recebe da class cliente um questionario e o adiciona à BD.
        Para tal ir executar uma query de INSERT que returnará tambem, no resulstset o Id desse questionario (que esta em modo Serial)
        e a partir desse ID e de um arraylist com as questao desse qustionario sao tambem inseridas as perguntas na base de dados das perguntas
     */
    @Override
    public String criarQuestionario(Questionario questionario) throws java.rmi.RemoteException {
        String nome = questionario.getNome();
        ArrayList<Perguntas> listaQuestoes = questionario.getQuestoes();
        int numPerguntas = questionario.getNumPerguntas();
        int numeroDeRespostasAoQuestionario = questionario.getNumRespostas();

        try {
            ResultSet rs = stmt.executeQuery("INSERT INTO questionario VALUES(DEFAULT, '" + nome + "'," + numeroDeRespostasAoQuestionario + "," + numPerguntas + ") RETURNING IdQuestionario");

            rs.next();

            int IdQuestionario = rs.getInt("IdQuestionario");

            for (int i = 0; i < numPerguntas; i++) {
                stmt.executeUpdate("INSERT INTO pergunta VALUES(" + IdQuestionario + ", DEFAULT,'" + listaQuestoes.get(i).getPergunta() + "'," + listaQuestoes.get(i).getRespostaGlobal() + ")");
            }
            rs.close();
            return "\n<< Questionário " + IdQuestionario + " adicionado com " + numPerguntas + " perguntas!\n";
        } catch (SQLException e) {
            return "\n---Erro a adicionar o questionário---\n" + e;
        }
    }

    /*
    Esta funcao serve para ir buscar à BD de qustionarios, os qustionarios ordenados por Id e returnar uma string
        a devolver ao user ou o tipo de erros que possam ter ocorrido
     */
    @Override
    public String consultarQuestionario() throws java.rmi.RemoteException {
        String paraDevolver = "\n";

        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM questionario ORDER BY IdQuestionario");
            if (rs.next() == false) {
                rs.close();
                return "\n---Não há questionários---\n";
            } else {
                paraDevolver += "<< ID: " + rs.getInt("IdQuestionario")
                        + " | Nome: " + rs.getString("nome")
                        + " | Número de perguntas: " + rs.getInt("numPerguntas") + "\n";
                while (rs.next()) {
                    paraDevolver += "<< ID: " + rs.getInt("IdQuestionario")
                            + " | Nome: " + rs.getString("nome")
                            + " | Número de perguntas: " + rs.getInt("numPerguntas") + "\n";
                }
                rs.close();
            }
        } catch (SQLException e) {
            return "\n---Erro ao consultar questionários---\n" + e;
        }

        return paraDevolver;
    }

    /*
    Esta funcao recebe como argumento o id de um questionario, e executa a query de DELETE de forma a apagar esse 
        questionario que ira tambem apagar as perguntas pois estão em modo cascade (foreign key) e retorna uma string a 
        com mensagem de sucesso ou caso contrário, com o erro que ocorreu
     */
    @Override
    public String apagarQuestionario(int id) throws java.rmi.RemoteException {
        try {
            int i = stmt.executeUpdate("DELETE FROM questionario WHERE IdQuestionario=" + id);
            if (i != 0) {
                return "\n---Questionário apagado com sucesso---\n";
            } else {
                return "\n--Questionário inexistente---\n";
            }
        } catch (SQLException e) {
            System.out.println(e);
            return "\n---Erro ao apagar questionário---\n";
        }
    }

    /*
    Esta funcao receber um Id de um questinoario e a partir desse Id seleciona todas as perguntas (BD de perguntas)
        associadas a esse ID e devolve um arraylist com essas perguntas retirardas, ou caso ocorra algum erro será tratado
        da forma apropriada (retorna null ou empty)
     */
    @Override
    public ArrayList<Perguntas> obterPerguntasDeQuestionario(int id) throws java.rmi.RemoteException {
        ArrayList<Perguntas> listaPerguntas = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM pergunta WHERE IdQuestionario =" + id + " ORDER BY IdPergunta");
            if (rs.next() == false) {
                rs.close();
                return listaPerguntas;
            } else {
                Perguntas perguntaAux1 = new Perguntas(rs.getInt("IdPergunta"), rs.getString("pergunta"), rs.getInt("respostaGlobal"));
                listaPerguntas.add(perguntaAux1);
                while (rs.next()) {
                    Perguntas perguntaAux = new Perguntas(rs.getInt("IdPergunta"), rs.getString("pergunta"), rs.getInt("respostaGlobal"));
                    listaPerguntas.add(perguntaAux);
                }
                rs.close();
                return listaPerguntas;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    /*
    Esta funcao recebe o id de um questionario e um arraylist de perguntas (que foram respondidas anteriormente)
        e em primeiro faz update das perguntas na base de dados, e depois faz update do numero de respostas ao questionario na base de dados
        dos questionarios e insere mais um valor (serial) na BD de codigos devolvendo tambem o codigo da resposta que irá ser
        transmitido para o user
     */
    @Override
    public String guardarRespostas(int idQuest, ArrayList<Perguntas> listaPerguntas) throws java.rmi.RemoteException {
        //Adiciona as respostas somando ao valor global das respostas
        for (Perguntas pergunta : listaPerguntas) {
            try {
                int i = stmt.executeUpdate("UPDATE pergunta SET respostaGlobal =" + pergunta.getRespostaGlobal() + "WHERE IdPergunta = " + pergunta.getId());
                if (i == 0) {
                    return "\n--Questionário inexistente---\n";
                }
            } catch (SQLException e) {
                return "\n---Erro ao guardar respostas---\n";
            }
        }

        //Incrementa valor ao numero de respostas ao quesitonário
        try {
            stmt.executeUpdate("UPDATE questionario SET numeroDeRespostasAoQuestionario = numeroDeRespostasAoQuestionario + 1 WHERE IdQuestionario = " + idQuest);
            ResultSet rs = stmt.executeQuery("INSERT INTO codigos VALUES(DEFAULT) RETURNING codigoResposta");

            rs.next();

            int codigoResposta = rs.getInt("codigoResposta");

            rs.close();
            return "\n>> Respostas guardadas com sucesso com o código: " + codigoResposta + "\n";
        } catch (SQLException ex) {
            return "\n---Erro ao aceder às tabelas de questionários ou códigos--\n";
        }
    }

    /*
    Esta funcao recebe como argumento o id de um questionario e vai buscar esse questionario à base de dados de modo a retirar o numero de
        vezes que foi respondido (variavel numeroDeREspostasAoQuestionario) e devolver esse valor, ou -1 ou -2 em caso de erro ou de inezistencia desse quesitonario
     */
    @Override
    public int obterNumeroRespostas(int id) throws java.rmi.RemoteException {
        try {
            ResultSet rs = stmt.executeQuery("SELECT numeroDeRespostasAoQuestionario FROM questionario WHERE IdQuestionario=" + id);

            boolean check = rs.next();

            if (check == true) {
                int acessos = rs.getInt("numeroDeRespostasAoQuestionario");

                rs.close();

                return acessos;
            }
            rs.close();
            return -2;
        } catch (SQLException e) {
            return -1;
        }
    }

    /*
    Esta funcao fecha a conexao com a base de dados
     */
    public void fechaBD() throws SQLException {
        this.stmt.close();
        this.con.close();
    }
}
