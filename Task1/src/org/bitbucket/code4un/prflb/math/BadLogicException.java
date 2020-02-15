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
//IMPORT
//===========================================================

//===========================================================
//TYPES
//===========================================================

/**
* BadLogicException - exception-type for prflb package.
* <br/><hr><br/><h1><b>=^_^=</h1></b><br/><hr><br/>
* @version 0.1
* @since 13.02.2020
* @authors Denis Z. (code4un@yandex.ru)
**/

public final class BadLogicException extends Exception
{

	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	/** Unique ID for this Exception Type. Required. **/
	private static final long serialVersionUID = 1L;
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	//===========================================================
	// CONSTRUCTORS
	//===========================================================
	
	/**
	 * BadLogicException <u><b>default</b></u> constructor.
	 * Use with caution.
	 *  
	 * @param pMsg - describing message, can contains stuck trace copy.
	 * @param pThrowable - throwable instance. 
	**/
	public BadLogicException( )
	{ super( ); }
	
	/**
	 * BadLogicException constructor with message only.
	 *  
	 * @param pMsg - describing message, can contains stuck trace copy.
	 * @param pThrowable - throwable instance. 
	**/
	public BadLogicException( String pMsg )
	{ super( pMsg ); }
	
	/**
	 * BadLogicException constructor with message & thrown-type.
	 *  
	 * @param pMsg - describing message, can contains stuck trace copy.
	 * @param pThrowable - throwable instance. 
	**/
	public BadLogicException( String pMsg, Throwable pThrowable )
	{ super( pMsg, pThrowable ); }
	
	/**
	 * BadLogicException constructor with throwable only.
	 *  
	 * @param pMsg - describing message, can contains stuck trace copy.
	 * @param pThrowable - throwable instance. 
	**/
	public BadLogicException( Throwable pThrowable )
	{ super( pThrowable ); }
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// BadLogicException

//-----------------------------------------------------------