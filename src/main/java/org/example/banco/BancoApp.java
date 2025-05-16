package org.example.banco;

import org.example.banco.controller.BancoController;


public class BancoApp {
    public static void main(String[] args) {
        BancoController controller = new BancoController();
        controller.iniciar();
    }
}