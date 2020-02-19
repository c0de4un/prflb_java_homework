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
// IMPORTS
//===========================================================

//===========================================================
// TYPES
//===========================================================

/**
 * ExceptionCatching
 * 
 * @version 0.1
 * @since 18.02.2020
 * @author Denis Z. (code4un@yandex.ru)
**/
public final class ExceptionCatching
{
	
	// -----------------------------------------------------------

	// ===========================================================
	// CONSTANTS & FIELDS
	// ===========================================================
	
	public static final byte NO_EXCEPTION_TYPE = 0;
	public static final byte NULL_EXCEPTION_TYPE = 1;
	public static final byte ARITHMETIC_EXCEPTION_TYPE = 2;
	public static final byte NO_FILE_EXCEPTION_TYPE = 3;
	public static final byte URI_SYNTAX_EXCEPTION_TYPE = 4;
	
	// ===========================================================
	// METHODS
	// ===========================================================
	
	public static void catchMe( final byte pType ) throws FileNotFoundException, URISyntaxException
	{
		switch( pType )
		{
		case NULL_EXCEPTION_TYPE:
			throw new NullPointerException( "Test" );
		case ARITHMETIC_EXCEPTION_TYPE:
			throw new ArithmeticException( "Test" );
		case NO_FILE_EXCEPTION_TYPE:
			throw new FileNotFoundException( "Test" );
		case URI_SYNTAX_EXCEPTION_TYPE:
			throw new URISyntaxException( "?", "?" );
		case NO_EXCEPTION_TYPE:
		default:
			break;
		}
	}
	
	// -----------------------------------------------------------
	
} /// ExceptionCatching

//-----------------------------------------------------------