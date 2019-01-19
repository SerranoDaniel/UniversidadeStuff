package work;

public interface IMaze {

	boolean canMove(Pawn pawn, Move move); // true IFF pawn can do move in this maze.

	Move[] getOptions(Pawn pawn); // returns the possible moves of pawn.

	void move(Pawn pawn, Move move); // if pawn can move, change his position.

	boolean isSolvedBy(Pawn pawn); // true IFF pawn is in EXIT position.

}
