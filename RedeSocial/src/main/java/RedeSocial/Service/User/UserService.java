package RedeSocial.Service.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import RedeSocial.Data.IUserRepository;
import RedeSocial.Entities.User;
import RedeSocial.Validation.UserValidator;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;

    @Async
    public String createUser(CreateUserRequest request){

        var user = new User(request.name, request.email, request.password);

        if(_userRepository.existsUserByEmail(request.email)){
            throw new IllegalArgumentException("Já existe um usuário cadastrado com este e-mail.");
        }

        if(!UserValidator.nameIsValid(request.name)){
            throw new IllegalArgumentException("Favor preencher os campos corretamente.");
        }
        if(!UserValidator.passwordIsValid(request.password)){
            throw new IllegalArgumentException("A Senha precisar ter mais de 8 caracteres.");
        }
        if(!UserValidator.emailIsValid(request.email)){
            throw new IllegalArgumentException("favor preencher o campo email");
        }


        _userRepository.save(user);

        return user.getId().toString();
    }

    public UserResponse findUserByEmail(String email){
        var user = _userRepository.findUserByEmail(email).get();

        var response = new UserResponse(user.getId(), user.getName(), user.getEmail());

        return response;
    }

    public User getUser(String email) {
        return _userRepository.findUserByEmail(email).get();
    }

}