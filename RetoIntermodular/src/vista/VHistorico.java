package vista;

import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import logica.*;
import modelo.*;

public class VHistorico extends JDialog {
	private JTable tableHistorico;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			VHistorico dialog = new VHistorico();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public VHistorico(VCliente clie, boolean b, String id, ControladorClie datos) throws ReadException {
		this.setModal(b);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
			JLabel lblNombreHistorico = new JLabel("Historico de ...");
			lblNombreHistorico.setBounds(89, 11, 200, 39);
			getContentPane().add(lblNombreHistorico);
			
			JButton btnAtras = new JButton("Atras");
			btnAtras.setBounds(172, 227, 89, 23);
			getContentPane().add(btnAtras);
			

		String[] columnas = { "VENDEDOR", "PRODUCTO", "CANTIDAD", "FECHA" };
		try {
			Collection<Historico> historico = datos.historicoClieCom(id);
			
			tableHistorico = new JTable(cargarHistoricoClie(datos, historico), columnas);
			tableHistorico.setBounds(36, 65, 347, 132);
			getContentPane().add(tableHistorico);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		
	
	}

	/*public VHistorico(ActionListener actionListener, boolean b, String id, ControladorCom datos) throws ReadException {
		this.setModal(b);
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

		String[] columnas = { "VENDEDOR", "PRODUCTO", "CANTIDAD", "FECHA" };
		try {
			Collection<Historico> historico = datos.historicoComSum(id);
			tableHistorico = new JTable(cargarHistoricoCom(datos, historico), columnas);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		tableHistorico.setBounds(24, 194, 414, 168);

	}*/

	protected String[][] cargarHistoricoClie(ControladorClie datos, Collection<Historico> historico) {
		int cont = 1;
		String[][] histTabla = new String[historico.size() + 1][4];
		histTabla[0][0] = "COMERCIO";
		histTabla[0][1] = "PRODUCTO";
		histTabla[0][2] = "CANTIDAD COMPRADA";
		histTabla[0][3] = "FECHA COMPRA";

		for (Historico hist : historico) {
			histTabla[cont][0] = hist.getVendedor();
			histTabla[cont][1] = hist.getProducto();
			histTabla[cont][2] = String.valueOf(hist.getCant());
			histTabla[cont][3] = hist.getFecha().toString();
			cont++;
		}
		return histTabla;
	}

	protected String[][] cargarHistoricoCom(ControladorCom datos, Collection<Historico> historico) {
		int cont = 1;
		String[][] histTabla = new String[historico.size() + 1][4];
		histTabla[0][0] = "COMERCIO";
		histTabla[0][1] = "PRODUCTO";
		histTabla[0][2] = "CANTIDAD COMPRADA";
		histTabla[0][3] = "FECHA COMPRA";

		for (Historico hist : historico) {
			histTabla[cont][0] = hist.getVendedor();
			histTabla[cont][1] = hist.getProducto();
			histTabla[cont][2] = String.valueOf(hist.getCant());
			histTabla[cont][3] = hist.getFecha().toString();
			cont++;
		}
		return histTabla;
	}

}
