import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    // Get the input
    Scanner input = new Scanner(System.in);
    int q = input.nextInt();
    
    ArrayList<String> numbers = new ArrayList<>();
    for(int i = 0; i < q; i++) {
        numbers.add(input.next());
    }
    input.close();
    
    // Start processing
    for(String num : numbers) {
        long res = isBeautiful(num);
        if(res == -1)
        System.out.println("NO");
        else
        System.out.println("YES " + res);
    }
    }
 
    public static long isBeautiful(String original) {
    long res = -1;
    
    if(original.length() <= 1)
        return res;
    
    for(int startLength = 1; startLength <= original.length() / 2; startLength++) {
        String expected = original.substring(0, startLength);
        long firstNumber = Long.parseLong(expected);
        res = firstNumber;
        
        while(expected.length() < original.length()) {
        firstNumber++;
        expected += String.valueOf(firstNumber);
        }
        
        // Compare expected and original
        boolean valid = true;
        for(int i = 0; i < original.length(); i++) {
        if(original.charAt(i) != expected.charAt(i)) {
            valid = false;
            break;
        }
        }
        
        if(valid) {
        return res;
        }
    }
    
    return -1;
    }
    
    public static <T> void showList(ArrayList<T> list) {
    System.out.println("The following list contents are: ");
    for(T element : list) {
        System.out.println(element);
    }
    }
}