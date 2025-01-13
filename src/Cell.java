public class Cell {
    private String content;

    public Cell(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isNumber() {
        try {
            Double.parseDouble(content);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isText() {
        return !isNumber() && !isFormula();
    }

    public boolean isFormula() {
        return content.startsWith("=");
    }
}
