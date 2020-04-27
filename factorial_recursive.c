//Find factorial of a number using recursion
#include<stdio.h>
int factorial(int n);
int main(){
	int n= 0;
	int f= 0;
	scanf("%d", &n); //enter the number whose factorial is to be calculated
	f= factorial(n);
	printf("%d", f); //output the factorial
	return 0;
}
int factorial(int n){
	if(n==0)
		return 1;
	else
		return n*factorial(n-1);
}
