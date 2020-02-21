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

package io.gihub.c0de4un.prflb.salarymail;

//-----------------------------------------------------------

//===========================================================
// IMPORTS
//===========================================================

//===========================================================
// TYPES
//===========================================================

/**
 * SalaryMailScenario - scenario logic.
 * 
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (c0de4un@yandex.ru)
**/
final class SalaryMailScenario
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Mail.From **/
	String mMailFrom;
	
	/** Mail.To **/
	String mMailTo;
	
	/** Mail.Salary **/
	int mMailSalary;
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/** SalaryMailScenario constructor. (!) Serialization only. **/
	SalaryMailScenario( )
	{
		mMailFrom = "undefined";
		mMailTo = "undefined";
		mMailSalary = -1;
	}
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Parses email from string.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pSrc - Source-string.
	 * @return - ready-to-use email.
	 * @throws - can throw IllegalArgumentException.
	**/
	public static String parseEmail( final String pSrc ) throws IllegalArgumentException
	{
		if ( pSrc == null || pSrc.length() < 2 || !pSrc.contains( "@" ) )
			throw new IllegalArgumentException( "SalaryMailScenario.parseEmail: invalid email." );
		
		return pSrc.toLowerCase( );
	}
	
	/**
	 * Parses values from strings.
	 * 
	 * @thread_safety - not required.
	 * @param pArgs - arguments.
	 * @throws - can throw RuntimException.
	**/
	void ParseCMD( final String[] pArgs ) throws IllegalArgumentException
	{
		
		// Local-frame var to avoid reading from other space.
		final int len_ = pArgs.length;
		
		// Content (ref).
		String arg_ = null;
		
		// Iterate
		for( int i = 0; i < len_; i++ )
		{
			// Get Arg
			arg_ = pArgs[i];
			
			// Remove invalid chars.
			arg_ = arg_.replaceAll( "[%-*_-.,+-/]", "" );
			
			// To Lower-Case.
			arg_ = arg_.toLowerCase( );
			
			// Handle keyword (commandlets).
			switch( arg_ )
			{
			case "from":
				i++;
				mMailFrom = parseEmail( pArgs[i] );
				break;
			case "to":
				i++;
				mMailTo = parseEmail( pArgs[i] );
				break;
			case "sal":
				i++;
				mMailSalary = Integer.parseInt( pArgs[i] );
				break;
			default:
				throw new IllegalArgumentException( "SalaryMailScenario.ParseCMD: Bad commandlet." );
			}
			
		} /// Iter
	}
	
	//-----------------------------------------------------------
	
} /// SalaryMailScenario

//-----------------------------------------------------------