import math
from typing import NewType

# In the United Kingdom the currency is made up of pound (£) and pence (p).
# There are eight coins in general circulation:
#     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
#
# It is possible to make £2 in the following way:
#     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
#
# How many different ways can £2 be made using any number of coins?


Coin = NewType('Coin', int)


valid_coins = [
    Coin(1),
    Coin(2),
    Coin(5),
    Coin(10),
    Coin(20),
    Coin(50),
    Coin(100),
    Coin(200)
]


def find_combinations_for_sum(sum: int):
    return []


def solve() -> int:
    return 0
