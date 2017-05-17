# # encoding=utf-8
# from sqlalchemy import create_engine
# import tushare as ts
# import time
#
#
# def get_top_n_news(n):
#     news = ts.get_latest_news(top=n,show_content=True)
#     engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     news.to_sql('News', engine, if_exists='replace')
#     return
#
#
# while True:
#     print 'startNews'
#     get_top_n_news(50)
#     time.sleep(600)
# #