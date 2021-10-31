import java.util.Random;

public class oraculo {

    public String Nome;
    public int vidas;
    public Object level1;
    public Random rd = new Random();
    public int opcao;

    // METODOS DO ORACULO
    public void setNome(String nome) {
        Nome = nome;
    }

    public int vidas() {
        int randomNum = rd.nextInt((12 - 9) + 1) + 9;
        return randomNum;
    }

    public String prologo() {
        String txt = " vamos jogar dois jogas para vc ter um premio e vc tera ";
        return txt;
    }

    // level 1 do jogo de adivinhasao metodo so do oraculo para tirar vida 
    private int vidaMenosUm(){
        return vidas() - 1;
    } 

    public int level1() {
        guerreiro useGuerreiro = new guerreiro(); // chama guerreiro para usar o chute na logica
        int randomNum = rd.nextInt((100 - 1) + 1) + 1;
        
        while (randomNum != useGuerreiro.chute()) {
            // logica do jogo de chute do numero
            // int randomNum2 = randomNum;
            // System.out.println(randomNum2);
            
            if (useGuerreiro.chute() < randomNum) {
                System.out.println("e mais e vc perdeu um ponto de vida");
                vidaMenosUm();
                if (vidaMenosUm() <= 9) {
                    System.out.println("vc morreu"); // se morre encerra o programa ele nao pode ir para lvl 2
                    System.out.println("o numero Era: " + randomNum); // falar para ele qual era o numero caso morra
                    break;     
                }
                // break;
            } else if (useGuerreiro.chute() > randomNum) {
                System.out.println("e menos e vc perdeu um ponto de vida");
                vidaMenosUm();
                if (vidaMenosUm() <= 9) {
                    System.out.println("vc morreu"); // se morre encerra o programa ele nao pode ir para lvl 2
                    System.out.println("o numero era: " + randomNum); // falar para ele qual era o numero caso morra
                    break;
                }
                // break;
            } else {
                if (randomNum == useGuerreiro.chute()) {
                    System.out.println("vamos para o level 2");
                    System.out.println("o numero era: " + randomNum); // falar para ele qual era o numero caso acerte
                }
            }
        }
        return vidas(); 
    }

    public int level2(int opcao) {
        guerreiro useGuerreiro = new guerreiro(); // chama guerreiro
        int randomNum = rd.nextInt(5);
        int result;

        if((opcao % 2) == 0){
            result = randomNum + opcao;
            return result; //resultado do par ou impar
         }else{
            result = randomNum + opcao;
            return result; //resultado do par ou impar 
         }  
        
    }
}
