package kh.java.pcroom.server.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainView extends JFrame implements ActionListener, Runnable{
	ProductView pv = new ProductView();
	PcView pcv = new PcView();
	static String pcId;
	static String userId;
	static String userName;
	static String userPrice;
	static String userTime;
	
	private JPanel mainViewPanel = new JPanel();

	String str;
	private JPanel sideViewPanel = new JPanel();
	private JPanel menuBarViewPanel = new JPanel();
	private JPanel [] menuCards = new JPanel[3];
	private JPanel [] sideCards = new JPanel[3];
	private JLabel sVUserId = null;
	static JLabel sVPcId = null;

	int menuNumber = 1;
	public MainView(String str)
	{
		this.str = str;
	}
	public MainView() {
		setResizable(false);
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();

		this.setSize(1368, 768);
		setTitle("PC JUN SANG");

		this.mainView();
		this.sideView();
		this.menuBarView();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void mainView()
	{
		mainViewPanel.setBackground(Color.RED);
		getContentPane().add(mainViewPanel, BorderLayout.CENTER);
		mainViewPanel.setPreferredSize(new Dimension(1000, 610));
		mainViewPanel.setLayout(new CardLayout());
		for(int i=0;i<menuCards.length;i++)
		{
			menuCards[i] = new JPanel();
			menuCards[i].setPreferredSize(new Dimension(1000,610));
			mainViewPanel.add(Integer.toString((i+1)),menuCards[i]);
		}

		//		menuCards[0] = pv.getProductPanel();
		//		menuCards[0].setBackground(Color.YELLOW);
		//		mainViewPanel.add(Integer.toString((1)),menuCards[0]);
		//				menuCards[0].add(ProductView());
		menuCards[1].setBackground(Color.CYAN);
		menuCards[2].setBackground(Color.green);

		menuCards[0].setLayout(new GridLayout(5, 6,5,5));

		for(int i=0;i<30;i++) 
		{
			menuCards[0].add(pcv.button(i));
		}



		((CardLayout)(mainViewPanel.getLayout())).show(mainViewPanel,  Integer.toString(1));
	}

	public void sideView()
	{
		getContentPane().add(sideViewPanel, BorderLayout.WEST);
		sideViewPanel.setBackground(Color.BLUE);
		sideViewPanel.setPreferredSize(new Dimension(368, 610));
		sideViewPanel.setLayout(new CardLayout());
		//		sVPcId = new JLabel(Integer.toString(pcv.pcId));
		sVPcId = new JLabel(Integer.toString(pcv.pcId));

		for(int i=0;i<sideCards.length;i++)
		{
			sideCards[i] = new JPanel();
			sideCards[i].setPreferredSize(new Dimension(368,610));
			sideViewPanel.add(Integer.toString((i+1)),sideCards[i]);
		}
		sideCards[0].setBackground(Color.BLACK);
		sideCards[0].add(sVPcId);
		((CardLayout)(sideViewPanel.getLayout())).show(sideViewPanel,  Integer.toString(menuNumber));
		MainView te1 = new MainView("1");

		//		sVPcId.removeAll();
		//		sVPcId = new JLabel("!!!");
		//		sideCards[0].add(sVPcId);
		Thread t1 = new Thread(te1);
		t1.start();

		
	}

	// 메뉴바 뷰
	public void menuBarView()
	{

		menuBarViewPanel.setBackground(Color.DARK_GRAY);
		menuBarViewPanel.setPreferredSize(new Dimension(1368, 158));
		getContentPane().add(menuBarViewPanel, BorderLayout.NORTH);
		menuBarViewPanel.setLayout(null);

		JButton pcButton = new JButton("\uC88C\uC11D \uAD00\uB9AC");
		//		pcButton.setBorderPainted(false);		// 외곽선 제거
		//		pcButton.setContentAreaFilled(false);	// 내용 영역 채우기 안함
		//		pcButton.setFocusPainted(false);		// 선택(focus) 되었을때 테두리 사용 안함
		pcButton.setBounds(361, 78, 200, 80);
		menuBarViewPanel.add(pcButton);
		pcButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == pcButton)
				{
					((CardLayout)(mainViewPanel.getLayout())).show(mainViewPanel,  Integer.toString(1));
					menuNumber = 1;
				}
			}
		});

		JButton productButton = new JButton("\uC0C1\uD488 \uAD00\uB9AC");
		productButton.setBounds(562, 78, 200, 80);
		menuBarViewPanel.add(productButton);

		productButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == productButton)
				{
					((CardLayout)(mainViewPanel.getLayout())).show(mainViewPanel,  Integer.toString(2));
					menuNumber = 2;
				}
			}
		});

		JButton memberButton = new JButton("\uD68C\uC6D0 \uAD00\uB9AC");
		memberButton.setBounds(763, 78, 200, 80);
		menuBarViewPanel.add(memberButton);

		memberButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == memberButton)
				{
					((CardLayout)(mainViewPanel.getLayout())).show(mainViewPanel,  Integer.toString(3));
					menuNumber = 3;
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<30;i++)
		{
			if(e.getSource()==pcv.button(i))
			{
				((CardLayout)(sideViewPanel.getLayout())).show(sideViewPanel,  Integer.toString(i));
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			for(int i=0;i<30;i++)
			{
				if(pcv.pcId == (i+1))
				{
//					System.out.println(pcv.pcId);
					pcId = Integer.toString(pcv.pcId);
					System.out.println(pcId);
					//					sVPcId.setText(pcId);

					pcv.pcId = 0;
					
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
								if(pcId!=null)
								{
									MainView.sVPcId.setText(pcId);
									pcId=null;
								}
							}
						});

				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//			sVPcId.setText("!!!");
			//			if(pcId!=null)
			//			{
			//			sVPcId.remove(sideCards[0]);
			//			sVPcId = new JLabel(pcId);
			//			pcId=null;
			//			}
		}
	}


}
