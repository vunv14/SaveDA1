//package utils;
//
//
//import java.io.File;
//import java.io.IOException;
//import javax.swing.JTable;
//import javax.swing.table.TableModel;
//import jdk.jfr.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import org.apache.poi.ss.usermodel.Workbook;
//
//public class ExcelHelper {
//
//     public static void fillData(JTable table, File file, int cols, int rows) {
//        try {
//            WritableWorkbook workbook1 = jxl.Workbook.createWorkbook(file);
//            WritableSheet sheet1 = workbook1.createSheet("First Sheet", 0);
//            TableModel model = table.getModel();
//
//            for (int i = 0; i < cols; i++) {
//                jxl.write.Label column = new jxl.write.Label(i, 0, model.getColumnName(i));
//                sheet1.addCell(column);
//            }
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    jxl.write.Label row = new jxl.write.Label(j, i + 1,
//                            model.getValueAt(i, j).toString());
//                    sheet1.addCell(row);
//                }
//            }
//            workbook1.write();
//            workbook1.close();
//        } catch (IOException | WriteException ex) {
//            ex.printStackTrace(System.err);
//        }
//    }
//
//
// 
//}
