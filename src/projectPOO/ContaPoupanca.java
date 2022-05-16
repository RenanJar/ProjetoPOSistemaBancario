package projectPOO;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ContaPoupanca extends Conta {

	public double reajuste(ArrayList<String> array,double A, double b) {

		double rendimento = A / 100 * b;
		array.add("\nRendimento "+String.valueOf(Math.round(rendimento)));
		return rendimento;
	}

}