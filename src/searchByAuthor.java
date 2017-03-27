import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class searchByAuthor extends JFrame {

	private JPanel contentPane;
	private JTextField textAuthor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchByAuthor frame = new searchByAuthor();
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
	public searchByAuthor() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchByAuthor = new JLabel("Search By Author");
		lblSearchByAuthor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSearchByAuthor.setBounds(64, 16, 489, 40);
		contentPane.add(lblSearchByAuthor);
		
		JLabel lblNewLabel = new JLabel("Enter Author");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(113, 89, 118, 37);
		contentPane.add(lblNewLabel);
		
		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textAuthor.setBounds(246, 86, 146, 40);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from booklist where author like ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, "%" + textAuthor.getText() + "%");
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					textAuthor.setText("");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(246, 141, 146, 40);
		contentPane.add(btnSearch);
		lblSearchByAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBook sb = new searchBook();
				sb.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setBounds(15, 16, 51, 40);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 217, 606, 351);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}

}
