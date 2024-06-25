import math


def solve() -> int:
    results = []

    for a in range(2, 101):
        for b in range(2, 101):
            x = math.pow(a, b)

            if x not in results:
                results.append(x)

    return len(results)

# You are the 112329th person to have solved this problem.