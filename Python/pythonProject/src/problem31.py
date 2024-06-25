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
        self.parent: TreeNode = parent
        self.children: list[TreeNode] = []

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


def get_sum(self: TreeNode) -> int:
    path = get_path(self)
    return sum(path)


def build_tree(total: int) -> TreeNode:
    def get_coins_that_fit(value: int):
        return filter(lambda x: x <= value, valid_coin_values)

    tree = TreeNode.root()
    nodes_to_check = [tree]

    while len(nodes_to_check) > 0:
        node = nodes_to_check.pop(0)
        accumulated = get_sum(node)
        print(get_path(node))

        coins = get_coins_that_fit(total - accumulated)
        children = map(lambda x: TreeNode(Coin(x), node), coins)

        for c in children:
            nodes_to_check.append(c)
            node.add_child(c)

    return tree


def get_all_paths(tree: TreeNode) -> list[list[Coin]]:
    leaves = get_leaves(tree)
    paths = list(map(get_path, leaves))

    # Sort elements in each path
    for p in paths:
        p.sort()

    # Remove duplicate paths
    tuples = map(tuple, paths)
    distinct_paths = set(tuples)
    paths = list(map(list, distinct_paths))

    # Sort paths
    paths.sort()

    return paths


def find_combinations_for_total(total: int) -> list[list[Coin]]:
    tree = build_tree(total)
    return get_all_paths(tree)


def solve() -> int:
    return len(find_combinations_for_total(7))
