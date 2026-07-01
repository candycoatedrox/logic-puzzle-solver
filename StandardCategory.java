public class StandardCategory extends AbstractCategory {
    
    private String[] values;

    // --- CONSTRUCTORS ---

    public StandardCategory(String clueTemplate, String... values) {
        this.values = values;
        this.clueTemplate = clueTemplate;

        clueValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            clueValues[i] = clueTemplate.replace("$VAL", values[i]);
        }
    }

    public StandardCategory(String... values) {
        this("$VAL", values);
    }

    // --- GETTERS ---

    public String[] getValues() {
        return values;
    }

    public String getValue(int i) {
        return values[i];
    }

    public int getCount() {
        return values.length;
    }

}
