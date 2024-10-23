package NCPC_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class User {
    String teamName;
    String member1Name, member1Gmail, member1Phone;
    String member2Name, member2Gmail, member2Phone;
    String member3Name, member3Gmail, member3Phone;
    String coachName, coachGmail, coachPhone;

    User(String teamName, String member1Name, String member1Gmail, String member1Phone,
         String member2Name, String member2Gmail, String member2Phone,
         String member3Name, String member3Gmail, String member3Phone,
         String coachName, String coachGmail, String coachPhone) {
        this.teamName = teamName;
        this.member1Name = member1Name;
        this.member1Gmail = member1Gmail;
        this.member1Phone = member1Phone;
        this.member2Name = member2Name;
        this.member2Gmail = member2Gmail;
        this.member2Phone = member2Phone;
        this.member3Name = member3Name;
        this.member3Gmail = member3Gmail;
        this.member3Phone = member3Phone;
        this.coachName = coachName;
        this.coachGmail = coachGmail;
        this.coachPhone = coachPhone;
    }
}

public class SignupPage extends JFrame {
    private Container container;
    private JPanel panel;
    private JLabel titleLabel, teamNameLabel, member1NameLabel, member1GmailLabel, member1PhoneLabel,
            member2NameLabel, member2GmailLabel, member2PhoneLabel, member3NameLabel, member3GmailLabel, member3PhoneLabel,
            coachNameLabel, coachGmailLabel, coachPhoneLabel, hotlineLabel;
    private JTextField teamNameField, member1NameField, member1GmailField, member1PhoneField,
            member2NameField, member2GmailField, member2PhoneField, member3NameField, member3GmailField, member3PhoneField,
            coachNameField, coachGmailField, coachPhoneField;
    private JButton signupButton, backButton;

    // List to store user data
    private ArrayList<User> users = new ArrayList<>();

    public SignupPage() {
        setTitle("Signup - NCPC 2K24");
        setSize(600, 800); // Increased height to accommodate phone fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initializeComponents();
    }

    private void initializeComponents() {
        container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(230, 230, 250)); // Light lavender background

        // Panel for title
        panel = new JPanel();
        panel.setBackground(new Color(70, 130, 180)); // Steel blue background
        panel.setLayout(new FlowLayout());

