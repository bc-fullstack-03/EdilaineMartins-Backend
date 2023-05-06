package RedeSocial.Service.Authentication;

public interface IAuthenticationService {
    AuthenticateResponse authenticate(AuthenticateRequest request);
}