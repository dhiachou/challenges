/*
ID: dhiacho1
PROG: gift1
LANG: C++
*/

#include <iostream>
#include <fstream>

using namespace std;

/**
 ** Returns the position of "seek" in the array arr
 ** @param seek : what we are seeking
 ** @param arr : the array of strings in which we will search
 ** @param length: the length of the array
 **/
int getIndex(string seek,string arr[], int length){
    int i (0);
    while (arr[i]!=seek && i<length) i++;
    return i;
}

int main (int argc, char** argv){
    //opening input and output files
    ifstream fin ("gift1.in");
    ofstream fout("gift1.out");

    //getting the number of persons
    short NP;
    fin >> NP;

    //all outputs on STDERR are for debug purpose
    cerr << NP<<endl;

    //Dynamic allocation of memory
    string * name = new string[NP]; //this array contains the names of persons
    int * balance = new int  [NP];  //this array will contain how much each player gives or recieves money in total

    ///Initializing the arrays
    for(int i(0); i<NP; i++){
        fin>>name[i] ;
        cerr<<name[i]<<endl;
        balance[i] = 0;
    }

    for (int i(0); i<NP; i++){
        string nm;
        int to_pay(0), n_players(0);

        fin>>nm;        //the name of the giver
        fin>>to_pay;    //how much he wants to pay
        fin>>n_players; //how many players will get money

        cerr << "from " << nm << " we'll pay "<< to_pay << " to "<< n_players << " players"<<endl;

        if (n_players == 0 )    //this is to avoid division by zero
            continue;

        to_pay = to_pay/n_players; //how much each player will get

        cerr<<to_pay<<endl;

        int k = getIndex(nm, name,NP);

        balance[k] -= to_pay * n_players; //deducing the real amout he's giving

        ///giving money to each listed player
        for (int j(0) ; j<n_players ; j++){
            fin>>nm;                        //the name of the reciever
            int k = getIndex(nm,name,NP);   //getting the index of the reciever
            balance[k]+= to_pay;            //giving him money
        }
    }

    ///Output (and debug display )
    for (int i(0); i<NP ; i++){
        fout<<name[i]<<" "<<balance[i]<<endl;
        cerr<<endl<<"_______OUTPUT_________ : "<<endl <<endl;
        cerr<<name[i]<<" "<<balance[i]<<endl;
    }

    //Releasing allocated memory
    delete[] balance;
    delete[] name;
    return 0;
}
