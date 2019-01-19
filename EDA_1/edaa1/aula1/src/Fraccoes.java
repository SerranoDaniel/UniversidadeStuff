import org.omg.PortableInterceptor.ServerRequestInfo;

/**
 * Created by JoaoManuel on 25/09/2017.
 */
public class Fraccoes {

    public int nominador;
    public int denominador;


    public Fraccoes(){

    }


    public Fraccoes(int nominador){
        this.nominador=nominador;
    }


    public Fraccoes(int nominador, int denominador){
        this.nominador=nominador;
        this.denominador=denominador;
    }




    public int getNom(){

        return this.nominador;
    }
    public int getDen(){

        return this.denominador;
    }



    public void setNom(int novo_nom){

        this.nominador=novo_nom;

    }

    public void setDen(int novo_Den){

        this.denominador=novo_Den;

    }

    public String toString(){

        System.out.println(this.nominador+"/"+this.denominador);

        return null;
    }

    public void reduce() {

        boolean irredut = true;

        while (irredut==true) {

            if (this.nominador % 2 == 0 || this.denominador % 2 == 0) {

                this.nominador=this.nominador/2;
                this.denominador=this.denominador/2;


            }
            if (this.nominador % 2 != 0 || this.nominador < 0 || this.denominador % 2 != 0 || this.denominador < 0) {

                irredut = false;

                System.out.println("sadfadf");
            }



        }

    }






}

