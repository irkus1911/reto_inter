package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;

public class VStock extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VStock dialog = new VStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VStock() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton btnNewButton = new JButton("Atras");
			btnNewButton.setBounds(10, 227, 89, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(btnNewButton);
		}
		
		JLabel lblNombreStock = new JLabel("Stock de ....");
		lblNombreStock.setBounds(69, 11, 227, 23);
		contentPanel.add(lblNombreStock);
		
		tableStock = new JTable();
		tableStock.setBounds(94, 78, 227, 90);
		contentPanel.add(tableStock);
	}
}
