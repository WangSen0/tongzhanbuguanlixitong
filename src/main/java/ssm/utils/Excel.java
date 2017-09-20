package ssm.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ssm.entity.Person;

import java.io.*;
import java.util.Iterator;
import java.util.List;


/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/17
 */
public class Excel {
    public void write(List<Person> personList){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
        XSSFRow row;
        int rowId=0;

        row=spreadsheet.createRow(rowId++);
        int cellId1=0;
        Cell cell1;
        cell1=row.createCell(cellId1++);
        cell1.setCellValue("姓名");
        cell1=row.createCell(cellId1++);
        cell1.setCellValue("性别");
        cell1=row.createCell(cellId1++);
        cell1.setCellValue("出生年月");
        cell1=row.createCell(cellId1++);
        cell1.setCellValue("民族");
        cell1=row.createCell(cellId1++);
        cell1.setCellValue("党派");
        cell1=row.createCell(cellId1++);
        cell1.setCellValue("加入党派时间");
        for(Person person:personList){
            row=spreadsheet.createRow(rowId++);
            int cellId=0;
            Cell cell;
            cell=row.createCell(cellId++);
            cell.setCellValue(person.getName());
            cell=row.createCell(cellId++);
            cell.setCellValue(person.getSex());
            cell=row.createCell(cellId++);
            cell.setCellValue(person.getBirthday());
            cell=row.createCell(cellId++);
            cell.setCellValue(person.getNation());
            cell=row.createCell(cellId++);
            cell.setCellValue(person.getPart());
            cell=row.createCell(cellId++);
            cell.setCellValue(person.getParttime());
        }
        try {
            FileOutputStream out = new FileOutputStream(
                    new File("C:\\Users\\Administrator\\Desktop\\webssm\\src\\main\\webapp\\resources\\excel\\Writesheet.xlsx"));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
        }
    }
    public void writeModel(Person person){
        try{
            XSSFRow row;
            FileInputStream fis = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\webssm\\src\\main\\webapp\\resources\\excel\\model.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String s = cell.getStringCellValue();
                    if (s.equals("#name")) {
                        cell.setCellValue("王森");
                    } else if (s.equals("#sex")) {
                        cell.setCellValue(person.getSex());
                    } else if (s.equals("#birthday")) {
                        cell.setCellValue(person.getBirthday().trim());
                    } else if (s.equals("#nation")) {
                        cell.setCellValue(person.getNation());
                    } else if (s.equals("#nativeplace")) {
                        cell.setCellValue(person.getNativeplace());
                    } else if (s.equals("#part")) {
                        cell.setCellValue(person.getPart());
                    } else if (s.equals("#parttime")) {
                        cell.setCellValue(person.getParttime());
                    } else if (s.equals("#location")) {
                        cell.setCellValue(person.getLocation());
                    } else if (s.equals("#worktime")) {
                        cell.setCellValue(person.getWorktime());
                    } else if (s.equals("#health")) {
                        cell.setCellValue(person.getHealth());
                    } else if (s.equals("#title")) {
                        cell.setCellValue(person.getTitle());
                    } else if (s.equals("#eduction1")) {
                        cell.setCellValue(person.getEduction1());
                    } else if (s.equals("#school1")) {
                        cell.setCellValue(person.getSchool1());
                    } else if (s.equals("#eduction2")) {
                        cell.setCellValue(person.getEduction2());
                    } else if (s.equals("#school2")) {
                        cell.setCellValue(person.getSchool2());
                    } else if (s.equals("#job")) {
                        cell.setCellValue(person.getJob());
                    } else if (s.equals("#parttimejob")) {
                        cell.setCellValue(person.getParttimejob());
                    } else if (s.equals("#resume")) {
                        cell.setCellValue(person.getResume());
                    } else if (s.equals("#reason")) {
                        cell.setCellValue(person.getReason());
                    }
                }
            }
            FileOutputStream out = new FileOutputStream(
                    new File("C:\\Users\\Administrator\\Desktop\\webssm\\src\\main\\webapp\\resources\\excel\\wangsen1.xlsx"));
            workbook.write(out);
            out.close();
            fis.close();
        }

        catch(IOException e){

        }
    }
}
