package org.example.banco.model;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro(String numero, String titular) {
        super(numero, titular);
    }

    @Override
    public String getTipo() {
        return "AHORRO";
    }
}
