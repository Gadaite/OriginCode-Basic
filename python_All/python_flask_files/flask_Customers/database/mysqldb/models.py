from database.mysqldb.db import db
  
# class DateEncoder(json.JSONEncoder):  
#     def default(self, obj):  
#         if isinstance(obj, datetime.datetime):  
#             return obj.strftime('%Y-%m-%d %H:%M:%S')  
#         # elif isinstance(obj, date):  
#         #     return obj.strftime("%Y-%m-%d")  
#         else:  
#             return json.JSONEncoder.default(self, obj) 

class CustomersModel(db.Model):
    __tablename__ = 'Customers'
    vend_id = db.Column(db.String(50),unique = True,primary_key = True)
    vend_name = db.Column(db.String(50),nullable = False,default = False)
    vend_address = db.Column(db.String(50),nullable = False)
    vend_city = db.Column(db.String(50),nullable = False)
    vend_state = db.Column(db.String(50),nullable = False)
    vend_zip = db.Column(db.String(50),nullable = False)
    vend_country = db.Column(db.String(50),nullable = False)
    def dictRepr(self):
        info ={
            "vend_id":self.vend_id,
            "vend_name":self.vend_name,
            "vend_address":self.vend_address,
            "vend_city":self.vend_city,
            "vend_state":self.vend_state,
            "vend_zip":self.vend_zip,
            "vend_country":self.vend_country
        }
        return info
class OrdersModel(db.Model):
    __tablename__ = 'Orders'
    order_num = db.Column(db.String(50),unique = True,primary_key = True)
    order_date = db.Column(db.String(50),nullable = False,default = False)
    cust_id = db.Column(db.String(50),nullable = False,default = False)
    def dictRepr(self):
        info ={
            "order_num":self.order_num,
            "order_date":self.order_date,
            "cust_id":self.cust_id
        }
        return info 