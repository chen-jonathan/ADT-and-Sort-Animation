/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

/**
 *
 * @author 333618338
 */
/**************************************************
* CLASS: Node
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:Class for each node in the Binary Tree
*****************************************************/
public class Node 
{
    Node left; 
    Node right;
    int data;
    //constructor for root of the tree
    Node(int data)
    {
        this.left = null;
        this.right = null;
        this.data = data;        
    }
    //constructor for the rest of the nodes
    Node (Node l, Node r, int data)
    {
        this.left = l;
        this.right = r;
        this.data = data;     
    }
/**************************************************
* FUNCTION: getData
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:return the value of the data of the node
* Inputs: None 
* Outputs: return int data
*****************************************************/
    int getData()
    {
        return data;
    }
/**************************************************
* FUNCTION: getLeft
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:return the left node
* Inputs: None 
* Outputs: return node to left
*****************************************************/
    Node getLeft()
    {
        return left;//returns the node to the left of a specific referanace 
    }
/**************************************************
* FUNCTION: getRight
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:return the right node
* Inputs: None 
* Outputs: return node to right
*****************************************************/
    Node getRight()
    {
        return right;
    }
/**************************************************
* FUNCTION: setData
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:set the value of the data of the node
* Inputs: int data (value we want to set data too)
* Outputs: None
*****************************************************/
    void setData(int data)
    {
        this.data = data;
    }
/**************************************************
* FUNCTION: setLeft
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:set the left of a node
* Inputs: None n (node we want to add)
* Outputs: None
*****************************************************/
    void setLeft (Node n)
    {
        left = n; 
    }
/**************************************************
* FUNCTION: setRight
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:set the right of a node
* Inputs: None n (node we want to add)
* Outputs: None
*****************************************************/
    void setRight (Node n)
    {
        right = n;
    }    
}
