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
 * KeywordAnalyzer - handles keywords. Why it is required by tech-doc if AbstractKeywordAnalyzer exists - no idea.
 * <br/><hr><br/><h1><b>|-_-|</b></h1><br/><hr><br/>
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public abstract class KeywordAnalyzer extends AbstractKeywordAnalyzer
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
	 * KeywordAnalyzer default constructor.
	 * 
	 * @throws - can throw exception
	**/
	protected KeywordAnalyzer( )
	{
		super( );
	}
	
	/**
	 * KeywordAnalyzer constructor with initial keywords.
	 * 
	 * @param pKeywords - Keywords.
	 * @throws - can throw exception
	**/
	protected KeywordAnalyzer( String[] pKeywords )
	{
		super( pKeywords );
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	//===========================================================
	// OVERRIDE
	//===========================================================
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// KeywordAnalyzer

//-----------------------------------------------------------