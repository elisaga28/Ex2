public class Ex2Sheet implements Sheet {
    private CellEntry[][] cells;

    public Ex2Sheet(int rows, int cols) {
        cells = new CellEntry[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new CellEntry("");
            }
        }
    }

    @Override
    public void setCell(int x, int y, String content) {
        cells[x][y].setContent(content);
    }

    @Override
    public String getCellContent(int x, int y) {
        return cells[x][y].getContent();
    }

    @Override
    public double evaluateCell(int x, int y) throws Exception {
        return cells[x][y].computeFormula(this);
    }

    @Override
    public String[][] evaluateAll() throws Exception {
        int rows = cells.length;
        int cols = cells[0].length;
        String[][] result = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                try {
                    result[i][j] = String.valueOf(evaluateCell(i, j));
                } catch (Exception e) {
                    result[i][j] = "ERR";
                }
            }
        }

        return result;
    }
}
