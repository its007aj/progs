//print numbers 1 to n backwards
#include<stdio.h>
void printBackward(int n);
int main(){
	int n= 0;
	scanf("%d", &n); //enter the number
	printBackward(n); 
	return 0;
}
void printBackward(int n){
	if(n==0)
		return;
	else{
		printf("%d\n",n); //print the number
		printBackward(n-1);
	}
}
