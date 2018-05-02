package kh.java.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyEventTest extends JFrame implements KeyListener{
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JLabel upKey,downKey,leftKey,rightKey;
	private ImageIcon upKeyImage = null;
	private ImageIcon downKeyImage = null;
	private ImageIcon leftKeyImage = null;
	private ImageIcon rightKeyImage = null;
	private ImageIcon useUpkeyImage = null;
	private ImageIcon usedownkeyImage = null;
	private ImageIcon useleftkeyImage = null;
	private ImageIcon userightkeyImage = null;
	private ImageIcon mainRyan = null;
	private ImageIcon upRyan = null;
	private ImageIcon downRyan = null;
	private ImageIcon leftRyan = null;
	private ImageIcon rightRyan = null;
	private JLabel mainLabel = new JLabel();

	public void setImage()
	{
		upKeyImage = new ImageIcon(new ImageIcon("north.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		downKeyImage = new ImageIcon(new ImageIcon("south.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		leftKeyImage = new ImageIcon(new ImageIcon("west.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		rightKeyImage = new ImageIcon(new ImageIcon("east.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		useUpkeyImage = new ImageIcon(new ImageIcon("north2.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		usedownkeyImage = new ImageIcon(new ImageIcon("south2.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		useleftkeyImage = new ImageIcon(new ImageIcon("west2.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		userightkeyImage = new ImageIcon(new ImageIcon("east2.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		mainRyan = new ImageIcon(new ImageIcon("ryan.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		upRyan = new ImageIcon(new ImageIcon("image1.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)); 
		downRyan = new ImageIcon(new ImageIcon("image2.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		leftRyan = new ImageIcon(new ImageIcon("image3.gif").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		rightRyan = new ImageIcon(new ImageIcon("image4.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
	}

	public void setPanel1()
	{
		panel1.setPreferredSize(new Dimension(290, 290));		
		mainLabel.setIcon(mainRyan);
		panel1.add(mainLabel);
		this.add(panel1,BorderLayout.CENTER);
	}

	public void setPanel2()
	{
		upKey = new JLabel();
		downKey = new JLabel();
		leftKey = new JLabel();
		rightKey = new JLabel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
		panel2.setPreferredSize(new Dimension(290, 70));
		upKey.setIcon(upKeyImage);
		downKey.setIcon(downKeyImage);
		leftKey.setIcon(leftKeyImage);
		rightKey.setIcon(rightKeyImage);	
		panel2.add(leftKey);
		panel2.add(upKey);
		panel2.add(downKey);
		panel2.add(rightKey);
		this.add(panel2,BorderLayout.SOUTH);

	}

	public void comInit()
	{
		setImage();
		setPanel1();
		setPanel2();
	}

	public KeyEventTest()
	{
		super("라이언 춤추기");
		this.setSize(315,410);
		this.setLayout(new BorderLayout());
		comInit();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP :
			upKey.setIcon(useUpkeyImage);
			mainLabel.setIcon(upRyan);
			break;
		case KeyEvent.VK_DOWN : 
			downKey.setIcon(usedownkeyImage);
			mainLabel.setIcon(downRyan);
			break;
		case KeyEvent.VK_LEFT : 
			leftKey.setIcon(useleftkeyImage);
			mainLabel.setIcon(leftRyan);
			break;
		case KeyEvent.VK_RIGHT : 
			rightKey.setIcon(userightkeyImage); 
			mainLabel.setIcon(rightRyan);
			break;
		}		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP : upKey.setIcon(upKeyImage); break;
		case KeyEvent.VK_DOWN : downKey.setIcon(downKeyImage); break;
		case KeyEvent.VK_LEFT : leftKey.setIcon(leftKeyImage); break;
		case KeyEvent.VK_RIGHT : rightKey.setIcon(rightKeyImage); break;
		}		
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
}
