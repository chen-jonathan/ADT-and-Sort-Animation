/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

/**
 *
 * @author Jace
 */
/**************************************************
* CLASS:Stack
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Every instance of the stack class is a node that is used to make the Stack ADT
*****************************************************/
public class Stack 
{
    Stack link;   
    int x;
    int y;
    //Constructor for the first node in the stack
    Stack(int x, int y)
    {
        this.x = x;
        this.y = y;
        link = null;
    }
    //Constructor for the rest of the nodes on the stack 
    Stack(int x, int y, Stack top)
    {
        this.x = x;
        this.y =y;
        this.link = top;
        
    }
/**************************************************
* FUNCTION: getX
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Returns the value of the x coordinate for the node
* Inputs: None
* Outputs:x coordinate of the node 
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
