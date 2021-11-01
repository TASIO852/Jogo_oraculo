import java.util.Random;
import java.util.Scanner;

public class oraculo {

    public String Nome;
    public int vidas;
    public Object level1;
    public Random rd = new Random();
    public int opcao;

    // nome oraculo
    public void setNome(String nome) {
        this.Nome = nome;
    }
    // vidas do guerreio
    public int vidas() {
        guerreiro useGuerreiro = new guerreiro(); // chama guerreiro para usar o chute na logica
        int randomNum = rd.nextInt((12 - 9) + 1) + 1;
        if (useGuerreiro.palpiteLevel1() != randomNum) {
            return randomNum - 1;
        }
        return randomNum;
    }

    // primeira conversa
    public String prologo() {
        String txt = " vamos jogar dois jogas para vc ter um premio e vc tera ";
        return txt;
    }

    // primeiro mini game 
    public int level1() {
        guerreiro useGuerreiro = new guerreiro(); // chama guerreiro para usar o chute na logica
        int randomNuml1 = rd.nextInt((100 - 1) + 1) + 1;

            if (useGuerreiro.palpiteLevel1() < randomNuml1) {
                System.out.println("e mais e vc perdeu um ponto de vida");
                vidas();
            } else if (useGuerreiro.palpiteLevel1() > randomNuml1) {
                System.out.println("e menos e vc perdeu um ponto de vida");
                vidas();
            } else if (randomNuml1 == useGuerreiro.palpiteLevel1()) {
                System.out.println("vamos para o level 2");
            } else if (vidas() == 0) {
                System.out.println("vc morreu");    
        }
        return vidas();
    }

    // segundo mini game
    public int level2(Scanner opcao) {
        guerreiro useGuerreiro = new guerreiro(); // chama guerreiro

        switch (useGuerreiro.escolha()) {
        case 1:
            System.out.println("voce escolheu par");
            break;
        case 2:
            System.out.println("voce escolheu impar");
            break;
        }

        int randomNum = rd.nextInt(5) + 1;
        int result;
        result = useGuerreiro.opcao() + randomNum;

        if ((result % 2) == 0) {
            System.out.println("resultado deu par");
            return result;
        } else {
            System.out.println("resultado deu impar");
            return result;
        } 
    }

    public boolean  decidirVidaExtra(String misericordia){
        guerreiro useGuerreiro = new guerreiro();
        misericordia = useGuerreiro.misericordia;

        if (misericordia.length() > 5) {
            return true;
        } else {
            prologoPerdedor();
            return false;
        }
    }

    public String prologoVencedor(){
        guerreiro useGuerreiro = new guerreiro(); 

        String txt = "vc ganhou" + useGuerreiro.getNome();
        return txt;
    }
    public String prologoPerdedor(){
        guerreiro useGuerreiro = new guerreiro(); 

        String txt = "vc perdeu" + useGuerreiro.getNome();
        return txt;
    }




}
