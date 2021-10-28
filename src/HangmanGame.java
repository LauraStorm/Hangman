import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Character> lettersPlayerHasGuessed = new ArrayList<Character>();

    //Methods
    public void printHeadlineOfTheGame (){
        System.out.println("-------------------------------");
        System.out.println("         HANGMAN GAME          ");
        System.out.println("-------------------------------");
        System.out.println("             •••               ");
        System.out.println("   Hope you are ready to play  ");
        System.out.println("Remember - you have only 6 lives!");
        System.out.println("          Good luck            ");
        System.out.println("             •••               ");

    }

    public String getGuessFromPlayer(){
        System.out.println("Please write a letter: ");
        String inputLetter = scanner.nextLine();
        lettersPlayerHasGuessed.add(inputLetter.charAt(0));

        return inputLetter;
    }

    public String getWordInUnderscoresStatus(String wordToGuess){
        String status = "";

        for (int i = 0; i < wordToGuess.length(); i++) {
            status = status + "_" ;

        }
        return status;
    }

    public void showLetterPlayerHasGuessed(){
        System.out.println("User guesses: " + lettersPlayerHasGuessed);
    }

    public String getNewUpdatedStatusInUnderscores (String wordToGuess, String inputLetter, String statusInGame){
        StringBuilder newStatus = new StringBuilder(statusInGame);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if(String.valueOf(wordToGuess.charAt(i)).equals(inputLetter)){
                newStatus.setCharAt(i, wordToGuess.charAt(i));
            }
        }
        statusInGame = newStatus.toString();
         return statusInGame;
    }

    public void getWinOrLose (int wrongGuessCount, String wordToGuess, String statusInGame){
        System.out.println("             •••               ");
        if (wrongGuessCount == 6){
            System.out.println("Sorry you died...😩\nThe word was: " + wordToGuess);
        }

        if (statusInGame.equals(wordToGuess)){
            System.out.println("YAY - Congrats 🥳! You win!\nThe Word was: " + wordToGuess);
        }
        System.out.println("             •••               ");
    }












}
