import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class issueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textSID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issueBook frame = new issueBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public issueBook() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIssueBook = new JLabel("ISSUE BOOK");
		lblIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIssueBook.setBounds(61, 16, 365, 42);
		contentPane.add(lblIssueBook);
		lblIssueBook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issueAndReturn iar = new issueAndReturn();
				iar.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setBounds(15, 16, 51, 42);
		contentPane.add(button);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID");
		lblEnterStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterStudentId.setBounds(15, 137, 154, 40);
		contentPane.add(lblEnterStudentId);
		
		textSID = new JTextField();
		textSID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textSID.setBounds(184, 137, 192, 40);
		contentPane.add(textSID);
		textSID.setColumns(10);
		
		JLabel lblEnterBookId = new JLabel("Enter Book ID");
		lblEnterBookId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterBookId.setBounds(15, 229, 129, 40);
		contentPane.add(lblEnterBookId);
		
		JTextField textBID = new JTextField();
		textBID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textBID.setBounds(184, 229, 192, 40);
		contentPane.add(textBID);
		textBID.setColumns(10);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{					
					String query = "update booklist set quantity=quantity-1 where bid=? and quantity > 0";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textBID.getText());
					pst.execute();
					pst.close();
					query = "update student set bid=? where sid = ?";
					pst = connection.prepareStatement(query);
					pst.setString(1, textBID.getText());
					pst.setString(2, textSID.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Issued");
					pst.close();
					textSID.setText("");
					textBID.setText("");
					}
				catch(Exception e1){
					e1.printStackTrace();
				}
		}});
		btnIssueBook.setBounds(157, 325, 148, 54);
		contentPane.add(btnIssueBook);
	}
}
