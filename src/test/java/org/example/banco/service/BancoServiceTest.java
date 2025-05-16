package org.example.banco.service;

import org.example.banco.model.Cuenta;
import org.example.banco.model.CuentaAhorro;
import org.example.banco.model.CuentaCorriente;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BancoServiceTest {

    @Test
    void testCrearCuentaAhorro(){
        BancoService banco = new BancoService();
        banco.crearCuenta("123","Juan Perez", "AHORRO");

        assertDoesNotThrow(() -> banco.depositar("123", 1000)); // si existe, no tira error
    }

    @Test
    void testCalcularSaldoPromedio(){
        BancoService banco = new BancoService();

        banco.crearCuenta("01450035264", "Ezequiel Casada", "AHORRO");
        banco.depositar("01450035264", 100000);

        banco.crearCuenta("01450046375", "Micaela Rodriguez", "CORRIENTE");
        banco.depositar("01450046375", 25000);

        banco.crearCuenta("01450057486", "Agustin Freiria", "CORRIENTE");
        banco.depositar("01450057486", 25000);

        double promedio = banco.calcularSaldoPromedio();

        assertEquals(50000, promedio, 0.001); // (100000 + 25000 + 25000) / 3 = 50000
    }

    @Test
    void testTitularesOrdenados(){
        BancoService banco = new BancoService();
        banco.crearCuenta("01450013579", "Zoe", "AHORRO");
        banco.crearCuenta("01450024680", "Ana", "CORRIENTE");
        banco.crearCuenta("01450031488", "Leon", "CORRIENTE");

        List<String> ordenados = banco.obtenerTitularesOrdenados();

        assertEquals(List.of("Ana","Leon","Zoe"),ordenados);
    }

}
