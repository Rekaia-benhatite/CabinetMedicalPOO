package test1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        boxheure.setModel(new DefaultComboBoxModel<String>(
                new String[] { "8H ", "9H ", "10H", "11H", "13H", "14H", "15H", "16H", "17H" }));
        boxheure.setBounds(464, 441, 219, 30);
        contentPane.add(boxheure);

        idmedecin = new JTextArea();
        idmedecin.setBounds(464, 518, 219, 30);
        contentPane.add(idmedecin);

        JButton addrend = new JButton("Ajouter");
        addrend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajouterRendezVous();
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

    private void ajouterRendezVous() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cabinetmedical", "root", "kawter55");
            String query = "INSERT INTO rendezvous (idPatient, Nompatient, prenompatient, date, heure, IDmed) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, idpatienttxt.getText());
            ps.setString(2, Nompatienttxt.getText());
            ps.setString(3, prenomtxt.getText());
            java.sql.Date daterend = new java.sql.Date(dateChooser.getDate().getTime());
            ps.setDate(4, daterend);
            ps.setString(5, (String) boxheure.getSelectedItem());
            ps.setString(6, idmedecin.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rendez-vous ajouté avec succès");
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
