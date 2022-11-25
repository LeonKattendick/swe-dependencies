package test;

import de.kattendick.ct.ConsumerTwoApplication;
import de.kattendick.ct.model.CustomerEntity;
import de.kattendick.ct.model.ProductEntity;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = ConsumerTwoApplication.class)
@AutoConfigureStubRunner(
        ids = "de.kattendick:provider:0.0.1-SNAPSHOT:stubs:8100",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class ContractTest {

    @Test
    public void confirmCustomerList() {
        // given:
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_OCTET_STREAM));

        RestTemplate restTemplate = new RestTemplateBuilder()
                .defaultHeader("Content-Type", "application/json")
                .messageConverters(converter)
                .build();

        // when:
        CustomerEntity[] customer = restTemplate.getForEntity("http://localhost:8100/all",
               CustomerEntity[].class).getBody();

        // then:
        for (CustomerEntity customerEntity : customer) {
            BDDAssertions.then(customerEntity).hasFieldOrProperty("name");
            BDDAssertions.then(customerEntity).hasFieldOrProperty("productEntities");

            for (ProductEntity productEntity : customerEntity.getProductEntities()) {
                BDDAssertions.then(productEntity).hasFieldOrProperty("balance");
            }
        }
    }
}
