package online.library.book.service;

import online.library.author.api.AuthorApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "author-api", path = "/author")
public interface AuthorMicroservice extends AuthorApi {}
