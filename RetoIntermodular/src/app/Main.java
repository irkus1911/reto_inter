package app;

import java.sql.*;

import implementaciones.*;
import logica.*;
import modelo.*;
import vista.*;


public class Main {

	public static void main(String[] args) {
		
		ControladorClie datosClie = new ControladorClieImplementacion();
		ControladorCom datosCom = new ControladorComImplementacion();
		ControladorSum datosSum = new ControladorSumImplementacion();
		ControladorAdmin datosAdmin = new ControladorAdminImplementacion();
		VBienvenida vent = new VBienvenida(datosClie,datosCom,datosSum,datosAdmin);
		vent.setVisible(true);
	}

}
