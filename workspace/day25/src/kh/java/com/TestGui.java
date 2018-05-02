package kh.java.com;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGui extends JFrame{
	private JButton button1 = new JButton("버튼1");
	private JButton button2 = new JButton("버튼2");
	private JButton button3 = new JButton("버튼3");
	private JButton button4 = new JButton("버튼4");
	private JButton button5 = new JButton("버튼5");
	
	public void comInt()
	{
		this.setLayout(new GridLayout(5,1));
		
		
		this.add(button1,BorderLayout.WEST);
		this.add(button2,BorderLayout.EAST);
		this.add(button3,BorderLayout.NORTH);
		this.add(button4,BorderLayout.SOUTH);
		this.add(button5,BorderLayout.CENTER);
	}
	
	public TestGui()
	{
		this.setSize(500, 500);
//		this.setLayout(null);
		this.setTitle("설문조사");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("search.png"));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.comInt();	//사용자 정의 메소드
		this.setVisible(true);
	}
}
