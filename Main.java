import java.util.Random;
import java.util.Scanner;

public class Main {
private static Scanner pedirNome;
private static Scanner chute;
private static Scanner opcao;

public static void main(String[] args) {
    Random rd = new Random();
    oraculo magoOraculo =  new oraculo(); //chama oraculo
    guerreiro useGuerreiro = new guerreiro();//chama guerreiro

    pedirNome = new Scanner(System.in);//pergunta
    chute = new Scanner(System.in); //pergunta
    opcao = new Scanner(System.in); //pergunta / resposta

    magoOraculo.Nome = "Mago Drummond"; // seta nome do oraculo
    // useGuerreiro.Nome = pedirNome.nextLine();
    // useGuerreiro.palpite = chute.nextInt();

    System.out.println("Guerreiro meu nome e " + magoOraculo.Nome);
    System.out.println("Guerreiro qual eo seu nome ? ");
    useGuerreiro.Nome = pedirNome.nextLine();
    System.out.println(useGuerreiro.Nome + magoOraculo.prologo() + magoOraculo.vidas() + " vidas");
    System.out.println("primeiro jogo vc tera que adivinhar o numero que estou pensando entre 1 e 100");
    System.out.println("falerei tbm se estiver maior ou menor que o numero ");
    System.out.println("fale um numero !"); 
    useGuerreiro.chute = chute.nextInt();
    System.out.println(magoOraculo.level1());
    System.out.println("agora vc esta no level 2 " + useGuerreiro.Nome + " vamos jogar par ou impar");
    System.out.println("coloque um numero");
    // useGuerreiro.opcao = opcao.nextInt();
    magoOraculo.level2(rd.nextInt(5));
    
    }
 }