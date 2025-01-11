package id.co.maybank;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.metadata.Metadata;
import org.springframework.util.Assert;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The type Content analysis test.
 */
@Slf4j
class ContentAnalysisTest {
    /**
     * When get content type then not match.
     */
    @Test
    void whenGetContentType_thenNotMatch() {
        String pathFile = "./src/test/resources/test_file6.png";
        try {
            String contentType = getContentType(pathFile, printFileNameAndExtension(pathFile));
             log.info("Content type: " + contentType);
            Assert.notNull(contentType, "not null");
            Assert.isTrue(!contentType.contains("image/png"), "Content type is NOT image/png");

        }catch (Exception e) {
            Fail.fail(e.getMessage());
            log.error(e.toString(), e);
        }
    }

    /**
     * When get content type then match.
     */
    @Test
    void whenGetContentType_thenMatch() {
        String pathFile = "./src/test/resources/test_file3.png";
        try {
            String contentType = getContentType(pathFile, printFileNameAndExtension(pathFile));
            log.info("Content type: " + contentType);
            Assert.notNull(contentType, "not null");
            Assert.isTrue(contentType.contains("image/png"), "Content type is image/png");

        }catch (Exception e) {
            Fail.fail(e.getMessage());
            log.error(e.toString(), e);
        }
    }

    private static String printFileNameAndExtension(String filePath) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        log.info("File Name: " + fileName);

        return fileName;
    }
    private static String getContentType(String pathFile, String filenameWithExtension) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(pathFile));

        TikaConfig config = TikaConfig.getDefaultConfig();
        Detector detector = config.getDetector();
        TikaInputStream stream = TikaInputStream.get(new ByteArrayInputStream(fileBytes));
        Metadata metadata = new Metadata();
        metadata.add(TikaCoreProperties.RESOURCE_NAME_KEY, filenameWithExtension);
        return detector.detect(stream, metadata).toString();
    }
}
