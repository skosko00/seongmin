package kh.java.com;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GuiTest extends JFrame{


	
	private void start() {		
		
		JPanel p1 = new JPanel();
		JLabel lab1 = new JLabel("20~30대를 대상으로 진행하는 설문 입니다");
		JLabel nameLa = new JLabel("이름 : ");
		JLabel ageLa = new JLabel("나이 : ");
		JTextField nameTe = new JTextField(10);
		JTextField ageTe = new JTextField(10);
		JPanel p2 = new JPanel();
		JRadioButton sex1 = new JRadioButton("남성",false);
		JRadioButton sex2 = new JRadioButton("여성",false);
		JPanel p3 = new JPanel();
		JCheckBox chFood = new JCheckBox("음식",true);
		JCheckBox chMusic = new JCheckBox("음악",false);
		JCheckBox chTv = new JCheckBox("TV",false);
		JCheckBox chSport = new JCheckBox("운동",false);
		JCheckBox def = new JCheckBox("기타",false);
		JTextField def1 = new JTextField(10);
		JLabel def2 = new JLabel("기타사항");
		JPanel p4 = new JPanel(); 
		JTextArea area = new JTextArea(10,34);
		JButton button1 = new JButton("전송");
		JButton button2 = new JButton("취소");
		Container ct = getContentPane();
		
		p1.setSize(500,30);
		p1.setLocation(0,0);
		p1.add(lab1);
		this.add(p1);
		
		nameLa.setSize(50,15);
		nameLa.setLocation(130,50);
		this.add(nameLa);
		nameTe.setSize(50,15);
		nameTe.setLocation(170,50);
		this.add(nameTe);
		
		ageLa.setSize(50,15);
		ageLa.setLocation(240,50);
		this.add(ageLa);
		ageTe.setSize(50,15);
		ageTe.setLocation(280,50);
		this.add(ageTe);
		
		p2.setSize(500,80);
		p2.setLocation(0, 70);
		p2.setBorder(new TitledBorder("1번 당신의 성별은?"));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		ButtonGroup bg = new ButtonGroup();
		bg.add(sex1);
		bg.add(sex2);
		p2.add(sex1);
		p2.add(sex2);
		this.add(p2);
		
		p3.setSize(500,70);
		p3.setLocation(0, 160);
		p3.setBorder(new TitledBorder("2번 당신의 관심사는? (다중가선택 가능)"));
		p3.add(chFood);
		p3.add(chMusic);
		p3.add(chTv);
		p3.add(chSport);
		p3.add(def);
		p3.add(def1);		
		this.add(p3);
		
		def2.setSize(70,15);
		def2.setLocation(5,230);
		this.add(def2);
		
		p4.setSize(500,180);
		p4.setLocation(0, 250);
		p4.add(area);
		this.add(p4);
		
		button1.setSize(70, 30);
		button1.setLocation(100, 440);
		this.add(button1);
		
		button2.setSize(70, 30);
		button2.setLocation(300, 440);
		this.add(button2);
		
	}
	
	public GuiTest()
	{
		this.setSize(500, 500);
		this.setLayout(null);
		this.setTitle("설문조사");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("search.png"));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.start();	//사용자 정의 메소드
		this.setVisible(true);
		
	}
}
