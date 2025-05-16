package org.example.banco.model;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro(String numero, String titular) {
        super(numero, titular);
    }

    @Override
    public String getTipo() {
        return "AHORRO";
    }

    @Override
    public void retirar(double monto) {
        if (monto <= getSaldo()) {
            setSaldo (getSaldo() - monto);
            System.out.println("✅ Retiro exitoso (Cuenta Ahorro).");
        } else {
            System.out.println("❌ Saldo insuficiente (Cuenta Ahorro).");
        }
    }
}
