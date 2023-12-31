package com.myblog1.payload;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PostDto {

    private Long id;


    private String title;


    private String description;


    private String content;
}
