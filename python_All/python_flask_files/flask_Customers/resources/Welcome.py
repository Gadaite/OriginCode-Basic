from flask_restful import Resource

class Welcome(Resource):
    def get(self):
        return "zhuoge NB!!!"
