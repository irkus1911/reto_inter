package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Main;
import logica.*;
import modelo.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VBienvenida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboTipoUsuarioLogin;
	private JButton btnIrALogin;

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		try {
//			VBienvenida dialog = new VBienvenida();
//			dialog.setLocationRelativeTo(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public VBienvenida() {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnIrALogin = new JButton("Continuar");
		btnIrALogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
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

	}

	public void login() {

		if (comboTipoUsuarioLogin.getSelectedIndex() == 0) {
			ControladorAdmin datosAdmin = Main.datosAdmin();
			VLogin login = new VLogin(datosAdmin);
			login.setVisible(true);
			login.setLocationRelativeTo(null);
			this.dispose();

		} else if (comboTipoUsuarioLogin.getSelectedIndex() == 1) {
			ControladorClie datosClie = Main.datosClie();
			VLogin login = new VLogin(datosClie);
			login.setVisible(true);
			login.setLocationRelativeTo(null);
			this.dispose();

		} else if (comboTipoUsuarioLogin.getSelectedIndex() == 2) {
			ControladorCom datosCom = Main.datosCom();
			VLogin login = new VLogin(datosCom);
			login.setVisible(true);
			login.setLocationRelativeTo(null);
			this.dispose();

		} else if (comboTipoUsuarioLogin.getSelectedIndex() == 3) {
			ControladorSum datosSum = Main.datosSum();
			VLogin login = new VLogin(datosSum);
			login.setVisible(true);
			login.setLocationRelativeTo(null);
			this.dispose();

		} else {
			JOptionPane.showMessageDialog(btnIrALogin, "Error seleccion incorrecta", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
