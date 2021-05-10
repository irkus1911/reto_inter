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

import logica.*;
import modelo.*;

public class VSuministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
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

	 */
	/**
	 * Create the frame.
	 */
	public VSuministrador(VLogin vLogin, boolean b, String string, ControladorSum datos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnRevisarStock = new JButton("Stock");
		btnRevisarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRevisarStock.setBounds(123, 110, 122, 41);
		panel.add(btnRevisarStock);
		
		JButton btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.setBounds(10, 11, 105, 23);
		panel.add(btnCerrarSesion);
	}
}










