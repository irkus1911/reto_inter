package app;

import modelo.*;
import vista.VBienvenida;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorClie datosClie = new ControladorClieImplementacion();
		ControladorCom datosCom = new ControladorComImplementacion();
		ControladorSum datosSum = new ControladorSumImplementacion();
		ControladorAdmin datosAdmin = new ControladorAdminImplementacion();
		VBienvenida vent = new VBienvenida(datosClie,datosCom,datosSum,datosAdmin);
		vent.setVisible(true);
	}

}
