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
 * ITextAnalyzer - interface for text-analyzer class/object.
 * 
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public interface ITextAnalyzer
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Returns Analyzer-Type (spam, negative, long, etc).
	 * 
	 * @thread_safety - not required.
	 * @return - Analyzer-Type enum-value.
	 * @throws - no exceptions guarantee.
	**/
	public EAnalyzers getAnalyzerType( );
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Analyze text.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pText - Text to analyze. Only one thread should have access.
	 * @throws - can throw exception:
	 *   - NullPointerException - if text is empty.
	**/
	public ELabel processText( String pText ) throws NullPointerException;
	
	//-----------------------------------------------------------
	
} /// ITextAnalyzer

//-----------------------------------------------------------