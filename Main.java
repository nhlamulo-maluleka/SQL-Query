public class Main {
    // [StudentTable]
    // - id [int] -> {The Id is AutoIncremented, so no need to manually create an
    // [id]}
    // - firstName [String]
    // - lastName [String]
    // - dateOfBirthString [String] -> {Date format must [YYYY-MM-DD]}
    // - grade [int] -> {Grades are between [1 - 12]}
    // - isNewStudent [Boolean]

    // [QUERIES]
    // "INSERT INTO StudentTable (firstName,lastName,dateOfBirthString,grade,isNewStudent) VALUES (Nhlamulo,Maluleka,1997-01-03,12,false)"
    // SELECT firstName,lastName FROM StudentTable WHERE id=2
    // DELETE FROM StudentTable WHERE id=2
    // UPDATE StudentTable SET firstName=newName WHERE id=4

    public static void main(String[] args) throws Exception {
        Table tbl = new Table();
        System.out.println(tbl.insert(
                "INSERT INTO StudentTable (firstName,lastName,dateOfBirthString,grade,isNewStudent) VALUES (Nhlamulo,Maluleka,1987-01-03,12,false)"));
        System.out.println(tbl.insert(
                "INSERT INTO StudentTable (firstName,lastName,dateOfBirthString,grade,isNewStudent) VALUES (Silas,Maluks,1987-01-03,12,true)"));
        System.out.println(tbl.select("SELECT firstName,lastName FROM StudentTable"));
        System.out.println(tbl.update("UPDATE StudentTable SET firstName=newName,lastName=newLast WHERE id=1"));
        System.out.println(tbl.select("SELECT firstName,lastName FROM StudentTable"));
        // System.out.println(tbl.delete("DELETE FROM StudentTable WHERE id=2"));
    }
}
