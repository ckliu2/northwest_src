package pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.base.util.MyProperties;

import java.io.*;

public class PDFMerge extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String date = req.getParameter("date");
			ServletContext servletContext = getServletContext();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
			String filePath = myProperties.getPdfMergePath() + date;

			String target = filePath + ".pdf";

			File f = new File(filePath);

			String[] paths = f.list();
			String[] files = new String[paths.length];

			for (int i = 0; i < paths.length; i++) {
					files[i] = filePath + "//" + paths[i];
					System.out.println("filePath=" + files[i]);
			}

			mergePdfFiles(files, target);

			System.out.println("PDFMerge doGet date=" + date + "---" + filePath);
		} catch (Exception e) {
			System.out.println("PDFMerge doGet error=" + e.toString());
		}
	}

	public static boolean mergePdfFiles(String[] files, String newfile) {
		boolean retValue = false;
		Document document = null;
		try {
			document = new Document(new PdfReader(files[0]).getPageSize(1));
			PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
			document.open();
			for (int i = 0; i < files.length; i++) {
				PdfReader reader = new PdfReader(files[i]);
				int n = reader.getNumberOfPages();
				for (int j = 1; j <= n; j++) {
					document.newPage();
					PdfImportedPage page = copy.getImportedPage(reader, j);
					copy.addPage(page);
				}
			}
			retValue = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return retValue;
	}

}
