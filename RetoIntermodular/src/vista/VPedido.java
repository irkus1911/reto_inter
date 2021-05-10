package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import logica.*;
import modelo.*;

public class VPedido extends JDialog {
	private static final long serialVersionUID = 1L;
	private JComboBox comboProducto;
	private JComboBox comboVendedor;
	private String id_prod;
	private String id_com;
	private SpinnerModel sm;
	private JSpinner spinnerCant;
	private JButton btnEnviar;
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
		comboProducto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(comboProducto.getSelectedIndex()!=-1) {
					id_prod=comboProducto.getSelectedItem().toString().substring(0,comboProducto.getSelectedItem().toString().indexOf(" - "));
					cargarVendedor(id_prod,datos);
				}
			
			}
		});
		comboProducto.setBounds(154, 24, 207, 44);
		getContentPane().add(comboProducto);
		cargarProductos(id, datos);
		
		
		comboVendedor = new JComboBox();
		comboVendedor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(comboVendedor.getSelectedIndex()!=-1) {
					id_com=comboVendedor.getSelectedItem().toString().substring(0,comboVendedor.getSelectedItem().toString().indexOf(" - "));
					sm = new SpinnerNumberModel(0, 0,leerCantidad(id_prod,id_com,datos) , 1);
					spinnerCant = new JSpinner(sm);
					spinnerCant.setBounds(199, 156, 113, 35);
					getContentPane().add(spinnerCant);
					
				}
			}
		});
		comboVendedor.setBounds(154, 79, 207, 44);
		getContentPane().add(comboVendedor);
		
		
		
		
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(47, 216, 89, 23);
		getContentPane().add(btnAtras);
		
		btnEnviar = new JButton("Continuar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			realizarPedido(id, datos);
			}
		});
		btnEnviar.setBounds(299, 216, 89, 23);
		getContentPane().add(btnEnviar);
		
		
		
	}

	private void realizarPedido(String id_clie,ControladorClie datos) {
		// TODO Auto-generated method stub
		try {
			datos.crearPedidoClieCom(id_clie, id_com, id_prod, ((Integer)spinnerCant.getValue()));
			JOptionPane.showMessageDialog(btnEnviar, "Se ha realizado el pedido exitosamente", "Pedido realizado", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int leerCantidad(String id_prod, String id_com, ControladorClie datos) {
		// TODO Auto-generated method stub
		try {
			return datos.listarCant(id_com, id_prod);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	private void cargarVendedor(String id_prod, ControladorClie datos) {
		// TODO Auto-generated method stub
		try {
			Collection<Comercio> comercios = datos.listarVendedor();
		for (Comercio com : comercios) {
			comboVendedor.addItem(com.getCifCom() +" - "+com.getTipoCom()+": "+ com.getNombreCom());
		}
		comboVendedor.setSelectedIndex(-1);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cargarProductos(String id, ControladorClie datos) {
		// TODO Auto-generated method stub
		
		try {
			Collection<Producto> productos = datos.listarProd();
		for (Producto prod : productos) {
			comboProducto.addItem(prod.getId() +" - "+ prod.getNomProducto());
		}
		comboProducto.setSelectedIndex(-1);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
