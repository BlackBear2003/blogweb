package com.wzl.service;

import com.wzl.entity.Post;
import com.wzl.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface PostService {
    /**
     * 通过id查询帖子
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Post getPostById(int id)throws SQLException;

    /**
     *通过标题模糊搜索得到帖子集
     *
     * @param  title
     * @return
     * @throws SQLException
     */
    List<Post> getPostsByTitle(String title) throws SQLException;

    /**
     *通过标题模糊搜索得到帖子集
     *
     * @param  img
     * @return
     * @throws SQLException
     */
    List<Post> getPostsByImg(String img) throws SQLException;

    /**
     * 新增帖子
     *
     * @param title
     * @param img
     * @param text
     * @return
     * @throws SQLException
     */
    int addPost(String title,String img,String text) throws SQLException;

    /**
     * 根据编号删除帖子
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int deletePost(int id) throws SQLException;

    /**
     * 通过类型查询帖子
     *
     * @param c_id
     * @return
     * @throws SQLException
     */
    List<Post> getPostByCategory(int c_id) throws SQLException;

    /**
     * 为帖子分类
     *
     * @param c_id p_id
     * @return
     */
    int setCategory(int c_id,int p_id);

    /**
     * 为帖子设置发布人
     *
     * @param u_id p_id
     * @return
     */
    int setAuthor(int u_id,int p_id);


    /**
     * 根据用户id查询
     *
     * @param u_id
     * @return
     */
    List<Post> getPostByUser(int u_id);


}
