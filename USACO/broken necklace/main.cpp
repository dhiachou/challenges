/*
ID: dhiacho1
PROG: beads
LANG: C++
*/

#include <iostream>
#include <fstream>

using namespace std;

char firstColored(string str){
    short i(0);

    while ('w' == str[i] && i < str.length())
        i++;

    return str[i];
}

char lastColored(string str){
    short i;

    i=str.length()-1;

    while ('w' == str[i] && i>0)
        i--;

    return str[i];
}

short edgesCount(string str){
    cerr<< "recieved string : "<< str <<endl;

    short c (0);

    char actualChar = str[0];

    for (short i(0) ; i<str.length(); i++){
        while ('w'==actualChar){
            i++;
            actualChar = str[i];
        }
        if (actualChar == 'b' && str [i] == 'r'){
            actualChar = 'r';
            c++;
        }
        else if (actualChar == 'r' && str [i] == 'b'){
            actualChar = 'b';
            c++;
        }
    }
    if (firstColored(str) != lastColored(str)){
        c++;
    }

    cerr<<"edges count : "<< c <<endl;
    return c;
}

short * rightEdgesPositions(string str, short n){
    short * positions = new short[n];

    short j(0);
    char actualChar = str[0];

    positions[0] = 0;

    if (firstColored(str) != lastColored(str)){
        j++;
        positions[j] = 0;
    }

    for (short i(0) ; i<str.length(); i++){
        while ('w'==actualChar){
            i++;
            actualChar = str[i];
        }
        if (actualChar == 'b' && str [i] == 'r'){
            actualChar = 'r';
            positions[j] = i;
            j++;
        }
        else if (actualChar == 'r' && str [i] == 'b'){
            actualChar = 'b';
            positions[j] = i;
            j++;
        }
    }

    //printing it :
    cerr<<"Right edges array : "<<endl;
    for (short i(0); i<j; i++)
        cerr<<positions[i] <<" , ";
    cerr<<endl;

    return positions ;
}

short * leftEdgesPositions(string str, short n){
    short * positions = new short[n];

    positions[0] = 0;

    short j(n-1);
    char actualChar = str[str.length()-1];

    for (short i(str.length()-1) ; i>=0; i--){
        while ('w'==actualChar){
            i--;
            actualChar = str[i];
        }
        if (actualChar == 'b' && str [i] == 'r'){
            actualChar = 'r';
            positions[j] = i+1;
            j--;
        }
        else if (actualChar == 'r' && str [i] == 'b'){
            actualChar = 'b';
            positions[j] = i+1;
            j--;
        }
    }

    //printing it :
    cerr<<"LEFT edges array : "<<endl;
    for (short i(0); i<n; i++)
        cerr<<positions[i] <<" , ";
    cerr<<endl;

    return positions ;
}

short maxBeadsCollected(short* rarr , short* larr ,short len, short totalLen ) {
    short n;

    n =  totalLen-larr[len-1] + rarr[1] ; //initializing on the length of the circular bound

    cerr<< "initial n : "<< n <<endl;

    for (short i(0); i<len-2 ; i++){
        n = (( rarr[i+2]- larr[i]  > n )? rarr[i+2] - larr[i] : n ) ;
    }
    cerr << "n fore last  : " << n <<endl;
    n = (( rarr[0]+ totalLen-larr[len-2]  > n )? rarr[0]+ totalLen-larr[len-2]: n ) ;
    n= (n>totalLen? totalLen : n ) ;
    cerr << "max = "<<n<<endl;

    return n;
}

int main (int argc, char** argv){
    //opening input and output files
    ifstream fin ("beads.in");
    ofstream fout("beads.out");

    ///reading input
    short N;
    fin >> N;
    string necklace;
    fin >> necklace;

    //all outputs on STDERR are for debug purpose
    cerr << N<<endl<<necklace<<endl;

    short n = edgesCount(necklace);

    short * rightEdges  = rightEdgesPositions(necklace,n);
    short * leftEdges  = leftEdgesPositions(necklace,n);

    ///Output (and debug display )
    fout << maxBeadsCollected(rightEdges,leftEdges,n , N )<<endl;

    //Releasing allocated memory //this causes some strange errors sometimes what might be the cause ?
    //delete[] rightEdges;
    //delete[] leftEdges;

    return 0;
}
