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

package org.bitbucket.code4un.prflb.txtfilter;

//-----------------------------------------------------------

//===========================================================
// IMPORT
//===========================================================

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.bitbucket.code4un.prflb.txtfilter.text.EAnalyzers;
import org.bitbucket.code4un.prflb.txtfilter.text.ELabel;
import org.bitbucket.code4un.prflb.txtfilter.text.ITextAnalyzer;
import org.bitbucket.code4un.prflb.txtfilter.text.TextAnalyzerFactory;

//===========================================================
// TYPES
//===========================================================

/**
 * DefaultLauncher - entry-point.
 * Designed mainly to allow desktop launch of app.
 * 
 * @version 0.1
 * @since 14.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class DefaultLauncher
{
	
	// -----------------------------------------------------------
	
	// ===========================================================
	// CONSTANTS
	// ===========================================================
	
	// ===========================================================
	// FIELDS
	// ===========================================================
	
	// ===========================================================
	// CONSTRUCTORS
	// ===========================================================
	
	// ===========================================================
	// GETTERS & SETTERS
	// ===========================================================
	
	// ===========================================================
	// METHODS
	// ===========================================================
	
	/**
	 * Reads all strings from the file.
	 * 
	 * @thread_safety - main-thread only.
	 * @param pFile - File-Path.
	 * @return - file content.
	 * @throws - can throw {@link IOException}
	**/
	private static String fileToString( final String pFile ) throws IOException
	{
		File file = new File( pFile );
		BufferedReader reader = null;
		String fileLine = "";
		String resultContent = new String( "" );
		
		// Guarded-Block
		try
		{
			// Open File
			reader = new BufferedReader( new FileReader(file) );
			
			// Read all lines (eof or n or 0).
			do
			{
				fileLine = reader.readLine( );
				resultContent += fileLine;
			}
			while( fileLine != null && fileLine.length() > 0 );
			
		}
		finally
		{
			if ( reader != null )
				reader.close( );
		}
		
		// Returns File Content.
		return resultContent;
	}
	
	/**
	 * Check text using SpamAnalyzer.
	 * 
	 * @thread_safety - main-thread only.
	 * @param pText - Text to process.
	 * @throws - can throw exception.
	**/
	private static boolean isTextSpam( String pText ) throws Exception
	{
		// Get SpamAnalyzer
		ITextAnalyzer spamAnalyzer = TextAnalyzerFactory.getTemp( ).BuildAnalyzer( EAnalyzers.SPAM_ANALYZER, new String[] { "this is spam", "spam" } );
		
		// Process Text with SpamAnalyzer
		return spamAnalyzer.processText( pText ) == ELabel.SPAM;
	}
	
	/**
	 * Check text using NegativeTextAnalyzer.
	 * 
	 * @thread_safety - main-thread only.
	 * @param pText - Text to process.
	 * @throws - can throw exception.
	**/
	private static boolean isTextNegative( String pText ) throws Exception
	{
		// Get NegativeTextAnalyzer
		ITextAnalyzer negativeAnalyzer = TextAnalyzerFactory.getTemp( ).BuildAnalyzer( EAnalyzers.NEGATIVE_TEXT_ANALYZER, new String[] { ":(", "=(", ":|" } );
		
		// Process Text with NegativeTextAnalyzer
		return negativeAnalyzer.processText( pText ) == ELabel.NEGATIVE_TEXT;
	}
	
	/**
	 * Check text using TooLongTextAnalyzer.
	 * 
	 * @thread_safety - main-thread only.
	 * @param pText - Text to process.
	 * @throws - can throw exception.
	**/
	private static boolean isTextTooLong( String pText ) throws Exception
	{
		// Get TooLongTextAnalyzer
		ITextAnalyzer longTextAnalyzer = TextAnalyzerFactory.getTemp( ).BuildAnalyzer( EAnalyzers.LONG_TEXT_ANALYZER, new String[] { Integer.toString( 2 ) } );
		
		// Process Text with TooLongTextAnalyzer
		return longTextAnalyzer.processText( pText ) == ELabel.TOO_LONG;
	}
	
	/**
	 * Entry-Point.
	 * 
	 * @thread_safety - main thread-only.
	 * @param pArgs - additional arguments.
	 * @throws - can throw exception.
	**/
	public static void main(String[] pArgs)
	{
		// cout << "Hello World !" << endl;
		System.out.println( "<< = = = = = = = = = = = = = = = = = = = = = = = = = = = =\n\n"
				+ "Welcome to AtomiX Text-Parser v0.1.0\n"
				+ "This app supports input:\n"
				+ " - input via command-line arguments.\n"
				+ "Example: <some_text>;\n"
				+ " - file input. Example: <f path_to_file.txt>;\n"
				+ "\nProcessing input . . ." );
		
		// Guarded-Block
		try
		{
			// Text to Process
			String processedText = "";
			
			// Handle Args.
			if ( pArgs.length > 0 )
			{
				
				// Handle commandlet.
				final String command = pArgs[0].replace( "-", "").toLowerCase( );
				
				switch( command )
				{
				case "f": // File
					
					// INFO
					System.out.println( "reading from file#" + pArgs[1].substring( pArgs[1].lastIndexOf( "/" ) ) );
					
					// Read Text-File.
					processedText = fileToString( pArgs[1] );
					
					break;
				default: // Text
					processedText = pArgs[0];
				}
			}
			else
				processedText = "Hello World ! =(";
			
			// INFO
			System.out.println( "Processing text: " + processedText );
			
			// Spam ?
			System.out.println( "Spam = " + ( isTextSpam( processedText ) ? " TRUE" : "FALSE" ) );
			
			// Negative ?
			System.out.println( "Negative = " + ( isTextNegative( processedText ) ? " TRUE" : "FALSE" ) );
			
			// Long ?
			System.out.println( "Too Long = " + ( isTextTooLong( processedText ) ? " TRUE" : "FALSE" ) );
		}
		catch( Exception pException )
		{
			System.out.println( "DefaultLauncher.main - ERROR: " + pException.getMessage( ) + "\n\n<< = = = = = = = = = = = = = = = = = = = = = = = = = = = =\n\n"
					+ "Unexpected error, press any key to exit . . ." );
			System.exit( -1 );
		}
		
		System.out.println( "\n\n Complete \\^_^/"
				+ "\nHave a nice day !\n\n"
				+ "<< = = = = = = = = = = = = = = = = = = = = = = = = = = = =\n\n" );
		
	}

	// -----------------------------------------------------------
	
} /// DefaultLauncher

//-----------------------------------------------------------