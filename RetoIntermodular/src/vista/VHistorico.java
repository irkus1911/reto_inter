package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import logica.*;
import modelo.*;

public class VHistorico extends JDialog {
	
	private JTable tableHistorico;

	/**
	 * @wbp.parser.constructor
	 */
	
	public VHistorico(VCliente clie, boolean b, String id, ControladorClie datos) throws ReadException {
		this.setModal(b);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNombreHistorico = new JLabel("Historico de ...");
		lblNombreHistorico.setBounds(89, 11, 200, 39);
		getContentPane().add(lblNombreHistorico);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
	
	public VHistorico(VComercio vCom, boolean b, String id, ControladorCom datos) throws ReadException {
		this.setModal(b);
		setBounds(100, 100, 450, 400);
		
		JTabbedPane pestañas=new JTabbedPane();
		JPanel histCompras = new JPanel();
		histCompras.setLayout(null);
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(172, 227, 89, 23);
		histCompras.add(btnAtras);

		String[] columnasCompras = { "VENDEDOR", "PRODUCTO", "CANTIDAD", "FECHA" };
		try {
			Collection<Historico> historicoCompras = datos.historicoComSum(id);
			tableHistorico = new JTable(cargarHistoricoCom_Sum(datos, historicoCompras), columnasCompras);
			tableHistorico.setBounds(36, 65, 347, 132);
			histCompras.add(tableHistorico);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		JPanel histVentas = new JPanel();
		histVentas.setLayout(null);
	

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(172, 227, 89, 23);
		histVentas.add(btnAtras);

		String[] columnasVentas = { "COMPRADOR", "PRODUCTO", "CANTIDAD", "FECHA" };
		try {
			Collection<Historico> historicoVentas = datos.historicoClieCom(id);
			tableHistorico = new JTable(cargarHistoricoCom_Clie(datos, historicoVentas), columnasVentas);
			tableHistorico.setBounds(36, 65, 347, 132);
			histVentas.add(tableHistorico);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		pestañas.addTab("Historico Compras", histCompras);
		pestañas.addTab("Historico Ventas", histVentas);
		 getContentPane().add(pestañas);
		

	}

	public VHistorico(VSuministrador vSum, boolean b, String id, ControladorSum datos) {
		this.setModal(b);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNombreHistorico = new JLabel("Historico de ...");
		lblNombreHistorico.setBounds(89, 11, 200, 39);
		getContentPane().add(lblNombreHistorico);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(10, 227, 89, 23);
		getContentPane().add(btnAtras);

		String[] columnas = { "VENDEDOR", "PRODUCTO", "CANTIDAD", "FECHA" };
		try {
			Collection<Historico> historico = datos.historicoSumCom(id);
			tableHistorico = new JTable(cargarHistoricoSum(datos, historico), columnas);
			tableHistorico.setBounds(36, 65, 347, 132);
			getContentPane().add(tableHistorico);
		} catch (ReadException e) {
			JOptionPane.showMessageDialog(this, "Error al intentar listar datos de la base de datos",
					"Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		

	}

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

	protected String[][] cargarHistoricoCom_Sum(ControladorCom datos, Collection<Historico> historico) {
		int cont = 1;
		String[][] histTabla = new String[historico.size() + 1][4];
		histTabla[0][0] = "SUMINISTRADOR";
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
	protected String[][] cargarHistoricoCom_Clie(ControladorCom datos, Collection<Historico> historico) {
		int cont = 1;
		String[][] histTabla = new String[historico.size() + 1][4];
		histTabla[0][0] = "CLIENTE";
		histTabla[0][1] = "PRODUCTO";
		histTabla[0][2] = "CANTIDAD COMPRADA";
		histTabla[0][3] = "FECHA COMPRA";
		
		for (Historico hist : historico) {
			histTabla[cont][0] = hist.getComprador();
			histTabla[cont][1] = hist.getProducto();
			histTabla[cont][2] = String.valueOf(hist.getCant());
			histTabla[cont][3] = hist.getFecha().toString();
			cont++;
		}
		return histTabla;
	}
	protected String[][] cargarHistoricoSum(ControladorSum datos, Collection<Historico> historico) {
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
