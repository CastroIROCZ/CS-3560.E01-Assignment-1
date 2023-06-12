import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Question class which configures a question type (single or multiple choice) and sets the answer choices based on the previous determination
public class Question {
	public String question;
	public char questionType;
	List<String> options = new ArrayList<>();

	
	public void configureQuestion() {
		//random generator that is set to generate char values of a or b
		Random questionTypeSelector = new Random();
		setQuestionType((char) ('a' + questionTypeSelector.nextInt(2)));
		
		//if else branch that sets the question depending on what type of question the random generator determined
		if(getQuestionType() == 'a') {
			setQuestionSingleChoice();
			setQuestionSingleChoiceOptions();
		}
		else {
			setQuestionMultipleChoice();
			setQuestionMultipleChoiceOptions();
		}
	}

	//configures the question to the single choice question
	public void setQuestionSingleChoice() {
		this.question = "How many moons does Mars have?";

	}
	
	//configures the answers for the single choice question
	public void setQuestionSingleChoiceOptions() {
		options.clear();
		this.options.add("A. 1 Moon");
		this.options.add("B. 3 Moons");
		this.options.add("C. 2 Moons");
		this.options.add("D. 5 Moons");
	}
	
	//configures the question to the multiple choice question
	public void setQuestionMultipleChoice() {
		this.question = "What are Cal Poly Pomona's colors?";

	}
	
	//configures the answers for the multiple choice question
	public void setQuestionMultipleChoiceOptions() {
		options.clear();
		this.options.add("A. Yellow");
		this.options.add("B. Red");
		this.options.add("C. Green");
		this.options.add("D. Purple");
	}
	
	//returns the options for the question
	public List<String> getQuestionChoiceOptions() {
		return options;
	}
	
	//returns the question
	public String getQuestion() {
		return question;
	}
	
	//takes in a char of a or b, a represents single choice question and b represents multiple choice question
	public void setQuestionType(char type) {
		this.questionType = type;
	}
	
	//returns the question type (a for single choice, b for multiple choice)
	public char getQuestionType() {
		return questionType;
	}
	
	
}
