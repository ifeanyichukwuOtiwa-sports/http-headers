package dev.regent.httpheaders.service;


import dev.regent.httpheaders.model.Post;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * <a href="www.jsonplaceholder.typicode.com">JSON Place Holder</a>
 */
public interface JsonPlaceHolderService {
    @GetExchange("/posts")
    List<Post> findAll();
}
