import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu1 frame = new menu1();
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
	public menu1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addBook ab = new addBook();
				ab.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnAddBook.setBounds(136, 308, 202, 45);
		contentPane.add(btnAddBook);
		
		JButton btnIssueBook = new JButton("Issue & Return");
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issueAndReturn iar = new issueAndReturn();
				iar.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnIssueBook.setBounds(136, 219, 202, 45);
		contentPane.add(btnIssueBook);
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBook sbook = new searchBook();
				sbook.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnSearchBook.setBounds(136, 136, 202, 45);
		contentPane.add(btnSearchBook);
		
		JLabel lblSelectAnOption = new JLabel("Main Menu");
		lblSelectAnOption.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSelectAnOption.setBounds(15, 52, 438, 45);
		contentPane.add(lblSelectAnOption);
		lblSelectAnOption.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWelcomeToLibdbms = new JLabel("Welcome to lib-dbms");
		lblWelcomeToLibdbms.setFont(new Font("Nirmala UI", Font.ITALIC, 18));
		lblWelcomeToLibdbms.setBounds(15, 16, 438, 20);
		contentPane.add(lblWelcomeToLibdbms);
		
		JButton btnEditBook = new JButton("Edit Book");
		btnEditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBook eb = new editBook();
				eb.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnEditBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnEditBook.setBounds(136, 396, 202, 45);
		contentPane.add(btnEditBook);
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeBook rb = new removeBook();
				rb.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnRemoveBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRemoveBook.setBounds(136, 481, 202, 45);
		contentPane.add(btnRemoveBook);
	}
}
