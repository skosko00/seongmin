package kh.java.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class GuiTest extends JFrame implements ActionListener{

	private JButton fileOpen = new JButton("���Ͽ���");
	private JButton fileSave = new JButton("��������");
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
				System.out.println("������ ���� : "+	fc.getSelectedFile().getName());
				System.out.println("��� : "+fc.getSelectedFile().getPath());
			}
		}
		else if(e.getSource()==fileSave)
		{
			JFileChooser fc = new JFileChooser();
			int choiceValue = fc.showSaveDialog(this);
			if(choiceValue==JFileChooser.APPROVE_OPTION)
			{
				System.out.println("������ ���� : "+fc.getSelectedFile().getName());
			}
		}
	}
	public GuiTest() 
	{
		this.setSize(500,500);
		//		this.setLocation(710, 250);
		//		this.setLayout(new FlowLayout());
		this.setLayout(null);
		this.setTitle("����");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("calc.png"));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.comInit();	//����� ���� �޼ҵ�
		this.setVisible(true);

	}	

	public GuiTest(int width, int height, int operation, boolean b)
	{
		this.setSize(width, height);
		this.setDefaultCloseOperation(operation);	
		this.setVisible(b);	
	}
}
