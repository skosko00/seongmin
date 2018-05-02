package cm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cm.controller.JoinGameMgr;

//----- �� �� ----- //
public class JoinGameView extends JFrame implements Runnable
{
	JoinGameMgr jgm = new JoinGameMgr();

	private JButton send = new JButton("�����ϱ�");
	private JButton cancel = new JButton("���");
	private JTextField ipAddr = new JTextField();
	private JTextField portAddr = new JTextField();
	private JLabel ipLabel = new JLabel("IP��ȣ �Է� : ");
	private JLabel portLabel = new JLabel("��Ʈ��ȣ �Է� : ");

	private int portNumber =0;
	private String ipNumber=null;

	public void JoinButton()
	{
		// IP �Է� 
		ipLabel.setSize(100,100);
		ipLabel.setLocation(34, 102);
		ipAddr.setSize(200,50);
		ipAddr.setLocation(122, 128);
		// Port �Է�
		portLabel.setLocation(24, 162);
		portLabel.setSize(100,100);
		portAddr.setLocation(122, 188);
		portAddr.setSize(200, 50);

		// ����, ��� ��ư
		cancel.setBounds(195, 386, 183, 50);
		send.setBounds(8, 386, 183, 50);

		getContentPane().add(ipAddr);
		getContentPane().add(ipLabel);
		getContentPane().add(portAddr);
		getContentPane().add(portLabel);
		getContentPane().add(send);
		getContentPane().add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new LoginView();				
			}
		});

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{	if(e.getSource()==send) {
				ipNumber=ipAddr.getText();
				portNumber=Integer.parseInt(portAddr.getText());
				click();
				new Thread(new ClientGameView()).start();
			}
			}
		});

	}
	public void click()
	{
		new Thread(this).start();
	}
	public JoinGameView()
	{
		super("���� ����");
		getContentPane().setLayout(null);
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JoinButton();
		this.setVisible(true);
	}

	@Override
	public void run() 
	{
		jgm.joinGame(ipNumber, portNumber);
	}
}
