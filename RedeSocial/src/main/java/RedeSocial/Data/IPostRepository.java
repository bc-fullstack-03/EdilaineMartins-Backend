package RedeSocial.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import RedeSocial.Entities.Post;

public interface IPostRepository extends MongoRepository<Post, String> {
}