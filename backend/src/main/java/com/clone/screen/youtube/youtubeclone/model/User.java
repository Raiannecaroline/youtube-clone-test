package com.clone.screen.youtube.youtubeclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private Set<String> inscricao;
    private Set<String> inscritos;
    private List<String> historicoVideo;
    private Set<String> videosCurtidos;
    private Set<String> videosNaoCurtidos;
}
