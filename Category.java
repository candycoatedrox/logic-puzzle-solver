public abstract class Category {

    protected String name;

    protected String clueTemplate = "{VAL}";
    protected String[] clueValues;

    // --- CONSTRUCTOR ---

    public Category(String name, int count) {
        this.name = name;
        clueValues = new String[count];
    }

    // --- GETTERS ---

    public abstract int getCount();

    public abstract String[] getDisplayValues();
    public abstract String getDisplayValue(int i);

    public void updateDisplayValues() {
        for (int i = 0; i < getCount(); i++) {
            updateDisplayValue(i);
        }
    }

    protected abstract void updateDisplayValue(int i);

    public String getClueTemplate() {
        return clueTemplate;
    }

    public void setClueTemplate(String template) {
        clueTemplate = template;
        updateClueValues();
    }

    public String[] getClueValues() {
        return clueValues;
    }

    public String getClueValue(int i) {
        return clueValues[i];
    }

    public void updateClueValues() {
        for (int i = 0; i < getCount(); i++) {
            updateClueValue(i);
        }
    }

    protected abstract void updateClueValue(int i);

    // --- MISC ---

    @Override
    public String toString() {
        return name;
    }

}
