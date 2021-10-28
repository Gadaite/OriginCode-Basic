#%%
from flask import Flask
from database import mysqldb
from flask_restful import Api
from resources.routes import initialize_routes
from flask_cors import CORS
from resources import errors
app = Flask(__name__)
CORS(app)
app.config.from_pyfile('databaseinfo.py')
#初始化mysql数据库
mysqldb.db.initialize_db(app)
#初始化flask_restful接口
api = Api(app,errors=errors)
#初始化资源，绑定url到api
initialize_routes(api)

if (__name__ == '__main__'):
    app.run(debug=False,host="0.0.0.0",port=4000)
# %%
