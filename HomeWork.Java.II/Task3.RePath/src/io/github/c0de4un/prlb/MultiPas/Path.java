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

package io.github.c0de4un.prlb.MultiPas;

import java.util.Stack;

//-----------------------------------------------------------

//===========================================================
// IMPORTS
//===========================================================

import java.util.StringJoiner;

//===========================================================
// TYPES
//===========================================================

/**
 * Path - path-utility class.
 * 
 * @version 0.1
 * @author Denis Z. (code4un@yandex.ru)
**/
public final class Path
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Converts path separators from Win-style (\\) to common nix (/).
	 * 
	 * @thread_safety - not required.
	 * @param pOriginal - original path.
	 * @return - fixed path.
	 * @throws - no exceptions guarantee.
	**/
	public static String fixSeparators( final String pOriginal )
	{ return pOriginal != null ? pOriginal.replace( '\\', '/') : null; }
	
	/**
	 * Simplify path.<br/>
	 * (!) This is dirty c0de-styl3, don't use it }0_o{
	 * <br/>
	 * @param pOriginal - original path.
	 * @param useStack - true to use stack instead of raw-indices.
	 * @return - simple path.
	**/
	public static String simplifyPath( String pOriginal, final boolean useStack )
	{
		
		// Manual
		pOriginal = fixSeparators( pOriginal );
		final String[] dirNames = pOriginal.split( "/" );

		// Raw iteration.
		if ( !useStack )
		{
			final int len = dirNames.length;
			String curDirName = "";
			String prevDirName = "";
			
			StringJoiner strJoiner = new StringJoiner( "/" );
			for( int i = 0; i < len; i++ )
			{
				curDirName = dirNames[i];
				
				if ( curDirName.contains( ".." ) )
				{
					if ( prevDirName != null )
						prevDirName = null;
				}
				else
				{
					if ( prevDirName != null )
						strJoiner.add( prevDirName );
					prevDirName = curDirName;
				}
			}
			if ( prevDirName != null )
				strJoiner.add( prevDirName );
			
			final String result = strJoiner.toString( );
			return result.substring( 1 );
		}
		
		// Stack in use.
		StringJoiner strJoiner = new StringJoiner( "/" );
		Stack<String> stack = new Stack<String>( );
		
		for( String dirName : dirNames )
		{
			if ( !dirName.contains( ".." ) )
				stack.add( dirName );
			else if ( !stack.isEmpty( ) )
				stack.remove( stack.size() - 1 );
		}
		
		// Second iter.
		for( String dirName : stack )
		{ strJoiner.add( dirName ); }
		
		final String result = strJoiner.toString( );
		return result;
	}
	
	//-----------------------------------------------------------
	
} /// Path

//-----------------------------------------------------------