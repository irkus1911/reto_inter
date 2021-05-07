package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;

public class VHistorico extends JDialog {
	private JTable tableHistorico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VHistorico dialog = new VHistorico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VHistorico() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblNombreHistorico = new JLabel("Historico de ...");
			lblNombreHistorico.setBounds(89, 11, 200, 39);
			getContentPane().add(lblNombreHistorico);
		}
		{
			tableHistorico = new JTable();
			tableHistorico.setBounds(56, 76, 268, 90);
			getContentPane().add(tableHistorico);
		}
		{
			JButton btnAtras = new JButton("Atras");
			btnAtras.setBounds(10, 227, 89, 23);
			getContentPane().add(btnAtras);
		}
	}

}
