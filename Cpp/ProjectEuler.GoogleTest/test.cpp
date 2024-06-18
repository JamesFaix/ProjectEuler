#include "pch.h"
#include "../ProjectEuler.StaticLib/ProjectEuler.StaticLib.cpp"
#include "../ProjectEuler.StaticLib/InfInt.h"

TEST(Problem25Tests, fibWorks) {
	InfInt actual = fib(12);
	InfInt expected = 144;
	EXPECT_EQ(actual, expected);
}

TEST(Problem25Tests, memoFibWorks) {
	InfInt actual = memoFib(12);
	InfInt expected = 144;
	EXPECT_EQ(actual, expected);
}

TEST(Problem25Tests, fibLenWorks) {
	int actual = fibLen(12);
	int expected = 3;
	EXPECT_EQ(actual, expected);
}

TEST(Problem25Tests, ItsSolved) {
	int actual = solveProblem25();
	int expected = 4782;
	EXPECT_EQ(actual, expected);
}