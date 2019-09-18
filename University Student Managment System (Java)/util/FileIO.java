/**
 * @author Amit Biswas
 */

package ucam.util;

import java.io.*;


public class FileIO {
    
    /**
     * To skip iterating through the file twice.
     */
    public static String matchedLine;
    
    /**
     * To check username and password while logging in.
     * @param ID is a specifically formatted String to compare with saved username and password.
     * @return true if it's a match.
     * @throws IOException 
     */
    public static boolean check(String ID) throws IOException {

        String line , path;
        BufferedReader reader;
        boolean match = false;
        
        path = "/home/amitb/NetBeansProjects/UCAM/src/ucam/util/login.txt";
        reader = new BufferedReader(new FileReader(path));
        if (reader.ready()){

            while ((line = reader.readLine()) != null){

                if (line.equals(ID)){
                    matchedLine = line;
                    match = true;
                    break;
                }
            }
        }
        reader.close();
        return match;
    }

    /**
     * To check if old password matches while changing password.
     * @param oldPass is the old password duh!
     * @return true is it's a match
     * @throws IOException 
     */
    public static boolean checkOldPass(String oldPass) throws IOException {

        String line , path;
        String[] arr;
        BufferedReader reader;
        boolean match = false;
        
        path = "/home/amitb/NetBeansProjects/UCAM/src/ucam/util/login.txt";
        reader = new BufferedReader(new FileReader(path));
        if (reader.ready()){

            while ((line = reader.readLine()) != null){

                arr = line.split("-");
                if(arr[0].equals(oldPass)){
                    match = true;
                    break;
                }
            }
        }
        reader.close();
        return match;
    }

    /**
     * To write new password for the user.
     * @param newPass is the new password
     * @return true if renaming the temporary txt file successful
     * @throws IOException 
     */
    public static boolean writeNewpass(String newPass) throws IOException{

        String line, tempLine , path;
        /**
         * This array holds the username and password.
         * Made using split() method.
         */
        String[] arr;
        boolean doneWriting=false;
        
        path = "/home/amitb/NetBeansProjects/UCAM/src/ucam/util/login.txt";
        File file = new File(path);
        /**
         * Temporary file to copy all data to.
         */
        File tempFile = new File("/home/amitb/NetBeansProjects/UCAM/src/ucam/util/loginTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        while ((line = reader.readLine()) != null){

            if(line.equals(matchedLine)){

                arr = line.split("-");
                tempLine = newPass +"-"+ arr[1];

                writer.write(tempLine);
                writer.newLine();
                writer.flush();
            } else {

                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        }
        reader.close();
        writer.close();
        /**
         * Platform dependent. 
         * Renames the temporary file to original file.
         */
        doneWriting = tempFile.renameTo(file);

        return doneWriting;
    }
}
