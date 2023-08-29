package com.devchw.fitlogix.member.controller;

import com.devchw.fitlogix.ApiResponse;
import com.devchw.fitlogix.member.service.response.MemberResponse;
import com.devchw.fitlogix.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String ok() {
        log.info("컨트롤러 호출댐");
        return "ok";
    }

    /**
     * 회원 조회
     */
    @GetMapping("/{id}")
    public ApiResponse<MemberResponse> getMember(@PathVariable Long id) {
        return ApiResponse.ok(memberService.getMember(id));
    }

    /**
     * 회원 목록 조회
     */

    /**
     * 회원 정보 수정
     */

    /**
     * 회원 상태(활동중, 탈퇴) 조회
     */

    /**
     * 회원 이메일로 조회
     */

    /**
     * 회원 삭제
     */

    /**
     * 회원_운동 조회
     */

    /**
     * 회원_운동 목록 조회
     */

    /**
     * 회원_운동 날짜별 조회
     */

    /**
     * 회원_운동 많이한 운동부위 1위 조회
     * 회원_운동 일자별 통계(했는지? 안했는지?)
     */

    /**
     * 회원_운동 월별 통계(몇번?)
     */
}
