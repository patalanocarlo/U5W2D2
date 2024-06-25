package CarloPatalano.U5W2D2.Service;

import CarloPatalano.U5W2D2.Entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();
    private long nextId = 1;

    //Metodi Per il Controller:
    public List<BlogPost> findAll() {
        return blogPosts;
    }

    public Optional<BlogPost> findById(Long id) {
        return blogPosts.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
    public BlogPost save(BlogPost blogPost) {
        if (blogPost.getId() == null) {
            blogPost.setId(nextId++);
        }
        blogPosts.add(blogPost);
        return blogPost;
    }
    public boolean deleteById(Long id) {
        return blogPosts.removeIf(blogPost -> blogPost.getId().equals(id));
    }
    public Optional<BlogPost> update(Long id, BlogPost updatedBlogPost) {
        return findById(id).map(blogPost -> {
            blogPost.setCategoria(updatedBlogPost.getCategoria());
            blogPost.setTitolo(updatedBlogPost.getTitolo());
            blogPost.setCover(updatedBlogPost.getCover());
            blogPost.setContenuto(updatedBlogPost.getContenuto());
            blogPost.setTempoDiLettura(updatedBlogPost.getTempoDiLettura());
            blogPost.setAuthorId(updatedBlogPost.getAuthorId());
            return blogPost;
        });
    }
}
