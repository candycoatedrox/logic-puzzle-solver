public abstract class Category {

    protected String name;
    protected String clueTemplate;

    protected String[] clueValues;

    // --- CONSTRUCTOR ---

    public Category(String name, int count) {
        this.name = name;
        clueValues = new String[count];
    }

    // --- GETTERS ---

    public String getClueTemplate() {
        return clueTemplate;
    }

    public void setClueTemplate(String template) {
        clueTemplate = template;
        setClueValues();
    }

    public String[] getClueValues() {
        return clueValues;
    }

    public abstract void setClueValues();

    public String getClueValue(int i) {
        return clueValues[i];
    }

    // --- MISC ---

    @Override
    public String toString() {
        return name;
    }

}
