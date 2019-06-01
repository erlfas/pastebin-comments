package no.fasmer.pastebin.comments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CommentController {
    
    private final CommentRepository commentRepository;
    
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    @GetMapping("/comments/{pasteId}")
    public Flux<Comment> comments(@PathVariable String pasteId) {
        return commentRepository.findByPasteId(pasteId);
    }
    
}
