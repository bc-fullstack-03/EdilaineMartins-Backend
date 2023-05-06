package RedeSocial.Service.User;

import RedeSocial.Entities.User;

public interface IUserService {
    String createUser(CreateUserRequest request);
    UserResponse findUserByEmail(String email);
    User getUser(String email);
}