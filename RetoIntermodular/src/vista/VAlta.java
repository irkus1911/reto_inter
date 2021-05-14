package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logica.ControladorAdmin;
import logica.CreateException;

public class VAlta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldId;
	private JTextField textFieldContrasena;
	private JButton btnAlta;
	private ButtonGroup groupUsuarios;
	private JTextField textFieldTipo;
	private JLabel lblTipo;

	public VAlta(ControladorAdmin datos) {

		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		groupUsuarios = new ButtonGroup();
		

		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta(datos);
			}
		});
		btnAlta.setBounds(292, 300, 89, 23);
		contentPanel.add(btnAlta);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(51, 300, 89, 23);
		contentPanel.add(btnAtras);

		textFieldNombre = new JTextField();
		textFieldNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldNombre.getText().length() > 20) {

					JOptionPane.showMessageDialog(textFieldNombre, "El nombre no puede ser de mas de 20 carácteres",
							"Error longitud nombre", JOptionPane.ERROR_MESSAGE);
					textFieldNombre.setText("");
					textFieldNombre.requestFocus();

				}

			}
		});
		textFieldNombre.setBounds(148, 45, 182, 30);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldId = new JTextField();
		textFieldId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldId.getText().length() > 9 || textFieldId.getText().length() == 0) {

					JOptionPane.showMessageDialog(textFieldId, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
					textFieldId.requestFocus();

				}

			}
		});
		textFieldId.setColumns(10);
		textFieldId.setBounds(148, 86, 182, 30);
		contentPanel.add(textFieldId);

		textFieldContrasena = new JTextField();
		textFieldContrasena.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldContrasena.getText().length() > 25) {

					JOptionPane.showMessageDialog(textFieldContrasena,
							"La contraseña no puede ser de más de 25 carácteres", "Error longitud contraseña",
							JOptionPane.ERROR_MESSAGE);
					textFieldContrasena.setText("");
					textFieldContrasena.requestFocus();

				}

			}
		});
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

		lblTipo = new JLabel("Tipo comercio:");
		lblTipo.setBounds(43, 172, 72, 23);
		contentPanel.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(148, 168, 182, 30);
		contentPanel.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(51, 229, 78, 23);
		rdbtnCliente.setActionCommand("Cliente");
		contentPanel.add(rdbtnCliente);
		groupUsuarios.add(rdbtnCliente);
		
		JRadioButton rdbtnComercio = new JRadioButton("Comercio");
		rdbtnComercio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnComercio.isSelected()) {
					lblTipo.setVisible(true);
					textFieldTipo.setVisible(true);
				} else {
					lblTipo.setVisible(false);
					textFieldTipo.setVisible(false);
				}
			}
		});
		rdbtnComercio.setBounds(160, 229, 78, 23);
		rdbtnComercio.setActionCommand("Comercio");
		contentPanel.add(rdbtnComercio);
		groupUsuarios.add(rdbtnComercio);
		
		JRadioButton rdbtnSuministrador = new JRadioButton("Suministrador");
		rdbtnSuministrador.setBounds(288, 229, 109, 23);
		rdbtnSuministrador.setActionCommand("Suministrador");
		contentPanel.add(rdbtnSuministrador);
		lblTipo.setVisible(false);
		textFieldTipo.setVisible(false);
		groupUsuarios.add(rdbtnSuministrador);

	}

	private void alta(ControladorAdmin datos) { 
		
		try {
			datos.alta(textFieldNombre.getText(), textFieldContrasena.getText(), textFieldId.getText(),groupUsuarios.getSelection().getActionCommand() , textFieldTipo.getText());
			JOptionPane.showMessageDialog(btnAlta, "El usuario se ha dado de alta exitosamente","Alta",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(btnAlta, "Error al dar de alta a un usuario","Error alta",JOptionPane.ERROR_MESSAGE);

		}

	}
}
