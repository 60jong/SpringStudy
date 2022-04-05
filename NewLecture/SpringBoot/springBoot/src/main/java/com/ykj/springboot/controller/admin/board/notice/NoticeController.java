package com.ykj.springboot.controller.admin.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/board/notice/")
@Controller("adminNoticeController")
public class NoticeController {
    @RequestMapping("list")
    public String list() {
        return "admin.board.notice.list";
    }
    @RequestMapping("detail")
    public String detail() {
        return "admin.board.notice.detail";
    }    @RequestMapping("reg")
    public String reg() {
        return "admin.board.notice.reg";
    }

}
