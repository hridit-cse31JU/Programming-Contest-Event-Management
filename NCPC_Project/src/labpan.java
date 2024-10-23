package NCPC_Project;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NCPC extends JFrame {
    private Container container;
    private ImageIcon ic;
    private JLabel welcomeLabel, loginLabel, passwordLabel;
    private JTextField loginField;
    private JButton loginButton, signupButton;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox, rememberMeCheckBox;
    private JLabel errorMessageLabel;
    private Image backgroundImage;

    public NCPC() {
        try {
            File input = new File("C:/Users/Oywon/Downloads/NCPCP.png");
            ic = new ImageIcon(input.getAbsolutePath());
            setIconImage(ic.getImage());

            backgroundImage = ImageIO.read(new File("D:/Oywon_370/image.jpeg"));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
        container.setLayout(new BorderLayout());

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());
        container.add(backgroundPanel, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        Font titleFont = new Font("Arial", Font.BOLD, 24);
        Font labelFont = new Font("Arial", Font.BOLD, 18);

        welcomeLabel = new JLabel("Welcome to NCPC 2K24", JLabel.CENTER);
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setFont(titleFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        backgroundPanel.add(welcomeLabel, gbc);

        loginLabel = new JLabel("Email:");
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        backgroundPanel.add(loginLabel, gbc);

        loginField = new JTextField(20);
        loginField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(loginField, gbc);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        backgroundPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(passwordField, gbc);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(labelFont);
        showPasswordCheckBox.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(showPasswordCheckBox, gbc);

        rememberMeCheckBox = new JCheckBox("Remember Me");
        rememberMeCheckBox.setFont(labelFont);
        rememberMeCheckBox.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(rememberMeCheckBox, gbc);

        loginButton = new JButton("Login");
        loginButton.setFont(labelFont);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        backgroundPanel.add(loginButton, gbc);

        signupButton = new JButton("Signup");
        signupButton.setFont(labelFont);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(signupButton, gbc);

        errorMessageLabel = new JLabel("", JLabel.CENTER);
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        backgroundPanel.add(errorMessageLabel, gbc);

        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        signupButton.addActionListener(e -> {
            this.dispose();
            SignupPage signupPage = new SignupPage();
            signupPage.setVisible(true);
        });

        loginButton.addActionListener(e -> {
            String email = loginField.getText();
            String password = new String(passwordField.getPassword());
            if (email.isEmpty() || password.isEmpty()) {
                errorMessageLabel.setText("Please fill in all fields.");
            } else {
                // Here you can add actual authentication logic
                if (email.equals("admin@example.com") && password.equals("admin")) {
                    errorMessageLabel.setText("Login successful!");
                    // Navigate to the next page or main application
                } else {
                    errorMessageLabel.setText("Invalid email or password.");
                }
            }
        });
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        NCPC frame = new NCPC();
        frame.setVisible(true);
    }
}
