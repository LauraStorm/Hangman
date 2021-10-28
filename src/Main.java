import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        FileReader1 fileReader = new FileReader1();
        int wrongGuessCount = 0;

        //Game intro
        hangmanGame.printHeadlineOfTheGame();

        //Read csv file
        fileReader.getWordsFromCSVFile();

        //Get random word to guess
        String wordToGuess = fileReader.getRandomWord();

        //Show word in underscores - status of how it's going with guessing the word
        String statusInGame = hangmanGame.getWordInUnderscoresStatus(wordToGuess);

        //The game mode//
        while (wrongGuessCount < 6 && !statusInGame.equals(wordToGuess)){
            //Get a letter guess from Player
            System.out.println("Word: " + statusInGame);
            String inputLetter = hangmanGame.getGuessFromPlayer();

            //Check if players guess (letter) is in the word
            if (wordToGuess.contains(inputLetter)){
                statusInGame = hangmanGame.getNewUpdatedStatusInUnderscores(wordToGuess, inputLetter, statusInGame);
            }
            else {
                System.out.println("Wrong guess..");
                wrongGuessCount++;
            }

            //Show letter that has been chosen
            hangmanGame.showLetterPlayerHasGuessed();
            System.out.println();
        }

        //Did player win or loose
        hangmanGame.showWinOrLose(wrongGuessCount,wordToGuess,statusInGame);

    }

}
