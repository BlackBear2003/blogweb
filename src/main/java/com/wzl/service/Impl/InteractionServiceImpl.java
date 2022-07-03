package com.wzl.service.Impl;

import com.wzl.entity.Comment;
import com.wzl.entity.Post;
import com.wzl.mapper.InteractionMapper;
import com.wzl.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InteractionServiceImpl implements InteractionService {
    @Autowired
    InteractionMapper interactionMapper;

    @Override
    public int getThumbByPostId(int id) {
        return interactionMapper.getThumbByPostId(id);
    }

    @Override
    public List<Post> getPostsByUserThumb(int id) {
        return interactionMapper.getPostsByUserThumb(id);
    }

    @Override
    public int doThumb(int u_id, int p_id) {
        return interactionMapper.doThumb(u_id, p_id);
    }

    @Override
    public int removeThumb(int u_id, int p_id) {
        return interactionMapper.removeThumb(u_id, p_id);
    }

    @Override
    public int addComment(int u_id, int p_id, String text) {
        Comment comment = new Comment(0,p_id,u_id,text);
        int val=interactionMapper.addComment(comment);
        return comment.getId();
    }

    @Override
    public int deleteComment(int id) {
        return interactionMapper.deleteComment(id);
    }

    @Override
    public List<Comment> getCommentByPostId(int p_id) {
        return interactionMapper.getCommentByPostId(p_id);
    }

    @Override
    public int getUserIdByPostId(int p_id) {
        return interactionMapper.getUserIdByPostId(p_id);
    }
}
