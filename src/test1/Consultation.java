// Classe pour ajouter une consultation
package test1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultation extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idPatientField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField resultatsField;
    private JTextField ordonnanceField;
    private JTextField dateField;

    public Consultation(String idPatient) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ID du Patient:");
        lblNewLabel.setBounds(30, 30, 100, 20);
        contentPane.add(lblNewLabel);
        
        idPatientField = new JTextField(idPatient);
        idPatientField.setBounds(150, 30, 200, 20);
        contentPane.add(idPatientField);
        idPatientField.setColumns(10);
        idPatientField.setEditable(false);
        
        JLabel lblNewLabel_1 = new JLabel("Nom:");
        lblNewLabel_1.setBounds(30, 70, 100, 20);
        contentPane.add(lblNewLabel_1);
        
        nomField = new JTextField();
        nomField.setBounds(150, 70, 200, 20);
        contentPane.add(nomField);
        nomField.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Prénom:");
        lblNewLabel_2.setBounds(30, 110, 100, 20);
        contentPane.add(lblNewLabel_2);
        
        prenomField = new JTextField();
        prenomField.setBounds(150, 110, 200, 20);
        contentPane.add(prenomField);
        prenomField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Résultats:");
        lblNewLabel_3.setBounds(30, 150, 100, 20);
        contentPane.add(lblNewLabel_3);
        
        resultatsField = new JTextField();
        resultatsField.setBounds(150, 150, 200, 20);
        contentPane.add(resultatsField);
        resultatsField.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Ordonnance:");
        lblNewLabel_4.setBounds(30, 190, 100, 20);
        contentPane.add(lblNewLabel_4);
        
        ordonnanceField = new JTextField();
        ordonnanceField.setBounds(150, 190, 200, 20);
        contentPane.add(ordonnanceField);
        ordonnanceField.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Date:");
        lblNewLabel_5.setBounds(30, 230, 100, 20);
        contentPane.add(lblNewLabel_5);
        
        dateField = new JTextField();
        dateField.setBounds(150, 230, 200, 20);
        contentPane.add(dateField);
        dateField.setColumns(10);
        
        JButton btnNewButton = new JButton("Enregistrer");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ajouter ici la logique pour enregistrer la consultation
                // Vous pouvez récupérer les valeurs saisies dans les champs de texte
                // (idPatientField.getText(), nomField.getText(), prenomField.getText(), etc.)
                // et les utiliser pour créer une nouvelle consultation.
            }
        });
        btnNewButton.setBounds(180, 280, 150, 30);
        contentPane.add(btnNewButton);
    }
}