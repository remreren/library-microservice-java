package online.library.book.service;

import com.example.author.api.AuthorApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "localhost:9002", url = "http://localhost:9002/author")
public interface AuthorMicroservice extends AuthorApi {}
