package online.library.book.service;

import online.library.author.controller.AuthorController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "author-api", path = "/author")
public interface AuthorMicroservice extends AuthorController {}
