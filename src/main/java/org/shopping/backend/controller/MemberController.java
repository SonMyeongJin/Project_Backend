package org.shopping.backend.controller;

import org.shopping.backend.entity.Item;
import org.shopping.backend.entity.Member;
import org.shopping.backend.repository.ItemRepository;
import org.shopping.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public int login(@RequestBody Map<String, String> param){
        Member member = memberRepository.findByNameAndPassword(param.get("name"), param.get("password"));

        if (member != null) {
            return member.getMember_id();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
