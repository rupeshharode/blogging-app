package com.blog.blogging.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.blog.blogging.model.post;
import com.blog.blogging.repository.postRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class postController {
@Autowired
private postRepository postRepo;

@GetMapping("/")
public String viewHomePage(Model model) {
    model.addAttribute("listPosts", postRepo.findAll());
    return "index";

}
@GetMapping("/new")
public String showNewPostForm(Model model) {
    return "new_post";
}
@PostMapping("/save")
public String savePost(@RequestParam("title") String title,
                       @RequestParam("content") String content,
                       @RequestParam("author") String author) {
    post newPost = new post();
    newPost.setTitle(title);
    newPost.setContent(content);
    newPost.setAuthor(author);
    postRepo.save(newPost);
    return "redirect:/";

   }
   @GetMapping("/edit")
   public String showEditPostForm(@RequestParam("id") int id, Model model) {
    post existingPost = postRepo.findById(id).orElse(null);
    if (existingPost != null) {
        model.addAttribute("post", existingPost);
        return "edit_post";
    }
    return "redirect:/";
   }
   @PostMapping("/update")
   public String updatePost(@RequestParam("id") int id,
                            @RequestParam("title") String title,
                            @RequestParam("content") String content,
                            @RequestParam("author") String author) {
    post existingPost = postRepo.findById(id).orElse(null);
    if (existingPost != null) {
        existingPost.setTitle(title);
        existingPost.setContent(content);
        existingPost.setAuthor(author);
        postRepo.save(existingPost);
        return "redirect:/";
    }
    return "redirect:/";
   }
 @GetMapping("/delete")
    public String deletePost(@RequestParam("id") int id) {
        post existingPost = postRepo.findById(id).orElse(null);
        if (existingPost != null) {
            postRepo.deleteById(id);
            return "redirect:/";
        }
        return "redirect:/";
    }

}
