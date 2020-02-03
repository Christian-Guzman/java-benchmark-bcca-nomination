import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Nominator> nominations = loadOrders();

        Nominator nomination = nominate();
        nominations.add(nomination);
        save(nominations);

    }

    private static void save(ArrayList<Nominator> nominations) {
        try {
            FileOutputStream fileStream = new FileOutputStream("nominations.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(nominations);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save nominations.");
        }
    }

    private static Nominator nominate() {
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("School District or Affiliation: ");
        String schoolDistrict = in.nextLine();
        System.out.print("Position: ");
        String position = in.nextLine();
        System.out.print("Relationship to Nominee: ");
        String relationshipToNom = in.nextLine();
        System.out.print("Nominee Name: ");
        String nomName = in.nextLine();
        System.out.print("Nominee Age: ");
        Integer nomAge = Integer.parseInt(in.nextLine());
        System.out.print("Nominee Contact Info: ");
        String nomContactInfo = in.nextLine();
        System.out.print("Nominee Graduation date: ");
        String nomGraduation = in.nextLine();
        System.out.print(
                "Aptitude: Do you have any experiences when this student has demonstrated strong ability to think logically and/or strategically?: ");
        String aptitude = in.nextLine();
        System.out.print(
                "Perseverance: Is there any evidence of the applicant being engaged in something they are passionate about?: ");
        String perseverance = in.nextLine();
        System.out.print(
                "Dedication: Do you think the applicant would be able to reliably attend the program five days a week in Water Valley?: ");
        String dedication = in.nextLine();
        System.out.print("Work Ethic/Heart: Why does this student deserve a position at Base Camp?: ");
        String workEthic = in.nextLine();
        System.out.print("Anything else you'd like to share about this nominee?: ");
        String otherStatements = in.nextLine();
        System.out.println(name + " has nominated " + nomName + " to Base Camp Coding Academy.");
        return new Nominator(name, email, schoolDistrict, position, relationshipToNom, nomName, nomAge, nomContactInfo,
                nomGraduation, aptitude, perseverance, workEthic, dedication, otherStatements);
    }

    private static ArrayList<Nominator> loadOrders() {
        try {
            FileInputStream fileStream = new FileInputStream("nominations.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Nominator> nominations = (ArrayList<Nominator>) os.readObject();
            os.close();
            return nominations;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Nominator>();
        }
    }
}