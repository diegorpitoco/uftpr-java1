/**
 * 
 * @author Diego Reis Pitoco
 * 
 */

public final class Carga extends Veiculo implements Calc {

	private int tara;
	private int cargaMax;

	public Carga() {
		this.tara = 0;
		this.cargaMax = 0;
	}

	public int getTara() {
		return tara;
	}

	final public void setTara(int tara) {
		this.tara = tara;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	final public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	@Override
	public void calcVel() {
		double velocidade = (getVelocMax() * 10000);
		System.out.println("\nVelocidade Carga: " + velocidade + " CM/H");
	}

	public double calcular() {

		int somaNumero = 0;

		somaNumero += getMotor().getQtdPist();
		somaNumero += getMotor().getPotencia();
		somaNumero += getQtdRodas();
		somaNumero += getVelocMax();
		somaNumero += getTara();
		somaNumero += getCargaMax();

		return somaNumero;
	}
}
