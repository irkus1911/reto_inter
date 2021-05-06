package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ControladorSum;
import modelo.ControladorSumImplementacion;
import modelo.Stock;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class VStock extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaStock;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { VStock dialog = new VStock( );
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 * 
	 * @param datos
	 * @param b
	 * @param vSuministrador
	 */
	public VStock(VSuministrador vSuministrador, boolean b, String id_sum, ControladorSum datos) {

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

			JLabel lblNombreStock = new JLabel("Stock de ....");
			lblNombreStock.setBounds(69, 11, 337, 23);
			contentPanel.add(lblNombreStock);

			ControladorSumImplementacion sum = new ControladorSumImplementacion();
			Collection<Stock> stock = new HashSet<Stock>();
			stock = sum.stockSum(id_sum);
			String[] columnas = { "Suministrador", "Producto", "Cantidad" };
			tablaStock = new JTable(cargarStockSum(datos, stock), columnas);
			tablaStock.setBounds(24, 194, 414, 168);

			contentPanel.add(tablaStock);

		}

	}

	protected String[][] cargarStockSum(ControladorSum datos, Collection<Stock> stock) {
		int cont = 1;
		String[][] tablaStock = new String[stock.size() + 1][4];
		tablaStock[0][0] = "ID PRODUCTO";
		tablaStock[0][1] = "PRODUCTO";
		tablaStock[0][2] = "CANTIDAD EN STOCK";

		for (Stock st : stock) {
			tablaStock[cont][0] = st.getId_prod();
			tablaStock[cont][1] = st.getNomProducto();
			tablaStock[cont][2] = String.valueOf(st.getCantidad());

			cont++;
		}
		return tablaStock;
	}
}
