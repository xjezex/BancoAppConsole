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

    public Cuenta(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto){
        if (monto > 0) {
          saldo += monto;
        }
    }

    public abstract void retirar(double monto);

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    public abstract String getTipo();

    public void mostrarDatos() {
        System.out.printf("%s - %s - %s - Saldo: $%.2f%n", numero, titular, getTipo(), saldo);
    }

}
