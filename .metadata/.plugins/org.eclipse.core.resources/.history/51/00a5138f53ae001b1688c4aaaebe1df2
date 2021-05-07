package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class VValidar extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VValidar dialog = new VValidar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VValidar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(31, 95, 258, 48);
			getContentPane().add(comboBox);
		}
		{
			JButton btnAtras = new JButton("Atr\u00E1s");
			btnAtras.setBounds(156, 208, 89, 23);
			getContentPane().add(btnAtras);
		}
		{
			JButton btnContinuar = new JButton("Continuar");
			btnContinuar.setBounds(313, 108, 89, 23);
			getContentPane().add(btnContinuar);
		}
	}

}
