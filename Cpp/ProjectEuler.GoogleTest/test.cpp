#include "pch.h"
#include "../ProjectEuler.StaticLib/ProjectEuler.StaticLib.cpp"
TEST(ProjectEulerTests, Problem25) {
	int actual = solveProblem25();
	int expected = 0;
	EXPECT_EQ(actual, expected);
}