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
 * Line2d - shape of line, with 2 points.
 * <i>2 mean two coordinates (orthographical surface), d mean double values (high precision floating point).</i>
 * 
 * @version 0.1
 * @since 13.02.2020
 * @authors Denis Z. (code4un@yandex.ru)
**/
public final class Line2d implements IShape
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTANTS
	//===========================================================
	
	//===========================================================
	// FIELDS
	//===========================================================
	
	/** Start-point. **/
	Point2d mStart;
	
	/** Finish-point. **/
	Point2d mFinish;
	
	//===========================================================
	// CONSTRUCTORS
	//===========================================================
	
	/**
	 * Line2d constructor with 
	 * 
	 * @param pStart - Start-Point.
	 * @param pFinish - Finish-Point.
	 * @param allowZeroDenominator - 'false' to throw exception, if denominator of float value (double) is 0 (cant be < 0 though).
	 * @throws - can throw exception:
	 *   - {@link BadLogicException} - thrown if bad arguments provided.
	**/
	public Line2d( final Point2d pStart, final Point2d pFinish, final boolean allowZeroDenominator ) throws BadLogicException
	{
		// Null-checks.
		if ( pStart == null || pFinish == null )
			throw new NullPointerException( "Line2d: null !" );
		
		mStart = (Point2d)pStart.Copy( );
		mFinish = (Point2d)pFinish.Copy( );
	}
	
	//===========================================================
	// GETTERS & SETTERS
	//===========================================================
	
	/**
	 * Calculates sum of start & finish points location 
	 * using vectors of 2 double values.
	 * 
	 * @thread_safety - not thread-safe.
	 * @return - double sum of locations.
	 * @throws - no exceptions guarantee.
	 **/
	public double getLength()
	{ return mStart.getLength() + mFinish.getLength(); }
	
	public static boolean IsLengthEqual( final Line2d pSrc, final Line2d pDst )
	{
		// Null-checks.
		if ( pSrc == null || pDst == null )
			throw new NullPointerException( "Line2d.IsLengthEqual: null !" );
		
		return pSrc.getLength() == pDst.getLength();
	}
	
	//===========================================================
	// IShape
	//===========================================================
	
	@Override
	public int compareTo( IShape pOther )
	{
		// Null-check
		if ( pOther == null )
			throw new NullPointerException("Line2d.compareTo: invalid arguments provided !");
		
		// Line2d
		Line2d rhsLine2d = null;
		
		// Cast to Line2d from IShape
		try { rhsLine2d = (Line2d) pOther; }
		catch( Exception pException ) { throw new ClassCastException( "Line2d.compareTo: invalid shape type LoL ^o^ !" ); }
		
		// Equal Points coordinates ?
		if ( mStart.compareTo( rhsLine2d.mStart ) == 0 
				&& mFinish.compareTo( rhsLine2d.mFinish ) == 0 )
			return 0;
		
		// Compare using length.
		return getLength() - rhsLine2d.getLength() > 0 ? 1 : -1;
	}
	
	//===========================================================
	// METHODS
	//===========================================================	
	
	/**
	 * Check if given lines are the same (all points locations matches).
	 * 
	 * @thread_safety - not thread-safe.
	 * @param pSrc - Lhs (Left hand side).
	 * @param pDst - Rhs (Right hand side).
	 * @return - 'true' if Lines has the exact same points locations.
	 * @throws - can throw exception:
	 *   - {@link BadLogicException} - if some arguments are invalid;
	**/
	static boolean IsEqual( final Line2d pSrc, final Line2d pDst )
	{
		// Null-checks.
		if ( pSrc == null || pDst == null )
			throw new NullPointerException( "Line2d.IsEqual: null !" );
		
		// Compare
		return pSrc.compareTo( pDst ) == 0;
	}
	
	//-----------------------------------------------------------
	
}

//-----------------------------------------------------------