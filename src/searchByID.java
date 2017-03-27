import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class searchByID extends JFrame {

	private JPanel contentPane;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchByID frame = new searchByID();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public searchByID() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchById = new JLabel("Search By ID");
		lblSearchById.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSearchById.setBounds(81, 16, 468, 40);
		contentPane.add(lblSearchById);
		lblSearchById.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterId.setBounds(137, 89, 100, 37);
		contentPane.add(lblEnterId);
		
		textID = new JTextField();
		textID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textID.setBounds(247, 86, 146, 40);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from booklist where bid = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textID.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					textID.setText("");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnSearch.setBounds(247, 145, 146, 40);
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
