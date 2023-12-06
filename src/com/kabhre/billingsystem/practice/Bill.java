package com.kabhre.billingsystem.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.management.modelmbean.ModelMBean;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Button;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField categorytextField;
	private JTextField priceTextField;
	private JTextField quantitiTextField;
	private JTable table;
	JTextArea billTextArea;
	int total;
	int billPrice;
	int grndTotal;
	JLabel grndTotall;
	int availability;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bill() {
		setTitle("Create Bill");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Bill.class.getResource("/images/bill.png")));
		lblNewLabel.setBounds(228, 0, 80, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenerateBill = new JLabel("Generate Bill");
		lblGenerateBill.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblGenerateBill.setBounds(318, 20, 334, 60);
		contentPane.add(lblGenerateBill);
		
		JLabel lblNewLabel_1 = new JLabel(" Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 136, 100, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Category");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(120, 136, 100, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(240, 136, 100, 39);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Quantity");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(360, 136, 100, 39);
		contentPane.add(lblNewLabel_1_1_2);
		
		nametextField = new JTextField();
		nametextField.setBackground(new Color(255, 255, 255));
		nametextField.setEditable(false);
		nametextField.setBounds(10, 180, 96, 35);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		categorytextField = new JTextField();
		categorytextField.setBackground(new Color(255, 255, 255));
		categorytextField.setEditable(false);
		categorytextField.setColumns(10);
		categorytextField.setBounds(120, 180, 96, 35);
		contentPane.add(categorytextField);
		
		priceTextField = new JTextField();
		priceTextField.setBackground(new Color(255, 255, 255));
		priceTextField.setEditable(false);
		priceTextField.setColumns(10);
		priceTextField.setBounds(240, 180, 100, 35);
		contentPane.add(priceTextField);
		
		quantitiTextField = new JTextField();
		quantitiTextField.setColumns(10);
		quantitiTextField.setBounds(360, 180, 100, 35);
		contentPane.add(quantitiTextField);
		
		JButton btnNewButton = new JButton("Add to Bill");
		btnNewButton.addMouseListener(new MouseAdapter() {
			int i=0;
			@Override
			public void mouseClicked(MouseEvent e) {	
			if(nametextField.getText().isEmpty() || categorytextField.getText().isEmpty() || quantitiTextField.getText().isEmpty() || priceTextField.getText().isEmpty() )
			{	
				JOptionPane.showMessageDialog(btnNewButton, "Form Incomplete");
			}
			else if(availability<=Integer.valueOf(quantitiTextField.getText())) {
				JOptionPane.showMessageDialog(btnNewButton, "Not Enough Stock");
			}
			else {
				i++;
				total= billPrice * Integer.valueOf(quantitiTextField.getText());
				grndTotal=total+grndTotal;

				if(i==1) {
				billTextArea.setText(billTextArea.getText()+"                         >>>MeroKicks<<<\n"+"\n"+
						"  Name      Category      Quantity      Price      TOTAL\n"+" "+nametextField.getText()+"    "+categorytextField.getText()+"             "+quantitiTextField.getText()+"         "+priceTextField.getText()+"       "+total+"\n");
				}
				else{
					billTextArea.setText(billTextArea.getText()+" "+nametextField.getText()+"    "+categorytextField.getText()+"             "+quantitiTextField.getText()+"         "+priceTextField.getText()+"       "+total+"\n");
			}
				grndTotall.setText("Rs "+grndTotal);
			}
			}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(94, 241, 150, 40);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setToolTipText("");
		table.setBounds(10, 131, 770, 292);
		contentPane.add(table);
		
		String[]columns= {"Id","Name","Rate","Category","Availability","Quantity"};
		DefaultTableModel tableModel=new DefaultTableModel(columns,0);
		table.setModel(tableModel);
		loadDatainTable();
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
				int row=table.getSelectedRow();
				nametextField.setText(tableModel.getValueAt(row, 1).toString());
				categorytextField.setText(tableModel.getValueAt(row, 3).toString());
				priceTextField.setText(tableModel.getValueAt(row, 2).toString());
				availability =Integer.valueOf(tableModel.getValueAt(row, 5).toString());
				billPrice =Integer.valueOf(tableModel.getValueAt(row,2).toString());

				
				
				
				
			}
		});
		
		scrollPane.setBounds(10, 302, 642, 268);
		contentPane.add(scrollPane);
		
		billTextArea = new JTextArea();
		billTextArea.setEditable(false);
		billTextArea.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		billTextArea.setBounds(705, 10, 451, 503);
		contentPane.add(billTextArea);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametextField.setText("");
				categorytextField.setText("");
				priceTextField.setText("");
				quantitiTextField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(318, 241, 100, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Print");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					billTextArea.print();
				}catch(Exception ex){
					
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(705, 535, 100, 35);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(900, 535, 57, 39);
		contentPane.add(lblNewLabel_1_2);
		
		grndTotall = new JLabel("");
		grndTotall.setFont(new Font("Tahoma", Font.BOLD, 20));
		grndTotall.setBounds(958, 535, 100, 39);
		contentPane.add(grndTotall);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new form().setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Bill.class.getResource("/images/home.png")));
		btnNewButton_4.setBounds(1106, 525, 50, 50);
		contentPane.add(btnNewButton_4);
	}

	private void loadDatainTable() {
		Billing bill=new ProductsImpl();
		ArrayList<ProductsDto> productList=bill.GetDatafromDb();
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(ProductsDto productsDto: productList) {
		tableModel.addRow(new Object[] {
				productsDto.getId(),productsDto.getName(),productsDto.getRate(),productsDto.getCategory(),productsDto.getAvailability(),productsDto.getQuantity()
		});

		}		
	}
}
