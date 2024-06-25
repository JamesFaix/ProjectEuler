import math
from typing import NewType
from functools import reduce

# In the United Kingdom the currency is made up of pound (£) and pence (p).
# There are eight coins in general circulation:
#     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
#
# It is possible to make £2 in the following way:
#     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
#
# How many different ways can £2 be made using any number of coins?


Coin = NewType('Coin', int)
valid_coin_values = [1, 2, 5, 10, 20, 50, 100, 200]


class TreeNode:
    def __init__(self, value, parent):
        self.value = value
        self.parent = parent
        self.children = []

    def is_root(self):
        return self.parent is None

    def add_child(self, node):
        self.children.append(node)

    @staticmethod
    def root():
        return TreeNode(None, None)


def get_leaves(self: TreeNode) -> list :
    if len(self.children) == 0:
        return [self]
    else:
        return reduce(lambda a, b: a+b, map(get_leaves, self.children))


def get_path(self: TreeNode) -> list:
    if self.parent is None:
        return []
    else:
        return get_path(self.parent) + [self.value]


def find_combinations_for_sum(sum: int):
    def get_coins_that_fit(value: int):
        return filter(lambda x: x <= value, valid_coin_values)

    tree = TreeNode.root()

    for c in get_coins_that_fit(sum):
        tree.add_child(TreeNode(Coin(c), tree))

    return []


def solve() -> int:
    return 0
