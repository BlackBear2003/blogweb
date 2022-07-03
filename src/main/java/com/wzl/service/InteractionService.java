package com.wzl.service;

import com.wzl.entity.Comment;
import com.wzl.entity.Post;

import java.util.List;

public interface InteractionService {

    /**
     * 根据帖子id查询点赞数量
     *
     * @param id
     * @return
     */
    public int getThumbByPostId(int id);

    /**
     * 根据用户id查询点赞过的帖子
     *
     * @param id
     * @return
     */
    public List<Post> getPostsByUserThumb(int id);

    /**
     * 给帖子点赞
     *
     * @param u_id,p_id
     * @return
     */
    public int doThumb(int u_id,int p_id);

    /**
     * 撤销给帖子点赞
     *
     * @param u_id,p_id
     * @return
     */
    public int removeThumb(int u_id,int p_id);

    /**
     * 给帖子评论
     *
     * @param u_id,p_id,text
     * @return
     */
    public int addComment(int u_id, int p_id, String text);

    /**
     * 根据评论id删除帖子评论
     *
     * @param id
     * @return
     */
    public int deleteComment(int id);

    /**
     * 获得帖子的所有评论
     *
     * @param p_id
     * @return
     */
    public List<Comment> getCommentByPostId(int p_id);

    /**
     * 获得帖子的作者
     *
     * @param p_id
     * @return
     */
    public int getUserIdByPostId(int p_id);

}
