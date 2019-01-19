package work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class ButtonMenuListeners implements ActionListener{

	boolean menuIA;
	boolean menu1P;
	boolean load;
	boolean previous;
	JFrame f;

	public ButtonMenuListeners(boolean menuIA, boolean menu1p, boolean load, boolean previous, JFrame f) {
		super();
		this.f = f;
		this.menuIA = menuIA;
		menu1P = menu1p;
		this.load = load;
		this.previous = previous;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (menuIA == true && load == true && menu1P == false) {
			new Paint();
		}

		else if (menuIA == true && load == false && menu1P == false) {

		}

		else if (menuIA == false && load == true && menu1P == true) {
			new PlayerMotion();
		}

		else if (menuIA == false && load == false && menu1P == true) {

		}

		else if (previous == true) {
			f.dispose();
			JFrame frame = new JFrame();
			frame.setTitle("MAZE ATTACK");
			frame.setSize(300, 300);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			JPanel panel = new JPanel(new BorderLayout());
			JPanel menu = new JPanel(new GridLayout(4, 0));
			Label menuLabel = new Label("MENU", Label.CENTER);
			JButton buttonIA = new JButton("IA");
			JButton button1P = new JButton("UM JOGADOR");
			JButton buttonLeave = new JButton("SAIR");

			buttonIA.addActionListener(new ButtonListener(false, true, false, frame));
			button1P.addActionListener(new ButtonListener(true, false, false, frame));
			buttonLeave.addActionListener(new ButtonListener(false, false, true, frame));

			menu.add(menuLabel);
			menu.add(buttonIA);
			menu.add(button1P);
			menu.add(buttonLeave);

			panel.add(menu, BorderLayout.CENTER);
			frame.add(panel);
		}
	}

	
}
