package test1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Jlabel4;
    private JLabel jlabel5;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Jlabel4 = new JLabel("New label");
		Jlabel4.setBounds(805, 81, 97, 30);
		contentPane.add(Jlabel4);
		
		 jlabel5 = new JLabel("New label");
		jlabel5.setBounds(806, 190, 49, 14);
		contentPane.add(jlabel5);
		
		JButton btnNewButton = new JButton("rendezvous");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rendezvousmed rendezvousMedFrame = new rendezvousmed(newid);
		        rendezvousMedFrame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(215, 134, 89, 23);
		contentPane.add(btnNewButton);
	}
	int newid;
	String uname;
	String usertype;
	public Main (int id, String username, String utype) 
	{ 
		this();
		this.uname = username;
		Jlabel4.setText(uname);
		this.usertype = utype;
		jlabel5.setText(usertype);
		this.newid= id;
		
		
		
		
		
	}
}
