package kh.java.pcroom.server.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

import kh.java.pcroom.server.controll.PCMgr;

public class PcView extends JFrame implements ActionListener{

	PCMgr pcM = new PCMgr(); 

	private JToggleButton [] btnList = new JToggleButton[30];
	static int pcId=0;
	static String userId;
	static String userName;
	static String userPrice;
	static String userTime;
	private ButtonGroup bg = new ButtonGroup();
	

	public JToggleButton button(int index) 
	{
		return btnList[index];
	}

	public PcView()
	{
		

		
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		
		SetButton();

	}

	public void SetButton()
	{
		for(int i=0; i<btnList.length; i++)
		{
			btnList[i] = new JToggleButton(Integer.toString(i+1));
			bg.add(btnList[i]);
			
		}
		for(int i=0; i<30; i++)
		{
			btnList[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<btnList.length;i++)
		{
			if(e.getSource()==btnList[i])
			{
				pcId = pcM.pcId(i);
//				userId = "a"+(i+1);
			}
		}
		


	}

	



}