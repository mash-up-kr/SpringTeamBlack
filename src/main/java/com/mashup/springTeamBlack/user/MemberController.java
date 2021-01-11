package com.mashup.springTeamBlack.user;

import com.mashup.springTeamBlack.user.dto.SignUpRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpRequestDto requestBody) {
        memberService.signUp(requestBody);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
