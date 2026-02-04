package proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Funciones {
	public static void main(String[] args) {

	}

	public static boolean ejercicio1(int edad, int numIntentos, boolean vetado) {
		if (vetado)
			return false;
		if (numIntentos > 3)
			return false;
		if (edad <= 15 || edad > 15 && numIntentos <= 2)
			return false;

		return true;
	}

	public static void ejercicio2(int[] array, boolean intento) {
		if (intento) {
			array[0] = 0;
		} else {
			array[0] += 1;
		}
	}

	public static boolean ejercicio3(double saldoActual, double importeOp, boolean cuentaBloqueada) {
		if (cuentaBloqueada || importeOp < 0 || saldoActual - importeOp < 0)
			return false;

		// actualizamos la bbdd
		return true;
	}

	/**
	 * @param tipoOp true => ingreso false => retirada
	 * 
	 */
	public static void ejercicio4(double[] saldo, double importeOp, boolean tipoOp) {
		if (!tipoOp && saldo[0] - importeOp < 0) {
			return;
		}
		if (tipoOp)
			saldo[0] += importeOp;
		else
			saldo[0] -= importeOp;
	}

	public static boolean ejercicio5(int numIntentos, int acumulado, int importe) {
		if (numIntentos > 5 && acumulado + importe > 1000)
			return false;
		// actualizamos la bbdd
		return true;
	}

	public static void ejercicio6(double[] notas) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 0)
				notas[i] = 0;
			if (notas[i] > 10)
				notas[i] = 10;
		}
	}

	public static boolean ejercicio7(int[] contadorErrores, int codError) {
		if (codError < 0 || contadorErrores[0] > 3)
			return false;
		if (codError > 500)
			contadorErrores[0] += 1;
		return true;
	}

	public static boolean ejercicio8(String contraseña) {
		if (contraseña.length() < 8)
			return false;

		boolean tengoLetraMayus=false;
		boolean tengoNumero=false;
		for (int i = 0; i < contraseña.length(); i++) {
			if(Character.isUpperCase(contraseña.charAt(i))) {
				tengoLetraMayus=true;
			}
			if(Character.isDigit(contraseña.charAt(i))) {
				tengoNumero=true;
			}
		}
		return tengoLetraMayus && tengoNumero;

	}

}
