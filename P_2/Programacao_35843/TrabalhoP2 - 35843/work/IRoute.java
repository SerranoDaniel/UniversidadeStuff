package work;

public interface IRoute {

	int getCol(); // returns the column of the current position.

	int getRow(); // returns the row of the current position.

	int getCol(int i); // returns the column of the i-th position.

	int getRow(int i); // returns the row of the i-th position.

	int length(); // returns the number of moves in this route.

	void move(Move move); // append a new position to this route.

}
