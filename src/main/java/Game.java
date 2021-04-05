public class Game {
    private String p1Move, p2Move;

    public void isValidInput(String move) throws IllegalArgumentException {
        if (!move.equals("rock") && !move.equals("paper") && !move.equals("scissors")) {
            throw new IllegalArgumentException("Bad Choice!");
        }
    }

    public void setP1Move(String p1Move) {
        isValidInput(p1Move);
        this.p1Move = p1Move;
    }

    public void setP2Move(String p2Move) {
        isValidInput(p2Move);
        this.p2Move = p2Move;
    }

    public String result() {
        if (p1Move.equals(p2Move))
            return "Draw!";
        else if (p1Move.equals("rock"))
            return p2Move.equals("paper") ? "Player 2 win!" : "Player 1 win!";
        else if (p1Move.equals("paper"))
            return p2Move.equals("scissors") ? "Player 2 win!" : "Player 1 win!";
        else
            return p2Move.equals("rock") ? "Player 2 win!" : "Player 1 win!";
    }
}
