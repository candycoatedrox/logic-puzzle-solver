public class PuzzleDriver {

    private static LogicPuzzle puzzle;

    public static void main(String[] args) {
        puzzle = new LogicPuzzle(3, 4, "price", "person", "sandwich");
        System.out.println(puzzle);
    }
    
}
