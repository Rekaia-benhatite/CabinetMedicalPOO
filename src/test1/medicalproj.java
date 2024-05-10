package test1;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Map;

import javax.swing.JComboBox;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class medicalproj extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	JLabel lblinfo;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel_2;
	
	private JRadioButton button1;
    private JRadioButton button2;

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
		lblNewLabel_1.setBounds(84, 131, 113, 19);
		contentPane.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUsername.setBounds(274, 62, 217, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		button1 = new JRadioButton("medecin");
        button1.setBounds(367, 197, 111, 23);
        contentPane.add(button1);
        
        button2 = new JRadioButton("secraitaire");
        button2.setBounds(178, 197, 111, 23);
        contentPane.add(button2);
		
		JButton btnok = new JButton("Se Connecter");
		btnok.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText ();
	        	String password = txtPassword.getText ();
	        	String utype = "";
	        	if (button2.isSelected()) {
	                utype = "secraitaire";
	            } else if ( button1.isSelected()) {
	                utype = "medecin";
	            } else {
	         
	                JOptionPane.showMessageDialog(null, "Please select user type");
	                return; 
	            }
			        	
			        	
				try {
				
		        	
		        	
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical","root","ikoukikouk");
					PreparedStatement ps = con.prepareStatement("select *from createcompte where Nomutilisateur=? and Motdepasse=? and TypeUtilisateur= ? ");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, utype);
					
					ResultSet rs;
					rs = ps.executeQuery();
					if (rs.next() )
					{
						int userid = rs.getInt("ID");
						setVisible(false);
						if (utype.equals("Secraitaire")) {
		                    Main2 main2 = new Main2(userid, username,utype );
		                    main2.setVisible(true);
		                } else {
		                    // Ouvrir Main sinon
		                	SaisieIDPatient main = new SaisieIDPatient();
		                    main.setVisible(true);
		                }
						
						
						 
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "userName or password do not match");
						txtUsername.setText("");
						txtPassword.setText("");
						
						txtUsername.requestFocus();
					}
					
		    	  
		    	  
		    	  
		      
				
				
	
				} catch(Exception e1) {
					  e1.printStackTrace();
					}
			}
		});
		btnok.setBounds(106, 282, 135, 48);
		contentPane.add(btnok);
		
		JButton btnreset = new JButton("Fermer");
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
		btnreset.setBounds(465, 285, 135, 43);
		contentPane.add(btnreset);
		
	    lblinfo = new JLabel("");
		lblinfo.setBounds(144, 316, 268, 14);
		contentPane.add(lblinfo);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(274, 130, 217, 20);
		contentPane.add(txtPassword);
		
		lblNewLabel_2 = new JLabel("LOGIN SYSTEM");
		lblNewLabel_2.setBounds(274, 22, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Creer un compte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Compte create=new Compte();
			create.setVisible(true);
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(274, 297, 164, 33);
		contentPane.add(btnNewButton);
		
		JRadioButton button1 = new JRadioButton("Medecin");
		button1.setBounds(367, 197, 111, 23);
		contentPane.add(button1);
		
		JRadioButton button2 = new JRadioButton("Secraitaire");
		button2.setBounds(178, 197, 111, 23);
		contentPane.add(button2);
	}
}
