package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import logica.ControladorCom;
import logica.ControladorSum;
import logica.ReadException;
import logica.UpdateException;
import modelo.Pedido;

public class VValidar extends JDialog {
	private JComboBox comboPedido;
	private JButton btnAtras;
	private JButton btnContinuar;

	private String id_prod;
	private LocalDateTime fecha;

	public VValidar(VSuministrador vSuministrador, boolean b, String id, ControladorSum datos) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		comboPedido = new JComboBox();
		comboPedido.setBounds(31, 95, 258, 48);
		getContentPane().add(comboPedido);
		cargarPedidos(id, datos);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(156, 208, 89, 23);
		getContentPane().add(btnAtras);

		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarPedido(id, datos);
			}
		});
		btnContinuar.setBounds(313, 108, 89, 23);
		getContentPane().add(btnContinuar);

	}

	public VValidar(VComercio vCom, boolean b, String id, ControladorCom datos) {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		comboPedido = new JComboBox();
		comboPedido.setBounds(31, 95, 258, 48);
		getContentPane().add(comboPedido);
		cargarPedidos(id, datos);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(156, 208, 89, 23);
		getContentPane().add(btnAtras);

		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarPedido(id, datos);
			}
		});
		btnContinuar.setBounds(313, 108, 89, 23);
		getContentPane().add(btnContinuar);

	}

	private void validarPedido(String id, ControladorCom datos) {
		if (comboPedido.getSelectedIndex() != -1) {
			String pedido = comboPedido.getSelectedItem().toString();

			String id_clie = pedido.substring(0, pedido.indexOf(" - "));
			id_prod = pedido.substring(pedido.lastIndexOf(" - ") + 3, pedido.indexOf(" ca"));
			fecha = LocalDateTime.parse(pedido.substring(pedido.lastIndexOf("a: ") + 3, pedido.length()));
			try {
				datos.validarPedidoCom(id_clie, id, id_prod, fecha);
				JOptionPane.showMessageDialog(this, "Pedido validado correctamente", "Pedido validado",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (UpdateException e) {
				JOptionPane.showMessageDialog(this, "Error al intentar actualizar datos de la base de datos",
						"Error update BBDD", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun pedido", "Error seleccion pedido",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarPedidos(String id, ControladorCom datos) {

		try {
			Collection<Pedido> pedidos = datos.listarPed(id);
			for (Pedido ped : pedidos) {
				if (!ped.isEstado()) {
					comboPedido.addItem(ped.getIdComprador() + " - " + ped.getIdProd() + " cantidad: " + ped.getCant()
							+ " Fecha: " + ped.getFecha());
				}
			}
			comboPedido.setSelectedIndex(-1);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void validarPedido(String id, ControladorSum datos) {
		if (comboPedido.getSelectedIndex() != -1) {
			String pedido = comboPedido.getSelectedItem().toString();

			String id_com = pedido.substring(0, pedido.indexOf(" - "));
			id_prod = pedido.substring(pedido.lastIndexOf(" - ") + 3, pedido.indexOf(" ca"));
			fecha =  LocalDateTime.parse(pedido.substring(pedido.lastIndexOf("a: ") + 3, pedido.length()));
			try {
				datos.validarPedidoSum(id, id_com, id_prod, fecha);
				JOptionPane.showMessageDialog(this, "Pedido validado correctamente", "Pedido validado",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (UpdateException e) {
				JOptionPane.showMessageDialog(this, "Error al intentar actualizar datos de la base de datos",
						"Error update BBDD", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun pedido", "Error seleccion pedido",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarPedidos(String id, ControladorSum datos) {

		try {
			Collection<Pedido> pedidos = datos.listarPed(id);
			for (Pedido ped : pedidos) {
				if (!ped.isEstado()) {
					comboPedido.addItem(ped.getIdComprador() + " - " + ped.getIdProd() + " cantidad: " + ped.getCant()
							+ " Fecha: " + ped.getFecha());

				}

			}
			comboPedido.setSelectedIndex(-1);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}

	}
}
