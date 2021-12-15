/**
 * 
 * @author Diego Reis Pitoco
 * 
 */
public class Teste {

	private static Passeio passeio = new Passeio();
	private static Carga carga = new Carga();

	public static BDVeiculos bdVeiculos = new BDVeiculos();
	public static Leitura l = new Leitura();

	public static void main(String[] args) throws VelocException, VeicExistException {

		boolean continua = true;
		int opcao = 0;

		while (continua) {

			System.out.println("\n\t\t\tMENU INICIAL");
			System.out.println("\t(1) Cadastrar veículo PASSEIO");
			System.out.println("\t(2) Cadastrar veículo CARGA");
			System.out.println("\t(3) Imprimir todos veículos PASSEIO");
			System.out.println("\t(4) Imprimir todos veículos CARGA");
			System.out.println("\t(5) Imprimir todos veículos de PASSEIO pela placa");
			System.out.println("\t(6) Imprimir todos veículos de CARGA pela placa");
			System.out.println("\t(7) Excluir Veículo de Passeio pela Placa");
			System.out.println("\t(8) Excluir Veículo de Carga Pela Placa");
			System.out.println("\t(9) Sair do Sistema");
			try {
				opcao = Integer.parseInt(l.entDados("\n\tEscolha uma opção de 1 até 9: "));
			} catch (NumberFormatException e) {
				System.out.println(" Digíte um valor inteiro - pressione <ENTER>");
				l.entDados("");
				continue;
			}

			switch (opcao) {
				case 1:
					for (int i = bdVeiculos.achaVazioPasseio(); i < BDVeiculos.vetPasseio.length; i++) {
						if (i == -1) {
							l.entDados("\nVetor de PASSEIO esta cheio!! pressione <ENTER>");
							break;
						}
						passeio = new Passeio();

						BDVeiculos.vetPasseio[i] = bdVeiculos.cadastroPasseio(passeio);

						l.entDados("\nPasseio armazenado na posição " + i + " do vetor - pressione <ENTER>");

						String respPass = l.entDados("\nDeseja cadastrar outro veículo de PASSEIO? <S/N>");
						if (respPass.equalsIgnoreCase("n")) {
							break;
						}

						if (bdVeiculos.achaVazioPasseio() == -1) {
							l.entDados("\nVetor de Passeio está cheio! pressione <ENTER>");
							break;
						}
					}
					break;

				case 2:
					for (int i = bdVeiculos.achaVazioCarga(); i < BDVeiculos.vetCarga.length; i++) {
						if (i == -1) {
							l.entDados("\nVetor de Carga esta cheio!! pressione <ENTER>");
							break;
						}
						carga = new Carga();
						BDVeiculos.vetCarga[i] = bdVeiculos.cadastroCarga(carga);

						l.entDados("\nCarga armazenado na posição " + i + " do vetor - pressione <ENTER>");

						String respCarg = l.entDados("\nDeseja cadastrar outro Carga? <s/n>");

						if (respCarg.equalsIgnoreCase("n")) {
							break;
						}

						if (bdVeiculos.achaVazioCarga() == -1) {
							l.entDados("\nVetor de Carga está cheio! pressione <ENTER>");
							break;
						}
					}
					break;

				case 3:
					System.out.println("\nPasseio - Impressão de TODOS veículos");
					System.out.println("====================================================");
					BDVeiculos.imprimeTodosPasseio();
					break;

				case 4:
					System.out.println("\nCARGA - Impressão de TODOS veículos");
					System.out.println("====================================================");
					BDVeiculos.imprimeTodosCarga();
					break;

				case 5:
					System.out.println("\nPesquisa pela Placa - veículos de Passeio");
					System.out.println("====================================================");
					passeio = new Passeio();
					bdVeiculos.consultaPlacaPasseio();					
					break;

				case 6:
					System.out.println("\nConsulta pela Placa - veículos de CARGA");
					System.out.println("====================================================");
					carga = new Carga();
					bdVeiculos.consultaPlacaCarga();
					break;
				
				case 7: 
					System.out.println("\nExcluir Veículo de Passeio pela Placa");	
					break;
				case 8: 
					System.out.println("\nExcluir Veículo de Carga pela Placa");
					break;
				
				case 9:
					String resp = l.entDados("\nDeseja realmente sair do sistema? <S/N>");
					if (resp.equalsIgnoreCase("s")) {
						continua = false;
					}
					break;

				default:
					l.entDados("\nO valor deve ser entre 1 e 7 <pressione ENTER...>");
					break;
			}
		}
	}
}