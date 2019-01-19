package TrabalhoProg2;

import java.util.ArrayList;

public class Pawn {
    public int x, y;

    public Pawn(int linha,int coluna){
        this.x=linha;
        this.y=coluna;
        //System.out.print(linha);
        //System.out.print(coluna);
    }

    void movePawn(String move){
        if(move.equals("NORT")){
            this.y = y - 1;
        }
        if(move.equals("SOUTH")){
            this.y = y - 1;
        }
        if(move.equals("EAST")){
            this.x = x + 1;
        }
        if(move.equals("WEST")){
            this.x = x -1;
        }
        else{
            this.x = x;
            this.y = y;
        }
    }

    public ArrayList<String> getRoute(Route x){
        return  x.routeList;
   }
}
