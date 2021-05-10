package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import logica.*;
import modelo.*;

public class VAlta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldId;
	private JTextField textFieldContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VAlta dialog = new VAlta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VAlta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JCheckBox chckbxCliente = new JCheckBox("Cliente");
		chckbxCliente.setBounds(43, 172, 97, 23);
		contentPanel.add(chckbxCliente);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(292, 213, 89, 23);
		contentPanel.add(btnAlta);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(39, 213, 89, 23);
		contentPanel.add(btnAtras);
		
		JCheckBox chckbxComercio = new JCheckBox("Comercio");
		chckbxComercio.setBounds(160, 172, 97, 23);
		contentPanel.add(chckbxComercio);
		
		JCheckBox chckbxSuministrador = new JCheckBox("Suministrador");
		chckbxSuministrador.setBounds(292, 172, 97, 23);
		contentPanel.add(chckbxSuministrador);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(148, 45, 182, 30);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(148, 86, 182, 30);
		contentPanel.add(textFieldId);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setColumns(10);
		textFieldContrasena.setBounds(148, 127, 182, 30);
		contentPanel.add(textFieldContrasena);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(43, 53, 78, 22);
		contentPanel.add(lblNombre);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(43, 94, 78, 22);
		contentPanel.add(lblId);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(43, 135, 97, 22);
		contentPanel.add(lblContrasena);
	}
}
