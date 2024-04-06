package test1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JRadioButton;

public class medicalproj extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	JLabel lblinfo;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medicalproj frame = new medicalproj();
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
	public medicalproj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 403);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(9, 9, 9, 9));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom Utilisateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(72, 62, 148, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(72, 154, 113, 19);
		contentPane.add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtusername.setBounds(274, 62, 217, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnok = new JButton("Login");
		btnok.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Password = txtPassword.getText();
				String username = txtusername.getText();
				if (Password.contains("king") && username.contains("one")) {
					txtPassword.setText(null);
					txtusername.setText(null);
				}
				else {
					JOptionPane.showMessageDialog(null,"invalid login","login error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtusername.setText(null);
				}
				
			}
		});
		btnok.setBounds(106, 282, 89, 23);
		contentPane.add(btnok);
		
		JButton btnreset = new JButton("close ");
		btnreset.setIcon(new ImageIcon("C:\\Users\\pc\\OneDrive\\Documents\\photopro\\Close.png"));
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int choice = JOptionPane.showConfirmDialog(null, "Do you really want to close", "Select", JOptionPane.YES_NO_OPTION);
				    if (choice == JOptionPane.YES_OPTION) {
				        System.exit(0);
				    }
			}
		});
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreset.setBounds(411, 282, 108, 23);
		contentPane.add(btnreset);
		
	    lblinfo = new JLabel("");
		lblinfo.setBounds(144, 316, 268, 14);
		contentPane.add(lblinfo);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(274, 155, 217, 20);
		contentPane.add(txtPassword);
		
		lblNewLabel_2 = new JLabel("login system");
		lblNewLabel_2.setBounds(231, 26, 101, 14);
		contentPane.add(lblNewLabel_2);
	}
}
