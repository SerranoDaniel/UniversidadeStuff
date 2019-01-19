package TrabalhoProg2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    private ArrayList<ArrayList<String>> tabuleiroMenu = new ArrayList<ArrayList<String>>();
    private int rowBoardLen, colBoardlen;
    public String move;
    public int start, gamemenu, gpmenu;

    public Menu(ArrayList<ArrayList<String>> tabMenu, int rowBoardLen, int colBoardlen){
        this.tabuleiroMenu = tabMenu;
        this.rowBoardLen = rowBoardLen;
        this.colBoardlen = colBoardlen;
        //start();
    }

   // public void actionPerformed(ActionEvent e){
    //    gameMenu();
   // }


    public void start(){
        JFrame jf = new JFrame();
        Container contentPane = jf.getContentPane();
        JButton jb2 = new JButton("<Click to continue>");
        Font fonte1 = new Font("Arial", Font.ITALIC, 20);
        ImageIcon image = new ImageIcon("C:\\Users\\User\\Desktop\\maze.JPG");
        JButton jb = new JButton(image);

        jf.setVisible(true);
        jf.setTitle("Maze Game");
        jf.setSize(1024, 768);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        contentPane.setBackground(Color.BLACK);

        jb2.setFont(fonte1);
        contentPane.add(jb, BorderLayout.CENTER);
        contentPane.add(jb2, BorderLayout.PAGE_END);

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gameMenu();
                jf.setVisible(false);
            }
        });
    }

    public void gameMenu(){
        JFrame jf = new JFrame();
        Container contentPane = jf.getContentPane();

        ImageIcon image2 = new ImageIcon("C:\\Users\\User\\Desktop\\exit.png");
        JButton jb2 = new JButton(image2);
        ImageIcon image = new ImageIcon("C:\\Users\\User\\Desktop\\play.png");
        JButton jb = new JButton(image);

        jf.setVisible(true);
        jf.setTitle("Maze Game Menu");
        jf.setSize(1024, 768);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(null);


        //jb.setFont(fonte);
        //jb2.setFont(fonte1);
        jb.setBounds(128,256,256,256);
        jb2.setBounds(640,256,256,256);

        contentPane.add(jb2);
        contentPane.add(jb);

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gamePlayMenu();
                jf.setVisible(false);
            }
        });

        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public void gamePlayMenu(){
        JFrame jf = new JFrame();
        Container contentPane = jf.getContentPane();

        Font fonte = new Font("Bauhaus 93", Font.PLAIN, 100);
        JButton jb = new JButton("<html>You<br />Play</html>");
        JButton jb2 = new JButton("<html>Auto<br />Play</html>");
        ImageIcon image = new ImageIcon("C:\\Users\\User\\Desktop\\Back.png");
        JButton jb3 = new JButton(image);

        jf.setVisible(true);
        jf.setTitle("Maze Game Menu");
        jf.setSize(1024, 768);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(new GridLayout(1,3));

        jb.setFont(fonte);
        jb2.setFont(fonte);

        contentPane.add(jb);
        contentPane.add(jb3);
        contentPane.add(jb2);

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                youPlay();
                jf.setVisible(true);
                jf.setLocation(0,0);
                jf.setSize(1024,400);
                play();
                }

        });

 /*       jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gamePlayMenu();
                jf.setVisible(false);
            }
        });*/

        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gameMenu();
                jf.setVisible(false);
            }
        });
    }



    public void youPlay(){
        BoardPaint boardMenu = new BoardPaint(tabuleiroMenu, rowBoardLen, colBoardlen);
        boardMenu.x(tabuleiroMenu, rowBoardLen, colBoardlen);
    }


    public String play(){
        String inputstr = JOptionPane.showInputDialog("What's your move?: " );
        return inputstr;
    }

}
