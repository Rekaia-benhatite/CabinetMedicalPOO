package test1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class SaisieIDPatient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idPatientField;
    private JTextField nomPatientField;
    private JTextField prenomPatientField;
    private JTextField agePatientField;
    private JTextField adressePatientField;
    private JTextField telephonePatientField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SaisieIDPatient frame = new SaisieIDPatient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SaisieIDPatient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Saisir l'ID du patient:");
        lblNewLabel.setBounds(30, 30, 150, 20);
        contentPane.add(lblNewLabel);
        
        idPatientField = new JTextField();
        idPatientField.setBounds(190, 30, 200, 20);
        contentPane.add(idPatientField);
        idPatientField.setColumns(10);
        
        JLabel lblNom = new JLabel("Nom:");
        lblNom.setBounds(30, 70, 100, 20);
        contentPane.add(lblNom);
        
        nomPatientField = new JTextField();
        nomPatientField.setBounds(190, 70, 200, 20);
        contentPane.add(nomPatientField);
        nomPatientField.setColumns(10);
        
        JLabel lblPrenom = new JLabel("Prénom:");
        lblPrenom.setBounds(30, 110, 100, 20);
        contentPane.add(lblPrenom);
        
        prenomPatientField = new JTextField();
        prenomPatientField.setBounds(190, 110, 200, 20);
        contentPane.add(prenomPatientField);
        prenomPatientField.setColumns(10);
        
        JLabel lblAge = new JLabel("Âge:");
        lblAge.setBounds(30, 150, 100, 20);
        contentPane.add(lblAge);
        
        agePatientField = new JTextField();
        agePatientField.setBounds(190, 150, 200, 20);
        contentPane.add(agePatientField);
        agePatientField.setColumns(10);
        
        JLabel lblAdresse = new JLabel("Adresse:");
        lblAdresse.setBounds(30, 190, 100, 20);
        contentPane.add(lblAdresse);
        
        adressePatientField = new JTextField();
        adressePatientField.setBounds(190, 190, 200, 20);
        contentPane.add(adressePatientField);
        adressePatientField.setColumns(10);
        
        JLabel lblTelephone = new JLabel("Téléphone:");
        lblTelephone.setBounds(30, 230, 100, 20);
        contentPane.add(lblTelephone);
        
        telephonePatientField = new JTextField();
        telephonePatientField.setBounds(190, 230, 200, 20);
        contentPane.add(telephonePatientField);
        telephonePatientField.setColumns(10);
        
        JButton btnNewButton = new JButton("Afficher Dossier Médical");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer l'ID du patient saisi
                String idPatient = idPatientField.getText();
                
                // Connexion à la base de données et récupération des informations du patient
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/votre_base_de_donnees", "root", "kawter55");
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE id=?");
                    ps.setString(1, idPatient);
                    ResultSet rs = ps.executeQuery();
                    
                    // Si un résultat est trouvé, remplir les champs avec les informations du patient
                    if (rs.next()) {
                        String nom = rs.getString("nom");
                        String prenom = rs.getString("prenom");
                        String age = rs.getString("age");
                        String adresse = rs.getString("adresse");
                        String telephone = rs.getString("telephone");
                        
                        nomPatientField.setText(nom);
                        prenomPatientField.setText(prenom);
                        agePatientField.setText(age);
                        adressePatientField.setText(adresse);
                        telephonePatientField.setText(telephone);
                    } else {
                        // Si aucun résultat n'est trouvé, effacer les champs
                        nomPatientField.setText("");
                        prenomPatientField.setText("");
                        agePatientField.setText("");
                        adressePatientField.setText("");
                        telephonePatientField.setText("");
                        
                        // Afficher un message d'erreur
                        JOptionPane.showMessageDialog(null, "Aucun patient trouvé avec cet ID.");
                    }
                    
                    // Fermer les connexions
                    rs.close();
                    ps.close();
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(150, 260, 200, 30);
        contentPane.add(btnNewButton);
    }
}
