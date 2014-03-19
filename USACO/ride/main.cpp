
/*
ID: dhiacho1
PROG: ride
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

int main()
{
    //opening input and output files
    ifstream fin("ride.in");
    ofstream fout ("ride.out");

    string comete, groupe ;
    fin>> comete;
    fin>> groupe;

    short int c_len=comete.length();
    short int g_len=groupe.length();


    int c_product=1;
    int g_product=1;

    for(int i=0;i<c_len;i++){
        c_product=c_product*(comete[i]-'A'+1);
    }
    for(int i=0;i<g_len;i++){
        g_product=g_product*(groupe[i]-'A'+1);
    }

    if ((c_product%47) == (g_product%47))
        fout<< "GO"<<endl;
    else
        fout << "STAY"<<endl;

    return 0 ;

}





