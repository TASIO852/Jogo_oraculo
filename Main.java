import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner pedirNome;

    static int palpite = 0;
    static int sorteado;
    int tentativas = 0;

    public static void main(String[] args) {
        oraculo magoOraculo = new oraculo();
        guerreiro useGuerreiro = new guerreiro();
        Scanner entrada = new Scanner(System.in);

        pedirNome = new Scanner(System.in);
        magoOraculo.Nome = "Mago Drummond";
        int vidasG = useGuerreiro.getVidas();
        int vidasGPerda = vidasG;
        String misericordia = useGuerreiro.vidaExtra();

        // System.out.println("Guerreiro meu nome e " + magoOraculo.Nome);
        // System.out.println("\nGuerreiro qual eo seu nome ? ");
        // useGuerreiro.Nome = pedirNome.nextLine();
        // System.out.println(useGuerreiro.Nome + magoOraculo.prologo() + vidasG + " vidas");

        // level 1
        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(100) + 1;
        System.out.println("Número entre 1 e 100 sorteado!");

        do {
            System.out.printf("\n\n\n\n-----------------\n");

            
            System.out.println("Número de vidas: "  + vidasGPerda + "\n");

            System.out.print("Qual seu palpite: ");
            palpite = entrada.nextInt();

            vidasGPerda--;


            magoOraculo.level1(palpite, sorteado, vidasGPerda);
        } while (palpite != sorteado);

        while (true) {
            // level 2
            System.out.println("agora vc esta no level 2 " + useGuerreiro.Nome + " vamos jogar par ou impar");
            System.out.println("ok agora joque um numero de 1 a 5 ");
            magoOraculo.level2(useGuerreiro.opcao,vidasGPerda);
            break;
        }
        // vida extra game misericordia
        if (useGuerreiro.getVidas() == 0 && magoOraculo.decidirVidaExtra(useGuerreiro.vidaExtra())) {
            System.out.println("te darei mais uma chance guerrei mas vc tera que fazer um pedido");

            System.out.println(magoOraculo.decidirVidaExtra(useGuerreiro.vidaExtra()));
        }

    }
}