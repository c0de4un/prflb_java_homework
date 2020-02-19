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

package io.github.c0de4un.prflb.integral;

//-----------------------------------------------------------

//===========================================================
// IMPORTS
//===========================================================

import java.util.Scanner;

import io.github.c0de4un.prflb.math.IRectangularIntegral;
import io.github.c0de4un.prflb.math.Line;

//===========================================================
// TYPES
//===========================================================

/**
 * DefaultLauncher - entry class for app.
 * 
 * @version 0.1
 * @since 18.02.2020
 * @author Denis Z. (code4un@yandex.ru)
**/
public final class DefaultLauncher
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/** main. **/
	public static void main( String[] pArgs )
	{
		
		// INFO
		System.out.println( "Welcom to \"Integral by Rectangular-Method\" test.\n\n"
				+ "Please enter the valid numbers: DOUBLE, DOUBLE, INTEGER"
				+ "(!) INTEGER is a precision-value. 1 is the lowest precision, 1000 is the highest.\n"
				+ "For example, to find the 100% (1 - 10, 10 is 100%) use 1000 value."
				+ "rectangle-method (right or left)." );
		
		// Scanner for Console I/O
		Scanner scanner = null;
		
		// Guarded-Block
		try
		{
			// Scanner for Input 
			scanner = new Scanner( System.in );
			
			// Read user input.
			final String inData = scanner.nextLine( );
			
			// Split to args.
			final String[] strValues = inData.split( " " );
			
			// Get Double-vals for X#0 & X#1.
			final double x0 = Double.parseDouble( strValues[0] );
			final double x1 = Double.parseDouble( strValues[1] );
			
			// Get Step as double (high precision float).
			final double num = Double.parseDouble( strValues[2] );
			
			//
			Line line = new Line( );
			IRectangularIntegral<Double, Double> integralRightRect = ( a, b, n ) -> {
				
				double result = 0.0;
				double h = (b - a) / n;
				
				for( double i = 0; i < n; i += h )
				{// 1.0 - right, 0.0 - left. 0.5 middle.
					result += a + ( h * (i * 1.0) ); // result += myFunc(a + h * (i * 1.0));
				}
				
				return (result * h) + 1;
			};
			
			//
			final double integralResult = line.integrate( integralRightRect, x0, x1, num);
			
			// INFO
			System.out.println( "Integrate result for integral using right rectangle-method = " + integralResult + "\n\n"
					+ "Press any key to exit . . ." );
		}
		catch( Exception criticalException )
		{
			System.out.println( "unexpected error: " + criticalException.getMessage( ) );
			System.exit( -1 );
		}
		finally
		{
			if ( scanner != null )
				scanner.close( );
		}
		
	}
	
	//-----------------------------------------------------------
	
} /// DefaultLauncher

//-----------------------------------------------------------