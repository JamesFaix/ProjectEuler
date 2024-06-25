import unittest
from src import problem30

limit = 1000000


class Problem30Tests(unittest.TestCase):

    def test_get_digits(self):
        actual = problem30.get_digits(1634)
        expected = [1, 6, 3, 4]
        self.assertEqual(actual, expected)

    def test_is_sum_of_digits_to_power(self):
        for n, expected in [
            (1, False),
            (5, False),
            (1634, True),
            (1635, False)
        ]:
            with self.subTest(p1=n, p2=expected):
                actual = problem30.is_sum_of_digits_to_power(n, 4)
                self.assertEqual(actual, expected)

    def test_get_numbers_that_are_sum_of_powers_of_their_digits(self):
        for power, expected in [
            (1, []),
            (2, []),
            (3, [153, 370, 371, 407]),
            (4, [1634, 8208, 9474]),
            (5, [4150, 4151, 54748, 92727, 93084, 194979])
        ]:
            with self.subTest(p1=power, p2=expected):
                actual = problem30.get_numbers_that_are_sum_of_powers_of_their_digits(power, limit)
                self.assertEqual(actual, expected)

    def test_solve(self):
        actual = problem30.solve(limit)
        expected = 443839

        self.assertEqual(actual, expected)
