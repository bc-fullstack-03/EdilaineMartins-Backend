package RedeSocial.Data;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import RedeSocial.Entities.User;
import java.util.Optional;



public interface IUserRepository extends MongoRepository<User, UUID> {
   Optional<User> findUserByEmail(String email);
   boolean existsUserByEmail(String email);

}