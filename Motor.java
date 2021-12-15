/**
 * 
 * @author Diego Reis Pitoco 
 * 
 */
public class Motor {

	private int qtdPist;
	private double potencia;

	public Motor() {
	}

	public Motor(int qtdPist, double potencia) {
		this.qtdPist = 0;
		this.potencia = 0;
	}

	public int getQtdPist() {
		return qtdPist;
	}

	final public void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}

	public double getPotencia() {
		return potencia;
	}

	final public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

}