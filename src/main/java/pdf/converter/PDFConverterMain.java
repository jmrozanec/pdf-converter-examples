package pdf.converter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class PDFConverterMain {
    public static void main(String[] args) throws IOException, URISyntaxException {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("little-prince.pdf");
        //System.out.println(inputUrl.toURI().toString());
        File input = File.createTempFile("little-prince", "pdf");
        File output = File.createTempFile("little-prince", "epub");
        IOUtils.copy(stream, new FileOutputStream(input));

        PdfConverter.convert(input).intoEpub("The Little Prince", output);
        System.out.println(output.getAbsolutePath());
    }
}
