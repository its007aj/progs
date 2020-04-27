//Tower of Hanoi
#include<stdio.h>
int steps= 0; //number of steps taken
void towerOfHanoi(int n, char frompeg, char topeg, char auxpeg){
	//if only 1 disk , make the move and return
	if(n==1){
		printf("Move disk 1 from peg %c to peg %c.\n", frompeg, topeg);
		steps++;
		return;
	}
	//Move top n-1 disks from A to B using C as auxillary
	towerOfHanoi(n-1, frompeg, auxpeg, topeg);
	
	//Move remaining disks from A to C
	printf("Move disk %d from peg %c to peg %c\n", n, frompeg, topeg);
	steps++;
	
	//Move n-1 disks from B to C using A as auxillary
	towerOfHanoi(n-1,auxpeg, topeg, frompeg);
}
int main(){
	int n= 0;
	scanf("%d", &n); //enter the number of disks
	towerOfHanoi(n, 'A', 'C', 'B'); //disks have to moved from A to C
	printf("\n%d", steps); //output the number of steps
}
