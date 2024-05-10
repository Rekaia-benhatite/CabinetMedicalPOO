package test1;

import java.awt.EventQueue;
<<<<<<< HEAD
import java.awt.Font;
import java.awt.event.ActionEvent;
=======

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
>>>>>>> 74d1999449570a069c5df1a48dfd8d8f09e29f23
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Rendezvous extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea idpatienttxt;
    private JTextArea Nompatienttxt;
    private JTextArea prenomtxt;
    private JDateChooser dateChooser;
    private JComboBox<String> boxheure;
    private JTextArea idmedecin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Rendezvous frame = new Rendezvous();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Rendezvous() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 990, 716);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ID Patient");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel.setBounds(181, 88, 119, 22);
        contentPane.add(lblNewLabel);

        JLabel lblNomPatient = new JLabel("Nom Patient");
        lblNomPatient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblNomPatient.setBounds(181, 172, 119, 22);
        contentPane.add(lblNomPatient);

        JLabel lblPrenomPatient = new JLabel("Prenom Patient");
        lblPrenomPatient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblPrenomPatient.setBounds(181, 263, 175, 30);
        contentPane.add(lblPrenomPatient);

        JLabel lblDate = new JLabel("Date ");
        lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblDate.setBounds(181, 364, 119, 22);
        contentPane.add(lblDate);

        JLabel lblHeure = new JLabel("Heure ");
        lblHeure.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblHeure.setBounds(181, 438, 119, 22);
        contentPane.add(lblHeure);

        JLabel lblIdMedecin = new JLabel("ID medecin");
        lblIdMedecin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        lblIdMedecin.setBounds(181, 516, 119, 22);
        contentPane.add(lblIdMedecin);

        idpatienttxt = new JTextArea();
        idpatienttxt.setBounds(464, 80, 219, 30);
        contentPane.add(idpatienttxt);

        Nompatienttxt = new JTextArea();
        Nompatienttxt.setBounds(464, 172, 219, 30);
        contentPane.add(Nompatienttxt);

        prenomtxt = new JTextArea();
        prenomtxt.setBounds(464, 269, 219, 30);
        contentPane.add(prenomtxt);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(464, 364, 219, 30);
        contentPane.add(dateChooser);

        boxheure = new JComboBox<String>();
        boxheure.setModel(new DefaultComboBoxModel<String>(new String[] { "8H ", "9H ", "10H", "11H", "13H", "14H",
                "15H", "16H", "17H" }));
        boxheure.setBounds(464, 441, 219, 30);
        contentPane.add(boxheure);

        idmedecin = new JTextArea();
        idmedecin.setBounds(464, 518, 219, 30);
        contentPane.add(idmedecin);

        JButton addrend = new JButton("Ajouter");
        addrend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical",
                            "root", "koukikouki");
                    String query = "insert into rendezvous (idPatient,Nompatient ,prenompatient ,date , heure,IDmed) values (?,?,?,?,?,?)";

                    String iDpatient = idpatienttxt.getText();
                    String nompat = Nompatienttxt.getText();
                    String prenompat = prenomtxt.getText();
                    java.sql.Date daterend = new java.sql.Date(dateChooser.getDate().getTime());
                    String heurerend = (String) boxheure.getSelectedItem();
                    String IdMEd = idmedecin.getText();

                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, iDpatient);
                    ps.setString(2, nompat);
                    ps.setString(3, prenompat);
                    ps.setDate(4, daterend);
                    ps.setString(5, heurerend);
                    ps.setString(6, IdMEd);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "rendezvous ajouter avec succes");
                    ps.close();
                    con.close();

                } catch (ClassNotFoundException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        addrend.setBounds(256, 617, 89, 23);
        contentPane.add(addrend);

        JButton btnNewButton_1 = new JButton("Quitter");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre actuelle
                Main2 main2Frame = new Main2();
                main2Frame.setVisible(true); // Rend visible la fenêtre Main2

            }
        });
        btnNewButton_1.setBounds(568, 617, 89, 23);
        contentPane.add(btnNewButton_1);
    }
=======
import java.awt.event.ActionEvent;

public class Rendezvous extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rendezvous frame = new Rendezvous();
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
	public Rendezvous() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(181, 88, 119, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomPatient = new JLabel("Nom Patient");
		lblNomPatient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNomPatient.setBounds(181, 172, 119, 22);
		contentPane.add(lblNomPatient);
		
		JLabel lblPrenomPatient = new JLabel("Prenom Patient");
		lblPrenomPatient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPrenomPatient.setBounds(181, 263, 175, 30);
		contentPane.add(lblPrenomPatient);
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblDate.setBounds(181, 364, 119, 22);
		contentPane.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure ");
		lblHeure.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblHeure.setBounds(181, 438, 119, 22);
		contentPane.add(lblHeure);
		
		JLabel lblIdMedecin = new JLabel("ID medecin");
		lblIdMedecin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblIdMedecin.setBounds(181, 516, 119, 22);
		contentPane.add(lblIdMedecin);
		
		JTextArea idpatienttxt = new JTextArea();
		idpatienttxt.setBounds(464, 80, 219, 30);
		contentPane.add(idpatienttxt);
		
		JTextArea Nompatienttxt = new JTextArea();
		Nompatienttxt.setBounds(464, 172, 219, 30);
		contentPane.add(Nompatienttxt);
		
		JTextArea prenomtxt = new JTextArea();
		prenomtxt.setBounds(464, 269, 219, 30);
		contentPane.add(prenomtxt);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(464, 364, 219, 30);
		contentPane.add(dateChooser);
		
		JComboBox boxheure = new JComboBox();
		boxheure.setModel(new DefaultComboBoxModel(new String[] {"8H ", "9H ", "10H", "11H", "13H", "14H", "15H", "16H", "17H"}));
		boxheure.setBounds(464, 441, 219, 30);
		contentPane.add(boxheure);
		
		JTextArea idmedecin = new JTextArea();
		idmedecin.setBounds(464, 518, 219, 30);
		contentPane.add(idmedecin);
		
		JButton addrend = new JButton("Ajouter");
		addrend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical","root","lydia");
					String query="insert into rendezvous (idPatient,Nompatient ,prenompatient ,date , heure,IDmed) values (?,?,?,?,?,?)";
					
					String iDpatient = idpatienttxt.getText ();
					String nompat = Nompatienttxt.getText ();
					String prenompat = prenomtxt.getText ();
					java.sql.Date daterend = new java.sql.Date(dateChooser.getDate().getTime());
	                String heurerend = (String) boxheure.getSelectedItem();
					String IdMEd = idmedecin.getText ();
					
					
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, iDpatient);
					ps.setString(2,nompat );
					ps.setString(3,prenompat );
					ps.setDate(4,daterend);
					ps.setString(5,heurerend );
					ps.setString(6,IdMEd );
					 ps.executeUpdate();
                    
					
					

					JOptionPane.showMessageDialog(null, "rendezvous ajouter avec succes");
					ps.close();
		            con.close();
		          
		            
				} catch(Exception e1) {
					  e1.printStackTrace();}
			
				
				
				
			}
				
				
				
				
				
				
				
				
			
		});
		addrend.setBounds(256, 617, 89, 23);
		contentPane.add(addrend);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose(); // Ferme la fenêtre actuelle
			        Main2 main2Frame = new Main2();
			        main2Frame.setVisible(true); // Rend visible la fenêtre Main2
				
			}
		});
		btnNewButton_1.setBounds(568, 617, 89, 23);
		contentPane.add(btnNewButton_1);
	}
>>>>>>> 74d1999449570a069c5df1a48dfd8d8f09e29f23
}
