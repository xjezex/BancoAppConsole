package org.example.banco.service;

import org.example.banco.model.Cuenta;
import org.example.banco.model.CuentaAhorro;
import org.example.banco.model.CuentaCorriente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoService {
    private final Map<String, Cuenta> cuentas = new HashMap<>();

    public boolean crearCuenta(String numero, String titular, String tipo) {
        if (cuentas.containsKey(numero)) return false;

        Cuenta cuenta;
        switch (tipo.toUpperCase()) {
            case "AHORRO" -> cuenta = new CuentaAhorro(numero, titular);
            case "CORRIENTE" -> cuenta = new CuentaCorriente(numero, titular);
            default -> throw new IllegalArgumentException("Tipo de cuenta inválido");
        }

        cuentas.put(numero, cuenta);
        return true;
    }

    public boolean depositar(String numero, double monto) {
        Cuenta cuenta = cuentas.get(numero);
        if (cuenta != null) {
            cuenta.depositar(monto);
            return true;
        }
        return false;
    }

    public boolean retirar(String numero, double monto) {
        Cuenta cuenta = cuentas.get(numero);
        if (cuenta != null) {
            cuenta.retirar(monto);
            return true;
        }
        return false;
    }

    public List<Cuenta> obtenerCuentas() {
        return new ArrayList<>(cuentas.values());
    }

    /* lambdas */

    public List<Cuenta> obtenerCuentasSaldoMayorA(double limite) {
        return cuentas.values().stream()
                .filter(c -> c.getSaldo() > limite)
                .toList();
    }

    public List<String> obtenerTitulares() {
        return cuentas.values().stream()
                .map(Cuenta::getTitular)
                .toList();
    }

    public List<String> obtenerTitularesOrdenados() {
        return cuentas.values().stream()
                .map(Cuenta::getTitular)
                .sorted()
                .toList();
    }

    public double calcularSaldoPromedio() {
        return cuentas.values().stream()
                .mapToDouble(Cuenta::getSaldo)
                .average()
                .orElse(0.0);
    }

}