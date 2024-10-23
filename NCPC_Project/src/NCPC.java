

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class NCPC extends JFrame {
    private Container container;
    private ImageIcon ic;
    private JLabel welcomeLabel, loginLabel, passwordLabel;
    private JTextField loginField;
    private JButton loginButton, signupButton;
    private JPasswordField passwordField;

    public NCPC() {
        try
        {
            File input = new File("C:/Users/Oywon/Downloads/NCPCP.png");
            ic= new ImageIcon(input.getAbsolutePath());
            setIconImage(ic.getImage());
        }catch(Exception e)
        {
            System.out.println(" error is in "+e.getMessage());
        }
        setTitle("NCPC 2K24");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        initializeComponents();
    }

    private void initializeComponents() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.white);

        Font titleFont = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.BOLD, 18);

        welcomeLabel = new JLabel("Welcome to NCPC 2K24", JLabel.CENTER);
        welcomeLabel.setBounds(50, 20, 400, 50);
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(titleFont);

        loginLabel = new JLabel("Email        :");
        loginLabel.setBounds(50, 100, 100, 30);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(labelFont);

        loginField = new JTextField();
        loginField.setBounds(160, 100, 250, 30);
        loginField.setFont(labelFont);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(labelFont);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 150, 250, 30);
        passwordField.setFont(labelFont);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 220, 150, 40);
        loginButton.setFont(labelFont);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);

        signupButton = new JButton("Signup");
        signupButton.setBounds(260, 220, 150, 40);
        signupButton.setFont(labelFont);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);

        signupButton.addActionListener(e -> {
            this.dispose(); // Close the current login frame
            SignupPage signupPage = new SignupPage();
            signupPage.setVisible(true);
        });


        container.add(welcomeLabel);
        container.add(loginLabel);
        container.add(loginField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
        container.add(signupButton);
    }

    public static void main(String[] args) {
        NCPC frame = new NCPC();
        frame.setVisible(true);
    }
}
