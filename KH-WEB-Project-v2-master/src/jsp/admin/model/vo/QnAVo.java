package jsp.admin.model.vo;

import jsp.member.model.vo.QuestionVo;

public class QnAVo {
	private QuestionVo qv;
	private AnswerVo asv;
	public QuestionVo getQv() {
		return qv;
	}
	public void setQv(QuestionVo qv) {
		this.qv = qv;
	}
	public AnswerVo getAsv() {
		return asv;
	}
	public void setAsv(AnswerVo asv) {
		this.asv = asv;
	}
	public QnAVo(QuestionVo qv, AnswerVo asv) {
		super();
		this.qv = qv;
		this.asv = asv;
	}
	public QnAVo() {
		super();
	}
	@Override
	public String toString() {
		return "QnAVo [qv=" + qv + ", asv=" + asv + "]";
	}
}
