package test1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DossierMedicalPatient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField ageField;
    private JTextField rendezVousField;
    private JTextField maladiesChroniquesField;

    public DossierMedicalPatient(final String idPatient) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Dossier Médical du Patient " + idPatient);
        lblNewLabel.setBounds(30, 30, 250, 20);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nom:");
        lblNewLabel_1.setBounds(30, 70, 100, 20);
        contentPane.add(lblNewLabel_1);
        
        nomField = new JTextField();
        nomField.setBounds(140, 70, 200, 20);
        contentPane.add(nomField);
        nomField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Prénom:");
        lblNewLabel_2.setBounds(30, 110, 100, 20);
        contentPane.add(lblNewLabel_2);
        
        prenomField = new JTextField();
        prenomField.setBounds(140, 110, 200, 20);
        contentPane.add(prenomField);
        prenomField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Âge:");
        lblNewLabel_3.setBounds(30, 150, 100, 20);
        contentPane.add(lblNewLabel_3);
        
        ageField = new JTextField();
        ageField.setBounds(140, 150, 200, 20);
        contentPane.add(ageField);
        ageField.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Rendez-vous:");
        lblNewLabel_4.setBounds(30, 190, 100, 20);
        contentPane.add(lblNewLabel_4);
        
        rendezVousField = new JTextField();
        rendezVousField.setBounds(140, 190, 200, 20);
        contentPane.add(rendezVousField);
        rendezVousField.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Maladies Chroniques:");
        lblNewLabel_5.setBounds(30, 230, 150, 20);
        contentPane.add(lblNewLabel_5);
        
        maladiesChroniquesField = new JTextField();
        maladiesChroniquesField.setBounds(190, 230, 200, 20);
        contentPane.add(maladiesChroniquesField);
        maladiesChroniquesField.setColumns(10);
        
        JButton btnNewButton = new JButton("Ajouter Consultation");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouvrir le formulaire pour ajouter une consultation
                Consultation ajouterConsultation = new Consultation(idPatient);
                ajouterConsultation.setVisible(true);
            }
        });
        btnNewButton.setBounds(200, 280, 200, 30);
        contentPane.add(btnNewButton);
    }
}