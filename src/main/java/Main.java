import java.util.Scanner;

public class Main {
    private static Game game = new Game();
    private static Scanner scanner = new Scanner(System.in);

    public static void welcome() {
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
    }

    private static void getPlayer1Move() {
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        String p1 = scanner.nextLine();
        game.setP1Move(p1);
    }

    private static void getPlayer2Move() {
        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        String p2 = scanner.nextLine();
        game.setP2Move(p2);
    }

    public static void main(String[] args) {
        welcome();
        getPlayer1Move();
        getPlayer2Move();
        System.out.println(game.result());
    }
}
