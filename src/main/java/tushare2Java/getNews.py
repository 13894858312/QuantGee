# encoding=utf-8
import tushare as ts


# ts.get_latest_news() #默认获取最近80条新闻数据，只提供新闻类型、链接和标题
# ts.get_latest_news(top=5,show_content=True) #显示最新5条新闻，并打印出新闻内容

def get_top_news(n):
    news = ts.get_latest_news(top=n)
    return news


def get_news_content(url):
    new = ts.latest_content(url=url)
    return new
