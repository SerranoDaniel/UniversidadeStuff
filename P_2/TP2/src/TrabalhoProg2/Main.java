package TrabalhoProg2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Maze maze = new Maze();
        Route route = new Route();
        Pawn pawn = new Pawn();

        JFrame jf = new JFrame();
        Container contentPane = jf.getContentPane();
        JButton jb2 = new JButton("<Click to continue>");
        Font fonte1 = new Font("Arial", Font.ITALIC, 20);
        ImageIcon image = new ImageIcon("C:\\Users\\User\\IdeaProjects\\TP2\\src\\TrabalhoProg2\\maze.jpg");
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


        ///IF CLICKED
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                JFrame jf1 = new JFrame();
                Container contentPane1 = jf1.getContentPane();

                ImageIcon image2 = new ImageIcon("C:\\Users\\User\\Desktop\\exit.png");
                JButton jb3 = new JButton(image2);
                ImageIcon image1 = new ImageIcon("C:\\Users\\User\\Desktop\\play.png");
                JButton jb1 = new JButton(image1);

                jf1.setVisible(true);
                jf1.setTitle("Maze Game Menu");
                jf1.setSize(1024, 768);
                jf1.setLocationRelativeTo(null);
                jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                contentPane1.setBackground(Color.CYAN);
                contentPane1.setLayout(null);


                jb1.setBounds(128, 256, 256, 256);
                jb3.setBounds(640, 256, 256, 256);

                contentPane1.add(jb1);
                contentPane1.add(jb3);


                //IF PLAY CLICKED
                jb1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jf1.setVisible(false);
                        JFrame jf3 = new JFrame();
                        Container contentPane3 = jf3.getContentPane();

                        JButton jb7 = new JButton("Load Map");
                        Font fonte3 = new Font("Bauhaus 93", Font.PLAIN, 100);
                        JButton jb8 = new JButton("<html>Generate<br />Map</html>");

                        jf3.setVisible(true);
                        jf3.setTitle("Maze Game Menu");
                        jf3.setSize(1024, 768);
                        jf3.setLocationRelativeTo(null);
                        jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        contentPane3.setBackground(Color.CYAN);
                        contentPane3.setLayout(new GridLayout(1, 1));

                        jb7.setFont(fonte3);
                        jb8.setFont(fonte3);

                        contentPane3.add(jb7);
                        contentPane3.add(jb8);

                        jb7.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                jf3.setVisible(false);
                                JFrame jf2 = new JFrame();
                                Container contentPane2 = jf2.getContentPane();

                                Font fonte2 = new Font("Bauhaus 93", Font.PLAIN, 100);
                                JButton jb4 = new JButton("<html>You<br />Play</html>");
                                JButton jb5 = new JButton("<html>Auto<br />Play</html>");
                                JButton jb6 = new JButton(image2);

                                jf2.setVisible(true);
                                jf2.setTitle("Maze Game Menu");
                                jf2.setSize(1024, 768);
                                jf2.setLocationRelativeTo(null);
                                jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                contentPane2.setBackground(Color.CYAN);
                                contentPane2.setLayout(new GridLayout(1,3));

                                jb4.setFont(fonte2);
                                jb5.setFont(fonte2);

                                contentPane2.add(jb4);
                                contentPane2.add(jb6);
                                contentPane2.add(jb5);

                                ///IF YOUPLAY CLICKED
                                jb4.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        try {
                                            maze.ReadFile();
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                                        ArrayList<ArrayList<String>> tabMain = maze.getMaze();
                                        int collen = maze.getCollen();
                                        int rowlen = maze.getRowlen();
                                        maze.youPlay();
                                        jf2.setVisible(false);
                                        //START PLAYING
                                        route.startPos(tabMain, rowlen, collen);
                                        route.endPos(tabMain, rowlen, collen);
                                        pawn.setPawn(route.getX(),route.getY());
                                        pawn.setEnd(route.getXend(), route.getYend());
                                        while(maze.isSolvedBy(pawn)==false){
                                            JOptionPane.showMessageDialog(null,  maze.getOptions());
                                            String movePlay = maze.playMove();
                                            if(maze.canMove(pawn, movePlay)==true){
                                                maze.movePawnMaze(pawn, movePlay);
                                                maze.youPlay();
                                                maze.setMaze("R", pawn, movePlay);

                                            }
                                            else if(maze.canMove(pawn, movePlay)==false){
                                                JOptionPane.showMessageDialog(null, "Invalid Move, please try again");
                                            }

                                        }
                                        JOptionPane.showMessageDialog(null, "CONGRATULATIONS YOU WON!");
                                        jf3.setVisible(true);

                                    }

                                });

                                //IFF EXIT CLICKED
                                jb6.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        System.exit(0);
                                    }
                                });

                                //IFF AUTOPLAY CLICKED
                                jb5.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        JOptionPane.showMessageDialog(null, "Coming Soon");
                                        jf2.setVisible(true );
                                    }
                                });

                            }
                        });

                        jb8.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "Coming Soon");
                                jf3.setVisible(true);
                            }
                        });
                    }

                });
                jb3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jf1.setVisible(false);
                        System.exit(0);

                    }
                });
            }
        });
    }
}


