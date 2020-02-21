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
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.HashMap;

//===========================================================
// TYPES
//===========================================================

/**
 * BaseMailService - MailService base.
 * <br/>
 * \^_^/
 * <br/>
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (c0de4un@yandex.ru)
**/
public abstract class BaseMailService<T> implements IMailService<T>, Consumer<IMailMessage>
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Messages content grouped by Sender. **/
	protected Map<String, List<T>> mContents;
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/**
	 * BaseMailService default constructor.
	 * 
	 * @thread_safety - not thread-safe.
	 * @throws - can throw out-of-memory.
	**/
	protected BaseMailService()
	{
		mContents = new HashMap<String, List<T>>( 4 );
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public Map<String, List<T>> getMailBox()
	{ return mContents; }
	
	//===========================================================
	// INTERFACES
	//===========================================================
	
	@Override
	public void accept( IMailMessage pMessage )
	{
		if ( pMessage == null )
			return; // Should NullPtrException being thrown ?
		
		// Sender.
		final String sender_ = pMessage.getFrom();
		
		// Search messages list.
		List<T> messages_ = mContents.get( sender_ );
		
		// Allocate
		if ( messages_ == null )
		{
			messages_ = new ArrayList<T>( 2 ); // Array list to support manual sorting, add-order sotring as default.
			mContents.put(sender_, messages_);
		}
		
		// Get Message Content.
		T content_ = pMessage.<T>getContentAs( );
		
		if ( content_ == null )
			throw new ClassCastException( "BaseMailService.accept: uncompatable types !" );
		
		// Add Message Content.
		messages_.add( content_ ); // Very not thread-safe. Copying would me more applicable.
	}
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// BaseMailService

//-----------------------------------------------------------