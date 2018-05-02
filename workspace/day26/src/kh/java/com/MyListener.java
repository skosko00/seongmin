package kh.java.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyListener implements ActionListener{
	private JButton button = null;
	private JButton button2 = null;
	public MyListener(JButton button, JButton button2)
	{
		this.button = button;
		this.button2 = button2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton sourceButton = (JButton)e.getSource();
		if(sourceButton == button)
		{
		JOptionPane.showMessageDialog(null, "알림창");
		}else if(sourceButton == button2)
		{
			System.out.println("두번쨰 버튼입니다.");
		}
		
	}

}
