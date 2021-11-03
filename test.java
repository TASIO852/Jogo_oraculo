// SÃO BIBLIOTECAS IMPORTADAS PARA A EXECUÇÃO DO PROGRAMA: "RAMDOM" É PARA SORTEAR UM NÚMERO ALEATÓRIO E "JOptionPane" É UM TIPO DE IMPUT.

import java.util.Random;
import javax.swing.JOptionPane;
// import java.util.Date;

// NA CLASSE GUERREIRO TEM OS ATRIBUTOS SOLICITADOS PELO PROFESSOR. "THIS " É PARA REALIZAR UMA REFERÊNCIA AO ATRIBUTO DA CLASSE, "GET" É PARA PUXAR UM ATRIBUTO PARA A CLASSE E O "SET" É PRA ATRIBUIR ALGUM VALOR EM GERAL.

class Guerreiro {
  String Nome;
  int Vidas;

  void setNome(String Nome) {
    this.Nome = Nome;
  }

  int getVidas() {
    return Vidas;
  }

  String getNome() {
    return Nome;
  }

  String VidaExtra() {
    String extraLife = JOptionPane.showInputDialog("Digite a sua súplica por clemência: ");
    return extraLife;
  }
}

// NÓS USAMOS "RAMDOM" PARA O SORTEIO DAS VIDAS, ENTRE 9 E 12.
class Oraculo {
  String Nome;
  Guerreiro Guerreiro;

  void setNome(String Nome) {
    this.Nome = Nome;
  }

  // "SET VIDAS ESTÁ ATRIBUINDO UM VALOR A VIDA DO GUERREIRO."

  int setVidas() {
    Random aleatory = new Random();
    return aleatory.nextInt(4) + 9;
  }
  // RETORNAR UMA STRING COM AS INFORMAÇÕES "NOME DO ORACULO", "NOME DO GUERREIRO"
  // E A QUANTIDADE DE VIDAS DO GUERREIRO.

  String prologoIntroducao() {
    return "O guerreiro chamado " + this.Guerreiro.getNome()
        + " deve atravessar a \nporta mágica.\nA porta é protegida pelo oráculo " + this.Nome
        + ", que guarda\nem sua mente o segredo da porta.\n\nO Guerreiro tem " + this.Guerreiro.getVidas()
        + " vidas.\nEle perde 1 vida a cada palpite errado.";
  }

  // ATRIBUIR UM NÚMERO ALEATÓRIO ENTRE 1 E 101.

  int loadLevel1() {
    Random aleatory = new Random();
    int password = aleatory.nextInt(99) + 1;
    return password;
  }

  // NESSA CLASSE, O GUERREIRO E ORÁCULO PODERÁ JOGAR UM VALOR DE O A 5. CASO A
  // SOMA DOS VALORES LANÇADOS PELO OCRÁCULO + GUERREIRO DER RESTO "0", SERÁ PAR,
  // CASO A SOMA DOS VALORES DER MAIOR OU IGUAL 1, SERÁ ÍMPAR.

  int loadLevel2(int option) {
    Random fingers = new Random();
    int Warrior = fingers.nextInt(5);
    int Oracle = fingers.nextInt(5);
    if (option == 1 && (Warrior + Oracle) % 2 >= 1) {
      return 1;
    } else if (option == 2 && (Warrior + Oracle) % 2 == 0) {
      return 1;
    } else {
      return 0;
    }
  }

  // NESSA PARTE DO CÓDIGO É FEITA A MENSAGEM DO PROLOGO VENCEDOR, POR MEIO DOS
  // COMANDOS THIS, GET.

  String prologoVencedor() {
    return this.Nome + ": Meus parabéns, " + this.Guerreiro.getNome()
        + "!\nVocê me derrotou!\n\nTens o direito de passar pela porta.\n\nFim de jogo.";
  }

  // NESSA PARTE DO CÓDIGO É FEITA A MENSAGEM DO PROLOGO VENCEDOR, POR MEIO DOS
  // COMANDOS THIS, GET.

  String prologoPerdedor() {
    return this.Nome + ": Guerreiro " + this.Guerreiro.getNome()
        + "\nvocê falhou miseravelmente e a porta permanecerá trancada!\n\nGAME OVER";
  }

