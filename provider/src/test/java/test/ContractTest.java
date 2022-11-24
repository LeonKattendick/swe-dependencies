package test;

import de.kattendick.provider.ProviderApplication;
import de.kattendick.provider.controller.CustomerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProviderApplication.class)
public class ContractTest {

    @Autowired
    private CustomerController customerController;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(customerController);
    }
}

