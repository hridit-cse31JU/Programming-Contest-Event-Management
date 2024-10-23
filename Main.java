import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Admin> admins = new ArrayList<>();
    private static ArrayList<Participant> participants = new ArrayList<>();
    private static ArrayList<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        // Load data from files (if needed)
        admins = FileHandler.loadAdmins("admins.txt");
        participants = FileHandler.loadParticipants("participants.txt");
        events = FileHandler.loadEvents("events.txt");

        // Start the GUI application
        EventManagementGUI.main(args);

        // Optionally, you can handle console input here if needed
        // This part can be commented out if you only want the GUI to run
        /*
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Programming Contest Event Management System");
            System.out.println("1. Add Admin");
            System.out.println("2. Register Participant");
            System.out.println("3. Create Event");
            System.out.println("4. View Participants for Event");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addAdmin(scanner);
                    break;
                case 2:
                    registerParticipant(scanner);
                    break;
                case 3:
                    createEvent(scanner);
                    break;
                case 4:
                    viewParticipantsForEvent(scanner);
                    break;
                case 5:
                    running = false;
                    // Save data before exiting
                    FileHandler.saveAdmins(admins, "admins.txt");
                    FileHandler.saveParticipants(participants, "participants.txt");
                    FileHandler.saveEvents(events, "events.txt");
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
        */
    }

    // You can keep the methods for adding admin, registering participant, creating events, and viewing participants here,
    // but they would be mostly redundant with the GUI version.
}
