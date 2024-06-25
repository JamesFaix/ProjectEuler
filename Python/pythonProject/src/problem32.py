


# 5000 * 2 = 10000, which has 10 digits in the full equation
factor_upper_bound = 4999


def get_digits(number: int):
    return list(map(int, [c for c in str(number)]))


def are_digits_distinct(digits):
    return len(list(set(digits))) == len(digits)


def digits_overlap(digits1, digits2):
    return any(check in digits1 for check in digits2)


def get_possible_factors():
    def is_valid(n):
        digits = get_digits(n)
        return 0 not in digits and are_digits_distinct(digits)

    xs = range(0, factor_upper_bound + 1)
    xs = filter(is_valid, xs)
    return list(xs)


def get_possible_factor_pairs():
    xs = []

    factors = get_possible_factors()

    for a in factors:
        digits_a = get_digits(a)
        for b in factors:
            digits_b = get_digits(b)

            if not digits_overlap(digits_a, digits_b):
                xs.append((a, b))

    return xs


def get_pandigital_products():
    results = []

    for (a, b) in get_possible_factor_pairs():
        x = a * b
        digits = get_digits(a) + get_digits(b) + get_digits(x)

        if (len(digits) == 9
                and 0 not in digits
                and are_digits_distinct(digits)
                and (b, a, x) not in results):

            results.append((a, b, x))

    return results


def solve() -> int:
    results = get_pandigital_products()
    products = map(lambda tup: tup[2], results)
    products = list(set(products))
    return sum(products)

# You are the 76389th person to have solved this problem.