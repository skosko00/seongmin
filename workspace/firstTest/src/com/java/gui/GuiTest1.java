package com.java.gui;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GuiTest1 extends JFrame{
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("메뉴1");
	private JMenuItem item1 = new JMenuItem("메뉴항목1");
	private JLabel label = new JLabel("메뉴와 버튼을 만들어보세요");
	private JButton button = new JButton("OK");
	
	public GuiTest1() 
	{
		super("Test");
		this.setLayout(new GridBagLayout());
		this.setSize(300,300);		
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.compInit();	
		this.setVisible(true);	
	}

	private void compInit() {
		menu1.add(item1);
		menuBar.add(menu1);
		this.setJMenuBar(menuBar);
		this.add(label);
		this.add(button);
		
	}
}
