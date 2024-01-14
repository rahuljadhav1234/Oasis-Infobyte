
import java.util.Scanner;
import java.util.Random;

class guessingnumbergame {
   public static void main(String args[]) {
      Scanner reader = new Scanner(System.in);
      String play = "Yes";

      while (play.equals("Yes")) {
         Random rand = new Random();
         int randomnum = rand.nextInt(100);
         int guess = -1;
         int tries = 0;

         while (guess != randomnum) {
            System.out.println("Guess number between 1 and 100 =");
            guess = reader.nextInt();
            tries++;

            if (guess == randomnum) {
               System.out.println(" Awesome You guess the number :");
               System.out.println("It only took you :" + tries + "  Gusses");
               System.out.println("Would you like to play again yes or no ?");
               play = reader.next().toLowerCase();
            } else if (guess > randomnum) {
               System.out.println("Your guess is to high, try again.");
            } else {
               System.out.println("Your guess to low, try agian. ");
            }
         }
      }
      reader.close();
   }
}

