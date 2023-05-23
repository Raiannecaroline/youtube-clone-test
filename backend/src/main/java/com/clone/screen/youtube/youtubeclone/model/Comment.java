package com.clone.screen.youtube.youtubeclone.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    private String id;
    private String texto;
    private String IdAutor;
    private Integer naoCurtiuCount;
    private Integer curtiuCount;
}
