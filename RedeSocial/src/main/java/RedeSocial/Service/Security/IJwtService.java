package RedeSocial.Service.Security;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId);
    
}