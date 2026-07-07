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
            clueValues[i] = clueTemplate.replace("$VAL", values[i]);
        }
    }

    public StandardCategory(String name, String... values) {
        this(name, "$VAL", values);
    }

    // --- GETTERS & SETTERS ---

    public void setCategory(String clueTemplate, String... values) {
        int n = getCount();
        if (values.length > n) throw new IllegalArgumentException("Not enough values provided");

        this.clueTemplate = clueTemplate;
        this.values = Arrays.copyOf(values, n);
        setClueValues();
    }

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
        setClueValues();
    }

    public String getValue(int i) {
        return values[i];
    }

    @Override
    public void setClueValues() {
        for (int i = 0; i < getCount(); i++) {
            clueValues[i] = clueTemplate.replace("$VAL", values[i]);
        }
    }

}
