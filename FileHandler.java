import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    
    // Generic method to load objects from a file
    @SuppressWarnings("unchecked") // Suppress unchecked cast warning
    private static <T> ArrayList<T> loadList(String filename) {
        ArrayList<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                list = (ArrayList<T>) obj; 
            } else {
                System.out.println("Data in file is not of expected type ArrayList.");
            }
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found. A new one will be created.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Method to load events from a file
    public static ArrayList<Event> loadEvents(String filename) {
        return loadList(filename);
    }

    // Method to save events to a file
    public static void saveEvents(ArrayList<Event> events, String filename) {
        saveList(events, filename);
    }

    // Method to load admins from a file
    public static ArrayList<Admin> loadAdmins(String filename) {
        return loadList(filename);
    }

    // Method to save admins to a file
    public static void saveAdmins(ArrayList<Admin> admins, String filename) {
        saveList(admins, filename);
    }

    // Method to load participants from a file
    public static ArrayList<Participant> loadParticipants(String filename) {
        return loadList(filename);
    }

    // Method to save participants to a file
    public static void saveParticipants(ArrayList<Participant> participants, String filename) {
        saveList(participants, filename);
    }

    // Generic method to save objects to a file
    private static <T> void saveList(ArrayList<T> list, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println(list.get(0).getClass().getSimpleName() + " saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
