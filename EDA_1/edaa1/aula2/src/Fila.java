/**
 * Created by JoaoManuel on 02/10/2017.
 */

import java.util.ArrayList;

public class Fila<T> implements FiladeEspera<T>{

    ArrayList<T> lista = new ArrayList<T>();
    int tamanho;


    public Fila(){

        tamanho = 50;
        lista = new ArrayList<T>();

    }

    public Fila(int tamanho){

        this.tamanho = tamanho;
        lista = new ArrayList<T>();

    }


    @Override
    public int getcomp() {

        return lista.size();
    }



    @Override
    public int getmax() {
        return tamanho;
    }


    @Override
    public int getvagas() {

        return tamanho-lista.size();
    }

    @Override
    public boolean checkfull() {

        if (tamanho==lista.size()){
            return true;
        }
        return false;

    }

    @Override
    public boolean checkvoid() {

        if (lista.size()==0){
            return true;
        }
        return false;

    }

    @Override
    public void addelement(T a) {
        lista.add(a);
    }

    @Override
    public T getfirst() {

        T x = lista.get(0);

        return x;
    }

    @Override
    public T removefirst() {

        T x = lista.get(0);
        lista.remove(0);
        return x;
    }

    @Override
    public String toString() {

        return lista.toString();

    }




    public static void main (String[] args){

        Fila fila = new Fila();

        fila.addelement(1);
        fila.addelement(5);
        fila.addelement(8);
        fila.addelement(10);

        System.out.println(fila.getcomp());
        System.out.println(fila.getfirst());
        System.out.println(fila.getmax());
        System.out.println(fila.getvagas());
        System.out.println(fila.checkvoid());
        System.out.println(fila.checkfull());
        System.out.println(fila.removefirst());
        System.out.println(fila.getfirst());



    }
}

