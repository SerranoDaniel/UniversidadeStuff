package trabalho1_so2;

public class Perguntas implements java.io.Serializable {

    private int id, respostaGlobal;
    private String pergunta;

    public Perguntas(int id, String pergunta, int respostaGlobal) {
        this.id = id;
        this.pergunta = pergunta;
        this.respostaGlobal = respostaGlobal;
    }

    public Perguntas(String pergunta) {
        this.pergunta = pergunta;
    }

    public void responder(int resposta) {
        this.respostaGlobal += resposta;
    }

    public float media(int acessos) {
        return (float) this.respostaGlobal / (float) acessos;
    }

    public String getPergunta() {
        return this.pergunta;
    }

    public int getRespostaGlobal() {
        return this.respostaGlobal;
    }

    public int getId() {
        return this.id;
    }
}
