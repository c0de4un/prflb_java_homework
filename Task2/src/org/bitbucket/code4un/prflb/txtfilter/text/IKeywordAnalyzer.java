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
 * IKeywordAnalyzer - interface for keywords analyzers.
 * 
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public interface IKeywordAnalyzer
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Add Keyword to the dictionary.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pKeyword - Value. Arrays or Regexes not supported.
	 * @throws - can throw out of memory.
	**/
	public void addKeyword( String pKeyword );
	
	/**
	 * Add Keywords to the dictionary.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pKeywords - Keywords.
	 * @throws - can throw out of memory.
	**/	
	public void addKeywords( String[] pKeywords );
	
	/**
	 * Returns fixed size array of keywords in UTF-16.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - copy of keywords collection as array.
	 * @throws - can throw exception in case of memory insufficient.
	**/
	public String[] getKeywords( );
	
	/**
	 * Copies references (not values) of keywords to output-container.
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pOutput - Output container. Strings appended.
	 * @throws - can throw {@link NullPointerException} if the output is null.
	**/
	public void getKeywords( ArrayList<String> pOutput ) throws NullPointerException;
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
} ///

//-----------------------------------------------------------