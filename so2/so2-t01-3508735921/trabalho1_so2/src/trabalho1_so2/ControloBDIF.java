package trabalho1_so2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ControloBDIF extends java.rmi.Remote {

    public String criarQuestionario(Questionario questionario) throws java.rmi.RemoteException;

    public String consultarQuestionario() throws java.rmi.RemoteException;

    public String apagarQuestionario(int id) throws java.rmi.RemoteException;

    public ArrayList<Perguntas> obterPerguntasDeQuestionario(int id) throws java.rmi.RemoteException;

    public String guardarRespostas(int idQuest, ArrayList<Perguntas> listaPerguntas) throws java.rmi.RemoteException;

    public int obterNumeroRespostas(int id) throws java.rmi.RemoteException;
}
