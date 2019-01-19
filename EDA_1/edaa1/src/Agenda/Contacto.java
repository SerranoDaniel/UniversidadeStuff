package Agenda;

import EDA1.DoubleLinkedList;
import EDA1.LinkedList;

/**
 * Created by DanielSerrano on 29/12/2017.
 */
public class Contacto implements Comparable<Contacto>{
    private String nome;
    private DoubleLinkedList<Integer> numero;

    //Contrutor vazio de contacto
    public Contacto(){
        this.nome = null;
        this.numero = null;
    }

    //Construtor com nome e numero de contacto
    public Contacto(String nome, int numero){
        this.nome = nome;
        this.numero = new DoubleLinkedList<>();
        this.numero.add(numero);
    }

    //Retorna o nome
    public String getNome(){
        return nome;
    }

    //retorna a lista numero
    public DoubleLinkedList getNum(){
        return numero;
    }

    //Retorna o numero do index dado
    public int getNumIndex(int i){
        return this.numero.get(i);
    }

    //Modifica o nome
    public void setNome(String nome){
        this.nome = nome;
    }

    //Modifica o numero
    public void setNumero(int x, int numeroNovo){
        numero.set(x-1,numeroNovo);
    }

    //Retorna o numero de numeros na lista
    public int sizeNum(){
        return numero.size();
    }

    //Adicionaa um numero à lista
    public void addNumero(int numero){
        this.numero.add(numero);
    }

    //Retorna o contacto inteiro em formato String
    public String toString() {
        String str = numero.get(0) + " ";
        for(int i = 1; i < numero.size(); i++){
            str += " |  Numero: " + numero.get(i);
        }
        return "Nome: " + nome + "   |   Numero: " + str;
    }

    //Retorna os numeros em formato String
    public String toStringNum() {
        String str = "(1)- " + numero.get(0) + " ";
        for(int i = 1; i < numero.size(); i++){
            str += " |  (" + (i + 1) + ")- " + numero.get(i);
        }
        return "Numero: " + str;
    }

    //Utiliza o Nome como forma de comparacao entre contactos
    public int compareTo(Contacto outroContacto) throws ClassCastException {
        if (!(outroContacto instanceof Contacto))
            throw new ClassCastException("Intruduza um contacto, por favor.");
        String outroNomeContacto = ((Contacto) outroContacto).getNome();
        return this.nome.compareToIgnoreCase(outroNomeContacto);
    }
}
