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

import java.util.ArrayList;

//===========================================================
// TYPES
//===========================================================

/**
 * AbstractKeywordAnalyzer - base Keywords Analyzer class.
 * 
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
abstract class AbstractKeywordAnalyzer extends TextAnalyzer implements IKeywordAnalyzer
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** List of Keywords, found in processing of the text. **/
	ArrayList<String> mKeywords;
	
	/** Text Label. **/
	ELabel mLabel;
	
	//===========================================================
	// CONSTRUCTOR
	//===========================================================
	
	/**
	 * AbstractKeywordAnalyzer default constructor.
	 * 
	 * @throws - can throw exception
	**/
	protected AbstractKeywordAnalyzer( )
	{
		super( );
		mLabel = ELabel.OK; // Default value, better use Invalid or None.
		mKeywords = new ArrayList<String>( 4 ); // Allocate Keywords-List for 4 objects.
	}
	
	/**
	 * AbstractKeywordAnalyzer constructor with initial keywords.
	 * 
	 * @param pKeywords - Keywords.
	 * @throws - can throw exception
	**/
	protected AbstractKeywordAnalyzer( String[] pKeywords )
	{
		this();
		addKeywords( pKeywords );
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Returns keywords found during process of the text.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - array of strings, or null.
	 * @throws - can throw {@link OutOfMemoryError}.
	**/
	public final String[] getKeywords()
	{ return mKeywords != null ? (String[]) mKeywords.toArray( ) : null; }
	
	@Override
	public void getKeywords( ArrayList<String> pOutput ) throws NullPointerException
	{
		// Null-Check
		if ( pOutput == null )
			throw new NullPointerException( "AbstractKeywordAnalyzer.getKeywords - output is null." );
		
		// Copy references.
		if ( mKeywords != null )
		{
			for( String keyword : mKeywords )
			{
				pOutput.add( keyword );
			}
		}
	}
	
	/**
	 * Returns text label from previous analyzation.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - array of strings, or null.
	 * @throws - can throw {@link OutOfMemoryError}.
	**/
	public final ELabel getLabel( )
	{ return mLabel; }
	
	//===========================================================
	// OVERRIDE
	//===========================================================
	
	@Override
	public final ELabel processText( String pText ) throws NullPointerException
	{
		
		// Notify derived object.
		if ( !OnAnalysisStart( pText ) )
			return mLabel;
		
		// Keyword
		String keyword = null;
		
		// Cast Text to Lower-Case.
		final String text = pText.toLowerCase( );
		
		// Search
		for( String keywordNormal : mKeywords )
		{
			// Cast Keyword to lower-case.
			keyword = keywordNormal.toLowerCase( );
			
			// Check match.
			if ( text.contains( keyword ) )
			{
				mLabel = OnKeywordMatch( keywordNormal, pText );
				break;
			}
		}
		
		// Return Label
		return mLabel;
	}
	
	@Override
	public final void addKeyword( String pKeyword )
	{
		// Allocate Keywords container.
		allocateKeywordsList( this );
		
		// Push Keyword
		mKeywords.add( pKeyword );
	}
	
	@Override
	public void addKeywords( String[] pKeywords )
	{
		
		// Allocate Keywords container.
		allocateKeywordsList( this );
		
		// Add Keywords
		for( String keyword : pKeywords )
		{
			mKeywords.add( keyword );
		}
		
	}
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Called when text processing started.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pText - Text to being processed.
	 * @return - 'true' to continue, 'false' to stop.
	**/
	protected boolean OnAnalysisStart( String pText )
	{ return true; }
	
	/**
	 * Called to notify derived object, that keyword found in the text.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pKeyword - Keyword.
	 * @param pText - Text.
	 * @return - Label. NEGATIVE_TEXT is default.
	 * @throws - no exceptions guarantee.
	**/
	protected ELabel OnKeywordMatch( final String pKeyword, final String pText )
	{ return ELabel.NEGATIVE_TEXT; }
	
	/**
	 * Allocates Keywords List for the given instance of AbstractKeywordAnalyzer.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pInstance - AbstractKeywordAnalyzer instance.
	 * @return - Keywords list.
	 * @throws - can throw:
	 *   - {@link NullPointerException} if instance is null;
	**/
	protected static ArrayList<String> allocateKeywordsList( AbstractKeywordAnalyzer pInstance ) throws NullPointerException
	{
		// Null-check.
		if ( pInstance == null )
			throw new NullPointerException( "AbstractKeywordAnalyzer.allocateKeywordsList - null argument !" );
		
		// Allocate Keywords List.
		if ( pInstance.mKeywords == null )
			pInstance.mKeywords = new ArrayList<String>( 4 );
		
		// Return Reference (Shared)
		return pInstance.mKeywords;
	}
	
	//-----------------------------------------------------------
	
} /// AbstractKeywordAnalyzer

//-----------------------------------------------------------