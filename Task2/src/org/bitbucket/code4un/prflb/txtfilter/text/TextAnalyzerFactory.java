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
 * TextAnalyzerFactory - allows to get analyzer for content without using direct type-call.
 * 
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class TextAnalyzerFactory implements ITextAnalyzeFactory
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
	 * TextAnalyzerFactory constructor.
	 * 
	 * @throws - can throw out of memory.
	**/
	public TextAnalyzerFactory()
	{
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Creates temporary instance of a TextAnalyzerFactory.
	 * 
	 * @thread_safety - not required.
	 * @return - ITextAnalyzeFactory.
	 * @throws - can throw out-of-memory exception.
	**/
	public static ITextAnalyzeFactory getTemp()
	{ return new TextAnalyzerFactory(); }
	
	//===========================================================
	// ITextAnalyzerFactory
	//===========================================================
	
	@Override
	public ITextAnalyzer BuildAnalyzer( final EAnalyzers pType, String[] pKeywords ) throws Exception
	{
		switch( pType )
		{
		case SPAM_ANALYZER:
			return new SpamAnalyzer( pKeywords );
		case NEGATIVE_TEXT_ANALYZER:
			return new NegativeTextAnalyzer( pKeywords );
		case LONG_TEXT_ANALYZER:
			
			// Check Text Length Limit.
			if ( pKeywords == null || pKeywords[0] == null || pKeywords[0].length( ) < 1 )
				throw new IllegalArgumentException( "TextAnalyzerFactory.BuildAnalyzer: Long-Text Analyzer requires numeric-value as #0 argument !" );
			
			return new TooLongTextAnalyzer( Integer.parseInt( pKeywords[0] ) );
		default:
			throw new IllegalArgumentException( "TextAnalyzerFactory.BuildAnalyzer: unknown analyzer type !" );
		}
	}
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// TextAnalyzerFactory

//-----------------------------------------------------------