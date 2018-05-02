package kh.java.com.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MyFrame2 extends JFrame{
	// 스피너
	// 버튼
	// 출력
	
	// 스피너 모델 생성
	SpinnerModel numberModel = new SpinnerNumberModel(0, -100000, +100000, 1000);
	// 스피너 생성
	JSpinner spinner = new JSpinner(numberModel);
	
	// 버튼 생성
	JButton button = new JButton("출력");
	
	// 라벨 생성
	JLabel label = new JLabel("0");
	public void comInit()
	{
		spinner.setSize(new Dimension(350, 100));
		this.add(spinner,BorderLayout.CENTER);
		
		this.add(button,BorderLayout.SOUTH);
		this.add(label, BorderLayout.NORTH);
		
		label.setPreferredSize(new Dimension(400, 300));
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = spinner.getValue().toString();
				label.setText(data);
			}
		});
	}
	
	public MyFrame2()
	{
		
		this.setSize(400,400);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		comInit();
		this.setVisible(true);
	}
}
