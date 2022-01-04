import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginForm extends JFrame implements ActionListener {
    JTextField textFieldEmail;

    public loginForm() {
        loginForm.Frame frame = new loginForm.Frame();
        frame.loginFrame();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Queries query = new Queries();


        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(10, 175, 80, 25);
        jPanel.add(emailLabel);

        JTextField textFieldEmail = new JTextField(20);
        textFieldEmail.setBounds(100, 175, 200, 25);
        jPanel.add(textFieldEmail);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 210, 80, 25);
        jPanel.add(passwordLabel);

        JTextField textFieldPassword = new JTextField(20);
        textFieldPassword.setBounds(100, 210, 200, 25);
        jPanel.add(textFieldPassword);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(100, 250, 100, 30);


        JButton registerButton = new JButton("Register");
        registerButton.setBounds(200,250,100,30);
        jPanel.add(registerButton);

       frame.jFrame.add(jPanel);

       loginButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
                   if(query.loginQuery(textFieldEmail.getText(),textFieldPassword.getText())) {
                       frame.jFrame.setVisible(false);
                       ActivityForm activityForm = new ActivityForm();
                       activityForm.setVisible(true);
                   }else {
                       JOptionPane.showMessageDialog(frame, "User Not Found",
                               "ERROR", JOptionPane.ERROR_MESSAGE);
                   }
               }catch(Exception exception){
                   exception.printStackTrace();
               }
           }
       });
       jPanel.add(loginButton);

       registerButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
                   frame.jFrame.setVisible(false);
                   RegisterForm registerForm = new RegisterForm();
                   registerForm.SignUpPage();


               }catch (Exception exception){
                   exception.printStackTrace();
               }
           }
       });

    }


    public static class Frame extends Component {
        JFrame jFrame ;
        public void loginFrame(){

            jFrame = new JFrame();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jFrame.setLocation((dim.width/2 -jFrame.getSize().width/2), dim.height/4-jFrame.getSize().height/2);

            jFrame.setSize(400 , 500);
            jFrame.setTitle("Motify Login");

            jFrame.setResizable(true);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
