import Utils.Utils;

public class StudentTable {
    public int id;
    public String firstName;
    public String lastName;
    public String dateOfBirthString; // Date format must [YYYY-MM-DD]
    public int grade; // Grades are between [1 - 12]
    public Boolean isNewStudent;

    public StudentTable() {
    }

    public StudentTable(String firstName, String lastName, String dateOfBirthString, int grade,
            Boolean isNewStudent) {
        this.id = ++Utils.COUNTER;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirthString = dateOfBirthString;
        this.grade = grade;
        this.isNewStudent = isNewStudent;
    }

    public Object get(String field) {
        switch (field) {
            case "firstName":
                return this.firstName;
            case "lastName":
                return this.lastName;
            case "dateOfBirthString":
                return this.dateOfBirthString;
            case "grade":
                return this.grade;
            case "isNewStudent":
                return this.isNewStudent;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "[" + id + "], " + firstName + ", " + lastName + ", " + dateOfBirthString + ", " + grade + ", "
                + isNewStudent + "\n";
    }
}
