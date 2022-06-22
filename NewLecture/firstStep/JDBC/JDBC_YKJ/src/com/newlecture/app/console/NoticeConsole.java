package com.newlecture.app.console;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NoticeConsole {
    private NoticeService service = new NoticeService();

    private int count;
    private int lastPage;
    private String field;
    private String query;

    public NoticeConsole() {
        count = 0;
        lastPage = 1;
    }

    public void printNoticeList(int page) throws SQLException, ClassNotFoundException {
        List<Notice> noticeList = service.getList(page,field,query);
        count = service.getCount();
        lastPage = (count % 5 == 0) ? (count / 5) : (count / 5 + 1);

        System.out.println("───────────────────────────────────────────");
        System.out.printf("<공지사항> 게시글 수 : %d개\n", count);
        System.out.println("───────────────────────────────────────────");
        for (Notice n : noticeList) {
            System.out.printf("%d/ %s/ %s/ %s\n",n.getId(),n.getTitle(),n.getWriterId(),n.getRegDate());
        }
        System.out.println("───────────────────────────────────────────");
        System.out.printf("           %d/%d page         \n",page,lastPage);
        System.out.println("───────────────────────────────────────────");

    }

    public int inputKey() {
        System.out.print("1.글쓰기 /2.이전 /3.다음 /4.검색 /5.종료 > ");
        Scanner sc = new Scanner(System.in);
        int menu = Integer.parseInt(sc.nextLine());

        return menu;
    }
    public int getCount() {
        return count;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void searchWord() {
        System.out.println("검색 범주 : ");
        Scanner sc = new Scanner(System.in);
        field = sc.nextLine();
        System.out.println("검색어 : ");
        query = sc.nextLine();
    }
}
