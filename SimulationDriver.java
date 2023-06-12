import java.util.Random;

public class SimulationDriver {
	
	//main method driver that starts the entire simulation
	public static void main(String[] args) {
		//Random generator to configure a random number of students between 5 - 15 
		Random rand = new Random();
		int numOfStudents = rand.nextInt(5,16);
		System.out.println(numOfStudents + " students took part in the poll");
		
		Question question = new Question();
		Student student = new Student();
		VotingService vote = new VotingService();
		
		//configures the question type, question, and the choices
		question.configureQuestion();
		
		//for loop that configures each student generated 
		for (int i = 0; i < numOfStudents; ++i) {
			student.configureStudent(question, vote);
		}
		
		//displays the poll
		vote.display(question);
		
	}

}
