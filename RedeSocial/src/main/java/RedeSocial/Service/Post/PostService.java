package RedeSocial.Service.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import RedeSocial.Data.IPostRepository;
import RedeSocial.Entities.Comment;
import RedeSocial.Entities.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostSevice {
    @Autowired
    private IPostRepository _postRepository;

    public PostService(IPostRepository postRepository) {
        this._postRepository = postRepository;
    }

    @Override
    public Post createPost(CreatePostRequest request) {
        Post post = new Post();
        post.setUserId(request.getUserId());
        return _postRepository.save(post);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> posts = _postRepository.findAll();
        List<PostResponse> responseList = new ArrayList<>();

        for (Post post : posts) {
            PostResponse response = new PostResponse();
            response.setId(post.getId().toString());
            response.setUserId(post.getUserId());
            response.setLikes(post.getLikes());
            response.setComments(post.getComments());
            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public PostResponse getPostById(String id) {
        Optional<Post> postOptional = _postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            PostResponse response = new PostResponse();
            response.setId(post.getId().toString());
            response.setUserId(post.getUserId());
            response.setLikes(post.getLikes());
            response.setComments(post.getComments());
            return response;
        } else {
            throw new IllegalArgumentException("Post not found with id: " + id);
        }
    }

    @Override
    public PostResponse addComment(String postId, Comment comment) {
        Optional<Post> postOptional = _postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            List<Comment> comments = post.getComments();
            comments.add(comment);
            post.setComments(comments);
            _postRepository.save(post);

            PostResponse response = new PostResponse();
            response.setId(post.getId().toString());
            response.setUserId(post.getUserId());
            response.setLikes(post.getLikes());
            response.setComments(post.getComments());
            return response;
        } else {
            throw new IllegalArgumentException("Post not found with id: " + postId);
        }
    }

    @Override
    public PostResponse addLike(String postId, String userId) {
        Optional<Post> postOptional = _postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            List<String> likes = post.getLikes();
            likes.add(userId);
            post.setLikes(likes);
            _postRepository.save(post);

            PostResponse response = new PostResponse();
            response.setId(post.getId().toString());
            response.setUserId(post.getUserId());
            response.setLikes(post.getLikes());
            response.setComments(post.getComments());
            return response;
        } else {
            throw new IllegalArgumentException("Post not found with id: " + postId);
        }
    }



}