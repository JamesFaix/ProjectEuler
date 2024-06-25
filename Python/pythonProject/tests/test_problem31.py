import unittest
from src.problem31 import *


class Problem31Tests(unittest.TestCase):

    def test_get_leaves(self):
        tree = TreeNode.root()
        c1 = TreeNode(Coin(100), tree)
        tree.add_child(c1)
        c2 = TreeNode(Coin(50), tree)
        tree.add_child(c2)
        c3 = TreeNode(Coin(50), c1)
        c1.add_child(c3)
        c4 = TreeNode(Coin(20), c1)
        c1.add_child(c4)

        actual = get_leaves(tree)
        expected = [
            c3, c4, c2
        ]

        self.assertEqual(actual, expected)

    def test_get_path(self):
        tree = TreeNode.root()
        c1 = TreeNode(Coin(100), tree)
        tree.add_child(c1)
        c2 = TreeNode(Coin(50), tree)
        tree.add_child(c2)
        c3 = TreeNode(Coin(50), c1)
        c1.add_child(c3)
        c4 = TreeNode(Coin(20), c1)
        c1.add_child(c4)

        actual = get_path(c4)
        expected = [
            Coin(100), Coin(20)
        ]

        self.assertEqual(actual, expected)

    def test_get_sum(self):
        tree = TreeNode.root()
        c1 = TreeNode(Coin(100), tree)
        tree.add_child(c1)
        c2 = TreeNode(Coin(50), tree)
        tree.add_child(c2)
        c3 = TreeNode(Coin(50), c1)
        c1.add_child(c3)
        c4 = TreeNode(Coin(20), c1)
        c1.add_child(c4)

        actual = get_sum(c4)
        expected = 120

        self.assertEqual(actual, expected)

    def test_find_combinations_for_total_5(self):
        expected = [
            [Coin(1), Coin(1), Coin(1), Coin(1), Coin(1)],
            [Coin(1), Coin(1), Coin(1), Coin(2)],
            [Coin(1), Coin(2), Coin(2)],
            [Coin(5)]
        ]
        actual = find_combinations_for_total(5)
        self.assertEqual(actual, expected)

    def test_solve(self):
        actual = solve()
        expected = -1

        self.assertEqual(actual, expected)
