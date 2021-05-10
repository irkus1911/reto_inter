package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import logica.*;
import modelo.*;

public class VLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JTextField textFieldContraseina;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VLogin dialog = new VLogin();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public VLogin(ControladorClie datos) {
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
		textFieldId.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if (textFieldId.getText().length() > 9) {

					JOptionPane.showMessageDialog(textFieldId, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
					textFieldId.requestFocus();

				}
			}
		});
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
		textFieldContraseina.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldContraseina.getText().length() > 25) {

					JOptionPane.showMessageDialog(textFieldContraseina, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldContraseina.setText("");
					textFieldContraseina.requestFocus();
				}
			}
		});

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginClie(datos);
			
				
			};
		});
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VBienvenida bien = new VBienvenida(datos, null, null, null);
				bien.setVisible(true);
			}
		});
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}
	public VLogin(ControladorCom datos) {
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
		textFieldId.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				if (textFieldId.getText().length() > 9) {
					
					JOptionPane.showMessageDialog(textFieldId, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
					textFieldId.requestFocus();
					
				}
			}
		});
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
		textFieldContraseina.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldContraseina.getText().length() > 25) {
					
					JOptionPane.showMessageDialog(textFieldContraseina, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldContraseina.setText("");
					textFieldContraseina.requestFocus();
				}
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginCom(datos);
			};
		});
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VBienvenida bien = new VBienvenida(null, datos, null, null);
				bien.setVisible(true);
			}
		});
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}
	
	public VLogin(ControladorSum datos) {
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
		textFieldId.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				if (textFieldId.getText().length() > 9) {
					
					JOptionPane.showMessageDialog(textFieldId, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
					textFieldId.requestFocus();
					
				}
			}
		});
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
		textFieldContraseina.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldContraseina.getText().length() > 25) {
					
					JOptionPane.showMessageDialog(textFieldContraseina, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldContraseina.setText("");
					textFieldContraseina.requestFocus();
				}
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginSum(datos);
			};
		});
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VBienvenida bien = new VBienvenida(null, null, datos,null);
				bien.setVisible(true);
			}
		});
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}
/*	public VLogin(ControladorAdmin datos) {
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
		textFieldId.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				if (textFieldId.getText().length() > 9) {
					
					JOptionPane.showMessageDialog(textFieldId, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
					textFieldId.requestFocus();
					
				}
			}
		});
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
		textFieldContraseina.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldContraseina.getText().length() > 25) {
					
					JOptionPane.showMessageDialog(textFieldContraseina, "El id no puede ser de más de 9 carácteres",
							"Error longitud id", JOptionPane.ERROR_MESSAGE);
					textFieldContraseina.setText("");
					textFieldContraseina.requestFocus();
				}
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAdmin();
			};
		});
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);
		
		JButton btnCerrar = new JButton("Cerrar");
		
//		btnCerrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//				VBienvenida bien = new VBienvenida(null, null, null, null);
//				bien.setVisible(true);
//			}
//		});
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}*/
	
	public void loginClie(ControladorClie datos) {
		try {
		
			boolean login = datos.login(textFieldId.getText(), textFieldContraseina.getText());
			

			
			if (login) {
				
				VCliente vent = new VCliente(this, textFieldId.getText(), datos);
				vent.setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(textFieldContraseina, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				textFieldContraseina.setText("");
				textFieldId.requestFocus();

			}
			
			//ReadException Q lo cambie yo 
		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this,
					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void loginCom(ControladorCom datos) {
		try {
			boolean login = datos.login(textFieldId.getText(), textFieldContraseina.getText());
			if (login) {
				VComercio vent = new VComercio(this, true, textFieldId.getText(), datos);
				vent.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(textFieldContraseina, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				textFieldContraseina.setText("");
				textFieldId.requestFocus();
				
			}
		} catch (ReadException ex) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void loginSum(ControladorSum datos) {
		try {
			boolean login = datos.login(textFieldId.getText(), textFieldContraseina.getText());
			if (login) {
				VSuministrador vent = new VSuministrador(this, true, textFieldId.getText(), datos);
				vent.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(textFieldContraseina, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				textFieldContraseina.setText("");
				textFieldId.requestFocus();
				
			}
		} catch (ReadException ex) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/*public void loginAdmin() { //Ya que el usuario Administrador va a tener unas credenciales predefinidas  se realiza el login en la propia ventana, o con parametros predefinidos en el controlodar o en un archivo de configuracion
		try {
			boolean login = datos.login(textFieldId.getText(), textFieldContraseina.getText());
			if (login) {
				VAdmin vent = new VAdmin(this, true, textFieldId.getText(), datos);
				vent.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(textFieldContraseina, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				textFieldContraseina.setText("");
				textFieldId.requestFocus();
				
			}
		} catch (ReadException ex) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
		if(textFieldId.getText().toUpperCase().equals("ADMIN") && textFieldContraseina.getText().equals("admin")) {
			VAdministrador vent = new VAdministrador(this, true, textFieldId.getText(), datos);
			vent.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(textFieldContraseina, "Se han introducido credenciales erroneas",
					"Error login", JOptionPane.ERROR_MESSAGE);
			textFieldId.setText("");
			textFieldContraseina.setText("");
			textFieldId.requestFocus();
		}
	}*/
}
