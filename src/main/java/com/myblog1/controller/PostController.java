package com.myblog1.controller;

import com.myblog1.payload.PostDto;
import com.myblog1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8080/api/post
    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){
        PostDto dto = postService.savePost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);//201
    }
    //http://localhost:8080/api/post/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted", HttpStatus.OK);
    }
    //http://localhost:8080/api/post/1
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") long id, @RequestBody PostDto postDto){
        PostDto dto = postService.updatePost(id, postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);


    }
    //http://localhost:8080/api/post/1
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostByid(@PathVariable("id")long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    //http://localhost:8080/api/post?pageNo=0&pageSize=5&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto> getPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false)String sortDir
    ){




    ){
       List<PostDto> postDtos =  postService.getPosts(pageNo, pageSize, sortBy);
       return postDtos;
    }
}
