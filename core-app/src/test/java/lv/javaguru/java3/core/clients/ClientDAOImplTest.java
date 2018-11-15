package lv.javaguru.java3.core.clients;

import lv.javaguru.java3.core.CoreApplication;
import lv.javaguru.java3.core.database.ClientRepository;
import lv.javaguru.java3.core.domain.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.java3.core.domain.builders.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class ClientDAOImplTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional
    public void testCreateClient() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        assertThat(client.getId(), is(nullValue()));
        client = clientRepository.save(client);
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        client = clientRepository.save(client);
        Client clientFromDb = clientRepository.findOne(client.getId());
        assertThat(clientFromDb, is(notNullValue()));
    }

}