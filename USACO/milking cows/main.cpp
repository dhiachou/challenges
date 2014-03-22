/*
ID: dhiacho1
PROG: milk2
LANG: C++
*/

#include <iostream>
#include <fstream>

using namespace std;

/**
  * This function calculates the minimum and the maximum in a bi dimensional array which's width is 2
  * @param arr : the bidimensional array
  * @param N : the length of the array
  * @param mini: this will contain the minimum of the array
  * @param maxi: this will contain the maximum of the array
  * @author : Dhia Eddine Chouchane
  */

void getMinMax(long ** arr, short N, long * mini, long * maxi ){
    *mini = *maxi = arr[0][0];

    for (short i(0) ; i<2;i++){
        for (short j(0) ; j< N ; j++){
            if (arr[i][j]<*mini)
                *mini = arr[i][j];
            if (arr[i][j]>*maxi)
                *maxi = arr[i][j];
        }
    }
    cerr<<"min  : " << *mini << " max : " << *maxi <<endl;
}

int main (int argc, char** argv){
    //opening input and output files
    ifstream fin ("milk2.in");
    ofstream fout("milk2.out");

    ///reading input
    short N;
    fin >> N;

    //all outputs on STDERR are for debug purpose
    cerr << N<<endl;

    //allocating memory for the schedule
    long * schedule[2] ;
    for (short i(0) ; i<2 ; i++){
        schedule[i] = new long[N];
    }

    // reading input
    for (short i(0) ; i<N ; i++){
        for (short j(0) ; j<2 ; j++){
            fin>>schedule[j][i];
            cerr << schedule [j][i] <<" ";
        }
        cerr <<endl;
    }

    long m[2]; //this contains minimum number and maximum number

    getMinMax(schedule, N, &m[0],&m[1] );

    long beingMilked(0), notBeingMilked(0), lbeingMilked(0) , lnotBeingMilked(0);

    for (long i(m[0])  ; i<m[1] ; i++){
        bool isMilked = false;
        for (int j(0) ; j<N ; j++){
            if (i >= schedule[0][j] && i<schedule[1][j]){
                lnotBeingMilked = (lnotBeingMilked>notBeingMilked? lnotBeingMilked : notBeingMilked); //we compare to the last value , if it is bigger then we affect it !
                notBeingMilked = 0;
                isMilked = true;
                beingMilked += schedule[1][j] - i;
                i = schedule[1][j]-1;
                break;
            }
        }
        if (! isMilked){
            lbeingMilked = (lbeingMilked>beingMilked? lbeingMilked : beingMilked); //we compare to the last value , if it is bigger then we affect it !
            beingMilked = 0 ;
            notBeingMilked ++ ;
        }
    }

    //making sure everything is up to date:
    lnotBeingMilked = (lnotBeingMilked>notBeingMilked? lnotBeingMilked : notBeingMilked);
    lbeingMilked = (lbeingMilked>beingMilked? lbeingMilked : beingMilked);

    cerr << "Milked time :" <<lbeingMilked<<endl;
    cerr << "not being milked time :"<<lnotBeingMilked<<endl;

    ///Output (and debug display )
    fout << lbeingMilked << " " << lnotBeingMilked <<endl;

    ///Releasing allocated memory
    delete[] schedule[0];
    delete[] schedule[1];

    return 0;
}
