public class Ex2Main {
    public static void main(String[] args) {
        // יצירת גיליון בגודל 3x3
        Spreadsheet spreadsheet = new Spreadsheet(3, 3);

        // הגדרת תאים
        spreadsheet.setCell(0, 0, "123");          // תא עם מספר
        spreadsheet.setCell(0, 1, "=2+3");         // תא עם נוסחה
        spreadsheet.setCell(0, 2, "Hello World");  // תא עם טקסט
        spreadsheet.setCell(1, 0, "=5*5");         // נוסחה נוספת

        System.out.println("תוכן הגיליון לפני הערכה:");
        printSpreadsheet(spreadsheet);

        // חישוב נוסחה בתא ספציפי
        try {
            System.out.println("\nתוצאה של התא (0,1): " + spreadsheet.evaluateCell(0, 1)); // ציפוי 5
            System.out.println("תוצאה של התא (1,0): " + spreadsheet.evaluateCell(1, 0)); // ציפוי 25
        } catch (Exception e) {
            System.out.println("שגיאה בחישוב תא: " + e.getMessage());
        }

        // חישוב והדפסת כל הגיליון
        System.out.println("\nתוכן הגיליון לאחר הערכה:");
        printEvaluatedSpreadsheet(spreadsheet);
    }

    // פונקציה להדפסת תוכן הגיליון לפני הערכה
    private static void printSpreadsheet(Spreadsheet spreadsheet) {
        for (int i = 0; i < spreadsheet.getRowCount(); i++) {
            for (int j = 0; j < spreadsheet.getColumnCount(); j++) {
                System.out.print(spreadsheet.getCellContent(i, j) + "\t");
            }
            System.out.println();
        }
    }

    // פונקציה להדפסת תוכן הגיליון לאחר הערכה
    private static void printEvaluatedSpreadsheet(Spreadsheet spreadsheet) {
        String[][] results = spreadsheet.evaluateAll();
        for (String[] row : results) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
