package NCPC_Project;

import javax.swing.*;
import java.awt.*;

public class SignupPage extends JFrame {
    private Container container;
    private JLabel teamNameLabel, member1NameLabel, member1PhoneLabel, member2NameLabel, member2PhoneLabel, member3NameLabel, member3PhoneLabel,coahnamelabel,coachnumberlabel;
    private JTextField teamNameField, member1NameField, member1PhoneField, member2NameField, member2PhoneField, member3NameField, member3PhoneField,coachnamefield,coachnumberfield;
    private JButton signupButton, backButton;

    public SignupPage() {
        setTitle("Signup - NCPC 2K24");
        setSize(600, 600);
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

        JLabel titleLabel = new JLabel("Signup for NCPC 2K24", JLabel.CENTER);
        titleLabel.setBounds(50, 20, 500, 50);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(titleFont);

        teamNameLabel = new JLabel("Team Name:");
        teamNameLabel.setBounds(50, 100, 150, 30);
        teamNameLabel.setForeground(Color.BLACK);
        teamNameLabel.setFont(labelFont);

        teamNameField = new JTextField();
        teamNameField.setBounds(200, 100, 300, 30);
        teamNameField.setFont(labelFont);

        member1NameLabel = new JLabel("Member 1 Name:");
        member1NameLabel.setBounds(50, 150, 150, 30);
        member1NameLabel.setForeground(Color.BLACK);
        member1NameLabel.setFont(labelFont);

        member1NameField = new JTextField();
        member1NameField.setBounds(200, 150, 300, 30);
        member1NameField.setFont(labelFont);

        member1PhoneLabel = new JLabel("Phone Number:");
        member1PhoneLabel.setBounds(50, 200, 150, 30);
        member1PhoneLabel.setForeground(Color.BLACK);
        member1PhoneLabel.setFont(labelFont);

        member1PhoneField = new JTextField();
        member1PhoneField.setBounds(200, 200, 300, 30);
        member1PhoneField.setFont(labelFont);

        member2NameLabel = new JLabel("Member 2 Name:");
        member2NameLabel.setBounds(50, 250, 150, 30);
        member2NameLabel.setForeground(Color.BLACK);
        member2NameLabel.setFont(labelFont);

        member2NameField = new JTextField();
        member2NameField.setBounds(200, 250, 300, 30);
        member2NameField.setFont(labelFont);

        member2PhoneLabel = new JLabel("Phone Number:");
        member2PhoneLabel.setBounds(50, 300, 150, 30);
        member2PhoneLabel.setForeground(Color.BLACK);
        member2PhoneLabel.setFont(labelFont);

        member2PhoneField = new JTextField();
        member2PhoneField.setBounds(200, 300, 300, 30);
        member2PhoneField.setFont(labelFont);

        member3NameLabel = new JLabel("Member 3 Name:");
        member3NameLabel.setBounds(50, 350, 150, 30);
        member3NameLabel.setForeground(Color.BLACK);
        member3NameLabel.setFont(labelFont);

        member3NameField = new JTextField();
        member3NameField.setBounds(200, 350, 300, 30);
        member3NameField.setFont(labelFont);

        member3PhoneLabel = new JLabel("Phone number:");
        member3PhoneLabel.setBounds(50, 400, 150, 30);
        member3PhoneLabel.setForeground(Color.BLACK);
        member3PhoneLabel.setFont(labelFont);

        member3PhoneField = new JTextField();
        member3PhoneField.setBounds(200, 400, 300, 30);
        member3PhoneField.setFont(labelFont);

        /*
         coachNameLabel = new JLabel("Coach Name:");
        member3NameLabel.setBounds(50, 450, 150, 30);
        member3NameLabel.setForeground(Color.BLACK);
        member3NameLabel.setFont(labelFont);

        coachNameField = new JTextField();
        member3NameField.setBounds(200, 350, 300, 30);
        member3NameField.setFont(labelFont);

        member3PhoneLabel = new JLabel("Phone number:");
        member3PhoneLabel.setBounds(50, 400, 150, 30);
        member3PhoneLabel.setForeground(Color.BLACK);
        member3PhoneLabel.setFont(labelFont);

        member3PhoneField = new JTextField();
        member3PhoneField.setBounds(200, 400, 300, 30);
        member3PhoneField.setFont(labelFont);
         */

        signupButton = new JButton("Signup");
        signupButton.setBounds(50, 470, 150, 40);
        signupButton.setFont(labelFont);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);

        backButton = new JButton("Back");
        backButton.setBounds(350, 470, 150, 40);
        backButton.setFont(labelFont);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            this.dispose();
            NCPC loginPage = new NCPC();
            loginPage.setVisible(true);
        });

        container.add(titleLabel);
        container.add(teamNameLabel);
        container.add(teamNameField);
        container.add(member1NameLabel);
        container.add(member1NameField);
        container.add(member1PhoneLabel);
        container.add(member1PhoneField);
        container.add(member2NameLabel);
        container.add(member2NameField);
        container.add(member2PhoneLabel);
        container.add(member2PhoneField);
        container.add(member3NameLabel);
        container.add(member3NameField);
        container.add(member3PhoneLabel);
        container.add(member3PhoneField);
        container.add(signupButton);
        container.add(backButton);
    }

    public static void main(String[] args) {
        SignupPage signupFrame = new SignupPage();
        signupFrame.setVisible(true);
}
}
