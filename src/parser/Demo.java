package parser;

import com.machinepublishers.glass.ui.monocle.MonoclePlatformFactory;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) /*throws MalformedURLException*/ throws IOException {

        /*URL url = new URL("https://flashdeals.aliexpress.com/en.htm?");
        String line;
        List<Article> listArticles = new ArrayList<>();

        try (InputStream inputStream = url.openStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            while ((line = bufferedReader.readLine()) != null){
                if (line.contains("<div class=deals-item-inner")){
                    String link = line.trim();
                    Article article = new Article(link);
                    listArticles.add(article);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        listArticles.forEach(System.out::println);*/

        JBrowserDriver driver = new JBrowserDriver(Settings.builder().timezone(Timezone.EUROPE_KIEV).build());
        driver.get("https://flashdeals.aliexpress.com/en.htm?");

        String loadPage = driver.getPageSource();

        ((JavascriptExecutor)driver).executeScript("jQuery18306121861958147454_1554108007321;", loadPage);

        List<Article> listArticles = new ArrayList<>();
        Document doc = Jsoup.parse(loadPage);

        Elements links = doc.select(".deals-item-inner");

        for (Element link : links){
            Element aElement = link.child(0);
            String url = "https:" + aElement.attr("href");
            listArticles.add(new Article(url));
        }

        driver.quit();

        System.out.println("Количество ссылок - " + listArticles.size());
        listArticles.forEach(System.out::println);


        /*for (Article article : listArticles){
                if (article != null){
                    System.out.println("Link on page with product - " + article.getUrl());
                    String urlProduct = "https://" + article.getUrl();
                    driver.get(urlProduct);
                    String productPage = driver.getPageSource();
                    Document document = Jsoup.parse(productPage);
                    Elements linksStore = document.select(".shop-name");
                    Store store;
                    for (Element element : linksStore){
                        if (element != null){
                            Element aTeg = link.child(1);
                            String urlStore = aTeg.attr("href");
                            String nameStore = aTeg.attr("title");
                            Long idStore = getIdStore(urlStore);
                            store = new Store(idStore, nameStore, urlStore);
                            System.out.println("Store - " + store + "\n" + "Name store: " + nameStore + "\n" + "-----------");
                        }
                    }


                }
            }*/
        //driver.quit();

//        for (Article article : listArticles){
//            if (article != null){
//                driver.get(String.valueOf(article));
//                String productPage = driver.getPageSource();
//                Document document = Jsoup.parse(productPage);
//                Elements linksStore = document.select(".shop-name");
//                Store store;
//                for (Element link : linksStore){
//                    if (link != null){
//                        Element aElement = link.child(1);
//                        String urlStore = aElement.attr("href");
//                        String nameStore = aElement.attr("title");
//                        Long idStore = getIdStore(urlStore);
//                        store = new Store(idStore, nameStore, urlStore);
//                        System.out.println("Store - " + store + "\n" + "Name store: " + nameStore + "\n" + "-----------");
//                    }
//                }
//
//
//            }
//        }

        //driver.quit();

        //System.out.println("Количество ссылок - " + listArticles.size());
        //listArticles.forEach(System.out::println);
    }

    /*private String correctInputLink(String link){


    }*/

    private static Long getIdStore(String urlStore){
        String[] word = urlStore.split("/");
        return Long.valueOf(word[word.length - 1]);
    }
}
