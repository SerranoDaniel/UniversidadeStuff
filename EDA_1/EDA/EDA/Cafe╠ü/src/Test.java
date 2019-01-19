import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Test {
	private JFrame frame;
	private JButton button;
	private boolean t;
	
	public void buildFrame(){
		frame = new JFrame();
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public void buildButton(){
		button = new JButton("Eduardo");
		button.setBounds(50, 50, 50, 50);
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(t){
		    		t = false;
		    		button.setSelected(false);
		    	}else{
		    		t = true;
		    		button.setSelected(true);
		    	}
		    	System.out.println(t);
		    	System.out.println(button.getText());
		    }
		});
		frame.add(button);
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.buildFrame();
		test.buildButton();
	}
}
