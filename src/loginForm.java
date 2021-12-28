import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginForm extends JFrame implements ActionListener {
    JButton button;
    JPanel panel;
    JLabel mailLabel,passwordLabel;
    final JTextField textField1 , textField2;

   loginForm(){
       mailLabel = new JLabel();
       mailLabel.setText("E-Mail");

       textField1 =new JTextField(20);
       passwordLabel = new JLabel();
       passwordLabel.setText("Password");

       textField2 = new JPasswordField(20);
       button = new JButton("LOGIN");

       panel = new JPanel(new GridLayout(3, 1));
       panel.add(mailLabel);
       panel.add(textField1);
       panel.add(passwordLabel);
       panel.add(textField2);
       panel.add(button);
       add(panel, BorderLayout.CENTER);


       button.addActionListener(this);
       setTitle("LOGIN FORM");
   }



    @Override
    public void actionPerformed(ActionEvent e) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();

    }
}
