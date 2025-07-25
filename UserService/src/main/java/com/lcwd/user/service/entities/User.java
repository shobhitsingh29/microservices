package com.lcwd.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="micro_user")
public class User {
    @Id
    @Column(name="ID", nullable = false, unique = true)
    private String userId;
    @Column(name = "NAME",length = 20)
    private String name;
    @Column(name="EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name="ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
