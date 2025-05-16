package org.example.banco.model;

public class CuentaCorriente extends Cuenta {
    private static final double LIMITE_SOBREGIRO = 5000.0;

    public CuentaCorriente(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    public CuentaCorriente(String numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= getSaldo() + LIMITE_SOBREGIRO) {
            setSaldo(getSaldo() - monto);
            System.out.println("✅ Retiro exitoso (Cuenta Corriente con sobregiro si fue necesario).");
        } else {
            System.out.println("❌ Límite de sobregiro excedido (Cuenta Corriente).");
        }
    }

    @Override
    public String getTipo() {
        return "CORRIENTE";
    }
}
