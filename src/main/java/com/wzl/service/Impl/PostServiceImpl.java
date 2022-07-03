package com.wzl.service.Impl;

import com.wzl.entity.Post;
import com.wzl.mapper.PostMapper;
import com.wzl.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;

    @Override
    public Post getPostById(int id) throws SQLException {
        return postMapper.getPostById(id);
    }

    @Override
    public List<Post> getPostsByTitle(String title) throws SQLException {
        return postMapper.getPostsByTitle(title);
    }

    @Override
    public List<Post> getPostsByImg(String img) throws SQLException {
        return postMapper.getPostsByImg(img);
    }

    @Override
    public int addPost(String title, String img, String text) throws SQLException {
        Post post = new Post(0,title,img,text);

        return postMapper.addPost(post);
    }

    @Override
    public int deletePost(int id) throws SQLException {
        return postMapper.deletePost(id);
    }

    @Override
    public List<Post> getPostByCategory(int c_id) throws SQLException {
        return postMapper.getPostByCategory(c_id);
    }

    @Override
    public int setCategory(int c_id, int p_id) {
        return postMapper.setCategory(c_id, p_id);
    }

    @Override
    public int setAuthor(int u_id, int p_id) {

        return postMapper.setAuthor(u_id, p_id);
    }

    @Override
    public List<Post> getPostByUser(int u_id) {
        return postMapper.getPostByUser(u_id);
    }
}
