package javaCollections.level_1.AbstractList_BigTask;

import java.util.List;                                                  

public class Solution  {                                                  
    public static void main(String[] args) {                                                  
        List<String> list = new CustomTree();
        
        for(int i = 1; i < 17; i++) {
        	list.add(String.valueOf(i));
        }
        
        for(int i = 4; i <= 6; i++) {
        	list.remove(String.valueOf(i));
        }
        list.remove(String.valueOf(7));
        list.remove(String.valueOf(8));
        list.add("19");
       
        System.out.println(((CustomTree) list).getParent("3"));
        System.out.println(((CustomTree) list).getParent("2"));
        /*list.remove("3");
        list.remove("4");
        list.remove("5");
        list.remove("6");
        list.add("16");
        list.add("119");
        list.add("18");
        list.add("17");
        list.add("22");
        //System.out.println(((CustomTree)list).root.leftChild.getElementName());
        System.out.println(((CustomTree) list).getParent("16"));
        System.out.println(((CustomTree) list).getParent("119"));
        System.out.println(((CustomTree) list).getParent("18"));
        System.out.println(((CustomTree) list).getParent("17"));
        System.out.println(((CustomTree) list).getParent("22"));
        System.out.println(list.size());
        list.remove("22");
        System.out.println(list.size());*/
        
        /*System.out.println(list.size());
        list.remove("7");
        System.out.println(list.size());*/
    }                                                  
}