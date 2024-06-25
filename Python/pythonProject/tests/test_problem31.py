import unittest
from src.problem31 import find_combinations_for_sum, solve, Coin


class Problem31Tests(unittest.TestCase):

    def test_find_combinations_for_sum_5(self):
        expected = [
            [Coin(1), Coin(1), Coin(1), Coin(1), Coin(1)],
            [Coin(1), Coin(2), Coin(2)],
            [Coin(5)]
        ]
        actual = find_combinations_for_sum(5)
        self.assertEqual(actual, expected)

    def test_solve(self):
        actual = solve()
        expected = -1

        self.assertEqual(actual, expected)
