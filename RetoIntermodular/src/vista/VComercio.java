package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ControladorCom;
import logica.ReadException;

public class VComercio extends JFrame {

	private JPanel contentPane;
	private JButton btnCerrarSesion;
	private static String DISABLE_DIALOG_COMPONENTS = "Disable Dialog Components";
	private static String DISABLE_DIALOG = "Disable Dialog";

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

		

		JButton btnHistoricoSuministrador = new JButton("Historico compras y ventas");
		btnHistoricoSuministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historicoComSum(id, datos);
			}
		});
		btnHistoricoSuministrador.setBounds(118, 193, 177, 23);
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
	
	private void validarPedido(String id, ControladorCom datos) {

		try {
			VValidar vali = new VValidar(this, true, id, datos);
			vali.setVisible(true);
			vali.setLocationRelativeTo(null);
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
			stock.setLocationRelativeTo(null);
			
		/*	
		 * la mierda del pto focus para quitar los ptos botones
			stock.setFocusableWindowState(true);
			stock.transferFocus();
			stock.setFocusable(true);
			this.setFocusableWindowState(false);
			this.setFocusable(false);
			
			
			if(!this.hasFocus()) {
				System.out.println("no_CO");
			//	this.disable();
			//	this.disableEvents(EXIT_ON_CLOSE);
			}else {
				System.out.println("si_CO");
				this.enable();
			}
*/
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this,
					"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void historicoComSum(String id, ControladorCom datos) {
		
		try {
			VHistorico hist = new VHistorico(this, true, id, datos);
			hist.setVisible(true);
			hist.setLocationRelativeTo(null);
		} catch (ReadException e1) {
			JOptionPane.showMessageDialog(btnCerrarSesion,
					"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
					JOptionPane.ERROR_MESSAGE);
		}
	}	
	
	private void pedido(String id, ControladorCom datos) {

		VPedido ped = new VPedido(this, true, id, datos);
		ped.setVisible(true);
		ped.setLocationRelativeTo(null);
	}
}
