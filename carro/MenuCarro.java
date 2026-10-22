package carro;

import java.util.Scanner;

public class MenuCarro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        Carro carro = new Carro();
        while (menu) {
            System.out.println("========== MENU DO CARRO ==========");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar para esquerda/direita");
            System.out.println("6 - Verificar velocidade");
            System.out.println("7 - Trocar a marcha");
            System.out.println("8 - Sair");
            System.out.println("Digite sua opção :");
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            switch (opcao) {
                case 1:
                    if (carro.ligarCarro()) {
                        System.out.println("O carro foi ligado com sucesso!");
                    } else {
                        System.out.println(carro.getMotivoFalha());
                    }
                    break;
                case 2:
                    if (carro.desligarCarro()) {
                        System.out.println("Seu carro está sendo desligado...");
                    } else {
                        System.out.println(carro.getMotivoFalha());
                    }
                    break;
                case 3:
                    if (carro.acelerarCarro(1)) {
                        System.out.println("Acelerando carro!!");
                        System.out.println("Sua velocidade atual é de :" + carro.getVelocidade() + " Km/h");
                    } else {
                        System.out.println(carro.getMotivoFalha());
                    }
                    break;
                case 4:
                    if (carro.freiarCarro(1)) {
                        System.out.println("Freando o carro!!");
                        System.out.println("Sua velocidade atual é de : " + carro.getVelocidade() + " Km/h");
                    } else {
                        System.out.println(carro.getMotivoFalha());
                    }
                    break;
                case 5:
                    if (carro.direcaoCarro()) {
                        System.out.println("Você deseja virar para a esquerda ou para a direita");
                        String dir = scanner.nextLine();
                        if (dir.equalsIgnoreCase("esquerda")) {
                            System.out.println("Você virou para a esquerda");
                        } else if (dir.equalsIgnoreCase("direita")) {
                            System.out.println("Você virou para a direita");
                        } else {
                            System.out.println("Digite esquerda ou direita!");
                        }
                    } else {
                        System.out.println(carro.getMotivoFalha());
                    }
                    break;
                case 6:
                    System.out.println("Sua velocidade atual é de : " + carro.getVelocidade() + " Km/h");
                    break;
                case 7:
                    if (carro.estaLigado()) {
                        System.out.println("Você deseja descer ou subir a marcha?");
                        String mar = scanner.nextLine();
                        if (mar.equalsIgnoreCase("subir")) {
                            System.out.printf("A sua marcha atual é : %d\n", carro.getMarcha());
                            if (carro.trocarMarcha(1)) {
                                System.out.printf("E você subiu para a marcha : %d\n", carro.getMarcha());
                            } else {
                                System.out.println(carro.getMotivoFalha());
                            }
                        } else if (mar.equalsIgnoreCase("descer")) {
                            System.out.printf("A sua marcha atual é : %d\n", carro.getMarcha());
                            if (carro.trocarMarcha(-1)) {
                                System.out.printf("E você desceu para a marcha : %d\n", carro.getMarcha());
                            } else {
                                System.out.println(carro.getMotivoFalha());
                            }
                        } else {
                            System.out.println("Digite subir ou descer para trocar a marcha!");
                        }
                    } else {
                        System.out.println("Seu carro está desligado");
                    }
                    break;
                case 8:
                    System.out.println("Fechando o programa...");
                    menu = false;
                    break;
                default:
                    System.out.println("Digite uma das opções da sua tela");
                    break;
            }
        }
        scanner.close();

    }

}
