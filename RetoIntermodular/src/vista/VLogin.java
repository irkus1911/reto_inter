package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VLogin extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JTextField textFieldContraseina;
	private JButton btnCerrar;
	private JButton btnContinuar;
	private String tipoU;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VLogin dialog = new VLogin("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VLogin(String tipo) {
		tipoU=tipo;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(48, 67, 46, 14);
			contentPanel.add(lblId);
		}
		
		textFieldId = new JTextField();
		textFieldId.setBounds(104, 64, 240, 20);
		contentPanel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblContraseina = new JLabel("Contrase\u00F1a");
		lblContraseina.setBounds(28, 129, 66, 14);
		contentPanel.add(lblContraseina);
		
		textFieldContraseina = new JTextField();
		textFieldContraseina.setBounds(104, 126, 240, 20);
		contentPanel.add(textFieldContraseina);
		textFieldContraseina.setColumns(10);
		
		 btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(335, 217, 89, 23);
		contentPanel.add(btnContinuar);
		
		 btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(236, 217, 89, 23);
		contentPanel.add(btnCerrar);
		
		JLabel lblTipo = new JLabel(tipo);
		lblTipo.setBounds(104, 11, 240, 20);
		contentPanel.add(lblTipo);
		btnCerrar.addActionListener(this);
		btnContinuar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCerrar)) {
			VBienvenida Vbienve=new VBienvenida();
			Vbienve.setVisible(true);
			this.dispose();
		}
		else if(e.getSource().equals(btnContinuar)) {
			if(tipoU.equalsIgnoreCase("Administrador")) {
				VAdministrador vAdmin=new VAdministrador();
				vAdmin.setVisible(true);
				this.dispose();
			}else if(tipoU.equalsIgnoreCase("Cliente")) {
				VCliente vClie=new VCliente();
				vClie.setVisible(true);
				this.dispose();
				
			}else if(tipoU.equalsIgnoreCase("Comercio")) {
				VComercio vComer=new VComercio();
				vComer.setVisible(true);
				this.dispose();
				
			}else if(tipoU.equalsIgnoreCase("Suministrador")) {
				VSuministrador vSumin=new VSuministrador();
				vSumin.setVisible(true);
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(btnContinuar, "Error seleccion incorrecta", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
