import unittest
from src import problem29


class Problem29Tests(unittest.TestCase):

    def test_solve(self):
        actual = problem29.solve()
        expected = 9183

        self.assertEqual(actual, expected)
