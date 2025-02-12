package com.csc;
import java.util.Scanner;
import java.util.List;

public class Zipper {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the contents of the first list with a space between each element: ");
        String List_1_contents= in.nextString();
        String[] List1_elements = List_1_contents.split(" ");
        List <String> List1 = new ArrayList<>();

        for (String element : List1_elements)
        {
            List1.add(element);
        }
        
        System.out.print("Please enter the contents of the second list with a space between each element: ");
        String List_2_contents = in.nextString();
        List <String> List2= new ArrayList<>();
        String[] List2_elements = List_2_contents.split(" ");

        for ( String element2 : List2_elements)
        {
            List2.add(element2);
        }

        List <String> Combined_List = zip(List1, List2);

    }

    public static List <String> zip(List <String> List1, List <String> List2)
    {
        if (List1.size() == List2.size())
        {
            for (int index=0; index<List1.size()+List2.size(); index++)
            {
                if (index % 2 ==0)
                {
                    Combined_List.add(List1.get(index/2));
                }
                if (index % 2 !=0)
                {
                    Combined_List.add(List2.get(index/2));
                }
            }
        }
        else if (List1.size() != List2.size())
        {
            for (int index=0; index<List1.size()+List2.size(); index++)
            {
                if (index % 2 ==0)
                {
                    try {
                        Combined_List.add(List1.get(index/2));
                    
                } catch (IndexOutOfBoundsException e) {
                    Combined_List.addAll(List2.subList(index/2,List2.size()));
                }
                }

                else if (index % 2 !=0)
                {
                    try {
                        Combined_List.add(List2.get(index/2));
                    
                } catch (IndexOutOfBoundsException e) {
                    Combined_List.addAll(List1.subList(index/2,List1.size()));
                }
                }
            }
        }
        return Combined_List;
    }
}