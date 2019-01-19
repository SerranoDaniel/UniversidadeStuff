package work;

import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

public class Paint extends JFrame {

	Loader l = new Loader(10);
	MazeCell[][] board = l.getMaze_board();

	Route route;
	Pawn pawn;
	Maze maze;

	public Paint() {
		setTitle("MAZE ATTACK");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		this.board = l.maze_board;
		this.route = new Route(l.maxCell, l.maze_board, l.currentCol, l.currentRow, l.finalRow, l.finalCol);
		this.pawn = new Pawn(route);
		this.maze = new Maze();
		route.finalPath.add(l.currentRow);
		route.finalPath.add(l.currentCol);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.translate(60, 70);

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				Color color;
				switch (board[row][col]) {
				case EMPTY:
					color = Color.WHITE;
					break;
				case START:
					color = Color.BLUE;
					break;
				case EXIT:
					color = Color.RED;
					break;
				default:
					color = Color.BLACK;
				}

				g.setColor(color);
				g.fillRect(30 * col, 30 * row, 30, 30);
				g.setColor(Color.WHITE);
				g.drawRect(30 * col, 30 * row, 30, 30);
			}
		}

		Move[] auxOptions = new Move[4];
		while (!maze.isSolvedBy(pawn)) {
			auxOptions = maze.getOptions(pawn);
			System.out.println("automaqtic: " + auxOptions[0]);
			maze.move(pawn, auxOptions[0]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int rowt = 0; rowt < route.finalPath.size(); rowt = rowt + 2) {
				g.setColor(Color.ORANGE);
				g.fillRect(30 * route.finalPath.get(rowt + 1), 30 * route.finalPath.get(rowt), 30, 30);
				g.setColor(Color.WHITE);
				g.drawRect(30 * route.finalPath.get(rowt + 1), 30 * route.finalPath.get(rowt), 30, 30);
			}

			for (int rowt = 0; rowt < route.lastPath.size(); rowt = rowt + 2) {
				g.setColor(Color.WHITE);
				g.fillRect(30 * route.lastPath.get(rowt + 1), 30 * route.lastPath.get(rowt), 30, 30);
				g.setColor(Color.WHITE);
				g.drawRect(30 * route.lastPath.get(rowt + 1), 30 * route.lastPath.get(rowt), 30, 30);
			}
		}

	}
}
