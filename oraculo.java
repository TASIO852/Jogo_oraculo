import java.util.Random;
import java.util.Scanner;

public class oraculo {

    public String Nome;
    guerreiro useGuerreiro = new guerreiro();

    // nome oraculo
    public void setNome(String nome) {
        this.Nome = nome;
    }

    // vidas do guerreio
    public int setVidas() {
        Random vidas = new Random();
        return vidas.nextInt(4) + 9 ;
    }

    // primeira conversa
    public String prologo() {
        String txt = " vamos jogar dois jogas para vc ter um premio e vc tera ";
        return txt;
    }

    // primeiro mini game

    public static void level1(int palpite, int numero, int vidasGPerda) {
        if (palpite > numero) {
            System.out.println("Seu palpite é maior que o número sorteado.");
        } else {
            if (palpite < numero) {
                System.out.println("Seu palpite é menor que o número sorteado.");
            } else {
                System.out.println("Parabéns, você acertou! O número era " + numero);
                System.out.println("Você tentou " + vidasGPerda + " vezes antes de acertar!");
                }
            }
        }
    

    // segundo mini game
    public void level2(int opcao,int vidasGPerda) {
        int num,num2,poi;
        guerreiro useGuerreiro = new guerreiro();
        int vidasG = useGuerreiro.getVidas();

        Scanner in = new Scanner(System.in);
        System.out.println("coloque um numero");
        Random vidas = new Random();
        num2 = vidas.nextInt(5) + 1;
        num = in.nextInt() + num2 ;
        poi = (num % 2);
        if (poi == 0) {
            System.out.println(num  + " e par" );
        } else {
            System.out.println(num  + " e impar");
        }
    }

    // vida Extra para o guerreiro
    public boolean decidirVidaExtra(String misericordia) {
        guerreiro useGuerreiro = new guerreiro();
        misericordia = useGuerreiro.vidaExtra();

        if (misericordia.length() > 5) {
            prologoVencedor();
            return true;
        } else {
            prologoPerdedor();
            return false;
        }
    }

    // ultima conversa
    public String prologoVencedor() {
        guerreiro useGuerreiro = new guerreiro();

        String txt = "vc ganhou" + useGuerreiro.getNome();
        return txt;
    }

    public String prologoPerdedor() {
        guerreiro useGuerreiro = new guerreiro();

        String txt = "vc perdeu" + useGuerreiro.getNome();
        return txt;
    }

}
