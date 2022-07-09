package com.wzl.controller;

import com.wzl.entity.Comment;
import com.wzl.entity.Post;
import com.wzl.service.Impl.InteractionServiceImpl;
import com.wzl.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    InteractionServiceImpl interactionService;

    @GetMapping(value = "")
    public Post getPostById(int p_id) throws SQLException {
        return postService.getPostById(p_id);
    }

    @PostMapping(value = "")
    public int doPost(String title,String img,String text) throws SQLException {
        int returnID=0;
        if(postService.addPost(title, img, text)==1){
            returnID= postService.getPostsByImg(img).get(0).getId();
        }
        return returnID;
    }

    @GetMapping(value = "/getByUser")
    public List<Post> getPostByUser(int u_id){
        return postService.getPostByUser(u_id);
    }

    @PostMapping(value = "/setAuthor")
    public String setPostAuthor(int u_id,int p_id){
        if(postService.setAuthor(u_id, p_id)==1){
            return "success";
        }
        return "failed";
    }

    @GetMapping(value = "/getByCategory")
    public List<Post> getPostByCategoryId(int c_id) throws SQLException {
        return postService.getPostByCategory(c_id);
    }

    @GetMapping(value = "/delete")
    public String deletePostById(int p_id) throws SQLException {
        postService.deletePost(p_id);
        return "success";

    }

    @GetMapping(value = "/search")
    public List<Post> getPostByTitle(String title) throws SQLException {
        return postService.getPostsByTitle(title);
    }

    @PostMapping(value = "/thumb")
    public String doThumb(int u_id,int p_id){
        interactionService.doThumb(u_id,p_id);
        return "success";

    }

    @GetMapping(value = "/thumb")
    public int getThumbNumByPostId(int id){
        int num = interactionService.getThumbByPostId(id);
        return num;
    }

    //查点过赞的posts
    @GetMapping(value = "/userThumbs")
    public List<Post> getPostByUserThumbs(int u_id){
        List<Post> posts = interactionService.getPostsByUserThumb(u_id);
        return posts;
    }

    @PostMapping(value = "/delthumb")
    public String delThumb(int u_id,int p_id){
        interactionService.removeThumb(u_id,p_id);
        return "success";

    }

    @GetMapping(value = "/comment")
    public List<Comment> getCommentByPostId(int p_id){
        return interactionService.getCommentByPostId(p_id);
    }

    @PostMapping(value = "/comment")
    public String doComment(int u_id, int p_id, String text){
        interactionService.addComment(u_id, p_id, text);
        return "success";

    }

    @PostMapping(value = "/delcomment")
    public String  delCommentById(int id){
        interactionService.deleteComment(id);
        return "success";

    }

    @PostMapping(value = "/setCategory")
    public String setPostToCategory(int c_id,int p_id){
        postService.setCategory(c_id, p_id);
        return "success";
    }

    @GetMapping(value = "/getPoster")
    public int getPosterByPostId(int p_id){
        return interactionService.getUserIdByPostId(p_id);
    }


}
