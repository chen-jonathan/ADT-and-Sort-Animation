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
* CLASS:Queue
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Every instance of the queue class is a node that is used to make the Queue ADT
*****************************************************/
public class Queue 
{
    Queue link;
    int x;
    int y;
    //constructor for the first node in the queue 
    Queue (int x, int y)
    {
        this.x = x;
        this.y =y;
        this.link = null;
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
