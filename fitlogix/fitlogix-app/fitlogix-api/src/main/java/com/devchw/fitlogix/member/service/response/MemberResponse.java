package com.devchw.fitlogix.member.service.response;

import com.devchw.fitlogix.member.Member;
import com.devchw.fitlogix.member.MemberType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    private Long id;
    private String name;
    private String email;
    private MemberType type;

    @Builder
    private MemberResponse(Long id, String name, String email, MemberType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public static MemberResponse toDto(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .type(member.getType())
                .build();
    }
}
