import java.util.ArrayList;

public class Participant {
    private String name;
    private String email;
    private String dateOfBirth;
    private String contest;
    private ArrayList<Event> registeredEvents;

    // Constructor
    public Participant(String name, String email, String dateOfBirth, String contest) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.contest = contest;
        this.registeredEvents = new ArrayList<>();
    }

    // Method to get participant's name
    public String getName() {
        return name;
    }

    // Method to get participant's email
    public String getEmail() {
        return email;
    }

    // Method to get participant's date of birth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Method to get participant's contest
    public String getContest() {
        return contest;
    }

    // Method to register for an event
    public void registerForEvent(Event event) {
        if (event != null) {
            registeredEvents.add(event);
            event.addParticipant(this);  // Add this participant to the event
            System.out.println(name + " has registered for " + event.getName());
        } else {
            System.out.println("Event cannot be null.");
        }
    }

    // Method to view registered events
    public void viewRegisteredEvents() {
        System.out.println(name + "'s Registered Events:");
        if (registeredEvents.isEmpty()) {
            System.out.println("No registered events.");
            return;
        }
        for (Event event : registeredEvents) {
            System.out.println("- " + event.getName());
        }
    }

    // Method to unregister from an event
    public void unregisterFromEvent(Event event) {
        if (event != null && registeredEvents.contains(event)) {
            registeredEvents.remove(event);
            event.removeParticipant(this);  // Remove this participant from the event
            System.out.println(name + " has unregistered from " + event.getName());
        } else {
            System.out.println("Event cannot be null or participant not registered for this event.");
        }
    }
}
