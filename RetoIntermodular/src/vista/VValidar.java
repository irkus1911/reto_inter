package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Collection;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import logica.*;
import modelo.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class VValidar extends JDialog {
	private JComboBox comboPedido;
	private JButton btnAtras;
	private JButton btnContinuar;
	private String id_com;
	private String id_prod;
	private LocalDate fecha;
	
		
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
				
				validarPedido(id,datos);
				
			}
		});
		btnContinuar.setBounds(313, 108, 89, 23);
		getContentPane().add(btnContinuar);

	}
	
	private  void validarPedido(String id, ControladorSum datos) {
		if(comboPedido.getSelectedIndex()!=-1) {
		String pedido= comboPedido.getSelectedItem().toString();
		
		id_com = pedido.substring(0, pedido.indexOf(" - "));
		id_prod = pedido.substring(pedido.lastIndexOf(" - ")+1,pedido.indexOf(" cantidad: "));
		fecha = LocalDate.parse(pedido.substring(pedido.lastIndexOf(" Fecha: ")+1));
		datos.validarPedidoSum(id, id_com,id_prod, fecha);
		}else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun pedido",
					"Error seleccion pedido", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarPedidos(String id, ControladorSum datos) {
		try {
			Collection<Pedido> pedidos = datos.listarPed(id);
			for (Pedido ped : pedidos) {
				if (!ped.isEstado()) {
					comboPedido.addItem(ped.getIdComprador() + " - " + ped.getIdProd() + " cantidad: " + ped.getCant()+" Fecha: "+ped.getFecha());
				}
			}
			comboPedido.setSelectedIndex(-1);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}

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
				
				validarPedido(id,datos);
				
			}
		});
		btnContinuar.setBounds(313, 108, 89, 23);
		getContentPane().add(btnContinuar);
		
	}
	
	private  void validarPedido(String id, ControladorCom datos) {
		if(comboPedido.getSelectedIndex()!=-1) {
			String pedido= comboPedido.getSelectedItem().toString();
			
			id_com = pedido.substring(0, pedido.indexOf(" - "));
			id_prod = pedido.substring(pedido.lastIndexOf(" - ")+1,pedido.indexOf(" cantidad: "));
			fecha = LocalDate.parse(pedido.substring(pedido.lastIndexOf(" Fecha: ")+1));
			datos.validarPedidoCom(id, id_com,id_prod, fecha);
		}else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun pedido",
					"Error seleccion pedido", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void cargarPedidos(String id, ControladorCom datos) {
		try {
			Collection<Pedido> pedidos = datos.listarPed(id);
			for (Pedido ped : pedidos) {
				if (!ped.isEstado()) {
					comboPedido.addItem(ped.getIdComprador() + " - " + ped.getIdProd() + " cantidad: " + ped.getCant()+" Fecha: "+ped.getFecha());
				}
			}
			comboPedido.setSelectedIndex(-1);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
