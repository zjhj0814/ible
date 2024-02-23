package Member.Email;

import domain.Member.Email.EmailConfig;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@SpringBootTest
class YamlLoadFactoryTest {
    private static final Logger logger = LoggerFactory.getLogger(YamlLoadFactoryTest.class);
    private final EmailConfig emailConfig;

    @GetMapping("/email_validation_test")
    public ResponseEntity<String> testEmailValidation(){
        logger.info("[EmailConfig]: "+emailConfig);
        return new ResponseEntity<>("EmailConfig",HttpStaxtus.OK);
    }
}