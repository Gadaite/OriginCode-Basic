#%%
import collections
from typing import List
Card = collections.namedtuple('扑克牌', ['牌号', '类型'])
print(type(Card))
class FrenchDeck:
    ranks = [str(n) for n in range(2, 11)] + list('JQKA')
    suits = '红桃 梅花 方块 黑桃'.split()
    def __init__(self):
        self._cards = [Card(rank, suit) for suit in self.suits for rank in self.ranks]
    def __len__(self):
        return len(self._cards)
    def __getitem__(self, position):
        return self._cards[position]
deck = FrenchDeck()
len(deck)

#%%
from random import choice
for i in range(0,5):
    result = choice(deck)
    print(result)


#%%
class Test():
    def __init__(self) -> None:
        pass
xiaobao = Test()
print(type(xiaobao))
print(type(Test))
#%%
import pandas as pd
print(type(pd))