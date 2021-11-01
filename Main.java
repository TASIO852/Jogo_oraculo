import java.util.Scanner;

public class Main {
    private static Scanner pedirNome;
    private static Scanner palpiteLevel1;
    private static Scanner opcao;
    private static Scanner escolha;
    private static Scanner misericordia;

    public static void main(String[] args) {
        oraculo magoOraculo = new oraculo(); // chama oraculo
        guerreiro useGuerreiro = new guerreiro();// chama guerreiro

        pedirNome = new Scanner(System.in);// pergunta
        palpiteLevel1 = new Scanner(System.in); // pergunta
        opcao = new Scanner(System.in); // pergunta / resposta
        escolha = new Scanner(System.in); // pergunta / resposta
        misericordia = new Scanner(System.in); // pergunta /

        magoOraculo.Nome = "Mago Drummond"; // seta nome do oraculo
        int tentativas = 0;

        System.out.println("Guerreiro meu nome e " + magoOraculo.Nome);
        System.out.println("Guerreiro qual eo seu nome ? ");
        useGuerreiro.Nome = pedirNome.nextLine();
        System.out.println(useGuerreiro.Nome + magoOraculo.prologo() + useGuerreiro.getVidas() + " vidas");

        // level 1
        System.out.println("primeiro jogo vc tera que adivinhar o numero que estou pensando entre 1 e 100");
        System.out.println("falerei tbm se estiver maior ou menor que o numero ");
        System.out.println("fale um numero !");
        do {
            System.out.println("fale outro numero");
            useGuerreiro.palpiteLevel1 = palpiteLevel1.nextInt();
            System.out.println("vc tem " + magoOraculo.level1() + " vidas");
            tentativas++;
        } while (useGuerreiro.palpiteLevel1 != magoOraculo.level1());

        // level 2
        System.out.println("agora vc esta no level 2 " + useGuerreiro.Nome + " vamos jogar par ou impar");
        System.out.println("coloque [1] para PAR e [2] para IMPAR ");
        useGuerreiro.escolha = escolha.nextInt();
        System.out.println("ok agora joque um numero de 1 a 5 ");
        useGuerreiro.opcao = opcao.nextInt();
        System.out.println(magoOraculo.level2(opcao));

        // vida extra game misericordia

        if (useGuerreiro.getVidas() == 0 && magoOraculo.decidirVidaExtra(useGuerreiro.misericordia) == true) {
            System.out.println("te darei mais uma chance guerrei mas vc tera que fazer um pedido");
            useGuerreiro.misericordia = misericordia.nextLine();
            System.out.println(magoOraculo.decidirVidaExtra(useGuerreiro.misericordia));
        }
    }
}