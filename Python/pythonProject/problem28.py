import math

# Starting with the number and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

# 21 22 23 24 25
# 20  7  8  9 10
# 19  6  1  2 11
# 18  5  4  3 12
# 17 16 15 14 13

# It can be verified that the sum of the numbers on the diagonals is 101.

# What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?


def list_diagonal_numbers_of_spiral(diameter: int) -> list:
    if diameter % 2 == 0:
        raise Exception("Number spiral must be of odd size")

    radius = math.floor(diameter / 2)
    result = [1]
    i = 1

    for r in range(1, radius + 1):
        # Move out 1
        i += 1

        # Skip over current radius
        i += r

        # Append first corner
        result.append(i)

        # Skip over second side
        i += (2 * r)

        # Append second corner
        result.append(i)

        # Skip over third side
        i += (2 * r)

        # Append third corner
        result.append(i)

        # Skip over fourth side
        i += (2 * r)

        # Append last corner
        result.append(i)

        # Skip over last bit
        i += r

    return result


def sum_diagonal_numbers_of_spiral(diameter: int) -> int:
    xs = list_diagonal_numbers_of_spiral(diameter)
    return sum(xs)


def solve() -> int:
    return sum_diagonal_numbers_of_spiral(1001)


# You are the 114568th person to have solved this problem.
