/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures.algorithms;

     
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    //Algorithm
        //Get the CSV File
        //Submit File
        //Validate file
        //Open file 
        //Get Line Count
        //Read the file line by line
        //Split each line using the comma
        //pick first record
        //pick second record
        //pick third record
        //pick fourth record
        //Validate each Record to see if they meet the criteria
        //Display Result

public class CSV {
    
    String[] parts = new String[4];
    List States = new ArrayList();
    
    public static void main(String[] args) {
        CSV c = new CSV();
        c.States.add("Imo");
        c.States.add("Lagos");
        c.States.add("Kaduna");
        c.States.add("Abuja");
        
        String filepath = "C:\\Users\\Stephen\\Documents\\Visual Studio 2015\\Projects\\ConsoleApplication2\\CSV Integrity Check\\CSVFiles\\TestFile.csv";
        System.out.println("System is reading '"+filepath+"' \n ");
        if (c.ValidateFileExtension(filepath)){
            System.out.println("File Extension is Valid \n");
            c.ValidateFileContents(filepath);
        }
        
    }
    
    public boolean ValidateFileExtension(String filepath){
        System.out.println("Validating File Extension");
        String ext = getFileExtension(new File(filepath));
        
        switch (ext){
            case ".csv":
                return true;
            default:
                return false;
        }
    }
    
    public String getFileExtension(File file){
        String extension = "";
        
        if (file != null && file.exists()){
            String name = file.getName();
            int index = name.lastIndexOf(".");
            extension = name.substring(index);
            return extension;
        }
        
        return extension;
    }
    
    public void ValidateFileContents(String filepath) {
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filepath)); 
            String Line; 
            int linecount = 0;
            while ((Line = reader.readLine()) != null){
                linecount++;
                parts = Line.split(",");
                while(linecount > 1){
                    if (IntegrityCheck(0)){
                        System.out.println("Line "+linecount+" is valid");
                    }else{
                        System.out.println("Line "+linecount+" is Invalid");
                    }
                    break;
                }
            }
        }
        catch (FileNotFoundException f){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Unable to read file lines");
        }
        
        
    }
    
    public boolean IntegrityCheck(int validityCount){
        
        if (ValidateName(parts[0])){
            validityCount++;        
        }
                
        if (ValidateAge(Integer.parseInt(parts[1]))){
            validityCount++;          
        }
       
        if (ValidateGender(parts[2])){
            validityCount++;        
        }
        
        if (ValidateStates(parts[3])){
            validityCount++;    
        }
                
        
        switch (validityCount){
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return false;
            case 4: 
                return true;
           
        }
        return false;
    }
    
    public boolean ValidateName(String name)
    {
        if (name != null || !"".equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidateAge(int age)
    { 
        if (age > 0) {
            return true;
        } else {
           return false;
        }
    }

    public boolean ValidateGender(String gender){
        
        if ("M".equals(gender) || "F".equals(gender)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ValidateStates(String state)
    {
        if (States.contains(state)) {
            return true;
        } else {
            return false;
        }
    }
    
}
