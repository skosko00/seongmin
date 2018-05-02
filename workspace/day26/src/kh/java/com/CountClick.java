package kh.java.com;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountClick extends JFrame{
	private JButton increButton = new JButton("숫자 증가");
	private JButton initButton = new JButton("초기화");
	private JLabel label = new JLabel("count");
	private JLabel countLabel = null;
	private JFrame myFrame = this;
	
	private int count = 0;
	public void comImit()
	{
		this.add(label);
		countLabel = new JLabel(Integer.toString(count));
		countLabel.setFont(new Font("Serif",Font.BOLD,100));
		this.add(countLabel);
		this.add(increButton);
		this.add(initButton);
		increButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==increButton)
					{
					count++;
					countLabel.setText(Integer.toString(count));
					}				
			}
		});
		initButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==initButton)
				{
					count=0;
					countLabel.setText(Integer.toString(count));
					myFrame.remove(initButton);
					repaint();
				}
				
			}
		});
	}
	
	public CountClick()
	{
		super("카운트 증가 프로그램");
		this.setSize(270, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		comImit();
	}
	
}
