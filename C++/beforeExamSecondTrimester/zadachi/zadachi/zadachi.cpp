// zadachi.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "zadachi.h"
using namespace std;

struct Person {
	string name;
	double salary;
};

void fillArray(Person persons[], int L)
{
	for (int i = 0; i < L; i++)
	{
		cout << "Vuvedi ime" << endl;
		string name;
		cin >> name;
		cout << "Vuvedi zaplata" << endl;


		double salary;
		cin >> salary;

		struct Person p1 = { name,salary };
		persons[i] = p1;
	}
}

void sortBySalary(Person arr[], int l) {
	for (int i = 1; i < l; i++)
	{

		for (int j = 0; j < i; j++)
		{
			if (arr[j].salary < arr[i].salary) {
				Person temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

}

void printArray(Person arr[],int l) {
	for (int i = 0; i < l; i++)
	{
		cout << "Name:" + arr[i].name << "\n Salary:" << arr[i].salary << endl;
	}
}


//sorting array


int main()
{
    std::cout << "Hello World!\n";
	const int count=3;
	
	//cin >> count;
	Person persons[count];

	fillArray(persons,count);
	sortBySalary(persons, count);
	printArray(persons,count);


}




