package entities;

import org.example.entities.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    // Preparar o teste
    double valorDeposito = 100.0;
    double valorEsperado = 98.0;
    double valorParaSaque = 10.0;
    double valorEsperadoAposSaque = 87.4;
    Conta c1 = new Conta(1L, 0.0);
    Conta c2 = new Conta(1L, 0.0);

    @Test
    public void depositarDeveriaIncrementarOSaldo() {
        // Execução do teste
        System.out.println("Saldo inicial: " + c1.getSaldo());
        System.out.println("Depositando " + valorDeposito);
        c1.depositar(valorDeposito);
        System.out.println("Saldo após o depósito - cobrada taxa de 2%: " + c1.getSaldo());

        // Verificação do teste
        Assertions.assertEquals(valorEsperado, c1.getSaldo());
    }

    @Test
    public void sacarDeveriaDecrementarOSaldo() {
        // Execução do teste
        System.out.println("Depositando para saque: " + valorDeposito);
        c2.depositar(valorDeposito);
        System.out.println("Valor do saldo - cobrada taxa de 2%: " + c2.getSaldo());
        System.out.println("Sacando " + valorParaSaque);
        c2.sacar(valorParaSaque);
        System.out.println("Valor do saldo após o saque - cobrada taxa de 6%: " + c2.getSaldo());

        // Verificação do teste
        Assertions.assertEquals(valorEsperadoAposSaque, c2.getSaldo());
    }

}
