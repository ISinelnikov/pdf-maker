package pdf;

import pdf.generator.FileGenerationException;

import java.io.OutputStream;

public class PDFMaker {
    private final static String CHARSET = "UTF-8";

    /**
     * Генерирует pdf для переданного template
     * @param template
     * @return
     */
    public static byte[] generatePDFFromHTML(String template) throws FileGenerationException {
        return null;
    }

    /**
     * Записывает сгенерированный pdf в outputStream
     *
     * @param template     данные
     * @param outputStream выходной поток
     */
    public static void generatePDFFromHTML(String template, OutputStream outputStream) throws FileGenerationException {
        byte file[] = generatePDFFromHTML(template);

    }
}
