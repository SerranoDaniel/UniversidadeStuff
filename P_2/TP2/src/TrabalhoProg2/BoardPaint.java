package TrabalhoProg2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPaint extends JFrame{
    private ArrayList<ArrayList<String>> tabuleiroPaint = new ArrayList<ArrayList<String>>();
    public BoardPaint(ArrayList<ArrayList<String>> tabPaint, int rowlen, int collen){
        this.tabuleiroPaint = tabPaint;
        setTitle("Maze");
        setSize(55 * collen, 72 * rowlen);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    public void paint(Graphics g){
        super.paint(g);
        ImageIcon img = new ImageIcon("C:\\Users\\User\\Desktop\\play.png");
        Image start = img.getImage();


        g.translate(30,45);

        for (int row = 0; row < this.tabuleiroPaint.size(); row++){
            for (int col = 0; col < this.tabuleiroPaint.get(0).size(); col++){
                Color color;
                switch (this.tabuleiroPaint.get(row).get(col)){
                    case "S" : color = Color.GREEN; break;
                    case "R" : color = Color.BLUE; break;
                    case "E" : color = Color.RED; break;
                    case "W" : color = Color.BLACK; break;
                    case "_" : color = Color.WHITE; break;
                    default : color = Color.WHITE; break;
                }
                g.setColor(color);
                g.fillRect(50 * col, 50 * row, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(50 * col, 50 * row, 50, 50);
            }
        }


    }

    public static void x(ArrayList<ArrayList<String>> tabuleiroMenu, int row, int col){
        SwingUtilities.invokeLater(new Runnable() {

            ArrayList<ArrayList<String>> tab = tabuleiroMenu;
            public void run() {
                BoardPaint board = new BoardPaint(tab, row, col);
                board.setVisible(true);
            }
        } );
    }
}
