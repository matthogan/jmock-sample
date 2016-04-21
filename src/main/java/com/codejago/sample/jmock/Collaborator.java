/**
 * 
 */
package com.codejago.sample.jmock;

/**
 * @author matto
 *
 */
public class Collaborator
{
    /** */
    private String message = "Default hello";

    /**
     * 
     */
    public Collaborator( String message )
    {
        this.message = message;
    }

    /**
     * @return
     */
    public String hello()
    {
        return message;
    }

    /**
     * @return
     */
    public String hello( String message )
    {
        return message;
    }
}
