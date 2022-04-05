package com.newlecture.web.controller.admin.notice;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Collection;

@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*5,
        maxRequestSize = 1024*1024*5*5
)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        System.out.println(title);
        String content = request.getParameter("content");
        String isOpen = request.getParameter("open");
        boolean pub = false;
        if (isOpen != null) {
            pub = true;
        }


        StringBuilder sb = new StringBuilder();
        Collection<Part> parts = request.getParts();
        for (Part p : parts) {
            if (!p.getName().equals("file")) continue;
            if (p.getSize() == 0) continue;
            Part filePart = p;
            String fileName = filePart.getSubmittedFileName();
            sb.append(fileName);
            sb.append(",");

            InputStream fis = filePart.getInputStream();

            String realPath = request.getServletContext().getRealPath("/upload");
            String filePath = realPath + File.separator + fileName;

            File path = new File(realPath);
            if (!path.exists()) {
                path.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(filePath);

            byte[] buf = new byte[1024];
            int size = 0;
            while ((size = fis.read(buf)) != -1) {
                fos.write(buf,0,size);

            }
            fos.close();
            fis.close();
        }
        if (!sb.toString().equals("")) {
            sb.delete(sb.length() - 1, sb.length());
        }




        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setPub(pub);
        notice.setWriterId("YKJ");
        notice.setFiles(sb.toString());

        NoticeService service = new NoticeService();
        service.insertNotice(notice);

        response.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
    }
}
