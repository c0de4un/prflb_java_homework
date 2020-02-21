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

package io.gihub.c0de4un.prflb.salarymail;

//===========================================================
// IMPORTS
//===========================================================

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import io.gihub.c0de4un.prflb.salarymail.mail.MailMessage;
import io.gihub.c0de4un.prflb.salarymail.mail.MailService;
import io.gihub.c0de4un.prflb.salarymail.mail.Salary;

//===========================================================
// TYPES
//===========================================================

/**
 * DefaultLauncher - entry class.
 * 
 * @version 0.1
 * @since 20.02.2020
 * @author Denis Z. (c0de4un@yandex.ru)
**/
public class DefaultLauncher
{
	
	//-----------------------------------------------------------
	
	//===========================================================
	// CONSTRUCTORS
	//===========================================================
	
	/** @deleted DefaultLauncher default constructor. **/
	private DefaultLauncher() { }

	//===========================================================
	// GETTERS & SETTERS
	//===========================================================

	
	
	//===========================================================
	// METHODS
	//===========================================================
	
//	/**
//	 * Parse user-input.
//	 * 
//	 * @thread_safety - calling-thread blocked.
//	 * @throws - can throw exception:
//	 *   - IllegalArgumentException if invalid data provided (malformat);
//	 **/
//	private static void parseCMDInput( SalaryMailScenario pScenario )
//	{
//		
//		// INFO
//		System.out.println( "Waiting user input . . .\n\n"
//				+ "Please enter From: " );
//		
//		// Create Scanner.
//		Scanner scanner = new Scanner( System.in );
//		
//		try
//		{
//			// From
//			pScenario.mMailFrom = SalaryMailScenario.parseEmail( scanner.nextLine( ) ); // I'm just too lazy to write same stuff again
//			
//			// To
//			System.out.println( "Please enter To: " );
//			pScenario.mMailTo = SalaryMailScenario.parseEmail( scanner.nextLine( ) );
//			
//			// Salary
//			System.out.println( "Please enter Salary (Integer): " );
//			pScenario.mMailSalary = scanner.nextInt( );
//		}
//		finally
//		{
//			// Close I/O
//			if ( scanner != null )
//			{
//				try { scanner.close( ); }
//				finally { /** -void- **/ }
//			}
//		}
//		
//	}
	
	/** main **/
	public static void main( String[] pArgs )
	{
		// INFO
		/*System.out.println( "\n\n << = = = = = = = = = = = = = = = = = = = = = ="
				+ "Welcome to the AtomiX Testing Systemz v0.1.2\n\n"
				+ "This app is a test-cast for Salary-Mail Service.\n\n"
				+ "This app supports two input methods: arguments & user-console."
				+ "To set arguments, use: -from <sa@ty.ru> -to <sam@ty.ru> -sal <100>\n"
				+ "For randomizer, just enter -rnd"
				+ "Or use input, first value is from, then to, then salary." );*/
		
		// Scenario Data Container.
		//SalaryMailScenario scenario = new SalaryMailScenario(); // Dynamic allocation.
		
		// Guarded-Block
		try
		{
			
			// Check cmd-Arguments
			//if ( pArgs.length > 0 )
				//scenario.ParseCMD( pArgs ); // Parse cmd for Auto-Scenario
			//else
				//parseCMDInput( scenario );// Manual Input Scenario
			
			// Process.
			System.out.println( "Processing synthetic salary-email-service. . ." );
			
			String randomFrom = "sa@ty.org"; // ����� ��������� ������. 
			String randomTo = "sam@ty.kz";  // ����� ��������� ������. 
			int randomSalary = 100; // ����� ��������� �����.
			
			// Create #1 MailMessage.
			MailMessage firstMessage = new MailMessage( "Robert Howard", "H.P. Lovecraft", "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!" );
			
			// ��������, ��� ��������� ��������� ��� ����.
			assert firstMessage.getFrom().equals("Robert Howard"): "Wrong firstMessage from address";
			assert firstMessage.getTo().equals("H.P. Lovecraft"): "Wrong firstMessage to address";
			assert firstMessage.getContent().endsWith("Howard!"): "Wrong firstMessage content ending";
			
			// Create #2 MailMessage. 
			MailMessage secondMessage = new MailMessage(
			        "Jonathan Nolan",
			        "Christopher Nolan",
			        "����, ������ ��� ��� ������ ������ ����, ����� ����������� ��� �������� ������� �. ��� �� ������!"
			);

			// Create #3 MailMessage.
			MailMessage thirdMessage = new MailMessage(
			        "Stephen Hawking",
			        "Christopher Nolan",
			        "� ��� � �� ����� ������������."
			);
			
			// Messages to List container.
			List<MailMessage> messages = Arrays.asList( firstMessage, secondMessage, thirdMessage );
			
			// �������� ��������� �������.
			MailService<String> mailService = new MailService<>();
			
			// ��������� ������ ����� �������� ��������
			messages.stream().forEachOrdered( mailService );

			// ��������� "��������� �����",
			//   ��� �� ���������� ����� �������� ������ ���������, ������� ���� ��� ����������
			Map<String, List<String>> mailBox = mailService.getMailBox();
			
			//�������� ��������� �����
			assert mailBox.get("H.P. Lovecraft").equals(
			        Arrays.asList(
			                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
			        )
			): "wrong mailService mailbox content (1)";

			assert mailBox.get("Christopher Nolan").equals(
			        Arrays.asList(
			                "����, ������ ��� ��� ������ ������ ����, ����� ����������� ��� �������� ������� �. ��� �� ������!",
			                "� ��� � �� ����� ������������."
			        )
			): "wrong mailService mailbox content (2)";

			assert mailBox.get(randomTo).equals( Collections.<String>emptyList() ): "wrong mailService mailbox content (3)";
			
			// IFNO
			System.out.println( "UC_1_MailMessage Complete" );
			
			// �������� ������ �� ���� �������.
			Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
			Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
			Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

			// �������� ��������� �������, ��������������� ��������.
			MailService<Integer> salaryService = new MailService<>();

			// ��������� ������ ������� �������� ��������
			Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

			//�������� ��������� �����
			Map<String, List<Integer>> salaries = salaryService.getMailBox();
			assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)): "wrong salaries mailbox content (1)";
			assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)): "wrong salaries mailbox content (2)";
			assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)): "wrong salaries mailbox content (3)";
		
			// IFNO
			System.out.println( "UC_1_Salary Complete" );
			
		}
		catch( Exception crutiaclExcInfo )
		{
			
			// Wtf ?
			System.out.println( "ERROR: " + crutiaclExcInfo.getMessage( ) );
			
			// Really bad c0de. 
			System.exit( -1 );
			
		}
		
		// INFO
		System.out.println( "\n\n << = = = = = = = = = = = = = = = = = = = = = =" );
	}
	
	//-----------------------------------------------------------
	
} /// DefaultLauncher

//-----------------------------------------------------------