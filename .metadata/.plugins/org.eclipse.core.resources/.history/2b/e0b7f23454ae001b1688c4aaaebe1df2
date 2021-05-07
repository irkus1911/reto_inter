package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCliente frame = new VCliente();
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
	public VCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.setBounds(52, 92, 129, 57);
		contentPane.add(btnRealizarPedido);
		
		JButton btnConsultarPedidos = new JButton("Consultar Pedidos");
		btnConsultarPedidos.setBounds(234, 92, 129, 57);
		contentPane.add(btnConsultarPedidos);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(307, 228, 117, 23);
		contentPane.add(btnCerrarSesion);
	}

}
