package net.app.theoryofcompproj;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class JsonManip {

    private final String selected_automats_path = "C:/Users/user/Desktop/all/Semester_5/Theory_of_computation/project/LinaguaVerifexC++/data/selected_automats.json";
    private final File selected_automats_json = new File(selected_automats_path);

    private final String is_available_path = "C:/Users/user/Desktop/all/Semester_5/Theory_of_computation/project/LinaguaVerifexC++/data/is_language_available.json";
    private final File is_available_json = new File(is_available_path);

    private final String trigger_response_path = "C:/Users/user/Desktop/all/Semester_5/Theory_of_computation/project/LinaguaVerifexC++/data/trigger_response.json";
    private final File trigger_response_json = new File(trigger_response_path);
    private final ObjectMapper objectMapper = new ObjectMapper();
    byte[] selectedAutomatsData;
    byte[] languageAvailable;

    public void writeToSelectedAutomatsJson(boolean isIntSelected,
    boolean isDoubleSelected,
    boolean isFloatSelected,
    boolean isCharSelected,
    boolean isStringSelected,
    boolean isVariableSelected,
    boolean isIfSelected,
    boolean isDoWhileSelected ,
    boolean isWhileSelected,
    boolean isForSelected ,
    boolean isMainSelected,
    boolean isArraySelected) throws IOException {

        try {
            selectedAutomatsData = Files.readAllBytes(Paths.get(String.valueOf(selected_automats_json)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonNode jsonNode = objectMapper.readTree(selectedAutomatsData);

        if(jsonNode instanceof  ObjectNode objectNode){
            if (isIntSelected) {
                objectNode.put("int", true);
            }else{
                objectNode.put("int", false);
            }
            if (isDoubleSelected) {
                objectNode.put("double", true);
            }else{
                objectNode.put("double", false);
            }
            if (isFloatSelected) {
                objectNode.put("float", true);
            }else{
                objectNode.put("float", false);
            }
            if (isCharSelected) {
                objectNode.put("char", true);
            }else{
                objectNode.put("char", false);
            }
            if (isStringSelected) {
                objectNode.put("string", true);
            }else{
                objectNode.put("string", false);
            }
            if (isVariableSelected) {
                objectNode.put("variable", true);
            }else{
                objectNode.put("variable", false);
            }
            if (isIfSelected) {
                objectNode.put("if", true);
            }else{
                objectNode.put("if", false);
            }
            if (isDoWhileSelected) {
                objectNode.put("do_while", true);
            }else{
                objectNode.put("do_while", false);
            }
            if (isWhileSelected) {
                objectNode.put("while", true);
            }else{
                objectNode.put("while", false);
            }
            if (isForSelected) {
                objectNode.put("for", true);
            }else{
                objectNode.put("for", false);
            }
            if (isMainSelected) {
                objectNode.put("main", true);
            }else{
                objectNode.put("main", false);
            }
            if (isArraySelected) {
                objectNode.put("array", true);
            }else{
                objectNode.put("array", false);
            }
        }
        objectMapper.writeValue(selected_automats_json, jsonNode);
    }

    public void writeToLanguageAvailable(String newValue){
        try {
            // Read the existing JSON content
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode rootNode = objectMapper.readTree(is_available_json);

            // Update the "string" field with the new value
            ((ObjectNode) rootNode).put("String", newValue);

            // Write the updated JSON back to the file
            objectMapper.writeValue(is_available_json, rootNode);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your requirements
        }
    }
    public void sendTrigger(){
        try {
            // Read the existing JSON content
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode rootNode = objectMapper.readTree(trigger_response_json);

            // Update the "string" field with the new value
            ((ObjectNode) rootNode).put("trigger", true);

            // Write the updated JSON back to the file
            objectMapper.writeValue(trigger_response_json, rootNode);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your requirements
        }
    }

    public boolean readFromLanguageIsAvailableJson(){
        try {
            JsonNode rootNode = objectMapper.readTree(is_available_json);
            return rootNode.get("available").asBoolean();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your requirements
            return false;
        }
    }
    public Map<String, Boolean> readFromSelectedAutomatsJson(){

        try{
            return objectMapper.readValue(selected_automats_json, new TypeReference<Map<String, Boolean>>() {});
        }catch (IOException e){
            e.printStackTrace();
        }

        return Map.of();
    }

        /*{
        try {
            triggerData = Files.readAllBytes(Paths.get(String.valueOf(trigger_json)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

//    {
//        try {
//            numbersData = Files.readAllBytes(Paths.get(String.valueOf(numbers_json)));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
