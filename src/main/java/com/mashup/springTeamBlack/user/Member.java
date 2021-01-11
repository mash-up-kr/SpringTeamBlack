package com.mashup.springTeamBlack.user;

import com.mashup.springTeamBlack.user.dto.SignUpRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private Member(SignUpRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
        this.phoneNumber = requestDto.getPhoneNumber();
    }

    public static Member from(SignUpRequestDto requestDto) {
        return new Member(requestDto);
    }
}
