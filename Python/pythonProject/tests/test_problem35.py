import unittest
from src.problem35 import *


class Problem35Tests(unittest.TestCase):

    def test_is_prime(self):
        for n, expected in [
            (-3, False),
            (0, False),
            (1, False),
            (2, True),
            (3, True),
            (4, False),
            (5, True),
            (6, False),
            (7, True),
            (8, False),
            (9, False),
            (10, False),
            (96, False),
            (97, True),
        ]:
            with self.subTest(p1=n, p2=expected):
                actual = is_prime(n)
                self.assertEqual(actual, expected)

    def test_get_primes(self):
        actual = get_primes(20)
        expected = [2, 3, 5, 7, 11, 13, 17, 19]
        self.assertEqual(actual, expected)

    def test_get_primes_001000(self):
        actual = len(get_primes(1000))
        expected = 168
        self.assertEqual(actual, expected)

    def test_get_primes_010000(self):
        actual = len(get_primes(10000))
        expected = 1229
        self.assertEqual(actual, expected)

    def test_get_primes_050000(self):
        actual = len(get_primes(50000))
        expected = 5133
        self.assertEqual(actual, expected)

    def test_get_primes_100000(self):
        actual = len(get_primes(100000))
        expected = 9592
        self.assertEqual(actual, expected)

    def test_get_primes_1000000(self):
        actual = len(get_primes(1000000))
        expected = 78498
        self.assertEqual(actual, expected)

    def test_get_rotations(self):
        n = 197
        expected = [197, 971, 719]
        actual = get_rotations(n)
        self.assertEqual(actual, expected)

    def test_is_circular_prime(self):
        primes = get_primes(100)

        for n, expected in [
            (0, False),
            (2, True),
            (3, True),
            (4, False),
            (5, True),
            (7, True),
            (11, True),
            (13, True),
            (17, True),
            (19, False),
            (23, False),
            (31, True)
        ]:
            with self.subTest(p1=n, p2=expected):
                actual = is_circular_prime(n, primes)
                self.assertEqual(actual, expected)

    def test_get_circular_primes(self):
        actual = get_circular_primes(100)
        expected = [2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97]
        self.assertEqual(actual, expected)

    def test_solve(self):
        actual = solve()
        expected = 55
        self.assertEqual(actual, expected)
