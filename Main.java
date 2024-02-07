import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    int[][] arr;
    int rows = Character.getNumericValue(in.readLine().charAt(0));
    System.out.println(rows);
    arr = new int[rows-1][3];

    int lineRow =0;
    while ((line = in.readLine()) != null) {
      System.out.println(line);
      int lineColumn =0;
      for(int i = 0; i < line.length(); i++){
        if(line.charAt(i)== ' '){
          continue;
        }
        else{
          arr[lineRow][lineColumn] = Character.getNumericValue(line.charAt(i));
          lineColumn++;
        }
      }
      lineRow++;
    
    }
    System.out.println(Arrays.deepToString(arr));
    for(int [] row : arr){
      System.out.println(Arrays.toString(arr));
    }
    System.out.println(arr);
  }
}