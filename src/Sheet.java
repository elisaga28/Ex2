public interface Sheet {
    void setCell(int x, int y, String content);
    String getCellContent(int x, int y);
    double evaluateCell(int x, int y) throws Exception;
    String[][] evaluateAll() throws Exception;
}
