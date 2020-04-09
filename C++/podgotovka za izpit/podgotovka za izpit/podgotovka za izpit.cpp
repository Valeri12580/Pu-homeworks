// podgotovka za izpit.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <vector>;
using namespace std;



int main()
{
	int x = 25;
	int* p = &x;
	cout << p << endl;
	cout << *p << endl;

	x = x + 5; //30

	x = *p + 5; //35;

	*p = *p + 5;//p=40 x=40
	cout << "P:"<< *p << endl;

	cout << "X:" << x << endl;

	cout << "*&*p :" << *&*p << endl;

	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
