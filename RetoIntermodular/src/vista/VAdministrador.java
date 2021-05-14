package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Main;
import logica.ControladorAdmin;
import logica.ControladorClie;
import logica.ControladorCom;
import logica.ControladorSum;

public class VAdministrador extends JFrame {

	private JPanel contentPane;
	private JButton btnAcceso;
	private JButton btnAlta;
	private JButton btnCerrarSesion;
	private JComboBox comboTipoUsuarioAlta;

	public VAdministrador(VLogin vLogin, boolean b, String id, ControladorAdmin datos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta(datos);
			}
		});
		btnAlta.setBounds(304, 206, 89, 23);
		contentPane.add(btnAlta);

		comboTipoUsuarioAlta = new JComboBox();
		comboTipoUsuarioAlta
				.setModel(new DefaultComboBoxModel(new String[] { "Cliente", "Comercio", "Suministrador" }));
		comboTipoUsuarioAlta.setBounds(85, 109, 270, 22);
		comboTipoUsuarioAlta.setSelectedIndex(-1);
		contentPane.add(comboTipoUsuarioAlta);

		btnAcceso = new JButton("Acceder");
		btnAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(vLogin, id);
			}
		});
		btnAcceso.setBounds(67, 206, 89, 23);
		contentPane.add(btnAcceso);

		btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion(datos);
			}
		});
		btnCerrarSesion.setBounds(10, 11, 120, 23);
		contentPane.add(btnCerrarSesion);
	}

	private void login(VLogin vLogin, String id) {
		
		if (comboTipoUsuarioAlta.getSelectedIndex() == 0) {
			ControladorClie datosClie = Main.datosClie();
			VCliente cliente = new VCliente(vLogin, id, datosClie);
			cliente.setVisible(true);
			cliente.setLocationRelativeTo(null);
			this.dispose();

		} else if (comboTipoUsuarioAlta.getSelectedIndex() == 1) {
			ControladorCom datosCom = Main.datosCom();
			VComercio comercio = new VComercio(vLogin, true, id, datosCom);
			comercio.setVisible(true);
			comercio.setLocationRelativeTo(null);
			this.dispose();

		} else if (comboTipoUsuarioAlta.getSelectedIndex() == 2) {
			ControladorSum datosSum = Main.datosSum();
			VSuministrador suministrador = new VSuministrador(vLogin, true, id, datosSum);
			suministrador.setVisible(true);
			suministrador.setLocationRelativeTo(null);
			this.dispose();

		} else {
			JOptionPane.showMessageDialog(btnAcceso, "Error seleccion incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	

	private void alta(ControladorAdmin datos) {

		VAlta alta = new VAlta(datos);
		alta.setVisible(true);
		alta.setLocationRelativeTo(null);
	}
	
	private void cerrarSesion(ControladorAdmin datos) {
		try {
			VBienvenida vent = new VBienvenida();
			vent.setVisible(true);
			vent.setLocationRelativeTo(null);
			this.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al Cargar la Ventana", "Error Lectura Ventana",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
