import java.util.*;

public class FilaDeEsperaa<T> implements FilaDeEspera<T>{

    ArrayList<T> lista = new ArrayList<T>();
    int tamanho;

    public FilaDeEsperaa(){
        tamanho=50;
        lista = new ArrayList<T>();
    }

    public FilaDeEsperaa(int max){

        this.tamanho=tamanho;
        lista = new ArrayList<T>();

    }

    @Override
    public int getCompFila() {
        return lista.size();
    }

    @Override
    public int getCompMaxFila() {
        return tamanho;
    }

    @Override
    public int getNumVagas() {
        return tamanho - lista.size();
    }

    @Override
    public boolean isFull() {
        if(lista.size() == tamanho){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(lista.size() == 0){
            return true;
        }
        return false;
    }

    @Override
    public void addElement(T num) {
        lista.add(num);

    }

    @Override
    public T firstElement() {
        return lista.get(0);
    }

    @Override
    public T removeFirstElement() {
        T x = lista.get(0);
        lista.remove(0);
        return x;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    public static void main (String[] args) {
        FilaDeEspera teste = new FilaDeEsperaa<>();

        teste.addElement(1);
        teste.addElement(5);
        teste.addElement(8);
        teste.addElement(10);

        System.out.println(teste.getCompFila());
        System.out.println(teste.firstElement());
        System.out.println(teste.getCompMaxFila());
        System.out.println(teste.getNumVagas());
        System.out.println(teste.isEmpty());
        System.out.println(teste.isFull());
        System.out.println(teste.removeFirstElement());
        System.out.println(teste.firstElement());
        System.out.println(teste);

        FilaDeEspera coco = new FilaDeEsperaa<>();

        coco.addElement(2);
        coco.addElement(4);
        coco.addElement(6);
        coco.addElement(8);
        coco.addElement(0);

        System.out.println(coco);

        if(coco.getCompFila() > teste.getCompFila()){
            System.out.println("Coco e maior que teste");
        }else{
            System.out.println("Teste e maior que coco");
        }

    }
}
