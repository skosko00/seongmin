package kh.java.pcroom.server.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProductView extends JFrame{
	private JPanel productPanel = new JPanel();
	public JPanel getProductPanel() {
		panelSetting();
		return productPanel;
	}
	public ProductView()
	{
//		setResizable(false);
//		
//		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
//		
//		this.setSize(1000, 610);
//		setTitle("PC JUN SANG");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setVisible(true);
	}
	public void panelSetting()
	{
		productPanel.setBackground(Color.black);
//		getContentPane().add(productPanel, BorderLayout.CENTER);
		productPanel.setPreferredSize(new Dimension(1000, 610));
	}
}
