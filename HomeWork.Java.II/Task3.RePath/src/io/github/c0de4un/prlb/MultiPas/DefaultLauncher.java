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

package io.github.c0de4un.prlb.MultiPas;

//-----------------------------------------------------------

//===========================================================
//INCLUDES
//===========================================================

//===========================================================
//TYPES
//===========================================================

/**
 * DefaultLauncher - entry-point fo default launcher.
 * <br/><hr><br/>
 * >_<
 * <br/><hr><br/>
 * @version 0.1
 * @author Denis Z. (code4un@yandex.ru)
**/
public final class DefaultLauncher
{
	
	//-----------------------------------------------------------
	
	/**
	 * <i>some useful info must be here</i>
	**/
	public static void main(String[] pArgs)
	{
		
		// INFO
		System.out.println( "Welcome to Nix-Style Path util.\n\n"
				+ "Testing values: #1 \"/a/b/c/../d\" & #2 \"/a/\"\n\n"
				+ "Results: " );
		
		//
		System.out.println( "#1 = " + Path.simplifyPath( "/a/b/c/../d", true ) + " #2 = " + Path.simplifyPath( "/a/", true ) );
		
		//
		
		// INFO
		System.out.println( "Test complete, have a nice day !\n\n=^_^=" );
		
	}
	
	//-----------------------------------------------------------
	
} /// DefaultLauncher

//-----------------------------------------------------------