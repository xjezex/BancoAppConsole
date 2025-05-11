package org.example.banco.model;

public abstract class Cuenta {
    private String numero;
    private String titular;
    protected double saldo;

    public Cuenta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double monto){
        if (monto > 0) {
          saldo += monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0){
            saldo -= monto;
        }
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract String getTipo();

    public void mostrarDatos() {
        System.out.printf("%s - %s - %s - Saldo: $%.2f%n", numero, titular, getTipo(), saldo);
    }

}
