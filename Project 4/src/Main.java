/**
 * A Main class to run the language manager
 *  @author Bea Sauve
 *  @version 02-19-2025
 */
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //new Language("Java","java.txt", Language.Type.COMPILED );  //test language class
        File languagefile = new File("languages.txt");      //initiate language file

        LanguageManager languageManager = new LanguageManager(languagefile);
        System.out.println(languageManager.getLanguage(1));
        System.out.println("Lang with fewest keywords: " + languageManager.findLangWithFewestKwds());
        System.out.println("Lang with longest keyword length: " + languageManager.findLongestKwdLength());
        System.out.println("Lang with shortest keyword length: " + languageManager.findShortestKwdLength());


    }

}
