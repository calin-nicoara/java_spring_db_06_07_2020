package ro.esolacad.javaspring.async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncComponentUserTest {

    @Autowired
    private AsyncComponentUser asyncComponentUser;

    @Test
    public void testAsync() throws InterruptedException {
        asyncComponentUser.test();
        Thread.sleep(200);
    }
}
