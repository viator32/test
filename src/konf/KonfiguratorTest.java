package konf;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class KonfiguratorTest {

    @Test
    void domaptest() throws IOException {
        Map<String, String> map = new HashMap<>();
        map= Konfigurator.domap(Konfigurator.listKongurationsdatei());

        assertTrue(map.get("mail.transport.protocol").equals("smtp"));
        assertTrue(map.get("password").equals("K[O8a}5#"));

    }
}