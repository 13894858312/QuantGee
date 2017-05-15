# encoding=utf-8
from sqlalchemy import create_engine
import tushare as ts


def get_market_info_to_db():
    df = ts.get_industry_classified()
    engine = create_engine('mysql+pymysql://root:19961112@localhost:3306/quantgee_data?charset=utf8')

    df.to_sql('MarketInfo', engine, if_exists='fail', index=False)
    return
