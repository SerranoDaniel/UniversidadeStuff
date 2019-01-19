package TrabalhoProg2;


import javax.lang.model.type.ArrayType;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Maze maze = new Maze();
        Route route = new Route();

        maze.ReadFile();
        ArrayList<ArrayList<String>> tabMain = maze.getMaze();
        int collen = maze.getCollen();
        int rowlen = maze.getRowlen();
        route.startPos(tabMain, rowlen, collen);

        Pawn pawn = new Pawn(route.getX(),route.getY());

        Menu menu = new Menu(tabMain, rowlen, collen);

        menu.start();

        String ola = menu.play();
        boolean cMove = maze.canMove(pawn,ola);

        System.out.print(cMove);

    }

}
