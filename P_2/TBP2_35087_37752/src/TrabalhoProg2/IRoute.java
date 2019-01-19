package TrabalhoProg2;

import java.util.ArrayList;

public interface IRoute {
    int getCol(); // returns the column of the current position.
    int getRow(); // returns the row of the current position.
    int getCol(int i, Maze maze); // returns the column of the i-th position.
    int getRow(int i, Maze maze); // returns the row of the i-th position.
    int getLength(); // returns the number of moves in this route.
    void moveRoute(String movePlay); // append a new position to this route.
    int getX(); //Gets Route x start.
    int getY(); // Gets Route Y start.
    int getXend(); // Gets Route X end.
    int getYend(); // Gets Route Y end.
    void startPos(ArrayList<ArrayList<String>> tab, int row, int col); // Finds pawns start position.
    void endPos(ArrayList<ArrayList<String>> tab, int row, int col); // Finds pawns ends position
}
