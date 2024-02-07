import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * TestingEnviroment
 */
public class TestingEnviroment {

    public static void main(String[] args) throws IOException {

        // File path is passed as parameter
        File file = new File("coding_qual_input.txt");
        String message = decode(file);
        System.out.println(message);

        /*String s = "babad"; //"cbbd";
        System.out.println(longestPalindrome(s));
        */

        /*String reverseString = reverseWords("  hello world  ");
        System.out.println(reverseString);
        */

        /*int length = lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
        */

        /*
        Boolean anagramTesting = new Boolean(null);
        anagramTesting = isAnagramCounting("MADAM CURIE", "RADIUM CAME");
        System.out.println(anagramTesting);
        */
    }

    /*public List<User> disturbable(LocalTime now, List<User> users) {
        
    }
    */
    //SELECT house.BUYER_ID, price.PRICE FROM house RIGHT OUTER JOIN price ON house.HOUSE_ID=price.HOUSE_ID;
    /*WHERE price.PRICE SUM > 100;*/

    private static int CHARACTER_RANGE= 256;
    public static boolean isAnagramCounting(String string1, String string2) {
        System.out.println("In Method 'isAnagramCounting");
        if (string1.length() != string2.length()) {
            return false;
        }

        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            System.out.println(string1.charAt(i));
            count[string1.charAt(i)]++;
            System.out.println(count[i]);
            
            System.out.println(string2.charAt(i));
            count[string2.charAt(i)]--;
            System.out.println(count[i]);
            //System.out.println(count[string2.charAt(i)]);
        }
        System.out.println(string2);
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            System.out.println(count[i]);
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1 ){
            return s.length();
        }
        int largerSubstring = 0;
        String substringCharTemp = Character.toString(s.charAt(0));

        int i = 1; 
        while (i < s.length()) {
            /*If the Character at length (i) is not in the string variable "substringCharTemp" then go ahead and concatenate the 
            character to the string.
            */
            if(!substringCharTemp.contains(Character.toString(s.charAt(i)))){
                substringCharTemp += s.charAt(i);
                i++;
            }
            /*Else, if the character (i) is found in the subtring then go ahead and record the lenght of the current subtring. Then
            clear the contents of the "substringCharTemp" variable, and finally restart the subtring with the current Character.
            */
            else {
                if(substringCharTemp.length() > largerSubstring){
                    largerSubstring = substringCharTemp.length();
                }
                substringCharTemp = "";
                substringCharTemp += s.charAt(i);;
                i++;
            }
        }
        return largerSubstring;
    }

    public static String reverseWords(String s) {
        //Exapmple string "  hello world  "
        String trimmedStr = s.trim();
        //Vector<String> newString = new Vector<String>();
        Stack <String> wordStack = new Stack<String>();

        String wordCreation = "";
        int lengthOfString = trimmedStr.length() -1;

        System.out.println("Trimmed string: " + trimmedStr);
        System.out.println("Length of trimmed string: " + lengthOfString);

        while (lengthOfString >= 0) {
            if (lengthOfString == 0) {
                wordCreation += wordStack;
            }
            if (trimmedStr.charAt(lengthOfString) != ' ') {
                System.out.println("Character: " + trimmedStr.charAt(lengthOfString));
                wordStack.push(Character.toString(trimmedStr.charAt(lengthOfString)));
                lengthOfString --;
            }
            else{ //We reached a Space character in the String
                //If there is a space and the stack is not empty then lets pop the stack and add it to our string variable
                 //"WordCreation"
                if (trimmedStr.charAt(lengthOfString) == ' ' && !wordStack.isEmpty()) {
                    
                    for(int i =0; i < wordStack.size(); i++){
                        System.out.println("Stack size before pop: " + wordStack.size());
                        System.out.print("Current Stack before pop: " + wordStack +"\n");
                        System.out.print("Index i: " + i +"\n");
                    
                        wordCreation += wordStack.pop();
                        System.out.println("Stack elements afer pop: " + wordStack);
                        System.out.println("String so far created: " + wordCreation);
                    }
                    wordCreation += " "; //Concatenate a space character after stack has been all popped (Removed)
                    lengthOfString --; //Continue to the next iteration
                }
                else{ //If spaces continue to be found.
                    lengthOfString --;
                    continue;
                }    
            }   
        }
        return wordCreation;
    }

    public static String longestPalindrome(String s) {
        //Examples: s = "babad", s = "cbbd"
        //s.trim();
        char firstChar = ' '; //s.charAt(0);
        String biggestPalindrome = ""; 
        String lastPalindrome="";
        int i =1;
        int j=0;
        while (i < s.length()){
            System.out.println(s.charAt(i));
            if (firstChar == s.charAt(i)) {
                System.out.println("FirstChar: " +firstChar + " Char at i: " + s.charAt(i));
                String tempString = "";
                String reverseString = "";
                tempString = s.substring(0, i +1);
                System.out.println("Substring palindrome: "+ tempString);
                //i++;
                for(j= tempString.length() -1; j >=0; j--){
                    System.out.println(" Palindrome reverse Char at i: " + tempString.charAt(j));
                    reverseString += tempString.charAt(j);
                }
                //System.out.println("Substring reverse: " + reverseString);
                System.out.println("Palindrome String: '" + tempString + "' Reverse Palindrome String: " +reverseString);

                if (tempString.equals(reverseString)) { //Previously: tempString == reverseString
                    System.out.println("Found matching Palindrome");
                    if(tempString.length() > biggestPalindrome.length()){ 
                        //iF a palindrome bigger than the current was found then replace it.
                        //lastPalindrome =biggestPalindrome;
                        biggestPalindrome = tempString;
                    }
                    //biggestPalindrome = tempString;
                    i++;
                }
                else{
                    System.out.println("Palindrome pattern is not equal.");
                    i++;
                }
                
            }
            else{
                System.out.println("Did not find matching palindrome. Adding 1 to the counter");
                i++;
            }
        }
        System.out.println("Returning Palindrome: ");
        return biggestPalindrome;
    }

    /* public static String decode(File message_file)throws IOException{//String[] message_file)throws IOException{
        // File path is passed as parameter
       // File file = new File("coding_qual_input.txt");

        //InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        //BufferedReader in = new BufferedReader(reader);

        //BufferedReader in = new BufferedReader(new FileReader(file));
        BufferedReader in = new BufferedReader(new FileReader(message_file));
        String line = in.readLine();
        
        HashMap<Integer, String> hashMap = new HashMap<>();

        while (line != null) {
            // Array of string type to store input
            String[] strLine;
            // Reading the input line as a string, and splitting based on space delimeter
            strLine = line.split(" ");
            //strLine = in.readLine().split(" ");
           // System.out.println("line: " + strLine[0] + strLine[1]);
            hashMap.put(Integer.parseInt(strLine[0]),strLine[1]);
            line = in.readLine();
           
            //hashMap.put(Integer.parseInt(strLine[0]), strLine[1]);
        }
        in.close();
        //Sorting hashmap
        ArrayList<Integer> sortedKeys = new ArrayList<>(hashMap.keySet());
        Collections.sort(sortedKeys);

        System.out.println("Array List size: " + sortedKeys.size());
 
        // Display the TreeMap which is naturally sorted
        /*for (int x : sortedKeys){
            System.out.println("Key = " + x + ", Value = " + hashMap.get(x));
        }
        */
        //Print out first Key Value
        /*System.out.println("Line: " + sortedKeys.get(0));
        String decodedMessage = hashMap.get(1)  + " ";

        int keyNumber = 1;
        int lineNumber = 1;
    
            while (keyNumber < hashMap.size()) {
                keyNumber = keyNumber + lineNumber + 1;
                lineNumber = lineNumber + 1;
                System.out.println("Key number " + keyNumber);
                System.out.println("Line number " + lineNumber + "\n");
                // Getting element at index
                //System.out.println("Array value: " + sortedKeys.get(keyNumber -1));
                //System.out.println("hashMap Value: " + hashMap.get(keyNumber));
                if (keyNumber <= hashMap.size()){
                    decodedMessage += hashMap.get(keyNumber ) + " ";
                }
                
            }   
        
        /*while (keyNumber < sortedKeys.size()) {
            keyNumber = keyNumber + lineNumber + 1;
            System.out.println("Key number " + keyNumber);
            // Getting element at index
            System.out.println("Array value: " + sortedKeys.get(keyNumber -1));
            System.out.println("hashMap Value: " + hashMap.get(keyNumber));
            decodedMessage += hashMap.get(keyNumber ) + " ";
            lineNumber = lineNumber + 1;
            System.out.println("Line number " + lineNumber + "\n");
        }
        */
        /*System.out.println(decodedMessage.trim());
        return decodedMessage;

    } */

    // Function to sort a HashMap by "Key".
    /*public static void sortbykey(){
        ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());
 
        Collections.sort(sortedKeys);
 
        // Display the TreeMap which is naturally sorted
        for (String x : sortedKeys)
            System.out.println("Key = " + x
                               + ", Value = " + map.get(x));
    }*/

    public static String decode(File message_file)throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(message_file));
        String line = in.readLine();
        
        HashMap<Integer, String> hashMap = new HashMap<>();

        while (line != null) {
            // Array of string type to store input
            String[] strLine;
            // Reading the input line as a string, and splitting based on space delimeter
            strLine = line.split(" ");
            //Putting the Keys and Values in a HashMap
            hashMap.put(Integer.parseInt(strLine[0]),strLine[1]);
            line = in.readLine();
        }
        in.close();
        
        //Concatenate first Value of Key 1 in a String variable.
        String decodedMessage = hashMap.get(1)  + " ";

        //Variable keyNumber to keep track of the end of the line value. 
        //Variable lineNumber is to keep track of the "lines" or steps in the pyramid.
        int keyNumber = 1;
        int lineNumber = 1;
        while (keyNumber < hashMap.size()) {
            keyNumber = keyNumber + lineNumber + 1;
            lineNumber = lineNumber + 1;
            //This if checks that the next value we find is actually value at the end of each line.
            if (keyNumber <= hashMap.size()){
                decodedMessage += hashMap.get(keyNumber ) + " ";
            }
            
        }   

        decodedMessage.trim();
        return decodedMessage;

    }

}