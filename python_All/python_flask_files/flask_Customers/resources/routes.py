from resources.orders import OrdersApi
from resources.Welcome import Welcome
def initialize_routes(api):
    api.add_resource(OrdersApi,'/orders')
    api.add_resource(Welcome, '/')

