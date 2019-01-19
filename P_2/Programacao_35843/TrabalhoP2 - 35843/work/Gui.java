package work;

import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

	public Gui() {
		setTitle("MAZE ATTACK");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new GridLayout(4,0));
		Label menuLabel = new Label("MENU", Label.CENTER);
		JButton buttonIA = new JButton("IA");
		JButton button1P = new JButton("UM JOGADOR");
		JButton buttonLeave = new JButton("SAIR");
		
		buttonIA.addActionListener(new ButtonListener(false, true, false, this));
		button1P.addActionListener(new ButtonListener(true, false, false, this));
		buttonLeave.addActionListener(new ButtonListener(false, false, true, this));
		
		menu.add(menuLabel);
		menu.add(buttonIA);
		menu.add(button1P);
		menu.add(buttonLeave);
		
		panel.add(menu, BorderLayout.CENTER);
		this.add(panel);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Gui gui = new Gui();
				gui.setVisible(true);
			}
		});
	}
}
