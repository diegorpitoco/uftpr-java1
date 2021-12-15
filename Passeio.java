/**
 * 
 * @author Diego Reis Pitoco
 * 
 */

public final class Passeio extends Veiculo implements Calc{

	private int qtdePassageiros;


	
	public Passeio() {
		qtdePassageiros = 0;
	}
	
	public int getQtdePassageiros() {
		return qtdePassageiros;
	}

	final public void setQtdePassageiros(int qtdePassageiros) {
		this.qtdePassageiros = qtdePassageiros;
	}

	@Override
	public void calcVel() {
		double velocidade = (getVelocMax()*1000);
		System.out.println("\nVelocidade - Passeio: "+ velocidade +" M/H");

	}
	public double calcular() {

		int somaQTDLetras = 0;

		somaQTDLetras+= getPlaca().length();
		somaQTDLetras+= getMarca().length();
		somaQTDLetras+= getModelo().length();
		somaQTDLetras+= getCor().length();

		return somaQTDLetras;
	}

}
