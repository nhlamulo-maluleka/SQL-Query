# Database Management System

The Java project involves a class named ```Table``` which implements an interface ```IQueries```. This class is designed to manage operations on a table of student records, represented by an ```array``` of ```StudentTable``` objects. The main functionalities provided by the ```Table``` class include ```inserting```, ```selecting```, ```updating```, and ```deleting``` student records based on SQL-like queries passed as strings.

#### Key Components:
1. ```StudentTable``` Array:
The class maintains an array studentTable of ```StudentTable``` objects to store student records. The array is initialized to hold ```10``` student records.

2. ```Insert``` Method:
The insert method parses a query string to extract field names and values, maps them, and validates the fields against the ```StudentTable``` class's fields. If validation passes, it creates a `new` ``StudentTable`` object and stores it in the studentTable array. A response indicating the success of the operation is returned.

3. ```Select``` Method:
The select method iterates through the studentTable array, concatenating the string representations of non-null ```StudentTable``` objects to form a response string, which is then returned wrapped in a Response object.

4. ```Update``` and ```Delete``` Methods:
These methods are declared but not implemented, indicating planned functionality for updating and deleting records.

5. ```Helper``` Methods:
```validateFields```: Validates that the fields specified in a query exist in the StudentTable class, except for the "id" field.
```mapFieldValues```: Maps field names to their corresponding values extracted from the query string.
``insert(StudentTable)``: A helper method for inserting a StudentTable object into the array and returning a success response.

6. ```Utilities```:
The class uses a utility class ```Utils``` for operations like splitting strings and removing brackets, which assists in parsing the query strings.

# TASKS

1. Given the insert method:

```java
    public Response insert(String query) throws Exception {
        Map<String, String> mapped = mapFieldValues(Utils.getSplitQuery(query, " "), 3, 5);
        validateFields(mapped.keySet());

        return insert(new StudentTable(
                mapped.get("firstName"),
                mapped.get("lastName"),
                mapped.get("dateOfBirthString"),
                Integer.valueOf(mapped.get("grade")),
                Boolean.valueOf(mapped.get("isNewStudent"))));
    }
```

> COMPLETE THE IMPLEMENTATION OF THE ```mapFieldValues``` SUCH THAT AN INSERT OPERATION SUCCEEDS!

### EXAMPLE: WHEN THE FOLLOWING CODE IS EXECUTED, THE PROVIDED OUTPUT SHOULD BE PROVIDED

```java
public static void main(String[] args) throws Exception {
    Table tbl = new Table();
    System.out.println(tbl.insert(
            "INSERT INTO StudentTable (firstName,lastName,dateOfBirthString,grade,isNewStudent) VALUES (Nhlamulo,Maluleka,1997-01-03,12,false)"));
    System.out.println(tbl.insert(
            "INSERT INTO StudentTable (firstName,lastName,dateOfBirthString,grade,isNewStudent) VALUES (Silas,Maluks,1997-01-03,12,true)"));
    System.out.println(tbl.select("SELECT firstName,lastName FROM StudentTable WHERE id=2"));
}
```

EXAMPLE OUTPUT:

```
Insert Query Successful
Insert Query Successful
[1], Nhlamulo, Maluleka, 1987-01-03, 12, false
[2], Silas, Maluks, 1987-01-03, 12, true
```

2. The ```select``` method has an incorrect implementation which does not use a query. Your task is to provide a correct implementation of the select method such that it operates on a query and it must be able to select all fields using the ```*``` and also to select ```fields```! It must work same way that it is on as SQL Query. 

> The only exception is that you don't have to implement the ```WHERE``` clause

3. IMPLEMENT BOTH THE ```update``` and ```delete``` methods to operate using queries


# > YOU CAN CREATE THE YOUR OWN HELPERS WHEN YOU NEED THEM, BUT WHERE NECESSARY, YOU MUST MAKE USE OF THE ```HELPERS``` AND ```UTILS``` PROVIDED TO YOU!