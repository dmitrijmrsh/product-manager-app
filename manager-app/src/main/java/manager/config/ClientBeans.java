package manager.config;

import manager.client.ProductsRestClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public ProductsRestClientImpl productsRestClient(
            @Value("${shop.services.catalogue.uri:http://localhost:8081}") String catalogueBaseUri,
            @Value("${shop.services.catalogue.username:}") String catalogueUserName,
            @Value("${shop.services.catalogue.password:}") String cataloguePassword
    ) {
        return new ProductsRestClientImpl(RestClient.builder()
                .baseUrl(catalogueBaseUri)
                .requestInterceptor(
                        new BasicAuthenticationInterceptor(catalogueUserName, cataloguePassword))
                .build());
    }
}
