package com.devchw.fitlogix.member;

import com.devchw.fitlogix.memberexercise.MemberExercise;
import com.devchw.fitlogix.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String name;

    private String email;

    private String userId;

    private String password;

    @Enumerated(EnumType.STRING)
    private MemberType type; // USER, ADMIN

    @OneToMany(mappedBy = "member")
    private List<MemberExercise> memberExercise = new ArrayList<>();

}
