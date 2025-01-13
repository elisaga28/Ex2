public class Spreadsheet {
    private Cell[][] cells;

    public Spreadsheet(int rows, int cols) {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(""); // תאים ריקים כברירת מחדל
            }
        }
    }

    public void setCell(int row, int col, String content) {
        cells[row][col].setContent(content);
    }

    public String getCellContent(int row, int col) {
        return cells[row][col].getContent();
    }

    public boolean isNumber(int row, int col) {
        return cells[row][col].isNumber();
    }

    public boolean isText(int row, int col) {
        return cells[row][col].isText();
    }

    public boolean isFormula(int row, int col) {
        return cells[row][col].isFormula();
    }

    public double evaluateCell(int row, int col) throws Exception {
        if (!cells[row][col].isFormula()) {
            throw new IllegalArgumentException("Cell is not a formula");
        }
        return new CellEntry(cells[row][col].getContent()).computeFormula(null);
    }

    public String[][] evaluateAll() {
        String[][] result = new String[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isNumber()) {
                    result[i][j] = cells[i][j].getContent();
                } else if (cells[i][j].isFormula()) {
                    try {
                        result[i][j] = String.valueOf(evaluateCell(i, j));
                    } catch (Exception e) {
                        result[i][j] = "ERR";
                    }
                } else {
                    result[i][j] = "TEXT";
                }
            }
        }
        return result;
    }

    public int getRowCount() {
        return cells.length;
    }

    public int getColumnCount() {
        return cells[0].length;
    }
}
