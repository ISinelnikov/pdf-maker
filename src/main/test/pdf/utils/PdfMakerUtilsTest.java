package pdf.utils;

import pdf.generator.FileGenerationException;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfMakerUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(PdfMakerUtilsTest.class);

    @Test
    public void generatePDFFromHTML() {
        try {
            PdfMakerUtils.generatePdfFromHtml("<h1>Hello world</h1>", "test");
        } catch (FileGenerationException | IOException ex) {
            logger.error("Execute test with exception.", ex);
        }
    }
}