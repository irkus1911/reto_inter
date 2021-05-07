package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JTextField textFieldContraseina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VLogin dialog = new VLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VLogin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(48, 67, 46, 14);
			contentPanel.add(lblId);
		}
		
		textFieldId = new JTextField();
		textFieldId.setBounds(104, 64, 240, 20);
		contentPanel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblContraseina = new JLabel("Contrase\u00F1a");
		lblContraseina.setBounds(28, 129, 66, 14);
		contentPanel.add(lblContraseina);
		
		textFieldContraseina = new JTextField();
		textFieldContraseina.setBounds(104, 126, 240, 20);
		contentPanel.add(textFieldContraseina);
		textFieldContraseina.setColumns(10);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}
}
