package com.java.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiTest2 extends JFrame{
	private JTextField jTf1 = new JTextField(10);
	private JTextField jTf2 = new JTextField(10);
	private JButton button = new JButton("+");
	private JLabel label = new JLabel("Result : ");


	
	public GuiTest2()
	{
		super("°è»ê±â");
		this.setLayout(new GridLayout(0,1,5,2));
		this.setSize(300,300);		
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.compInit();	
		this.setVisible(true);	
	}

	private void compInit() {
		this.add(jTf1);		
		this.add(jTf2);		
		this.add(button);
		this.add(label);
		
		jTf1.setText("123");
		
		String a = jTf1.getText();
		int num = Integer.parseInt(a);
		
				
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
					
					label.setText("Result : "+(Integer.valueOf(jTf1.getText())+Integer.valueOf(jTf2.getText())));
				}
				
			}
		});
		
		
		
		
	}
}
