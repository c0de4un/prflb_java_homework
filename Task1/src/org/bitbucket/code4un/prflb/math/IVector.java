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
 * IVector - interface for all vector-based math operations.
 * Used to unify basic set of rules for calculations <i>(for example add, mul, div, sub, etc.)</i>.
 * 
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
interface IVector extends Comparable<IVector>
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Allows to retrieve amount of elements (symbols, numbers, values)
	 * from this IVector avoiding knowing it exact type (class).
	 * 
	 * @thread_safety - thread-safe, const-value used.
	 * @return - number of values this IVector have.
	 * @throws - exceptions-free.
	**/
	public int countElements();
	
	/**
	 * Returns values numeric-type (int, float, double or long).
	 * 
	 * @thread_safety - thread-safe, const-value used.
	 * @return - numeric-type (int, float, double or long).
	 * @throws - exceptions-free.
	**/
	public ENumTypes getNumericType();
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Add other vector (+).
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pOther - other IVector instance.
	 * @return - IVector (new instance).
	 * @throws - no exceptions are thrown.
	**/
	public IVector add( final IVector pOther ) throws BadLogicException;
	
	/**
	 * Sub other vector (-).
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pOther - other IVector instance.
	 * @return - IVector (new instance).
	 * @throws - no exceptions are thrown.
	**/	
	public IVector sub( final IVector pOther ) throws BadLogicException;
	
	/**
	 * Multiply other vector (*).
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pOther - other IVector instance.
	 * @return - IVector (new instance).
	 * @throws - no exceptions are thrown.
	**/
	public IVector mul( final IVector pOther ) throws BadLogicException;
	
	/**
	 * Divide other vector (/).
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pOther - other IVector instance.
	 * @return - IVector (new instance).
	 * @throws - no exceptions are thrown.
	**/	
	public IVector div( final IVector pOther ) throws BadLogicException;
	
	//-----------------------------------------------------------
	
} /// IVector

//-----------------------------------------------------------