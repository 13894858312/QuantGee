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
# def get_current_data():
#     df = ts.get_today_all()
#     t = time.asctime()[11:16]
#     # engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     # df.to_sql('Current', engine, if_exists='append', index = False)
#     #
#     df2 = ts.get_index()
#     # df2.to_sql('CurrentIndex',engine,if_exists='append', index = False)
#
#     try:
#         conn = MySQLdb.connect(host='127.0.0.1', port=3306, user='root', passwd='19961112',
#                                db='quantgee_data', charset='utf8')  # cennect the database
#         cur = conn.cursor()
#
#         for n in range(0, len(df)):
#             c = df.iloc[n]
#             SQL = "INSERT INTO Current(code, name, changepercent, trade, open, high, low, settlement," \
#                   " volume, turnoverratio, amount, per, pb, mktcap, nmc, time)" \
#                   " VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
#             l = (c['code'], c['name'], c['changepercent'], c['trade'], c['open'], c['high'],
#                  c['low'], c['settlement'], c['volume'], c['turnoverratio'], c['amount'],
#                  c['per'], c['pb'], c['mktcap'], c['nmc'], t)
#             cur.execute(SQL, l)
#
#         for n2 in range(0, len(df2)):
#             i = df2.iloc[n2]
#             code = i['code']
#             change = i['change']
#             open = i['open']
#             preclose = i['preclose']
#             close = i['close']
#             high = i['high']
#             low = i['low']
#             volume = i['volume']
#             amount = i['amount']
#
#             # code = MySQLdb.escape_string(code)
#             # change = MySQLdb.escape_string(change)
#             # open = MySQLdb.escape_string(open)
#             # preclose = MySQLdb.escape_string(preclose)
#             # close = MySQLdb.escape_string(close)
#             # high = MySQLdb.escape_string(high)
#             # low = MySQLdb.escape_string(low)
#             # volume = MySQLdb.escape_string(volume)
#             # amount = MySQLdb.escape_string(amount)
#
#             SQL2 = "INSERT INTO CurrentIndex(code, changes, openNum, preclose, closeNum, high, low, volume, " \
#                    "amount, t)VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
#             l2 = (code, change, open, preclose, close, high, low, volume, amount, t)
#             cur.execute(SQL2, l2)
#
#         conn.commit()
#         cur.close()
#         conn.close()
#
#     except AttributeError, e:
#         print e
#     except TypeError, e:
#         print e
#     except MySQLdb.ProgrammingError, e:
#         print e
#
#     print 'get_over'
#     return
#
#
# def replace():
#     #  df = ts.get_today_all()
#     # t = time.asctime()[11:16]
#     # df['time'] = t
#     # engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     # df.to_sql('Current', engine, if_exists='replace')
#     try:
#         conn = MySQLdb.connect(host='127.0.0.1', port=3306, user='root', passwd='19961112',
#                                db='quantgee_data', charset='utf8')
#         cur = conn.cursor()
#         cur.execute("DELETE FROM Current")
#         cur.execute("DELETE FROM CurrentIndex")
#         conn.commit()
#         cur.close()
#         conn.close()
#     except TypeError,e:
#         print e
#     print 'replace_over'
#     return
#
#
# while True:
#     hour = time.asctime()[11:13]
#     minute = time.asctime()[14:16]
#     print hour + ':' + minute
#     if hour >= '09':
#         if hour < '16':
#             get_current_data()
#     if hour == '08':
#         if minute < '05':
#             replace()
#     # get_current_data()
#     print 'over'
#     time.sleep(120)
