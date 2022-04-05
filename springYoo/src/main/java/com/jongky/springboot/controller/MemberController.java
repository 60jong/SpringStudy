package com.jongky.springboot.controller;

import com.jongky.springboot.entity.Member;
import com.jongky.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }


    @GetMapping("/members/new")
    public String createMemberForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(Member member) {
        System.out.println(member);

        service.join(member);

        return "redirect:/";
    }


    @GetMapping("/members")
    public String memberList(Model model){

        List<Member> memberList = service.findMembers();
        model.addAttribute("memberList", memberList);
        return "members/memberList";
    }
}
