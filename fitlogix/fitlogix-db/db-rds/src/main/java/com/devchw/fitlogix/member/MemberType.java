package com.devchw.fitlogix.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberType {

    ADMIN("관리자"),
    USER("일반 회원");

    public final String text;

}
