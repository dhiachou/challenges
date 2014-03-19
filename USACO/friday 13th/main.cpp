/*
ID: dhiacho1
PROG: friday
LANG: C++
*/
#include <iostream>
#include <fstream>

using namespace std;

int main(){
    ifstream fin ("friday.in");
    ofstream fout("friday.out");

    int year(1900);    //this is the starting year
    int months_days[12] = {31,28,31,30,31,30,31,31,30,31,30,31}; //this array holds the number of days in each month
    int freq [7] = {0,0,0,0,0,0,0}; //first is monday
    long day(0);

    ///Input
    int N(0);
    fin>>N; //getting the number of years to test on

    ///Computing Algorithm
    int dest_year = year + N  ;

    while (year < dest_year){
        months_days[1] = (((year % 400 == 0) || (year % 100 !=0 && year %4 ==0)) ?\
                        29 : 28);   //determining the number of days in february (whether it is a leap year or not)
        int i(0);
        while (i<12){               //getting into the 13th of each month
            freq [day%7]++;         //and increasing the counts of the day on the 13th of that month
            day += months_days[i];  //getting to the 13th of the next month
            i++;
        }
        year ++;            //repeating this every year until we reach the dest_year
    }

    /// Output
    for (int i(0) ; i<6 ; i++)
        fout << freq[i]<<" ";
    fout <<freq[6]<<endl;

    return 0;
}
