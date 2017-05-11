package vo.stock;

/**
 * Created by Mark.W on 2017/5/10.
 * 新闻动态的类
 */
public class NewsVO {
    private String title;
    private String url;

    public NewsVO() {}

    /**
     * @param title 标题
     * @param url 链接
     */
    public NewsVO(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
