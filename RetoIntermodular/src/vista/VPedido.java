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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import logica.*;
import modelo.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class VPedido extends JDialog {
	private static final long serialVersionUID = 1L;
	private JComboBox comboProducto, comboVendedor;
	private String id_prod;
	private String id_com;
	private String id_sum;
	private SpinnerModel sm;
	private JSpinner spinnerCant;
	private JButton btnEnviar, btnAtras;

	// VPedido para Clientes
	/**
	 * @wbp.parser.constructor
	 */
	
	public VPedido(VCliente clie, boolean b, String id, ControladorClie datos) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		comboProducto = new JComboBox();
		comboProducto.setBounds(154, 24, 207, 44);
		getContentPane().add(comboProducto);
		cargarProductos(id, datos);
		comboProducto.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				comboVendedor.removeAllItems();
				if (comboProducto.getSelectedIndex() != -1) {
					id_prod = comboProducto.getSelectedItem().toString().substring(0,
							comboProducto.getSelectedItem().toString().indexOf(" - "));
					cargarVendedor(id_prod, id, datos);
				}

			}
		});

		comboVendedor = new JComboBox();
		comboVendedor.setBounds(154, 79, 207, 44);
		getContentPane().add(comboVendedor);
		comboVendedor.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (comboVendedor.getSelectedIndex() != -1) {
					id_com = comboVendedor.getSelectedItem().toString().substring(0,
							comboVendedor.getSelectedItem().toString().indexOf(" - "));
					sm = new SpinnerNumberModel(0, 0, leerCantidad(id_prod, id_com, datos), 1);
					spinnerCant.setModel(sm);
					spinnerCant.setVisible(true);
				}
			}
		});

		spinnerCant = new JSpinner(new SpinnerNumberModel(0, 0, 0, 0));
		spinnerCant.setBounds(199, 156, 113, 35);
		getContentPane().add(spinnerCant);
		spinnerCant.setVisible(false);

		btnAtras = new JButton("Atr\u00E1s");
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

	// VPedido para Comercios
	public VPedido(VComercio com, boolean b, String id, ControladorCom datos) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		comboProducto = new JComboBox();
		comboProducto.setBounds(154, 24, 207, 44);
		getContentPane().add(comboProducto);
		cargarProductos(id, datos);
		comboProducto.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				comboVendedor.removeAllItems();
				if (comboProducto.getSelectedIndex() != -1) {
					id_prod = comboProducto.getSelectedItem().toString().substring(0,
							comboProducto.getSelectedItem().toString().indexOf(" - "));
					cargarVendedor(id_prod, id, datos);
				}

			}
		});

		comboVendedor = new JComboBox();
		comboVendedor.setBounds(154, 79, 207, 44);
		getContentPane().add(comboVendedor);
		comboVendedor.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (comboVendedor.getSelectedIndex() != -1) {
					id_sum = comboVendedor.getSelectedItem().toString().substring(0,
							comboVendedor.getSelectedItem().toString().indexOf(" - "));
					sm = new SpinnerNumberModel(0, 0, leerCantidad(id_prod, id_sum, datos), 1);
					spinnerCant.setModel(sm);
					spinnerCant.setVisible(true);
				}
			}
		});

		spinnerCant = new JSpinner(new SpinnerNumberModel(0, 0, 0, 0));
		spinnerCant.setBounds(199, 156, 113, 35);
		getContentPane().add(spinnerCant);
		spinnerCant.setVisible(false);

		btnAtras = new JButton("Atr\u00E1s");
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

	
	// Metodos del Cliente
	private int leerCantidad(String id_prod, String id_com, ControladorClie datos) {
	
		try {
			return datos.listarCant(id_com, id_prod);
		} catch (ReadException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private void cargarVendedor(String id_prod, String id_clie, ControladorClie datos) {
		
		try {
			Collection<Comercio> comercios = datos.listarVendedor(id_prod,id_clie);
			for (Comercio com : comercios) {
				comboVendedor.addItem(com.getCifCom() + " - " + com.getTipoCom() + ": " + com.getNombreCom());
			}
			comboVendedor.setSelectedIndex(-1);
		} catch (ReadException e) {
			e.printStackTrace();
		}
	}

	private void cargarProductos(String id, ControladorClie datos) {

		try {
			Collection<Producto> productos = datos.listarProd();
			for (Producto prod : productos) {
				comboProducto.addItem(prod.getId() + " - " + prod.getNomProducto());
			}
			comboProducto.setSelectedIndex(-1);
		} catch (ReadException e) {
			e.printStackTrace();
		}
	}

	private void realizarPedido(String id_clie, ControladorClie datos) {
	
		try {
			datos.crearPedidoClieCom(id_clie, id_com, id_prod, ((Integer) spinnerCant.getValue()));
			JOptionPane.showMessageDialog(btnEnviar, "Se ha realizado el pedido exitosamente", "Pedido realizado",
					JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		} catch (CreateException e) {
			e.printStackTrace();
		}
	}
	
	
	// Metodos del Comercio
	private int leerCantidad(String id_prod, String id_sum, ControladorCom datos) {
		
		try {
			return datos.listarCant(id_sum, id_prod);
		} catch (ReadException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private void cargarVendedor(String id_prod, String id_sum, ControladorCom datos) {
	
		try {
			Collection<Suministrador> suministradores = datos.listarVendedor(id_prod, id_sum);
			for (Suministrador sum : suministradores) {
				comboVendedor.addItem(sum.getCifSum() + " - " + sum.getNombreSum());
			}
			comboVendedor.setSelectedIndex(-1);
		} catch (ReadException e) {
			e.printStackTrace();
		}
	}

	private void cargarProductos(String id, ControladorCom datos) {

		try {
			Collection<Producto> productos = datos.listarProd();
			for (Producto prod : productos) {
				comboProducto.addItem(prod.getId() + " - " + prod.getNomProducto());
			}
			comboProducto.setSelectedIndex(-1);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void realizarPedido(String id_com, ControladorCom datos) {
		
		try {
			datos.crearPedidoComSum(id_com, id_sum, id_prod, ((Integer) spinnerCant.getValue()));
			JOptionPane.showMessageDialog(btnEnviar, "Se ha realizado el pedido exitosamente", "Pedido realizado",
					JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		} catch (CreateException e) {
			e.printStackTrace();
		}
	}
}
