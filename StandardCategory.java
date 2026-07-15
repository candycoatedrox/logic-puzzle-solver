import java.util.Arrays;

public class StandardCategory extends Category {
    
    private String[] values;

    // --- CONSTRUCTORS ---

    /* Main constructor; use setCategory() to set values and clue template later */
    public StandardCategory(String name, int count) {
        super(name, count);
        this.values = new String[count];
    }

    public StandardCategory(String name, String clueTemplate, String... values) {
        super(name, values.length);
        this.values = values;
        this.clueTemplate = clueTemplate;

        for (int i = 0; i < values.length; i++) {
            clueValues[i] = clueTemplate.replace("{VAL}", values[i]);
        }
    }

    public StandardCategory(String name, String... values) {
        this(name, "{VAL}", values);
    }

    // --- SET CATEGORY ---

    public void setCategory(String clueTemplate, String... values) {
        int n = getCount();
        if (values.length > n) throw new IllegalArgumentException("Not enough values provided");

        this.clueTemplate = clueTemplate;
        this.values = Arrays.copyOf(values, n);
        updateClueValues();
    }

    // --- GETTERS & SETTERS ---

    @Override
    public int getCount() {
        return values.length;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String... values) {
        int n = getCount();
        if (values.length > n) throw new IllegalArgumentException("Not enough values provided");

        this.values = Arrays.copyOf(values, n);
        updateClueValues();
    }

    public String getValue(int i) {
        return values[i];
    }

    @Override
    public String[] getDisplayValues() {
        return values;
    }

    @Override
    public String getDisplayValue(int i) {
        return values[i];
    }

    @Override
    protected void updateDisplayValue(int i) {
    }

    @Override
    protected void updateClueValue(int i) {
        clueValues[i] = clueTemplate.replace("{VAL}", String.valueOf(values[i]));
    }

}
