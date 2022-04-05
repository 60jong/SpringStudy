package com.newlecture.web.controller.notice;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notice/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoticeService service = new NoticeService();
        List<NoticeView> noticeList = new ArrayList<>();
        String field = "title";
        String query = "";

        String field_ = request.getParameter("f");
        String query_ = request.getParameter("q");
        String page_ = request.getParameter("p");

        if (field_!=null && !field_.equals("")) {
            field = field_;
        }
        if (query_ != null && !query_.equals("")) {
            query = query_;
        }
        int page = 1;
        if (page_ != null && !page_.equals("")) {
            page = Integer.parseInt(page_);
        }

        int count = service.getNoticePubCount(field, query);

        noticeList = service.getNoticePubList(field,query,page);

        request.setAttribute("count",count);
        request.setAttribute("nList",noticeList);
        request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request,response);

    }
}
