package ro.esolacad.javaspring.jpa.embedded;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import ro.esolacad.javaspring.jpa.embedabble.Client;
import ro.esolacad.javaspring.jpa.embedabble.ClientAddress;
import ro.esolacad.javaspring.jpa.embedabble.ClientRepository;

@SpringBootTest
public class EmbeddedTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreate() {
        Client client = Client.builder()
                .name("Gigel")
                .credit(BigDecimal.TEN)
                .clientAddress(ClientAddress.builder()
                        .streetName("Iuliu Maniu")
                        .number("244")
                        .build())
                .build();

        clientRepository.save(client);
    }

    @Test
    public void testUpdate() {
        clientRepository.findById(7L)
                .ifPresent(client -> {
                    client.setCredit(BigDecimal.valueOf(320));
                    clientRepository.save(client);
                });
    }
}
