import unittest
from src.problem32 import *


class Problem32Tests(unittest.TestCase):

    def test_solve(self):
        actual = solve()
        expected = -1

        self.assertEqual(actual, expected)