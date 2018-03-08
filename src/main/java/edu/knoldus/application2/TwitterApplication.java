package edu.knoldus.application2;

import java.util.Scanner;

public class TwitterApplication {

    public static void main(String[] args) {

        Operations objectOfOperation = new Operations("#ViratKohli");
        System.out.println("1: Total Tweets \n2: Average Tweets Per Day \n"
                + "3: Average Likes \n4: Average ReTweets");
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Enter Your choice: ");
        Integer userChoice = scannerObject.nextInt();

        switch (userChoice) {
            case 1:
                objectOfOperation.getTotalNoOfTweets();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                break;
            case 2:
                objectOfOperation.getAverageTweetsPerDay();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                break;
            case 3:
                objectOfOperation.getAverageNumOfLikes();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                break;
            case 4:
                objectOfOperation.getAverageReTweets();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                break;
            default:
                System.out.println("You Have Entered Wrong Choice!!!");
        }
    }
}
