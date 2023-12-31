
package com.myblog1.service;

import com.myblog1.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);

    void deletePost(long id);

    PostDto updatePost(long id, PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getPosts(int pageNo, int pageSize, String sortBy);
}
