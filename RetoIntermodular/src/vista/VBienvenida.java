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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VBienvenida extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboTipoUsuarioLogin;
	private JButton btnIrALogin;
	

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

		btnIrALogin = new JButton("Continuar");
		btnIrALogin.setBounds(297, 194, 89, 23);
		contentPanel.add(btnIrALogin);

		JLabel lblBienvenida = new JLabel("Bienvenide les gallines");
		lblBienvenida.setBounds(158, 41, 137, 14);
		contentPanel.add(lblBienvenida);

		comboTipoUsuarioLogin = new JComboBox();
		comboTipoUsuarioLogin.setModel(
				new DefaultComboBoxModel(new String[] { "Administrador", "Cliente", "Comercio", "Suministrador" }));
		comboTipoUsuarioLogin.setSelectedIndex(-1);
		comboTipoUsuarioLogin.setBounds(126, 123, 182, 22);
		contentPanel.add(comboTipoUsuarioLogin);
		

		btnIrALogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (comboTipoUsuarioLogin.getSelectedIndex() == 0) {
			if (e.getSource().equals(btnIrALogin)) {
				VLogin login=new VLogin("Administrador");
				login.setVisible(true);
				this.dispose();

			}
		} else if (comboTipoUsuarioLogin.getSelectedIndex() == 1) {
			if (e.getSource().equals(btnIrALogin)) {
				VLogin login=new VLogin("Cliente");
				login.setVisible(true);
				this.dispose();
			}
		} else if (comboTipoUsuarioLogin.getSelectedIndex() == 2) {
			if (e.getSource().equals(btnIrALogin)) {
				VLogin login=new VLogin("Comercio");
				login.setVisible(true);
				this.dispose();
			}
		} else if (comboTipoUsuarioLogin.getSelectedIndex() == 3) {
			if (e.getSource().equals(btnIrALogin)) {
				VLogin login=new VLogin("Suministrador");
				login.setVisible(true);
				this.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(btnIrALogin, "Error seleccion incorrecta", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
