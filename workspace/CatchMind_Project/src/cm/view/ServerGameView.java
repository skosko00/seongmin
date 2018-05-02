package cm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cm.controller.CreateGameMgr;

//----- �� �� ----- //
public class ServerGameView extends JFrame implements Runnable{

	private JPanel panelMember = null;							// ȸ�� �г�
	private JLabel userId1 = null;
	private JLabel userScore1 = null;
	private JLabel userImage1 = null;
	private ImageIcon userIconImage1 = null;
	private JLabel userId2 = null;
	private JLabel userScore2 = null;
	private JLabel userImage2 = null;
	private ImageIcon userIconImage2 = null;
	private JButton exit = null;
	private JPanel chatingPanel = null; 						// ä�� �г�

	private JTextArea chatPrint = new JTextArea(10,10);			// ä��â
	private JScrollPane chatScroll = new JScrollPane();			// ä��â (��ũ��)
	private JButton chatSend = null;							// ä�����۹�ư
	private JTextField chatInsert = new JTextField();			// ä���Է�
	private JPanel chatMenu = new JPanel();						// ä���Է�,���� ���� �г�
	private JPanel drawingPnael = null;

	

	private String sendMessage;
	private String getMessage;
	
	private JPanel grid = new JPanel();
	public ServerGameView() 
	{
		super("Catch Mind");
		this.setSize(1368,768);
		getContentPane().setLayout(new BorderLayout());

		panelMember = new JPanel();
		chatingPanel = new JPanel();
		setImage();
		panelMember();		
		chatingPanel();
		drawingPnael();

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
		
	}

	private void drawingPnael() {


	}
	
	public void getMessage(String getMessage) 
	{
		this.getMessage=getMessage;
		new Thread(this).start();
	}

	private void chatingPanel() {

		CreateGameMgr cgm = new CreateGameMgr(this);
		
		chatingPanel = new JPanel();
		chatingPanel.setPreferredSize(new Dimension(300, 610));
		chatingPanel.setLayout(null);

		// ä�� ��� â
		chatPrint.setLocation(0, 0);
		chatPrint.setSize(290,510);
		chatingPanel.add(chatPrint);
		chatingPanel.add(chatScroll);
		
		

		// ä�� �Է� ����
		chatMenu.setLayout(new BorderLayout());
		chatInsert.setSize(300,59);
		chatMenu.setSize(300,65);
		chatMenu.setLocation(0, 515);
		chatMenu.add(chatInsert,BorderLayout.CENTER);
		chatSend = new JButton("����");
		
		
		
		chatSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==chatSend)
				{
					sendMessage = chatInsert.getText();
					chatPrint.append(sendMessage+"\n");
					cgm.createGameMgr(sendMessage);
					chatInsert.setText("");
				}				
			}
		});

		chatInsert.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					sendMessage = chatInsert.getText();
					chatPrint.append(sendMessage+"\n");
					cgm.createGameMgr(sendMessage);
					chatInsert.setText("");
				}
			}
		});

		chatMenu.add(chatSend,BorderLayout.EAST);
		chatingPanel.add(chatMenu);

		getContentPane().add(chatingPanel, BorderLayout.EAST);
	}

	private void setImage() {
		userIconImage1 = new ImageIcon(new ImageIcon("rice.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		userIconImage2 = new ImageIcon(new ImageIcon("onion.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

	}

	private void panelMember()
	{		
		panelMember.setPreferredSize(new Dimension(1368, 150));
		panelMember.setLayout(null);
		panelMember.setBackground(Color.white);
		getContentPane().add(panelMember,BorderLayout.SOUTH);


		userId1 = new JLabel("userID1");
		userId1.setBounds(245, 33, 57, 15);
		panelMember.add(userId1);

		userScore1 = new JLabel("userScore1");
		userScore1.setBounds(245, 95, 70, 15);
		panelMember.add(userScore1);

		userImage1 = new JLabel();
		userImage1.setBounds(343, 14, 135, 107);
		userImage1.setIcon(userIconImage1);
		panelMember.add(userImage1);

		userId2 = new JLabel("userID2");
		userId2.setBounds(644, 33, 57, 15);
		panelMember.add(userId2);

		userScore2 = new JLabel("userScore2");
		userScore2.setBounds(644, 95, 88, 15);
		panelMember.add(userScore2);

		userImage2 = new JLabel();
		userImage2.setBounds(756, 14, 135, 107);
		userImage2.setIcon(userIconImage2);
		panelMember.add(userImage2);

		exit = new JButton("EXIT");
		exit.setBounds(1142, 78, 157, 48);
		panelMember.add(exit);				
	}

	@Override
	public void run() {
		while(true)
		{
			if(getMessage!=null)
			{
				chatPrint.append(getMessage+"\n");
			}
		}
		
	}
}
