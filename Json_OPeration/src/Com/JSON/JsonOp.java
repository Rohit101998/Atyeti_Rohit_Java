package Com.JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;
import java.util.Map;

public class JsonOp {
    public static void updateName(JsonNode node){
        if(node.isObject()){
            ObjectNode objectNode=(ObjectNode) node;
            Iterator<Map.Entry<String,JsonNode>> fields = objectNode.fields();
            while(fields.hasNext()){
                Map.Entry<String,JsonNode>entry = fields.next();
                String key = entry.getKey();
                JsonNode value = entry.getValue();
                if("name".equals(key) && value.isTextual()){
                    objectNode.put(key,"Rohit");
                }else {
                    updateName(value);
                }
            }
        } else if (node.isArray()) {
            for(JsonNode names:node){
                updateName(names);
            }

        }
    }
}
