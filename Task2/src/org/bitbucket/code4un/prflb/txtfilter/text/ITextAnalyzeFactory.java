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
 * ITextAnalyzeFactory - text analyzers factory.
 * Allows to avoid using specific code/api.
 * 
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public interface ITextAnalyzeFactory
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	//===========================================================
	// METHODS
	//===========================================================
	
	/**
	 * Build Analyzer for text (and/or spam).
	 * 
	 * @thread_safety - not required.
	 * @param pType - Analyzer type required (Spam, Negative, Long, etc).
	 * @param pKeywords - Keywords, can be null.
	 * @return - ITextAnalyzer implementation.
	 * @throws - can throw out of memory.
	**/
	public ITextAnalyzer BuildAnalyzer( final EAnalyzers pType, String[] pKeywords ) throws Exception;
	
	//-----------------------------------------------------------
	
} /// ITextAnalyzeFactory

//-----------------------------------------------------------