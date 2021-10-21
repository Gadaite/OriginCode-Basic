from flask import app


SQLALCHEMY_DATABASE_URI = 'mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite'
#是否追踪对象修改，用于Flask-SQLalchemy的事件通知系统
SQLALCHEMY_TRACK_MODIFICATIONS = False
SQLALCHEMY_POOL_SIZE = 30 #解决数据库连接数的问题
SQLALCHEMY_MAX_OVERFLOW = 60 
SQLALCHEMY_BINDS = {
    'Gadaite': SQLALCHEMY_DATABASE_URI
}