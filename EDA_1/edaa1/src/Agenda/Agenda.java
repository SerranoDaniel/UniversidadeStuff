package Agenda;

import EDA1.*;


/**
 * Created by DanielSerrano on 12/01/2018.
 */
public class Agenda{
    ArvVL<Contacto> agendaAvl;

    //Construtor da agenda
    public Agenda(){
        agendaAvl = new ArvVL();
    }

    //Retorna o contacto a que pertence o nome recebido
    public Contacto getContacto(int x){
        int o = 0;
        for (Contacto c : agendaAvl){
            if (o == x){
                return c;
            }
            o++;
        }
        return null;
    }

    //Verifica se a agenda esta vazia
    public boolean isEmpty(){
        if(agendaAvl.isEmpty()){
            return true;
        }
        return false;
    }

    //Serve para a partir do num, retornar o contacto inteiro em formato String
    public String getContactoStringWithNumber(int num) {
        for (Contacto c : agendaAvl) {
            if(containsNum(num)){
                return c.toString();
            }
        }
        return null;
    }

    //Verifica se um dado Nome existe na agenda
    public boolean containsNome(String nome){
        for(Contacto c: agendaAvl){
            if(c.getNome().compareToIgnoreCase(nome)==0){
                return true;
            }
        }
        return false;
    }

    //Verifica se um dado Numero existe na agenda
    public boolean containsNum(int num){
        for(Contacto c: agendaAvl){
            for(int i=0; i < c.sizeNum(); i++){
                if(c.getNumIndex(i)==num){
                    return true;
                }
            }
        }
        return false;
    }

    public void removeNumber(String nome, int i){
        for(Contacto c: agendaAvl){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.getNum().remove(i);
            }
        }
    }

    //Serve para modificar um numero cujo o contacto tem o nome dado
    public void setNumero(String nome, int i, int numNovo){
        for(Contacto c : agendaAvl){
            if(c.getNome().compareToIgnoreCase(nome)==0){
                c.setNumero(i, numNovo);
            }
        }
    }

    //Retorna o numero de numeros que um nome tem associado a ele
    public int sizeContacto(String nome){
        for (Contacto c : agendaAvl) {
            if(c.getNome().compareToIgnoreCase(nome) == 0){
                return c.sizeNum();
            }
        }
        return 0;
    }

    //Retorna todos os numeros, em formato String, associados a um dado nome
    public String showNumeros(String nome) {
        for (Contacto c : agendaAvl) {
            if (c.getNome().compareToIgnoreCase(nome) == 0){
                return c.toStringNum();
            }
        }
        return "Contact not found";
    }

    //Serve para modificar o nome
    public void setNome(String nomeAnt, String nomeNovo){
        for(Contacto c: agendaAvl){
            if(c.getNome().compareToIgnoreCase(nomeAnt)==0){
                c.setNome(nomeNovo);
            }
        }
    }

    //Adiciona um numero a um determinado contacto com o nome dado
    public void addContacto(String nome, int numero){
        for(Contacto c : agendaAvl){
            if(c.getNome().compareToIgnoreCase(nome)==0){
                c.addNumero(numero);
            }
        }
    }

    //Inser na agenda um novo contacto
    public void insere(Contacto c){
        agendaAvl.insere(c);
    }

    public void remove(String name){
        for(Contacto c: agendaAvl){
            if(c.getNome().compareToIgnoreCase(name)==0){
                agendaAvl.remove(c);
            }
        }
    }

    //Faz print de forma alfabetica da agenda
    public void listarContacto(){
        agendaAvl.printEmOrdem();
    }

}
