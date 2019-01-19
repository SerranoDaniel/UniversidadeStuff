package TrabalhoProg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    private ArrayList<ArrayList<String>> tabuleiro = new ArrayList<ArrayList<String>>();
    private int collength, rowlength;

    public Maze(){
    }

    public int getCollen(){

        return collength;
    }

    public int getRowlen(){

        return rowlength;
    }

    public void ReadFile() throws IOException {
        FileReader file = new FileReader("C:\\Users\\User\\Desktop\\coco.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        int row= 0, col = 0;
        for(; line!=null; row++){
            ArrayList<String> temp = new ArrayList<String>();
            int i=0;
            char x = line.charAt(i);
            //System.out.print(x);
            i++;
            for(; x!='n'; i++){
                temp.add(x + "");
                x = line.charAt(i);
            }
            col = temp.size();
            temp.remove(i-2);
            col--;
            tabuleiro.add(temp);
            line = reader.readLine();
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(tabuleiro.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        this.collength = col;
        this.rowlength = row;
    }

    public ArrayList<ArrayList<String>> getMaze(){
        return tabuleiro;
    }
///////////////////////////////////////////////////////
        boolean canMove(Pawn peao, String move) {
            int x = peao.x;
            int y = peao.y;

            switch (move) {
                case "SOUTH":
                    if ((y + 1) > rowlength || tabuleiro.get(y + 1).get(x).equals("W")) {
                        return false;
                    } else {
                        return true;
                    }

                case "NORT":
                    if ((y - 1) < 0 || tabuleiro.get(y - 1).get(x).equals("W")) {
                        return false;
                    } else {
                        return true;
                    }

                case "EAST":
                    if ((x + 1) > collength || tabuleiro.get(y).get(x + 1).equals("W")) {
                        return false;
                    } else {
                        return true;
                    }

                case "WEST":
                    if ((x - 1) < 0 || tabuleiro.get(y).get(x - 1).equals("W")) {
                        return false;
                    } else {
                        return true;
                    }
                default:
                    System.out.println("Erro");
                    return false;
            }
        }

///////////////////////////////////////////////
    boolean isSolvedBy(Pawn peao){
        if(tabuleiro.get(peao.y).get(peao.x).equals("E"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

/////////////////////
    public enum MoveOption {NORT, EAST, SOUTH, WEST, NOOP};

    MoveOption[] getOptions(Pawn peao){
        return MoveOption.values();
    }

    ////////////////////////////
    void movePawnMaze(Pawn peao, String move){
        if(canMove(peao,move)==true){
            peao.movePawn(move);
        }
        else{
            System.out.println("You can not move in this direction, please choose another one");
        }
    }


}
