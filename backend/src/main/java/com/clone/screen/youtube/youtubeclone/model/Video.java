package com.clone.screen.youtube.youtubeclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value = "Video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    private String id;
    private String titulo;
    private String descricao;
    private String userId;
    private Integer gostei;
    private Integer naoGostei;
    private Set<String> hashTags;
    private String videoUrl;
    private VideoStatus videoStatus;
    private Integer vizualizacoes;
    private String thumbnailUrl;
    private List<Comment> commentsList;
}
