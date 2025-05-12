package org.example.banco;

import org.example.banco.service.BancoService;

import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        BancoService banco = new BancoService();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ BANCO ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Ver cuentas");
            System.out.println("5. Ver cuentas con saldo Alto");
            System.out.println("6. Ver titulares");
            System.out.println("7. Ver Titulares Ordenados Alfabeticamente");
            System.out.println("0. Salir");
            System.out.println("------------------");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    System.out.print("Tipo (AHORRO/CORRIENTE): ");
                    String tipo = sc.nextLine();
                    banco.crearCuenta(num, titular, tipo);
                }
                case 2 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("Monto a depositar: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    banco.depositar(num, monto);
                }
                case 3 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();
                    System.out.print("Monto a retirar: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    banco.retirar(num, monto);
                }
                case 4 -> banco.mostrarCuentas();
                case 5 -> banco.mostrarCuentasSaldoAlto();
                case 6 -> banco.getTitulares();
                case 7 -> banco.getTitularesOrdenados();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}