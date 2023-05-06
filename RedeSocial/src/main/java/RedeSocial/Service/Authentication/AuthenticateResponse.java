package RedeSocial.Service.Authentication;

import lombok.Data;
import lombok.Setter;

import java.util.UUID;
@Setter
@Data
public class AuthenticateResponse {
    private UUID id;
    private String token;
    
	public void setToken(String token) {
			
	}

	public void setId(UUID id) {
		this.id = id;
	}

	

	
}