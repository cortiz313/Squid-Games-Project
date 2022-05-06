import java.util.Random;
import java.util.Scanner;

public class Game {

    private int computerMarbles = 10;
    private int playerMarbles = 10;
    private int computerMarbleWager;
    private int playerMarbleWager;
    private int computerHand;
    private int playerHand;
    private String userGuess = "";
    private String computerGuess = "";

    public Game()
    {

    }

    public void setPlayerMarbleWager(int playerMarbleWager)
    {

        this.playerMarbleWager = playerMarbleWager;
        playerMarbles = playerMarbles - playerMarbleWager;
        System.out.println("Test player wager, it's " + playerMarbleWager);
        System.out.println("Test Player marbles left, it's " + playerMarbles);
    }

    public void setComputerMarbleWager()
    {
        Random myRan = new Random();
        int marbleNumber;
        marbleNumber = myRan.nextInt(computerMarbles) + 1;
        computerMarbleWager = marbleNumber;
        computerMarbles = computerMarbles - computerMarbleWager;
        System.out.println("TEST Computer marble wager is " + computerMarbleWager);
        System.out.println("TEST computer marbles left is " + computerMarbles);
    }

    public int getComputerMarbles()
    {
        return computerMarbles;
    }

    public int getPlayerMarbles()
    {
        return playerMarbles;
    }

    public void setComputerHand()
    {
        Random myRan  = new Random();
        computerHand = myRan.nextInt(computerMarbles) + 1;
        System.out.println("Test computer hand, there are #" + computerHand + " marbles.");
    }

    public void setPlayerHand(int playerHand) {

        this.playerHand = playerHand;
        System.out.println("TEST there are " + playerHand + " marbles in your hand.");
    }

    public void setComputerGuess() {
        Random myRan = new Random();
        int randomNum = myRan.nextInt(2);
        System.out.println("Computer Guess random number is " + randomNum);
        if (randomNum == 1)
        {
            computerGuess = "Even";
            System.out.println("Computer guess is " + computerGuess);
        }
        else {
            computerGuess = "Odd";
            System.out.println("Computer guess is " + computerGuess);
        }
    }

    public void play()
    {
        Random myRan = new Random();
        int gameNum = myRan.nextInt(6);
        System.out.println("game num is " + gameNum);
        if (gameNum == 0)
        {
            girlsGame();
        }
        else if (gameNum == 1)
        {
            oldManGame();
        }
        else if (gameNum == 2)
        {
            sangWooGame();
        }
        else
        {
            Scanner keyboard = new Scanner(System.in);
            setComputerHand();
            do {
                System.out.println("Computer has marbles in their hand. What is your guess, odd or even?");
                userGuess = keyboard.nextLine();
                if (!userGuess.equalsIgnoreCase("Odd") && !userGuess.equalsIgnoreCase("Even"))
                {
                    System.out.println("Please type odd or even.");
                }
            } while(!userGuess.equalsIgnoreCase("Odd") && !userGuess.equalsIgnoreCase("Even"));
            System.out.println("What is your wager on that guess? You have " + playerMarbles + " marbles left to wager.");
            setPlayerMarbleWager(keyboard.nextInt());
            determineWinner();
            if (playerMarbles != 0 && computerMarbles != 0)
            {
                System.out.println("It is your turn, how many marbles do you want in your hand? You have " + playerMarbles + " left.");
                setPlayerHand(keyboard.nextInt());
                setComputerMarbleWager();
                setComputerGuess();
                determineWinner();
             }


        }



    }

    public void girlsGame()
    {
        Scanner keyboard = new Scanner(System.in);
        String answer1, answer2;
        int ballRoll;
        System.out.println("Alright, let's just play 1 game for all the marbles...");
        System.out.println("For now, let's just talk...");
        System.out.println("What will you do with the money if you win?");
        answer1 = keyboard.nextLine();
        System.out.println("Do you have any family?");
        answer2 = keyboard.nextLine();
        System.out.println("Ok, time's almost up, let's play.");
        System.out.println("Roll the marble towards the wall. Closest one wins. (Type 1 to roll)");
        ballRoll = keyboard.nextInt();
        System.out.println("You rolled your ball, you're about 1 foot from the wall");
        System.out.println("Ji-Yeong - Ok my turn...");
        System.out.println("She drops the ball...");
        System.out.println("You yell at her to take a real turn. She refuses.");
        System.out.println("She wants you to win the money for your family. You cry. Game over.");
        System.out.println("You win");
        System.exit(0);

    }

