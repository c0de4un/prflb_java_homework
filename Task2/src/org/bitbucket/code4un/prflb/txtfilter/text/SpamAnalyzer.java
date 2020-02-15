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
 * SpamAnalyzer - check text to detects, that it is a spam.
 * <br/><hr><br/><h1><b>=^_^=</b></h1><br/><hr><br/>
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class SpamAnalyzer extends KeywordAnalyzer
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/**
	 * SpamAnalyzer default constructor.
	 * 
	 * @throws - can throw exception
	**/
	public SpamAnalyzer( )
	{
		super( );
	}
	
	/**
	 * SpamAnalyzer constructor with initial keywords.
	 * 
	 * @param pKeywords - Keywords.
	 * @throws - can throw exception
	**/
	public SpamAnalyzer( String[] pKeywords )
	{
		super( pKeywords );
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public final EAnalyzers getAnalyzerType( )
	{ return EAnalyzers.SPAM_ANALYZER; }
	
	//===========================================================
	// OVERRIDE
	//===========================================================
	
	@Override
	protected final boolean OnAnalysisStart( String pText )
	{
		// Null-Check
		if ( mKeywords == null || mKeywords.isEmpty( ) )
			throw new NullPointerException( "SpamAnalyzer.OnAnalysisStart - no keywords are provided !" );
		
		// COninue analyzes.
		return true;
	}
	
	@Override
	protected final ELabel OnKeywordMatch( final String pKeyword, final String pText )
	{ return ELabel.SPAM; }
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// SpamAnalyzer

//-----------------------------------------------------------