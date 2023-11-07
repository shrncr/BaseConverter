import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class checker {
    public static void main(String[] args){
        File out = new File("output2.txt");
        File myOut = new File("output.txt");
        try (Scanner sc = new Scanner(out)) {
            try(Scanner sc2 = new Scanner(myOut)){
                while (sc2.hasNextLine()){
                    String myOutCurLine = sc2.nextLine();
                    String trueOutCurLine = sc.nextLine();
                    if (myOutCurLine.equals(trueOutCurLine)){
                        System.out.println(myOutCurLine.equals(trueOutCurLine));
                    }else{
                        System.out.println(myOutCurLine);
                        System.out.println(trueOutCurLine);
                    }
                }
            }catch(IOException e){
                System.out.print(e);
            }
        }catch(IOException e){
            System.out.print("d");
        }
    } 
}
