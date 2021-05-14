package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.*;
import modelo.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnRealizarPedido;
	private JButton btnConsultarPedidos;
	private JPanel contentPane;
	private JButton btnCerrarSesion;


	public VCliente(VLogin vLogin, String id, ControladorClie datos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido(id, datos);

			}
		});
		btnRealizarPedido.setBounds(52, 92, 129, 57);
		contentPane.add(btnRealizarPedido);

		btnConsultarPedidos = new JButton("Consultar Pedidos");
		btnConsultarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarPedido(id, datos);
			}
		});
		btnConsultarPedidos.setBounds(234, 92, 129, 57);
		contentPane.add(btnConsultarPedidos);

		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarSesion(datos);
			}
		});
		btnCerrarSesion.setBounds(307, 228, 117, 23);
		contentPane.add(btnCerrarSesion);
	}

	private void cerrarSesion(ControladorClie datos) {
	
		try {
			VBienvenida vent = new VBienvenida();
			vent.setVisible(true);
			vent.setLocationRelativeTo(null);
			this.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al Cargar la Ventana", "Error Lectura Ventana",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void consultarPedido(String id, ControladorClie datos) {
		
		try {
			VHistorico hist = new VHistorico(this, true, id, datos);
			hist.setVisible(true);
			hist.setLocationRelativeTo(null);
		} catch (ReadException e1) {
			JOptionPane.showMessageDialog(btnConsultarPedidos,
					"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void pedido(String id, ControladorClie datos) {
		
		VPedido ped = new VPedido(this, true, id, datos);
		ped.setVisible(true);
		ped.setLocationRelativeTo(null);
	}

}
