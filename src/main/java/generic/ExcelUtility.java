package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


	public class ExcelUtility {
		String filepath;
		public ExcelUtility(String filepath)
		{
			this.filepath = filepath;
			}
		public String readData(String sheetName,int row,int cell) 
		{
			String value=null;
			try
			{
				
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Cell cl = wb.getSheet(sheetName).getRow(row).getCell(cell);

			switch(cl.getCellType())
			{
			case STRING:
				value=cl.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cl))
				{
					SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
					sdf.format(cl.getDateCellValue());
			}
				else
				{
					long longvalue = (long)cl.getNumericCellValue();
					value=Long.toString(longvalue);
					
				}
			break;
			case BOOLEAN:
				Boolean.toString(cl.getBooleanCellValue());
				break;
				default:
					System.out.println("cell Format is not matching");
					break;
			}
			}
			catch(EncryptedDocumentException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return value;
		}

}
