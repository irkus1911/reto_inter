package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class VProducto extends JDialog {
	private JTextField texIdProducto;
	private JTextField textNomProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VProducto dialog = new VProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VProducto() {
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
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(179, 125, 71, 25);
		getContentPane().add(spinner);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(33, 212, 89, 23);
		getContentPane().add(btnAtras);
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setBounds(306, 212, 89, 23);
		getContentPane().add(btnAñadir);
	}
}
