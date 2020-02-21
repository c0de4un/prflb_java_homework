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

package org.bitbucket.code4un.prflb.math;

//-----------------------------------------------------------

//===========================================================
// IMPORT
//===========================================================

//===========================================================
// TYPES
//===========================================================

/**
 * DesktopLauncher - entry-point.
 * Designed mainly to allow desktop launch of app.
 * 
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public enum ENumTypes
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	INTEGER_32,
	INTEGER_64,
	FLOAT,
	DOUBLE;
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Converts java-string to ENumTypes instance-value.
	 * <br/><hr><b><h1>]~_~[</h1></b><hr><br/>
	 * @thread_safety - static.
	 * @param pInput - string to parse.
	 * @return - ENumTypes.
	 * @throws - can throw exceptions:<br/>
	 *   - BadLogicException - if input values are invalid;
	**/
	static final ENumTypes fromString( String pInput ) throws BadLogicException
	{
		// Null-check.
		if ( pInput == null || pInput.length() < 3 )
			throw new BadLogicException( "ENumTypes.fromString: NULL string !!! X_X" );
		
		// Cast string to lower-case, so the switch-case works properly.
		pInput = pInput.toUpperCase( );
		
		// Handle string.
		switch( pInput )
		{
		case "INTEGER_32":
			return ENumTypes.INTEGER_32;
		case "INTEGER_64":
			return ENumTypes.INTEGER_64;
		case "FLOAT":
			return ENumTypes.FLOAT;
		case "DOUBLE":
			return ENumTypes.DOUBLE;
		default:
			throw new BadLogicException( "ENumTypes.fromString: bad input string, fix." );
		}
	}
	
	//-----------------------------------------------------------
	
} /// ENumTypes

//-----------------------------------------------------------