package kh.java.com;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventTest extends JFrame{
	private JButton button = new JButton("눌러보세요");
	private JButton button2 = new JButton("누르지마세요");

	private void compInit()
	{
		this.add(button);
		this.add(button2);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
					JOptionPane.showMessageDialog(null, "눌러졌음");
				}				
			}
		});	
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button2)
				{
					JOptionPane.showMessageDialog(null, "두번째 버튼");
				}				
			}
		});
	}

	public EventTest()
	{
		super("Event");
		this.setLayout(new FlowLayout());	// 레이아웃 매니저 설정
		this.setSize(450,300);		// 프레임 사이즈
		this.setLocationRelativeTo(null);	// 중앙에 위치
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// X버튼 클릭시 종료
		this.compInit();	// 사용자 정의 메소드
		this.setVisible(true);	// 가시적으로 보여주어라

	}
}
