package trabalho1_so2;

import java.util.ArrayList;
import java.util.Scanner;

public class Questionario implements java.io.Serializable {

    private String nome;

    private ArrayList<Perguntas> listaQuestoes;

    private int numeroDeRespostasAoQuestionario, numPerguntas;

    //Constructor
    public Questionario() {
        listaQuestoes = new ArrayList<>();
        this.numeroDeRespostasAoQuestionario = 0;
        this.numPerguntas = 0;

        escreverNome();
        escreverPerguntas();
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Perguntas> getQuestoes() {
        return this.listaQuestoes;
    }

    public int getNumPerguntas() {
        return this.numPerguntas;
    }

    public int getNumRespostas() {
        return this.numeroDeRespostasAoQuestionario;
    }

    /*
    Metodo que escreve o nome do questionario
     */
    private void escreverNome() {
        System.out.print("\nPor favor digite a nome do seu questionário\n>> ");
        Scanner scanNome = new Scanner(System.in);
        this.nome = scanNome.nextLine();
    }

    /*
    Metodo que adiciona a um arraylist das perguntas pedidas ao utilizador
     */
    private void escreverPerguntas() {
        int i = 5;
        Scanner scanQuestions = new Scanner(System.in);

        while (i > 0) {
            if (i <= 2) { //A partir da 3 pergunta já pode cancelar (3 a 5 perguntas)
                System.out.print("\nEscreva a sua pergunta (0 para evitar mais perguntas)\n>> ");
                String question = scanQuestions.nextLine();

                if (question.equals("0")) { //Nao ha mais perguntas                
                    break;
                }
                Perguntas pergunta = new Perguntas(question);
                this.listaQuestoes.add(pergunta);
            } else {
                System.out.print("\nEscreva a sua pergunta\n>> ");
                String question = scanQuestions.nextLine();

                Perguntas pergunta = new Perguntas(question);
                this.listaQuestoes.add(pergunta);
            }
            i--;
        }
        this.numPerguntas = listaQuestoes.size();
    }
}
