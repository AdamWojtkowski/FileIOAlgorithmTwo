package us.mattgreen;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

    private final static FileInput cardAccts = new FileInput("C:\\Users\\boots\\Downloads\\Spring 2018\\Adv Java\\Lesson #3 File Algorithms and Applications\\FileIOAlgorithmTwo\\FileIOAlgorithmTwo\\movie_cards.csv");
    private final static FileInput cardPurchases = new FileInput("C:\\Users\\boots\\Downloads\\Spring 2018\\Adv Java\\Lesson #3 File Algorithms and Applications\\FileIOAlgorithmTwo\\FileIOAlgorithmTwo\\movie_purchases.csv");
    private final static FileInput movieRatings = new FileInput("C:\\Users\\boots\\Downloads\\Spring 2018\\Adv Java\\Lesson #3 File Algorithms and Applications\\FileIOAlgorithmTwo\\FileIOAlgorithmTwo\\movie_rating.csv");
    private final static FileOutput meals = new FileOutput("C:\\Users\\boots\\Downloads\\Spring 2018\\Adv Java\\Lesson #3 File Algorithms and Applications\\FileIOAlgorithmControlBreak\\FileIOAlgorithmControlBreak\\movie_data.csv");
    private static Scanner keyboard = new Scanner(System.in);
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER = "Account,Rating,Count";

    public static void main(String[] args) {
        String line;
        String[] fields;
        int[] nums = new int[2];
        int[] avg = new int[1];
        System.out.format("%8s  %-18s %6s %6s %-2s\n", "Account", "Name", "Movies", "Points", "Total Rating");
        while ((line = cardAccts.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(fields[0], nums);
            calculateAvgMovieRating(fields[0], avg);
            System.out.format(" 00%6s   %-18s  %2d   %4d      %.2s \n", fields[0], fields[1], nums[0], nums[1], avg[0]);
        }
    }



    public static void findPurchases(String acct, int[] nums) {

        nums[0] = 0;
        nums[1] = 0;
        String line;
        String line2;
        String[] fields;
        String[] fields2;
        boolean done = false;

        while (((line = cardPurchases.fileReadLine()) != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            } else if (fields[0].equals(acct)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
            }
        }
    }

    public static void calculateAvgMovieRating(String acct, int[] avg) {
        avg[0] = 0;
        double avg1 = 0;
        int i = 0;
        int total = 0;
        int count = 0;
        String line2;
        String[] fields2;
        boolean done = false;

        while (((line2 = movieRatings.fileReadLine()) != null) && !(done)) {
            fields2 = line2.split(",");
            if (fields2[0].compareTo(acct) > 0) {
                done = true;
            } else if (fields2[0].equals(acct)) {
                count += Integer.parseInt(fields2[1]);
                i++;
                total = (i * 5);
                //System.out.println("Total : "+count);

                //System.out.println("max stars : "+total);
                avg[0] = total / i;
                avg1 =((double) avg[0]);
                FileWriter fileWriter = null;

                try{
                    fileWriter = new FileWriter("movie_data.csv");

                    //Write the CSV file header
                    fileWriter.append(FILE_HEADER.toString());

                    //Add a new line separator after the header
                    fileWriter.append(NEW_LINE_SEPARATOR);

                    //Write a new student object list to the CSV file

                    for (MovieRating movie : movieRating) {

                        fileWriter.append(String.valueOf(student.getId()));

                        fileWriter.append(COMMA_DELIMITER);

                        fileWriter.append(student.getFirstName());

                        fileWriter.append(COMMA_DELIMITER);

                        fileWriter.append(student.getLastName());

                        fileWriter.append(COMMA_DELIMITER);

                        fileWriter.append(student.getGender());

                        fileWriter.append(COMMA_DELIMITER);

                        fileWriter.append(String.valueOf(student.getAge()));

                        fileWriter.append(NEW_LINE_SEPARATOR);

                    }

                    System.out.println("CSV file was created successfully !!!");

                } catch (Exception e) {
                    System.out.println("Error in CsvFileWriter !!!");
                    e.printStackTrace();

                } finally {

                    try {
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.println("Error while flushing/closing fileWriter !!!");
                        e.printStackTrace();
                    }
                }
            }
            }

            //System.out.println(avg1);
        }


    }


}