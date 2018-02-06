package news;

import news.entity.News;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This is {@link Sort}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Sort {

    News newsA = new News(1, 1, "新闻A", 1);
    News newsB = new News(2, 2, "新闻A", 2);
    News newsC = new News(3, 3, "新闻A", 3);
    News newsD = new News(4, 4, "新闻A", 4);
    News newsE = new News(5, 5, "新闻A", 5);
    News newsF = new News(6, 6, "新闻A", 6);
    News newsG = new News(7, 7, "新闻A", 7);
    News newsH = new News(8, 8, "新闻A", 8);
    News newsI = new News(9, 9, "新闻A", 9);

    List<News> listOrigin = new ArrayList<News>(){{add(newsA);add(newsB);add(newsC);add(newsD);add(newsE);add(newsF);add(newsG);add(newsH);add(newsI);}};


    News newsA_New = new News(1, 1, "新闻A", 1);
    News newsB_New = new News(2, 2, "新闻A", 2);
    News newsC_New = new News(3, 3, "新闻A", 3);
    News newsD_New = new News(4, 4, "新闻A", 4);
    News newsE_New = new News(5, 5, "新闻A", 5);
    News newsF_New = new News(6, 6, "新闻A", 6);
    News newsG_New = new News(7, 7, "新闻A", 7);
    News newsH_New = new News(8, 8, "新闻A", 8);
    News newsI_New = new News(9, 9, "新闻A", 9);


    List<News> listNew = new ArrayList<News>(){{add(newsA_New);add(newsB_New);add(newsC_New);add(newsD_New);add(newsE_New);add(newsF_New);add(newsG_New);add(newsH_New);add(newsI_New);}};


    public static void main(String[] args) throws Exception {

        String dateString = "2017-05-03";
        SimpleDateFormat reverseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date current = reverseDateFormat.parse(dateString);
        System.out.println("解析得到日期为：" + current);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("M.d");
        String str = dateFormat.format(date);
        System.out.println("current:" + str);

        calendar.add(Calendar.DATE, 15);
        Date halfMonth = calendar.getTime();
        System.out.println(halfMonth);
        str = dateFormat.format(halfMonth);
        System.out.println("half month later:" + str);

//        Date date1 = new Date();
//        date1.after(date) == true;

    }

    public static void printNew() {

    }
}
