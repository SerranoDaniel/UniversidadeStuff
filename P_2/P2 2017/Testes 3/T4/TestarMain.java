
public class TestarMain{
  public static void main(String[] args){
    
    //Turma tM = new Turma();
    Notas nFlo = new Notas();
    float[] notasDosTestes = {17.0f, 18.0f, 16.0f, 19.0f, 16.0f};
    nFlo.setTrab(19.5f);
    nFlo.setTest(notasDosTestes);
    nFlo.setAlea();
    //System.out.print(nFlo.media()); }}
    
    
    
    //enunciado classe main
    //identico ao TestarMain anterior
    Turma tM = new Turma();
    tM.inputAluno(32640, nFlo);
    System.out.print(tM.media()); }}