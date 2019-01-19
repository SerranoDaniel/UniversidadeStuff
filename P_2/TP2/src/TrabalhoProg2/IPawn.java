package TrabalhoProg2;

import java.util.ArrayList;

public interface IPawn {
    void movePawn(String movePlay); // changes this pawn position according to move.
    ArrayList<String> getRoute(Route route); // returns the current route.
    void setEnd(int x, int y); //Sets pawn end.
    void setPawn(int x, int y); // Sets pawn start.
}
