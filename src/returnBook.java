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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class returnBook extends JFrame {

	private JPanel contentPane;
	private JTextField textSID;
	private JTextField textBID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook frame = new returnBook();
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
	public returnBook() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK");
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReturnBook.setBounds(67, 16, 359, 40);
		contentPane.add(lblReturnBook);
		lblReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issueAndReturn iar = new issueAndReturn();
				iar.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setBounds(15, 16, 51, 40);
		contentPane.add(button);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID");
		lblEnterStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterStudentId.setBounds(15, 139, 152, 37);
		contentPane.add(lblEnterStudentId);
		
		textSID = new JTextField();
		textSID.setBounds(182, 136, 192, 40);
		contentPane.add(textSID);
		textSID.setColumns(10);
		
		JLabel lblEnterBookId = new JLabel("Enter Book ID");
		lblEnterBookId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterBookId.setBounds(15, 228, 152, 34);
		contentPane.add(lblEnterBookId);
		
		textBID = new JTextField();
		textBID.setBounds(182, 227, 192, 40);
		contentPane.add(textBID);
		textBID.setColumns(10);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{					
					String query = "update booklist set quantity=quantity+1 where bid=? and quantity >= 0";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textBID.getText());
					pst.execute();
					pst.close();
					query = "update student set bid=NULL where sid = ?";
					pst = connection.prepareStatement(query);
					pst.setString(1, textSID.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Returned");
					pst.close();
					textSID.setText("");
					textBID.setText("");
					}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnBook.setBounds(158, 324, 148, 50);
		contentPane.add(btnReturnBook);
	}

}
