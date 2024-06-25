import math


def get_digits(number: int):
    return list(map(int, [c for c in str(number)]))


def is_sum_of_digits_to_power(number: int, power: int) -> bool:
    def to_pow(n: int):
        return math.pow(n, power)

    digits = get_digits(number)
    if len(digits) < 2:
        return False
    else:
        return number == sum(list(map(to_pow, digits)))


def get_numbers_that_are_sum_of_powers_of_their_digits(power: int, limit: int) -> list:
    rng = range(1, limit + 1)
    return list(filter(lambda x: is_sum_of_digits_to_power(x, power), rng))


def solve(limit: int) -> int:
    return sum(get_numbers_that_are_sum_of_powers_of_their_digits(5, limit))

# You are the 116877th person to have solved this problem.