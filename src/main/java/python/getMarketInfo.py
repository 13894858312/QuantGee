# # encoding=utf-8
# from sqlalchemy import create_engine
# import tushare as ts
#
#
# def get_market_info_to_db():
#     df = ts.get_industry_classified()
#     engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#
#     df.to_sql('MarketInfo', engine, if_exists='fail', index=False)
#     return
#
# def get_sme():
#     df1 = ts.get_sme_classified()
#     print df1
#     engine1 = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     df1.to_sql('SME', engine1, if_exists='fail', index=False)
#     return
#
# def get_gem():
#     df2 = ts.get_gem_classified()
#     print df2
#     engine2 = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
#     df2.to_sql('GEM', engine2, if_exists='fail', index=False)
#     return
#
#     #get_market_info_to_db();
#     #get_sme()
#     #get_gem()