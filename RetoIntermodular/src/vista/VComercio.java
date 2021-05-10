package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ControladorClie;
import logica.ControladorCom;
import logica.ReadException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VComercio extends JFrame {

	private JPanel contentPane;
	private JButton btnCerrarSesion;

	public VComercio(VLogin vLogin, boolean b, String id, ControladorCom datos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRevisarStock = new JButton("Stock");
		btnRevisarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockCom(id, datos);
			}
		});
		btnRevisarStock.setBounds(159, 140, 89, 23);
		contentPane.add(btnRevisarStock);

		JButton btnHacerPedido = new JButton("Realizar pedido");
		btnHacerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido(id, datos);
			}
		});
		btnHacerPedido.setBounds(263, 89, 135, 23);
		contentPane.add(btnHacerPedido);

		JButton btnHistoricoCliente = new JButton("Historico cliente");
		btnHistoricoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historicoClieCom(id, datos);
			}
		});
		btnHistoricoCliente.setBounds(30, 192, 130, 23);
		contentPane.add(btnHistoricoCliente);

		JButton btnHistoricoSuministrador = new JButton("Historico Suministrador");
		btnHistoricoSuministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historicoComSum(id, datos);
			}
		});
		btnHistoricoSuministrador.setBounds(247, 192, 177, 23);
		contentPane.add(btnHistoricoSuministrador);

		JButton btnValidarPedidos = new JButton("Validar Pedidos");
		btnValidarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				validarPedido(id, datos);	
			}
		});
		btnValidarPedidos.setBounds(30, 89, 130, 23);
		contentPane.add(btnValidarPedidos);

		JButton btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion(datos);
			}
		});
		btnCerrarSesion.setBounds(30, 26, 109, 23);
		contentPane.add(btnCerrarSesion);
	}
	
	private void cerrarSesion(ControladorCom datos) {
		try {
			this.dispose();
		//	VLogin login = new VLogin(datos);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al Cargar la Ventana", "Error Lectura Ventana",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validarPedido(String id, ControladorCom datos) {

		try {
			VValidar vali = new VValidar(this, true, id, datos);
			vali.setVisible(true);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al abrir Ventana", "Error lectura Ventana",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void stockCom(String id, ControladorCom datos) {
		
		try {
			VStock stock = new VStock(this, true, id, datos);
			stock.setVisible(true);
			
			//MOdificado Excepcion (ReadException)
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void historicoClieCom(String id, ControladorCom datos) {

		//BOTON HABILITADO PERO NO FUNCIONAL
		try {
			VHistorico hist = new VHistorico(this, true, id, datos);
			hist.setVisible(true);
		} catch (ReadException e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void historicoComSum(String id, ControladorCom datos) {
		
		// SELECT MAL IMPLEMENTADA 
		
		try {
			VHistorico hist = new VHistorico(this, true, id, datos);
			hist.setVisible(true);
		} catch (ReadException e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void pedido(String id, ControladorCom datos) {

		VPedido ped = new VPedido(this, true, id, datos);
		ped.setVisible(true);
	}

}
