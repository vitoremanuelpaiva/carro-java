package carro;

public class Carro {

    private String motivoFalha = "";
    private static final int[] VELOCIDADE_MINIMA = { 0, 0, 20, 40, 60, 80, 100 };
    private static final int[] VELOCIDADE_MAXIMA = { 0, 20, 40, 60, 80, 100, 120 };
    private boolean ligado;
    private int marcha;
    private int velocidade;

    public Carro() {
        ligado = false;
        marcha = 0;
        velocidade = 0;
    }

    public boolean ligarCarro() {
        if (ligado == true) {
            return falhar("O carro já está ligado");
        }
        this.ligado = true;
        return true;
    }

    private boolean falhar(String motivo) {
        this.motivoFalha = motivo;
        return false;
    }

    public boolean trocarMarcha(int valor) {
        if (!this.ligado) {
            return falhar("O carro está desligado");
        }
        int novaMarcha = this.marcha + valor;

        if (valor != 1 && valor != -1) {
            return falhar("Você não pode pular marchas!");
        }

        if (novaMarcha < 0) {
            return falhar("Você não pode descer mais a marcha porque já está no ponto morto");
        }

        if (novaMarcha > 6) {
            return falhar("Você já atingiu o limite de marchas");
        }

        if (novaMarcha == 0 && this.velocidade > 0) {
            return falhar("Para ir ao ponto morto o carro precisa estar parado");
        }

        if (this.velocidade < VELOCIDADE_MINIMA[novaMarcha]) {
            return falhar("Velocidade muito baixa para a marcha " + novaMarcha
                    + " a velocidade mínima permitida para esta marcha é de " + VELOCIDADE_MINIMA[novaMarcha]);
        }

        if (this.velocidade > VELOCIDADE_MAXIMA[novaMarcha]) {
            return falhar("Velocidade muito alta para a marcha " + novaMarcha
                    + " a velocidade maxima permitida para esta marcha é de " + VELOCIDADE_MAXIMA[novaMarcha]);
        }

        this.marcha = novaMarcha;
        return true;
    }

    public boolean acelerarCarro(int valor) {
        if (!this.ligado) {
            return falhar("Seu carro está desligado");
        }

        if (this.marcha == 0) {
            return falhar("Você não pode acelerar o carro no ponto morto(marcha = 0)");
        }

        int novaVelocidade = this.velocidade + valor;

        if (this.marcha == 6 && novaVelocidade > VELOCIDADE_MAXIMA[this.marcha]) {
            return falhar("Você já está na velocidade máxima do carro");
        }

        if (novaVelocidade > VELOCIDADE_MAXIMA[this.marcha]) {
            return falhar("A velocidade máxima da marcha " + this.marcha + " é de " + VELOCIDADE_MAXIMA[this.marcha]
                    + ", você pode subir a marcha para continuar acelerando");
        }

        this.velocidade = novaVelocidade;
        return true;
    }

    public boolean freiarCarro(int valor) {

        if (!this.ligado) {
            return falhar("Seu carro está desligado");
        }

        int novaVelocidade = this.velocidade - valor;

        if (novaVelocidade < 0) {
            return falhar("O carro já está parado");
        }

        if (novaVelocidade < VELOCIDADE_MINIMA[this.marcha]) {
            return falhar("A velocidade mínima da marcha " + this.marcha + " é de " + VELOCIDADE_MINIMA[this.marcha]
                    + ", você pode descer a marcha para continuar freando");
        }

        this.velocidade = novaVelocidade;
        return true;
    }

    public boolean direcaoCarro() {
        if (this.ligado != true) {
            return falhar("O carro está desligado");
        }
        if (this.velocidade == 0) {
            return falhar("O carro está parado");
        }
        if (this.velocidade > 40) {
            return falhar("O carro está muito rápido para dar a curva");
        }
        return true;
    }

    public boolean desligarCarro() {
        if (ligado != true) {
            return falhar("O carro já está desligado");
        }
        if (velocidade != 0) {
            return falhar("O carro precisa estar parado!");
        }
        if (marcha != 0) {
            return falhar("O carro precisa estar no Ponto morto(marcha = 0),para desligar");
        }
        this.ligado = false;
        return true;
    }

    public String getMotivoFalha() {
        return this.motivoFalha;
    }

    public int getMarcha() {
        return this.marcha;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public boolean estaLigado() {
        return this.ligado;
    }
}
