import javax.swing.JFrame;

public class GridFrame extends JFrame {

    private final GridPanel panel;

    // --- CONSTRUCTOR ---

    public GridFrame(LogicPuzzleGrid grid) {
        panel = new GridPanel(grid);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
