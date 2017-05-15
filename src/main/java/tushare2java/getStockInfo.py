#encoding=utf-8
import tushare as ts
from sqlalchemy import create_engine


def get_hist_info_to_db(id):

    df = ts.get_hist_data(id)
    engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')
    df.to_sql('StockInfo',engine,if_exists='append',index=False)
    return

def get_current_info(id):
    return