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

package io.gihub.c0de4un.prflb.salarymail.mail;

//-----------------------------------------------------------

//===========================================================
// IMPORTS
//===========================================================

import java.util.List;
import java.util.Map;

//===========================================================
// TYPES
//===========================================================

/**
 * IMailService - 
 * <br/>
 * \>_</
 * <br/>
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (c0de4un@yandex.ru)
**/
public interface IMailService<T>
{
	
	//-----------------------------------------------------------

	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Returns all messages map.
	 * 
	 * <i>(?) This is really bad behavior pattern.</i>
	 * 
	 * @thread_safety - not thread-safe (event dangerous, cause refs (ptrs) returned, not copies).
	 * @return - map of all messages content.
	 * @throws - no exceptions guarantee.
	**/
	public Map<String, List<T>> getMailBox();
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// IMailService

//-----------------------------------------------------------