package bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by wangxue on 2017/5/15.
 */
@Entity
public class News {
    private String classify;
    private String title;
    private String time;
    private String url;
    private String content;

    @Basic
    @Column(name = "classify")
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (classify != null ? !classify.equals(news.classify) : news.classify != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (time != null ? !time.equals(news.time) : news.time != null) return false;
        if (url != null ? !url.equals(news.url) : news.url != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classify != null ? classify.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
