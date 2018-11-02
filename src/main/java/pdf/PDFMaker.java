package pdf;

import org.apache.log4j.Logger;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.xhtmlrenderer.pdf.ITextRenderer;
import pdf.generator.FileGenerationException;
import pdf.generator.TextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PDFMaker {
    private static final Logger logger = Logger.getLogger(PDFMaker.class);
    private static final String CHARSET = "UTF-8";

    /**
     * This method generates a pdf byte array for the string template
     *
     * @param template is plane html
     * @return
     */
    public static byte[] generatePDFFromHTML(String template) throws FileGenerationException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            HtmlCleaner cleaner = new HtmlCleaner();
            CleanerProperties props = cleaner.getProperties();
            props.setCharset(CHARSET);
            TagNode node = cleaner.clean(template);
            (new PrettyXmlSerializer(props)).writeToStream(node, out);
            ITextRenderer renderer = new TextRenderer();
            renderer.setDocumentFromString(new String(out.toByteArray(), StandardCharsets.UTF_8));
            renderer.layout();
            renderer.createPDF(output);
            out.flush();
            out.close();
            return output.toByteArray();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new FileGenerationException("Invoke generatePDFFromHTML() exception");
        }
    }

    /**
     * This method writes a pdf byte array to the output stream
     *
     * @param template is plane html
     * @param outputStream
     */
    public static void generatePDFFromHTML(String template, OutputStream outputStream) throws FileGenerationException, IOException {
        byte file[] = generatePDFFromHTML(template);
        outputStream.write(file);
        outputStream.flush();
        outputStream.close();
    }
}
