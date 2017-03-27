import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchBook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchBook frame = new searchBook();
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
	public searchBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBook = new JLabel("SEARCH BOOK");
		lblSearchBook.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSearchBook.setBounds(64, 16, 352, 42);
		contentPane.add(lblSearchBook);
		lblSearchBook.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSearchByName = new JButton("Search By Name");
		btnSearchByName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByName sbname = new searchByName();
				sbname.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnSearchByName.setBounds(129, 183, 222, 42);
		contentPane.add(btnSearchByName);
		
		JButton btnSearchByAuthor = new JButton("Search By Author");
		btnSearchByAuthor.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByAuthor sbauth = new searchByAuthor();
				sbauth.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnSearchByAuthor.setBounds(129, 270, 222, 42);
		contentPane.add(btnSearchByAuthor);
		
		JButton btnSearchById = new JButton("Search By ID");
		btnSearchById.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSearchById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchByID sbid = new searchByID();
				sbid.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnSearchById.setBounds(129, 102, 222, 42);
		contentPane.add(btnSearchById);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu1 menu1 = new menu1();
				menu1.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setBounds(15, 16, 51, 42);
		contentPane.add(button);
	}

}
