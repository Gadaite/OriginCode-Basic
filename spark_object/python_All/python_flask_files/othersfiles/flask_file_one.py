
#%%
"""
    传入程序实例app，完成对扩展的初始化
"""
import os
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
app = Flask(__name__)
db = SQLAlchemy(app)
#%%
"""
    是否追踪对象修改，用于Flask-SQLalchemy的事件通知系统
"""
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

#%%
#绝对路径定位数据库
#app.config['SQLALCHEMY_DATABASE_URI'] = os.getenv('DATABASE_URL','sqlite:///'+os.path.join(app.root_path,'data.db'))
#使用URL定位数据库
app.config['SQLALCHEMY_DATABASE_URI'] = os.getenv('DATABASE_URL','mysql://root:zzjz123@139.155.70.177:3306/Gadaite')

#%%
#定义数据库Model
class CustomerModel(db.Model):
    table = ''
    vend_id = db.Column(db.String(50),unique = True,primary_key = True)
    vend_name = db.Column(db.String(50),nullable = False,default = False)
    vend_address = db.Column(db.String(50),nullable = False)
    vend_city = db.Column(db.String(50),nullable = False)
    vend_state = db.Column(db.String(50),nullable = False)
    vend_zip = db.Column(db.String(50),nullable = False)
    vend_country = db.Column(db.String(50),nullable = False)
#%%
#创建数据库和表
db.create_all()
#%%

