
public class DfaTable {

  private int state;

  private final int q1 = 0;
  private final int q2 = 1;
  private final int q3 = 2;
  private final int q4 = 3;
  private final int q5 = 4;

  private final int[][] delta = {
    // E   G   L   O   X
      {q1, q2, q1, q1, q1},
      {q1, q3, q1, q2, q1},
      {q1, q3, q4, q2, q1},
      {q5, q2, q1, q1, q1},
      {q5, q5, q5, q5, q5}
  };

  public String checkWord (String word) {
    state = 0;

    for (int i = 0; i < word.length(); i++) {

      if (state == q5) return "valido";

      if (word.charAt(i) == 'G' && (state == q1 || state == q2))
        state = delta[state][1];

      else if (word.charAt(i) == 'O') {
        if (state == q2)
          state = delta[state][3];
      }

      else if (word.charAt(i) == 'L' && state == q3)
        state = delta[state][2];

      else if (word.charAt(i) == 'E' && state == q4)
        state = delta[state][0];

      else
        state = delta[0][0];
    }

    return (state == q5) ? "valido" : "nao valido";
  }

}
