


# 5000 * 2 = 10000, which has 10 digits in the full equation
factor_upper_bound = 4999


def get_digits(number: int):
    return list(map(int, [c for c in str(number)]))


def are_digits_distinct(digits):
    return len(list(set(digits))) == len(digits)


def digits_overlap(digits1, digits2):
    return any(check in digits1 for check in digits2)


def solve() -> int:
    results = []

    for a in range(0, factor_upper_bound + 1):
        digits_a = get_digits(a)
        if are_digits_distinct(digits_a):

            for b in range(0, factor_upper_bound + 1):
                digits_b = get_digits(b)
                if (are_digits_distinct(digits_b)
                    and not digits_overlap(digits_a, digits_b)):

                    x = a * b
                    digits_x = get_digits(x)

                    if (are_digits_distinct(digits_x)
                        and not digits_overlap(digits_a, digits_x)
                        and not digits_overlap(digits_b, digits_x)):

                        results.append((a, b, x))

    return len(results)
