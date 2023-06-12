import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//IDGenerator class which is used to produce unique ID's 
public class IDGenerator {
	
	public String generateRandomID () {
		
		//characters list containing all characters from a - z 
        List<Character> characters = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }

        //creates the uniqueID that is 5 characters in length 
        String randomString = "";
        for (int i = 0; i < 5; i++) {
        	//uses shuffle to avoid the possibility of duplicate uniqueID's for 2 or more different students
            Collections.shuffle(characters);
            randomString += characters.get(i);
        }

        return randomString;
	}
}