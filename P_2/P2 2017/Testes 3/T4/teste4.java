1-a é so declarar as variáveis como float

1-b mport java.util.Random;
import java.util.Random;
class main {
  public static void main(String[] args) {
    Notas n = new Notas();
    n.setTest(10.0f);
    n.setTrab(10.0f);
    n.ajax();
    n.media();
  }
}

class Notas {
  private float trab, test, alea;
  Random r;

  public void setTrab (float trab) {
    this.trab = trab;
  }

  public void setTest (float test) {
    this.test = test;
  }

  public float getTrab () {
    return this.trab;
  }

  public float getTest () {
    return this.test;
  }

  public void ajax () {
    Random r = new Random();
    int calgon = 0;
    for (int i = 0; i < 3; i++){
      calgon += r.nextInt(6-1+1)+1;
    }
    this.alea = calgon;
  }

  public float getAlea () {
    return this.alea;
  }

  public void media() {
    float trab = this.trab*0.2f;
    float test = this.test*0.55f;
    float alea = this.alea*0.25f;
    int media = (int) (trab + test + alea);
    System.out.print(media);
  }
 }

1-c public class Turma {
  public static void main(String[] args) {
    Map notas = new TreeMap<Int, Nota>();
    float t = 0.0f;
    int i = 0;

    public void Insere(Int aluno, Notas nota) {
      notas.put(aluno, nota);
    }
    public int media() {
      for(notas alunonota: TreeMap.entrySet()) {
        i++;
        Notas tide = alunonota.getValue();
        t = t + tide;
      }
      return t/i;
    }
  }
}
