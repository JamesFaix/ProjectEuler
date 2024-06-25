import math


def get_digits(number: int):
    return list(map(int, [c for c in str(number)]))


def is_sum_of_digits_to_power(number: int, power: int) -> bool:
    def to_pow(n: int):
        return math.pow(n, power)

    digits = get_digits(number)
    return number == sum(list(map(to_pow, digits)))


def solve() -> int:
    return 0
