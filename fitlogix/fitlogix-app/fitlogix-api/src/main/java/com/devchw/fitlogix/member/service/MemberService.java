package com.devchw.fitlogix.member.service;

import com.devchw.fitlogix.member.Member;
import com.devchw.fitlogix.member.service.response.MemberResponse;
import com.devchw.fitlogix.member.MemberReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberReader memberReader;

    // 회원 단일 조회
    public MemberResponse getMember(Long id) {
        return MemberResponse.toDto(memberReader.read(id));
    }

    // TODO : 회원 리스트 조회 만들기 (이슈 내용 제목)
    // 이슈 내용 본문
    // assignees : DevCHW

}
