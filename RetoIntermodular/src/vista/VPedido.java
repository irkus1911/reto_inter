package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;

import modelo.ControladorClie;

public class VPedido extends JDialog {
	private static final long serialVersionUID = 1L;
	private JComboBox comboProducto;
	private JComboBox comboVendedor;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VPedido dialog = new VPedido();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	public VPedido(VCliente clie, boolean b, String id, ControladorClie datos) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboProducto = new JComboBox();
		comboProducto.setBounds(154, 24, 207, 44);
		getContentPane().add(comboProducto);
		
		cargarProductos(id, datos);
		comboVendedor = new JComboBox();
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
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviar.setBounds(299, 216, 89, 23);
		getContentPane().add(btnEnviar);
		
		JSpinner spinnerCant = new JSpinner();
		spinnerCant.setBounds(199, 156, 113, 35);
		getContentPane().add(spinnerCant);
	}

	private void cargarProductos(String id, ControladorClie datos) {
		// TODO Auto-generated method stub
		
	}
}
