package com.codejago.sample.jmock;

/**
 * Hello world!
 *
 */
public class TestMe
{
    private Collaborator instanceMember = new Collaborator( "Hello from instanceMember" );

    private static Collaborator staticMember = new Collaborator( "Hello from staticMember" );

    private static final Collaborator STATIC_FINAL_MEMBER = new Collaborator( "Hello from STATIC_FINAL_MEMBER" );

    /**
     * Simple public interface
     */
    public void hitMe()
    {
        System.out.println( instanceMember.hello() );

        System.out.println( staticMember.hello() );

        System.out.println( STATIC_FINAL_MEMBER.hello() );
    }

    /**
     * @return
     */
    public String getInstanceMemberHello()
    {
        return instanceMember.hello( "Hello from TestMe" );
    }

    /**
     * @return the instanceMember
     */
    public Collaborator getInstanceMember()
    {
        return instanceMember;
    }

    /**
     * @param instanceMember
     *            the instanceMember to set
     */
    public void setInstanceMember( Collaborator instanceMember )
    {
        this.instanceMember = instanceMember;
    }

    /**
     * @return the staticMember
     */
    public static Collaborator getStaticMember()
    {
        return staticMember;
    }

    /**
     * @param staticMember
     *            the staticMember to set
     */
    public static void setStaticMember( Collaborator staticMember )
    {
        TestMe.staticMember = staticMember;
    }

    /**
     * @return the staticFinalMember
     */
    public static Collaborator getStaticFinalMember()
    {
        return STATIC_FINAL_MEMBER;
    }
}
