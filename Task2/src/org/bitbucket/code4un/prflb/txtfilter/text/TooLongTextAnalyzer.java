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

package org.bitbucket.code4un.prflb.txtfilter.text;

//-----------------------------------------------------------

//===========================================================
// IMPORT
//===========================================================

//===========================================================
// TYPES
//===========================================================

/**
 * TooLongTextAnalyzer - checks text length.
 * <br/><hr><br/><h1><b>\^_^/</b></h1><br/><hr><br/>
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class TooLongTextAnalyzer extends KeywordAnalyzer
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Text Length Limit. **/
	private long mLengthLimit;
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/**
	 * SpamAnalyzer default constructor.
	 * 
	 * @param pLimit - Maximum Text allowed length.
	 * @throws - can throw exception
	**/
	public TooLongTextAnalyzer( final int pLimit )
	{
		super( );
		mLengthLimit = (long) pLimit;
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public final EAnalyzers getAnalyzerType( )
	{ return EAnalyzers.LONG_TEXT_ANALYZER; }
	
	/**
	 * Sets new Text Length Limit value.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pLimit - Text Length Limit.
	 * @throws - no exceptions guarantee.
	**/
	public final void setLengthLimitInt32( final int pLimit )
	{ mLengthLimit = (long) pLimit; }
	
	/**
	 * Gets Text Length Limit.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - Text Length Limit.
	 * @throws - no exceptions guarantee.
	**/
	public final int getLengthLimitIn32( )
	{ return (int) mLengthLimit; }
	
	//===========================================================
	// OVERRIDE
	//===========================================================
	
	@Override
	protected boolean OnAnalysisStart( String pText )
	{
		if ( pText.length() > mLengthLimit )
			mLabel = ELabel.TOO_LONG;
		
		return false;
	}
	
	@Override
	protected ELabel OnKeywordMatch( final String pKeyword, final String pText )
	{ return ELabel.OK; }
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// TooLongTextAnalyzer

//-----------------------------------------------------------