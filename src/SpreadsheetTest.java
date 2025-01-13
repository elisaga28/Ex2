import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpreadsheetTest {

    @Test
    void testSetAndGetCell() {
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);
        spreadsheet.setCell(0, 0, "123");
        assertEquals("123", spreadsheet.getCellContent(0, 0));
    }

    @Test
    void testIsNumber() {
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);
        spreadsheet.setCell(0, 0, "123");
        assertTrue(spreadsheet.isNumber(0, 0));
    }

    @Test
    void testIsText() {
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);
        spreadsheet.setCell(0, 0, "Hello");
        assertTrue(spreadsheet.isText(0, 0));
    }

    @Test
    void testIsFormula() {
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);
        spreadsheet.setCell(0, 0, "=2+3");
        assertTrue(spreadsheet.isFormula(0, 0));
    }

    @Test
    void testEvaluateCell() throws Exception {
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);
        spreadsheet.setCell(0, 0, "=2+3");
        assertEquals(5.0, spreadsheet.evaluateCell(0, 0));
    }

    @Test
    void testEvaluateAll() {
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);
        spreadsheet.setCell(0, 0, "=2+3");
        spreadsheet.setCell(0, 1, "123");
        spreadsheet.setCell(0, 2, "Hello");

        String[][] results = spreadsheet.evaluateAll();

        assertEquals("5.0", results[0][0]);
        assertEquals("123", results[0][1]);
        assertEquals("TEXT", results[0][2]);
    }
}
