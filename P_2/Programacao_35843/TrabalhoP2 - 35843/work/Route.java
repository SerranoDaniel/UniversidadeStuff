package work;

import java.util.ArrayList;

public class Route implements IRoute {

	int maxCell;
	int currentCol;
	int currentRow;
	int size = 0;
	int finalRow;
	int finalCol;

	MazeCell[][] maze_board;
	Move currentMove = Move.NOOP;

	ArrayList<Integer> finalPath = new ArrayList<>();
	ArrayList<Integer> lastPath = new ArrayList<>();

	public Route(int maxCell, MazeCell[][] maze_board, int currentCol, int currentRow, int finalRow, int finalCol) {
		super();
		this.maxCell = maxCell;
		this.maze_board = maze_board;
		this.currentCol = currentCol;
		this.currentRow = currentRow;
		this.finalRow = finalRow;
		this.finalCol = finalCol;
	}

	public int getFinalRow() {
		return finalRow;
	}

	public int getFinalCol() {
		return finalCol;
	}

	@Override
	public int getCol() {
		return currentCol;
	}

	public Move getMove() {
		return currentMove;
	}

	@Override
	public int getRow() {
		return currentRow;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	// Acabar
	@Override
	public int getCol(int i) {
		return 0;
	}

	@Override
	public int getRow(int i) {
		return 0;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public void move(Move move) {
		size++;
		this.currentMove = move;

		if (move == Move.EAST) {
			currentCol++;
		}

		else if (move == Move.NORT) {
			currentRow--;
		}

		else if (move == Move.WEST) {
			currentCol--;
		}

		else if (move == Move.SOUTH) {
			currentRow++;
		}

		System.out.println("MOVE " + currentRow + "   " + currentCol);

		finalPath.add(currentRow);
		finalPath.add(currentCol);
	}


	public boolean checkMoveOneP(Move move) {

		int nextCol = currentCol;
		int nextRow = currentRow;

		// System.out.println("Ponto atual " + nextRow + " " + nextCol);

		if (move == Move.EAST) {
			nextCol++;
		}

		else if (move == Move.NORT) {
			nextRow--;
		}

		else if (move == Move.WEST) {
			nextCol--;
		}

		else if (move == Move.SOUTH) {
			nextRow++;
		}

		if (move == Move.NOOP) {
			return false;
		}

		if (nextCol == maxCell || nextRow == maxCell || nextCol == -1 || nextRow == -1) {
			return false;
		}

		else if (MazeCell.WALL == maze_board[nextRow][nextCol]) {
			return false;
		}

		else if (finalPath.size() > 2) {
			if (nextRow == finalPath.get(finalPath.size() - 4) && nextCol == finalPath.get(finalPath.size() - 3)) {
				backTracking();
				return false;
			}
		}

		return true;
	}

	public boolean checkMove(Move move) {

		int nextCol = currentCol;
		int nextRow = currentRow;

		// System.out.println("Ponto atual " + nextRow + " " + nextCol);

		if (move == Move.EAST) {
			nextCol++;
		}

		else if (move == Move.NORT) {
			nextRow--;
		}

		else if (move == Move.WEST) {
			nextCol--;
		}

		else if (move == Move.SOUTH) {
			nextRow++;
		}

		if (move == Move.NOOP) {
			return false;
		}

		if (nextCol == maxCell || nextRow == maxCell || nextCol == -1 || nextRow == -1) {
			return false;
		}

		else if (MazeCell.WALL == maze_board[nextRow][nextCol]) {
			return false;
		}

		else if (finalPath.size() > 2) {
			if (nextRow == finalPath.get(finalPath.size() - 4) && nextCol == finalPath.get(finalPath.size() - 3)) {
				return false;
			}
		}

		for (int p = 0; p < finalPath.size(); p = p + 2) {
			if (finalPath.get(p) == nextRow && finalPath.get(p + 1) == nextCol) {
				return false;
			}
		}

		for (int i = 0; i < lastPath.size(); i = i + 2) {

			if (lastPath.get(i) == nextRow && lastPath.get(i + 1) == nextCol) {
				return false;
			}
		}
		return true;
	}
	
	public void backTracking() {

		lastPath.add(finalPath.get(finalPath.size() - 2));
		lastPath.add(finalPath.get(finalPath.size() - 1));

		finalPath.remove(finalPath.size() - 1);
		finalPath.remove(finalPath.size() - 1);

		currentRow = finalPath.get(finalPath.size() - 2);
		currentCol = finalPath.get(finalPath.size() - 1);

		System.out.println("BACK " + currentRow + "   " + currentCol);
	}
}
