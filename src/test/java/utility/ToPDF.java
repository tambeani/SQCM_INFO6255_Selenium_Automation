package utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

public class ToPDF {

	public static void saveToPdf(String htmlText, String fileName) throws IOException {

		// Create a PDF document
		PdfDocument pdf = new PdfDocument(new PdfWriter(fileName + ".pdf"));

		// Create an output stream to write the PDF content
		FileOutputStream outputStream = new FileOutputStream(fileName + ".pdf");

		// Convert the HTML string to PDF using iText
		HtmlConverter.convertToPdf(htmlText, outputStream);

		// Close the output stream
		outputStream.close();

		// Close the PDF document
		pdf.close();

		System.out.println("PDF file created successfully!");
	}
}
