import com.newlecture.app.console.NoticeConsole;

import java.sql.SQLException;

public class Program5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        NoticeConsole console = new NoticeConsole();

        int page = 1;

        EXIT:
        while(true){
            console.printNoticeList(page);
            int menu = console.inputNoticeMenu();

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
                    int lastpage = console.returnCount()/10==0 ? console.returnCount()/10 : console.returnCount()/10+1;
                    if (page == console.returnCount()/10+1) {
                        System.out.println("다음 페이지가 없습니다.");
                    } else {
                        page++;
                    }

                    break;
                case 4:
                    break;
                case 5:
                    console.DoRetrieve();
                    break;
                case 6:
                    System.out.println("Bye!");
                    break EXIT;
                default:
                    System.out.println("<<사용밥법>> 메뉴는 1~4까지만 입력할 수 있습니다.");
                    break;
        }


        }
    }
}
