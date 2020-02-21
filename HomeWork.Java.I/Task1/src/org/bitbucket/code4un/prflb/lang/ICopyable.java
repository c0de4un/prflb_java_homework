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

package org.bitbucket.code4un.prflb.lang;

//-----------------------------------------------------------

//===========================================================
// IMPORT
//===========================================================

import org.bitbucket.code4un.prflb.math.BadLogicException;

//===========================================================
// TYPES
//===========================================================

/**
 * ICopyable - interface for copying objects.
 * Copy - is a independent instance of an object, unlikely clone.
 * 
 * @version 0.1
 * @since 13.02.2020
 * @author Denis Z. (code4un@yandex.ru)
**/
public interface ICopyable
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Checks if this instance supports copying.
	 * 
	 * @thread_safety - not required.
	 * @return - 'true' if object can be copied.
	 * @throws - no exceptions.
	**/
	public boolean isCopyingSupported();
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Tries to create a copy of this instance.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - copy if this instance.
	 * @throws - can throw exception:
	 *    - {@link BadLogicException} - if copying not supported.
	 *    Use {@link #isCopyingSupported()}.
	**/
	public ICopyable Copy() throws BadLogicException;
	
	//-----------------------------------------------------------
	
} /// ICopyable

//-----------------------------------------------------------