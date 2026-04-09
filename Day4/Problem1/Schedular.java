//Course Schedular Order
//Real: course completion order in a university
//Problem: Given a course (0 to n-1) and prerequisites, return a valid order.
//Kahn's Algorithm- BFS
//Sort graph using Toposort

package Day4.Problem1;
import java.util.*;

//ArrayList / Queue / LinkedList

public class Schedular
{
    public static void main(String[] args)
    {
        //n --> number of nodes (0 to n-1)
        int n = 4;

        //Prerequisites -> edges (dependencies)
        //Meaning : 0 --> 1, 0 --> 2, 1 --> 3, 2 --> 3

        int [][] prereq = {{1, 2}, {2,0} ,{3,1}};

        System.out.println(topoSort(n, prereq));
    }

    //Function to perform topological sort using Kahn's Algorithm

    static List<Integer> topoSort(int n, int [][] prereq)
    {
        //Create Graph 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            graph.add(new ArrayList<>());
        }
        //Indegree Array
        int [] indegree = new int[n];

        //Build Graph and Indegree Array
        //for each pair (a,b)
        //b --> a (b must be completed before a)

        for(int[] p : prereq)
        {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        //for input - {1,0}, {2,0}, {3,1}, {3,2}
        //graph - 0 --> [1, 2], 1 --> [3], 2 --> [3] 3 --> []
        //indegree - [0, 1, 1, 2]

        //Kahn's Algorithm

        //Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        //Add all nodes with indegree 0 to the queue
        for(int i=0; i<n; i++)
        {
            //nodes with zero dependencies can be processed first
            if(indegree[i] == 0)
            {
                q.add(i);
                //queue initially --> 0
            }
        }

        //Result set
        //Storesfinal topological order of courses

        List<Integer> result = new ArrayList<>();

        //Main BFS Loop
        while(!q.isEmpty())
        {

            //Remove a node from the queue
            //take node with indegree 0 and add it to the result

            int current = q.poll();

            //add to result: This is valid next node in order
            result.add(current);

            //Process neighbours
            //Go through all nodes dependent on current node (neighbors in graph)

            for(int neighbor : graph.get(current))
            {
                //Reduce indegree of neighbor by 1 (one less dependency to process)
                //Dependency is now resolved for this neighbor

                indegree[neighbor]--;

                //Add new independent nodes, if no dependencies left, add to queue for processing
                if(indegree[neighbor] == 0)
                {
                    q.add(neighbor);
                }
            }
        }

        return result;
    }
}