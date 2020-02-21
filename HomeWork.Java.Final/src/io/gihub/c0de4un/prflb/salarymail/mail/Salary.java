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
 * Salary - salary data container.
 * 
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (code4un@yandex.ru)
**/
public final class Salary implements IMailMessage
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Corp. Name. **/
	public String mCompanyTitle;
	
	/** Person's Name. **/
	public String mUnitName;
	
	/** Int. Value. **/
	public int mVal;
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/**
	 * Salary constructor.
	 * 
	 * @param pCorp - Company Name.
	 * @param pName - Unit (employee) Name.
	 * @param salVal - Salary value as an int.
	 * @throws - can throw exception:
	 *    - NullPointerException if bad arguments provided;
	**/
	public Salary( String pCorp, String pName, final int salVal )
	{
		
		if ( pCorp == null || pCorp.isEmpty( ) )
			throw new NullPointerException( "Salary - empty Company Name !" );
		if ( pName == null || pCorp.isEmpty( ) )
			throw new NullPointerException( "Salary - empty Employee Name !" );
		if ( salVal < 1 )
			throw new NullPointerException( "Salary - invalid salary value !" );
		//if ( salVal == Integer.MAX_VALUE )
			//throw new IllegalArgumentException( "Salary - salary integer-value exceeded !" );
		
		mCompanyTitle = pCorp;
		mUnitName = pName;
		mVal = salVal;
		
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public final String getFrom()
	{ return mCompanyTitle; }
	
	@Override
	public final String getTo()
	{ return mUnitName; }
	
	@Override
	public final String getContent()
	{ return new String( "" + mVal ); }
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getContentAs()
	{ return (T) new Integer(mVal); }
	
	//-----------------------------------------------------------
	
} /// Salary

//-----------------------------------------------------------