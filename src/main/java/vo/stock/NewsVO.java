package vo.stock;

/**
 * Created by Mark.W on 2017/5/10.
 * 新闻动态的类
 */
public class NewsVO {
    private String classify;
    private String title;
    private String time;
    private String url;
    private String content;

    public NewsVO() {}

    /**
     * @param classify 分类
     * @param title 标题
     * @param url 链接
     * @param time 时间
     * @param content 内容
     */
    public NewsVO(String classify, String title, String time, String url, String content) {
        this.classify = classify;
        this.title = title;
        this.time = time;
        this.url = url;
        this.content = content;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
