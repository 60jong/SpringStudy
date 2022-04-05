package com.newlecture.app.console;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NoticeConsole {
    private NoticeService service;
    private int count = 0;
    String searchField;
    String searchWord;

    public int returnCount() {
        return count;
    }

    public NoticeConsole() {
        service = new NoticeService();
    }
    public void printNoticeList(int page) throws SQLException, ClassNotFoundException {
        List<Notice> list = service.getList(page,searchField,searchWord);
        count = service.getCount();
        int lastpage = count/10 == 0 ? count/10: count/10 +1;

        System.out.println("──────────────────────────────────");
        System.out.printf("<공지사항> 총 %d게시글\n",count);
        System.out.println("──────────────────────────────────");
        for (Notice n : list) {
            System.out.printf("%d. %s/ %s/ %s\n",n.getId(),n.getTitle(),n.getWriter_id(),n.getRegdate());
        }


        System.out.printf("             %d/%d page         \n",page,lastpage);
    }

    public int inputNoticeMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기/ 5.검색 > ");
        String menu1 = sc.nextLine();

        int menu = Integer.parseInt(menu1);

        return menu;


    }

    public void DoRetrieve() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 범주 : ");
        searchField = sc.nextLine();
        System.out.print("검색어 : ");
        searchWord = sc.nextLine();
    }
}
