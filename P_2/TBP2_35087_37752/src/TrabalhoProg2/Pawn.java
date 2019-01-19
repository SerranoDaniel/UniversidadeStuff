package TrabalhoProg2;

import java.util.ArrayList;

public class Pawn {
    public int x, y, xend, yend;

    void setPawn(int x, int y){
        this.x = x;
        this.y = y;
    }

    void setEnd(int x, int y){
        this.xend = x;
        this.yend = y;
    }



    void movePawn(String move){
        if(move.equals("NORT")){
            this.y -= 1;
        }
        if(move.equals("SOUTH")){
            this.y += 1;
        }
        if(move.equals("EAST")){
            this.x += 1;
        }
        if(move.equals("WEST")){
            this.x -= 1;
        }
        else{
            this.x = this.x;
            this.y = this.y;
        }
    }

    public ArrayList<String> getRoute(Route x){
        return  x.routeList;
   }
}
