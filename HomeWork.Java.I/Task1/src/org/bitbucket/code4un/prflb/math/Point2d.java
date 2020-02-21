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

import org.bitbucket.code4un.prflb.lang.ICopyable;

//===========================================================
// TYPES
//===========================================================

/**
 * Point2d - base surface-point type with 2 double-values.
 * 
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class Point2d implements IPoint, ICopyable
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Location-vector 2d. **/
	private Vector2d mLocation;
	
	//===========================================================
	// CONSTRUCTORS
	//===========================================================
	
	/**
	 * Point2d constructor with default values.
	 * 
	 * @param pX - X.
	 * @param pY - Y.
	 * @throws BadLogicException - thrown if invalid arguments provided.
	**/
	public Point2d( final double pX, final double pY ) throws BadLogicException
	{ mLocation = new Vector2d( pX, pY, false ); }
	
	/**
	 * Point2d constructor with default values.
	 * 
	 * @param pX - X.
	 * @param pY - Y.
	 * @throws BadLogicException - thrown if invalid arguments provided.
	**/
	public Point2d( final Point2d pOther ) throws BadLogicException
	{ mLocation = new Vector2d( pOther.mLocation ); }
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	@Override
	public boolean isCopyingSupported( )
	{ return true; }
	
	/**
	 * Calculates location vector len.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - len of vector.
	 * @throws - no exceptions.
	**/
	public double getLength()
	{ return mLocation.getLen( ); }
	
	//===========================================================
	// IPoint, Comparable, ICopyable
	//===========================================================
	
	@Override
	public IVector getLocation( )
	{ return mLocation; }
	
	@Override
	public void setLocation( IVector pLocation ) throws BadLogicException
	{
		if ( pLocation == null )
			throw new BadLogicException("Point2d.setLocation: invalid arguments provided !");
		
		if ( pLocation.countElements( ) != 2
				&& pLocation.getNumericType( ) != ENumTypes.DOUBLE )
			throw new BadLogicException("Point2d.setLocation: can't execute calculation with incompatable data-types, LoL !");
		
		mLocation = new Vector2d( (Vector2d)pLocation );
	}

	@Override
	public int compareTo( IPoint pOther )
	{
		if ( pOther == null )
			throw new NullPointerException("Point2d.compareTo: invalid arguments provided !");
		
		// Point2d
		Point2d rhsPoint = null;
		
		// Cast to Point2d from IPoint
		try { rhsPoint = (Point2d) pOther; }
		catch( Exception pException ) { throw new ClassCastException( "Point2d.compareTo: invalid point type LoL ^o^ !" ); }
		
		// Compare locations.
		return mLocation.compareTo( rhsPoint.mLocation );
	}

	@Override
	public ICopyable Copy( ) throws BadLogicException
	{ return new Point2d(this); }
	
	//===========================================================
	// METHODS
	//===========================================================
	
	//-----------------------------------------------------------
	
}

//-----------------------------------------------------------