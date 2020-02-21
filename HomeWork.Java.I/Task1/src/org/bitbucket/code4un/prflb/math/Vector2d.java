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
//IMPORT
//===========================================================

//===========================================================
//TYPES
//===========================================================

/**
* Vector2d - 2D (Orthographical surface) vector-struct (class/object),
* allows to avoid direct usage of simple vector-math for surfaces.
* 2d means this type of vector designed for usage of 2 double values.
* <br/>
* 
* @version 0.1
* @since 13.02.2020
* @authors Denis Z. (code4un@yandex.ru)
**/
public final class Vector2d implements IVector
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** X & Y Coordinates values. **/
	private double mX, mY;
	
	//===========================================================
	// CONSTRUCTORS
	//===========================================================
	
	/**
	 * Vector2d DEFAULT constructor.
	 * 
	 * @throws - no exceptions guarantee.
	**/
	public Vector2d( )
	{
		mX = 0;
		mY = 0;
	}
	
	/**
	 * Vector2d copy-constructor.
	 * 
	 * @param pOther - other Vector.
	 * @throws - no exceptions guarantee.
	**/
	public Vector2d( final Vector2d pOther )
	{
		mX = pOther.mX;
		mY = pOther.mY;
	}
	
	/**
	 * Vector2d constructor.
	 * 
	 * @param pX - X coordinate value.
	 * @param pY - Y coordinate value.
	 * @param allowZero - 'true' to allow 0 values, 'false' to throw.
	 * @throws BadLogicException - thrown if invalid values provided.
	 * @throws - no exceptions guarantee.
	**/
	public Vector2d( final double pX, final double pY, final boolean allowZero ) throws BadLogicException
	{
		mX = pX;
		mY = pY;
		
		// 0-Values not allowed.
		if ( allowZero &&
				( new MidDouble(pX).getDenominator( ) == 0
				|| new MidDouble(pY).getDenominator( ) == 0 ) )
			throw new BadLogicException( "Vector2d - zero-initialized values not allowed !" );
			
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public int countElements()
	{ return 2; }
	
	@Override
	public ENumTypes getNumericType()
	{ return ENumTypes.DOUBLE; }
	
	/**
	 * Calculates vector length using 2 double-values.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - vector length as double.
	 * @throws - no exceptions guarantee.
	**/
	public double getLen()
	{ return mX + mY; }
	
	//===========================================================
	// IVector
	//===========================================================
	
	@Override
	public IVector add(IVector pOther) throws BadLogicException
	{
		if ( pOther == null )
			throw new BadLogicException("Vector2d.add: invalid arguments provided !");
		
		if ( pOther.countElements( ) != 2
				&& pOther.getNumericType( ) != ENumTypes.DOUBLE )
			throw new BadLogicException("Vector2d.add: can't execute calculation with incompatable data-types, LoL !");
		
		final Vector2d otherVector = (Vector2d) pOther;
		return new Vector2d( otherVector.mX + mX, otherVector.mY + mY, false );
	}

	@Override
	public IVector sub(IVector pOther) throws BadLogicException
	{
		if ( pOther == null )
			throw new BadLogicException("Vector2d.sub: invalid arguments provided !");

		if ( pOther.countElements( ) != 2
				&& pOther.getNumericType( ) != ENumTypes.DOUBLE )
			throw new BadLogicException("Vector2d.sub: can't execute calculation with incompatable data-types, LoL !");
		
		final Vector2d otherVector = (Vector2d) pOther;
		return new Vector2d( mX - otherVector.mX, mY - otherVector.mY, false );
	}

	@Override
	public IVector mul(IVector pOther) throws BadLogicException
	{
		if ( pOther == null )
			throw new BadLogicException("Vector2d.mul: invalid arguments provided !");
		
		if ( pOther.countElements( ) != 2
				&& pOther.getNumericType( ) != ENumTypes.DOUBLE )
			throw new BadLogicException("Vector2d.mul: can't execute calculation with incompatable data-types, LoL !");
		
		final Vector2d otherVector = (Vector2d) pOther;
		return new Vector2d( otherVector.mX * mX, otherVector.mY * mY, false );
	}

	@Override
	public IVector div(IVector pOther) throws BadLogicException
	{
		if ( pOther == null )
			throw new BadLogicException("Vector2d.div: invalid arguments provided !");
		
		if ( pOther.countElements( ) != 2
				&& pOther.getNumericType( ) != ENumTypes.DOUBLE )
			throw new BadLogicException("Vector2d.div: can't execute calculation with incompatable data-types, LoL !");
		
		final Vector2d otherVector = (Vector2d) pOther;
		return new Vector2d( mX/ otherVector.mX, mY / otherVector.mY, false );
	}

	@Override
	public int compareTo( IVector pOther )
	{
		if ( pOther == null )
			throw new NullPointerException("Vector2d.compareTo: invalid arguments provided !");
		
		if ( pOther.countElements( ) != 2
				&& pOther.getNumericType( ) != ENumTypes.DOUBLE )
			throw new ClassCastException("Vector2d.compareTo: can't execute calculation with incompatable data-types, LoL !");
		
		// Cast to Vector2d
		final Vector2d rhs = (Vector2d) pOther;
		
		// Check coordinates match.
		if ( mX == rhs.mX && mY == rhs.mY )
			return 0;
		
		// Calculate sum
		final double lhsSum = Math.abs( mX ) + Math.abs( rhs.mX );
		final double rhsSum = Math.abs( mY ) + Math.abs( rhs.mY );
		
		// Returns length diff.
		return lhsSum < rhsSum ? -1 : 1;
	}
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
}

//-----------------------------------------------------------