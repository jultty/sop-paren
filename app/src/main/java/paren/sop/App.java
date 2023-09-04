package paren.sop;

import java.util.Stack;
import javax.swing.JOptionPane;

public class App {

  public static void main(String[] args) {

    Stack P = new Stack();

    String user_input =
      JOptionPane.showInputDialog("Digite a sequência de parênteses:");
    char[] user_expression = user_input.toCharArray();

    boolean user_evaluation = evaluateExpression(P, user_expression);

    String user_message;

    if (user_evaluation == true)
      user_message = "Expressão válida.";
    else
      user_message = "Expressão inválida.";

    JOptionPane.showMessageDialog(null, user_message);
  }

  // Criar a função pop(P, sym)
  // empilha na pilha P um caractere lido da expressão analisada
  // parâmetros: a pilha P e o caractere lido sym
  public static void pop(Stack p, char sym) { p.push(sym); }

  // Criar a função top()
  // retorno: o caractere empilhado no topo da pilha P
  // parâmetro: a pilha P
  public static char top(Stack p) { return (char) p.peek(); }

  public static boolean evaluateExpression(Stack P, char[] expression) {

    // Para cada caractere sym na expressão (percorrendo da esq. para direita) repita:
    for (int i = 0; i < expression.length; i++) {

      char sym = expression[i];

      // 5.1 Se sym é um parêntesis esquerdo
      if (sym == '(') {
        // 5.1.1 Adicione sym ao topo da pilha P
        pop(P, sym);
      }

      // 5.2 Se sym é um parêntesis direito
      else if (sym == ')') {
        // 5.2.1 Se a pilha P está vazia, termine com false.
        if (P.isEmpty()) {
          return false;
        }

        // 5.2.2 Remova o parêntesis do topo de P para uma variável left.
        char left = top(P);
        P.pop();

        // 5.2.3 Se left e sym não são complementares, termine com false.
        if (left == sym) {
          return false;

        }
      }
    }

    // Termine com true se a pilha P está vazia, ou false caso contrário
    if (P.isEmpty()) { return true; } else { return false; }
  }
}
