import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("UserID: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();
    HashMap<String,String> logininfo = new HashMap<>();
    LoginPage(HashMap<String,String> loginInfoOrginal){
        logininfo = loginInfoOrginal;//copy of hashmap

        userIdLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(125,100,200,25);
        passwordField.setBounds(125,150,200,25);

        loginBtn.setBounds(125,200,100,25);
        loginBtn.setFocusable(false);
        loginBtn.addActionListener(this);

        resetBtn.setBounds(225,200,100,25);
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(this);

        frame.add(userIdLabel);
        frame.add(passwordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(passwordField);
        frame.add(loginBtn);
        frame.add(resetBtn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetBtn){
            userIdField.setText("");
            passwordField.setText("");
        }
        if(e.getSource()==loginBtn){
            String userId = userIdField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if(logininfo.containsKey(userId)){
                if(logininfo.get(userId).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful!!");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userId);
                }else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Login Failed!!");
                }
            }else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User not found!!");
            }
        }
    }
}
