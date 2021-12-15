import java.util.ArrayList;
import java.util.List;

/**
 * @author: Diego Reis Pitoco 
 */

public class BDVeiculos extends VeicExistException {

    private static final long serialVersionUID = 719145438688141193L;

    private static Leitura l = new Leitura();

 /**   static Passeio vetPasseio[] = new Passeio[5];
    static Carga vetCarga[] = new Carga[5];*/
    private Passeio passeio = new Passeio();
    private Carga carga = new Carga();
 

    private List<Passeio> BDPasseio = new ArrayList<Passeio>();
    private List<Carga> BDCarga = new ArrayList<Carga>();

    public BDVeiculos() {

    }

    public Passeio cadastroPasseio(Passeio passeio) throws VelocException, VeicExistException {

        System.out.println("\n\n=================================================================");
        System.out.println("Cadastro de Veículos de PASSEIO");
        System.out.println("======================================================================");
        try {
            passeio.setPlaca(l.entDados("\nInforme a placa: "));
          /**  for (int i = 0; i < vetPasseio.length; i++) {
                if (vetPasseio[i] != null) {
                    if (vetPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                        throw new VeicExistException();
                    }
                }
            } */
            for(int i = 0; i < BDPasseio.size();i++){
                if(BDPasseio.get(i) != null){
                    if(BDPasseio.get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())){
                        throw new VeicExistException();
                    }
                }
            }

            passeio.setQtdePassageiros(Integer.parseInt(l.entDados("Quantidade de Passageiros")));
            passeio.setMarca(l.entDados("Marca......"));
            passeio.setModelo(l.entDados("Modelo......"));
            passeio.setCor(l.entDados("Cor......"));
            passeio.setQtdRodas(Integer.parseInt(l.entDados("Quantidade de Rodas.....")));
            try {
                passeio.setVelocMax(Integer.parseInt(l.entDados("Velocidade Máxima.:")));
            } catch (VelocException ve) {
                try {
                    ve.impErro();
                    passeio.setVelocMax(100);

                } catch (VelocException e) {
                    e.printStackTrace();
                }
            }
            passeio.getMotor().setQtdPist(Integer.parseInt(l.entDados("Quantidade de Pistoes do motor.....:")));
            passeio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor.......")));
        } catch (VeicExistException ex) {
            ex.impErroPasseio();
            cadastroPasseio(passeio);
        }
        return passeio;
    }

    public static void imprimePasseio(Passeio passeio, int i) {

        System.out.println("\nPasseio armazenado no vetor ......" + i + "( do vetor vetPasseio)");
        System.out.println("Quantidade de Passageiros.....: " + passeio.getQtdePassageiros());
        System.out.println("Placa.....:" + passeio.getPlaca());
        System.out.println("Marca.....:" + passeio.getMarca());
        System.out.println("Modelo.....:" + passeio.getModelo());
        System.out.println("Cor.....:" + passeio.getCor());
        System.out.println("Quantidade de Rodas.....:" + passeio.getQtdRodas());
        System.out.println("Velocidade Máxima.....:" + passeio.getVelocMax());
        System.out.println("Quantidade Pistoes de motor.....:" + passeio.getMotor().getQtdPist());
        System.out.println("Potência do motor.....:" + passeio.getMotor().getPotencia());
        System.out.println("Quantidade total de letras....." + passeio.calcular());
        passeio.calcVel();
    }

    public int achaVazioPasseio() {
        for (int i = 0; i < BDPasseio.size(); i++) {
            if (BDPasseio.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    public static void imprimeTodosPasseio() {
        for (int i = 0; i < vetPasseio.length; i++) {
            if (BDVeiculos.vetPasseio[i] != null) {
                BDVeiculos.imprimePasseio(BDVeiculos.vetPasseio[i], i);
                System.out.println("==================================================");
            }
        }
        l.entDados("\nSem mais VEÍCULOS DE PASSEIO para imprimir - pressione <ENTER>");
    }

    public void consultaPlacaPasseio() throws VeicExistException {
        boolean existePlacaPasseio = false;
        String placaPasseio = l.entDados("\nInforme a placa a ser pesquisada: ");
        passeio.setPlaca(placaPasseio);
        try {
            for (int i = 0; i < vetPasseio.length; i++) {
                if (vetPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                    imprimePasseio(vetPasseio[i], i);
                    existePlacaPasseio = true;
                    l.entDados("\n\n\t\t\t ======= PASSEIO com esta PLACA - pressione <ENTER>");
                    break;
                }
            }
        } catch (Exception e) {
            l.entDados("\n\n\t\t\t ======= NÃO existe veículo de PASSEIO com esta PLACA - pressione <ENTER>");
        }
    }

    // Metodos veículo de Carga
    public Carga cadastroCarga(Carga carga) throws VeicExistException, VeicExistException {
        System.out.println("\n\n=================================================================");
        System.out.println("Cadastro de Veículos de Carga");
        System.out.println("======================================================================");
        try {
            carga.setPlaca(l.entDados("Placa......"));
            for (int i = 0; i < vetCarga.length; i++) {
                if (vetCarga[i] != null) {
                    if (vetCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                        throw new VeicExistException();
                    }
                }
            }
            carga.setTara(Integer.parseInt(l.entDados("Tara.....:")));
            carga.setCargaMax(Integer.parseInt(l.entDados("Carga Máxima.....:")));
            carga.setMarca(l.entDados("Marca......"));
            carga.setModelo(l.entDados("Modelo......"));
            carga.setCor(l.entDados("Cor....."));
            carga.setQtdRodas(Integer.parseInt(l.entDados("Quantidade de Rodas.....:")));
            try {
                carga.setVelocMax(Integer.parseInt(l.entDados("Velocidade Máxima.....:")));
            } catch (VelocException ve) {
                try {
                    ve.impErro();
                    carga.setVelocMax(90);
                } catch (VelocException e) {
                    e.printStackTrace();
                }
            }
            carga.getMotor().setQtdPist(Integer.parseInt(l.entDados("Quantidade Pistoes de motor.....:")));
            carga.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do Motor.......:")));
        } catch (VeicExistException ex) {
            ex.impErroPasseio();
            cadastroCarga(carga);
        }
        return carga;
    }

    public static void imprimeCarga(Carga carga, int i) {

        System.out.println("\nCarga armazenado no endereço ..." + i + "( do vetor vetCarga)");
        System.out.println("Tara.....: " + carga.getTara());
        System.out.println("Carga Máxima.....:" + carga.getCargaMax());
        System.out.println("Placa.....:" + carga.getPlaca());
        System.out.println("Marca.....:" + carga.getMarca());
        System.out.println("Marca.....:" + carga.getModelo());
        System.out.println("Cor.....:" + carga.getCor());
        System.out.println("Quantidade de Rodas.....:" + carga.getQtdRodas());
        System.out.println("Velocidade Máxima.....:" + carga.getVelocMax());
        System.out.println("Quantidade Pistoes de motor.....:" + carga.getMotor().getQtdPist());
        System.out.println("Potência do motor.....:" + carga.getMotor().getPotencia());
        System.out.println("Quantidade total de letras....." + carga.calcular());
        carga.calcVel();
    }

    public int achaVazioCarga() {
        for (int i = 0; i < vetCarga.length; i++) {
            if (vetCarga[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static void imprimeTodosCarga() {
        for (int i = 0; i < vetCarga.length; i++) {
            if (BDVeiculos.vetCarga[i] != null) {
                BDVeiculos.imprimeCarga(BDVeiculos.vetCarga[i], i);
                System.out.println("==================================================");
            }
        }
        l.entDados("\nSem mais VEÍCULOS DE CARGA para imprimir - pressione <ENTER>");
    }

    public void consultaPlacaCarga() throws VeicExistException {
        boolean existePlacaCarga = false;
        String placaCarga = l.entDados("\nInforme a placa a ser pesquisada: ");
        carga.setPlaca(placaCarga);
        try {
            for (int i = 0; i < vetCarga.length; i++) {
                if (vetCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                    imprimeCarga(vetCarga[i], i);
                    existePlacaCarga = true;
                    l.entDados("\n\n\t\t\t ======= Veículo de Carga impresso - pressione <ENTER>");
                    break;
                }
            }
        } catch (NullPointerException e) {
            l.entDados("\n\n\t\t\t ======= NÃO existe veículo de Carga com esta PLACA - pressione <ENTER>");
        }
    }
}