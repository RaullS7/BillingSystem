package com.kabhre.billingsystem.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class addproducts extends JFrame {

	public JPanel contentPane;
	public JTextField pidtextField;
	public JTextField pname;
	public JTextField rateTf;
	public JTextField quantityTf;
	JComboBox categoryComboBox;
	JComboBox availabilitycomboBox;
	JButton btnSubmit;
	Billing bill=new ProductsImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addproducts frame = new addproducts();
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
	public addproducts() {
		setTitle("Add Products");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 559);
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
		btnBack.setBounds(10, 466, 126, 46);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Add Products");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(289, 29, 300, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(addproducts.class.getResource("/images/add-icon.png")));
		lblNewLabel_1.setBounds(199, 10, 80, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(118, 145, 100, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(118, 195, 126, 40);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Rate");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(118, 245, 126, 40);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Category");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(118, 295, 159, 40);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Availability");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3_1.setBounds(118, 345, 159, 40);
		contentPane.add(lblNewLabel_2_3_1);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=pname.getText();
				int rate=Integer.parseInt(rateTf.getText());
				String category=(String) categoryComboBox.getSelectedItem();
				String availavility=(String)availabilitycomboBox.getSelectedItem();
				int quantity=Integer.parseInt(quantityTf.getText());
				
				ProductsDto pdo=new ProductsDto();
				pdo.setName(name);
				pdo.setRate(rate);
				pdo.setCategory(category);
				pdo.setAvailability(availavility);
				pdo.setQuantity(quantity);
				String id=pidtextField.getText();
				
				if(id==null || id.isEmpty()) {
					
					bill.AddProducts(pdo);
				
				}else {
					pdo.setId(Integer.parseInt(id));
					bill.updateProducts(pdo);
				}
				dispose();
				new updateProducts().setVisible(true);
				}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(289, 458, 100, 40);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new form().setVisible(true);
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(439, 458, 100, 40);
		contentPane.add(btnCancel);
		
		pidtextField = new JTextField();
		pidtextField.setEditable(false);
		pidtextField.setBounds(289, 152, 70, 35);
		contentPane.add(pidtextField);
		pidtextField.setColumns(10);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(289, 200, 250, 35);
		contentPane.add(pname);
		
		rateTf = new JTextField();
		rateTf.setColumns(10);
		rateTf.setBounds(289, 250, 250, 35);
		contentPane.add(rateTf);
		
		categoryComboBox = new JComboBox();
		categoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Nike ", "Adidas", "Puma", "Converse"}));
		categoryComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		categoryComboBox.setBounds(289, 300, 100, 35);
		contentPane.add(categoryComboBox);
		
		availabilitycomboBox = new JComboBox();
		availabilitycomboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		availabilitycomboBox.setModel(new DefaultComboBoxModel(new String[] {"Available", "Out of Stock"}));
		availabilitycomboBox.setBounds(289, 350, 110, 35);
		contentPane.add(availabilitycomboBox);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Quantity");
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3_1_1.setBounds(118, 400, 159, 40);
		contentPane.add(lblNewLabel_2_3_1_1);
		
		quantityTf = new JTextField();
		quantityTf.setColumns(10);
		quantityTf.setBounds(289, 402, 100, 35);
		contentPane.add(quantityTf);
		
		
	}
}
