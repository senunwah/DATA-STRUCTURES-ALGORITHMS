/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structures.algorithms;

class Node{
    public int data;
    public Node left;
    public Node right;
    
    public Node(int value){
        data = value;
        left = right = null;
    }
    
    public void Insert(int x){
        if (x < data){
            if (left == null){
                left = new Node(x);
            }else{
                left.Insert(x);
            }
        }
        else{
            if (right == null){
                right = new Node(x);            
            }
            else{
                right.Insert(x);
            }
        }
    }
}

public class BinaryTree {

    Node root;
    
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.Add(4);
        b.Add(3);
        b.Add(10);
        b.Add(9);
        b.Add(17);
        System.out.println("PreOrder Traversal");
        b.PreOrder();
        System.out.println("InOrder Traversal");
        b.InOrder();
        System.out.println("PostOrder Traversal");
        b.PostOrder();
    }
    
    public void Add(int x){
        if (root == null){
            root = new Node(x);
        }
        else{
            root.Insert(x);
        }
    }
    
    public void _inOrder(Node y)
        {
            if(y != null)
            {
                _inOrder(y.left);
                System.out.println(y.data);
                _inOrder(y.right);
            }
        }

        public void InOrder()
        {
            _inOrder(root);
        }

    
    public void _preorder(Node y){
        if (y != null){
            System.out.println(y.data);
            _preorder(y.left);
            _preorder(y.right);
        }
    }
    
    public void PreOrder(){
        _preorder(root);
    }
    
    public void _postOrder(Node y)
        {
            if(y != null)
            {            
                _postOrder(y.left);
                _postOrder(y.right);
                System.out.println(y.data);
            }
        }

        public void PostOrder()
        {
            _postOrder(root);
        }
    
}
