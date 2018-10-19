import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static XSSFSheet excelWorkSheet;
    private static XSSFWorkbook excelWorkBook;
    private static XSSFCell cell;
    private static XSSFRow row;

    public static void setExcelFile(String Path, int sheetIndex) {
        try {
            //Open excel file
            FileInputStream excelFile = new FileInputStream(Path);

            excelWorkBook = new XSSFWorkbook(excelFile);
            excelWorkSheet = excelWorkBook.getSheetAt(sheetIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static XSSFSheet getExcelWorkSheet() {
        return excelWorkSheet;
    }

    public static String getCellData(int rowNum, int colNum) {
        try {
            cell = excelWorkSheet.getRow(rowNum).getCell(colNum);
            String CellData = cell.getStringCellValue();

            return CellData;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setCellData(String result, int rowNum, int colNum) {
        try {
            row = excelWorkSheet.getRow(rowNum);
            cell = row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(result);
            } else {
                cell.setCellValue(result);
            }

            //Constant variables
            FileOutputStream fileOut = new FileOutputStream(Constants.reportPath);
            excelWorkBook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
