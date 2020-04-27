//checking array is sorted using recurion
#include<stdio.h>
#include<stdlib.h>
int checkSorted(int arr[], int n);
int main(){
	int n; //size of array
	int *arr; //pointer to array
	int i= 0;
	scanf("%d", &n);
	arr= (int*)malloc(sizeof(int)*n);
	for(i=0; i<n; i++)
		scanf("%d", &arr[i]);
	if(checkSorted(arr,n))
		printf("Sorted");
	else
		printf("Not sorted");
}
int checkSorted(int *arr, int n){
	if(n==1)
		return 1;
	else{
		if(arr[n-1]>arr[n-2]) //ascending order
			return checkSorted(arr,n-1);
		else
			return 0;
	}
	
}
