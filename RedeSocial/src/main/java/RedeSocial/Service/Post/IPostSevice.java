package RedeSocial.Service.Post;


import java.util.List;

import RedeSocial.Entities.Comment;
import RedeSocial.Entities.Post;

public interface IPostSevice {

    Post createPost(CreatePostRequest request);
    List<PostResponse> getAllPosts();
    PostResponse getPostById(String id);
    PostResponse addComment(String postId, Comment comment);
    PostResponse addLike(String postId, String userId);
}