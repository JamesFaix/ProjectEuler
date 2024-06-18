// ProjectEuler.StaticLib.cpp : Defines the functions for the static library.
//

#include "pch.h"
#include "framework.h"
#include "InfInt.h"
#include <stdexcept>
#include <string>
#include <functional>
#include <map>

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

std::map<int, InfInt> fibCache;

static InfInt memoFib(int i);
static InfInt fib(int i) {
	if (i < 0) {
		throw std::invalid_argument("Indexes must be positive.");
	}

	if (i == 1 || i == 2) {
		return 1;
	}

	return memoFib(i - 1) + memoFib(i - 2);
}
static InfInt memoFib(int i) {
	InfInt val = fibCache[i];

	if (val == NULL) {
		val = fib(i);
		fibCache.insert_or_assign(i, val);
	}

	return val;
}

static int fibLen(int i) {
	InfInt f = memoFib(i);
	std::string s = f.toString();
	return s.length();
}

static bool testNum(int i) {
	int l = fibLen(i);
	if (l >= 10) {
		return true;
	}
	else {
		std::cout << "Checked fib(" + std::to_string(i) + "), length is " + std::to_string(l)  + "\n";
		return false;
	}
}

static int solveProblem25()
{
	// If not memoized
	//	10x = <1ms
	//  20x = 18ms
	//  30x = 2.3s
	//  40x = minutes

	for (int i = 1; i < 100; i++) {
		if (testNum(i)) {
			return i;
		}
	}

	return -1;
}
