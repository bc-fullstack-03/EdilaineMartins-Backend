package RedeSocial.Api.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import RedeSocial.Service.User.CreateUserRequest;
import RedeSocial.Service.User.IUserService;
import RedeSocial.Service.User.UserResponse;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private IUserService _userService;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request){

        var response = _userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(String email){
        return ResponseEntity.ok().body(_userService.findUserByEmail(email));
    }
}