package com.devchw.fitlogix.member.controller;

import com.devchw.fitlogix.member.MemberType;
import com.devchw.fitlogix.member.service.MemberService;
import com.devchw.fitlogix.member.service.response.MemberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberControllerTest extends RestDocsSupport {

    private final MemberService memberService = mock(MemberService.class);

    @Override
    protected Object initController() {
        return new MemberController(memberService);
    }

    @DisplayName("회원 id를 받아서 회원 1명을 조회하는 API")
    @Test
    void getMember() throws Exception {
        // given
        Long id = 1L;

        // stubbing
        given(memberService.getMember(any(Long.class)))
                .willReturn(MemberResponse.builder()
                        .id(1L)
                        .name("최현우")
                        .type(MemberType.USER)
                        .email("ggoma003@naver.com")
                        .build());

        mockMvc.perform(
                    get("/api/v1/members/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").isMap())
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("최현우"))
                .andExpect(jsonPath("$.data.type").value("USER"))
                .andExpect(jsonPath("$.data.email").value("ggoma003@naver.com"))
                .andDo(
                        document("members-get",
                            preprocessRequest(prettyPrint()), // JSON 이쁘게 출력
                            preprocessResponse(prettyPrint()), // JSON 이쁘게 출력
                            pathParameters(parameterWithName("id").description("회원 ID")),
                            responseFields(
                                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                                            .description("코드"),
                                    fieldWithPath("status").type(JsonFieldType.STRING)
                                            .description("상태"),
                                    fieldWithPath("message").type(JsonFieldType.STRING)
                                            .description("메세지"),
                                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                                            .description("응답 데이터"),
                                    fieldWithPath("data.id").type(JsonFieldType.NUMBER)
                                            .description("회원 ID"),
                                    fieldWithPath("data.name").type(JsonFieldType.STRING)
                                            .description("회원 이름"),
                                    fieldWithPath("data.email").type(JsonFieldType.STRING)
                                            .description("회원 이메일"),
                                    fieldWithPath("data.type").type(JsonFieldType.STRING)
                                            .description("회원 타입")
                            )
                        )
                );
    }

}
