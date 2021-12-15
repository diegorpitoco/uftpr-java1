/**
 * 
 * @author Diego Reis Pitoco
 * 
 */
public abstract class Veiculo extends VelocException {

	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private int qtdRodas;
	private double velocMax;
	private Motor motor;
	// private VeicExistException veicExistException;

	public Veiculo() {
		placa = " ";
		marca = " ";
		modelo = " ";
		cor = "";
		qtdRodas = 0;
		velocMax = 0;
		motor = new Motor();
	}

	public String getPlaca() {
		return placa;
	}

	final public void setPlaca(String placa) throws VeicExistException {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	final public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	final public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public double getVelocMax() {
		return velocMax;
	}

	final public void setVelocMax(double velocMax) throws VelocException {

		if (velocMax < 110 && velocMax > 80) {
			this.velocMax = velocMax;
		} else {
			throw new VelocException();
		}

	}

	public Motor getMotor() {
		return motor;
	}

	final public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public abstract void calcVel();

}