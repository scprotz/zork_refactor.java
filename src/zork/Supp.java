package zork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Supp
{	
	/* supp.c -- support routines for dungeon */


	/* Define these here to avoid using <stdlib.h> */

	/* We should have a definition for time_t and struct tm by now.  Make
	 * sure we have definitions for the functions we want to call.
	 * The argument to localtime should be P((final time_t *)), but Ultrix
	 * 4.0 leaves out the final in their prototype.  Damn them.
	 */
	/* Terminate the game */

	public static void exit_()
	{
		Supp.errorln("The game is over.");
	    System.exit(0);
	}
	
	/* Get time in hours, minutes and seconds */

	public static void itime_(int[] hrptr, int[] minptr, int[] secptr)
	{
		GregorianCalendar cal = new GregorianCalendar();

		hrptr[0] = cal.get(Calendar.HOUR_OF_DAY);
		minptr[0] = cal.get(Calendar.MINUTE);
		secptr[0] = cal.get(Calendar.SECOND);
	}

	/* Random number generator */
	
	private static Random random  = new Random();
	
	public static void srand(long seed)
	{
		random.setSeed(seed);
	}

	static int rndcnt = 1;
	public static int rnd_(int maxval)
	{
//		return (int)(util.Random.randint() % maxval);
//		return random.nextInt(maxval);
		rndcnt ++;
		return rndcnt % maxval;
	}


	/* The program wants to output a line to the terminal.  If z is not
	 * NULL it is a simple string which is output here; otherwise it
	 * needs some sort of formatting, and is output after this function
	 * returns (if all computers had vprintf I would just it, but they
	 * probably don't).
	 */
	private static StringBuilder out = new StringBuilder();
	private static StringBuilder err = new StringBuilder();
	
	public static String getOut()
	{
		String o = out.toString();
		out.setLength(0);
		return o;
	}
	
	public static String getErr()
	{
		String e = err.toString();
		err.setLength(0);
		return e;
	}
	
	
	public static void print(String str)
	{
		out.append(str);
	}
	
	public static void println(String str)
	{
		print(str + "\n");
	}
	
	public static void error(String str)
	{
		err.append(str);
	}
	
	public static void errorln(String str)
	{
		error(str + "\n");
	}
}
