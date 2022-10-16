package com.product.inventory.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.product.inventory.entity.ProductInventoryEntity;

public class ProductInventoryCSVHelper {

	public static boolean validateCSVFormat(MultipartFile file) {
		System.out.println(file.getContentType());
		if (file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	public static List<ProductInventoryEntity> importCSVToDatabase(InputStream inputStream) {
		List<ProductInventoryEntity> ProductInventoryList = new ArrayList<>();
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","Strympathy@17");
		try {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			XSSFSheet xssfWorkbookSheet = xssfWorkbook.getSheetAt(0);
			//getSheet("sample_inventory");
			int rowNumber = 0;
			Iterator<Row> iteratorRow = xssfWorkbookSheet.iterator();
			while (iteratorRow.hasNext()) {
				Row row = iteratorRow.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid = 0;

				ProductInventoryEntity productInventoryEntity = new ProductInventoryEntity();

				while (cells.hasNext()) {

					Cell cell = cells.next();

					switch (cid) {
						/*case 0:
							productInventoryEntity.setCode(cell.getStringCellValue());
							break;*/
						case 0:
							System.out.println("Case 0");
							productInventoryEntity.setName(cell.getStringCellValue());
							break;
						case 1:
							System.out.println("Case 1");
							productInventoryEntity.setStock((int) (cell.getNumericCellValue()));
							break;

						case 2:
							System.out.println("Case 2");
							productInventoryEntity.setDeal((int) (cell.getNumericCellValue()));
							break;

						case 3:
							System.out.println("Case 3");
							productInventoryEntity.setFree((int) (cell.getNumericCellValue()));
							break;

						case 4:
							System.out.println("Case 4");
							productInventoryEntity.setMrp((float) cell.getNumericCellValue());
							break;

						case 5:
							System.out.println("Case 5");
							productInventoryEntity.setRate((float) (cell.getNumericCellValue()));
							break;

						case 6:
							System.out.println("Case 6");
							productInventoryEntity.setCompany(cell.getStringCellValue());
							break;

						case 7:
							System.out.println("Case 7");
							if (cell.getCellType()== CellType.NUMERIC) {
								productInventoryEntity.setBatch(String.valueOf(cell.getNumericCellValue()));
								break;
							} else if(cell.getCellType()== CellType.STRING){
								productInventoryEntity.setBatch((cell.getStringCellValue()));
								break;
							} else
								break;

						case 8:
							System.out.println("Case 8");
							if (cell.getCellType()== CellType.NUMERIC) {
								System.out.println("Expiry Numeric");
								productInventoryEntity.setExpiry((cell.getDateCellValue()));
								break;
							} else if(cell.getCellType()== CellType.STRING){
								System.out.println("Expiry String");
								productInventoryEntity.setExpiry(null);
								break;
							} else
								break;

						case 9:
							System.out.println("Case 9");
							productInventoryEntity.setSupplier(cell.getStringCellValue());
							break;
						default:
							break;
					}
					cid++;

				}
				ProductInventoryList.add(productInventoryEntity);
			}

		} catch (IOException e) {
			throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
		}
		return ProductInventoryList;
	}
}
		/*List<String> productInventoryList = new ArrayList<>();

		DataFormatter dataFormatter = new DataFormatter();

		try {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			XSSFSheet xssfWorkbookSheet = xssfWorkbook.getSheetAt(0);

			int noOfColumns = xssfWorkbookSheet.getRow(0).getLastCellNum();
			System.out.println("-------Sheet has '" + noOfColumns + "' columns------");

			for (Row row : xssfWorkbookSheet) {
				for (Cell cell : row) {
					String cellValue = dataFormatter.formatCellValue(cell);
					productInventoryList.add(cellValue);

				}
			}
			List<ProductInventoryEntity> productInventoryEntities =
					createProductInventoryEntityList(productInventoryList, noOfColumns);
			try {
				xssfWorkbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return productInventoryEntities;

		} catch (IOException e) {
			throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}*/

	/*private static List<ProductInventoryEntity> createProductInventoryEntityList
			(List<String> sheetData, int noOfColumns) throws ParseException {

		ArrayList<ProductInventoryEntity> productList = new ArrayList<ProductInventoryEntity>();

		int i = noOfColumns;
		do {
			ProductInventoryEntity productInventoryEntity = new ProductInventoryEntity();



			productInventoryEntity.setCode(sheetData.get(i));
			productInventoryEntity.setName(sheetData.get(i+1));
			productInventoryEntity.setBatch(sheetData.get(i+2));
			productInventoryEntity.setStock(Integer.parseInt(sheetData.get(i+3)));
			productInventoryEntity.setDeal(Integer.parseInt(sheetData.get(i+4)));
			productInventoryEntity.setFree(Integer.parseInt(sheetData.get(i+5)));
			productInventoryEntity.setMrp(Float.parseFloat(sheetData.get(i+6)));
			productInventoryEntity.setRate(Float.parseFloat(sheetData.get(i+7)));
			productInventoryEntity.setExpiry(sheetData.get(i+8));
			//productInventoryEntity.setExpiry(new SimpleDateFormat("dd/MM/yyyy").parse(sheetData.get(i+8)));

			productInventoryEntity.setCompany(sheetData.get(i+9));

			if (sheetData.get(i+10) != null) {
				productInventoryEntity.setSupplier(sheetData.get(i + 10));
			}


			productList.add(productInventoryEntity);
			i = i + (noOfColumns);

		} while (i < sheetData.size());
		return productList;

	}*/


