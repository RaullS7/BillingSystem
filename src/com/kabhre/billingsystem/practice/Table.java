package com.kabhre.billingsystem.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Table extends JFrame {

	private JPanel contentPane;
	JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
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
	public Table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new form().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(10, 452, 126, 46);
		contentPane.add(btnBack);
		
		table = new JTable();
		table.setToolTipText("");
		table.setBounds(10, 131, 770, 292);
		contentPane.add(table);
		
		String[]columns= {"Id","Name","Rate","Category","Availability","Quantity"};
		DefaultTableModel tableModel=new DefaultTableModel(columns,0);
		table.setModel(tableModel);
		loadDatainTable();
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(10, 97, 793, 308);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Table.class.getResource("/images/view.png")));
		lblNewLabel.setBounds(181, 0, 80, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblViewProducts = new JLabel("View Products");
		lblViewProducts.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewProducts.setBounds(271, 20, 300, 60);
		contentPane.add(lblViewProducts);
		
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
