package com.kabhre.billingsystem.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class updateProducts extends JFrame {

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
					updateProducts frame = new updateProducts();
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
	public updateProducts() {
		setTitle("Update Products");
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
		lblNewLabel.setIcon(new ImageIcon(updateProducts.class.getResource("/images/update.png")));
		lblNewLabel.setBounds(181, 0, 80, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblViewProducts = new JLabel("Update Products");
		lblViewProducts.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewProducts.setBounds(271, 20, 334, 60);
		contentPane.add(lblViewProducts);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel= (DefaultTableModel)table.getModel();
				int row=table.getSelectedRow();
				Object id=table.getValueAt(row, 0);
				Object name=table.getValueAt(row, 1);
				Object rate=table.getValueAt(row, 2);
				Object category=table.getValueAt(row, 3);
				Object availability=table.getValueAt(row, 4);
				Object quantity=table.getValueAt(row, 5);
				addproducts ap=new addproducts();
				ap.pname.setText(name.toString());
				ap.rateTf.setText(rate.toString());
				ap.categoryComboBox.setSelectedItem(category);
				ap.availabilitycomboBox.setSelectedItem(availability);
				ap.quantityTf.setText(quantity.toString());
				ap.pidtextField.setText(id.toString());
				ap.setVisible(true);
				dispose();
				
				}
			
		});
		btnUpdate.setForeground(new Color(0, 255, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(330, 450, 110, 50);
		contentPane.add(btnUpdate);
		
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
