package kh.java.pcroom.server.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCMgr extends Thread{

	static int pcId=0;
	static String userId;
	static String userName;
	static String userPrice;
	static String userTime;
	
	public PCMgr() {}
	
	public PCMgr(int pcId, String userName)
	{
		
	}
	
	public void login(String userName, String pwd)
	{
		
	}
	
	public int pcId(int i) {
		pcId = (i+1);
		return pcId;
	}
	
	public void memberInfo(int i)
	{
		
	}
	
}
