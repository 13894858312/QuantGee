# # -*- coding:utf-8 -*-
# from sqlalchemy import create_engine
# import tushare as ts
# import time
# import MySQLdb
# import sys
#
# reload(sys)
# sys.setdefaultencoding('utf-8')
#
#
# # def get_top_n_news(n):
# #     news = ts.get_latest_news(top=n,show_content=True)
# #     print news
# #     engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
# #     news.to_sql('News', engine, if_exists='replace')
# #
# #     return
# #
# #
# def get_top_n_news(num):
#     try:
#         conn = MySQLdb.connect(host='127.0.0.1', port=3306, user='root', passwd='19961112',
#                                db='quantgee_data', charset='utf8')  # cennect the database
#         cur = conn.cursor()
#         cur.execute("DELETE FROM News")
#
#         ns = ts.get_latest_news(top=num, show_content=True)
#
#         for n in range(0, len(ns)):
#             nw = ns.iloc[n]
#             classify = nw['classify']
#             title = nw['title']
#             url = nw['url']
#             content = nw['content']
#             t = nw['time']
#             classify = MySQLdb.escape_string(classify)
#             title = MySQLdb.escape_string(title)
#             url = MySQLdb.escape_string(url)
#             t = MySQLdb.escape_string(t)
#             if content!=None:
#                 content = MySQLdb.escape_string(content).decode('utf-8')
#
#             SQL = "INSERT INTO News VALUES (%s,%s,%s,%s,%s,%s)"
#             l = (n, classify.decode('utf-8'), title.decode('utf-8'), t.decode('utf-8')
#                  , url.decode('utf-8'), content)
#             cur.execute(SQL, l)
#         conn.commit()
#         cur.close()
#         conn.close()
#
#     except AttributeError, e:
#         print e
#     except TypeError, e:
#         print e
#     return
#
# while True:
#     print 'startNews'
#     get_top_n_news(20)
#     print 'over'
#     time.sleep(600)
