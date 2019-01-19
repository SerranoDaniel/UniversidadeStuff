package work;

public interface IPawn {

	void move(Move move); // changes this pawn position according to move.

	Route getRoute(); // returns the current route.

}
