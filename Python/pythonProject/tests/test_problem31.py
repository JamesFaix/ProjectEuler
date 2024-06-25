import unittest
from src import problem31


class Problem31Tests(unittest.TestCase):

    def test_solve(self):
        actual = problem31.solve()
        expected = -1

        self.assertEqual(actual, expected)
