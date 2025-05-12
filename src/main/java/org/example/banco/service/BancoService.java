package org.example.banco.service;

import org.example.banco.model.Cuenta;
import org.example.banco.model.CuentaAhorro;
import org.example.banco.model.CuentaCorriente;

import java.util.HashMap;
import java.util.Map;

public class BancoService {
    private final Map<String, Cuenta> cuentas = new HashMap<>();

    public void crearCuenta(String numero, String titular, String tipo) {
        if (cuentas.containsKey(numero)) {
            System.out.println("Ya existe una cuenta con ese número.");
            return;
        }

        Cuenta cuenta;
        if (tipo.equalsIgnoreCase("AHORRO")) {
            cuenta = new CuentaAhorro(numero, titular);
        } else if (tipo.equalsIgnoreCase("CORRIENTE")) {
            cuenta = new CuentaCorriente(numero, titular);
        } else {
            System.out.println("Tipo de cuenta inválido.");
            return;
        }

        cuentas.put(numero, cuenta);
        System.out.println("✅ Cuenta creada con éxito.");
    }

    public void depositar(String numero, double monto) {
        Cuenta c = cuentas.get(numero);
        if (c != null) {
            c.depositar(monto);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void retirar(String numero, double monto) {
        Cuenta c = cuentas.get(numero);
        if (c != null) {
            c.retirar(monto);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void mostrarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            cuentas.values().forEach(Cuenta::mostrarDatos);
        }
    }

    /* lambdas */

    public void mostrarCuentasSaldoAlto() {
        cuentas.values().stream()
                .filter(c -> c.getSaldo() > 100000)
                .forEach(Cuenta::mostrarDatos);
    }

    public void getTitulares(){
        cuentas.values().stream()
                .map(Cuenta::getTitular)
                .forEach(System.out::println);
    }

    public void getTitularesOrdenados() {
        cuentas.values().stream()
                .map(Cuenta::getTitular)
                .sorted()
                .forEach(System.out::println);
    }


}