        Font titleFont = new Font("Arial", Font.BOLD, 30); // Increased title font size
        titleLabel = new JLabel("Signup for NCPC 2K24");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);
        panel.add(titleLabel);

        // Main panel for form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Labels and text fields
        int yPos = 20;

        Font labelFont = new Font("Arial", Font.BOLD, 18); // Increased label font size
        Font fieldFont = new Font("Arial", Font.PLAIN, 16); // Increased field font size
        Font buttonFont = new Font("Arial", Font.BOLD, 18); // Increased button font size

        teamNameLabel = new JLabel("Team Name:");
        teamNameLabel.setBounds(30, yPos, 150, 30);
        teamNameLabel.setFont(labelFont);
        formPanel.add(teamNameLabel);
        teamNameField = new JTextField();
        teamNameField.setBounds(200, yPos, 300, 30);
        teamNameField.setFont(fieldFont);
        formPanel.add(teamNameField);
        yPos += 40;

        member1NameLabel = new JLabel("Member 1 Name:");
        member1NameLabel.setBounds(30, yPos, 150, 30);
        member1NameLabel.setFont(labelFont);
        formPanel.add(member1NameLabel);
        member1NameField = new JTextField();
        member1NameField.setBounds(200, yPos, 300, 30);
        member1NameField.setFont(fieldFont);
        formPanel.add(member1NameField);
        yPos += 40;

        member1GmailLabel = new JLabel("Gmail:");
        member1GmailLabel.setBounds(30, yPos, 150, 30);
        member1GmailLabel.setFont(labelFont);
        formPanel.add(member1GmailLabel);
        member1GmailField = new JTextField();
        member1GmailField.setBounds(200, yPos, 300, 30);
        member1GmailField.setFont(fieldFont);
        formPanel.add(member1GmailField);
        yPos += 40;

        member1PhoneLabel = new JLabel("Phone:");
        member1PhoneLabel.setBounds(30, yPos, 150, 30);
        member1PhoneLabel.setFont(labelFont);
        formPanel.add(member1PhoneLabel);
        member1PhoneField = new JTextField();
        member1PhoneField.setBounds(200, yPos, 300, 30);
        member1PhoneField.setFont(fieldFont);
        formPanel.add(member1PhoneField);
        yPos += 40;

        member2NameLabel = new JLabel("Member 2 Name:");
        member2NameLabel.setBounds(30, yPos, 150, 30);
        member2NameLabel.setFont(labelFont);
        formPanel.add(member2NameLabel);
        member2NameField = new JTextField();
        member2NameField.setBounds(200, yPos, 300, 30);
        member2NameField.setFont(fieldFont);
        formPanel.add(member2NameField);
        yPos += 40;

        member2GmailLabel = new JLabel("Gmail:");
        member2GmailLabel.setBounds(30, yPos, 150, 30);
        member2GmailLabel.setFont(labelFont);
        formPanel.add(member2GmailLabel);
        member2GmailField = new JTextField();
        member2GmailField.setBounds(200, yPos, 300, 30);
        member2GmailField.setFont(fieldFont);
        formPanel.add(member2GmailField);
        yPos += 40;

        member2PhoneLabel = new JLabel("Phone:");
        member2PhoneLabel.setBounds(30, yPos, 150, 30);
        member2PhoneLabel.setFont(labelFont);
        formPanel.add(member2PhoneLabel);
        member2PhoneField = new JTextField();
        member2PhoneField.setBounds(200, yPos, 300, 30);
        member2PhoneField.setFont(fieldFont);
        formPanel.add(member2PhoneField);
        yPos += 40;

        member3NameLabel = new JLabel("Member 3 Name:");
        member3NameLabel.setBounds(30, yPos, 150, 30);
        member3NameLabel.setFont(labelFont);
        formPanel.add(member3NameLabel);
        member3NameField = new JTextField();
        member3NameField.setBounds(200, yPos, 300, 30);
        member3NameField.setFont(fieldFont);
        formPanel.add(member3NameField);
        yPos += 40;

        member3GmailLabel = new JLabel("Gmail:");
        member3GmailLabel.setBounds(30, yPos, 150, 30);
        member3GmailLabel.setFont(labelFont);
        formPanel.add(member3GmailLabel);
        member3GmailField = new JTextField();
        member3GmailField.setBounds(200, yPos, 300, 30);
        member3GmailField.setFont(fieldFont);
        formPanel.add(member3GmailField);
        yPos += 40;

        member3PhoneLabel = new JLabel("Phone:");
        member3PhoneLabel.setBounds(30, yPos, 150, 30);
        member3PhoneLabel.setFont(labelFont);
        formPanel.add(member3PhoneLabel);
        member3PhoneField = new JTextField();
        member3PhoneField.setBounds(200, yPos, 300, 30);
        member3PhoneField.setFont(fieldFont);
        formPanel.add(member3PhoneField);
        yPos += 40;

        coachNameLabel = new JLabel("Coach Name:");
        coachNameLabel.setBounds(30, yPos, 150, 30);
        coachNameLabel.setFont(labelFont);
        formPanel.add(coachNameLabel);
        coachNameField = new JTextField();
        coachNameField.setBounds(200, yPos, 300, 30);
        coachNameField.setFont(fieldFont);
        formPanel.add(coachNameField);
        yPos += 40;

        coachGmailLabel = new JLabel("Gmail:");
        coachGmailLabel.setBounds(30, yPos, 150, 30);
        coachGmailLabel.setFont(labelFont);
        formPanel.add(coachGmailLabel);
        coachGmailField = new JTextField();
        coachGmailField.setBounds(200, yPos, 300, 30);
        coachGmailField.setFont(fieldFont);
        formPanel.add(coachGmailField);
        yPos += 40;

        coachPhoneLabel = new JLabel("Phone:");
        coachPhoneLabel.setBounds(30, yPos, 150, 30);
        coachPhoneLabel.setFont(labelFont);
        formPanel.add(coachPhoneLabel);
        coachPhoneField = new JTextField();
        coachPhoneField.setBounds(200, yPos, 300, 30);
        coachPhoneField.setFont(fieldFont);
        formPanel.add(coachPhoneField);
        yPos += 40;

        // Signup and Back buttons
        signupButton = new JButton("Signup");
        signupButton.setBounds(50, yPos, 150, 40);
        signupButton.setFont(buttonFont);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignup();
            }
        });
        formPanel.add(signupButton);

        backButton = new JButton("Back");
        backButton.setBounds(350, yPos, 150, 40);
        backButton.setFont(buttonFont);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            this.dispose();
            NCPC loginPage = new NCPC();
            loginPage.setVisible(true);
        });
        formPanel.add(backButton);

        // Hotline number label
        hotlineLabel = new JLabel("Hotline: +8801626976910");
        hotlineLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Increased font size for hotline
        hotlineLabel.setForeground(Color.RED);
        hotlineLabel.setBounds(30, 680, 250, 30); // Position it towards the bottom left
        formPanel.add(hotlineLabel);

        // Adding components to the container
        container.add(panel, BorderLayout.NORTH);
        container.add(formPanel, BorderLayout.CENTER);
    }

    private void handleSignup() {
        // Fetch user input
        String teamName = teamNameField.getText().trim();
        String member1Name = member1NameField.getText().trim();
        String member1Gmail = member1GmailField.getText().trim();
        String member1Phone = member1PhoneField.getText().trim();
        String member2Name = member2NameField.getText().trim();
        String member2Gmail = member2GmailField.getText().trim();
        String member2Phone = member2PhoneField.getText().trim();
        String member3Name = member3NameField.getText().trim();
        String member3Gmail = member3GmailField.getText().trim();
        String member3Phone = member3PhoneField.getText().trim();
        String coachName = coachNameField.getText().trim();
        String coachGmail = coachGmailField.getText().trim();
        String coachPhone = coachPhoneField.getText().trim();

        // Validate user data (you can add more validations as needed)
        if (teamName.isEmpty() || member1Name.isEmpty() || member1Gmail.isEmpty() || member1Phone.isEmpty() ||
                member2Name.isEmpty() || member2Gmail.isEmpty() || member2Phone.isEmpty() ||
                member3Name.isEmpty() || member3Gmail.isEmpty() || member3Phone.isEmpty() ||
                coachName.isEmpty() || coachGmail.isEmpty() || coachPhone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Store user data
        User newUser = new User(teamName, member1Name, member1Gmail, member1Phone,
                member2Name, member2Gmail, member2Phone,
                member3Name, member3Gmail, member3Phone,
                coachName, coachGmail, coachPhone);
        users.add(newUser);

        JOptionPane.showMessageDialog(this, "Signup successful! You can now log in.");

        // Redirect to login page
        this.dispose();
        NCPC loginPage = new NCPC();
        loginPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignupPage signupFrame = new SignupPage();
            signupFrame.setVisible(true);
        });
    }
}
