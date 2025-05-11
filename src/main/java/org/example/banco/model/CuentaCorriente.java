package org.example.banco.model;

public class CuentaCorriente extends Cuenta {
    private static final double LIMITE_SOBREGIRO = 5000.0;

    public CuentaCorriente(String numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void retirar(double monto){
        if(monto > 0 && monto <= saldo + LIMITE_SOBREGIRO) {
            saldo -= monto;
        } else {
            System.out.println("Fondos Insuficientes. Saldo: "+saldo+" - Sobregiro Permitido: "+LIMITE_SOBREGIRO);
        }
    }

    @Override
    public String getTipo() {
        return "CORRIENTE";
    }
}
