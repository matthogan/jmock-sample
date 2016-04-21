/**
 * 
 */
package com.codejago.sample.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.JavaReflectionImposteriser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Basic JMock demos
 * 
 * @author codejago
 *
 */
public class TestMeTest
{
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     */
    @Test ( expected = IllegalArgumentException.class)
    public void blahIsNotAnInterfaceError()
    {
        Mockery context = new Mockery();

        context.setImposteriser( JavaReflectionImposteriser.INSTANCE );

        Collaborator collaborator = context.mock( Collaborator.class, "Imposterised" );
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     * 
     * @see http://www.jmock.org/mocking-classes.html
     */
    @Test
    public void blahIsNotAnInterfaceFix()
    {
        Mockery context = new Mockery();

        context.setImposteriser( ClassImposteriser.INSTANCE );

        Collaborator collaborator = context.mock( Collaborator.class, "Imposterised" );
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     * 
     * @see <a href="http://www.jmock.org/mocking-classes.html">Mocking classes</a>
     * @see <a href="http://www.jmock.org/cheat-sheet.html">Cheat sheet</a>
     */
    @Test
    public void testHitMeInstanceMember()
    {
        Mockery context = new Mockery();

        context.setImposteriser( ClassImposteriser.INSTANCE );

        final Collaborator instanceMember = context.mock( Collaborator.class, "Imposterised" );

        TestMe testMe = new TestMe();

        testMe.setInstanceMember( instanceMember );

        // set the expectations on the mocked object
        context.checking( new Expectations()
        {
            {
                // at least 0 calls to hello
                allowing( instanceMember ).hello();
                // overrides the hello response somehow
                will( returnValue( "Hello from mocked instanceMember" ) );
                // at least 1 call to hello
                atLeast( 1 ).of( instanceMember ).hello();
                // at most 1 call to hello
                atMost( 1 ).of( instanceMember ).hello();
                // exactly one call to hello
                oneOf( instanceMember ).hello();
            }
        } );

        testMe.hitMe();

        // context.assertIsSatisfied();
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     * 
     * @see <a href="http://www.jmock.org/mocking-classes.html">Mocking classes</a>
     * @see <a href="http://www.jmock.org/cheat-sheet.html">Cheat sheet</a>
     */
    @Test
    public void testHitMeStaticMember()
    {
        Mockery context = new Mockery();

        context.setImposteriser( ClassImposteriser.INSTANCE );

        final Collaborator staticMember = context.mock( Collaborator.class, "Imposterised" );

        TestMe testMe = new TestMe();

        TestMe.setStaticMember( staticMember );

        // set the expectations on the mocked object
        context.checking( new Expectations()
        {
            {
                // at least 0 calls to hello
                allowing( staticMember ).hello();
                // overrides the hello response somehow
                will( returnValue( "Hello from mocked staticMember" ) );
                // at least 1 call to hello
                atLeast( 1 ).of( staticMember ).hello();
                // at most 1 call to hello
                atMost( 1 ).of( staticMember ).hello();
                // exactly one call to hello
                oneOf( staticMember ).hello();
            }
        } );

        testMe.hitMe();

        // context.assertIsSatisfied();
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     * 
     * @see <a href="http://www.jmock.org/mocking-classes.html">Mocking classes</a>
     * @see <a href="http://www.jmock.org/cheat-sheet.html">Cheat sheet</a>
     */
    @Test ( expected = IllegalArgumentException.class)
    public void testThrowException()
    {
        Mockery context = new Mockery();

        context.setImposteriser( ClassImposteriser.INSTANCE );

        final Collaborator instanceMember = context.mock( Collaborator.class, "Imposterised" );

        TestMe testMe = new TestMe();

        testMe.setInstanceMember( instanceMember );

        // set the expectations on the mocked object
        context.checking( new Expectations()
        {
            {
                // at least 0 calls to hello
                allowing( instanceMember ).hello();
                // overrides the hello response somehow
                will( throwException( new IllegalArgumentException( "Exception from JMock" ) ) );
            }
        } );

        testMe.hitMe();
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     * 
     * @see <a href="http://www.jmock.org/mocking-classes.html">Mocking classes</a>
     * @see <a href="http://www.jmock.org/cheat-sheet.html">Cheat sheet</a>
     */
    @Test
    public void testAllExpectationsSatisfied()
    {
        Mockery context = new Mockery();

        context.setImposteriser( ClassImposteriser.INSTANCE );

        final Collaborator instanceMember = context.mock( Collaborator.class, "Imposterised" );

        TestMe testMe = new TestMe();

        testMe.setInstanceMember( instanceMember );

        // set the expectations on the mocked object
        context.checking( new Expectations()
        {
            {
                // at least 0 calls to hello
                allowing( instanceMember ).hello();
                // overrides the hello response somehow
                will( returnValue( "Hello from mocked staticMember" ) );
            }
        } );

        testMe.hitMe();

        context.assertIsSatisfied();
    }

    /**
     * Test method for {@link com.codejago.sample.jmock.TestMe#hitMe()}.
     * 
     * @see org.hamcrest.core.IsEqual
     * @see <a href="http://www.jmock.org/matchers.html">Matchers</a>
     */
    @Test
    public void testWithHamcrestMatchers()
    {
        Mockery context = new Mockery();

        context.setImposteriser( ClassImposteriser.INSTANCE );

        final Collaborator instanceMember = context.mock( Collaborator.class, "Imposterised" );

        TestMe testMe = new TestMe();

        testMe.setInstanceMember( instanceMember );

        // set the expectations on the mocked object
        context.checking( new Expectations()
        {
            {
                // exactly one call to hello with a particular parameter value
                oneOf( instanceMember ).hello( with( equal( "Hello from TestMe" ) ) );
                // overrides the hello response somehow
                will( returnValue( "Hello from TestMe" ) );
            }
        } );

        Assert.assertEquals( "Hello from TestMe", testMe.getInstanceMemberHello() );

        context.assertIsSatisfied();
    }
}
