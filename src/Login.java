import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1065, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsername.setBounds(298, 209, 116, 44);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(298, 314, 116, 44);
		frame.getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		usernameField.setBounds(429, 206, 259, 47);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		passwordField.setBounds(429, 311, 259, 47);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Sign In");
		Image img2 = new ImageIcon(this.getClass().getResource("Ok-icon.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img2));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from LibrarianInfo where Username = ? and Password = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count=0;
					while(rs.next()){
						count++;
					}
					if(count==1){
						JOptionPane.showMessageDialog(null, "Sign in Successful.");
						frame.dispose();
						menu1 menu1 = new menu1();
						menu1.setVisible(true);
					}
					else if(count>1){
						JOptionPane.showMessageDialog(null, "Username already exists.");
					}
					else{
						JOptionPane.showMessageDialog(null, "Username or Password is Incorrect.");
					}
					rs.close();
					pst.close();
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(429, 449, 259, 78);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(15, 138, 259, 311);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLibdbms = new JLabel("lib-dbms");
		lblLibdbms.setFont(new Font("Arial Narrow", Font.ITALIC, 44));
		lblLibdbms.setBounds(15, 38, 1013, 64);
		frame.getContentPane().add(lblLibdbms);
		lblLibdbms.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
