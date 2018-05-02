package kh.java.com;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventTest extends JFrame{
	private JButton button = new JButton("����������");
	private JButton button2 = new JButton("������������");

	private void compInit()
	{
		this.add(button);
		this.add(button2);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
					JOptionPane.showMessageDialog(null, "��������");
				}				
			}
		});	
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button2)
				{
					JOptionPane.showMessageDialog(null, "�ι�° ��ư");
				}				
			}
		});
	}

	public EventTest()
	{
		super("Event");
		this.setLayout(new FlowLayout());	// ���̾ƿ� �Ŵ��� ����
		this.setSize(450,300);		// ������ ������
		this.setLocationRelativeTo(null);	// �߾ӿ� ��ġ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// X��ư Ŭ���� ����
		this.compInit();	// ����� ���� �޼ҵ�
		this.setVisible(true);	// ���������� �����־��

	}
}
