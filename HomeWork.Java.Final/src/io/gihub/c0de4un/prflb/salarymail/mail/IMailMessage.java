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

//===========================================================
// TYPES
//===========================================================

/**
 * IMailMessage - interface for Mail-Message object.
 * 
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (c0de4un@yandex.ru)
**/
public interface IMailMessage
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * @thread_safety - not thread-safe.
	 * @return - Sender email-address.
	 * @throws - no exceptions guarantee.
	 */
	public String getFrom();
	
	/**
	 * @thread_safety - not thread-safe.
	 * @return - Receiver email-address.
	 * @throws - no exceptions guarantee.
	 */
	public String getTo();
	
	/**
	 * @thread_safety - not thread-safe.
	 * @return - UTF-16 text of a content.
	 * @throws - no exceptions guarantee.
	 */
	public String getContent();
	
	/**
	 * @thread_safety - not thread-safe.
	 * @return - some casted type of the content.
	 * @throws - no exceptions guarantee.
	 */
	public <T> T getContentAs();
	
	//-----------------------------------------------------------
	
} /// IMailMessage

//-----------------------------------------------------------