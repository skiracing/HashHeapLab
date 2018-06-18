import java.util.Arrays;

public class HashLabQ2 {

private int [] origArray = {-6, 50, 11, 25, 42, 20, 104, 76, 19, 55, 88, 2};
private int [] binaryTree;
private int size;

HashLabQ2() {
binaryTree = new int [origArray.length+1];
int next =1;
size = origArray.length;
for(int i : origArray) {
binaryTree[next] = i;
next++;
}
System.out.println("The original binary tree is: " + java.util.Arrays.toString(origArray));
buildMinHeap();
System.out.println("The original array in min-heap tree is as follows: " + java.util.Arrays.toString(binaryTree));
System.out.println("");
for(int i = 0; i< origArray.length; i++) {
origArray[i] = remove();
int step = i +1;
System.out.println("The arrays after step " + step + ":");
System.out.println("Original array being re-sorted: " + java.util.Arrays.toString(origArray));
System.out.println("Binary Tree Array after each remove operation: " + 
java.util.Arrays.toString(java.util.Arrays.copyOf(binaryTree,binaryTree.length-i-1)));
System.out.println("");
}
}

private int left (int i) {
return i*2;
}

private int right (int i) {
return (2*i)+1;
}

private void swap (int origLoc, int newLoc) {
int temp = binaryTree[origLoc];
binaryTree[origLoc] = binaryTree[newLoc];
binaryTree[newLoc] = temp;
}

private void buildMinHeap() {
buildMinHeap(binaryTree);

}

private void buildMinHeap (int [] binaryTree) {
for (int i = size/2; i>=1; i--) {
minHeapify(binaryTree, i);}
}

private void minHeapify(int [] arr, int i) {
int l = left(i);
int r = right(i);
int smallest = i;
if (l<= size && arr[l]<arr[i]) {
smallest = l;
}
else {smallest = i;}
if(r<= size && arr[r]< arr[smallest]) {smallest = r;}
if(i != smallest) {swap(i,smallest);
minHeapify(arr,smallest);}
}

private int remove () {
int result = binaryTree[1];
binaryTree[1]=binaryTree[size];
size--;
minHeapify(binaryTree,1);
return result;
}
}