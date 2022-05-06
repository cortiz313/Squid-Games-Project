import java.util.Scanner;

public class SquidGamesProject {

    public static void main(String args[])
    {
        String userGuess;
        int wager;
        Scanner keyboard = new Scanner(System.in);
        Game aGame = new Game();
        do {
            aGame.play();
        } while (aGame.getComputerMarbles() != 0 && aGame.getPlayerMarbles() != 0);






    }



}
