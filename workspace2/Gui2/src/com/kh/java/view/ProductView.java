package com.kh.java.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

import com.kh.java.controller.ProductController;
import com.kh.java.model.vo.Product;

public class ProductView extends JFrame{

	String [] columnsNames = {"product_id","p_name","price","description"};

	DefaultTableModel model = new DefaultTableModel(columnsNames, 0) {
		@Override
		public boolean isCellEditable(int row, int colum)
		{
			return false;
		}
	};

	JTable table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);

	JPanel frameCenterPane = new JPanel();
	JPanel frameEastPane = new JPanel();

	JRadioButton idRadio = new JRadioButton("ProductID",true);
	JRadioButton nameRadio = new JRadioButton("ProductName",false);

	JButton allChart = new JButton("목록 보기");

	JTextField selectTF = new JTextField(20);
	JButton search = new JButton("검색");

	JLabel details = new JLabel("--- 상세 보기 ---"); 
	JLabel idLabel = new JLabel("상품 ID : ");
	JTextField idTF = new JTextField(10);
	JLabel nameLabel = new JLabel("상 품 명 : ");
	JTextField nameTF = new JTextField(10);
	JLabel priceLabel = new JLabel("가    격 : ");

	SpinnerModel numberModel = new SpinnerNumberModel(100000, -10000, +10000000, 10000);

	JLabel desLabel = new JLabel("상품설명 : ");
	TextArea desArea = new TextArea(10,10);
	JSpinner spinner = new JSpinner(numberModel);
	JButton insertButton = new JButton("추가");
	JButton updateButton = new JButton("수정");
	JButton deletebutton = new JButton("삭제");
	String id;
	
	private void fisrtView()	// JTable 화면창
	{
		ArrayList<Product> list = new ProductController().fisrtView();

		for(int i=0; i<list.size();i++)
		{
			model.addRow(new Object[] {list.get(i).getProductId(),
					list.get(i).getPName(),
					list.get(i).getPrice(),
					list.get(i).getDescription()
			});
		}
	}

	private void panelSetting() {	// 패널셋팅
		frameCenterPane.add(scrollPane);

		frameEastPane.setPreferredSize(new Dimension(330, 400));

		fisrtView();

		getContentPane().add(frameCenterPane,BorderLayout.CENTER);
		getContentPane().add(frameEastPane, BorderLayout.EAST);
		frameEastPane.setLayout(null);

		ButtonGroup bg = new ButtonGroup();
		bg.add(idRadio);
		bg.add(nameRadio);

		idRadio.setBounds(6,18,85,15);
		frameEastPane.add(idRadio);
		nameRadio.setBounds(95,18,103,15);
		frameEastPane.add(nameRadio);

		allChart.setBounds(206,14,95,23);
		frameEastPane.add(allChart);

		selectTF.setBounds(13,59,197,23);
		frameEastPane.add(selectTF);

		search.setBounds(213,59,78,23);
		frameEastPane.add(search);

		details.setBounds(97, 98, 102, 15);
		frameEastPane.add(details);
		idLabel.setBounds(6, 151, 57, 15);
		frameEastPane.add(idLabel);

		idTF.setBounds(75, 148, 199, 21);
		frameEastPane.add(idTF);		

		nameLabel.setBounds(6, 188, 57, 15);
		frameEastPane.add(nameLabel);

		nameTF.setBounds(75, 185, 199, 21);
		frameEastPane.add(nameTF);

		priceLabel.setBounds(6, 233, 57, 15);
		frameEastPane.add(priceLabel);

		spinner.setBounds(95, 223, 160, 40);
		frameEastPane.add(spinner);

		desLabel.setBounds(6, 274, 67, 15);
		frameEastPane.add(desLabel);

		desArea.setBounds(75, 271, 199, 50);
		frameEastPane.add(desArea);

		insertButton.setBounds(12, 329, 85, 23);
		frameEastPane.add(insertButton);

		updateButton.setBounds(113, 329, 85, 23);
		frameEastPane.add(updateButton);

		deletebutton.setBounds(216, 329, 85, 23);
		frameEastPane.add(deletebutton);


	}

	public ProductView()
	{
		this.setSize(820, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		comInit();
	}
	private void comInit() {	// 버튼 동작
		panelSetting();
		allChart.addActionListener(new ActionListener() {	//목록 보기

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==allChart)
				{
					ArrayList<Product> list = new ProductController().allChart();
					model.getDataVector().removeAllElements();
					for(int i=0; i<list.size();i++)
					{
						model.addRow(new Object[] {list.get(i).getProductId(),
								list.get(i).getPName(),
								list.get(i).getPrice(),
								list.get(i).getDescription()
						});
					}
				}

			}
		});
		table.addMouseListener(new MouseListener() {	//테이블 클릭

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
				id = (String) table.getValueAt(row, 0);
				String name = (String) table.getValueAt(row, 1);
				int price = (int) table.getValueAt(row, 2);
				String des = (String) table.getValueAt(row, 3);

				idTF.setText(id);
				nameTF.setText(name);
				spinner.setValue(price);
				desArea.setText(des);
			}
		});

		insertButton.addActionListener(new ActionListener() {	//추가 버튼

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==insertButton)
				{
					Product p = new Product();
					p.setProductId(idTF.getText());
					p.setPName(nameTF.getText());
					p.setPrice((int)spinner.getValue());
					p.setDescription(desArea.getText());
					int result = new ProductController().insert(p);
					if(result>0)
					{
						model.addRow(new Object [] {p.getProductId(),
								p.getPName(),
								p.getPrice(),
								p.getDescription()
						});	
						JOptionPane.showMessageDialog(null, "추가되었습니다");
					}
				}

			}
		});

		updateButton.addActionListener(new ActionListener() {	//수정 버튼

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(e.getSource()==updateButton)
				{
					Product p = new Product();
					p.setProductId(idTF.getText());					
					p.setPName(nameTF.getText());
					p.setPrice((int)spinner.getValue());
					p.setDescription(desArea.getText());
					int result = new ProductController().update(p, id);
					if(result>0)
					{
						table.setValueAt(p.getProductId(), row, 0);
						table.setValueAt(p.getPName(), row, 1);
						table.setValueAt(p.getPrice(), row, 2);
						table.setValueAt(p.getDescription(), row, 3);
					}
				}
			}
		});

		deletebutton.addActionListener(new ActionListener() {	//삭제 버튼

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(e.getSource()==deletebutton)
				{
					Product p = new Product();
					p.setProductId(idTF.getText());					
					p.setPName(nameTF.getText());
					p.setPrice((int)spinner.getValue());
					p.setDescription(desArea.getText());
					int result = new ProductController().delete(p);
					if(result>0)
					{
						model.removeRow(row);
					}
				}
			}
		});
		search.addActionListener(new ActionListener() {	//검색버튼

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==search)
				{
					String connection;
					if(idRadio.isSelected())
					{
						connection = "id";
					}
					else
					{
						connection = "name";
					}
					String select = selectTF.getText();

					ArrayList<Product> list = new ProductController().search(connection,select);
					model.getDataVector().removeAllElements();
					if(list!=null)
					{
						System.out.println("값있음");
						for(int i=0; i<list.size();i++)
						{
							model.addRow(new Object[] {list.get(i).getProductId(),
									list.get(i).getPName(),
									list.get(i).getPrice(),
									list.get(i).getDescription()
							});
						}
					}else
					{
						JOptionPane.showMessageDialog(null, "일치하는 항목이 없습니다.");
					}

				}
			}

		});

	}
}
