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

public class issueAndReturn extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issueAndReturn frame = new issueAndReturn();
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
	public issueAndReturn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIssueAndReturn = new JLabel("ISSUE & RETURN");
		lblIssueAndReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIssueAndReturn.setBounds(67, 16, 353, 40);
		contentPane.add(lblIssueAndReturn);
		lblIssueAndReturn.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issueBook ib = new issueBook();
				ib.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnIssueBook.setBounds(155, 125, 170, 40);
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook rb = new returnBook();
				rb.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnReturnBook.setBounds(155, 237, 170, 40);
		contentPane.add(btnReturnBook);
	}

}
