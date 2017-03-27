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

public class editBook extends JFrame {

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
					editBook frame = new editBook();
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
	public editBook() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditBook = new JLabel("EDIT");
		lblEditBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEditBook.setBounds(81, 16, 335, 40);
		contentPane.add(lblEditBook);
		lblEditBook.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(97, 106, 69, 37);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textID.setBounds(181, 103, 146, 40);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(97, 175, 69, 37);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textName.setBounds(181, 173, 146, 40);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAuthor.setBounds(97, 244, 69, 37);
		contentPane.add(lblAuthor);
		
		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textAuthor.setBounds(181, 241, 146, 40);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JButton btnUpdate = new JButton("Go");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "Update booklist set bid='"+textID.getText()+"' , Name='"+textName.getText()+"', Author='"+textAuthor.getText()+"' where bid='"+textID.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Information Updated");
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
		btnUpdate.setBounds(181, 323, 146, 40);
		contentPane.add(btnUpdate);
	}

}
