#include "pch.h"
#include "../ProjectEuler.StaticLib/ProjectEuler.StaticLib.cpp"
//#include "../ProjectEuler.StaticLib/BigInt.hpp"
#include "../ProjectEuler.StaticLib/InfInt.h"
//
TEST(ProjectEulerTests, Problem25) {
	InfInt actual = solveProblem25();
	InfInt expected = 0;
	EXPECT_EQ(actual, expected);
}


