package cm.vo;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.glass.events.WindowEvent;
import com.sun.prism.shader.DrawCircle_Color_AlphaTest_Loader;

import javafx.scene.shape.Path;
import kh.java.client.socket.ClientChat;
import kh.java.server.socket.ServerChat;

//----- 선범 ----- //
public class Paint extends JFrame{
	private JPanel paintPanel = new JPanel();
	private JPanel colorPanel = new JPanel();
	Graphics g = this.getGraphics();

	float bold = 3;
	Canvas canva;
	private static int last_x = 0;
	private static int last_y = 0;
	int writeY=0;
	
	JPanel[] paintcard = new JPanel[2];
	private static int a;
	private static int b;
	private static int c;
	private static int d;
	public static void setB(int b) {
		Paint.b = b;
	}



	private static int e;

	public static int getE() {
		return e;
	}
	public static int getA() {
		return a;
	}
	public static void setA(int a) {
		Paint.a = a;
	}
	public static void setE(int e) {
		Paint.e = e;
	}



	int isDraw = 2;

	public static int getC() {
		return c;
	}
	public static void setC(int c) {
		Paint.c = c;
	}
	public static int getD() {
		return d;
	}
	public static void setD(int d) {
		Paint.d = d;
	}

	public static String getTemp() {
		return temp;
	}
	public static String getTemp2() {
		return temp2;
	}



	private static String temp ="0|0|0";
	private static String temp2 ="0|0";

	public static int getLast_x() {
		return last_x;
	}
	public static void setLast_x(int last_x) {
		Paint.last_x = last_x;
	}
	public static int getLast_y() {
		return last_y;
	}
	public static  void setLast_y(int last_y) {
		Paint.last_y = last_y;
	}


	MyWriteCanvas can = new MyWriteCanvas();
	MyWriteCanvas can2 = new MyWriteCanvas();
	public Paint(int i)
	{
		this.setTitle("그림판 Ex");
		this.setLayout(new BorderLayout());
		this.setSize(600, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);




		if(i ==1)
		{
			this.PaintSetting();
			((CardLayout)(paintPanel.getLayout())).
			show(paintPanel, Integer.toString(1));
			this.ColorSetting();
			this.setVisible(true);
			thread serverThread = new thread("1");
			serverThread.start();



		}
		else if( i == 2)
		{
			this.PaintSetting();
			((CardLayout)(paintPanel.getLayout())).
			show(paintPanel, Integer.toString(2));
			this.ColorSetting();
			this.setVisible(true);
			thread clientThread = new thread("2");
			clientThread.start();

		}
	}
	public Paint()
	{
		//		this.setTitle("그림판 Ex");
		//		this.setLayout(new BorderLayout());
		//		this.setSize(600, 800);
		//		this.setResizable(false);
		//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//		this.PaintSetting();
		//		this.ColorSetting();
		//		
		//		this.setVisible(true);

	}


	public void PaintSetting()
	{
		this.add(paintPanel,BorderLayout.NORTH);
		paintPanel.setPreferredSize(new Dimension(600, 600));
		paintPanel.setLayout(new CardLayout());
		paintcard[0] = new JPanel();
		paintcard[1] = new JPanel();
		paintPanel.add(Integer.toString(1),paintcard[0]);
		paintPanel.add(Integer.toString(2),paintcard[1]);
			
		paintcard[0].add(can);
		paintcard[1].add(can2);
		
		
		can2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				while(true)
				{
//					System.out.println(a+" | "+b+" | "+c + " | " + d);
//					if(b==0)
//					{
//						last_x = c;
//						last_y = d;
//					}
					can2.Draw(a,b,c, d);
				
				
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		
		can.setBounds(10, 10, 580, 580);
		can2.setBounds(10,10,580,580);
		
		


	}

	
	public void ColorSetting()
	{
		this.add(colorPanel, BorderLayout.SOUTH);
		colorPanel.setBackground(Color.blue);
		colorPanel.setPreferredSize(new Dimension(600, 200));

	}


	public class MyWriteCanvas extends Canvas
	{		
		public MyWriteCanvas()
		{

		}
		public boolean mouseDown(Event e, int x, int y)
		{
			isDraw =1;
			last_x = x;
			last_y = y;
			
			temp2 = x+"|"+ y;
			temp = x+"|"+ y+"|"+isDraw;
			return true;
		}

		public boolean mouseDrag(Event e, int x, int y)
		{
			if(isDraw == 1)
			{
				Graphics g = this.getGraphics();
				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(new BasicStroke(bold));
				g.setColor(Color.BLACK);
				g.drawLine(last_x, last_y, x, y);
//				System.out.println(last_x + "|" + last_y +"|" + x + "|" + y);
				temp = x+"|"+ y+"|"+isDraw;
				temp2 = last_x +"|"+last_y;
				last_x = x;
				last_y = y;
				//			System.out.println(last_x + " | " + last_y);
			}
			return true;
			
		}
		public void Draw(int x1, int y1,int x2, int y2)
		{
			Graphics g = this.getGraphics();
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(bold));
			g.setColor(Color.BLACK);
			g.drawLine(x1, y1, x2, y2);
//			last_x = x1;
//			last_y = y1;
		}

	}

	


	public class MyReadCanvas extends Canvas
	{		

		//		public boolean mouseDown()
		//		{
		//			last_x = ClientChat.getLast_x2();
		//			System.out.println("받은 좌표");
		//			last_y = ClientChat.getLast_y2();
		//			
		//			return true;
		//		}
		//		

		public MyReadCanvas()
		{
			//			Graphics g = this.getGraphics();
			//			Graphics2D g2d = (Graphics2D) g;
			//			g2d.setStroke(new BasicStroke(bold));
			//			g.setColor(Color.BLACK);
			//			g.drawLine(last_x, last_y, ClientChat.getLast_x2(), ClientChat.getLast_y2());
			//			last_x = ClientChat.getLast_x2();
			//			last_y = ClientChat.getLast_y2();
			//			System.out.println("받은 좌표");

			//			Graphics g = this.getGraphics();
			//			Graphics2D g2d = (Graphics2D) g;
			//			g2d.setStroke(new BasicStroke(3));
			//			g.setColor(Color.BLACK);
			////			g.drawLine(arg0, arg1, arg2, arg3);
			//			g.drawLine(ClientChat.getPos_x2(), ClientChat.pos_y2, ClientChat.getLast_x2(), ClientChat.getLast_y2());
			//
			//			System.out.println("받은 좌표");

			//			this.mouseDrag();

		}

	}


	public class thread extends Thread
	{
		String str;
		public thread(String str)
		{
			this.str = str;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(str == "1")
			{
				new ServerChat();
			}
			else if(str == "2")
			{
				new ClientChat();
			}
		}
	}







}

