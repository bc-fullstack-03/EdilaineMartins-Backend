package RedeSocial.Validation;

import RedeSocial.Entities.User;

public class AuthenticateValidator {
    public static boolean UserIsValid(String user){
        return user != null;
    }

    public static boolean PasswordIsValid(User user,String password){
        return user.getPassword().equals(password);
    }
}