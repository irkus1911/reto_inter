package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ControladorCom;

import javax.swing.JButton;

public class VComercio extends JFrame {

	private JPanel contentPane;

	
	public VComercio(VLogin vLogin, boolean b, String text, ControladorCom datos)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRevisarStock = new JButton("Stock");
		btnRevisarStock.setBounds(159, 140, 89, 23);
		contentPane.add(btnRevisarStock);
		
		JButton btnHacerPedido = new JButton("Realizar pedido");
		btnHacerPedido.setBounds(263, 89, 135, 23);
		contentPane.add(btnHacerPedido);
		
		JButton btnHistoricoCliente = new JButton("Historico cliente");
		btnHistoricoCliente.setBounds(30, 192, 130, 23);
		contentPane.add(btnHistoricoCliente);
		
		JButton btnHistoricoSuministrador = new JButton("Historico Suministrador");
		btnHistoricoSuministrador.setBounds(247, 192, 177, 23);
		contentPane.add(btnHistoricoSuministrador);
		
		JButton btnValidarPedidos = new JButton("Validar Pedidos");
		btnValidarPedidos.setBounds(30, 89, 130, 23);
		contentPane.add(btnValidarPedidos);
		
		JButton btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.setBounds(30, 26, 109, 23);
		contentPane.add(btnCerrarSesion);
	}

}
