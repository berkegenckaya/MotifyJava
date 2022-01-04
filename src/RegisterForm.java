import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {
    JTextField textFieldPassword ;
    public void SignUpPage () {
        Frame frame = new Frame();
        frame.signUpFrame();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Queries sqlQuery = new Queries();

        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(10, 175, 80, 25);
        jPanel.add(emailLabel);

        JTextField textFieldEmail = new JTextField(20);
        textFieldEmail.setBounds(100, 175, 200, 25);
        jPanel.add(textFieldEmail);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10,135,80,25);
        jPanel.add(usernameLabel);

        JTextField textFieldUsername = new JTextField(20);
        textFieldUsername.setBounds(100,135,200,25);
        jPanel.add(textFieldUsername);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 210, 80, 25);
        jPanel.add(passwordLabel);


        textFieldPassword = new JTextField(20);
        textFieldPassword.setBounds(100, 210, 200, 25);
        jPanel.add(textFieldPassword);

        JLabel againLabel = new JLabel("Password (Again)");
        againLabel.setBounds(10, 245, 80, 25);
        jPanel.add(againLabel);

        JTextField againPassword = new JTextField(20);
        againPassword.setBounds(100, 245, 200, 25);
        jPanel.add(againPassword);

        jPanel.setBackground(Color.white);
        frame.jFrame.add(jPanel);


        JButton signUpButton = new JButton("Sign-Up");
        signUpButton.setBounds(100, 425, 100, 30);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username =textFieldUsername.getText();
                    String email = textFieldEmail.getText();
                    String password = textFieldPassword.getText();

                    if (textFieldEmail.getText().equals("") || textFieldPassword.getText().equals("")||
                            textFieldUsername.getText().equals("") || againPassword.getText().equals(" ")){
                        JOptionPane.showMessageDialog(frame, "Please enter valid info.!!!",
                                "ERROR", JOptionPane.ERROR_MESSAGE);

                    }else
                        sqlQuery.insert(username,email , password);
                    if (!textFieldPassword.getText().equals(againLabel.getText())){
                        JOptionPane.showMessageDialog(frame, "Passwords doesnt match!",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }


                }catch (Exception ex ){
                    ex.printStackTrace();
                }

            }
        });
        jPanel.add(signUpButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200 , 425 , 100 , 30 );


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.jFrame.setVisible(false);
                    loginForm loginForm = new loginForm();
                    loginForm.setVisible(true);

                }catch (Exception ex ){
                    ex.printStackTrace();                   //Catch the appropirate Exception
                    //ATTENTION
                }
                //System.out.println("Hello new Customer ");
            }
        });
        jPanel.add(loginButton);
    }

    public static class Frame extends Component {
        JFrame jFrame ;
        public void signUpFrame(){

            jFrame = new JFrame();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jFrame.setLocation((dim.width/2 -jFrame.getSize().width/2), dim.height/4-jFrame.getSize().height/2);

            jFrame.setSize(400 , 500);
            jFrame.setTitle("Motify Register");

            jFrame.setResizable(true);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        }
    }
}
