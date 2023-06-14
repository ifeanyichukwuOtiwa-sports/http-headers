package dev.regent.httpheaders.config;

import dev.regent.httpheaders.service.JsonPlaceHolderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class JsonConfig {
    @Bean
    JsonPlaceHolderService jsonPlaceHolderService(@Qualifier("jsonHttpFactory") final HttpServiceProxyFactory factory) {
        return factory.createClient(JsonPlaceHolderService.class);
    }

    @Bean("jsonHttpFactory")
    public static HttpServiceProxyFactory jsonHttpFactory(@Qualifier("jsonWebClient") final WebClient client) {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
    }

    @Bean("jsonWebClient")
    public static WebClient jsonWebClient() {
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @Bean
    CommandLineRunner commandLineRunner(JsonPlaceHolderService client) {
        return args -> client.findAll().forEach(System.out::println);
    }

}