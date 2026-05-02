package DS.trees;

import java.util.ArrayList;
import java.util.List;

/**
Dfs inorder iterative

Dfs inorder recursive

Dfs preorder iterative

Dfs preorder recursive

Dfs postorder iterative

Dfs postorder recursive

Bfs
*/
public class TreeNode{
    private int value;
    private List<TreeNode> children;

    //-- constructor to create a leaf with no children
    public TreeNode(int value){
        this.value = value;
        this.children = new ArrayList<>();
    }

    //-- adds a child to this node and return that child
    public TreeNode addChild(int value){
        TreeNode child = new TreeNode(value);
            this.children.add(child);
        return child;
    }
    
    
    //--add an existing node as a child
    public void addChild(TreeNode child){
        this.children.add(child);
    }
    
}
