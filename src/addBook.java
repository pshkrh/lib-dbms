import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class addBook extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTextField textAuthor;
	Connection connection = null;
	private JTextField textQuantity;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBook frame = new addBook();
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
	public addBook() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setBounds(84, 94, 69, 37);
		contentPane.add(lblID);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textID.setBounds(183, 92, 146, 40);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(84, 147, 69, 37);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textName.setBounds(183, 148, 146, 40);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textAuthor.setBounds(183, 204, 146, 40);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAuthor.setBounds(84, 203, 69, 37);
		contentPane.add(lblAuthor);
		
		JLabel lblAddBook = new JLabel("ADD BOOK");
		lblAddBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddBook.setBounds(70, 16, 335, 40);
		contentPane.add(lblAddBook);
		lblAddBook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "insert into booklist values(?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textID.getText());
					pst.setString(2, textName.getText());
					pst.setString(3, textAuthor.getText());
					pst.setString(4, textQuantity.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Book Added Successfully.");
					pst.close();
					textID.setText("");
					textName.setText("");
					textAuthor.setText("");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(183, 340, 146, 40);
		contentPane.add(btnAdd);
		
		JButton button = new JButton("<-");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu1 menu1 = new menu1();
				menu1.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setBounds(15, 16, 52, 40);
		contentPane.add(button);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantity.setBounds(84, 262, 84, 37);
		contentPane.add(lblQuantity);
		
		textQuantity = new JTextField();
		textQuantity.setBounds(183, 260, 146, 40);
		contentPane.add(textQuantity);
		textQuantity.setColumns(10);
	}
}
