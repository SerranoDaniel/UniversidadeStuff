import javax.swing.*;

public class LoginPrompt {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                String username = JOptionPane.showInputDialog(null, "Introduza temperatura em Far a converter para Celsius:");
                System.out.println("Username: " + username);

                JPasswordField passwordField = new JPasswordField(8);
                // a bit quirky, we need to tab to the field
                JOptionPane.showMessageDialog(null, passwordField, "Password",
                        JOptionPane.QUESTION_MESSAGE);
                char[] password = null;
                password = passwordField.getPassword();
                System.out.println("Password: " + String.valueOf(password));
            }
        });
    }
}