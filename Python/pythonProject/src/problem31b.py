from typing import NewType
from math import floor

# In the United Kingdom the currency is made up of pound (£) and pence (p).
# There are eight coins in general circulation:
#     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
#
# It is possible to make £2 in the following way:
#     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
#
# How many different ways can £2 be made using any number of coins?


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
    def range_of_coin_optimized(value: int, subtotal: int):
        return range(0, integer_divide(subtotal, value) + 1)

    def is_correct_value(c: Combination):
        return get_combination_value(c) == total

    possible_combinations: list[Combination] = []

    for p200 in range_of_coin_optimized(200, total):
        p100_remaining = total - (200 * p200)
        for p100 in range_of_coin_optimized(100, p100_remaining):
            p50_remaining = p100_remaining - (100 * p100)
            for p50 in range_of_coin_optimized(50, p50_remaining):
                p20_remaining = p50_remaining - (50 * p50)
                for p20 in range_of_coin_optimized(20, p20_remaining):
                    p10_remaining = p20_remaining - (20 * p20)
                    for p10 in range_of_coin_optimized(10, p10_remaining):
                        p5_remaining = p10_remaining - (10 * p10)
                        for p5 in range_of_coin_optimized(5, p5_remaining):
                            p2_remaining = p5_remaining - (5 * p5)
                            for p2 in range_of_coin_optimized(2, p2_remaining):
                                p1_remaining = p2_remaining - (2 * p2)
                                for p1 in range_of_coin_optimized(1, p1_remaining):
                                    c: Combination = (p1, p2, p5, p10, p20, p50, p100, p200)
                                    if is_correct_value(c):
                                        possible_combinations.append(c)

    possible_combinations.sort()

    return possible_combinations


def solve() -> int:
    return len(get_all_possible_combinations(200))

# You are the 91062nd person to have solved this problem.