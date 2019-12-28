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
* CLASS:LinkedList
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Every instance of the linked list class is a node that is used to make the Linked List ADT
*****************************************************/
public class LinkedList 
{
    int x;
    int y;
    LinkedList next;
    //Constructor for the start of the linked list
    LinkedList(int x, int y)
    {
        this.x =x;
        this.y= y;
        this.next = null;
    }
    //Constructor for the rest of the nodes
    LinkedList (int x, int y, LinkedList m1)
    {
        this.x = x;
        this.y=y;
        m1.next = this;
    }
/**************************************************
* FUNCTION: getX
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Returns the value of the x coordinate for the node
* Inputs: None
* Outputs:x coordinate of node
*****************************************************/
    int getX()
    {
        return x;
    }
/**************************************************
* FUNCTION: getY
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Returns the value of the y coordinate for the node
* Inputs: None
* Outputs:y coordinate of the node 
*****************************************************/
    int getY()
    {
        return y;
    }
}
