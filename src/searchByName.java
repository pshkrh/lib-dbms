import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;

public class searchByName extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchByName frame = new searchByName();
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
	public searchByName() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSearchByName.setBounds(65, 16, 499, 36);
		contentPane.add(lblSearchByName);
		lblSearchByName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterName.setBounds(119, 89, 113, 37);
		contentPane.add(lblEnterName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textName.setBounds(247, 86, 146, 40);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from booklist where title like ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, "%" + textName.getText() + "%");
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					textName.setText("");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(247, 141, 146, 36);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 216, 606, 351);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
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
	}

}
