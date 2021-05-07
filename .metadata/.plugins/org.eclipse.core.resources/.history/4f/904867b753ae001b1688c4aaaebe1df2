package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class VPrincipalAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipalAdministrador frame = new VPrincipalAdministrador();
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
	public VPrincipalAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(304, 206, 89, 23);
		contentPane.add(btnAlta);
		
		JComboBox comboTipoUsuarioAlta = new JComboBox();
		comboTipoUsuarioAlta.setBounds(85, 109, 270, 22);
		contentPane.add(comboTipoUsuarioAlta);
		
		JButton btnAcceso = new JButton("Acceder");
		btnAcceso.setBounds(67, 206, 89, 23);
		contentPane.add(btnAcceso);
		
		JButton btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.setBounds(10, 11, 120, 23);
		contentPane.add(btnCerrarSesion);
	}
}
