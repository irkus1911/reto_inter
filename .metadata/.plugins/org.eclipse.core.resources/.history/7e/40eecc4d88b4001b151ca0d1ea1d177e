package app;

import implementaciones.ControladorAdminImplementacion;
import implementaciones.ControladorClieImplementacion;
import implementaciones.ControladorComImplementacion;
import implementaciones.ControladorSumImplementacion;
import logica.ControladorAdmin;
import logica.ControladorClie;
import logica.ControladorCom;
import logica.ControladorSum;
import vista.VBienvenida;


public class Main {

	public static void main(String[] args) {
		
		VBienvenida vent = new VBienvenida();
		vent.setVisible(true);
	}
	
	public static ControladorClie datosClie() {
		ControladorClie datosClie = new ControladorClieImplementacion();
		return datosClie;
	}
	public static ControladorCom datosCom() {
		ControladorCom datosCom = new ControladorComImplementacion();
		return datosCom;
	}
	public static ControladorSum datosSum() {
		ControladorSum datosSum = new ControladorSumImplementacion();
		return datosSum;
	}
	public static ControladorAdmin datosAdmin() {
		ControladorAdmin datosAdmin = new ControladorAdminImplementacion();
		return datosAdmin;
	}

}
