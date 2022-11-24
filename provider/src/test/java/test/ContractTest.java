package test;

import de.kattendick.provider.ProviderApplication;
import de.kattendick.provider.controller.CustomerController;
import de.kattendick.provider.service.CustomerService;
import de.kattendick.provider.service.TestData;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = ProviderApplication.class)
public class ContractTest {

    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(customerController);
        Mockito.when(customerService.getListOfAllCustomers()).thenReturn(TestData.getTestData());
    }
}

