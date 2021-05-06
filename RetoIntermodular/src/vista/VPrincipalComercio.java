package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VPrincipalComercio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipalComercio frame = new VPrincipalComercio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VPrincipalComercio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRevisarStock = new JButton("Stock");
		btnRevisarStock.setBounds(59, 61, 89, 23);
		contentPane.add(btnRevisarStock);
		
		JButton btnHacerPedido = new JButton("Realizar pedido");
		btnHacerPedido.setBounds(247, 61, 135, 23);
		contentPane.add(btnHacerPedido);
		
		JButton btnHistoricoCliente = new JButton("Historico cliente");
		btnHistoricoCliente.setBounds(59, 158, 130, 23);
		contentPane.add(btnHistoricoCliente);
		
		JButton btnHistoricoSuministrador = new JButton("Historico Suministrador");
		btnHistoricoSuministrador.setBounds(247, 158, 177, 23);
		contentPane.add(btnHistoricoSuministrador);
		
		JButton btnValidarPedidos = new JButton("Validar Pedidos");
		btnValidarPedidos.setBounds(150, 111, 130, 23);
		contentPane.add(btnValidarPedidos);
	}

}
