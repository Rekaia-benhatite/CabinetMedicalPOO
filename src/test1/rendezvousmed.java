package test1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class rendezvousmed extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int idUtilisateur;
	
	
	 public rendezvousmed(int idUtilisateur) {
	        this.idUtilisateur = idUtilisateur;
	        initComponents();
	        afficherPatientsDuMedecin(idUtilisateur);
	    }
	 private void initComponents() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 930, 669);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(163, 94, 544, 335);
	        contentPane.add(scrollPane);

	        table = new JTable();
	        scrollPane.setViewportView(table);
	        table.setModel(new DefaultTableModel(
	                new Object[][]{},
	                new String[]{"ID Patient", "Nom", "Prénom", "Date", "Heure"}
	        ));
	    }
	 
	 

		public void afficherPatientsDuMedecin(int idMedecin) {
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical", "root", "lydia");
         PreparedStatement ps = con.prepareStatement("SELECT r.idPatient, r.Nompatient, r.prenompatient, r.date, r.heure FROM rendezvous r INNER JOIN medecin m ON r.IDmed = m.idmedecin WHERE m.idUtilisateur = ?");
         ps.setInt(1, idMedecin);

         
      
         ResultSet rs = ps.executeQuery();
         
         while (rs.next()) {
             Object[] row = {
                 rs.getString("idPatient"),
                 rs.getString("Nompatient"),
                 rs.getString("prenompatient"),
                 rs.getString("date"),
                 rs.getString("heure")
             };
             model.addRow(row);
         }
         
                con.close();
         
         
		
		} catch (Exception e) {
             e.printStackTrace();
         }
		
	}
	 
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rendezvousmed frame = new rendezvousmed(1);
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
	
		
	
		
		
}
