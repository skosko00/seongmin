package kh.java.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GuiTest extends JFrame implements ActionListener{

	private JButton fileOpen = new JButton("파일열기");
	private JButton fileSave = new JButton("파일저장");
	public void comInit()
	{
		fileOpen.setSize(100, 50);
		fileOpen.setLocation(100, 100);		
		this.add(fileOpen);
		fileSave.setSize(100, 50);
		fileSave.setLocation(200, 100);
		this.add(fileSave);
		fileOpen.addActionListener(this);
		fileSave.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fileOpen)
		{
			JFileChooser fc = new JFileChooser();
			int choiceValue = fc.showOpenDialog(this);
			if(choiceValue==JFileChooser.APPROVE_OPTION)
			{
				System.out.println("선택한 파일 : "+	fc.getSelectedFile().getName());
				System.out.println("경로 : "+fc.getSelectedFile().getPath());
			}
		}
		else if(e.getSource()==fileSave)
		{
			JFileChooser fc = new JFileChooser();
			int choiceValue = fc.showSaveDialog(this);
			if(choiceValue==JFileChooser.APPROVE_OPTION)
			{
				System.out.println("저장한 파일 : "+fc.getSelectedFile().getName());
			}
		}
	}
	public GuiTest() 
	{
		this.setSize(500,500);
		//		this.setLocation(710, 250);
		//		this.setLayout(new FlowLayout());
		this.setLayout(null);
		this.setTitle("계산기");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("calc.png"));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.comInit();	//사용자 정의 메소드
		this.setVisible(true);

	}	

	public GuiTest(int width, int height, int operation, boolean b)
	{
		this.setSize(width, height);
		this.setDefaultCloseOperation(operation);	
		this.setVisible(b);	
	}
}
