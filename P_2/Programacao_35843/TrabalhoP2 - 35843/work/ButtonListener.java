package work;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;

import javax.swing.*;

public class ButtonListener implements ActionListener {

	boolean onePlayer;
	boolean IA;
	boolean leave;
	JFrame frame;

	public ButtonListener(boolean onePlayer, boolean iA, boolean leave, JFrame frame) {
		super();
		this.onePlayer = onePlayer;
		IA = iA;
		this.leave = leave;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (onePlayer == true && IA == false && leave == false) {
			frame.dispose();
			JFrame frame1P = new JFrame("MAZE ATTACK");
			frame1P.setSize(300, 300);
			frame1P.setLocationRelativeTo(null);
			frame1P.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1P.setVisible(true);

			JPanel panel = new JPanel(new BorderLayout());
			JPanel menu = new JPanel(new GridLayout(4, 0));
			Label menuLabel = new Label("MENU UM JOGADOR", Label.CENTER);
			JButton generate = new JButton("GERAR TABULEIRO");
			JButton load = new JButton("LOAD TABULEIRO");
			JButton previous = new JButton("VOLTAR ATRÁS");

			generate.addActionListener(new ButtonMenuListeners(false, true, false, false, frame1P));
			load.addActionListener(new ButtonMenuListeners(false, true, true, false, frame1P));
			previous.addActionListener(new ButtonMenuListeners(false, true, false, true, frame1P));

			menu.add(menuLabel);
			menu.add(generate);
			menu.add(load);
			menu.add(previous);

			panel.add(menu, BorderLayout.CENTER);
			frame1P.add(panel);

		} else if (onePlayer == false && IA == true && leave == false) {
			frame.dispose();
			JFrame frameIA = new JFrame("MAZE ATACK");
			frameIA.setSize(300, 300);
			frameIA.setLocationRelativeTo(null);
			frameIA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameIA.setVisible(true);

			JPanel panel = new JPanel(new BorderLayout());
			JPanel menu = new JPanel(new GridLayout(4, 0));
			Label menuLabel = new Label("MENU IA", Label.CENTER);
			JButton generate = new JButton("GERAR TABULEIRO");
			JButton load = new JButton("LOAD TABULEIRO");
			JButton previous = new JButton("VOLTAR ATRÁS");

			generate.addActionListener(new ButtonMenuListeners(true, false, false, false, frameIA));
			load.addActionListener(new ButtonMenuListeners(true, false, true, false, frameIA));
			previous.addActionListener(new ButtonMenuListeners(false, false, false, true, frameIA));

			menu.add(menuLabel);
			menu.add(generate);
			menu.add(load);
			menu.add(previous);

			panel.add(menu, BorderLayout.CENTER);
			frameIA.add(panel);

		} else if (onePlayer == false && IA == false && leave == true) {
			System.exit(0);
		}
	}

}
