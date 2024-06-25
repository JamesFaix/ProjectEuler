from typing import NewType
from functools import reduce
from math import floor

# In the United Kingdom the currency is made up of pound (£) and pence (p).
# There are eight coins in general circulation:
#     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
#
# It is possible to make £2 in the following way:
#     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
#
# How many different ways can £2 be made using any number of coins?


Coin = NewType('Coin', int)
valid_coin_values = [1, 2, 5, 10, 20, 50, 100, 200]


def max_of_each_within_sum(total: int):
    return map(lambda x: (x, floor(total / x)), valid_coin_values)


def integer_divide(dividend: int, divisor: int):
    return floor(dividend / divisor)


Combination = NewType('Combination', tuple[int, int, int, int, int, int, int, int])


def get_combination_value(c: Combination) -> int:
    (p1, p2, p5, p10, p20, p50, p100, p200) = c
    return ((1 * p1)
            + (2 * p2)
            + (5 * p5)
            + (10 * p10)
            + (20 * p20)
            + (50 * p50)
            + (100 * p100)
            + (200 * p200))


def get_all_possible_combinations(total: int):
    def range_of_coin(value: int):
        return range(0, integer_divide(total, value) + 1)

    def is_correct_value(c: Combination):
        return get_combination_value(c) == total

    possible_combinations: list[Combination] = []

    for p1 in range_of_coin(1):
        for p2 in range_of_coin(2):
            for p5 in range_of_coin(5):
                for p10 in range_of_coin(10):
                    for p20 in range_of_coin(20):
                        for p50 in range_of_coin(50):
                            for p100 in range_of_coin(100):
                                for p200 in range_of_coin(200):
                                    c: Combination = (p1, p2, p5, p10, p20, p50, p100, p200)
                                    possible_combinations.append(c)

    possible_combinations = list(filter(is_correct_value, possible_combinations))
    possible_combinations.sort()

    return possible_combinations
