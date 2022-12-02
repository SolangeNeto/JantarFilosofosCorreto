package com.example.jantar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Filosofo> filosofos = new ArrayList<>();
        Object[] garfos = new Object[5];

        for (int i = 0; i < garfos.length; i++) {
            garfos[i] = new Object();
        }

        filosofos.add(new Filosofo("Socrates"));
        filosofos.add(new Filosofo("Aristóteles"));
        filosofos.add(new Filosofo("Hegel"));
        filosofos.add(new Filosofo("Kant"));
        filosofos.add(new Filosofo("Nietzsche"));

        for (int i = 0; i < filosofos.size(); i++) {
            Object garfoEsquerdo = garfos[i];
            Object garfoDireito = garfos[(i + 1) % garfos.length];

            filosofos.get(i).setGarfoDireito(garfoDireito);
            filosofos.get(i).setGarfoEsquerdo(garfoEsquerdo);
            Thread t = new Thread(filosofos.get(i),"Filosofo "+ filosofos.get(i).getNome());
            t.start();
        }
    }
}