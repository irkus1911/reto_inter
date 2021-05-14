package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.*;
import modelo.*;

public class VStock extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableStock;

	
	//STOCK SUMINISTRADOR
	
	
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
					dispose();
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(btnNewButton);

			JLabel lblNombreStock = new JLabel("Stock de ....");
			lblNombreStock.setBounds(69, 11, 337, 23);
			contentPanel.add(lblNombreStock);

			Collection<Stock> stock = new HashSet<Stock>();
			try {
				stock = datos.stockSum(id_sum);
			} catch (ReadException e1) {
				JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
						"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
				
			}
			String[] columnas = { "Suministrador", "Producto", "Cantidad" };
			tableStock = new JTable(cargarStockSum(datos, stock), columnas);
			tableStock.setBounds(36, 65, 347, 132);

			contentPanel.add(tableStock);
		}
	}
	
	
	//STOCK COMERCIO
	
	public VStock(VComercio vComercio, boolean b, String id_com, ControladorCom datos) {

		//POR ACABAR
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton btnNewButton = new JButton("Atras");
			btnNewButton.setBounds(10, 227, 89, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(btnNewButton);

			JLabel lblNombreStock = new JLabel("Stock de ....");
			lblNombreStock.setBounds(69, 11, 337, 23);
			contentPanel.add(lblNombreStock);

			Collection<Stock> stock = new HashSet<Stock>();
			try {
				stock = datos.stockCom(id_com);
				
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
						"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
				
			}
			String[] columnas = { "Suministrador", "Producto", "Cantidad" };
			tableStock = new JTable(cargarStockCom(datos, stock), columnas);
			tableStock.setBounds(36, 65, 347, 132);

			contentPanel.add(tableStock);
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
	
	
	protected String[][] cargarStockCom(ControladorCom datos, Collection<Stock> stock) {
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
