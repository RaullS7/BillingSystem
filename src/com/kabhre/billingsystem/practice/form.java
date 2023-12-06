package com.kabhre.billingsystem.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setResizable(false);
		setTitle("Billing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Billing System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(250, 67, 299, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnAddproduct = new JButton("");
		btnAddproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new addproducts().setVisible(true);
			
			}
		});
		btnAddproduct.setIcon(new ImageIcon(form.class.getResource("/images/add-icon.png")));
		btnAddproduct.setBounds(77, 189, 111, 100);
		contentPane.add(btnAddproduct);
		
		JLabel lblNewLabel_1 = new JLabel("Add Products");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(87, 285, 101, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new updateProducts().setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(form.class.getResource("/images/update.png")));
		btnNewButton.setBounds(344, 189, 111, 100);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Update Products");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(343, 285, 125, 37);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new deleteProducts().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(form.class.getResource("/images/delet.png")));
		btnNewButton_1.setBounds(487, 189, 111, 100);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Table().setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(form.class.getResource("/images/view.png")));
		btnNewButton_2.setBounds(208, 189, 111, 100);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Bill().setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(form.class.getResource("/images/bill.png")));
		btnNewButton_3.setBounds(627, 189, 111, 100);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("View Products");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(212, 285, 103, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Delete Products");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(489, 285, 115, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Create Bill");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(648, 285, 90, 37);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(form.class.getResource("/images/exit.png")));
		btnNewButton_4.setBounds(755, 353, 50, 50);
		contentPane.add(btnNewButton_4);

	}
}
