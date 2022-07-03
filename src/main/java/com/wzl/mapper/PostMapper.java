package com.wzl.mapper;

import com.wzl.entity.Post;
import com.wzl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PostMapper {

    /**
     * 根据帖子id查询
     *
     * @param id
     * @return
     */
    Post getPostById(int id);

    /**
     * 根据帖子名模糊查询帖子
     *
     * @param title
     * @return
     */
    List<Post> getPostsByTitle(String title);

    /**
     * 根据帖子名模糊查询帖子
     *
     * @param img
     * @return
     */
    List<Post> getPostsByImg(String img);

    /**
     * 添加帖子
     *
     * @param post
     */
    int addPost(Post post);

    /**
     * 删除帖子
     *
     * @param id
     */
    int deletePost(int id);

    /**
     * 根据帖子类型id查询
     *
     * @param c_id
     * @return
     */
    List<Post> getPostByCategory(int c_id);

    /**
     * 为帖子分类
     *
     * @param c_id,p_id
     * @return
     */
    int setCategory(@Param("c_id") int c_id, @Param("p_id")int p_id);


    /**
     * 根据用户id查询
     *
     * @param u_id
     * @return
     */
    List<Post> getPostByUser(int u_id);

    /**
     * 为帖子设置发布人
     *
     * @param u_id,p_id
     * @return
     */
    int setAuthor(@Param("u_id")int u_id,@Param("p_id")int p_id);

}
