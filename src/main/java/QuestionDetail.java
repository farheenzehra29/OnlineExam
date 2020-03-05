public class QuestionDetail
{
	private String[] answerOptions;
	private String correctAnswer;
	private String question;
	

	public QuestionDetail()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionDetail(String question, String[] answerOptions, String correctAnswer)
	{
		super();
		this.answerOptions = answerOptions;
		this.correctAnswer = correctAnswer;
		this.question = question;
	}
	public String[] getAnswerOptions()
	{
		return answerOptions;
	}
	public void setAnswerOptions(String[] answerOptions)
	{
		this.answerOptions = answerOptions;
	}
	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer)
	{
		this.correctAnswer = correctAnswer;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}

}
