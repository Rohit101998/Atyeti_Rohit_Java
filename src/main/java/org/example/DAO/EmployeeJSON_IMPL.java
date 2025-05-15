package org.example.DAO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entity.Employee;
import org.example.Util.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJSON_IMPL implements EmployeeDAO{

    private static final String FILE_PATH = "employee.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Employee> loadEmployee() {
        File file = new File(FILE_PATH);
        if(!file.exists())
            return new ArrayList<>();
        try{
            objectMapper.readValue(file, new TypeReference<List<Employee>>() {
            });
        }catch (IOException e){
            Logger.log("Error Loading Employee: "+e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void saveEmployees(List<Employee> employees) {
        try{
            objectMapper.writeValue(new File(FILE_PATH),employees);
        } catch (IOException e) {
            Logger.log("Error Saving Employees: "+e.getMessage());
        }
    }
}
