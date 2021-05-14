package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import logica.ControladorSum;
import logica.CreateException;
public class VProducto extends JDialog {
	private JTextField texIdProducto;
	private JTextField textNomProducto;
	private JButton btnAñadir;
	private JButton btnAtras;
	private JSpinner spinner;
	
	public VProducto(ControladorSum datos,String id) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblIdProducto = new JLabel("ID Producto");
		lblIdProducto.setBounds(80, 29, 57, 25);
		getContentPane().add(lblIdProducto);
		
		JLabel lblNomProducto = new JLabel("Nombre");
		lblNomProducto.setBounds(92, 77, 44, 19);
		getContentPane().add(lblNomProducto);
		
		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setBounds(109, 130, 46, 14);
		getContentPane().add(lblCant);
		
		texIdProducto = new JTextField();
		texIdProducto.setBounds(164, 31, 86, 20);
		getContentPane().add(texIdProducto);
		texIdProducto.setColumns(10);
		
		textNomProducto = new JTextField();
		textNomProducto.setBounds(164, 76, 86, 20);
		getContentPane().add(textNomProducto);
		textNomProducto.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(179, 125, 71, 25);
		getContentPane().add(spinner);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnAtras.setBounds(33, 212, 89, 23);
		getContentPane().add(btnAtras);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addProducto(datos,id);
			}
		});
		btnAñadir.setBounds(306, 212, 89, 23);
		getContentPane().add(btnAñadir);
	}

	protected void addProducto(ControladorSum datos, String id) {
		try {
			datos.anadirProd(id, texIdProducto.getText(), ((Integer)spinner.getValue()), textNomProducto.getText());
			JOptionPane.showMessageDialog(this, "Producto añadido correctamente","Producto añadido",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (CreateException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar añadir datos de la base de datos",
					"Error create BBDD", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
