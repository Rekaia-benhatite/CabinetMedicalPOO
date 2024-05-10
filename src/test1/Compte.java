package test1;

import java.awt.EventQueue;


import javax.swing.JOptionPane;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Compte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Create;
	private JTextField txtutilisateur;
	private JPasswordField passwordComp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compte frame = new Compte();
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
	public Compte() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 565);
		Create = new JPanel();
		Create.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Create);
		Create.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom Utilisateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(65, 117, 139, 42);
		Create.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot De Passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(65, 207, 127, 47);
		Create.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Créer Un Compte");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_3.setBounds(253, 23, 265, 47);
		Create.add(lblNewLabel_3);
		
		txtutilisateur = new JTextField();
		txtutilisateur.setBounds(338, 125, 265, 32);
		Create.add(txtutilisateur);
		txtutilisateur.setColumns(10);
		
		passwordComp = new JPasswordField();
		passwordComp.setBounds(338, 217, 265, 32);
		Create.add(passwordComp);
		
		final JRadioButton rdbtnmed = new JRadioButton("Medecin");
		rdbtnmed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		rdbtnmed.setBounds(164, 300, 127, 23);
		Create.add(rdbtnmed);
		
		final JRadioButton rdbtnSecraitaire = new JRadioButton("Secraitaire");
		rdbtnSecraitaire.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		rdbtnSecraitaire.setBounds(401, 300, 139, 23);
		Create.add(rdbtnSecraitaire);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (rdbtnmed.isSelected()) {
  // Médecin sélectionné, ouvrir la fenêtre d'informations du médecin (infodoc)
				        InfoMed infodoc = new InfoMed();
				        infodoc.setVisible(true);
				 }
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical","root","koukikouki");
					String query="insert into createcompte (Nomutilisateur, Motdepasse, TypeUtilisateur) values (?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, txtutilisateur.getText());
					ps.setInt(2, Integer.parseInt(passwordComp.getText()));
					
					if (rdbtnmed.isSelected())
						ps.setString(3,rdbtnmed.getText());
					else
						ps.setString(3,rdbtnSecraitaire.getText());
					
					ps.executeUpdate();
					 
					 txtutilisateur.setText("");
					    passwordComp.setText("");
					    rdbtnmed.setSelected(false);
					    rdbtnSecraitaire.setSelected(false);
					 
					    
					
					 ps.close();
					 con.close();
					 
					
				} catch(Exception e1) {
				  e1.printStackTrace();
				}
				
			}
			  

				
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnAjouter.setBounds(397, 448, 156, 42);
		Create.add(btnAjouter);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnQuitter.setBounds(132, 448, 156, 42);
		Create.add(btnQuitter);
	}
}