  // NESSA PARTE DO CÓDIGO É UTILIZADO O COMANDO "BOOLEAN" DO JAVA PARA DECIDIR
  // MAIS PARA FRENTE NO CÓDIGO, SE O GUERREIRO VAI QUERER OU NÃO VAI QUERER A
  // VIDAEXTRA POR MEIO DO PEDIDO DE MISERICORDIA. MAS O MAIS "IMPORTANTE" DESSA
  // PARTE DA CODIFICAÇÃO É A REMOÇÃO DOS ESPAÇOS POR MEIO DO
  // "misercoridia.trim()E LOGO DEPOIS UTILIZAMOS O ".split" PARA LOCALIZAR AS
  // PALAVRAS. CASO RETORNE UM PEDIDO DE MISERICORDIA < 5 PALAVRAS = VIDA EXTRA
  // NEGADA, CASO CONTRÁRIO PEDIDO DE MISERICORIDA>= 5 = VIDA EXTRA CONCEDIDA. A
  // LENGTH PARA CONTAR QUANTAS STRING'S.

  boolean decidirVidaExtra(String misericordia) {
    String removeSpaces = misericordia.trim();
    String[] espaces = removeSpaces.split("\\s+");

    int palavras = espaces.length;

    if (palavras >= 5)
      return true;

    else
      return false;

  }

}

