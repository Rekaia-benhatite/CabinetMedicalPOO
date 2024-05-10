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

public class SaisieIDPatient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idPatientField;

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
        setBounds(100, 100, 450, 200);
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
        
        JButton btnNewButton = new JButton("Afficher Dossier Médical");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer l'ID du patient saisi
                String idPatient = idPatientField.getText();
                // Ouvrir le dossier médical du patient correspondant à cet ID
                DossierMedicalPatient dossierMedical = new DossierMedicalPatient(idPatient);
                dossierMedical.setVisible(true);
            }
        });
        btnNewButton.setBounds(150, 90, 200, 30);
        contentPane.add(btnNewButton);
    }
}