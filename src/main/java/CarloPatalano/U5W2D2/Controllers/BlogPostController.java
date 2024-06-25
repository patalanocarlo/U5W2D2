package CarloPatalano.U5W2D2.Controllers;


import CarloPatalano.U5W2D2.Entities.BlogPost;
import CarloPatalano.U5W2D2.Service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

  @GetMapping
    public List<BlogPost> getAllBlogPosts() {
    return blogPostService.findAll();
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.save(blogPost);
    }
    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        return blogPostService.update(id, updatedBlogPost).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteById(id);
    }

}

