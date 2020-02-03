import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Employees {
    static Scanner in = new Scanner(System.in);

    public static void main(final String[] args) {
        final ArrayList<Nominator> nominations = loadOrders();
        System.out.println("View Nominations: ");
        int i = 0;
        for (final Nominator nomination : nominations) {
            System.out.println("[" + i + "]" + "Nominated by: " + nomination.name + ", Nominee: " + nomination.nomName);
            i += 1;
        }
        while (true) {
            System.out.print("Would you like to approve[Y] or disapprove[N] someone or [Q]uit: ");
            final String approve = in.nextLine().toLowerCase();
            if (approve.equals("y")) {
                System.out.print("Choose their respective number: ");
                final Integer num = Integer.parseInt(in.nextLine());
                nominations.get(num).approved = "Yes";
                System.out.println(nominations.get(num).nomName + " Approved: " + nominations.get(num).approved);
            }
            if (approve.equals("n")) {
                System.out.print("Choose their respective number: ");
                final Integer num = Integer.parseInt(in.nextLine());
                nominations.get(num).approved = "No";
                System.out.println(nominations.get(num).nomName + " Approved: " + nominations.get(num).approved);
            }
            if (approve.equals("q")) {
                break;
            }
        }
        save(nominations);
    }

    private static ArrayList<Nominator> loadOrders() {
        try {
            final FileInputStream fileStream = new FileInputStream("nominations.ser");
            final ObjectInputStream os = new ObjectInputStream(fileStream);
            final ArrayList<Nominator> nominations = (ArrayList<Nominator>) os.readObject();
            os.close();
            return nominations;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Nominator>();
        }
    }

    private static void save(final ArrayList<Nominator> nominations) {
        try {
            final FileOutputStream fileStream = new FileOutputStream("nominations.ser");
            final ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(nominations);
            os.close();
        } catch (final IOException ex) {
            System.out.println("Failed to save nominations.");
        }
    }
}