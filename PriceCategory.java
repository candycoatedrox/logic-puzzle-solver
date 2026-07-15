public class PriceCategory extends NumericalCategory {

    // --- CONSTRUCTORS ---

    public PriceCategory(String name, int count, double startValue, double step, String displayNoun, String clueTemplate) {
        super(name, count, startValue, step, displayNoun, clueTemplate);
        if (startValue <= 0 || startValue + step*5 <= 0) throw new IllegalArgumentException("All values in a price category must be positive");
    }

    public PriceCategory(String name, int count, int startValue, double step, String displayNoun, String clueTemplate) {
        this(name, count, (double)startValue, step, displayNoun, clueTemplate);
    }

    public PriceCategory(String name, int count, int startValue, int step, String displayNoun, String clueTemplate) {
        this(name, count, (double)startValue, (double)step, displayNoun, clueTemplate);
    }

    public PriceCategory(String name, int count, double startValue, double step, String displayNoun) {
        this(name, count, startValue, step, displayNoun, "{VAL}");
    }

    public PriceCategory(String name, int count, int startValue, double step, String displayNoun) {
        this(name, count, (double)startValue, step, displayNoun, "{VAL}");
    }

    public PriceCategory(String name, int count, int startValue, int step, String displayNoun) {
        this(name, count, (double)startValue, (double)step, displayNoun, "{VAL}");
    }

    public PriceCategory(String name, int count, double startValue, double step) {
        this(name, count, startValue, step, "", "{VAL}");
    }

    public PriceCategory(String name, int count, int startValue, double step) {
        this(name, count, (double)startValue, step, "", "{VAL}");
    }

    public PriceCategory(String name, int count, int startValue, int step) {
        this(name, count, (double)startValue, (double)step, "", "{VAL}");
    }

    // --- GETTERS & SETTERS ---
    
    @Override
    protected String rawDisplayValue(int i) {
        return Utils.numAsPrice(values[i], hasDisplayNoun());
    }
    
}
