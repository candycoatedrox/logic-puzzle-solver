import java.awt.*;
import javax.swing.*;

public class GridPanel extends JPanel {

    private final LogicPuzzleGrid grid;

    // --- CONSTRUCTOR ---
    
    public GridPanel(LogicPuzzleGrid grid) {
        this.grid = grid;
        this.setPreferredSize(new Dimension(750,750));
    }

    // --- PAINT ---

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;




        // TODO
    }

}
