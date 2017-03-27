import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class removeBook extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTextField textAuthor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeBook frame = new removeBook();
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
	public removeBook() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveBook = new JLabel("REMOVE BOOK");
		lblRemoveBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRemoveBook.setBounds(67, 16, 339, 40);
		contentPane.add(lblRemoveBook);
		lblRemoveBook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu1 menu1 = new menu1();
				menu1.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setBounds(15, 16, 51, 40);
		contentPane.add(button);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(85, 193, 69, 37);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(85, 122, 69, 37);
		contentPane.add(lblId);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAuthor.setBounds(85, 270, 69, 37);
		contentPane.add(lblAuthor);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textID.setBounds(169, 119, 146, 40);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textName.setBounds(169, 190, 146, 40);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textAuthor.setBounds(169, 267, 146, 40);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "delete from booklist where bid='"+textID.getText()+"' OR Name='"+textName.getText()+"'OR Author='"+textAuthor.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Removed.");
					pst.close();
					textID.setText("");
					textName.setText("");
					textAuthor.setText("");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnRemove.setBounds(169, 343, 146, 40);
		contentPane.add(btnRemove);
	}

}
