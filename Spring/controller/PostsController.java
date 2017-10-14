package content.com.ua.controller.blog;

import content.com.ua.entities.blog.Post;
import content.com.ua.service.iservice.blog.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/blog/posts")
public class PostsController {

    private PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public Page<Post> getAllPostsByDomain(@PathVariable("page") int page, @PathVariable("size") int size,
                                          @RequestParam("d") String domain) {
        return postService.findAllByDomain(domain, new PageRequest(page, size));
    }

    @RequestMapping(value = "/{category}/{page}/{size}", method = RequestMethod.GET)
    public Page<Post> getAllPostsByDomainAndCategory(@PathVariable("category") String category,
                                                     @PathVariable("page") int page, @PathVariable("size") int size,
                                                     @RequestParam("d") String domain) {
        return postService.findAllByDomainAndCategory(category, domain, new PageRequest(page, size));
    }

    @RequestMapping(value = "/{category}/{post}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("category") String category, @PathVariable("post") String post,
                        @RequestParam("d") String domain) {
        return postService.findByUrlAndCategoryAndDomain(post, category, domain);
    }
}
