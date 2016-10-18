package javafxpert;

import java.util.ArrayList;
import java.util.List;

public class Main {
  //static String gameStatus = "";
  static final int X_WIN_SCORE = 10;
  static final int O_WIN_SCORE = -10;

  static String evalGameStatus(String moves) {
    String gameStatus = "";
    // Check if O (second player) won
    String oMoves = "";
    for (int i = 1; i < moves.length(); i += 2) {
      oMoves += moves.charAt(i);
    }
    gameStatus = "I";
    if ((oMoves.contains("1") && oMoves.contains("2") && oMoves.contains("3")) ||
        (oMoves.contains("4") && oMoves.contains("5") && oMoves.contains("6")) ||
        (oMoves.contains("7") && oMoves.contains("8") && oMoves.contains("9")) ||
        (oMoves.contains("1") && oMoves.contains("4") && oMoves.contains("7")) ||
        (oMoves.contains("2") && oMoves.contains("5") && oMoves.contains("8")) ||
        (oMoves.contains("3") && oMoves.contains("6") && oMoves.contains("9")) ||
        (oMoves.contains("1") && oMoves.contains("5") && oMoves.contains("9")) ||
        (oMoves.contains("3") && oMoves.contains("5") && oMoves.contains("7"))) {
      gameStatus = "O";
    }
    else {
      // Check if X (first player) won
      String xMoves = "";
      for (int i = 0; i < moves.length(); i += 2) {
        xMoves += moves.charAt(i);
      }
      gameStatus = "I";
      if ((xMoves.contains("1") && xMoves.contains("2") && xMoves.contains("3")) ||
          (xMoves.contains("4") && xMoves.contains("5") && xMoves.contains("6")) ||
          (xMoves.contains("7") && xMoves.contains("8") && xMoves.contains("9")) ||
          (xMoves.contains("1") && xMoves.contains("4") && xMoves.contains("7")) ||
          (xMoves.contains("2") && xMoves.contains("5") && xMoves.contains("8")) ||
          (xMoves.contains("3") && xMoves.contains("6") && xMoves.contains("9")) ||
          (xMoves.contains("1") && xMoves.contains("5") && xMoves.contains("9")) ||
          (xMoves.contains("3") && xMoves.contains("5") && xMoves.contains("7"))) {
        gameStatus = "X";
      }
    }
    return gameStatus;
  }

  static int permute(int level, String permuted,
                      boolean used[], String original) {
//    String tempPrefix = "27689";
//    String tempPrefix = "";
//    String tempPrefix = "123485";
    String tempPrefix = "314879";

    List<Integer> scores = new ArrayList<>();
    List<String> moves = new ArrayList<>();

    int xMiniMaxScore = 0;
    int length = original.length();

    //evalGameStatus(permuted);
    String gs = evalGameStatus(tempPrefix + permuted);

    if (!gs.equalsIgnoreCase("I")) {
      int depth = 0;
      if (gs.equalsIgnoreCase("X")) {

        //depth = (tempPrefix + permuted).length() - tempPrefix.length();
        depth = 0;

        xMiniMaxScore = X_WIN_SCORE - depth;
        scores.add(xMiniMaxScore);
        //String move = (tempPrefix + permuted).substring((tempPrefix + permuted).length() - 1);
        //moves.add(move);
      }
      else if (gs.equalsIgnoreCase("O")) {

        //depth = (tempPrefix + permuted).length() - tempPrefix.length();
        depth = 0;

        xMiniMaxScore = O_WIN_SCORE + depth;
        //scores.add(xMiniMaxScore);
      }
      //if (xMiniMaxScore >= 7) {
      //System.out.println(tempPrefix + permuted + " " + gs + " " + scores);
      //}
    }

    if (level == length) {
      /*
      evalGameStatus(permuted);
      if (gameStatus.equalsIgnoreCase("X")) {
        System.out.println(permuted + " " + gameStatus);
      }
      */
    }
    else {
      for (int i = 0; i < length; i++) {
        if (!used[i]) {
          used[i] = true;
          int score;
          score = permute(level + 1, permuted + original.charAt(i),
              used, original);
          scores.add(score);
          String move = new Character(original.charAt(i)).toString();
          moves.add(move);
          System.out.println(tempPrefix + permuted + " " + gs + " " + scores + " " + moves);
          used[i] = false;
        }
      }
    }
    return xMiniMaxScore;
  }

  public static void main(String[] args) {
//    String s = "123456789";
//    boolean used[] = {false, false, false, false, false, false, false, false, false};
    String s = "256";
    boolean used[] = {false, false, false};
//    String s = "1345";
//    boolean used[] = {false, false, false, false};
//    String s = "679";
//    boolean used[] = {false, false, false};
//    String s = "256";
//    boolean used[] = {false, false, false};

    permute(0, "", used, s);
  }
}
