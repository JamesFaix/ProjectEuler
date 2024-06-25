import unittest
from src.problem32 import *


class Problem32Tests(unittest.TestCase):

    def test_get_pandigital_products(self):
        actual = get_pandigital_products()
        expected = [
            (4, 1738, 6952),
            (4, 1963, 7852),
            (12, 483, 5796),
            (18, 297, 5346),
            (27, 198, 5346),
            (28, 157, 4396),
            (39, 186, 7254),
            (42, 138, 5796),
            (48, 159, 7632)
        ]

        self.assertEqual(actual, expected)

    def test_solve(self):
        actual = solve()
        expected = -1

        self.assertEqual(actual, expected)