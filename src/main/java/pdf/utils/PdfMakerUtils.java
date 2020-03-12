package pdf.utils;

import pdf.generator.FileGenerationException;
import pdf.generator.TextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.DocumentException;

public final class PdfMakerUtils {
    private static final Logger logger = LoggerFactory.getLogger(PdfMakerUtils.class);

    private static final String PDF_SUFFIX = ".pdf";

    private PdfMakerUtils() {
    }

    /**
     * This method generates a pdf byte array for the string template.
     *
     * @param template (plane html)
     *
     * @return pdf blob
     */
    private static byte[] generatePdfFromHtml(String template) throws FileGenerationException, IOException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            HtmlCleaner cleaner = new HtmlCleaner();
            CleanerProperties props = cleaner.getProperties();
            props.setCharset(StandardCharsets.UTF_8.displayName());
            TagNode node = cleaner.clean(template);
            (new PrettyXmlSerializer(props)).writeToStream(node, out);
            ITextRenderer renderer = new TextRenderer();
            renderer.setDocumentFromString(new String(out.toByteArray(), StandardCharsets.UTF_8));
            renderer.layout();
            renderer.createPDF(output);
            out.flush();
            out.close();
            return output.toByteArray();
        } catch (DocumentException ex) {
            logger.error("Invoke generatePDFFromHTML(...) with exception.", ex);
            throw new FileGenerationException("Invoke generatePDFFromHTML() exception");
        }
    }

    public static File generatePdfFromHtml(String template, String pathToFile) throws FileGenerationException, IOException {
        File generatedFile = new File(pathToFile + PDF_SUFFIX);
        FileUtils.writeByteArrayToFile(generatedFile, generatePdfFromHtml(template));
        return generatedFile;
    }
}
