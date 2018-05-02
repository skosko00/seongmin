package kh.java.com;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiTest extends JFrame implements ActionListener{
	private JButton ls = new JButton("<<");
	private JButton lts = new JButton("<");
	private JButton rts = new JButton(">");
	private JButton rs = new JButton(">>");
	private JButton exit = new JButton("����");
	private JPanel northPanel = new JPanel();	// north ���� �г�
	private JPanel centerPanel = new JPanel();	// center ���� �г�
	private JPanel [] cards = new JPanel[7];	// ������ �����ϴ� �г��� ����
	private int cardNumber = 1;

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==ls)
		{
			cardNumber = 1;
		}else if(e.getSource()==lts)
		{
			if(cardNumber>1)
			cardNumber--;
		}else if(e.getSource()==rts)
		{
			if(cardNumber<7)
			cardNumber++;
		}else if(e.getSource()==rs)
		{
			cardNumber = 7;
		}else if(e.getSource()==exit)
		{
			System.exit(0);
		}
		// ī�带 ���� �� �ִ� ���̾ƿ��� CardLayout
		((CardLayout)centerPanel.getLayout()).show(centerPanel, Integer.toString(cardNumber));
	}	

	public void northPanel()
	{
		northPanel.setPreferredSize(new Dimension(430, 40));
		// null Layout�� setSize
		// ���̾ƿ� �Ŵ��������� setPreferredSize
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,35,5));
		northPanel.add(ls);
		northPanel.add(lts);
		northPanel.add(rts);
		northPanel.add(rs);
		northPanel.add(exit);

		// �� ��ư�� ���� ������ ����
		ls.addActionListener(this);
		lts.addActionListener(this);
		rts.addActionListener(this);
		rs.addActionListener(this);
		exit.addActionListener(this);
	}

	public void centerPanel()
	{
		centerPanel.setLayout(new CardLayout());
		for(int i=0; i<cards.length;i++)
		{
			cards[i] = new JPanel();
			centerPanel.add(Integer.toString(i+1), cards[i]);
		}
		cards[0].setBackground(Color.RED);
		cards[1].setBackground(Color.ORANGE);
		cards[2].setBackground(Color.YELLOW);
		cards[3].setBackground(Color.GREEN);
		cards[4].setBackground(Color.BLUE);
		cards[5].setBackground(Color.WHITE);
		cards[6].setBackground(Color.LIGHT_GRAY);		
	}

	private void compInit() 
	{	
		northPanel();
		centerPanel();
		this.add(northPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
	}

	public GuiTest()
	{
		super("CardLayout Test");	// this.setTitle("CardLayout Test") �� ����
		this.setLayout(new BorderLayout(5,5));	// ���̾ƿ� �Ŵ��� ����
		this.setSize(450,300);		// ������ ������
		this.setLocationRelativeTo(null);	// �߾ӿ� ��ġ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// X��ư Ŭ���� ����
		this.compInit();	// ����� ���� �޼ҵ�
		this.setVisible(true);	// ���������� �����־��
	}
}