// NO CÓDIGO PRINCIPAL(MAIN) CHAMAMOS A CLASSE GUERREIRO POR MEIO DO "Guerreiro
// Warrior1" E CHAMAMOS A CLASSE ORÁCULO POR MEIO " Oraculo Oracle1".
class Main {
  public static void main(String[] args) {
    Guerreiro Warrior1 = new Guerreiro();
    Oraculo Oracle1 = new Oraculo();
    Oracle1.Guerreiro = Warrior1;

    // ATRIBUIMOS A VARIÁVEL EXTRA, ANSWERLIFE E STRING MERCYREQUEST,
    // RESPECTIVAMENTE, COM O VALOR "1" PARA QUE NÃO FICASSE EM LOOPING INFINITO O
    // "PEDIDO DE MISERICORDIA", COM O VALOR "3" PARA NÃO FICAR DANDO ERRO NO CÓDIGO
    // E A STRING "VAZIA" PARA NÃO FICAR DANDO ERRO NO CÓDIGO.

    int extra = 1;
    int answerLife = 3;
    String mercyRequest = " ";
    Warrior1.Vidas = Oracle1.setVidas();

    // AQUI CHAMAMOS A CLASSE ORÁCULO E ATRIBUIMOS O NOME DO ORÁCULO POR MEIO
    // "JOptionPane.showInputDialog". LOGO DEPOIS CHAMAMOS A CLASSE GUERREIRO E
    // ATRIBUIMOS O NOME DO GUERREIRO POR MEIO "JOptionPane.showInputDialog".

    Oracle1.setNome(JOptionPane.showInputDialog("O Oráculo se chama:"));
    Warrior1.setNome(JOptionPane.showInputDialog("O Guerreiro se chama:"));

    // AQUI USAMOS "JOptionPane.showMessageDialog" E CHAMAMOS O PROLOGO INTROIDUÇÃO
    // DA CLASSE ORÁCULO.

    JOptionPane.showMessageDialog(null, Oracle1.prologoIntroducao());

    // AQUI USAMOS A VARIÁVEL "int level1SecretNum" PARA GUARDAR O VALOR
    // ENVIADO(SEGREDO) AO ORÁCULO QUE É CHAMADO POR MEIO DA CLASSE ORÁCULO E O
    // MÉTODO, RESPECTIVAMENTE. Oracle1.loadLevel1().

    int level1SecretNum = Oracle1.loadLevel1();

    JOptionPane.showMessageDialog(null, "-Oráculo: te darei uma pequena DICA caso erre");

    // AQUI USAMOS O COMANDO DE REPETIÇÃO "WHILE" PARA QUE OCORRA A REPETIÇÃO DAS
    // MENSAGENS EM QUESTÃO ATÉ QUE O GUERREIRO ACERTE O SEGREDO OU ZERE A
    // QUANTIDADE DE VIDAS E CONSEQUENTEMENTE É DERROTADO PELO ORÁCULO.

    while (true) {

      int warriorGuess = Integer.parseInt(JOptionPane.showInputDialog("Tente adivinhar o segredo da porta! "));

      if (warriorGuess == level1SecretNum) {
        JOptionPane.showMessageDialog(null,
            "Muito bem, guerreiro. Você adivinhou o segredo!\n\nAinda não acabou, prepare-se para o 2º level...");
        break;
      }

      else if (warriorGuess > level1SecretNum) {
        JOptionPane.showMessageDialog(null, "O número digitado é MAIOR(>) que o segredo.\nTente de novo.");
        Warrior1.Vidas = Warrior1.Vidas - 1;
      } else {
        JOptionPane.showMessageDialog(null, "O número digitado é MENOR(<) que o segredo.\nTente de novo.");
        Warrior1.Vidas = Warrior1.Vidas - 1;
      }
      if (Warrior1.Vidas == 0) {
        JOptionPane.showMessageDialog(null, Oracle1.prologoPerdedor());
        break;
      }
      if (Warrior1.Vidas == 1 && extra == 1) {
        answerLife = Integer.parseInt(JOptionPane.showInputDialog(
            "Você tem apenas 1 vida!\nQuer realizar um pedido de clemência ao Oráculo?\n\n' 1 ' para SIM , ' 0 ' para NÃO"));

        while (answerLife != 1 && answerLife != 0) {
          JOptionPane.showMessageDialog(null, "Resposta diferente de 0 e 1...");

          answerLife = Integer.parseInt(JOptionPane.showInputDialog(
              "Resposta inválida.\nQuer realizar um pedido de clemência ao Oráculo?\n\n' 1 ' para SIM e ' 0 ' para NÃO"));
        }
        if (answerLife == 1) {
          mercyRequest = JOptionPane.showInputDialog("Digite o seu pedido de clemência: ");

          if (Oracle1.decidirVidaExtra(mercyRequest)) {
            JOptionPane.showMessageDialog(null,
                "O bondoso oráculo" + Oracle1.Nome + " te deu mais uma vida.\nFaça valer a pena!");
            Warrior1.Vidas = Warrior1.Vidas + 1;
          } else {
            JOptionPane.showMessageDialog(null,
                "Oráculo " + Oracle1.Nome + " te negou a vida extra.\nDevia ter feito um pedido melhor...");
          }
        }
        extra = 0;
      }

      JOptionPane.showMessageDialog(null, "Você tem " + Warrior1.Vidas + " vidas restantes.");
    }
    if (Warrior1.Vidas > 0) {

      JOptionPane.showMessageDialog(null, "Hora do jogo de par ou ímpar");

      while (true) {

        int evenOrOddAnswer = Integer.parseInt(JOptionPane.showInputDialog("Par ou ímpar?\n1 - Ímpar | 2 - Par"));

        // A VARIÁVEL "evenOrOdd" RECEBE A CLASSE ORÁCULO E O MÉTODO LEVEL 2 QUE RECEBE
        // "evenOrOddAnswer" COMO PARÂMETRO PARA SABER SE A OPÇÃO ESCOLHIDA FOI ÍMPAR OU
        // PAR.

        int evenOrOdd = Oracle1.loadLevel2(evenOrOddAnswer);

        if (evenOrOdd == 1) {
          JOptionPane.showMessageDialog(null, Oracle1.prologoVencedor());
          break;
        } else if (evenOrOdd == 0) {
          JOptionPane.showMessageDialog(null, "Você perdeu.");
          Warrior1.Vidas = Warrior1.Vidas - 1;
          JOptionPane.showMessageDialog(null, " Ainda restam " + Warrior1.Vidas + " vidas.");
        }

        if (Warrior1.Vidas == 1 && extra == 1) {
          answerLife = Integer.parseInt(JOptionPane.showInputDialog(
              "Você tem apenas 1 vida!\nQuer realizar um pedido de clemência ao Oráculo?\n\n'1' para SIM ou '0' para NÃO"));

          while (answerLife != 1 && answerLife != 0) {
            JOptionPane.showMessageDialog(null, "Erro. Resposta diferente de 0 ou 1");

            answerLife = Integer.parseInt(JOptionPane.showInputDialog(
                "Resposta inválida.\nQuer realizar um pedido de clemência ao Oráculo?\n\n'1' para SIM ou '0' para NÃO"));
          }
          if (answerLife == 1) {
            mercyRequest = JOptionPane.showInputDialog("Digite o seu pedido de clemência: ");

            if (Oracle1.decidirVidaExtra(mercyRequest)) {
              JOptionPane.showMessageDialog(null,
                  "O bondoso oráculo" + Oracle1.Nome + " te deu mais uma vida.\nFaça valer a pena!");
              Warrior1.Vidas = Warrior1.Vidas + 1;
            } else {
              JOptionPane.showMessageDialog(null,
                  "Oráculo " + Oracle1.Nome + " te negou a vida extra.\nDevia ter feito um pedido melhor...");
            }
          }
          extra = 0;
        }

        if (Warrior1.Vidas == 0) {

          JOptionPane.showMessageDialog(null, Oracle1.prologoPerdedor());
          break;
        }
      }
    }

  }
}