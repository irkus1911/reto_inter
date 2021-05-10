package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JLabel;

public class VPedido extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VPedido dialog = new VPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VPedido() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox comboProducto = new JComboBox();
		comboProducto.setBounds(154, 24, 207, 44);
		getContentPane().add(comboProducto);
		
		JComboBox comboVendedor = new JComboBox();
		comboVendedor.setBounds(154, 79, 207, 44);
		getContentPane().add(comboVendedor);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setBounds(47, 216, 89, 23);
		getContentPane().add(btnAtras);
		
		JButton btnEnviar = new JButton("Continuar");
		btnEnviar.setBounds(299, 216, 89, 23);
		getContentPane().add(btnEnviar);
		
		JSpinner spinnerCant = new JSpinner();
		spinnerCant.setBounds(199, 156, 113, 35);
		getContentPane().add(spinnerCant);
		
		JLabel lblNomProducto = new JLabel("Producto");
		lblNomProducto.setBounds(23, 32, 81, 29);
		getContentPane().add(lblNomProducto);
		
		JLabel lblNomVendedor = new JLabel("Vendedor");
		lblNomVendedor.setBounds(23, 88, 65, 35);
		getContentPane().add(lblNomVendedor);
		
		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setBounds(143, 162, 48, 23);
		getContentPane().add(lblCant);
	}
}
