import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Scrap {
    public static void main(String[] args) {
        String url = "https://py-learn.onrender.com/";

        try {
            Document doc = Jsoup.connect(url).get();
            doc.select(".courses ol li a").forEach(x -> {
                try {
                    System.out.println(STR."Course Name: \{x.text()}");
                    String url2 = STR."https://py-learn.onrender.com\{x.attr("href")}";
                    System.out.println(STR."Course Link: \{url2}");
                    Connection connection2 = Jsoup.connect(url2);
                    connection2.cookie("sessionid", "lh87raytawfgchw1umb4ppo6vqjclge8");
                    Document doc2 = connection2.get();
                    System.out.println("--- THEMES ---");
                    doc2.select(".themes ol li a").forEach(y -> {
                        String url3 = STR."https://py-learn.onrender.com\{y.attr("href")}";
                        System.out.println(STR."Title: \{y.text()}");
                        System.out.println(STR."Link: \{url3}");
                        System.out.println("----------------------------");
                    });
                    System.out.println("============================");
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

