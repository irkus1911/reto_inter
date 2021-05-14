package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.ControladorAdmin;
import logica.ControladorClie;
import logica.ControladorCom;
import logica.ControladorSum;
import logica.ReadException;

public class VLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JPasswordField passwordField;

	
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 126, 240, 20);
		contentPanel.add(passwordField);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (new String(passwordField.getPassword()).length() > 25) {
					
					JOptionPane.showMessageDialog(passwordField, "La contraseña no puede ser de más de 25 carácteres",
							"Error longitud contraseña", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField.requestFocus();
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
				VBienvenida bien = new VBienvenida();
				bien.setVisible(true);
				bien.setLocationRelativeTo(null);
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 126, 240, 20);
		contentPanel.add(passwordField);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (new String(passwordField.getPassword()).length() > 25) {
					
					JOptionPane.showMessageDialog(passwordField, "La contraseña no puede ser de más de 25 carácteres",
							"Error longitud contraseña", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField.requestFocus();
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
				VBienvenida bien = new VBienvenida();
				bien.setVisible(true);
				bien.setLocationRelativeTo(null);
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 126, 240, 20);
		contentPanel.add(passwordField);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (new String(passwordField.getPassword()).length() > 25) {
					
					JOptionPane.showMessageDialog(passwordField, "La contraseña no puede ser de más de 25 carácteres",
							"Error longitud contraseña", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField.requestFocus();
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
				VBienvenida bien = new VBienvenida();
				bien.setVisible(true);
				bien.setLocationRelativeTo(null);
			}
		});
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}
	public VLogin(ControladorAdmin datos) {
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 126, 240, 20);
		contentPanel.add(passwordField);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (new String(passwordField.getPassword()).length() > 25) {
					
					JOptionPane.showMessageDialog(passwordField, "La contraseña no puede ser de más de 25 carácteres",
							"Error longitud contraseña", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					passwordField.requestFocus();
				}
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAdmin(datos);
			};
		});
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);
		
		JButton btnCerrar = new JButton("Cerrar");
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VBienvenida bien = new VBienvenida();
				bien.setVisible(true);
				bien.setLocationRelativeTo(null);
			}
		});
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
	}
	
	public void loginClie(ControladorClie datos) {
		try {
		
			boolean login = datos.login(textFieldId.getText(), new String(passwordField.getPassword()));
				
			if (login) {
				
				VCliente vent = new VCliente(this, textFieldId.getText(), datos);
				vent.setVisible(true);
				vent.setLocationRelativeTo(null);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(passwordField, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				passwordField.setText("");
				textFieldId.requestFocus();
			}
		} catch (ReadException ex) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void loginCom(ControladorCom datos) {
		try {
			boolean login = datos.login(textFieldId.getText(), new String(passwordField.getPassword()));
			if (login) {
				VComercio vent = new VComercio(this, true, textFieldId.getText(), datos);
				vent.setVisible(true);
				vent.setLocationRelativeTo(null);
				this.setVisible(false);			
			} else {
				JOptionPane.showMessageDialog(passwordField, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				passwordField.setText("");
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
			boolean login = datos.login(textFieldId.getText(), new String(passwordField.getPassword()));
			if (login) {
				VSuministrador vent = new VSuministrador(this, true, textFieldId.getText(), datos);
				vent.setVisible(true);
				vent.setLocationRelativeTo(null);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(passwordField, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				passwordField.setText("");
				textFieldId.requestFocus();
				
			}
		} catch (ReadException ex) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void loginAdmin(ControladorAdmin datos) {
		//try {
			//boolean login = datos.login(textFieldId.getText(), new String(passwordField.getPassword()));
			if (textFieldId.getText().equals("ADMIN") && new String(passwordField.getPassword()).equals("admin")) {
				VAdministrador vent = new VAdministrador(this, true, textFieldId.getText(), datos);
				vent.setVisible(true);
				vent.setLocationRelativeTo(null);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(passwordField, "Se han introducido credenciales erroneas",
						"Error login", JOptionPane.ERROR_MESSAGE);
				textFieldId.setText("");
				passwordField.setText("");
				textFieldId.requestFocus();
				
			}
//		} catch (ReadException ex) {
//			JOptionPane.showMessageDialog(this,
//					"Error al intentar comprobar credenciales en la base de datos", "Error lectura BBDD",
//					JOptionPane.ERROR_MESSAGE);
//		}
	}
}
