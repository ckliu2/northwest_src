package com.base.web.displaytag;

import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.displaytag.Messages;
import org.displaytag.exception.BaseNestableJspTagException;
import org.displaytag.exception.SeverityEnum;
import org.displaytag.export.BinaryExportView;
import org.displaytag.model.Column;
import org.displaytag.model.ColumnIterator;
import org.displaytag.model.HeaderCell;
import org.displaytag.model.Row;
import org.displaytag.model.RowIterator;
import org.displaytag.model.TableModel;

/**
 * Excel exporter using POI HSSF.
 * 
 * @author Fabrizio Giustina
 * @version $Revision: 3 $ ($Author: Fgiust $)
 */
public class ExcelHssfView implements BinaryExportView {

	/**
	 * TableModel to render.
	 */
	private TableModel model;

	/**
	 * export full list?
	 */
	private boolean exportFull;

	/**
	 * include header in export?
	 */
	private boolean header;

	/**
	 * decorate export?
	 */
	private boolean decorated;

	/**
	 * Generated sheet.
	 */
	private HSSFSheet sheet;

	/**
	 * @see org.displaytag.export.ExportView#setParameters(TableModel, boolean,
	 *      boolean, boolean)
	 */
	public void setParameters(TableModel tableModel, boolean exportFullList, boolean includeHeader, boolean decorateValues) {
		this.model = tableModel;
		this.exportFull = exportFullList;
		this.header = includeHeader;
		this.decorated = decorateValues;
	}

	/**
	 * @see org.displaytag.export.BaseExportView#getMimeType()
	 * @return "application/vnd.ms-excel"
	 */
	public String getMimeType() {
		return "application/vnd.ms-excel"; //$NON-NLS-1$
	}

	/**
	 * @see org.displaytag.export.BinaryExportView#doExport(OutputStream)
	 */
	public void doExport(OutputStream out) throws JspException {
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			sheet = wb.createSheet("-");

			int rowNum = 0;
			int colNum = 0;

			if (this.header) {
				// Create an header row
				HSSFRow xlsRow = sheet.createRow(rowNum++);

				HSSFCellStyle headerStyle = wb.createCellStyle();
				
				//headerStyle.setFillPattern(HSSFCellStyle.FINE_DOTS);				
				//headerStyle.setFillBackgroundColor(HSSFColor.BLUE_GREY.index);
				
				
				
				//HSSFFont bold = wb.createFont();
				//bold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				//bold.setColor(HSSFColor.WHITE.index);
				//headerStyle.setFont(bold);

				Iterator iterator = this.model.getHeaderCellList().iterator();

				while (iterator.hasNext()) {
					HeaderCell headerCell = (HeaderCell) iterator.next();

					String columnHeader = headerCell.getTitle();

					if (columnHeader == null) {
						columnHeader = StringUtils.capitalize(headerCell.getBeanPropertyName());
					}

					HSSFCell cell = xlsRow.createCell((short) colNum++);
					cell.setCellValue(columnHeader);
					cell.setCellStyle(headerStyle);
					/*
					 * start of patch by Karsten Voges this formats the width of
					 * the colums either according to the maxLenght, set in the
					 * colum tag or to the lenght of the header cell which can
					 * be adjusted by putting tailing whitespaces in the
					 * message.properties
					 */
					int myColWidth = 2700;
					if (((HeaderCell) model.getHeaderCellList().get(colNum - 1)).getMaxLength() > 0)
						myColWidth = ((HeaderCell) model.getHeaderCellList().get(colNum - 1)).getMaxLength() * 260;
					else
						myColWidth = cell.getStringCellValue().length() * 260;
					//sheet.setColumnWidth((short) (colNum - 1), (short) (myColWidth + 300));

					
					sheet.autoSizeColumn(100);
					
				}
			}

			// get the correct iterator (full or partial list according to the
			// exportFull field)
			RowIterator rowIterator = this.model.getRowIterator(this.exportFull);
			// iterator on rows

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				HSSFRow xlsRow = sheet.createRow(rowNum++);
				colNum = 0;

				// iterator on columns
				ColumnIterator columnIterator = row.getColumnIterator(this.model.getHeaderCellList());

				while (columnIterator.hasNext()) {
					Column column = columnIterator.nextColumn();

					// Get the value to be displayed for the column
					Object value = column.getValue(this.decorated);

					HSSFCell cell = xlsRow.createCell((short) colNum++);

					if (value instanceof Number) {
						cell.setCellValue(((Number) value).doubleValue());
					} else if (value instanceof Date) {
						cell.setCellValue((Date) value);
					} else if (value instanceof Calendar) {
						cell.setCellValue((Calendar) value);
					} else {
						cell.setCellValue(StringUtils.trimToEmpty(ObjectUtils.toString(value)));
					}

				}
			}

			wb.write(out);

		} catch (Exception e) {
			throw new ExcelGenerationException(e);
		}
	}

	/**
	 * Wraps IText-generated exceptions.
	 * 
	 * @author Fabrizio Giustina
	 * @version $Revision: 3 $ ($Author: Fgiust $)
	 */
	static class ExcelGenerationException extends BaseNestableJspTagException {

		/**
		 * D1597A17A6.
		 */
		private static final long serialVersionUID = 899149338534L;

		/**
		 * Instantiate a new PdfGenerationException with a fixed message and the
		 * given cause.
		 * 
		 * @param cause
		 *            Previous exception
		 */
		public ExcelGenerationException(Throwable cause) {
			super(ExcelHssfView.class, Messages.getString("PdfView.errorexporting"), cause); //$NON-NLS-1$
		}

		/**
		 * @see org.displaytag.exception.BaseNestableJspTagException#getSeverity()
		 */
		public SeverityEnum getSeverity() {
			return SeverityEnum.ERROR;
		}
	}
}
