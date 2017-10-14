package freeLancers.online.service.impl.blog;

import freeLancers.online.entities.blog.Post;
import freeLancers.online.repository.irepository.blog.PostRepository;
import freeLancers.online.service.impl.AbstractServiceImpl;
import freeLancers.online.service.iservice.blog.PostService;
import freeLancers.online.service.iservice.order.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class PostServiceImpl extends AbstractServiceImpl<Post> implements PostService {

    private PostRepository postRepository;
    private FileService fileService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, FileService fileService) {
        super(postRepository);
        this.postRepository = postRepository;
        this.fileService = fileService;
    }

    /**
     * Upload post picture to amazon S3
     *
     * @param picture - picture as String
     * @param postUrl - post's url
     * @return picture's S3 ulr
     */
    @Override
    public String uploadPicture(String picture, String postUrl) {
        if (picture.substring(0, 10).equals("data:image")) {
            String base64Image = picture.split(",")[1];
            byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
            BufferedImage img;
            try {
                img = ImageIO.read(new ByteArrayInputStream(imageBytes));
                File file = new File(postUrl + "." + picture.split(";")[0].split("/")[1]);
                ImageIO.write(img, picture.split(";")[0].split("/")[1], file);
                fileService.toTiny(file.getName());
                return fileService.uploadOrderFile(file, "posts/" + postUrl + "/picture");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * Find posts page by domain
     *
     * @param domain   - search domain
     * @param pageable - page @see {@link Pageable}
     * @return posts page
     */
    @Override
    public Page<Post> findAllByDomain(String domain, Pageable pageable) {
        return postRepository.findAllByDomain(domain, pageable);
    }

    /**
     * Find posts page by domain and category
     *
     * @param category - search category
     * @param domain   - search domain name
     * @param pageable - page @see {@link Pageable}
     * @return posts page
     */
    @Override
    public Page<Post> findAllByDomainAndCategory(String category, String domain, Pageable pageable) {
        return postRepository.findAllByDomainAndCategory(category, domain, pageable);
    }

    /**
     * Find post by it's url, category and domain
     *
     * @param url      - search url
     * @param category - search category
     * @param domain   - search domain name
     * @return found post
     */
    @Override
    public Post findByUrlAndCategoryAndDomain(String url, String category, String domain) {
        return postRepository.findByUrlAndCategoryAndDomain(url, category, domain);
    }

}
