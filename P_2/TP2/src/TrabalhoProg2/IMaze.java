package TrabalhoProg2;


import java.io.IOException;
import java.util.ArrayList;

public interface IMaze {
    boolean canMove(Pawn pawn, String movePlay); // true IFF pawn can do move in this maze.
    //MoveOption[] getOptions(); // returns the possible moves of pawn.
    void movePawnMaze(Pawn pawn, String movePlay); // if pawn can move, change his position.
    boolean isSolvedBy(Pawn pawn); // true IFF pawn is in EXIT position.
    void ReadFile()throws IOException; //Reads a file and set a bi dimensional arrayList as the Maze, and checks if that file is in the right setup.
    ArrayList<ArrayList<String>> getMaze(); // Used to get the maze made by the fail input
    void setMaze(String s, Pawn peao, String move); // Sets the maze to another elements so that we can paint the pawn route
    enum MoveOption{}; //Says what the options to use
    void youPlay();//Used to paint the maze board
    String playMove(); // Asks and receive player move
}

