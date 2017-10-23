
import java.util.ArrayList;
import java.util.HashSet;

public class Ancestors {
    public static boolean hasAncestors(ArrayList<ArrayList<Integer>> adjList, int nodeA, int nodeB){
        HashSet<Integer> ancestA = new HashSet<>();
        HashSet<Integer> ancestB = new HashSet<>();

        getAncestors(adjList, nodeA, ancestA);
        getAncestors(adjList, nodeB, ancestB);

        if(ancestA.isEmpty() || ancestB.isEmpty()){
            return false;
        }
        for(int ancestor : ancestA){
            if(ancestB.contains(ancestor)){
                return true;
            }
        }
        return false;
    }
    public static void getAncestors(ArrayList<ArrayList<Integer>> adjList, int node, HashSet<Integer> ancestors){
        int parent = 0;
        for(ArrayList<Integer> pair : adjList) {
            if(pair.get(1) == node) {
                parent = pair.get(0);
                ancestors.add(parent);
                getAncestors(adjList, parent, ancestors);
            }
        }
        for(ArrayList<Integer> pair : adjList) {
            if(pair.get(1) == node && !ancestors.contains(pair.get(0))) {
                parent = pair.get(0);
                ancestors.add(parent);
                getAncestors(adjList, parent, ancestors);
            }
        }
    }
    public static void main(String[] args) {
        boolean foundAncest = false;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> singleList = new ArrayList<>();
        singleList.add(1);
        singleList.add(2);
        adjList.add(singleList);
        ArrayList<Integer> singleList1 = new ArrayList<>();
        singleList1.add(2);
        singleList1.add(3);
        adjList.add(singleList1);
        ArrayList<Integer> singleList2 = new ArrayList<>();
        singleList2.add(3);
        singleList2.add(4);
        adjList.add(singleList2);
        ArrayList<Integer> singleList3 = new ArrayList<>();
        singleList3.add(4);
        singleList3.add(6);
        adjList.add(singleList3);
        ArrayList<Integer> singleList4 = new ArrayList<>();
        singleList4.add(5);
        singleList4.add(6);
        adjList.add(singleList4);
        ArrayList<Integer> singleList5 = new ArrayList<>();
        singleList5.add(2);
        singleList5.add(7);
        adjList.add(singleList5);
        ArrayList<Integer> singleList6 = new ArrayList<>();
        singleList6.add(7);
        singleList6.add(8);
        adjList.add(singleList6);
        ArrayList<Integer> singleList7 = new ArrayList<>();
        singleList7.add(8);
        singleList7.add(9);
        adjList.add(singleList7);
        ArrayList<Integer> singleList8 = new ArrayList<>();
        singleList8.add(9);
        singleList8.add(10);
        adjList.add(singleList8);
        ArrayList<Integer> singleList9 = new ArrayList<>();
        singleList9.add(10);
        singleList9.add(Integer.MAX_VALUE);
        adjList.add(singleList9);
        ArrayList<Integer> singleList10 = new ArrayList<>();
        singleList10.add(12);
        singleList10.add(Integer.MAX_VALUE);
        adjList.add(singleList10);
        ArrayList<Integer> singleList11 = new ArrayList<>();
        singleList11.add(13);
        singleList11.add(7);
        adjList.add(singleList11);
        ArrayList<Integer> singleList12 = new ArrayList<>();
        singleList12.add(14);
        singleList12.add(5);
        adjList.add(singleList12);
        ArrayList<Integer> singleList13 = new ArrayList<>();
        singleList13.add(15);
        singleList13.add(5);
        adjList.add(singleList13);
        ArrayList<Integer> singleList14 = new ArrayList<>();
        singleList14.add(16);
        singleList14.add(10);
        adjList.add(singleList14);
        ArrayList<Integer> singleList15 = new ArrayList<>();
        singleList15.add(17);
        singleList15.add(9);
        adjList.add(singleList15);
        ArrayList<Integer> singleList16 = new ArrayList<>();
        singleList16.add(18);
        singleList16.add(8);
        adjList.add(singleList16);
        ArrayList<Integer> singleList17 = new ArrayList<>();
        singleList17.add(19);
        singleList17.add(18);
        adjList.add(singleList17);
        ArrayList<Integer> singleList18 = new ArrayList<>();
        singleList18.add(20);
        singleList18.add(18);
        adjList.add(singleList18);

        foundAncest = hasAncestors(adjList, 6, Integer.MAX_VALUE);
        System.out.println(foundAncest);
    }
}
