import java.io.Serializable;

public class Nominator implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String email;
    String schoolDistrict;
    String position;
    String relationshipToNom;
    String nomName;
    int nomAge;
    String nomContactInfo;
    String nomGraduation;
    String aptitude;
    String perseverance;
    String workEthic;
    String dedication;
    String otherStatements;
    String approved;

    public Nominator(String name, String email, String schoolDistrict, String position, String relationshipToNom,
            String nomName, int nomAge, String nomContactInfo, String nomGraduation, String aptitude,
            String perseverance, String workEthic, String dedication, String otherStatements) {
        this.name = name;
        this.email = email;
        this.schoolDistrict = schoolDistrict;
        this.position = position;
        this.relationshipToNom = relationshipToNom;
        this.nomName = nomName;
        this.nomAge = nomAge;
        this.nomContactInfo = nomContactInfo;
        this.nomGraduation = nomGraduation;
        this.aptitude = aptitude;
        this.perseverance = perseverance;
        this.workEthic = workEthic;
        this.dedication = dedication;
        this.otherStatements = otherStatements;
        this.approved = "Pending";

    }
}