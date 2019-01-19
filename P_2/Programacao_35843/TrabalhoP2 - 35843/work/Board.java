package work;

public class Board {

	MazeCell[][] board;

	Route route;
	Pawn pawn;
	Maze maze;

	public Board(Loader l) {
		super();
		this.board = l.maze_board;
		this.route = new Route(l.maxCell, l.maze_board, l.currentCol, l.currentRow, l.finalRow, l.finalCol);
		this.pawn = new Pawn(route);
		this.maze = new Maze();
		route.finalPath.add(l.currentRow);
		route.finalPath.add(l.currentCol);
	}

	public void automatic() {
		Move[] auxOptions = new Move[4];
		while (!maze.isSolvedBy(pawn)) {
			auxOptions = maze.getOptions(pawn);
			System.out.println("automaqtic: " + auxOptions[0]);
			maze.move(pawn, auxOptions[0]);
			System.out.println("-------------//---------------------");
		}
	}
}
