import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EventManagementGUI {
    private JFrame mainFrame;
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

    public EventManagementGUI() {
        createMainGUI();
    }

    // Method to set up the main GUI
    private void createMainGUI() {
        mainFrame = new JFrame("Event Management System");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(4, 1));

        JButton addAdminButton = new JButton("Add Admin");
        JButton registerParticipantButton = new JButton("Register Participant");
        JButton createEventButton = new JButton("Create Event");
        JButton viewParticipantsButton = new JButton("View Participants");

        // Add action listeners to buttons
        addAdminButton.addActionListener(e -> openAddAdminWindow());
        registerParticipantButton.addActionListener(e -> openRegisterParticipantWindow());
        createEventButton.addActionListener(e -> openCreateEventWindow());
        viewParticipantsButton.addActionListener(e -> openViewParticipantsWindow());

        // Add buttons to the main frame
        mainFrame.add(addAdminButton);
        mainFrame.add(registerParticipantButton);
        mainFrame.add(createEventButton);
        mainFrame.add(viewParticipantsButton);

        mainFrame.setVisible(true);
    }

    // Method to open the add admin window
    private void openAddAdminWindow() {
        JFrame adminFrame = new JFrame("Add Admin");
        adminFrame.setSize(300, 200);
        adminFrame.setLayout(new GridLayout(2, 2));
        
        JTextField adminNameField = new JTextField();
        JButton addButton = new JButton("Add Admin");

        addButton.addActionListener(e -> {
            String name = adminNameField.getText();
            if (!name.isEmpty()) {
                Admin admin = new Admin(name);
                admins.add(admin);
                JOptionPane.showMessageDialog(adminFrame, "Admin added successfully!");
                adminFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(adminFrame, "Please enter a name.");
            }
        });

        adminFrame.add(new JLabel("Admin Name:"));
        adminFrame.add(adminNameField);
        adminFrame.add(addButton);
        adminFrame.setVisible(true);
    }

    // Method to open the register participant window
    private void openRegisterParticipantWindow() {
        JFrame participantFrame = new JFrame("Register Participant");
        participantFrame.setSize(350, 300);
        participantFrame.setLayout(new GridLayout(5, 2));
        
        JTextField participantNameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField contestField = new JTextField();
        JButton registerButton = new JButton("Register Participant");

        registerButton.addActionListener(e -> {
            String name = participantNameField.getText();
            String email = emailField.getText();
            String dob = dobField.getText();
            String contest = contestField.getText();

            if (!name.isEmpty() && !email.isEmpty() && !dob.isEmpty() && !contest.isEmpty()) {
                Participant participant = new Participant(name, email, dob, contest);
                for (Event event : events) {
                    if (event.getName().equalsIgnoreCase(contest)) {  // Assuming contest is the event name
                        participant.registerForEvent(event);
                        participants.add(participant);
                        JOptionPane.showMessageDialog(participantFrame, "Participant registered successfully!");
                        participantFrame.dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(participantFrame, "Event not found. Registration failed.");
            } else {
                JOptionPane.showMessageDialog(participantFrame, "Please fill all fields.");
            }
        });

        participantFrame.add(new JLabel("Participant Name:"));
        participantFrame.add(participantNameField);
        participantFrame.add(new JLabel("Email:"));
        participantFrame.add(emailField);
        participantFrame.add(new JLabel("Date of Birth:"));
        participantFrame.add(dobField);
        participantFrame.add(new JLabel("Contest:"));
        participantFrame.add(contestField);
        participantFrame.add(registerButton);
        participantFrame.setVisible(true);
    }

    // Method to open the create event window
    private void openCreateEventWindow() {
        JFrame eventFrame = new JFrame("Create Event");
        eventFrame.setSize(300, 200);
        eventFrame.setLayout(new GridLayout(4, 2));
        
        JTextField eventNameField = new JTextField();
        JTextField eventDateField = new JTextField();
        JTextField eventLocationField = new JTextField();
        JButton createButton = new JButton("Create Event");

        createButton.addActionListener(e -> {
            String name = eventNameField.getText();
            String date = eventDateField.getText();
            String location = eventLocationField.getText();
            if (!name.isEmpty() && !date.isEmpty() && !location.isEmpty()) {
                Event event = new Event(name, date, location);
                events.add(event);
                JOptionPane.showMessageDialog(eventFrame, "Event created successfully!");
                eventFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(eventFrame, "Please fill all fields.");
            }
        });

        eventFrame.add(new JLabel("Event Name:"));
        eventFrame.add(eventNameField);
        eventFrame.add(new JLabel("Event Date:"));
        eventFrame.add(eventDateField);
        eventFrame.add(new JLabel("Event Location:"));
        eventFrame.add(eventLocationField);
        eventFrame.add(createButton);
        eventFrame.setVisible(true);
    }

    // Method to open the view participants window
    private void openViewParticipantsWindow() {
        JFrame viewFrame = new JFrame("View Participants");
        viewFrame.setSize(400, 300);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        StringBuilder participantsInfo = new StringBuilder();
        for (Event event : events) {
            participantsInfo.append("Event: ").append(event.getName()).append("\n");
            for (Participant participant : event.getParticipants()) {
                participantsInfo.append("- ").append(participant.getName())
                                .append(" (").append(participant.getEmail()).append(", ")
                                .append(participant.getDateOfBirth()).append(", ")
                                .append(participant.getContest()).append(")\n");
            }
            participantsInfo.append("\n");
        }

        if (participantsInfo.length() == 0) {
            textArea.setText("No participants registered.");
        } else {
            textArea.setText(participantsInfo.toString());
        }

        viewFrame.add(new JScrollPane(textArea));
        viewFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new EventManagementGUI();
    }
}
