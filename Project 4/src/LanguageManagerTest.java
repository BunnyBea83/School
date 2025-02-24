import java.io.File;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class LanguageManagerTest {
    File languagefile = new File("languages.txt");
    LanguageManager languageManager = new LanguageManager(languagefile);

    /**
     * Test language count returns correct value
     */
    @Test
    public void testLanguageCount(){
        LanguageManager languageManager = new LanguageManager(new File("languages.txt"));
        int result = languageManager.getLanguageCount();
        assertEquals(27,result);

    }

    /**
     * Test to see if Get Language returns the proper language for the given index
     */
    @Test
    public void testGetLanguage(){
        LanguageManager languageManager = new LanguageManager(new File("languages.txt"));
        assertEquals("C++,cplusplus.txt,Compiled" ,languageManager.getLanguage(3));
    }
}