    public void oldManGame()
    {
        // type text for playing, and old man running away
        System.out.println("OLD MAN GAME");
        System.exit(0);
    }

    public void sangWooGame()
    {
        // type text for you winning most games, and then Sang Woo trying to talk you into going to check.
        // Give player option to say fuck you sang woo, and you win
        System.out.println("SANG WOO GAME");
        System.exit(0);
    }

    public void determineWinner()
    {
        if (userGuess.equalsIgnoreCase("Even") && computerHand % 2 == 0)
        {
            // Because if you win, you get the wager in your hand back plus that amount from the computer
            playerMarbles = playerMarbles + playerMarbleWager * 2;
            // Then you must subtract that amount from the computers marbles
            computerMarbles = computerMarbles - playerMarbleWager;
            System.out.println("TEST player got it right, player marbles now " + playerMarbles);
            System.out.println("TEST Computer marbles is  now " + computerMarbles);
            userGuess = "";
            // STOPPING POINT, need to
        }
        else if (userGuess.equalsIgnoreCase("Even") && computerHand % 2 != 0)
        {
            computerMarbles = computerMarbles + playerMarbleWager;
            System.out.println("TEST player is wrong, player marbles now " + playerMarbles);
            System.out.println("TEST Computer marbles is now " + computerMarbles);
            userGuess = "";
        }
        else if (userGuess.equalsIgnoreCase("Odd") && computerHand % 2 == 0)
        {
            computerMarbles = computerMarbles + playerMarbleWager;
            System.out.println("TEST player is wrong, player marbles now " + playerMarbles);
            System.out.println("TEST Computer marbles is now " + computerMarbles);
            userGuess = "";
        }
        else if (userGuess.equalsIgnoreCase("Odd") && computerHand % 2 != 0)
        {
            playerMarbles = playerMarbles + playerMarbleWager * 2;
            computerMarbles = computerMarbles - playerMarbleWager;
            System.out.println("TEST player got it right, player marbles now " + playerMarbles);
            System.out.println("TEST Computer marbles is  now " + computerMarbles);
            userGuess = "";
        }
        else if (computerGuess.equalsIgnoreCase("Even") && playerHand % 2 == 0)
        {
            computerMarbles = computerMarbles + computerMarbleWager * 2;
            // Then you must subtract that amount from the computers marbles
            playerMarbles = playerMarbles - computerMarbleWager;
            System.out.println("TEST computer got it right, computer marbles now " + computerMarbles);
            System.out.println("TEST player marbles is  now " + playerMarbles);
            computerGuess = "";
        }
        else if (computerGuess.equalsIgnoreCase("Even") && playerHand % 2 != 0)
        {
            playerMarbles = playerMarbles + computerMarbleWager;
            System.out.println("TEST computer is wrong, computer marbles now " + computerMarbles);
            System.out.println("TEST player marbles is now " + playerMarbles);
            computerGuess = "";
        }
        else if (computerGuess.equalsIgnoreCase("Odd") && playerHand % 2 == 0)
        {
            playerMarbles = playerMarbles + computerMarbleWager;
            System.out.println("TEST computer is wrong, computer marbles now " + computerMarbles);
            System.out.println("TEST player marbles is now " + playerMarbles);
            computerGuess = "";
        }
        else if (computerGuess.equalsIgnoreCase("Odd") && playerHand % 2 != 0)
        {
            computerMarbles = computerMarbles + computerMarbleWager * 2;
            // Then you must subtract that amount from the computers marbles
            playerMarbles = playerMarbles - computerMarbleWager;
            System.out.println("TEST computer got it right, computer marbles now " + computerMarbles);
            System.out.println("TEST player marbles is  now " + playerMarbles);
            computerGuess = "";
        }


    }

    public String toString() {
        return "Game{" +
                "computerMarbles=" + computerMarbles +
                ", playerMarbles=" + playerMarbles +
                '}';
    }
}
