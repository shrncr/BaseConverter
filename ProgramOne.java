/*
 * Dr. K
 * CSC 210
 * Program 1
 * Takes input from text file w number, current base, base to convert to, and max bits, and completes the operation as indicated.
 */


import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class ProgramOne {
    public static void main(String[] args){
        String tempConverted;

        File inp = new File("input.txt");
        try{
            FileWriter fileWriter = new FileWriter("output.txt",true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter,8192); 

            try (Scanner sc = new Scanner(inp)) {
                while(sc.hasNextLine()){ //for each binary conversion line
                    String[] currentEq = sc.nextLine().split(" ", 0); //array of the num, currentbase, basetoconvertto, and maxbits
                    Numb current = new Numb(currentEq[0], Integer.parseInt(currentEq[1]), Integer.parseInt(currentEq[2]), Integer.parseInt(currentEq[3])); //new number object

                    if (Integer.parseInt(currentEq[1]) == 10){ //if num in textfile is alr base 10
                        tempConverted = current.convertBasetoR(); //convert it to the defined new base
                        if (tempConverted.length() > current.getMaxNumberOfBits()){ //more than 10 bits means overload, so NO
                            buffWrite.write("OVERFLOW");
                            buffWrite.newLine();
                        }else{ //otherwise its ok, so convert and write it to file
                            buffWrite.write(tempConverted);
                            buffWrite.newLine();
                        }
                    }else{ //if num in textfile isnt alr base 10, we need to CONVERT TO BASE 10 FIRST and then convert again
                        int b = current.convertRToBase();
                        current.setNumber(Integer.toString(current.convertRToBase())); //new base 10 num
                        current.setCurrentBase(10); //make sure its base 10
                        tempConverted = (current.convertBasetoR());
                        if (tempConverted.length() > current.getMaxNumberOfBits()){ //more than 10 bits means overload, so NO
                            buffWrite.write("OVERFLOW");
                            buffWrite.newLine();
                        }else{ //otherwise its ok, so convert and write it to file
                            buffWrite.write(tempConverted);
                            buffWrite.newLine();
                        }
                    }
                }
                buffWrite.close(); //close file writer
                fileWriter.close(); // close file
            }catch (FileNotFoundException e) { 
            System.out.println("fskbegl");
            }
        }catch(IOException e){
            System.err.println("An error occurred: " + e.getMessage());
        }
    } 
}
    
