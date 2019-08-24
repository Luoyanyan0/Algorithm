package test;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:44 2019/7/10
 */
public class MergeSort {
    @Test
    public void main() {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        int[] tmp = new int[arr.length];    //新建一个临时数组存放
        mergeSort(arr,0,arr.length-1,tmp);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid+1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }

    public void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            merge(arr,low,mid,high,tmp);    //合并两个有序序列
        }
    }


    @Test
    public void test1(){
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        System.out.println(InversePairs(arr));
    }

    public int InversePairs(int [] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        int[] temp = new int[array.length];
        return MergeSort(array,temp,0,array.length-1);
    }

    public int MergeSort(int[] array,int[] temp ,int start,int end){
        if(start >= end){
            return 0;
        }
        int mid = (start + end) / 2;
        int left = MergeSort(array,temp,start,mid)%1000000007;
        int right = MergeSort(array,temp,mid+1,end)%1000000007;
        int i = start;
        int j = mid + 1;
        int k = start;
        int count = 0;
        while(i <= mid && j <= end){
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                count += (mid-i+1);
                if(count > 1000000007){
                    count = count % 1000000007;
                }
                temp[k++] = array[j++];
            }
        }
        while(i <= mid ){
            temp[k++] = array[i++];
        }
        while(j <= end ){
            temp[k++] = array[j++];
        }
        for(i = start; i <= end; i++){
            array[i] = temp[i];
        }
        return (count + left + right) %1000000007;
    }


}
