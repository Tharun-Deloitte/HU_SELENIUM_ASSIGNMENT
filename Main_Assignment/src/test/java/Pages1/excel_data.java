package Pages1;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class excel_data {
    XSSFWorkbook wb;
    XSSFSheet sheet1;
    public excel_data(String excelpath) throws IOException {
        File src = new File(excelpath);
        FileInputStream fis = fis = new FileInputStream(src);
        wb = new XSSFWorkbook(fis);
    }
    public String getData(int sheetno, int row, int column){
        sheet1 = wb.getSheetAt(sheetno);
        String data = sheet1.getRow(row).getCell(column).getStringCellValue();
        return data;
    }
    public int getData1(int sheetno, int row, int column){
        sheet1 = wb.getSheetAt(sheetno);
        int data1=(int)sheet1.getRow(row).getCell(column).getNumericCellValue();
        return data1;
    }

}
