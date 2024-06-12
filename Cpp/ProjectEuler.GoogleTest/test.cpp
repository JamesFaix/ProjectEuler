#include "pch.h"
#include "../ProjectEuler.StaticLib/ProjectEuler.StaticLib.cpp"
#include "../ProjectEuler.StaticLib/InfInt.h"

TEST(Problem25Tests, ItsSolved) {
	InfInt actual = solveProblem25();
	InfInt expected = 0;
	EXPECT_EQ(actual, expected);
}

TEST(Problem25Tests, fibWorks) {
	InfInt actual = fib(12);
	InfInt expected = 144;
	EXPECT_EQ(actual, expected);
}

TEST(Problem25Tests, fibLenWorks) {
	int actual = fibLen(12);
	int expected = 3;
	EXPECT_EQ(actual, expected);
}