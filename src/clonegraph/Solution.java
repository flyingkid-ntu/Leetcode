package clonegraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if (node == null) {
			return null;
		}
        UndirectedGraphNode n = new UndirectedGraphNode (node.label);
        HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode> ();
        nodeMap.put(new Integer(n.label), n);
        ArrayList<UndirectedGraphNode> nodeStack = new ArrayList<UndirectedGraphNode> ();
        nodeStack.add(node);
        while (!nodeStack.isEmpty()) {
        	UndirectedGraphNode topOrignial = nodeStack.remove(0);
        	UndirectedGraphNode top = nodeMap.get(new Integer(topOrignial.label));
        	for (UndirectedGraphNode ugn : topOrignial.neighbors) {
        		if (!nodeMap.containsKey(new Integer(ugn.label))) {
        			UndirectedGraphNode newNode = new UndirectedGraphNode(ugn.label);
        			nodeMap.put(new Integer(newNode.label), newNode);
        			nodeStack.add(ugn);
        			top.neighbors.add(newNode);
        		} else {
        			UndirectedGraphNode eNode = nodeMap.get(new Integer(ugn.label));
        			top.neighbors.add(eNode);
        		}
        	}
        }
        
        return n;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode n = new UndirectedGraphNode(0);
		n.neighbors.add(n);
		n.neighbors.add(n);
		Solution s = new Solution();
		UndirectedGraphNode nn = s.cloneGraph(n);
		System.out.print(nn.label + ",");
		for (UndirectedGraphNode ugn : nn.neighbors) {
			System.out.print(ugn.label + ",");
		}
		System.out.println();
	}

}
