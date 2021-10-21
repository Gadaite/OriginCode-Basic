from flask_restful import Resource,reqparse
from database.mysqldb import db
from flask import request
from database.mysqldb.models import OrdersModel 
from flask import Flask ,render_template
import json
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
#connection = create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite")
Session = sessionmaker(bind=create_engine("mysql+pymysql://root:zzjz123@139.155.70.177:3306/Gadaite"))
session = Session()
class OrdersApi(Resource):
    ##使用get方式请求数据库并返回相关表字段筛选结果
    def __init__(self) -> None:
        super().__init__()
    def get(self):
        #传递
        parser = reqparse.RequestParser()
        parser.add_argument('order_num')
        parser.add_argument('order_date')
        parser.add_argument('cust_id')
        #解析
        args = parser.parse_args()
        order_num = args['order_num']
        order_date = args['order_date']
        cust_id = args['cust_id']
        #筛选
        filters = OrdersModel.query
        if order_num is not None:
            filters = filters.filter_by(order_num = order_num)
        if order_date is not None:
            filters = filters.filter_by(order_date = order_date)
        if cust_id is not None:
            filters = filters.filter_by(cust_id = cust_id)
        #返回
        rows = filters.all()
        if len(rows)==0:
            return [{
                "order_num":None,
                "order_date":None,
                "cust_id":None
            }]
        else:
            return [row.dictRepr() for row in rows]
    ##使用post方式增加相关信息写入数据库
    def post(self):
         #传递
        parser = reqparse.RequestParser()
        parser.add_argument('order_num')
        parser.add_argument('order_date')
        parser.add_argument('cust_id')
        #解析
        args = parser.parse_args()
        order_num = args['order_num']
        order_date = args['order_date']
        cust_id = args['cust_id']
        
        #db=SQLalchemy()
        #body = request.get_json()
        #ordersmodel = OrdersModel(**body)
        #db.session.add(ordersmodel)
        #db.session.commit()

        ordersmodel = OrdersModel(order_num = order_num,order_date = order_date,cust_id = cust_id)
        session.add(ordersmodel)
        session.commit()
        #session.close()
        return {'order_num': ordersmodel.order_num,'order_date': ordersmodel.order_date,"cust_id":ordersmodel.cust_id}, 200

    def delete(self):
        OrdersModel.query.delete()
        db.session.commit()
        return "succeed to delete", 200
