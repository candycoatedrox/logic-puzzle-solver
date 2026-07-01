public abstract class AbstractCategory {

    protected String name;
    protected String clueTemplate;

    protected String[] clueValues;

    // --- GETTERS ---

    public String[] getClueValues() {
        return clueValues;
    }

    public String getClueValue(int i) {
        return clueValues[i];
    }

    // --- MISC ---

    @Override
    public String toString() {
        return name;
    }

}
