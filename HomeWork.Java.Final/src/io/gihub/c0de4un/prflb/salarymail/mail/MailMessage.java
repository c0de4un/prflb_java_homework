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
 * MailMessage - its a,... mail message.
 * <br/>
 * \>_</
 * <br/>
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (c0de4un@yandex.ru)
**/
public final class MailMessage implements IMailMessage
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Sender **/
	private String mSender;
	
	/** Receiver. **/
	private String mReceiver;
	
	/** UTF-16 Content. **/
	private String mContent;
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/**
	 * MailMessage default constructor.
	 * 
	 * @param pSender - From-email (instance copied).
	 * @param pReceiver - To-email (intsance copied).
	 * @param pContent - message content as UTF-16 String (instance copied).
	 * @throws - can throw out of memory exception.
	**/
	public MailMessage( String pSender, String pReceiver, String pContent )
	{
		mSender = new String( pSender );
		mReceiver = new String( pReceiver );
		mContent = new String( pContent );
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public final String getFrom()
	{ return mSender; }
	
	@Override
	public final String getTo()
	{ return mReceiver; }
	
	@Override
	public final String getContent()
	{ return mContent; }
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getContentAs()
	{
		try{ return (T) mContent; }
		catch( ClassCastException ccex )
		{ return null; }
	}
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// MailMessage

//-----------------------------------------------------------