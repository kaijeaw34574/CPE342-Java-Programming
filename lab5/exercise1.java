/* Program for training in using files, such as 
 * read file, write file, and covert file, get input from file into an array, etc.
 * 
 * Created by Pornthep Sangthongkhamsuk ID: 63070503431
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class exercise1 {

    public static void main(String[] args) {
        /* create a new file named f.txt */
        File f = new File("f.txt");
        try {
            /* create a FileWriter object to write random numbers to f.txt */
            FileWriter writer = new FileWriter(f);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of random integers to generate: ");
            int x = scanner.nextInt();
            Random rand = new Random();
            for (int i = 0; i < x; i++) {
                int randomInt = rand.nextInt(181) + 32; 
                writer.write(randomInt + "\n"); 
            }
            writer.close();
            /* open f.txt for reading and create a new file named c.txt*/
            Scanner fileScanner = new Scanner(f);
            File c = new File("c.txt");
            FileWriter cWriter = new FileWriter(c);
            /* convert data in f.txt to an array and find the average */
            int[] array = new int[x];
            int sum = 0;
            for (int i = 0; i < x; i++) {
                int num = Integer.parseInt(fileScanner.nextLine());
                array[i] = num;
                sum += num;
            }
            double average = (double)sum / x;
            /* write data in an array to c.txt */
            for (int i = 0; i < x; i++) {
                cWriter.write(array[i] + "\n"); 
            }
            cWriter.close();
            scanner.close();
            fileScanner.close();
            /* display the average number in f.txt on the console */
            System.out.println("The average of the numbers in f.txt is: " + average);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
