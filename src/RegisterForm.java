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
        String sqlEmail = textFieldEmail.getText();
        jPanel.add(textFieldEmail);


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
                    String email = textFieldEmail.getText();
                    String password = textFieldPassword.getText();

                    if (textFieldEmail.getText().equals("") || textFieldPassword.getText().equals("")){
                        System.out.println("error");
                    }else
                        sqlQuery.insert(email , password);


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

                }catch (Exception ex ){
                    ex.printStackTrace();                   //Catch the appropirate Exception
                    //ATTENTION
                }
                //System.out.println("Hello new Customer ");
            }
        });
        jPanel.add(loginButton);
    }

    public static class Frame {
        JFrame jFrame ;
        public void signUpFrame(){

            jFrame = new JFrame();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jFrame.setLocation((dim.width/2 -jFrame.getSize().width/2), dim.height/4-jFrame.getSize().height/2);

            jFrame.setSize(350 , 500);
            jFrame.setTitle("Motify Register");

            jFrame.setResizable(true);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        }
    }
}
