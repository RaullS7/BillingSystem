package com.kabhre.billingsystem.practice;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class deleteProducts extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteProducts frame = new deleteProducts();
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
	public deleteProducts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(deleteProducts.class.getResource("/images/delet.png")));
		lblNewLabel.setBounds(181, 0, 80, 100);
		contentPane.add(lblNewLabel);
		
		JLabel lblViewProducts = new JLabel("Delete Products");
		lblViewProducts.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewProducts.setBounds(271, 20, 334, 60);
		contentPane.add(lblViewProducts);
		
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
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
				int row=table.getSelectedRow();
				Object obj=tableModel.getValueAt(row,0);
				int id=Integer.parseInt(obj.toString());
				Billing bill= new ProductsImpl();
				int status=JOptionPane.showConfirmDialog(deleteProducts.this,"delete","Do you really want to delete ?",JOptionPane.YES_NO_OPTION);
				if (status==0) {
				bill.deleteProducts(id);
				loadDatainTable();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(330, 450, 110, 50);
		contentPane.add(btnNewButton);
		
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
