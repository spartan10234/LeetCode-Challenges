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

        //---Function "removeNthFromEnd"
        int n = 2;

        ListNode nod1 = new ListNode(1);
        ListNode nod2 = new ListNode(2);
        ListNode nod3 = new ListNode(3);
        ListNode nod4 = new ListNode(4);
        ListNode nod5 = new ListNode(5);

        nod1.next = nod2;
        nod2.next = nod3;
        nod3.next = nod4;
        nod4.next = nod5;

        removeNthFromEnd(nod1, n);


        /* ---Function "public static String decode"
        File path is passed as parameter*/

        /*---Funtion "decode" */
        /*File file = new File("coding_qual_input.txt");
        String message = decode(file);
        System.out.println(message);
        */

        /*---Function "longestPalindrome" */
        /*String s = "babad"; //"cbbd";
        System.out.println(longestPalindrome(s));
        */

        /*---Function "reverseWords"*/
        /*String reverseString = reverseWords("  hello world  ");
        System.out.println(reverseString);
        */

        /*---Function "lengthOfLongestSubstring"*/
        /*int length = lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
        */

        /*---Funtion "isAnagramCounting"*/
        /*Boolean anagramTesting = new Boolean(null);
        anagramTesting = isAnagramCounting("MADAM CURIE", "RADIUM CAME");
        System.out.println(anagramTesting);
        */
    }

    private static int CHARACTER_RANGE= 256;
    public static boolean isAnagramCounting(String string1, String string2) {
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
        
        Stack <String> wordStack = new Stack<String>();

        String wordCreation = "";
        int lengthOfString = trimmedStr.length() -1;

        while (lengthOfString >= 0) {
            if (lengthOfString == 0) {
                wordCreation += wordStack;
            }
            if (trimmedStr.charAt(lengthOfString) != ' ') { //Adding each character that is not a space.
                wordStack.push(Character.toString(trimmedStr.charAt(lengthOfString)));
                lengthOfString --;
            }
            else{ //We reached a Space character in the String
                //If there is a space and the stack is not empty then lets pop the stack and add it to our string variable
                 //"WordCreation"
                if (trimmedStr.charAt(lengthOfString) == ' ' && !wordStack.isEmpty()) {
                    for(int i =0; i < wordStack.size(); i++){
                        wordCreation += wordStack.pop();
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
        char firstChar = ' '; 
        String biggestPalindrome = ""; 
        String lastPalindrome="";
        int i =1;
        int j=0;
        while (i < s.length()){
            if (firstChar == s.charAt(i)) {
                String tempString = "";
                String reverseString = "";
                tempString = s.substring(0, i + 1);
            
                for(j= tempString.length() -1; j >=0; j--){
                    reverseString += tempString.charAt(j);
                }
                //Found matching Palindrome
                if (tempString.equals(reverseString)) { 
                    if(tempString.length() > biggestPalindrome.length()){ //iF a palindrome bigger than the current was found then replace it.
                        biggestPalindrome = tempString;
                    }
                    i++;
                }
                else{ //Palindrome pattern is not equal. Continue to next iteration.
                    i++;
                }
                
            }
            else{ //Did not find matching palindrome. Adding 1 to the counter
                i++;
            }
        }
        System.out.println("Returning Palindrome: ");
        return biggestPalindrome;
    }

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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNodes = 0; 
        ListNode current = head;  
        while (current != null) { //Find the nth node 
            current = current.next;  
            totalNodes++;
        }  
        if(totalNodes == 1 && n == 1){ //If ListNode is size 1 and n 1 then return empty node.
            ListNode empty = new ListNode();
            empty = null;
            return empty;
        }

        int nthNode = (totalNodes-n);
        int counter = 1;
        ListNode newHead = head; 
        
        while (head != null){
            //System.out.println("Counter: " + counter);
            if(nthNode != counter){
                head = head.next;
            }
            else{ //nthNode is found, and pointer needs to skip over it.
                head.next = head.next.next;
            }
            counter ++;
        }
        return newHead;
    }
    

}