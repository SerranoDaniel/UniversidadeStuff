package work;

public class Maze implements IMaze {

	@Override
	public boolean canMove(Pawn pawn, Move move) {

		Route route = pawn.getRoute();

		return route.checkMove(move);
	}

	@Override
	public Move[] getOptions(Pawn pawn) {

		Move[] options = new Move[4];
		int i = 0;

		for (Move m : Move.values()) {
			if (canMove(pawn, m) == true) {
				options[i] = m;
				i++;
			}
		}
		
		options[i] = Move.NOOP;

		return options;
	}

	@Override
	public void move(Pawn pawn, Move move) {
		pawn.move(move);
	}

	@Override
	public boolean isSolvedBy(Pawn pawn) {

		Route route = pawn.getRoute();

		if (route.currentCol == route.finalCol && route.currentRow == route.finalRow) {
			return true;
		}

		return false;
	}
}