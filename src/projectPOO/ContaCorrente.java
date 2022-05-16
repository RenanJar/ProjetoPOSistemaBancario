package projectPOO;

public class ContaCorrente extends Conta {

	public double reajuste(double A, double b) {
		double tarifa = A - b;
		return tarifa;
	}
}