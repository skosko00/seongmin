package kh.java.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class GuiTest extends JFrame implements ActionListener{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("����");
	private JMenu menu2 = new JMenu("�޴�2");
	private JMenuItem item1 = new JMenuItem("����");
	private JMenuItem item2 = new JMenuItem("����");
	private JMenuItem item3 = new JMenuItem("����");
	private JFileChooser jfc = new JFileChooser();
	
	
	public void comInit()
	{
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menuBar.add(menu1);
		menuBar.add(menu2);
		this.setJMenuBar(menuBar);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));	// Alt+O ����Ű
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.ALT_MASK));	// Alt+S ����Ű
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.ALT_MASK));	// Alt+X ����Ű
		
	}
	
	public GuiTest()
	{
		super("�޴�");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		comInit();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item1)
		{
			if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
			{
				String fileName = jfc.getSelectedFile().getName();
				System.out.println("������ ���� �̸� : "+fileName);
				String filePath = jfc.getSelectedFile().getPath();
				System.out.println("������ ���� ��� : "+filePath);
			}
		}else if(e.getSource()==item2)
		{
			if(jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
			{
				String fileName = jfc.getSelectedFile().getName();
				System.out.println(fileName+"������ ����Ǿ����ϴ�.");
			}
		}else if(e.getSource()==item3)
		{
			System.exit(0);
		}
		
	}
	
}