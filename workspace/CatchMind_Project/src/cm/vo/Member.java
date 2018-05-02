package cm.vo;

import java.awt.image.BufferedImage;

//----- มุ นฮ ----- //
public class Member {
	private String id;
	private String pw;
	private String nickName;
	private BufferedImage character ;
	
	public Member() {}
	public Member(String id,String pw,String nickName,BufferedImage character)
	{
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.character = character;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String Pw) {
		this.pw = Pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public BufferedImage getCharacter() {
		return character;
	}
	public void setCharacter(BufferedImage character) {
		this.character = character;
	}
}
