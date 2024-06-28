from math import floor, sqrt


def is_prime(n: int) -> bool:
    if n < 2:
        return False

    midway = floor(sqrt(n))  # Can't be divisible by anything > 1/2 your size
    possible_divisors = range(2, midway + 1)

    for d in possible_divisors:
        if n % d == 0:
            return False

    return True


def get_primes(max: int) -> list[int]:
    rng = range(1, max + 1)
    primes = filter(is_prime, rng)
    return list(primes)


def get_rotations(n: int) -> list[int]:
    n_str = str(n)
    digits = len(n_str)

    if digits == 1:
        return [n]

    else:
        rotations = [n]
        for i in range(1, digits):
            n_str = n_str[1:] + n_str[:1]
            rotations.append(int(n_str))
        return rotations


def is_circular_prime(n: int, primes: list[int]) -> bool:
    rotations = get_rotations(n)
    for r in rotations:
        if r not in primes:
            return False
    return True


def get_circular_primes(max: int) -> list[int]:
    primes = get_primes(max)
    circulars = filter(lambda n: is_circular_prime(n, primes), primes)
    return list(circulars)


def solve() -> int:
    primes = get_circular_primes(1_000_000)
    return len(primes)

# You are the 90344th person to have solved this problem.
