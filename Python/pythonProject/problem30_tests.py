import unittest
import problem30


class Problem30Tests(unittest.TestCase):

    def test_get_digits(self):
        actual = problem30.get_digits(1634)
        expected = [1, 6, 3, 4]
        self.assertEqual(actual, expected)

    def test_is_sum_of_digits_to_power(self):
        for n, expected in [
            (5, False),
            (1634, True),
            (1635, False)
        ]:
            with self.subTest(p1=n, p2=expected):
                actual = problem30.is_sum_of_digits_to_power(n, 4)
                self.assertEqual(actual, expected)

    def test_solve(self):
        actual = problem30.solve()
        expected = 1

        self.assertEqual(actual, expected)


if __name__ == '__main__':
    unittest.main()
