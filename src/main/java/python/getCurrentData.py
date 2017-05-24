# # encoding=utf-8
# from sqlalchemy import create_engine
# import tushare as ts
# import time
#
#
# def get_current_data():
#     df = ts.get_today_all()
#     t = time.asctime()[11:16]
#     df['time'] = t
#     engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     df.to_sql('Current', engine, if_exists='append')
#     print 'over'
#     return
#
#
# def replace():
#     df = ts.get_today_all()
#     t = time.asctime()[11:16]
#     df['time'] = t
#     engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     df.to_sql('Current', engine, if_exists='replace')
#     print 'replace_over'
#     return
#
#
# while True:
#     print time.asctime()[11:13]
#     if time.asctime()[11:13] == '01':
#         replace()
#     else:
#         get_current_data()
#     time.sleep(120)
