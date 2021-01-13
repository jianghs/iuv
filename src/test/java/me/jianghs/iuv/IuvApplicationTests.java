package me.jianghs.iuv;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class IuvApplicationTests {

    Logger logger = LoggerFactory.getLogger(IuvApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void testBCrypt() {
        String password = BCrypt.hashpw("111", BCrypt.gensalt());
        logger.info("密码：{}", password);
    }

}
