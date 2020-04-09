
//

#include <iostream>
#include <string>

using namespace std;
struct TS{ 
	string str;
	double w; 
	char ch; 
};



double zadachaDve(TS objects[],int length) {
	double average = 0;

	int count = 0;

	string numbers = "0123456789";
	for (int i = 0; i < length; i++)
	{
		TS currentObject = objects[i];
		if (currentObject.str.find_first_of(numbers)==string::npos && numbers.find_first_of(currentObject.ch)!=string::npos) {
			cout << currentObject.str << endl;
			average += currentObject.w;
			count++;
		}
		
	}

	if (count == 0) {
		return -1;
	}
	
	return average / count;
}


int main()
{
	TS objects[] = { "riledri",15,'a' ,
	"nark3213oman",15,'57' , 
	"bokKiro",5,'10' , 
	"daskircata",15,'a' , 
	};

	cout << zadachaDve(objects, 4) << endl;
	
	system("pause");

    
}

