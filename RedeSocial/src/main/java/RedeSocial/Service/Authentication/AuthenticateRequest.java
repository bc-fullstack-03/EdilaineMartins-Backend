package RedeSocial.Service.Authentication;


import lombok.Data;
import lombok.Getter;

@Getter
@Data

public class AuthenticateRequest {
        public String email;
        public String password;

}