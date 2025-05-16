package Com.Rohit.DAO;

import Com.Rohit.Model.Employee;
import Com.Rohit.Util.Logger;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJSON_IMPL implements EmployeeDAO{

    private static final String FILE_PATH = "employee.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();



    @Override
    public List<Employee> loadEmployee() {
       File file =new File(FILE_PATH);
       if(!file.exists())
           return new ArrayList<>();
       try{
           return objectMapper.readValue(file, new TypeReference<List<Employee>>() {
           });
       }catch (IOException e){
           Logger.log("Error loading employee: " +e.getMessage());
           return new ArrayList<>();
       }
    }

    @Override
    public void saveEmployees(List<Employee> employees) {
       try{
           objectMapper.writeValue(new File(FILE_PATH),employees);
       }catch (IOException e){
           Logger.log("Error saving employees: "+e.getMessage());
       }

    }
}
