package cm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cm.controller.CreateGameMgr;

//----- �� �� ----- //
public class CreateGameView extends JFrame implements Runnable{
	CreateGameMgr cgm = new CreateGameMgr();
	
	
	private JButton send = new JButton("�游���");
	private JButton cancel = new JButton("���");
	private JTextField portAddr = new JTextField();
	private JLabel portLabel = new JLabel("��Ʈ��ȣ �Է� : ");
	int portNumber=0;
	
	
	
	public void CreateButton()
	{
		portLabel.setLocation(24, 162);
		portLabel.setSize(100,100);
		portAddr.setLocation(122, 188);
		portAddr.setSize(200, 50);
		cancel.setBounds(195, 386, 183, 50);
		send.setBounds(8, 386, 183, 50);
		getContentPane().add(portAddr);
		getContentPane().add(portLabel);
		getContentPane().add(send);
		getContentPane().add(cancel);
		
		send.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				portNumber=Integer.parseInt(portAddr.getText());
				click();				
				ServerGameView sgv = new ServerGameView();
				
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginView();
			}
		});
	}
	public void click()
	{
		System.out.println("Ŭ��.");
		new Thread(this).start();
	}
	
	public CreateGameView()
	{
		super("�游���");
		getContentPane().setLayout(null);
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		CreateButton();
		this.setVisible(true);
	}

	@Override
	public void run() {
		cgm.createGame(portNumber);
	}




}
