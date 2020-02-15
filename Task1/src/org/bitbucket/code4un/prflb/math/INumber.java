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
 * INumber - interface for complex numeric-types.
 * Allows to use specific methods/fields, like fractions, denominator & numerator.
 * 
 * <br/>
 * <hr/>
 * <b><h1>=^-_-^=</h1></b>
 * <br/>
 * <hr/>
 * 
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
interface INumber
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Returns numeric-type.
	 * 
	 * @thread_safety - const-value.
	 * @return - ENumTypes.
	 * @throws - no exceptions guaranteed.
	**/
	public ENumTypes getType();
	
	//===========================================================
	// METHODS
	//===========================================================

	/**
	 * Cast values to single integer 32-bit numeric.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - 32-bit integer.
	 * @throws - no exceptions guarantee.
	**/
	public int CastToInt();
	
	/**
	 * Cast values to single integer 64-bit numeric.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - 64-bit integer.
	 * @throws - no exceptions guarantee.
	**/
	public long CastToLong();
	
	/**
	 * Cast values to single float (4n denominator).
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - float.
	 * @throws - no exceptions guarantee.
	**/
	public float CastToFloat();
	
	/**
	 * Cast values to single double.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - double.
	 * @throws - no exceptions guarantee.
	**/
	public double CastToDouble();
	
	//-----------------------------------------------------------
	
} /// INumber

//-----------------------------------------------------------