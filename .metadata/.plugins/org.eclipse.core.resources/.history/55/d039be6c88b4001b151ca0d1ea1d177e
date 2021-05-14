package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import logica.*;
import modelo.*;

public class VSuministrador extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnRevisarStock ;
	private JButton btnCerrarSesion;
	private JButton btnAñadirProducto;
	private JButton btnValidarPedidos;
	private JButton btnHistorico;
	private String id_sum;
	private ControladorSum datos;
	
	public VSuministrador(VLogin vLogin, boolean b, String id_sum,ControladorSum datos) {
	
		this.datos=datos;
		this.id_sum=id_sum;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		 btnRevisarStock = new JButton("Stock");
		
		btnRevisarStock.setBounds(26, 79, 156, 41);
		panel.add(btnRevisarStock);
		
		 btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.setBounds(10, 11, 138, 30);
		panel.add(btnCerrarSesion);
		
		 btnAñadirProducto = new JButton("A\u00F1adir Producto");
		btnAñadirProducto.setBounds(258, 79, 156, 41);
		panel.add(btnAñadirProducto);
		
		 btnValidarPedidos = new JButton("Validar Pedidos");
		btnValidarPedidos.setBounds(26, 175, 156, 41);
		panel.add(btnValidarPedidos);
		
		 btnHistorico = new JButton("Historico");
		btnHistorico.setBounds(258, 175, 156, 41);
		panel.add(btnHistorico);
		
		btnAñadirProducto.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
		btnHistorico.addActionListener(this);
		btnRevisarStock.addActionListener(this);
		btnValidarPedidos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnAñadirProducto)) {
			VProducto ven=new VProducto(datos,id_sum);
			ven.setVisible(true);
			ven.setLocationRelativeTo(null);

		}
		if(e.getSource().equals(btnCerrarSesion)) {
			this.dispose();
		}
		if(e.getSource().equals(btnHistorico)) {
			try {
				consultarPedido(id_sum,datos);
			} catch (ReadException e1) {
				JOptionPane.showMessageDialog(btnCerrarSesion,
						"Error al intentar ver el historico de pedidos", "Error lectura BBDD",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource().equals(btnRevisarStock)) {
			VStock ven=new VStock(this,true,id_sum,datos);
			ven.setVisible(true);
			ven.setLocationRelativeTo(null);
		
			
		}
		if(e.getSource().equals(btnValidarPedidos)) {
			VValidar ven=new VValidar(this, true, id_sum, datos);
			ven.setVisible(true);
			ven.setLocationRelativeTo(null);
		
		}
	}
	private void consultarPedido(String id, ControladorSum datos) throws ReadException {
		VHistorico hist = new VHistorico(this, true, id, datos);
		hist.setVisible(true);
		hist.setLocationRelativeTo(null);
	}
}
