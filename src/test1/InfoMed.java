package test1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.ScrollPane;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class InfoMed extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nommedtxt;
	private JTextField prenmedtxt;
	private JTextField emailtxt;
	private JTextField numtelmed;
	private JTextField adrmedtxt;
	private JTextField spémedtxt;
	private int idUtilisateur;
	


	
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoMed frame = new InfoMed();
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
	
	
	

	
	
	public InfoMed( ) {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 737);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(130, 107, 123, 34);
		contentPane.add(lblNewLabel);
		
		Nommedtxt = new JTextField();
		Nommedtxt.setBounds(130, 170, 219, 28);
		contentPane.add(Nommedtxt);
		Nommedtxt.setColumns(10);
		
		prenmedtxt = new JTextField();
		prenmedtxt.setColumns(10);
		prenmedtxt.setBounds(130, 350, 219, 28);
		contentPane.add(prenmedtxt);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(130, 523, 219, 28);
		contentPane.add(emailtxt);
		
		numtelmed = new JTextField();
		numtelmed.setColumns(10);
		numtelmed.setBounds(576, 170, 224, 28);
		contentPane.add(numtelmed);
		
		adrmedtxt = new JTextField();
		adrmedtxt.setColumns(10);
		adrmedtxt.setBounds(576, 350, 224, 28);
		contentPane.add(adrmedtxt);
		
		spémedtxt = new JTextField();
		spémedtxt.setColumns(10);
		spémedtxt.setBounds(576, 527, 224, 28);
		contentPane.add(spémedtxt);
		
		JLabel lblPrnom = new JLabel("Prénom:");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPrnom.setBounds(130, 295, 123, 34);
		contentPane.add(lblPrnom);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblEmail.setBounds(130, 468, 123, 34);
		contentPane.add(lblEmail);
		
		JLabel lblNumroTelephone = new JLabel("Numéro Tél:");
		lblNumroTelephone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNumroTelephone.setBounds(576, 107, 175, 34);
		contentPane.add(lblNumroTelephone);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAdresse.setBounds(576, 284, 175, 34);
		contentPane.add(lblAdresse);
		
		JLabel lblSpcialit = new JLabel("Spécialité:");
		lblSpcialit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSpcialit.setBounds(576, 468, 175, 34);
		contentPane.add(lblSpcialit);
		
		JLabel lblNewLabel_1 = new JLabel("Inscription Medecin ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(361, 26, 368, 28);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
		
		JButton quittermed = new JButton("Quitter");
		quittermed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		quittermed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Compte compteFrame = new Compte();
			        // Affichage de Compte
			        compteFrame.setVisible(true);
			        // Fermeture de la fenêtre actuelle de InfoMed
			        dispose();
			    }
			
		});
		quittermed.setBounds(290, 627, 137, 45);
		contentPane.add(quittermed);
		
		 
		
		
		
		
		
		
		JButton creermed = new JButton("Créer");
		creermed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				try {
					 
										
					
					
					
					
		
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical","root","lydia");
					
					String query="insert into medecin (nom, Prenom,email,numtel, adresse,spécialité,idutilisateur) values (?,?,?,?,?,?,?)";
					
					String nommed = Nommedtxt.getText ();
					String prenommed = prenmedtxt.getText ();
					String emailmed = emailtxt.getText ();
					String nultelmed = numtelmed.getText ();
					String adressemed =adrmedtxt.getText ();
					String specialité = spémedtxt.getText ();
					
					
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,nommed );
					ps.setString(2, prenommed);
					ps.setString(3, emailmed);
					ps.setString(4,nultelmed);
					ps.setString(5,adressemed );
					ps.setString(6,specialité  );
					ps.setInt(7, idUtilisateur);
			
					 ps.executeUpdate();
                    
					
					

					JOptionPane.showMessageDialog(null, "medecin ajouter avec succes");
					ps.close();
		            con.close();
		          
		            
				} catch(Exception e1) {
					  e1.printStackTrace();}
			
				
				
				
			}
		});
		creermed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		creermed.setBounds(537, 627, 137, 45);
		contentPane.add(creermed);
		
	
		
	}
	
	  public InfoMed(int idUtilisateur) {
	        this(); // Appel au constructeur par défaut pour initialiser l'interface
	        this.idUtilisateur = idUtilisateur;
	    }
	
}
