package jsp.admin.model.vo;

import java.util.ArrayList;

import jsp.board.model.vo.BoardVo;
import jsp.member.model.vo.QuestionVo;

public class AdminIndexVo {
	private int countReserve;
	private int countQuestion;
	private int countNewMember;
	
	private ArrayList<BoardVo> boardList;
	private ArrayList<QuestionVo> questionList;
	public int getCountReserve() {
		return countReserve;
	}
	public void setCountReserve(int countReserve) {
		this.countReserve = countReserve;
	}
	public int getCountQuestion() {
		return countQuestion;
	}
	public void setCountQuestion(int countQuestion) {
		this.countQuestion = countQuestion;
	}
	public int getCountNewMember() {
		return countNewMember;
	}
	public void setCountNewMember(int countNewMember) {
		this.countNewMember = countNewMember;
	}
	public ArrayList<BoardVo> getBoardList() {
		return boardList;
	}
	public void setBoardList(ArrayList<BoardVo> boardList) {
		this.boardList = boardList;
	}
	public ArrayList<QuestionVo> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(ArrayList<QuestionVo> questionList) {
		this.questionList = questionList;
	}
	public AdminIndexVo(int countReserve, int countQuestion, int countNewMember, ArrayList<BoardVo> boardList,
			ArrayList<QuestionVo> questionList) {
		super();
		this.countReserve = countReserve;
		this.countQuestion = countQuestion;
		this.countNewMember = countNewMember;
		this.boardList = boardList;
		this.questionList = questionList;
	}
	public AdminIndexVo() {
		super();
	}
	@Override
	public String toString() {
		return "AdminIndexVo [countReserve=" + countReserve + ", countQuestion=" + countQuestion + ", countNewMember="
				+ countNewMember + ", boardList=" + boardList + ", questionList=" + questionList + "]";
	}
	
	

}
