import java.util.*;

//VotingService class which displays the question, choices, as well as takes in all the responses 
public class VotingService {
    private Map<String, List<Character>> studentResponses = new HashMap<>();
    private Map<Character, Integer> choiceCounts = new HashMap<>();

    //Displays the question, choices, and results
    public void display(Question question) {
        System.out.println(question.getQuestion());
        
        //for loop that displays the answer choices
        for (String choice : question.getQuestionChoiceOptions()) {
            System.out.println(choice);
        }
        
        //for loop that displays the results
        System.out.println("The results from the poll are:");
        for (Map.Entry<Character, Integer> entry : choiceCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //method that handles the submission of all the students answers 
    public void submitAnswer(String studentID, List<Character> studentAnswer) {
    	//if a student were to resubmit their answer the if loop checks if their ID already exists within the hashmap
        if (studentResponses.containsKey(studentID)) {
            List<Character> previousResponse = studentResponses.get(studentID);
            for (Character answer : previousResponse) {
                decrementChoiceCount(answer); //if the student uniqueID is already in the hashmap it calls on decrementChoiceCount to decrement the previous results
            }
        }

        studentResponses.put(studentID, studentAnswer); //student's answer(s) are added to the map

        for (Character answer : studentAnswer) { //keeps track of the answer count 
            incrementChoiceCount(answer);
        }
    }

    //increments the choice count 
    private void incrementChoiceCount(Character choice) { 
        choiceCounts.put(choice, choiceCounts.getOrDefault(choice, 0) + 1);
    }
    
    //if needed decrements the choice count 
    private void decrementChoiceCount(Character choice) {
        if (choiceCounts.containsKey(choice)) {
            int count = choiceCounts.get(choice);
            if (count == 1) {
                choiceCounts.remove(choice);
            } else {
                choiceCounts.put(choice, count - 1);
            }
        }
    }
}