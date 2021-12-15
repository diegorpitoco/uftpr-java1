/**
 * 
 * @author Diego Reis Pitoco
 * 
 */

public class VeicExistException extends Exception{
    
    public VeicExistException(){
    
    }

    public void impErroPasseio(){
        System.out.println("\nJá existe um veículo cadastrado com esta placa");
    }
}
