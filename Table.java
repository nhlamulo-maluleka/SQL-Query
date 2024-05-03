import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Responses.Response;
import Utils.Utils;

@SuppressWarnings("unused")
public class Table implements IQueries {
    // Store 10 students
    StudentTable[] studentTable = new StudentTable[10];
    
    // [0]: INSERT
    // [1]: INTO
    // [2]: StudentTable
    // [3]: (firstName,lastName,dateOfBirthString,grade,isNewStudent)
    // [4]: VALUES
    // [5]: (Nhlamulo,Maluleka,1997-01-03,12,false)

    @Override
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

    @Override
    public Response select(String query) throws Exception {
        // COMPLETE THE IMPLEMENTATION OF THIS METHOD
        // 
        String queryResponse = "";
        for (int i = 0; i < studentTable.length; i++) {
            if (studentTable[i] == null)
                continue;
            queryResponse += studentTable[i].toString();
        }

        return new Response(queryResponse);
    }

    @Override
    public Response update(String query) throws Exception {
        // IMPLEMENT THIS METHOD
        return null;
    }

    @Override
    public Response delete(String query) throws Exception {
        // IMPLEMENT THIS METHOD
        return null;
    }

    // ------------------------ HELPER METHODS ------------------------------------
    private Response insert(StudentTable stbl) {
        studentTable[Utils.COUNTER] = stbl;
        return new Response("Insert Query Successful");
    }

    private void validateFields(Set<String> tblColumns) throws Exception {
        for (Field field : StudentTable.class.getDeclaredFields()) {
            if (!tblColumns.contains(field.getName()) && field.getName().compareTo("id") != 0) {
                throw new Exception("INVALID FIELD DETECTED FOR FIELD {" + field.getName() + "}");
            }
        }
    }

    private Map<String, String> mapFieldValues(String[] splitQuery, int fieldIndex, int valueIndex) {
        Map<String, String> fieldValMap = new HashMap<String, String>();

        String[] fields = Utils.getSplitQuery(Utils.removeBrackets(splitQuery[fieldIndex]), ",");
        String[] fieldValues = Utils.getSplitQuery(Utils.removeBrackets(splitQuery[valueIndex]), ",");

        for (int ind = 0; ind < fields.length; ind++) {
            fieldValMap.put(fields[ind], fieldValues[ind]);
        }

        return fieldValMap;
    }
}