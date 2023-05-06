package RedeSocial.Validation;

public class UserValidator {
    public static boolean nameIsValid(String name){
        return name != null && !name.trim().isEmpty();
    }
    public static boolean passwordIsValid(String password) {
        return password.length() >= 6 || password != null && !password.trim().isEmpty();
    }

    public static boolean emailIsValid(String email) {
        return email != null && !email.trim().isEmpty();
    }
}