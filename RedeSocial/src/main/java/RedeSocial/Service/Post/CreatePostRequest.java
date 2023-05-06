package RedeSocial.Service.Post;

import lombok.Data;

import java.util.List;
import java.util.UUID;

import RedeSocial.Entities.Comment;

@Data
public class CreatePostRequest {
    private UUID id;
    private String userId;
    private String content;
    private List<String> likes;
    private List<Comment> comments;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}