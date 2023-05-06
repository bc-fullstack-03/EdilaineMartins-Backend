package RedeSocial.Api.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RedeSocial.Service.Authentication.AuthenticateRequest;
import RedeSocial.Service.Authentication.AuthenticateResponse;
import RedeSocial.Service.Authentication.IAuthenticationService;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {
 @Autowired

 private IAuthenticationService _authenticationService;

 @PostMapping()
        public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request) {
           return ResponseEntity.ok().body(_authenticationService.authenticate(request));
        }

        //reset password
}