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

package org.bitbucket.code4un.prflb.math;

//-----------------------------------------------------------

//===========================================================
// IMPORT
//===========================================================

//===========================================================
// TYPES
//===========================================================

/**
 * MidDouble - complex numeric-type for double-type.
 * 
 * <br/>
 * <hr/>
 * <b><h1>\|0_0|/</h1></b>
 * <br/>
 * <hr/>
 * <br/><b>(!)</b>Licked from: {@link http://www.cyberforum.ru/java-j2se/thread1262591.html}<br/>
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class MidDouble extends NumericBase
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	/** Numeric-Type. **/
	private static final ENumTypes NUM_TYPE = ENumTypes.DOUBLE;
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Numerator. **/
	int mNumerator;
	
	/** Denominator. **/
	int mDenominator;
	
	//===========================================================
	// CONSTRUCTORS
	//===========================================================

	/**
	 * MidDouble <b>DEFAULT</b> constructor.
	 * 
	 * @throws - no exceptions guarantee.
	**/
	public MidDouble( )
	{
		mNumerator = 0;
		mDenominator = 0;
	}
	
	/**
	 * MidDouble constructor for double-value.
	 * 
	 * @param pDouble - double-value to convert from.
	 * @throws - no exceptions guarantee.
	**/
	public MidDouble( final double pDouble )
	{ this( java.lang.Double.toString( pDouble ) ); }
	
	/**
	 * MidDouble constructor for double-value.
	 * 
	 * @param pDouble - double-value to convert from.
	 * @throws - no exceptions guarantee.
	**/
	public MidDouble( final String pString )
	{
		final String denominatorStr_ =  pString.substring( pString.indexOf( "." ) + 1 );
		final String numeratorStr_ = pString.substring( 0, pString.indexOf( "." ) );
		mNumerator = Integer.parseInt( numeratorStr_ );
		mDenominator = Integer.parseInt( denominatorStr_ );
	}
	
	/**
	 * MidDouble constructor with two initial values.
	 * 
	 * @param pNumerator - Numerator.
	 * @param pDenominator - Denominator.
	 * @throws - no exceptions guarantee.
	**/
	public MidDouble( final int pNumerator, final int pDenominator )
	{
		mNumerator = pNumerator;
		mDenominator = pDenominator;
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public ENumTypes getType()
	{ return NUM_TYPE; }
	
	/**
	 * Returns Numerator value.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - int Numerator value.
	 * @throws - no exceptions guarantee.
	**/
	public final int getNumerator()
	{ return mNumerator; }
	
	/**
	 * Returns Denominator value.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - int denominator value.
	 * @throws - no exceptions guarantee.
	**/
	public final int getDenominator()
	{ return mDenominator; }
	
	//===========================================================
	// NumericBase, INumber
	//===========================================================
	
	@Override
	public int CastToInt()
	{
		final StringBuilder stringFactory = new StringBuilder( );
		stringFactory.append( mNumerator );
		stringFactory.append( mDenominator );
		return Integer.parseInt( stringFactory.toString( ) );
	}
	
	@Override
	public long CastToLong()
	{
		final StringBuilder stringFactory = new StringBuilder( );
		stringFactory.append( mNumerator );
		stringFactory.append( mDenominator );
		return Long.parseLong( stringFactory.toString( ) );
	}
	
	@Override
	public float CastToFloat()
	{
		final StringBuilder stringFactory = new StringBuilder( );
		stringFactory.append( mNumerator );
		stringFactory.append( mDenominator );
		return Float.parseFloat( stringFactory.toString( ) );
	}
	
	@Override
	public double CastToDouble()
	{
		final StringBuilder stringFactory = new StringBuilder( );
		stringFactory.append( mNumerator );
		stringFactory.append( mDenominator );
		return java.lang.Double.parseDouble( stringFactory.toString( ) );
	}
	
	//===========================================================
	// METHOD
	//===========================================================
	
	//-----------------------------------------------------------
	
} /// MidDouble

//-----------------------------------------------------------