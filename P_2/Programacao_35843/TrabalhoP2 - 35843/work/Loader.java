package work;

import java.io.*;
import java.util.*;

public class Loader {

	MazeCell[][] maze_board;
	int maxCell;
	int currentCol;
	int currentRow;
	int finalRow;
	int finalCol;

	public Loader(int n) {
		File file = new File("C:\\Users\\nuno-\\Documents\\P2\\Maze_Board.txt");

		this.maze_board = new MazeCell[n][n];
		this.maxCell = n;

		Scanner scanner;

		try {
			scanner = new Scanner(file);
			int count = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.length() == n) {

					for (int i = 0; i < n; i++) {

						char readLine = line.charAt(i);
	//					System.out.println(readLine + " " + count + " " + i);

						if (readLine == '_') {
							maze_board[count][i] = MazeCell.EMPTY;
						}

						else if (readLine == 'S') {
							maze_board[count][i] = MazeCell.START;
							this.currentRow = count;
							this.currentCol = i;
						}

						else if (readLine == 'W') {
							maze_board[count][i] = MazeCell.WALL;
						}

						else if (readLine == 'E') {
							maze_board[count][i] = MazeCell.EXIT;
							this.finalRow = count;
							this.finalCol = i;
						}

						else {
							System.err.println("WRONG CHARACTER IN LINE " + count + " ON ROW " + i);
							System.exit(-1);
						}
					}
					count++;
				}

				else {
					System.err.println("INSUFICIENT/EXCESS NUMBER OF CHARS IN LINE " + count);
					System.exit(-1);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("START POINT " + currentRow + " " + currentCol + " FINAL POINT " + finalRow + " " + finalCol );
	}

	public MazeCell[][] getMaze_board() {
		return maze_board;
	}

}
