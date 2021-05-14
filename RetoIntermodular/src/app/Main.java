package app;

import java.sql.*;

import implementaciones.*;
import logica.*;
import modelo.*;
import vista.*;


public class Main {

	public static void main(String[] args) {
		
		VBienvenida vent = new VBienvenida();
		vent.setVisible(true);
		vent.setLocationRelativeTo(null);
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
