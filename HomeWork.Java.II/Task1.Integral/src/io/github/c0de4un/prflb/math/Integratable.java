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

package io.github.c0de4un.prflb.math;

//-----------------------------------------------------------

//===========================================================
// IMPORTS
//===========================================================

//===========================================================
// TYPES
//===========================================================

/**
 * Integrateable - integratable interface.
 * 
 * @version 0.1
 * @since 18.02.2020
 * @author Denis Z. (code4un@yandex.ru)
**/
@FunctionalInterface
public interface Integratable<V, N>
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Integrate value between 2 points using
	 * rectangular-based integral method.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pMethod - Rectangular method inplementation (lambda).
	 * @return - integrate-result.
	 * @throws - can throw RuntimeException.
	**/
	public V integrate( IRectangularIntegral<V, N> pMethod, V pX1, V pX2, N pNum );
	
	//-----------------------------------------------------------
	
}

//-----------------------------------------------------------