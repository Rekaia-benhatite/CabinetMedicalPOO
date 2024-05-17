package test1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 30;
    private JLabel Jlabel4;
    private JLabel jlabel5;
    private JButton ordinanceButton;
    private JButton patientButton;
    private JButton dossierMedicalButton;
    private JFrame espaceDocteurFrame;
    private String uname;
    private String usertype;
    private int newid;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("ESPACE MÉDECIN");

        // Panneau principal avec un fond bleu clair
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(173, 216, 230)); // Light blue background color
        setContentPane(contentPane);

        // Titre "ESPACE MÉDECIN"
        JLabel lblTitle = new JLabel("ESPACE MÉDECIN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(Color.WHITE);
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panneau pour les boutons et les informations de l'utilisateur
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(173, 216, 230)); // Light blue background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(loginPanel, BorderLayout.CENTER);

        // Éléments du panneau de connexion
        Jlabel4 = new JLabel();
        jlabel5 = new JLabel();
        ordinanceButton = new JButton("Consultation");
        patientButton = new JButton("EDT");
        dossierMedicalButton = new JButton("Dossier Médical");

        // Ajout des éléments au panneau de connexion
        gbc.gridy = 0;
        loginPanel.add(Jlabel4, gbc);
        gbc.gridy = 1;
        loginPanel.add(jlabel5, gbc);
        gbc.gridy = 2;
        loginPanel.add(ordinanceButton, gbc);
        gbc.gridy = 3;
        loginPanel.add(patientButton, gbc);
        gbc.gridy = 4;
        loginPanel.add(dossierMedicalButton, gbc);

        // Action listeners pour les boutons
        ordinanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consultation consultationFrame = new Consultation("");
                consultationFrame.setVisible(true);
            }
        });

        patientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour le bouton Patient
            }
        });

        dossierMedicalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DossierMedicalPatient dossierMedicalFrame = new DossierMedicalPatient("id");
                dossierMedicalFrame.setVisible(true);
            }
        });

        // Créez la fenêtre espaceDocteurFrame dans le constructeur, mais ne la rendez pas visible ici
        espaceDocteurFrame = new JFrame();
        espaceDocteurFrame.setTitle("Espace Médecin");
        espaceDocteurFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        espaceDocteurFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        JPanel contentPaneDoctor = new JPanel(new BorderLayout());
        contentPaneDoctor.setBackground(new Color(173, 216, 230)); // Light blue background color
        espaceDocteurFrame.setContentPane(contentPaneDoctor);

        JLabel lblTitleDoctor = new JLabel("ESPACE MÉDECIN");
        lblTitleDoctor.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitleDoctor.setHorizontalAlignment(SwingConstants.CENTER);
        contentPaneDoctor.add(lblTitleDoctor, BorderLayout.NORTH);

        JLabel lblDoctorUsername = new JLabel("Bienvenue, ");
        contentPaneDoctor.add(lblDoctorUsername, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        contentPaneDoctor.add(buttonPanel, BorderLayout.SOUTH);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        JButton btnOrdonnance = createButton("Consultation");
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        buttonPanel.add(btnOrdonnance, gbc2);

        JButton btnEDT = createButton("EDT");
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        buttonPanel.add(btnEDT, gbc2);

        JButton btnDossierMedical = createButton("Dossier Médical");
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        buttonPanel.add(btnDossierMedical, gbc2);
    }

    public void loginDoctor(String username, String password) {
        try {
            // Connexion à la base de données
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cabinetmedical", "root", "kawter55");

            // Préparation de la requête SQL pour récupérer les informations du médecin
            String query = "SELECT * FROM medecins WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            // Exécution de la requête SQL
            ResultSet rs = ps.executeQuery();

            // Si un résultat est retourné, cela signifie que les identifiants sont valides
            if (rs.next()) {
                // Récupérer les informations du médecin
                int doctorId = rs.getInt("id");
                String doctorName = rs.getString("name");
                String doctorSpecialty = rs.getString("specialty");

                // Affichage du message de bienvenue
                JOptionPane.showMessageDialog(this, "Bienvenue, Dr. " + doctorName + "!");

                // Afficher la fenêtre espaceDocteurFrame
                espaceDocteurFrame.setVisible(true);
            } else {
                // Affichage du message d'erreur si les identifiants sont incorrects
                JOptionPane.showMessageDialog(this, "Nom d'utilisateur ou mot de passe incorrect.");
            }

            // Fermeture des connexions à la base de données
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code pour gérer le clic sur le bouton
            }
        });
        return button;
    }

    public Main(int id, String username, String utype) {
        this();
        this.uname = username;
        Jlabel4.setText(uname);
        this.usertype = utype;
        jlabel5.setText(usertype);
        this.newid = id;
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.loginDoctor("docteur", ""); // Remplacez "" par le mot de passe réel
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
