package online.library.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "The page you called for cannot response you right now. \n Please try again later.";
    }
}

