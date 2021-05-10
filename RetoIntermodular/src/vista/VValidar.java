package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Collection;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import logica.*;
import modelo.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VValidar extends JDialog {
	private JComboBox comboPedido;
	private JButton btnAtras;
	private JButton btnContinuar;
	private String id_com;
	private String id_prod;
	private Date fecha;
	
		
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
				if(comboPedido.getSelectedIndex()!=-1) {
				validarPedido(id,datos);
				}else {
					
				}
			}
		});
		btnContinuar.setBounds(313, 108, 89, 23);
		getContentPane().add(btnContinuar);

	}
	// Sin acabar
	private  void validarPedido(String id, ControladorSum datos) {
		String pedido= comboPedido.getSelectedItem().toString();
		
		id_com = pedido.substring(0, pedido.indexOf(" - "));
		id_prod = pedido.substring(pedido.lastIndexOf(" - ")+1,pedido.indexOf(" cantidad: "));
		fecha = Util.StringToDate(pedido.substring(pedido.lastIndexOf(" Fecha: ")+1));
		
		
	
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
