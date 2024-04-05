package org.shopping.backend.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.shopping.backend.entity.Item;
import org.shopping.backend.entity.Member;
import org.shopping.backend.repository.ItemRepository;
import org.shopping.backend.repository.MemberRepository;
import org.shopping.backend.service.JwtService;
import org.shopping.backend.service.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody Map<String, String> param,
                                HttpServletResponse res){
        Member member = memberRepository.findByNameAndPassword(param.get("name"), param.get("password"));

        if (member != null) {
            JwtService jwtService = new JwtServiceImpl();
            int id = member.getMember_id();
            String token = jwtService.getToken("id", id);

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return new ResponseEntity<>(id, HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
