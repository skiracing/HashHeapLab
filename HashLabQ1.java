public class HashLabQ1 {

private int [] set;
private int size;
final int removed = -999;

HashLabQ1() {
set = new int [33];
size = 0;
}

private int hash (int i) {
return Math.abs(i) % set.length;
}

public void add (int i) {
if((double) size/ set.length >= 0.75) {rehash();}
int h = hash(i);
while(set[h] != 0 && set[h] != i) {
h = (h+1)%set.length;
}
if(set[h] != i) {
set[h] = i;
size++;
}
}


public void remove (int i) {
int h = hash(i);
while(set[h] != 0 && set[h] != i) {
h = (h+1)%set.length;
}
if(set[h] == i) {set[h] = removed;
size--;}
}


public boolean contains (int i) {
int h = hash(i);
while(set[h] != 0 && set[h] != i) {
h = (h+1)%set.length;
}
return set[h] == i;
}

private void rehash () {
int [] old = set;
set = new int [2*old.length];
size = 0;
for (int i : old) {
if(i != 0 && i != removed) {
add(i);
}
}
}

public void print() {
int [] toPrint = new int[size];
int i = 0;
int next = 0;
while(i< set.length) {
if(set[i] != 0 && set[i] != removed) {
toPrint[next] = set[i];
next++;}
i++;
}
System.out.print(java.util.Arrays.toString(toPrint));
}

}