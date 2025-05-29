import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static Com.JSON.JsonOp.updateName;

public class Main {
    public static void main(String[] args) {

        String PathDir ="C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Rohit_Java\\Json_OPeration\\src\\Com\\JSON\\data.json";
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode read;
        try {
            read= objectMapper.readTree(new File(PathDir));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        updateName(read);

        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(PathDir),read);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try{
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(read));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }


    }
}