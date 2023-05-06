package RedeSocial.Service.User;




import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserRequest {
    public String name;
    public String email;
    public String password;
    

}