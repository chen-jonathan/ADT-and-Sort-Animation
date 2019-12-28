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
* CLASS: Bars
* NAME: Jonathan Chen
* Date: June 11th, 2019
* Description:Class for the bar objects used in the sorts
*****************************************************/
public class Bars 
{
    int x;
    int y;
    public int length; 
    int width;
    //Constructor 
    Bars (int x, int y, int length, int width)
    {
        this.x=x;
        this.y =y;
        this.length = length;
        this.width = width;
    }
/**************************************************
* FUNCTION: getLength
* NAME: Jonathan Chen
* Date: June 11th, 2019
* Description:Return the Length of the bar
* Inputs:none
* Outputs:length of the bar
*****************************************************/
    int getLength()
    {
        return length;
    }
/**************************************************
* FUNCTION: getX
* NAME: Jonathan Chen
* Date: June 11th, 2019
* Description:Return the x coordinate of the bar
* Inputs:none
* Outputs:x coordinate of the bar
*****************************************************/
    int getX()
    {
        return x;
    }
/**************************************************
* FUNCTION: getY
* NAME: Jonathan Chen
* Date: June 11th, 2019
* Description:Return the y coordinate of the bar
* Inputs:none
* Outputs:y coordinate of the bar
*****************************************************/
    int getY()
    {
        return y;
    }
/**************************************************
* FUNCTION:setLength
* NAME: Jonathan Chen
* Date: June 11th, 2019
* Description:change the length of the bar
* Inputs:int length
* Outputs: none
*****************************************************/
    void setLength(int length)
    {
        this.length = length;
    }
}
