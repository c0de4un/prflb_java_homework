/**
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ``AS
* IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
* PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL COPYRIGHT HOLDERS OR CONTRIBUTORS
* BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
* SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
* INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
* CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
* ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.
**/

package org.bitbucket.code4un.prflb.lines;

//-----------------------------------------------------------

// ===========================================================
// IMPORT
// ===========================================================

import org.bitbucket.code4un.prflb.math.Line2d;
import org.bitbucket.code4un.prflb.math.Point2d;

// ===========================================================
// TYPES
// ===========================================================

/**
 * DesktopLauncher - entry-point.
 * Designed mainly to allow desktop launch of app.
 * 
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class DesktopLauncher
{
	// -----------------------------------------------------------
	
	// ===========================================================
	// CONSTANTS
	// ===========================================================
	
	// ===========================================================
	// FIELDS
	// ===========================================================
	
	// ===========================================================
	// CONSTRUCTORS
	// ===========================================================
	
	// ===========================================================
	// GETTERS & SETTERS
	// ===========================================================
	
	// ===========================================================
	// METHODS
	// ===========================================================
	
	/**
	 * Callable entry-point method (function). <b>\^_^/</b>
	 * 
	 * @thread_safety - obviously, main-thread only.
	 * @param pArgs - cmd args. Not used.
	 * @throws - can throw exceptions.
	**/
	public static void main(String[] pArgs)
	{ // @TODO DesktopLauncher.main
		System.out.println( "<< = = = = = = = = = = = = = = = = = = = = = = = = = = = =\n\n"
				+ "\\^o^/ Welcome to AtomiX Geometry Tester v0.1.1a\n"
				+ "0_o Test-Cast: Compare 2 geometry lines on orthographical surface, using pre-defined values.\n"
				+ "-_- Input values: Line1: <1;1 to 2;2>; Line2: <-3;0 to 1;1>.\n"
				+ "~_- Result:" );
		
		// Guarded-Block
		try
		{
			// Create Lines
			Line2d line1 = new Line2d( new Point2d( 1, 1 ), new Point2d( 2, 2 ), false );
			Line2d line2 = new Line2d( new Point2d( -3, 0 ), new Point2d( 1, 1 ), false );
			
			// Check len.
			if ( Line2d.IsLengthEqual( line1, line2 ) )
				System.out.println( "Line1 have EXACT the same length as Line2." );
			else
				System.out.println( "Line1 have DIFFERENT length then Line2 does." );
		}
		catch( Exception pException )
		{
			System.out.println( "X_X ERROR=" + pException.getMessage( ) + "\n Test-Case: FAILED, have a nice day\n =^_^=" );
			System.exit( -1 );
		}
		
		System.out.println( "Test-Case COMPLETE ! Have a nice wonderfull day !\n =^_^=\n\n>> = = = = = = = = = = = = = = = = = = = = = = = = = = = =" );
		
		//MidDouble double_ = new MidDouble( 5.9 );
		//System.out.println( "1 = " + double_.getNumerator( ) + ", 2 = " + double_.getDenominator( ) );
		//org.bitbucket.code4un.prflb.math.MidDouble double_ = new org.bitbucket.code4un.prflb.math.MidDouble(0, 0);
		//if ( double_.getDenominator() == 0 ) // Знаменатель дроби нулевой.
			//return;
		
	}
	
	// -----------------------------------------------------------
} /// DesktopLauncher

//-----------------------------------------------------------