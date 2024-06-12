// ProjectEuler.StaticLib.cpp : Defines the functions for the static library.
//

#include "pch.h"
#include "framework.h"
#include "InfInt.h"
#include <stdexcept>
#include <string>

/* 
	Problem 25:

	The first 12 terms of the Fibonacci sequence are:
		F1  =   1
		F2  =   1
		F3  =   2
		F4  =   3
		F5  =   5
		F6  =   8
		F7  =  13
		F8  =  21
		F9  =  34
		F10 =  55
		F11 =  89
		F12 = 144

	The 12th term, F12, is the first to contain three digits.

	What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
*/

static InfInt fib(int i) {
	if (i < 0) {
		throw std::invalid_argument("Indexes must be positive.");
	}

	if (i == 1 || i == 2) {
		return 1;
	}

	return fib(i - 1) + fib(i - 2);
}

static int fibLen(int i) {
	InfInt f = fib(i);
	std::string s = f.toString();
	return s.length();
}

static InfInt solveProblem25()
{
	InfInt x = 1;

	return x;
}
