import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Zipper {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the contents of the first list with a space between each element: ");
        String List_1_contents= in.nextLine();
        String[] List1_elements = List_1_contents.split(" ");
        ArrayList <String> List1 = new ArrayList<>();

        for (String element : List1_elements)
        {
            List1.add(element);
        }
        
        System.out.print("Please enter the contents of the second list with a space between each element: ");
        String List_2_contents = in.nextLine();
        ArrayList <String> List2= new ArrayList<>();
        String[] List2_elements = List_2_contents.split(" ");

        for ( String element2 : List2_elements)
        {
            List2.add(element2);
        }

        ArrayList <String> Combined_List = zip(List1, List2);
        System.out.print(Combined_List);
        in.close();

    }

    public static ArrayList <String> zip(List <String> List1, List <String> List2)
    {
        ArrayList<String> Combined_List = new ArrayList<>();
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
        else if (List1.size() > List2.size())
        {
            for (int index=0; index<List1.size()+List2.size(); index++)
            {
                if (index % 2 ==0)
                {
                    try {
                        Combined_List.add(List1.get(index/2));
                    
                } catch (IndexOutOfBoundsException e) {
                    Combined_List.addAll(List2.subList(1+(index/2),List2.size()));
                    break;
                }
                }

                else if (index % 2 !=0)
                {
                    try {
                        Combined_List.add(List2.get(index/2));
                    
                } catch (IndexOutOfBoundsException e) {
                    Combined_List.addAll(List1.subList(1+(index/2),List1.size()));
                    break;
                }
                }
            }
        }
        else if (List1.size() < List2.size())
        {
            for (int index=0; index<List1.size()+List2.size(); index++)
            {
                if (index % 2 ==0)
                {
                    try {
                        Combined_List.add(List1.get(index/2));
                    
                } catch (IndexOutOfBoundsException e) {
                    Combined_List.addAll(List2.subList((index/2),List2.size()));
                    break;
                }
                }

                else if (index % 2 !=0)
                {
                    try {
                        Combined_List.add(List2.get(index/2));
                    
                } catch (IndexOutOfBoundsException e) {
                    Combined_List.addAll(List1.subList((index/2),List1.size()));
                    break;
                }
                }
            }
        }
        return Combined_List;
    }
}