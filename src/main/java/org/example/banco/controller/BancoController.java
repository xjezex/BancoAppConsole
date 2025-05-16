package org.example.banco.controller;

import org.example.banco.model.Cuenta;
import org.example.banco.service.BancoService;

import java.util.List;
import java.util.Scanner;

public class BancoController {

    private final BancoService bancoService = new BancoService();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            manejarOpcion(opcion);
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú Banco ---");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Mostrar todas las cuentas");
        System.out.println("5. Cuentas con saldo > 100000");
        System.out.println("6. Mostrar titulares");
        System.out.println("7. Mostrar titulares ordenados");
        System.out.println("8. Calcular saldo promedio");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearCuenta();
            case 2 -> depositar();
            case 3 -> retirar();
            case 4 -> mostrarCuentas();
            case 5 -> mostrarCuentasSaldoAlto();
            case 6 -> mostrarTitulares();
            case 7 -> mostrarTitularesOrdenados();
            case 8 -> calcularSaldoPromedio();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción inválida.");
        }
    }

    private void crearCuenta() {
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        System.out.print("Titular: ");
        String titular = scanner.nextLine();
        System.out.print("Tipo (AHORRO/CORRIENTE): ");
        String tipo = scanner.nextLine();

        if (bancoService.crearCuenta(numero, titular, tipo)) {
            System.out.println("✅ Cuenta creada con éxito.");
        } else {
            System.out.println("❌ No se pudo crear la cuenta (ya existe o tipo inválido).");
        }
    }

    private void depositar() {
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        System.out.print("Monto a depositar: ");
        double monto = Double.parseDouble(scanner.nextLine());

        if (bancoService.depositar(numero, monto)) {
            System.out.println("✅ Depósito realizado.");
        } else {
            System.out.println("❌ Cuenta no encontrada.");
        }
    }

    private void retirar() {
        System.out.print("Número de cuenta: ");
        String numero = scanner.nextLine();
        System.out.print("Monto a retirar: ");
        double monto = Double.parseDouble(scanner.nextLine());

        if (bancoService.retirar(numero, monto)) {
            System.out.println("✅ Retiro realizado.");
        } else {
            System.out.println("❌ Cuenta no encontrada.");
        }
    }

    private void mostrarCuentas() {
        List<Cuenta> cuentas = bancoService.obtenerCuentas();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            cuentas.forEach(Cuenta::mostrarDatos);
        }
    }

    private void mostrarCuentasSaldoAlto() {
        List<Cuenta> cuentas = bancoService.obtenerCuentasSaldoMayorA(100000);
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas con saldo alto.");
        } else {
            cuentas.forEach(Cuenta::mostrarDatos);
        }
    }

    private void mostrarTitulares() {
        bancoService.obtenerTitulares()
                .forEach(t -> System.out.println("Titular: " + t));
    }

    private void mostrarTitularesOrdenados() {
        bancoService.obtenerTitularesOrdenados()
                .forEach(t -> System.out.println("Titular: " + t));
    }

    private void calcularSaldoPromedio() {
        double promedio = bancoService.calcularSaldoPromedio();
        System.out.printf("Saldo promedio: %.2f\n", promedio);
    }
}