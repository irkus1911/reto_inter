package app;

import modelo.ControladorSum;
import modelo.ControladorSumImplementacion;
import vista.VBienvenida;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorSum datos=new ControladorSumImplementacion();
		VBienvenida ven=new VBienvenida(null, null, datos, null);
		ven.setVisible(true);
	}

}
