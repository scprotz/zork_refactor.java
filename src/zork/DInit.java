package zork;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class DInit implements Constants
{
	/* INIT-- DUNGEON INITIALIZATION SUBROUTINE */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	Vars vars = null;

	public DInit(Vars vars)
	{
		this.vars = vars;
	}

	/* This is here to avoid depending on the existence of <stdlib.h> */
	public RandomAccessFile dbfile = null;
	public static final String LOCALTEXTFILE = "dtextc.dat";

	/* Read a single two byte int from the index file */

	private static int readInt(RandomAccessFile file) throws IOException
	{
		int ch = file.read();
		return ((ch > 127) ? (ch - 256) : (ch)) * 256 + file.read();
	}

	/* Read a number of two byte ints from the index file */

	private void readInts(int c, int pi[], RandomAccessFile indxfile) throws IOException
	{
		int index = 0;
		while (c-- != 0)
		{
			pi[index] = readInt(indxfile);
			index++;
		}
	}

	/*
	 * Read a partial array of ints. These are stored as index,value pairs.
	 */

	private void rdpartialints(int c, int pi[], RandomAccessFile indxfile) throws IOException
	{
		while (true)
		{
			int i;

			if (c < 255)
			{
				i = indxfile.read();
				if (i == 255)
					return;
			}
			else
			{
				i = readInt(indxfile);
				if (i == -1)
					return;
			}

			pi[i] = readInt(indxfile);
		}
	}

	/* Read a number of one byte flags from the index file */

	private void readFlags(int c, boolean pf[], RandomAccessFile indxfile) throws IOException
	{
		int index = 0;
		while (c-- != 0)
		{
//	      *pf++ = getc(indxfile);
			pf[index] = (indxfile.read() > 0 ? true : false);
//		   *pf++ = indxfile.read();
			index++;
		}
	}

	public boolean init_()
	{
		/* System generated locals */
		boolean ret_val;

		/* Local variables */
		int xmax, r2max;
		int i, j, k;
		RandomAccessFile indxfile;
		int mmax, omax, rmax, vmax, amax, cmax;

		/* NOW START INITIALIZATION PROPER */

		ret_val = false;
		/* ASSUME INIT FAILS. */
		mmax = 1050;
		/* SET UP ARRAY LIMITS. */
		omax = 220;
		rmax = 200;
		vmax = 4;
		amax = 4;
		cmax = 25;
		xmax = 900;
		r2max = 20;

		vars.rmsg_1.mlnt = 0;
		/* INIT ARRAY COUNTERS. */
		vars.objcts_1.olnt = 0;
		vars.rooms_1.rlnt = 0;
		vars.vill_1.vlnt = 0;
		vars.advs_1.alnt = 0;
		vars.cevent_1.clnt = 0;
		vars.exits_1.xlnt = 1;
		vars.oroom2_1.r2lnt = 0;

		vars.state_1.ltshft = 10;
		/* SET UP STATE VARIABLES. */
		vars.state_1.mxscor = vars.state_1.ltshft;
		vars.state_1.egscor = 0;
		vars.state_1.egmxsc = 0;
		vars.state_1.mxload = 100;
		vars.state_1.rwscor = 0;
		vars.state_1.deaths = 0;
		vars.state_1.moves = 0;
//		vars.time_1.pltime = 0;
		vars.state_1.mungrm = 0;
		vars.state_1.hs = 0;
		vars.prsvec_1.action = 0;
		/* CLEAR PARSE VECTOR. */
		vars.prsvec_1.indirect_object = 0;
		vars.prsvec_1.direct_object = 0;
		vars.prsvec_1.prscon = 1;
		vars.orphs_1.oflag = 0;
		/* CLEAR ORPHANS. */
		vars.orphs_1.oact = 0;
		vars.orphs_1.oslot = 0;
		vars.orphs_1.oprep = 0;
		vars.orphs_1.oname = 0;
		vars.hack_1.thfflg = false;
		/* THIEF NOT INTRODUCED BUT */
		vars.hack_1.thfact = true;
		/* IS ACTIVE. */
		vars.hack_1.swdact = false;
		/* SWORD IS INACTIVE. */
		vars.hack_1.swdsta = 0;
		/* SWORD IS OFF. */

		/* INIT DB FILE POINTER. */
		vars.star_1.mbase = 0;
		/* INIT MELEE BASE. */
		/* INIT, PAGE 3 */

		/* INIT ALL ARRAYS. */

		for (i = 1; i <= cmax; ++i)
		{
			/* CLEAR CLOCK EVENTS */
			vars.cevent_1.cflag[i - 1] = false;
			vars.cevent_1.ctick[i - 1] = 0;
			vars.cevent_1.cactio[i - 1] = 0;
			/* L5: */
		}

		vars.findex_1.buoyf = true;
		/* SOME START AS TRUE. */
		vars.findex_1.egyptf = true;
		vars.findex_1.cagetf = true;
		vars.findex_1.mr1f = true;
		vars.findex_1.mr2f = true;
		vars.findex_1.follwf = true;
		vars.findex_1.ormtch = 4;
		/* NUMBER OF MATCHES. */
		vars.findex_1.lcell = 1;
		vars.findex_1.pnumb = 1;
		vars.findex_1.mdir = 270;
		vars.findex_1.mloc = vars.rindex_1.mrb;
		vars.findex_1.cphere = 10;

		for (i = 1; i <= r2max; ++i)
		{
			/* CLEAR ROOM 2 ARRAY. */
			vars.oroom2_1.rroom2[i - 1] = 0;
			vars.oroom2_1.oroom2[i - 1] = 0;
			/* L15: */
		}

		for (i = 1; i <= xmax; ++i)
		{
			/* CLEAR TRAVEL ARRAY. */
			vars.exits_1.travel[i - 1] = 0;
			/* L20: */
		}

		for (i = 1; i <= vmax; ++i)
		{
			/* CLEAR VILLAINS ARRAYS. */
			vars.vill_1.vopps[i - 1] = 0;
			vars.vill_1.vprob[i - 1] = 0;
			vars.vill_1.villns[i - 1] = 0;
			vars.vill_1.vbest[i - 1] = 0;
			vars.vill_1.vmelee[i - 1] = 0;
			/* L30: */
		}

		for (i = 1; i <= omax; ++i)
		{
			/* CLEAR OBJECT ARRAYS. */
			vars.objcts_1.odesc1[i - 1] = 0;
			vars.objcts_1.odesc2[i - 1] = 0;
			vars.objcts_1.odesco[i - 1] = 0;
			vars.objcts_1.oread[i - 1] = 0;
			vars.objcts_1.oactio[i - 1] = 0;
			vars.objcts_1.oflag1[i - 1] = 0;
			vars.objcts_1.oflag2[i - 1] = 0;
			vars.objcts_1.ofval[i - 1] = 0;
			vars.objcts_1.otval[i - 1] = 0;
			vars.objcts_1.osize[i - 1] = 0;
			vars.objcts_1.ocapac[i - 1] = 0;
			vars.objcts_1.ocan[i - 1] = 0;
			vars.objcts_1.oadv[i - 1] = 0;
			vars.objcts_1.oroom[i - 1] = 0;
			/* L40: */
		}

		for (i = 1; i <= rmax; ++i)
		{
			/* CLEAR ROOM ARRAYS. */
			vars.rooms_1.rdesc1[i - 1] = 0;
			vars.rooms_1.rdesc2[i - 1] = 0;
			vars.rooms_1.ractio[i - 1] = 0;
			vars.rooms_1.rflag[i - 1] = 0;
			vars.rooms_1.rval[i - 1] = 0;
			vars.rooms_1.rexit[i - 1] = 0;
			/* L50: */
		}

		for (i = 1; i <= mmax; ++i)
		{
			/* CLEAR MESSAGE DIRECTORY. */
			vars.rmsg_1.rtext[i - 1] = 0;
			/* L60: */
		}

		for (i = 1; i <= amax; ++i)
		{
			/* CLEAR ADVENTURER'S ARRAYS. */
			vars.advs_1.aroom[i - 1] = 0;
			vars.advs_1.ascore[i - 1] = 0;
			vars.advs_1.avehic[i - 1] = 0;
			vars.advs_1.aobj[i - 1] = 0;
			vars.advs_1.aactio[i - 1] = 0;
			vars.advs_1.astren[i - 1] = 0;
			vars.advs_1.aflag[i - 1] = 0;
			/* L70: */
		}

//		vars.debug_1.dbgflg = 0;
//		vars.debug_1.prsflg = 0;
//		vars.debug_1.gdtflg = 0;

		vars.screen_1.fromdr = 0;
		/* INIT SCOL GOODIES. */
		vars.screen_1.scolrm = 0;
		vars.screen_1.scolac = 0;
		/* INIT, PAGE 4 */
		try
		{

			/* NOW RESTORE FROM EXISTING INDEX FILE. */
			dbfile = new RandomAccessFile(new File(LOCALTEXTFILE), "r");

			indxfile = dbfile;

			i = readInt(indxfile);
			j = readInt(indxfile);
			k = readInt(indxfile);

			/* GET VERSION. */
			if (i != vars.vers_1.vmaj || j != vars.vers_1.vmin)
			{
				error1925(i, j, k);
				return ret_val;
			}

			vars.state_1.mxscor = readInt(indxfile);
			vars.star_1.strbit = readInt(indxfile);
			vars.state_1.egmxsc = readInt(indxfile);

			vars.rooms_1.rlnt = readInt(indxfile);
			readInts(vars.rooms_1.rlnt, vars.rooms_1.rdesc1, indxfile);
			readInts(vars.rooms_1.rlnt, vars.rooms_1.rdesc2, indxfile);
			readInts(vars.rooms_1.rlnt, vars.rooms_1.rexit, indxfile);
			rdpartialints(vars.rooms_1.rlnt, vars.rooms_1.ractio, indxfile);
//		System.out.println("vars.rooms_1.ractio = new int[]{");
//		for(int m = 0; m < vars.rooms_1.ractio.length; m++)
//		{
//			System.out.print(vars.rooms_1.ractio[m] + ",");
//		}
//		System.out.println("}");
			vars.rooms_1.ractio = new int[] { 0, 0, 0, 0, 1, 2, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 11, 11, 11, 11, 11, 6, 0, 0, 7, 8, 9, 0, 0,
					0, 10, 0, 0, 0, 0, 12, 12, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 15, 15, 16, 17, 18, 19, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					21, 22, 0, 0, 0, 23, 0, 0, 25, 0, 27, 0, 0, 0, 0, 0, 0, 28, 28, 29, 0, 30, 0,
					31, 0, 32, 0, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 0, 35, 0, 58, 36, 0,
					0, 37, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 26, 0, 48, 0, 0, 47, 42, 41, 40,
					39, 38, 51, 45, 45, 44, 44, 43, 43, 39, 39, 39, 39, 46, 50, 49, 0, 0, 52, 53,
					54, 55, 56, 57, 0, 59, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
			rdpartialints(vars.rooms_1.rlnt, vars.rooms_1.rval, indxfile);
			readInts(vars.rooms_1.rlnt, vars.rooms_1.rflag, indxfile);

			vars.exits_1.xlnt = readInt(indxfile);
			readInts(vars.exits_1.xlnt, vars.exits_1.travel, indxfile);

			vars.objcts_1.olnt = readInt(indxfile);
			readInts(vars.objcts_1.olnt, vars.objcts_1.odesc1, indxfile);
			readInts(vars.objcts_1.olnt, vars.objcts_1.odesc2, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.odesco, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oactio, indxfile);
			readInts(vars.objcts_1.olnt, vars.objcts_1.oflag1, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oflag2, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.ofval, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.otval, indxfile);
			readInts(vars.objcts_1.olnt, vars.objcts_1.osize, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.ocapac, indxfile);
			readInts(vars.objcts_1.olnt, vars.objcts_1.oroom, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oadv, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.ocan, indxfile);
			rdpartialints(vars.objcts_1.olnt, vars.objcts_1.oread, indxfile);

			vars.oroom2_1.r2lnt = readInt(indxfile);
			readInts(vars.oroom2_1.r2lnt, vars.oroom2_1.oroom2, indxfile);
			readInts(vars.oroom2_1.r2lnt, vars.oroom2_1.rroom2, indxfile);

			vars.cevent_1.clnt = readInt(indxfile);
			readInts(vars.cevent_1.clnt, vars.cevent_1.ctick, indxfile);
			readInts(vars.cevent_1.clnt, vars.cevent_1.cactio, indxfile);
			readFlags(vars.cevent_1.clnt, vars.cevent_1.cflag, indxfile);

			vars.vill_1.vlnt = readInt(indxfile);
			readInts(vars.vill_1.vlnt, vars.vill_1.villns, indxfile);
			rdpartialints(vars.vill_1.vlnt, vars.vill_1.vprob, indxfile);
			rdpartialints(vars.vill_1.vlnt, vars.vill_1.vopps, indxfile);
			readInts(vars.vill_1.vlnt, vars.vill_1.vbest, indxfile);
			readInts(vars.vill_1.vlnt, vars.vill_1.vmelee, indxfile);

			vars.advs_1.alnt = readInt(indxfile);
			readInts(vars.advs_1.alnt, vars.advs_1.aroom, indxfile);
			rdpartialints(vars.advs_1.alnt, vars.advs_1.ascore, indxfile);
			rdpartialints(vars.advs_1.alnt, vars.advs_1.avehic, indxfile);
			readInts(vars.advs_1.alnt, vars.advs_1.aobj, indxfile);
			readInts(vars.advs_1.alnt, vars.advs_1.aactio, indxfile);
			readInts(vars.advs_1.alnt, vars.advs_1.astren, indxfile);
			rdpartialints(vars.advs_1.alnt, vars.advs_1.aflag, indxfile);

			vars.star_1.mbase = readInt(indxfile);
			vars.rmsg_1.mlnt = readInt(indxfile);
			readInts(vars.rmsg_1.mlnt, vars.rmsg_1.rtext, indxfile);

			/* Save location of start of message text */
			vars.rmsg_1.mrloc = indxfile.getFilePointer();

			/* INIT DONE. */

			/* THE INTERNAL DATA BASE IS NOW ESTABLISHED. */
			/* SET UP TO PLAY THE GAME. */

			Supp.srand(new Date().getTime());

			vars.play_1.winner = PLAYER;
			vars.last_1.lastit = vars.advs_1.aobj[PLAYER - 1];
			vars.play_1.here = vars.advs_1.aroom[vars.play_1.winner - 1];
			vars.hack_1.thfpos = vars.objcts_1.oroom[vars.oindex_1.thief - 1];
			vars.state_1.bloc = vars.objcts_1.oroom[vars.oindex_1.ballo - 1];
			ret_val = true;
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		return ret_val;
	}

	/* init_ */
	public void error1925(int i, int j, int k)
	{
		if (Vars.DEBUG)
		{
			Supp.errorln(LOCALTEXTFILE + " is version " + i + "." + j + "" + (char) k + ".");
			Supp.errorln("I require version " + vars.vers_1.vmaj + "." + vars.vers_1.vmin
					+ (char) vars.vers_1.vedit + ".");
			error1975();
		}
	}

	public void error1950()
	{
		if (Vars.DEBUG)
		{
			Supp.errorln("I can't open " + LOCALTEXTFILE + ".");
		}
		error1975();
	}

	public void error1975()
	{
		if (Vars.DEBUG)
		{
			Supp.println("Suddenly a sinister, wraithlike figure appears before you,");
			Supp.println("seeming to float in the air.  In a low, sorrowful voice he says,");
			Supp.println("\"Alas, the very nature of the world has changed, and the dungeon");
			Supp.println("cannot be found.  All must now pass away.\"  Raising his oaken staff");
			Supp.println("in farewell, he fades into the spreading darkness.  In his place");
			Supp.println("appears a tastefully lettered sign reading:");
			Supp.println("");
			Supp.println("                       INITIALIZATION FAILURE");
			Supp.println("");
			Supp.println("The darkness becomes all encompassing, and your vision fails.");
		}
	}

}
