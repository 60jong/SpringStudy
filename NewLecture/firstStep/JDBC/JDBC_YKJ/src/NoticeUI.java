import com.newlecture.app.console.NoticeConsole;

import java.sql.SQLException;

public class NoticeUI {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        NoticeConsole console = new NoticeConsole();
        int page = 1;

        while (true) {
            console.printNoticeList(page);
            int menu = console.inputKey();

            switch (menu) {
                case 1:
                    break;
                case 2:
                    if (page == 1) {
                        System.out.println("이전 페이지가 없습니다.");
                    } else {
                        page--;
                    }
                    break;
                case 3:
                    if (page == console.getLastPage()) {
                        System.out.println("다음 페이지가 업습니다.");
                    } else {
                        page++;
                    }
                    break;
                case 4:
                    console.searchWord();

                    break;
                case 5:
                    break;
            }


        }

    }
}
