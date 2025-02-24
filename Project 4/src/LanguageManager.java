// import needed imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A language Manager class that reads a language file, fills in arrays, and sorts them
 *  @author Bea Sauve
 *  @version 02-19-2025
 */
public class LanguageManager implements LanguageManagerInterface{
    //initialize language array
    private Language[] languages;

    /**
     * Language Manager constructor that reads the language file, compiles the information into arrays, and sorts the
     * language names
     * @param languageFile
     */
    public LanguageManager(File languageFile) {
        //Scan in the file
        Scanner scanLangFile;
        try {
            scanLangFile = new Scanner(languageFile);
            int languagesCount = scanLangFile.nextInt();         //retrieves the count at the top of the list
            scanLangFile.nextLine();                             //Skip the header
            scanLangFile.nextLine();
            languages = new Language[languagesCount];           //initialize array length of lang count
            for (int lang = 0; lang < languagesCount; lang++) {         //iterate trough each file line
                if (scanLangFile.hasNextLine()) {
                    String line = scanLangFile.nextLine();     //parse the words on each line and store parsed words
                    String[] parts = line.split(",");    //as 2d array
                    languages[lang] = new Language(parts[0], parts[1], Language.Type.valueOf(parts[2].toUpperCase()));
                }
            }
            //verify file can be ran
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        //test arrays appear properly
        System.out.println(Arrays.toString(languages));
        //close file
        scanLangFile.close();
    }

    /**
     * parses the number of languages/ lines in the language file
     * @return the number of languages in file
     */
    @Override
    public int getLanguageCount() {
        return languages.length;
    }

    /**
     * Method that returns the language listed in given index
     * @param index     position of the language
     * @return  The language located at that index
     */
    @Override
    public Language getLanguage(int index) {
        return languages[index];
    }

    /**
     * Method to find location of the shortest keyword among all keywords in all languages
     *
     * @return index of shortest keyword
     */
    @Override
    public int findShortestKwdLength() {
        int langIndex = 0;                                        //initiate index to store language index
        int shortestKwdLength = languages.length;                 //initiate index to large num, so variable can iterate down
        for (int lang = 0; lang < languages.length; lang++) {     //iterate through each language
            Language eachLang = languages[lang];                  //store each language array as eachLang
            if (eachLang != null && eachLang.getKwdCount() > 0) {  //skip files that are blank or null
                if (eachLang.getKwd(0).length() < shortestKwdLength) { //compare first index of keyword since its shortest
                    shortestKwdLength = eachLang.getKwd(0).length();
                    langIndex = lang;
                }
            }
        }
        return langIndex;
    }

    /**
     * Method to find location of the longest keyword among all keywords in all languages
     * @return index of longest keyword
     */
    @Override
    public int findLongestKwdLength() {
        int langIndex = 0;             //initiate index holding variable
        int longestKwdLength = 0;      //store largest keyword length
        for (int lang = 0; lang < languages.length; lang++) {
            Language eachLang = languages[lang];                   //store each language array as eachLang
            if (eachLang != null && eachLang.getKwdCount() > 0) {  //skip files that are blank or null
                if (eachLang.getKwd(eachLang.getKwdCount()-1).length() > longestKwdLength) { //look at last index since its longest
                    longestKwdLength = eachLang.getKwd(eachLang.getKwdCount()-1).length();
                    langIndex = lang;
                }
            }
        }
        return langIndex;
    }

    /**
     * Method to find the language that contains the fewest number of keywords
     * @return index of language with fewest keywords
     */
    @Override
    public int findLangWithFewestKwds() {
        if (languages.length != 0 ){
            for (int i = 0; i < languages.length; i++) {
                Language language = languages[i];
                //if keywords null, ignore
                //get count of keywords in each language
                //iterate throughout keyword counts, store lowest number, and language index
                //return language index
            }
        }
        return 0;
    }

    /**
     * Method to find the language that contains the most number of keywords
     * @return index of language with most keywords
     */
    @Override
    public int findLangWithMostKwds() {

            //if keywords null, ignore
            //get count of keywords in each language
            //iterate throughout keyword counts, store highest number, and language index
            //return language index
        return 0;
    }

    /**
     * Method to return an array of language indexes that contain the given keywords
     * @param keyword       keyword to search for
     * @return langIndex    an array of language indexes
     */
    @Override
    public int[] findLangKwdMatches(String keyword) {
        int[] langIndex = new int[languages.length];  //initiate a new array use lang len to store any num of indexes
        int index = 0;                                //initialize first index to begin storing index locations
        for (int lang = 0; lang < languages.length; lang++) {  //iterate through each language type
            for (int kwd = 0; kwd < languages[lang].getKwdCount(); kwd++) {   //iterate through each word in keyword array
                if (languages[lang].getKwd(kwd).equals(keyword)) {        //if iterated key is same as keyword
                langIndex[index++] = lang;}                            //store index location
            }
        }
        return langIndex;  //return language index array
    }

    /**
     * A method to find the number of languages that contain the given type
     * @param type          the type of language to search for
     * @return langIndex    An array of language indexes
     */
    @Override
    public int[] findLangsOfType(Language.Type type) {
        int[] langIndex = new int[languages.length];  //initiate a new array use lang len to store any num of indexes
        int index = 0;                                //initialize first index to begin storing index locations
        for (int i = 0; i < languages.length; i++) {
            if (languages[i].getType() == type) {      //search if array of lang index i contains type given
                langIndex[index++] = i;                //store index location if lang array contains type given
            }
        }
        return langIndex;                              //return the language indexes
    }

    /**
     * A method that returns the languages in alphabetical order
     */
    @Override
    public void sortLangs() {
        Arrays.sort(languages);
        System.out.println(Arrays.toString(languages));
    }
}




