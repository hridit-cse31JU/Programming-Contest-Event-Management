import java.util.ArrayList;

public class Event {
    private String name;
    private String date;
    private String location;
    private ArrayList<Participant> participants;

    // Constructor
    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.participants = new ArrayList<>();
    }

    // Method to get event name
    public String getName() {
        return name;
    }

    // Method to get event date
    public String getDate() {
        return date;
    }

    // Method to get event location
    public String getLocation() {
        return location;
    }

    // Method to add a participant
    public void addParticipant(Participant participant) {
        if (participant != null && !participants.contains(participant)) {
            participants.add(participant);
            System.out.println(participant.getName() + " has been added to " + name);
        } else {
            System.out.println("Participant is already registered or null.");
        }
    }

    // Method to remove a participant
    public void removeParticipant(Participant participant) {
        if (participant != null && participants.contains(participant)) {
            participants.remove(participant);
            System.out.println(participant.getName() + " has been removed from " + name);
        } else {
            System.out.println("Participant not found or null.");
        }
    }

    // Method to view all participants
    public void viewParticipants() {
        System.out.println("Participants for " + name + ":");
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
            return;
        }
        for (Participant participant : participants) {
            System.out.println("- " + participant.getName());
        }
    }

    // New method to get the list of participants
    public ArrayList<Participant> getParticipants() {
        return participants;
    }
}
