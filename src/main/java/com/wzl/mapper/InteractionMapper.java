package com.wzl.mapper;

import com.wzl.entity.Comment;
import com.wzl.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InteractionMapper {
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
     * @param u_id
     * @param p_id
     * @return
     */
    public int doThumb(@Param("u_id") int u_id, @Param("p_id")int p_id);

    /**
     * 撤销给帖子点赞
     *
     * @param u_id,p_id
     * @return
     */
    public int removeThumb(@Param("u_id") int u_id, @Param("p_id")int p_id);

    /**
     * 给帖子评论
     *
     * @param comment
     * @return
     */
    public int addComment(Comment comment);

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
