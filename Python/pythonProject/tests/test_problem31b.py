import unittest
from src.problem31b import *


class Problem31Tests(unittest.TestCase):

    def test_max_of_each_within_sum(self):
        actual = list(max_of_each_within_sum(200))
        expected = [
            (1, 200),
            (2, 100),
            (5, 40),
            (10, 20),
            (20, 10),
            (50, 4),
            (100, 2),
            (200, 1)
        ]
        self.assertEqual(actual, expected)

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