package test1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AjoutPatient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Nomtext;
    private JTextField Prenomtxt;
    private JTextField Agetxt;
    private JTextField Numteltxt;
    private JTable table;
    private JTextArea Antitxt;
    private JLabel NumPat;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AjoutPatient frame = new AjoutPatient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AjoutPatient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1279, 729);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(56, 122, 76, 27);
        lblNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
        contentPane.add(lblNom);

        JLabel lblPrenom = new JLabel("Prénom");
        lblPrenom.setBounds(43, 201, 87, 20);
        lblPrenom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
        contentPane.add(lblPrenom);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(56, 279, 76, 27);
        lblAge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
        contentPane.add(lblAge);

        JLabel lblAdresse = new JLabel("Numéro Tel");
        lblAdresse.setBounds(56, 361, 133, 27);
        lblAdresse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
        contentPane.add(lblAdresse);

        JLabel lblAnticdents = new JLabel("Anticédents");
        lblAnticdents.setBounds(56, 452, 142, 27);
        lblAnticdents.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
        contentPane.add(lblAnticdents);

        NumPat = new JLabel("");
        NumPat.setBounds(367, 63, 151, 20);
        contentPane.add(NumPat);

        Nomtext = new JTextField();
        Nomtext.setBounds(231, 126, 228, 27);
        contentPane.add(Nomtext);
        Nomtext.setColumns(10);

        Prenomtxt = new JTextField();
        Prenomtxt.setBounds(231, 202, 228, 27);
        Prenomtxt.setColumns(10);
        contentPane.add(Prenomtxt);

        Agetxt = new JTextField();
        Agetxt.setBounds(231, 283, 228, 27);
        Agetxt.setColumns(10);
        contentPane.add(Agetxt);

        Numteltxt = new JTextField();
        Numteltxt.setBounds(231, 365, 228, 27);
        Numteltxt.setColumns(10);
        contentPane.add(Numteltxt);

        Antitxt = new JTextArea();
        Antitxt.setBounds(231, 457, 235, 114);
        contentPane.add(Antitxt);

        JButton btnNewButton = new JButton("Quitter");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main2.main(null);
            }
        });
        btnNewButton.setBounds(56, 630, 151, 40);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(btnNewButton);

        JButton Ajoutpat = new JButton("Ajouter");
        Ajoutpat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajouterPatient();
            }
        });
        Ajoutpat.setBounds(264, 630, 151, 40);
        Ajoutpat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(Ajoutpat);

        JButton btnModifier = new JButton("Modifier ");
        btnModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifierPatient();
            }
        });
        btnModifier.setBounds(461, 630, 151, 40);
        btnModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(btnModifier);

        JButton btnSupprimer = new JButton("Supprimer ");
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                supprimerPatient();
            }
        });
        btnSupprimer.setBounds(659, 630, 151, 40);
        btnSupprimer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(btnSupprimer);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(515, 66, 648, 522);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Patient ID", "Nom", "Prénom", "Age", "Numéro Tel", "Anticédents" }
        ));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remplirChamps();
            }
        });

        patient_table();
    }

    private void ajouterPatient() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cabinetmedical", "root", "kawter55");
            String query = "INSERT INTO patient (Nom, Prénom, Age, Numérotel, Anticédents) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Nomtext.getText());
            ps.setString(2, Prenomtxt.getText());
            ps.setString(3, Agetxt.getText());
            ps.setString(4, Numteltxt.getText());
            ps.setString(5, Antitxt.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Patient ajouté avec succès");
            ps.close();
            con.close();
            patient_table();
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du patient.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modifierPatient() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical", "root", "koukikouki");
            String query = "UPDATE patient SET Nom = ?, Prénom = ?, Age = ?, Numérotel = ?, Anticédents = ? WHERE `Patient ID` = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Nomtext.getText());
            ps.setString(2, Prenomtxt.getText());
            ps.setString(3, Agetxt.getText());
            ps.setString(4, Numteltxt.getText());
            ps.setString(5, Antitxt.getText());
            ps.setString(6, NumPat.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Patient modifié avec succès");
            ps.close();
            con.close();
            patient_table();
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification du patient.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void supprimerPatient() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical", "root", "koukikouki");
            String query = "DELETE FROM patient WHERE `Patient ID` = ?";
            PreparedStatement ps = con.prepareStatement(query);
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un patient à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String patientId = table.getValueAt(row, 0).toString();
            ps.setString(1, patientId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Patient supprimé avec succès");
            ps.close();
            con.close();
            patient_table();
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression du patient.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void remplirChamps() {
        DefaultTableModel d1 = (DefaultTableModel) table.getModel();
        int selectIndex = table.getSelectedRow();
        if (selectIndex >= 0 && selectIndex < d1.getRowCount()) {
            String patientId = d1.getValueAt(selectIndex, 0).toString();
            NumPat.setText(patientId);
            Nomtext.setText(d1.getValueAt(selectIndex, 1).toString());
            Prenomtxt.setText(d1.getValueAt(selectIndex, 2).toString());
            Agetxt.setText(d1.getValueAt(selectIndex, 3).toString());
            Numteltxt.setText(d1.getValueAt(selectIndex, 4).toString());
            Antitxt.setText(d1.getValueAt(selectIndex, 5).toString());
        }
    }

    private void patient_table() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical", "root", "koukikouki");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patient");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c = Rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector<Object> v2 = new Vector<>();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString(i));
                }
                df.addRow(v2);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des données des patients.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}

	
		
		
	
	
		
	