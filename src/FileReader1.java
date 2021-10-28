import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class FileReader1 {

    static Random random = new Random();
    static ArrayList<String> words = new ArrayList<String>();

    //Methods
    public void getWordsFromCSVFile (){
        File wordFile = new File("ressources/words.csv");

        try {
            Scanner sc = new Scanner(wordFile);
            while (sc.hasNextLine()){
                String line = sc.nextLine();                        //Læser hver linje i filen med ord
                String word = line.toLowerCase(Locale.ROOT);

                words.add(word);                            //Tilføjer ordene til ArrayList

            }

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
            e.printStackTrace();
        }
    }

    public String getRandomWord (){
        int randomIndexFromList = random.nextInt(words.size());
        String randomWord = words.get(randomIndexFromList);
        return randomWord;
    }


}
