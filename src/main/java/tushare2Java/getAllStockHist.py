import tushare as ts

df = ts.get_hist_data(code = '600848', start='2014-01-05', end='2014-01-09')
print df
