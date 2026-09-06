```java
import java.util.*;

// ============================================================
// 1. FREQUENCY USING HASHMAP
// ============================================================

class Frequency
{
    public static void main(String A[])
    {
        int Arr[] = {10, 20, 10, 30, 20, 10};

        HashMap<Integer, Integer> hobj =
            new HashMap<Integer, Integer>();

        for(int value : Arr)
        {
            hobj.put(value, hobj.getOrDefault(value, 0) + 1);
        }

        for(int value : hobj.keySet())
        {
            System.out.println(value + " -> " + hobj.get(value));
        }
    }
}


// ============================================================
// 2. DUPLICATE DETECTION USING HASHSET
// ============================================================

class Duplicate
{
    public static void main(String A[])
    {
        int Arr[] = {10, 20, 30, 20, 40};

        HashSet<Integer> hobj = new HashSet<Integer>();

        for(int value : Arr)
        {
            if(!hobj.add(value))
            {
                System.out.println("Duplicate : " + value);
            }
        }
    }
}


// ============================================================
// 3. PAIR + TARGET USING HASHSET
// ============================================================

class PairTarget
{
    public static void main(String A[])
    {
        int Arr[] = {1200, 500, 700, 300, 1500};
        int Target = 2000;

        HashSet<Integer> hobj = new HashSet<Integer>();

        for(int value : Arr)
        {
            int required = Target - value;

            if(hobj.contains(required))
            {
                System.out.println(
                    required + " + " + value + " = " + Target);

                break;
            }

            hobj.add(value);
        }
    }
}


// ============================================================
// 4. FIRST NON-REPEATING CHARACTER USING HASHMAP
// ============================================================

class FirstNonRepeating
{
    public static void main(String A[])
    {
        String str = "swiss";

        HashMap<Character, Integer> hobj =
            new HashMap<Character, Integer>();

        // Pass 1: Count frequency
        for(char ch : str.toCharArray())
        {
            hobj.put(ch, hobj.getOrDefault(ch, 0) + 1);
        }

        // Pass 2: Find first character with frequency 1
        for(char ch : str.toCharArray())
        {
            if(hobj.get(ch) == 1)
            {
                System.out.println(
                    "First non-repeating character : " + ch);

                break;
            }
        }
    }
}


// ============================================================
// 5. GROUP EMPLOYEES DEPARTMENT-WISE
// ============================================================

class GroupEmployees
{
    public static void main(String A[])
    {
        HashMap<String, ArrayList<String>> hobj =
            new HashMap<String, ArrayList<String>>();

        // Amit → IT
        if(hobj.containsKey("IT"))
        {
            hobj.get("IT").add("Amit");
        }
        else
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add("Amit");
            hobj.put("IT", list);
        }

        // Rahul → HR
        if(hobj.containsKey("HR"))
        {
            hobj.get("HR").add("Rahul");
        }
        else
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add("Rahul");
            hobj.put("HR", list);
        }

        // Pooja → IT
        hobj.get("IT").add("Pooja");

        // Neha → Finance
        if(hobj.containsKey("Finance"))
        {
            hobj.get("Finance").add("Neha");
        }
        else
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add("Neha");
            hobj.put("Finance", list);
        }

        // Kiran → HR
        hobj.get("HR").add("Kiran");

        // Riya → IT
        hobj.get("IT").add("Riya");

        // Display
        for(String key : hobj.keySet())
        {
            System.out.println(key + ":");

            for(String name : hobj.get(key))
            {
                System.out.println(name);
            }

            System.out.println();
        }
    }
}


// ============================================================
// 6. TOP-K FREQUENCY USING HASHMAP + PRIORITYQUEUE
// ============================================================

class TopKFrequency
{
    public static void main(String A[])
    {
        int Arr[] = {10, 20, 10, 30, 20, 10, 40, 20};

        int K = 2;

        // Calculate frequency
        HashMap<Integer, Integer> hobj =
            new HashMap<Integer, Integer>();

        for(int value : Arr)
        {
            hobj.put(value, hobj.getOrDefault(value, 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<Map.Entry<Integer, Integer>>(
                (e1, e2) -> e1.getValue() - e2.getValue()
            );

        // Add entries and maintain only K elements
        for(Map.Entry<Integer, Integer> entry : hobj.entrySet())
        {
            pq.offer(entry);

            if(pq.size() > K)
            {
                pq.poll();
            }
        }

        // Display Top K
        while(!pq.isEmpty())
        {
            Map.Entry<Integer, Integer> entry = pq.poll();

            System.out.println(
                entry.getKey() + " -> " + entry.getValue());
        }
    }
}

//operations performed
Frequency
Duplicate
PairTarget
FirstNonRepeating
GroupEmployees
TopKFrequency
