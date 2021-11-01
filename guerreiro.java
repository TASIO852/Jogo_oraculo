public class guerreiro {

    public String Nome;
    public int palpiteLevel1;
    public int opcao;
    public int escolha;
    public String misericordia;

    
    public void setNome() {
        this.Nome = Nome;
    }
    public int getVidas(){
        oraculo magoOraculo = new oraculo(); // chama oraculo
        return magoOraculo.vidas();
    }

    public String getNome(){
        return Nome;
    }
    public String vidaExtra(){ 
        return misericordia;
    }




    // methodos de jogabilidade
    public int palpiteLevel1() {
        return palpiteLevel1;
    }

    public int opcao() {
        return opcao;
    }

    public int escolha() {
        return escolha;
    }




}