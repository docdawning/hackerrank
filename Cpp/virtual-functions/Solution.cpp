//Refs: https://www.hackerrank.com/challenges/virtual-functions

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/// start
class Person {
	protected:
		string name;
		int age;
	public:
		virtual void putdata() {}
		virtual void getdata() {}
};

class Professor: public Person {
	private:
		int thisId;
		int publications;
	public:	
		Professor() {
			static int cur_id = 0;
			thisId = ++cur_id;
		}
	
		virtual void putdata() {
			cout << name << " " << age << " " << publications << " " << thisId << endl;
		}

		virtual void getdata() {
			cin >> name >> age >> publications;
		}
};

class Student: public Person {
	private:
		int thisId;
		int marks[6];
	public:
		Student() {
			static int cur_id = 0;
			thisId = ++cur_id;
		}
		virtual void putdata() {
			int markSum = marks[0];
			for (int i=1;i<=5;i++) markSum += marks[i];

			cout << name << " " << age << " " << markSum << " " << thisId << endl;
                }

                virtual void getdata() {
			cin >> name >> age >> marks[0] >> marks [1] >> marks[2] >> marks[3] >> marks[4] >> marks[5];
                }
};

/// end

int main(){

    int n, val;
    cin>>n; //The number of objects that is going to be created.
    Person *per[n];

    for(int i = 0;i < n;i++){

        cin>>val;
        if(val == 1){
            // If val is 1 current object is of type Professor
            per[i] = new Professor;

        }
        else per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.

    }

    for(int i=0;i<n;i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;

}

