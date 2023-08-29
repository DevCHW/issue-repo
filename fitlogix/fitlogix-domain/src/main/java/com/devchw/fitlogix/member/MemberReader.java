package com.devchw.fitlogix.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberReader {

    private final MemberRepository memberRepository;

    // 에러문구
    private static final String NOT_FOUND_MEMBER = "찾을 수 없는 회원입니다.";

    public Member read(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException(NOT_FOUND_MEMBER));
    }
}
