/**
 * Created by User on 30/10/2017.
 */
public class Bus {

    private int defLugares, lugaresDisponiveis, nPessoas;

    public Bus(){
        this.defLugares = 20;
        this.lugaresDisponiveis = 20;
        this.nPessoas = 0;
    }

    public Bus(int defLugares){
        this.defLugares = defLugares;
        this.lugaresDisponiveis = defLugares;
        this.nPessoas = 0;
    }

    public int getLugaresDisponiveis(){
        return lugaresDisponiveis;
    }

    public int getnPessoas(){
        return nPessoas;
    }

    public void addnPessoas(int num){
        if(full()){
            System.out.println("The bus is full, wait for another one");
        }
        this.nPessoas += num;
    }

    public void removenPessoas(int num){
        if(empty()){
            System.out.println("Bus is already empy");
        }
        this.nPessoas -= num;
    }

    public boolean full(){
        if(defLugares==lugaresDisponiveis){
            return true;
        }
        return false;
    }

    public boolean empty(){
        if(nPessoas==0){
            return true;
        }
        return false;
    }


}
