package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VSuministrador extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnRevisarStock ;
	private JButton btnCerrarSesion;
	private JButton btnAñadirProducto;
	private JButton btnValidarPedidos;
	private JButton btnHistorico;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VSuministrador frame = new VSuministrador();
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
	public VSuministrador() {
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
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnAñadirProducto)) {
			VProducto ven=new VProducto();
			ven.setVisible(true);
		
			
		}
		if(e.getSource().equals(btnCerrarSesion)) {
			VBienvenida ven=new VBienvenida();
			ven.setVisible(true);
			this.dispose();
		
		}
		if(e.getSource().equals(btnHistorico)) {
			VHistorico ven=new VHistorico();
			ven.setVisible(true);
		
			
		}
		if(e.getSource().equals(btnRevisarStock)) {
			VStock ven=new VStock();
			ven.setVisible(true);
		
			
		}
		if(e.getSource().equals(btnValidarPedidos)) {
			VValidar ven=new VValidar();
			ven.setVisible(true);
		
		}
	}
}
