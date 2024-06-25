import unittest
from src.problem31 import *


class Problem31Tests(unittest.TestCase):

    def test_get_all_possible_combinations_5(self):
        actual = get_all_possible_combinations(5)

        expected = [
            (5, 0, 0, 0, 0, 0, 0, 0),
            (3, 1, 0, 0, 0, 0, 0, 0),
            (1, 2, 0, 0, 0, 0, 0, 0),
            (0, 0, 1, 0, 0, 0, 0, 0)
        ]
        expected.sort()

        self.assertEqual(actual, expected)

    def test_solve(self):
        actual = solve()
        expected = 73682

        self.assertEqual(actual, expected)