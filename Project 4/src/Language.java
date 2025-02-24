// import needed imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A Language class that reads files, creates keyword arrays, and sorts keywords alphabetically
 *
 * @author Bea Sauve
 * @version 02-19-2025
 */
public class Language implements LanguageInterface{

    //implement enum Type Variables
   public enum Type {COMPILED, INTERPRETED, SCRIPTING, NUMERICAL_ANALYSIS}

    //initiate variables
    private String name;
    private String filename;
    private Type type;
    private String[] keywords;

    /**
     * A method that loads keyword data and sorts arrays alphabetically
     * @param name      - the name of the language
     * @param filename  - the name of the file to call
     * @param type      -the type language of the language
     */
    public Language(String name, String filename, Type type) {
        //validate objects within the language method
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Language name cannot be null or empty");
        }
        try {
            this.type = Type.valueOf(type.toString().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Language type: " + type + ". Valid types are " + Arrays.toString(Type.values()));
        }
        //define the variables
        this.name = name;
        this.filename = filename;
        this.type = type;

        //define keywords
        keywords = new String[0];

        //Scan in filename test to see if file found, and assign contents of file to Keywords
        if (filename != null && !filename.isEmpty()) {
            File file = new File(filename);
            try {
                Scanner scanFile = new Scanner(file);
                int lineCount = scanFile.nextInt();
                if (lineCount > 0) {
                    keywords = new String[lineCount];
                    for (int i = 0; i < lineCount; i++) {
                        keywords[i] = scanFile.next();
                    }
                }
                //close file
                scanFile.close();
                //error if file not found
                }catch (FileNotFoundException e) {
                System.out.println("File not found: " + filename);
            }
            //test is keywords and functions work properly
           // System.out.println("Keywords: " + Arrays.toString(keywords));
           // System.out.println("Keyword Length: " + getKwdCount());
           // System.out.println("Shortest Word Length: " + findShortestKwdLength());
           // System.out.println("Longest Word Length: " + findLongestKwdLength()) ;
           // System.out.println(toString()) ;
            //sortKwds();
        }
    }

    /**
     * Retrieves the name of the language
     * @return      language name
     */
    public String getName(){
        return name;
    }

    /**
     * Retrieves the filename for keywords
     * @return      filename in which keywords do (or would) reside
     */
    public String getFilename(){
        return filename;
    }

    /**
     * Retrieves the typical implementation type for the language
     * @return      typical implementation type
     */
    public Type getType(){
        return type;
    };

    /**
     * Retrieves a count of keywords for the language
     * @return      count of keywords
     */
    public int getKwdCount(){
        return keywords.length;
    }

    /**
     * Retrieves the keyword at the specified index
     * @param index     index of the keyword; must be a valid index in the range 0 to count - 1
     * @return          keyword at the specified index in the list
     */
    public String getKwd(int index){
        return keywords[index];
    }

    /**
     * Retrieves the index associated with the specified keyword
     * @param keyword       keyword to search for
     * @return              index of keyword, or -1 if no match is found
     */
    public int findKwd(String keyword){
        int index = 0;
        for (int keyInt = 0; keyInt < getKwdCount(); keyInt++){
            if (keyword.equals(getKwd(keyInt))){
                index = keyInt;
            }
        }
        return index;
    }

    /**
     * determines the length of the shortest keyword in the keyword list
     * @return  length of the shortest keyword, or -1 if there are no keywords in the list
     */
    public int findShortestKwdLength(){
        int minLength = getKwd(0).length();
        if (getKwdCount() == 0)
            return -1;
        else{
            return minLength;
        }
    }

    /**
     * determines the length of the longest keyword in the keyword list
     * @return  length of the longest keyword, or -1 if there are no keywords in the list
     */
    public int findLongestKwdLength(){
        int maxLength = getKwd(getKwdCount()-1).length();
        if (getKwdCount() == 0)
            return -1;
        else{
            return maxLength;
        }
    }

    /**
     * Retrieves a representation of basic language information
     * @return      string representation of the language
     */
    @Override
    public String toString(){
        return String.format("Language Name: %s \n Filename: %s \n Language Type: %s \n Keywords: %s \n" ,
                name, filename, type, Arrays.toString(keywords));
    }

    /**
     * Sorts keywords alphabetically (case-sensitive).  Implements an Insertion Sort adapted from the
     *      code given in class (see slides on Sorting).
     */
    public void sortKwds(){
        Arrays.sort(keywords);
        System.out.println("Keywords: " + Arrays.toString(keywords));
    }
    
}