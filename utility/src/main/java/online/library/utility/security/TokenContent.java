package online.library.utility.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenContent {
    private UUID id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String userType;
}
