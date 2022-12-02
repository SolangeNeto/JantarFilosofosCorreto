package com.example.jantar;

public class Filosofo implements Runnable{
    private String nome;
    private Object garfoEsquerdo;
    private Object garfoDireito;

    public Filosofo(String nome, Object garfoEsquerdo, Object garfoDireito) {
        this.nome = nome;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    public Filosofo(String nome) {
        this.nome = nome;
    }

    public void setGarfoEsquerdo(Object garfoEsquerdo) {
        this.garfoEsquerdo = garfoEsquerdo;
    }

    public void setGarfoDireito(Object garfoDireito) {
        this.garfoDireito = garfoDireito;
    }

    public String getNome() {
        return nome;
    }

    private void task(String tarefa) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + tarefa);
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                task(" Pensando!!");
                synchronized (garfoEsquerdo) {
                    task(" Pegou o garfo esquerdo!");
                    synchronized (garfoDireito) {
                        task(" Pegou o garfo direito e está comendo!");
                        task(" Soltou o garfo direito!");
                    }
                    task(" Soltou o garfo esquerdo!");
                }
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
