package com.mashup.springTeamBlack.user;

import com.mashup.springTeamBlack.user.dto.SignUpRequestDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// UserDetails는 사용자 정보 VO
@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void signUp(SignUpRequestDto request) {
        if (isExisted(request.getEmail())){
//            throw new Exception();
            System.out.println("exception");
         }

        Member member = Member.from(request);
        memberRepository.save(member);
    }

    private boolean isExisted(String email) {
        return memberRepository.findByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
