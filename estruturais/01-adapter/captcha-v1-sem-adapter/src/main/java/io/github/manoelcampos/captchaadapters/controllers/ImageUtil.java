package io.github.manoelcampos.captchaadapters.controllers;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Manoel Campos
 */
public final class ImageUtil {
    /**
     * Construtor padrão para impedir a instanciação da classe utilitária.
     */
    private ImageUtil() {/**/}

    /**
     * Obtém um objeto {@link BufferedImage}, contendo uma imagem, para um array de bytes.
     * Isto permite a um endpoints retornar a imagem gerada em memória.
     * @param image imagem pra obter um array de bytes
     * @return array de bytes da imagem
     */
    public static byte[] bufferedImageToByteArray(final BufferedImage image) {
        final var baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baos.toByteArray();
    }
}
