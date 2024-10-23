import java.util.ArrayList;

public class Admin {
    private String name;

    // Constructor
    public Admin(String name) {
        this.name = name;
    }

    // Method to get admin's name
    public String getName() {
        return name;
    }

    // Method to create a new event
    public Event createEvent(String eventName, String eventDate, String eventDescription) {
        return new Event(eventName, eventDate, eventDescription);
    }

    // Method to add a participant to an event
    public void addParticipant(Event event, Participant participant) {
        if (event != null && participant != null) {
            event.addParticipant(participant);
            System.out.println(participant.getName() + " has been added to " + event.getName());
        } else {
            System.out.println("Event or participant cannot be null.");
        }
    }

    // Method to view participants for a specific event
    public void viewParticipantsForEvent(Event event) {
        if (event != null) {
            System.out.println("Participants for event: " + event.getName());
            ArrayList<Participant> participants = event.getParticipants();
            for (Participant p : participants) {
                System.out.println("- " + p.getName());
            }
        } else {
            System.out.println("Event cannot be null.");
        }
    }

    // Method to remove a participant from an event
    public void removeParticipant(Event event, Participant participant) {
        if (event != null && participant != null) {
            event.removeParticipant(participant);
            System.out.println(participant.getName() + " has been removed from " + event.getName());
        } else {
            System.out.println("Event or participant cannot be null.");
        }
    }
}
