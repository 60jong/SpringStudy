package com.ykj.springboot.controller.customer;


import com.ykj.springboot.entity.NoticeView;
import com.ykj.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customer/notice/")
@Controller("customerNoticeController")
public class NoticeController {
    @Autowired
    private NoticeService service;

    @RequestMapping("list")
    public String list(Model model) {
        int page = 1;
        String field = "title";
        String query = "";

        List<NoticeView> noticeList = service.getNoticeList(page,field,query);
        model.addAttribute("noticeList", noticeList);

        return "customer.notice.list";
    }
    @RequestMapping("detail")
    public String detail() {
        NoticeView notice = service.getNotice(1);
        return "";
    }
    @RequestMapping("edit")
    public String edit() {

        return "";
    }
    @RequestMapping("reg")
    public String reg() {

        return "";
    }
}
