import java.util.*;

//Student class which generates the student's unique ID and configures the student's answers 
public class Student {
	public Random rnd = new Random();
	private String studentID;
	private List<Character> studentAnswer = new ArrayList<>();
	
	public void configureStudent(Question type, VotingService vote) {
		IDGenerator ID = new IDGenerator();
		setStudentID(ID.generateRandomID());  //calls on IDGenerator to generate a unique ID for the student 
		
		studentAnswer.clear(); //ensures the list that will hold the student's answer is empty and ready to take in a new set of answers 
		
		configureAnswer(type.getQuestionType()); //configures the student's answer 
		vote.submitAnswer(getStudentID(), getStudentAnswer()); //submits the student's answer to the VotingService 
	}
	
	public void configureAnswer(char type) {
		//if else branch, if a the student will only have one randomly generated answer 
	    if (type == 'a') {
	        setStudentAnswer((char) ('A' + rnd.nextInt(4)));
	    }
	    
	    //else if b the student will have a randomly generated number of answers which are also randomly generated 
	    else if (type == 'b'){
	        Set<Character> answers = new HashSet<>(); //Set to ensure the student does not generate duplicate answers 
	        while (answers.size() < rnd.nextInt(1,5)) {
	            answers.add((char) ('A' + rnd.nextInt(4)));
	        }
	        for (char answer : answers) {
	            setStudentAnswer(answer);
	        }
	    }
	}

	//set student's ID
	public void setStudentID (String ID) {
		this.studentID = ID;
	}
	
	//returns student's ID
	public String getStudentID() {
		return studentID;
	}
	
	//sets the student's answer(s)
	public void setStudentAnswer(char answer) {
		this.studentAnswer.add(answer);
	}
	
	//returns the list containing the student's answer(s)
	public List<Character> getStudentAnswer() {
		return studentAnswer;
	}

}
