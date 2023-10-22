package net.app.theoryofcompproj;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class JsonManip {

    String path = "LinaguaVerifexC++/data/trigger.json";
    File file = new File(path);
    ObjectMapper objectMapper = new ObjectMapper();
    byte[] jsonData;

    {
        try {
            jsonData = Files.readAllBytes(Paths.get(String.valueOf(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeToFile(){
        try{
            //For Prettifying the json file
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            if(jsonNode instanceof ObjectNode objectNode){
                objectNode.put("trigger", 1);
            }
            objectMapper.writeValue(file, jsonNode);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
