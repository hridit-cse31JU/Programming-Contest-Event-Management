package NCPC_Project;

import javax.swing.*;
import java.awt.*;

public class NCPC extends JFrame {
    private Container container;
    private ImageIcon ic;
    private JLabel welcomeLabel, loginLabel, passwordLabel, errorMessageLabel;
    private JTextField loginField;
    private JButton loginButton, signupButton, forgotPasswordButton;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox, rememberMeCheckBox;
    private JDialog loadingDialog;

    public NCPC() {
        try {
            ic = new ImageIcon("C:/Users/Oywon/Downloads/NCPCP.png");
            setIconImage(ic.getImage());
        } catch (Exception e) {
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
        container.setLayout(new GridBagLayout());
        container.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        Font titleFont = new Font("Sans Serif", Font.BOLD, 28); // Changed font to Sans Serif
        Font labelFont = new Font("Arial", Font.BOLD, 18);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Welcome Panel
        JPanel welcomePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Create a gradient background
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, 0, getHeight(), Color.CYAN);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS)); // Center the content
        welcomeLabel = new JLabel("Welcome to NCPC 2K24", JLabel.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(titleFont);
        welcomePanel.add(welcomeLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        container.add(welcomePanel, gbc); // Add welcome panel to the main container

        loginLabel = new JLabel("Email:");
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        container.add(loginLabel, gbc);

        loginField = new JTextField(20);
        loginField.setFont(labelFont);
        loginField.setToolTipText("Enter your email address");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(loginField, gbc);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        container.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(labelFont);
        passwordField.setToolTipText("Enter your password");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(passwordField, gbc);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(labelFont);
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(showPasswordCheckBox, gbc);

        rememberMeCheckBox = new JCheckBox("Remember Me");
        rememberMeCheckBox.setFont(labelFont);
        rememberMeCheckBox.setBackground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(rememberMeCheckBox, gbc);

        loginButton = new JButton("Login");
        loginButton.setFont(labelFont);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setToolTipText("Click to login");
        loginButton.addActionListener(e -> attemptLogin());
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        container.add(loginButton, gbc);

        signupButton = new JButton("Signup");
        signupButton.setFont(labelFont);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        signupButton.setToolTipText("Click to create a new account");
        signupButton.addActionListener(e -> {
            this.dispose();
            SignupPage signupPage = new SignupPage();
            signupPage.setVisible(true);
        });
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(signupButton, gbc);

        forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.setFont(labelFont);
        forgotPasswordButton.setBackground(Color.BLACK);
        forgotPasswordButton.setForeground(Color.WHITE);
        forgotPasswordButton.setToolTipText("Click to reset your password");
        forgotPasswordButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Password reset link sent to your email."));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(forgotPasswordButton, gbc);

        errorMessageLabel = new JLabel("", JLabel.CENTER);
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        container.add(errorMessageLabel, gbc);

        // Loading Spinner
        loadingDialog = new JDialog(this, "Logging in", true);
        loadingDialog.setSize(100, 100);
        loadingDialog.setLocationRelativeTo(this);
        loadingDialog.add(new JLabel("Loading...", JLabel.CENTER), BorderLayout.CENTER);
        loadingDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    private void attemptLogin() {
        String email = loginField.getText();
        String password = new String(passwordField.getPassword());
        if (email.isEmpty() || password.isEmpty()) {
            errorMessageLabel.setText("Please fill in all fields.");
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            errorMessageLabel.setText("Invalid email format.");
        } else {
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    loadingDialog.setVisible(true); // Show loading spinner
                    Thread.sleep(2000); // Simulate login process
                    return null;
                }

                @Override
                protected void done() {
                    loadingDialog.setVisible(false); // Hide loading spinner
                    // Here you can add actual authentication logic
                    if (email.equals("admin@example.com") && password.equals("admin")) {
                        errorMessageLabel.setText("Login successful!");
                        // Navigate to the next page or main application
                    } else {
                        errorMessageLabel.setText("Invalid email or password.");
                    }
                }
            };
            worker.execute();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NCPC loginPage = new NCPC();
            loginPage.setVisible(true);
        });
    }
}
