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

import org.bitbucket.code4un.prflb.lang.ICopyable;

//===========================================================
//TYPES
//===========================================================

/**
 * IPoint - all points interface.
 * 
 * @version 0.1
 * @since 13.02.2020
 * @author Denis Z. (code4un@yandex.ru)
**/
public interface IPoint extends Comparable<IPoint>, ICopyable
{
	
	//-----------------------------------------------------------

	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Returns current location.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - IVector.
	 * @throws - no exceptions guarantee.
	**/
	public IVector getLocation();
	
	/**
	 * Sets new location.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pLocation - coordinates-vector.
	 * @throws - can throw exception:
	 *   - BadLogicException - if provided IVector instance is incompatible with used one.
	**/
	public void setLocation( IVector pLocation ) throws BadLogicException;
	
	//===========================================================
	// METHODS
	//===========================================================
	
	
	
	//-----------------------------------------------------------
	
}

//-----------------------------------------------------------