package kh.java.com.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame{
	// 컬럼명
	String [] columnsNames = {"이름","나이","주소"};

	// 데이터 생성
	// 데이터는 2차원 Object 타입으로 생성	
	Object [][] data = {
			{"홍길동","20","경기도 부천"},
			{"김말똥","30","서울시 관악"},
			{"고길똥","40","제주도 서귀포"}
	};

	// 모델 생성(데이터,컬럼명)
	DefaultTableModel model = new DefaultTableModel(data,columnsNames) {
		@Override
		public boolean isCellEditable(int row, int colum)
		{
			return false;
		}
	};

	// JTable 생성(모델)
	JTable table = new JTable(model);

	// JScrollPane 생성 (table)
	JScrollPane scrollPane = new JScrollPane(table);

	JPanel frameCenterPane = new JPanel();
	JPanel frameSouthPane = new JPanel();

	JPanel FSPFirstPane = new JPanel();
	JPanel FSPSecondPane = new JPanel();

	JLabel name = new JLabel("이름 : ");
	JLabel age = new JLabel("나이 : ");
	JLabel addr = new JLabel("주소 : ");

	JTextField nameTF = new JTextField();
	JTextField ageTF = new JTextField();
	JTextField addrTF = new JTextField();

	JButton updateButton = new JButton("수정");
	JButton deleteButton = new JButton("삭제");
	JButton insertButton = new JButton("추가");

	public void panelSetting()
	{
		//		frameCenterPane.setBackground(Color.red);
		frameCenterPane.setLayout(new BorderLayout());
		frameCenterPane.add(scrollPane);




		frameSouthPane.setBackground(Color.blue);
		frameSouthPane.setPreferredSize(new Dimension(0, 100));
		frameSouthPane.setLayout(new BorderLayout());

		//		FSPFirstPane.setBackground(Color.yellow);
		FSPFirstPane.setPreferredSize(new Dimension(190, 0));
		FSPFirstPane.setLayout(new GridLayout(1, 3));
		FSPFirstPane.add(updateButton);
		FSPFirstPane.add(deleteButton);
		FSPFirstPane.add(insertButton);

		//		FSPSecondPane.setBackground(Color.green);		
		FSPSecondPane.setLayout(new GridLayout(3, 2));
		FSPSecondPane.add(name);
		FSPSecondPane.add(nameTF);
		FSPSecondPane.add(age);
		FSPSecondPane.add(ageTF);
		FSPSecondPane.add(addr);
		FSPSecondPane.add(addrTF);

		frameSouthPane.add(FSPFirstPane,BorderLayout.EAST);
		frameSouthPane.add(FSPSecondPane,BorderLayout.CENTER);

		this.add(frameCenterPane,BorderLayout.CENTER);
		this.add(frameSouthPane,BorderLayout.SOUTH);
	}

	public MyFrame()
	{
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		comInit();
	}

	private void comInit() {
		panelSetting();

		table.addMouseListener(new MouseListener() {

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

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String name = (String) table.getValueAt(row, 0);
				String age = (String) table.getValueAt(row, 1);
				String addr = (String) table.getValueAt(row, 2);
				
				nameTF.setText(name);
				ageTF.setText(age);
				addrTF.setText(addr);
			}
		});

		insertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTF.getText();
				String age = ageTF.getText();
				String addr= addrTF.getText();
				Object [] data = {name,age,addr};
				if(name.length()!=0&&age.length()!=0&&addr.length()!=0)
					model.addRow(data);
			}
		});
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row!=-1)
				{
				table.setValueAt(nameTF.getText(), row, 0);
				table.setValueAt(ageTF.getText(), row, 1);
				table.setValueAt(addrTF.getText(), row, 2);
				table.clearSelection();
				}
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row!=-1)
				{
				model.removeRow(row);
				table.clearSelection();
				nameTF.setText("");
				ageTF.setText("");
				addrTF.setText("");
				}
			}
		});
	}
}
