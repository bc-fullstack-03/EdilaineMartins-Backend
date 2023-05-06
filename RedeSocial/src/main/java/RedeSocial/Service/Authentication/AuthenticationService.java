package RedeSocial.Service.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import RedeSocial.Service.Security.IJwtService;
import RedeSocial.Service.User.IUserService;

@Service
public class AuthenticationService implements  IAuthenticationService {

    @Autowired
    private IUserService _userService;
    @Autowired
    private IJwtService _jwtService;



    public AuthenticateResponse authenticate(AuthenticateRequest request){
        var user = _userService.getUser(request.email);

        if (user == null) {
            return null;
        }

        if(!user.getPassword().equals(request.password)){
            return null;
        }

        var token = _jwtService.generateToken(user.getId());

        var response = new AuthenticateResponse();
        response.setId(user.getId());
        response.setToken(token);

        return response;
    }
}