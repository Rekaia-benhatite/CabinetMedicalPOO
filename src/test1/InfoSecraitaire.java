package test1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class InfoSecraitaire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namesec;
	private JTextField prenomsec;
	private JTextField emailsec;
	private JTextField telsec;
	private JTextField adressesec;
	private int idUtilisateur;
	private JTextField age;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoSecraitaire frame = new InfoSecraitaire();
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
	public InfoSecraitaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription Secraitaire");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(332, 50, 452, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(182, 148, 93, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prénom:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(182, 291, 93, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("E-mail:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_2.setBounds(192, 441, 93, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Numéro Tél:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_3.setBounds(616, 148, 149, 30);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adresse:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_4.setBounds(616, 291, 93, 30);
		contentPane.add(lblNewLabel_1_4);
		
		namesec = new JTextField();
		namesec.setBounds(181, 208, 181, 30);
		contentPane.add(namesec);
		namesec.setColumns(10);
		
		prenomsec = new JTextField();
		prenomsec.setColumns(10);
		prenomsec.setBounds(181, 354, 181, 30);
		contentPane.add(prenomsec);
		
		emailsec = new JTextField();
		emailsec.setColumns(10);
		emailsec.setBounds(191, 504, 181, 30);
		contentPane.add(emailsec);
		
		telsec = new JTextField();
		telsec.setColumns(10);
		telsec.setBounds(603, 208, 181, 30);
		contentPane.add(telsec);
		
		adressesec = new JTextField();
		adressesec.setColumns(10);
		adressesec.setBounds(603, 359, 181, 30);
		contentPane.add(adressesec);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(332, 596, 104, 34);
		contentPane.add(btnNewButton);
		
		JButton btnAjouter = new JButton("Creer");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	try {
					 
										
					
					
					
					
		
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical","root","lydia");
					
					String query="insert into secraitaire (Nom, Prenom,Email,telephone,Adresse,idutilisateursec,age) values (?,?,?,?,?,?,?)";
					
					String nommed = namesec.getText ();
					String prenommed = prenomsec.getText ();
					String emailmed = emailsec.getText ();
					String nultelmed = telsec.getText ();
					String adressemed =adressesec.getText ();
					String Age =age.getText ();
					
					
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,nommed );
					ps.setString(2, prenommed);
					ps.setString(3, emailmed);
					ps.setString(4,nultelmed);
					ps.setString(5,adressemed );
					
					ps.setInt(6, idUtilisateur);
					ps.setString(7, Age);
					 ps.executeUpdate();
                    
					
					

					JOptionPane.showMessageDialog(null, "Secretaire ajouter avec succes");
					ps.close();
		            con.close();
		          
		            
				} catch(Exception e1) {
					  e1.printStackTrace();}
			
				
				
				
			}
				
				
				
				
			
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnAjouter.setBounds(553, 594, 115, 38);
		contentPane.add(btnAjouter);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Age:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_2_1.setBounds(616, 441, 93, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(603, 504, 181, 30);
		contentPane.add(age);
	}
	
	 public InfoSecraitaire(int idUtilisateur) {
	        this(); // Appel au constructeur par défaut pour initialiser l'interface
	        this.idUtilisateur = idUtilisateur;
	    }
	
	
}
