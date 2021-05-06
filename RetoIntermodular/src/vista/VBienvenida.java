package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VBienvenida extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VBienvenida dialog = new VBienvenida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VBienvenida() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnIrALogin = new JButton("Continuar");
		btnIrALogin.setBounds(297, 194, 89, 23);
		contentPanel.add(btnIrALogin);
		
		JLabel lblBienvenida = new JLabel("Bienvenide les gallines");
		lblBienvenida.setBounds(158, 41, 137, 14);
		contentPanel.add(lblBienvenida);
		
		JComboBox comboTipoUsuarioLogin = new JComboBox();
		comboTipoUsuarioLogin.setBounds(126, 123, 182, 22);
		contentPanel.add(comboTipoUsuarioLogin);
	}
}
