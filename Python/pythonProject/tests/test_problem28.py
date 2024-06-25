import unittest
from src import problem28


class Problem28Tests(unittest.TestCase):

    def test_list_diagonal_numbers_of_spiral_3(self):
        actual = problem28.list_diagonal_numbers_of_spiral(3)
        expected = [1, 3, 5, 7, 9]

        self.assertEqual(actual, expected)

    def test_list_diagonal_numbers_of_spiral_5(self):
        actual = problem28.list_diagonal_numbers_of_spiral(5)
        expected = [1, 3, 5, 7, 9, 13, 17, 21, 25]

        self.assertEqual(actual, expected)

    def test_sum_diagonal_numbers_of_spiral_5(self):
        actual = problem28.sum_diagonal_numbers_of_spiral(5)
        expected = 101

        self.assertEqual(actual, expected)

    def test_solve(self):
        actual = problem28.solve()
        expected = 669171001

        self.assertEqual(actual, expected)
