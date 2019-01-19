package TrabalhoProg2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze implements IMaze {
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
        FileReader file = new FileReader("C:\\Users\\User\\Desktop\\Map.txt");
        FileReader file1 = new FileReader("C:\\Users\\User\\Desktop\\Map.txt");
        BufferedReader reader = new BufferedReader(file);
        BufferedReader readerCheck = new BufferedReader(file1);

        String lineCheck = readerCheck.readLine();
        String line = reader.readLine();
        String lineCheck1 = lineCheck;

        while(lineCheck!=null){
            for(int k=0; k < line.length()-2; k++) {
                String letra = Character.toString(lineCheck.charAt(k));
                if (!letra.equals("E") && !letra.equals("W") && !letra.equals("S") && !letra.equals("_")){
                    JOptionPane.showMessageDialog(null, "Your file contains an invalid Character");
                    System.exit(0);
                }
            }


            if(lineCheck.length() != lineCheck1.length()){
                JOptionPane.showMessageDialog(null, "Your file has not the right setup");
                System.exit(0);
            }
            lineCheck = readerCheck.readLine();
        }

        int row= 0, col = 0;
        for(; line!=null; row++){
            ArrayList<String> temp = new ArrayList<String>();
            int i=0;
            char x = line.charAt(i);
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
        this.collength = col;
        this.rowlength = row;
    }

    public ArrayList<ArrayList<String>> getMaze(){
        return tabuleiro;
    }

    public void setMaze(String s, Pawn peao, String move){
        int x = peao.x;
        int y = peao.y;
        int xend = peao.xend;
        int yend = peao.yend;
        if(x == xend && y == yend){
            this.tabuleiro.get(y).set(x, "E");
        }
        else {
            this.tabuleiro.get(y).set(x, s);
            if (move.equals("NORT")) {
                this.tabuleiro.get(y + 1).set(x, "_");
            }
            if (move.equals("SOUTH")) {
                this.tabuleiro.get(y - 1).set(x, "_");
            }
            if (move.equals("EAST")) {
                this.tabuleiro.get(y).set(x - 1, "_");
            }
            if (move.equals("WEST")) {
                this.tabuleiro.get(y).set(x + 1, "_");
            }
        }

    }
///////////////////////////////////////////////////////
    public boolean canMove(Pawn peao, String move) {
            int x = peao.x;
            int y = peao.y;

            switch (move) {
                case "SOUTH":
                    if ((y + 1) >= rowlength || tabuleiro.get(y + 1).get(x).equals("W")) {
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
                    if ((x + 1) >= collength || tabuleiro.get(y).get(x + 1).equals("W")) {
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
                case "NOOP":
                        return true;
                default:
                    return false;
            }
        }

    public MoveOption[] getOptions() {
        return MoveOption.values();
    }


    ///////////////////////////////////////////////
    public boolean isSolvedBy(Pawn peao){
        int x = peao.x;
        int y = peao.y;
        if(tabuleiro.get(y).get(x).equals("E"))
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



    ////////////////////////////
    public void movePawnMaze(Pawn peao, String move){
        peao.movePawn(move);
    }

    public void youPlay(){
        BoardPaint boardMenu = new BoardPaint(tabuleiro, rowlength, collength);
        boardMenu.x(tabuleiro, rowlength, collength);
    }

    public String playMove(){
        String inputstr = JOptionPane.showInputDialog("What's your move?: " );
        return inputstr;
    }
}
