package com.tomhydra.a2sv.geeksforgeeks.selection_sort;


class Solution
{
    int  select(int arr[], int i)
    {
        // code here such that selectionSort() sorts arr[]
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        return min;
    }

    void selectionSort(int arr[], int n)
    {
        //code here
        for (int i = 0; i < arr.length; i++) {
            int min = select(arr, i);
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}