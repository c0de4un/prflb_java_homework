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

package com.pflb.atchool;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

//-----------------------------------------------------------

//===========================================================
// INCLUDES
//===========================================================

/**
 * Default entry-point class.
 * 
 * @author Denis Z. (code4un@yandex.ru)
 * @version 0.1
 * @since 18.02.2020
 */
public final class DefaultLauncher
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/** This is main. 
	 * @throws URISyntaxException **/
	public static void main( String[] pArgs ) throws URISyntaxException
	{
		
		// INFO
		System.out.println( "Welcome to Exceptions Throw Test." );
		
		//
		for( byte err0_t = 1; err0_t < ExceptionCatching.URI_SYNTAX_EXCEPTION_TYPE; err0_t++ )
		{
			if ( err0_t == ExceptionCatching.ARITHMETIC_EXCEPTION_TYPE || err0_t == ExceptionCatching.URI_SYNTAX_EXCEPTION_TYPE )
			{// Ignore ArithmeticException & URISyntaxException
				try{ ExceptionCatching.catchMe( err0_t ); }
				catch( RuntimeException rtException ) {  }
				catch( Exception ignoreException ) {  }
			}
			else {
			try
			{
				ExceptionCatching.catchMe( err0_t );
			}
			catch( FileNotFoundException fioException )
			{
				System.out.println( "FileNotFoundException" );
			}
			catch( NullPointerException nullException )
			{
				System.out.println( "NullPointerException" );
			}
			
			}
		}
		
		// INFO
		System.out.println( "Test complete. Press any key to exit." );
		
	}
	
	//-----------------------------------------------------------
	
} ///

//-----------------------------------------------------------