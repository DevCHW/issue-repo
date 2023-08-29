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

    public MemberResponse getMember(Long id) {
        return MemberResponse.toDto(memberReader.read(id));
    }
}
