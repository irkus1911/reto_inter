package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VAdministrador extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCerrarSesion;
	private JButton btnAcceso;
	private JComboBox comboTipoUsuarioAlta ;
	private JButton btnAlta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAdministrador frame = new VAdministrador();
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
	public VAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnAlta = new JButton("Alta");
		btnAlta.setBounds(304, 206, 89, 23);
		contentPane.add(btnAlta);
		
		 comboTipoUsuarioAlta = new JComboBox();
		comboTipoUsuarioAlta.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Comercio", "Suministrador"}));
		comboTipoUsuarioAlta.setSelectedIndex(-1);
		comboTipoUsuarioAlta.setBounds(85, 109, 270, 22);
		contentPane.add(comboTipoUsuarioAlta);
		
		 btnAcceso = new JButton("Acceder");
		btnAcceso.setBounds(67, 206, 89, 23);
		contentPane.add(btnAcceso);
		
		 btnCerrarSesion = new JButton("CerrarSesion");
		btnCerrarSesion.setBounds(10, 11, 120, 23);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(this);
		btnAcceso.addActionListener(this);
		btnAlta.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCerrarSesion)) {
			//posible option pane(pop-up)
			VBienvenida vBienve=new VBienvenida(null, null, null, null);
			vBienve.setVisible(true);
			this.dispose();
		}else if(e.getSource().equals(btnAcceso)){
			if(comboTipoUsuarioAlta.getSelectedIndex()==0) {
				VCliente vClie=new VCliente();
				vClie.setVisible(true);
				this.dispose();
				
			}else if(comboTipoUsuarioAlta.getSelectedIndex()==1) {
				VComercio vComer=new VComercio();
				vComer.setVisible(true);
				this.dispose();
				
			}else if(comboTipoUsuarioAlta.getSelectedIndex()==2) {
				VSuministrador vSumi=new VSuministrador(id_sum, null);
				vSumi.setVisible(true);
				this.dispose();
				
			}else {
				JOptionPane.showMessageDialog(btnAcceso, "Error seleccion incorrecta", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}else {
			//Pasar esto a otra pestaña
			
			
		}
		
	}
}
