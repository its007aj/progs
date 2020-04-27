// generating all the binary strings of n bits
#include<stdio.h>
#include<stdlib.h>
char *A;
void Binary(int n){
	if(n<1)
		printf("%s\n", A);
	else{
		A[n-1]= '0'; //last element 0
		Binary(n-1);
		A[n-1]= '1'; //last element 1
		Binary(n-1);
	}
}
int main(){
	int n= 0; //number of bits
	scanf("%d", &n);
	A= (char*)malloc(sizeof(char)*(n+1));
	A[n]= '\0'; //making the last character NULL to terminate string
	Binary(n);
}
