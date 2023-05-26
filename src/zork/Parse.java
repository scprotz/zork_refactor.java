package zork;

public class Parse
{
	/* parse.h -- header file for parsing structures used by dungeon */

	/* These structures are only used by the parsing routines.  They are in
	 * their own file since they are so large.
	 */

//	#ifndef PARSE_H
//	#define PARSE_H

//	#ifndef EXTERN
//	#define EXTERN extern
//	#endif

	public class pv_ {
	    int act;
	    int[] objvec = new int[2];
	    int[] prpvec = new int[2];
	    
	    public int o1(){  return objvec[0];  }
	    public int o2(){  return objvec[1];  }
	    public int p1(){  return prpvec[0];  }
	    public int p2(){  return prpvec[1];  }
	    
	    public void o1(int o1){  objvec[0] = o1;  }
	    public void o2(int o2){  objvec[1] = o2;  }
	    public void p1(int p1){  prpvec[0] = p1;  }
	    public void p2(int p2){  prpvec[1] = p2;  }
	    
	};
//	pv_;

	public pv_ pv_1 = new pv_();
//	#define pv_1 pv_
	
//	#define pvec ((int *)&pv_1)
//	#define objvec ((int *)&pv_1 + 1)
//	#define prpvec ((int *)&pv_1 + 3)

	public class syntax_ {
	    int vflag, dobj, dfl1, dfl2, dfw1, dfw2, iobj, ifl1, ifl2, ifw1, ifw2;
	    
	    public void syn(int index, int value)
	    {
	    	switch(index)
	    	{
	    		case 0: vflag = value; break;
	    		case 1: dobj = value; break;
	    		case 2: dfl1 = value; break;
	    		case 3: dfl2 = value; break;
	    		case 4: dfw1 = value; break;
	    		case 5: dfw2 = value; break;
	    		case 6: iobj = value; break;
	    		case 7: ifl1 = value; break;
	    		case 8: ifl2 = value; break;
	    		case 9: ifw1 = value; break;
	    		case 10: ifw2 = value; break;
	    		
	    		default:
	    			throw new RuntimeException("Error decoding syn(). " + index );
	    	}
	    }
	};
//	syntax_;

	public syntax_ syntax_1 = new syntax_();
//	#define syntax_1 syntax_
//	#define syn ((int *)&syntax_1)
	

	/* Object flags (objflg) */

	public static final int VABIT = 16384;
	public static final int VRBIT = 8192;
	public static final int VTBIT = 4096;
	public static final int VCBIT = 2048;
	public static final int VEBIT = 1024;
	public static final int VFBIT = 512;
	public static final int VPMASK = 511;

	/* Syntax flags (synflg) */

	public static final int SDIR = 16384;
	public static final int SIND = 8192;
	public static final int SSTD = 4096;
	public static final int SFLIP = 2048;
	public static final int SDRIV = 1024;
	public static final int SVMASK = 511;

	/* BUZZ WORDS--	IGNORED IN SYNTACTIC PROCESSING */

	/*   THE FOLLOWING DATA STATEMENT WAS CONVERTED FROM: */

	/* 	DATA BVOC/3RAND,0,2RBY,0,2RIS,0,1RA,0, */
	/* &		2RAN,0,3RTHE,0,3RRUN,0,2RGO,0,3RPRO,3RCEE,0,0/ */

	public class buzvoc_ {
	    int bvoc[] = new int[]{ 2164, 0, 4200, 0, 15160, 0, 1600, 0, 2160, 0, 32325, 0, 
			    29654, 0, 11800, 0, 26335, 5005, 0, 0 };
	};
//	buzvoc_
//	#ifdef INIT
//		= { 2164, 0, 4200, 0, 15160, 0, 1600, 0, 2160, 0, 32325, 0, 
//		    29654, 0, 11800, 0, 26335, 5005, 0, 0 }
//	#endif
//		;

//	#define buzvoc_1 buzvoc_
	public buzvoc_ buzvoc_1 = new buzvoc_();

	/* PREPOSITIONS--	MAPS PREPOSITIONS TO INDICES */

	/*   THE FOLLOWING DATA STATEMENT WAS CONVERTED FROM: */

	/* 	DATA PVOC/3ROVE,1RR,1,3RWIT,1RH,2,3RUSI,2RNG,2,3RTHR,3ROUG,2, */
	/* &		2RAT,0,3,2RTO,0,4,2RIN,0,5,3RINS,3RIDE,5,3RINT,1RO,5, */
	/* &		3RDOW,1RN,6,2RUP,0,7,3RUND,2RER,8,2ROF,0,9,2RON,0,10, */
	/* &		3ROFF,0,11/ */

	public class prpvoc_ {
	    public int pvoc[] = new int[]{ 24885, 28800, 1, 37180, 12800, 2, 34369, 22680, 2, 32338, 
			    24847, 2, 2400, 0, 3, 32600, 0, 4, 14960, 0, 5, 14979, 14565, 5, 
			    14980, 0, 5, 7023, 22400, 6, 34240, 0, 7, 34164, 8720, 8, 24240, 
			    0, 9, 24560, 0, 10, 24246, 0, 11 };
	};
//	prpvoc_
//	#ifdef INIT
//		= { 24885, 28800, 1, 37180, 12800, 2, 34369, 22680, 2, 32338, 
//		    24847, 2, 2400, 0, 3, 32600, 0, 4, 14960, 0, 5, 14979, 14565, 5, 
//		    14980, 0, 5, 7023, 22400, 6, 34240, 0, 7, 34164, 8720, 8, 24240, 
//		    0, 9, 24560, 0, 10, 24246, 0, 11 }
//	#endif
//		;

//	#define prpvoc_1 prpvoc_
	public prpvoc_ prpvoc_1 = new prpvoc_();

	/* DIRECTIONS--	MAPS DIRECTIONS TO INDICES */

	/*   THE FOLLOWING DATA STATEMENT WAS CONVERTED FROM: */

	/* 	DATA DVOC/1RN,0,"2000,3RNOR,2RTH,"2000,1RS,0,"12000, */
	/* &	 1RE,0,"6000,3REAS,1RT,"6000,1RW,0,"16000,3RWES,1RT,"16000, */
	/* &	 2RSE,0,"10000,2RSW,0,"14000, */
	/* &	 2RNE,0,"4000,2RNW,0,"20000, */
	/* &	 1RU,0,"22000,2RUP,0,"22000,1RD,0,"24000,3RDOW,1RN,"24000, */
	/* &	 3RLAU,3RNCH,"26000,3RLAN,1RD,"30000,3RENT,2RER,"32000, */
	/* &	 3REXI,1RT,"34000,3ROUT,0,"34000,3RLEA,2RVE,"34000, */
	/* &	 3RTRA,3RVEL,"36000,3RSOU,2RTH,"12000, */
	/* &	 2RIN,0,"32000, */
	/* &	 3RCRO,2RSS,"36000/ */

	public class dirvoc_ {
	    public int dvoc[] = new int[]{ 22400, 0, 1024, 23018, 32320, 1024, 30400, 0, 5120, 8000, 0,
			    3072, 8059, 32000, 3072, 36800, 0, 7168, 37019, 32000, 7168, 
			    30600, 0, 4096, 31320, 0, 6144, 22600, 0, 2048, 23320, 0, 8192, 
			    33600, 0, 9216, 34240, 0, 9216, 6400, 0, 10240, 7023, 22400, 
			    10240, 19261, 22528, 11264, 19254, 6400, 12288, 8580, 8720, 13312,
			    8969, 32000, 14336, 24860, 0, 14336, 19401, 35400, 14336, 32721, 
			    35412, 15360, 31021, 32320, 5120, 14960, 0, 13312, 5535, 31160, 
			    15360 };
	};
//	dirvoc_
//	#ifdef INIT
//		= { 22400, 0, 1024, 23018, 32320, 1024, 30400, 0, 5120, 8000, 0,
//		    3072, 8059, 32000, 3072, 36800, 0, 7168, 37019, 32000, 7168, 
//		    30600, 0, 4096, 31320, 0, 6144, 22600, 0, 2048, 23320, 0, 8192, 
//		    33600, 0, 9216, 34240, 0, 9216, 6400, 0, 10240, 7023, 22400, 
//		    10240, 19261, 22528, 11264, 19254, 6400, 12288, 8580, 8720, 13312,
//		    8969, 32000, 14336, 24860, 0, 14336, 19401, 35400, 14336, 32721, 
//		    35412, 15360, 31021, 32320, 5120, 14960, 0, 13312, 5535, 31160, 
//		    15360 }
//	#endif
//		;

	public dirvoc_ dirvoc_1 = new dirvoc_();
//	#define dirvoc_1 dirvoc_

	/* ADJECTIVES--	MAPS ADJECTIVES TO OBJECT NUMBERS */

	/* EACH ENTRY IS VARIABLE LENGTH AND CONSISTS OF A TWO WORD */
	/* ADJECTIVE IN RADIX-50 FOLLOWED BY ONE OR MORE OBJECT NUMBERS. */
	/* NOTE THAT ADJECTIVES CAN BE DISTINGUISHED FROM OBJECTS AS */
	/* FOLLOWS-- ALL ADJECTIVES ARE .GE. 1RA (1600), WHILE ALL OBJECTS */
	/* ARE .LE. OLNT (255 MAX). */

	/*   THE DATA STATEMENT BELOW WAS CONVERTED FROM: */

	/* 	DATA AVOC1/3RBRO,2RWN,1,81,3RELO,3RNGA,1,3RHOT,0,3,3RPEP,3RPER,3, */
	/* &	 3RVIT,3RREO,4,3RJAD,1RE,6,3RHUG,1RE,8,3RENO,3RRMO,8,122, */
	/* &	 3RTRO,3RPHY,9,3RCLE,2RAR,10,3RLAR,2RGE,12,26,47,95,96,123, */
	/* &	 133,135,146,147,150,176,3RNAS,2RTY,13,3RELV,3RISH,14, */
	/* &	 3RBRA,2RSS,15,16,46,156, */
	/* &	 3RBRO,3RKEN,16,22,92,113,155,158,3RORI,3RENT,17, */
	/* &	 3RBLO,3RODY,20,3RRUS,2RTY,21,3RBUR,3RNED,22, */
	/* &	 3RDEA,1RD,22,3ROLD,0,25,41,44,45,3RLEA,3RTHE,25, */
	/* &	 3RPLA,3RTIN,26,3RPEA,2RRL,27, */
	/* &	 3RMOB,1RY,31,3RCRY,3RSTA,32,126, */
	/* &	 3RGOL,1RD,33,85,104,157,158,188, */
	/* &	 3RIVO,2RRY,34,3RSAP,3RPHI,37,3RWOO,3RDEN,38,67,136,137, */
	/* &	 165,173,174,175,3RWOO,1RD,38,67,136,137,165,173,174,175, */
	/* &	 3RSTE,2REL,39,125,189, */
	/* &	 3RDEN,3RTED,39,3RFAN,2RCY,40,3RANC,3RIEN,41,44, */
	/* &	 3RSMA,2RLL,5,46,52,53,89,102,103,153,187, */
	/* &	 3RBLA,2RCK,47,162,3RTOU,1RR,49, */
	/* &	 3RVIS,3RCOU,55,3RVIC,3RIOU,62, */
	/* &	 3RGLA,2RSS,10,126,132,3RTRA,1RP,66/ */

	/* 	DATA AVOC2/3RFRO,2RNT,68,3RSTO,2RNE,69,150,214,3RMAN,3RGLE,72, */
	/* &	 3RRED,0,79,94,140,161,170,171,3RYEL,3RLOW,80,159, */
	/* &	 3RBLU,1RE,82,112,114,141, */
	/* &	 3RVAM,3RPIR,83,3RMAG,2RIC,90, */
	/* &	 3RSEA,3RWOR,90,3RTAN,0,91,3RSHA,2RRP,92, */
	/* &	 3RWIC,3RKER,98,3RCLO,2RTH,100, */
	/* &	 3RBRA,3RIDE,101, */
	/* &	 3RGAU,2RDY,108,3RSQU,3RARE,109,127,3RCLA,1RY,109, */
	/* &	 3RSHI,2RNY,110,3RTHI,1RN,110, */
	/* &	 3RGRE,2REN,115,143,3RPUR,3RPLE,116,3RWHI,2RTE,117,147,160, */
	/* &	 3RMAR,3RBLE,119,3RCOK,1RE,121,3REMP,2RTY,121, */
	/* &	 3RROU,2RND,128,3RTRI,3RANG,129, */
	/* &	2 3RRAR,1RE,134,3ROBL,3RONG,135,3REAT,3R$ME,138, */
	/* &	 3REAT,2RME,138,3RORA,3RNGE,139,3RECC,1RH,141/ */

	/* 	DATA AVOC3/3RROC,2RKY,147,3RSHE,2RER,147, */
	/* &	 3R200,0,148,3RNEA,1RT,148,3RSHI,3RMME,151, */
	/* &	 3RZUR,3RICH,152,3RBIR,2RDS,153,154,155, */
	/* &	 3RENC,3RRUS,154,155,3RBEA,3RUTI,156,3RCLO,3RCKW,157,158, */
	/* &	 3RMEC,3RHAN,157,158, */
	/* &	 3RMAH,3ROGA,163,3RPIN,1RE,164,3RLON,1RG,166, */
	/* &	 3RCEN,3RTER,166,3RSHO,2RRT,167,1RT,0,168, */
	/* &	 3RCOM,3RPAS,169,211,3RBRO,3RNZE,172,3RCEL,1RL,174,175, */
	/* &	 3RLOC,3RKED,174,3RSUN,0,177, */
	/* &	 3RBAR,1RE,200,3RSON,1RG,203, */
	/* &	 3RNOR,2RTH,205,3RNOR,3RTHE,205,3RSOU,2RTH,206, */
	/* &	 3RSOU,3RTHE,206,3REAS,1RT,207,3REAS,3RTER,207, */
	/* &	 3RWES,1RT,208,3RWES,3RTER,208,3RDUN,3RGEO,215/ */

	public int avoc[]
//	#ifdef INIT
		= new int[]{ 3935, 37360, 1, 81, 8495, 22681, 1, 13420, 0, 3, 25816, 
		    25818, 3, 35580, 29015, 4, 16044, 8000, 6, 13647, 8000, 8, 8575, 
		    29335, 8, 122, 32735, 25945, 9, 5285, 2320, 10, 19258, 11400, 12, 
		    26, 47, 95, 96, 123, 133, 135, 146, 147, 150, 176, 22459, 33000, 
		    13, 8502, 15168, 14, 3921, 31160, 15, 16, 46, 156, 3935, 17814, 
		    16, 22, 92, 113, 155, 158, 24729, 8580, 17, 3695, 24185, 20, 
		    29659, 33000, 21, 4058, 22604, 22, 6601, 6400, 22, 24484, 0, 25, 
		    41, 44, 45, 19401, 32325, 25, 26081, 32374, 26, 25801, 29280, 27, 
		    21402, 40000, 31, 5545, 31201, 32, 126, 11812, 6400, 33, 85, 104, 
		    157, 158, 188, 15295, 29800, 34, 30456, 25929, 37, 37415, 6614, 
		    38, 67, 136, 137, 165, 173, 174, 175, 37415, 6400, 38, 67, 136, 
		    137, 165, 173, 174, 175, 31205, 8480, 39, 125, 189, 6614, 32204, 
		    39, 9654, 5800, 40, 2163, 14614, 41, 44, 30921, 19680, 5, 46, 52, 
		    53, 89, 102, 103, 153, 187, 3681, 5240, 47, 162, 32621, 28800, 49,
		     35579, 5421, 55, 35563, 15021, 62, 11681, 31160, 10, 126, 132, 
		    32721, 25600, 66, 10335, 23200, 68, 31215, 22600, 69, 150, 214, 
		    20854, 11685, 72, 29004, 0, 79, 94, 140, 161, 170, 171, 40212, 
		    19823, 80, 159, 3701, 8000, 82, 112, 114, 141, 35253, 25978, 83, 
		    20847, 14520, 90, 30601, 37418, 90, 32054, 0, 91, 30721, 29440, 
		    92, 37163, 17818, 98, 5295, 32320, 100, 3921, 14565, 101, 11261, 
		    7400, 108, 31101, 2325, 109, 127, 5281, 4000, 109, 30729, 23400, 
		    110, 32329, 22400, 110, 11925, 8560, 115, 143, 26458, 26085, 116, 
		    37129, 32200, 117, 147, 160, 20858, 3685, 119, 5411, 8000, 121, 
		    8536, 33000, 121, 29421, 22560, 128, 32729, 2167, 129, 28858, 
		    8000, 134, 24092, 24567, 135, 8060, 43725, 138, 8060, 21000, 138, 
		    24721, 22685, 139, 8123, 12800, 141, 29403, 18600, 147, 30725, 
		    8720, 147, 52430, 0, 148, 22601, 32000, 148, 30729, 21325, 151, 
		    42458, 14528, 152, 3578, 7160, 153, 154, 155, 8563, 29659, 154, 
		    155, 3401, 34409, 156, 5295, 5263, 157, 158, 21003, 12854, 157, 
		    158, 20848, 24281, 163, 25974, 8000, 164, 19814, 11200, 166, 5014,
		     32218, 166, 30735, 29600, 167, 32000, 0, 168, 5413, 25659, 169, 
		    211, 3935, 23445, 172, 5012, 19200, 174, 175, 19803, 17804, 174, 
		    31254, 0, 177, 3258, 8000, 200, 31014, 11200, 203, 23018, 32320, 
		    205, 23018, 32325, 205, 31021, 32320, 206, 31021, 32325, 206, 
		    8059, 32000, 207, 8059, 32218, 207, 37019, 32000, 208, 37019, 
		    32218, 208, 7254, 11415, 215, -1 }
//	#endif
		;

	/* VERBS--	MAPS VERBS TO SYNTAX SLOTS */

	/* EACH ENTRY IS VARIABLE LENGTH AND CONSISTS OF ONE OR MORE */
	/* TWO WORD VERBS IN RADIX-50 FOLLOWED BY A SYNTAX WORD COUNT */
	/* FOLLOWED BY ONE OR MORE SYNTAXES.  NOTE THAT VERBS CAN BE */
	/* DISTINGUISHED FROM WORD COUNTS AS FOLLOWS-- */
	/* ALL VERBS ARE .GE. 1RA (1600), WHILE ALL SYNTAX WORD COUNTS */
	/* ARE .LE. 255. */

	/* SYNTAX ENTRIES CONSIST OF A FLAG WORD FOLLOWED BY 0, 1, OR 2 */
	/* OBJECT DESCRIPTIONS.  THE FLAG WORD HAS THE FOLLOWING FORMAT-- */

	/* BIT <14>	IF 1, SYNTAX INCLUDES DIRECT OBJECT */
	/* BIT <13>	IF 1, SYNTAX INCLUDES INDIRECT OBJECT */
	/* BIT <12>	IF 1, DIRECT OBJECT IS IMPLICIT (STANDARD FORM) */
	/* BIT <11>	IF 1, DIRECT AND INDIRECT OBJECT MUST BE SWAPPED */
	/* 			AFTER SYNTAX PROCESSING */
	/* BIT <10>	IF 1, THIS IS DEFAULT SYNTAX FOR ORPHANERY */
	/* BITS <8:0>	VERB NUMBER FOR VAPPLI */

	/* OBJECT DESCRIPTIONS CONSIST OF A FLAG WORD AND TWO FWIM WORDS. */
	/* THE FLAG WORD HAS THE FOLLOWING FORMAT-- */

	/* BIT <14>	IF 1, SEARCH ADVENTURER FOR OBJECT */
	/* BIT <13>	IF 1, SEARCH ROOM FOR OBJECT */
	/* BIT <12>	IF 1, PARSER WILL TRY TO TAKE OBJECT */
	/* BIT <11>	IF 1, ADVENTURER MUST HAVE OBJECT */
	/* BIT <10>	IF 1, QUALIFYING BITS (NORMALLY -1,-1) ARE SAME */
	/* 			AS FWIM BITS */
	/* BIT <9>	IF 1, OBJECT MUST BE REACHABLE */
	/* BITS <8:0>	PREPOSITION NUMBER FOR SYNMCH */

	/* THE FWIM WORDS HAVE THE SAME FORMAT AS THE TWO OBJECT FLAG WORDS. */

	/* NOTE THAT BITS 12 AND 11 OF OBJECT DESCRIPTIONS ACTUALLY HAVE */
	/* FOUR DISTINCT STATES-- */

	/* 	BIT 12	BIT 11	MDLDESC		INTERPRETATION */
	/* 	------	------	-------		--------------- */

	/* 	  0	  0	 --		NO PARSER ACTION */
	/* 	  0	  1	 HAVE		ADVENTURER MUST HAVE OBJECT */
	/* 	  1	  0	 TRY		TRY TO TAKE, DONT CARE IF FAIL */
	/* 	  1	  1	 TAKE		TRY TO TAKE, CARE IF FAIL */

	/*   THE FOLLOWING DATA STATEMENT WAS ORIGINALLY: */

	/* 	DATA VVOC1/3RBRI,2REF,1,70,3RVER,3RBOS,1,71, */
	/* &	 3RSUP,3RERB,1,72,3RSTA,1RY,1,73,3RVER,3RSIO,1,74, */
	/* &	 3RSWI,1RM,3RBAT,2RHE,3RWAD,1RE,1,75,3RGER,3RONI,1,76, */
	/* &	 3RULY,3RSSE,3RODY,3RSSE,1,77, */
	/* &	 3RWEL,1RL,1,78,3RPRA,1RY,1,79,3RTRE,3RASU,1,80, */
	/* &	 3RTEM,3RPLE,1,81,3RBLA,2RST,1,82,3RSCO,2RRE,1,83, */
	/* &	 1RQ,0,3RQUI,1RT,1,84,3RHEL,1RP,1,40,3RINF,1RO,1,41, */
	/* &	 3RHIS,3RTOR,3RUPD,3RATE,1,42,3RBAC,1RK,1,43, */
	/* &	 3RSIG,1RH,3RMUM,3RBLE,1,44/ */

	/* 	DATA VVOC1A/3RCHO,2RMP,3RLOS,1RE,3RBAR,1RF,1,45, */
	/* &	 3RDUN,3RGEO,1,46,3RFRO,3RBOZ,1,47,3RFOO,0,3RBLE,3RTCH, */
	/* &	 3RBAR,0,1,48,3RREP,3RENT,1,49,3RHOU,2RRS,3RSCH,3REDU,1,50, */
	/* &	 3RWIN,0,1,51,3RYEL,1RL,3RSCR,3REAM,3RSHO,2RUT,1,52, */
	/* &	 3RHOP,0,3RSKI,1RP,1,53,3RFUC,1RK,3RSHI,1RT,3RDAM,1RN, */
	/* &	 3RCUR,2RSE,1,54,3RZOR,1RK,1,55,3RGRA,3RNIT,1,"50070, */
	/* &	 3RSAV,1RE,1,149,3RRES,3RTOR,1,150,3RTIM,1RE,1,90, */
	/* &	 3RDIA,3RGNO,1,94,3REXO,3RRCI,1,105,3RINV,3RENT, */
	/* &	 1RI,0,1,133,3RWAI,1RT,1,128, */
	/* &	 3RINC,3RANT,1,95,3RANS,3RWER,1,96/ */

	/* 	DATA VVOC1B/3RAGA,2RIN,1,57,3RNOO,2RBJ,1,58, */
	/* &	 3RBUG,0,3RGRI,2RPE,3RCOM,3RPLA,1,59, */
	/* &	 3RFEA,3RTUR,3RCOM,3RMEN,3RSUG,3RGES,3RIDE,1RA,1,60, */
	/* &	 3RROO,1RM,1,65,3ROBJ,3RECT,1,66,3RRNA,2RME,1,67/ */

	/* 	DATA VVOC2/3RDEF,3RLAT,1,"50147, */
	/* &	 3RDES,3RCRI,3RWHA,1RT,3REXA,3RMIN,1,"50170, */
	/* &	 3RFIL,1RL,11,"60206,"61000,"200,0,"61002,"400,0, */
	/* &		"40206,"61000,"200,0, */
	/* &	 3RFIN,1RD,3RSEE,1RK,3RWHE,2RRE,3RSEE,0,4,"40177,"60000,-1,-1, */
	/* &	 3RFOL,3RLOW,2,"125,"50125, */
	/* &	 3RKIC,1RK,3RBIT,1RE,3RTAU,2RNT,1,"50153,3RLOW,2RER,1,"50156, */
	/* &	 3RPUS,1RH,3RPRE,2RSS,1,"50160,3RRIN,1RG,3RPEA,1RL,1,"50127, */
	/* &	 3RRUB,0,3RCAR,3RESS,3RTOU,2RCH,3RFON,3RDLE,1,"50157, */
	/* &	 3RSHA,2RKE,1,"50171,3RSPI,1RN,1,"50201, */
	/* &	 3RUNT,2RIE,3RFRE,1RE,1,"50161,3RWAL,1RK,9,"50216, */
	/* &		"40126,"61002,-1,-1,"40126,"61005,-1,-1/ */

	/* 	DATA VVOC3/3RATT,3RACK,3RFIG,2RHT,3RINJ,3RURE,3RHIT,0,3RHUR,1RT, */
	/* &		7,"60215,"21000,0,"200,"44002,0,"1000, */
	/* &	 3RBOA,2RRD,4,"40202,"21000,0,"2, */
	/* &	 3RBRU,2RSH,3RCLE,2RAN,5,"52130,"70130,"61002,-1,-1, */
	/* &	 3RBUR,1RN,3RIGN,3RITE,3RINC,3RINE,7,"60211,"61000,"20,0, */
	/* &		"64002,"10,0, */
	/* &	 3RCLI,2RMB,12,"40235,"20007,0,"4000, */
	/* &		"40236,"20006,0,"4000,"40234,"20000,0,"4000, */
	/* &	 3RCLO,2RSE,4,"40176,"61000,"10200,0, */
	/* &	 3RDIG,0,4,"40131,"44002,"4,0, */
	/* &	 3RDIS,3REMB,4,"40203,"20000,0,"2, */
	/* &	 3RDRI,2RNK,3RIMB,3RIBE,3RSWA,3RLLO,4,"40210,"61000,"400,0, */
	/* &	 3RDRO,1RP,3RREL,3REAS,11,"42221,"41000,-1,-1, */
	/* &		"60221,"41000,-1,-1,"61005,-1,-1, */
	/* &	 3REAT,0,3RCON,3RSUM,3RGOB,3RBLE,3RMUN,2RCH,3RTAS,2RTE, */
	/* &		4,"40207,"75000,"2000,0, */
	/* &	 3REXT,3RING,3RDOU,2RSE,4,"40174,"75000,"100,0/ */

	/* 	DATA VVOC4/3RGIV,1RE,3RHAN,1RD,3RDON,3RATE,11,"72222,"21004, */
	/* &		"40,0,"64222,"21000,"40,0,"61000,-1,-1, */
	/* &	 3RHEL,2RLO,2RHI,0,2,"2227,"50227, */
	/* &	 3RBLO,1RW,15,"62146,"61007,-1,-1,"61002,"4,0, */
	/* &		"40160,"61007,-1,-1,"40165,"61005,-1,-1, */
	/* &	 3RINF,3RLAT,4,"70146,"61002,"4,0, */
	/* &	 3RJUM,1RP,3RLEA,1RP,5,"133,"40133,"61001,-1,-1, */
	/* &	 3RKIL,1RL,3RMUR,3RDER,3RSLA,1RY,3RSTA,1RB,3RDIS,3RPAT, */
	/* &		7,"60213,"21000,0,"200, */
	/* &		"44002,0,"1000, */
	/* &	 3RKNO,2RCK,3RRAP,0,12,"42166,"61003,-1,-1, */
	/* &		"40166,"61012,-1,-1,"40215,"23006,"40,0, */
	/* &	 3RLIG,2RHT,11,"42173,"75000,"100,0, */
	/* &		"60211,"61000,"100,0,"54002,"10,0, */
	/* &	 3RLOC,1RK,4,"40134,"20000,-1,-1/ */

	/* 	DATA VVOC5/3RLOO,1RK,1RL,0,3RSTA,2RRE,3RGAZ,1RE, */
	/* &		13,"167,"40167,"60003,-1,-1, */
	/* &		"40231,"61010,-1,-1,"40230,"60005,-1,-1, */
	/* &	 3RMEL,1RT,3RLIQ,3RUIF,4,"70145,"61002,"10,0, */
	/* &	 3RMOV,1RE,4,"40172,"20000,-1,-1, */
	/* &	 3RPUL,1RL,3RTUG,0,8,"42172,"21000,-1,-1, */
	/* &		"40172,"21012,-1,-1, */
	/* &	 3RMUN,1RG,3RHAC,1RK,3RFRO,1RB,3RDAM,3RAGE, */
	/* &		5,"52212,"70212,"44002,-1,-1, */
	/* &	 3ROPE,1RN,11,"42175,"61000,"10200,0, */
	/* &		"60175,"61000,"10200,0,"54002,"4,"1000, */
	/* &	 3RPIC,1RK,4,"40204,"61007,"20000,"40, */
	/* &	 3RPLU,1RG,3RGLU,1RE,3RPAT,2RCH,4,"70152,"61002,-1,-1, */
	/* &	 3RPOK,1RE,3RBRE,2RAK,3RJAB,0,7,"60212,"21000,0,"200, */
	/* &		"44002,0,"1000, */
	/* &	 3RPOU,1RR,3RSPI,2RLL,11,"42223,"42000,"400,0, */
	/* &		"60223,"42000,"400,0,"60005,-1,-1, */
	/* &		3RPUM,1RP,4,"60232,"60007,-1,-1/ */

	/* 	DATA VVOC6/3RPUT,0,3RINS,3RERT,3RSTU,2RFF,3RPLA,2RCE, */
	/* &		8,"72220,"61005,-1,-1, */
	/* &		"40221,"61006,-1,-1, */
	/* &	 3RRAI,2RSE,3RLIF,1RT,5,"52155,"40155,"61007,-1,-1, */
	/* &	 3RREA,1RD,3RSKI,1RM,11,"42144,"71000,"40000,0, */
	/* &		"60144,"71000,"40000,0,"61002,-1,-1, */
	/* &	 3RSTR,3RIKE,12,"60215,"23000,"40,0, */
	/* &		"44002,0,"1000,"42215,"23000,"40,0,"50173, */
	/* &	 3RSWI,2RNG,3RTHR,3RUST,7,"60214,"44000,0,"1000, */
	/* &		"21003,0,"200, */
	/* &	 3RTAK,1RE,3RGET,0,3RHOL,1RD,3RCAR,2RRY,3RREM,3ROVE, */
	/* &		4,"40204,"61000,"20000,"40, */
	/* &	 3RTEL,1RL,3RCOM,3RMAN,3RREQ,3RUES,4,"40217,"20000,0,"2000, */
	/* &	 3RTHR,2ROW,3RHUR,1RL,3RCHU,2RCK,14,"60224,"44000,-1,-1, */
	/* &		"21003,"40,0,"60224,"44000,-1,-1,"21002,"40,0/ */

	/* 	DATA VVOC7/3RTIE,0,3RFAS,3RTEN,11,"70162,"61004,-1,-1, */
	/* &		"60163,"21000,"40,0,"65002,"4,0, */
	/* &	 3RTUR,1RN,3RSET,0,22,"62164,"61000,"2,0, */
	/* &		"64002,"4,0, */
	/* &		"40173,"75012,"100,0,"40174,"75013,"100,0, */
	/* &		"60237,"61000,"2,0,"20004,-1,-1, */
	/* &	 3RUNL,3ROCK,7,"60135,"21000,-1,-1, */
	/* &		"74002,"4,0, */
	/* &	 3RWAK,1RE,3RSUR,3RPRI,3RALA,2RRM,3RSTA,3RRTL, */
	/* &		8,"42150,"20000,"40,0, */
	/* &		"40150,"20007,"40,0, */
	/* &	 3RWAV,1RE,3RFLA,3RUNT,3RBRA,3RNDI,4,"40154,"40000,-1,-1, */
	/* &	 3RWIN,1RD,5,"50233,"40233,"61007,-1,-1/ */

	public int vvoc[]
//	#ifdef INIT
		= new int[]{ 3929, 8240, 1, 70, 35418, 3819, 1, 71, 31256, 8722, 1, 72, 
		    31201, 40000, 1, 73, 35418, 30775, 1, 74, 31329, 20800, 3260, 
		    13000, 36844, 8000, 1, 75, 11418, 24569, 1, 76, 34105, 31165, 
		    24185, 31165, 1, 77, 37012, 19200, 1, 78, 26321, 40000, 1, 79, 
		    32725, 2381, 1, 80, 32213, 26085, 1, 81, 3681, 31200, 1, 82, 
		    30535, 29000, 1, 83, 27200, 0, 28049, 32000, 1, 84, 13012, 25600, 
		    1, 40, 14966, 24000, 1, 41, 13179, 32618, 34244, 2405, 1, 42, 
		    3243, 17600, 1, 43, 30767, 12800, 21653, 3685, 1, 44, 5135, 21440,
		    19819, 8000, 3258, 9600, 1, 45, 7254, 11415, 1, 46, 10335, 3826, 
		    1, 47, 10215, 0, 3685, 32128, 3258, 0, 1, 48, 29016, 8580, 1, 49, 
		    13421, 29560, 30528, 8181, 1, 50, 37174, 0, 1, 51, 40212, 19200, 
		    30538, 8053, 30735, 34400, 1, 52, 13416, 0, 30849, 25600, 1, 53, 
		    10443, 17600, 30729, 32000, 6453, 22400, 5658, 30600, 1, 54, 
		    42218, 17600, 1, 55, 11921, 22780, 1, 20536, 30462, 8000, 1, 149, 
		    29019, 32618, 1, 150, 32373, 8000, 1, 90, 6761, 11775, 1, 94, 
		    8975, 28929, 1, 105, 14982, 8580, 14400, 0, 1, 133, 36849, 32000, 
		    1, 128, 14963, 2180, 1, 95, 2179, 37018, 1, 96, 1881, 14960, 1, 
		    57, 23015, 3600, 1, 58, 4047, 0, 11929, 25800, 5413, 26081, 1, 59,
		     9801, 32858, 5413, 21014, 31247, 11419, 14565, 1600, 1, 60, 
		    29415, 20800, 1, 65, 24090, 8140, 1, 66, 29361, 21000, 1, 67, 
		    6606, 19260, 1, 20583, 6619, 5529, 37121, 32000, 8961, 21174, 1, 
		    20600, 9972, 19200, 11, 24710, 25088, 128, 0, 25090, 256, 0, 
		    16518, 25088, 128, 0, 9974, 6400, 30605, 17600, 37125, 29000, 
		    30605, 0, 4, 16511, 24576, -1, -1, 10212, 19823, 2, 85, 20565, 
		    17963, 17600, 3580, 8000, 32061, 23200, 1, 20587, 19823, 8720, 1, 
		    20590, 26459, 12800, 26325, 31160, 1, 20592, 29174, 11200, 25801, 
		    19200, 1, 20567, 29642, 0, 4858, 8779, 32621, 5120, 10214, 6885, 
		    1, 20591, 30721, 17800, 1, 20601, 31049, 22400, 1, 20609, 34180, 
		    14600, 10325, 8000, 1, 20593, 36852, 17600, 9, 20622, 16470, 
		    25090, -1, -1, 16470, 25093, -1, -1, 2420, 1731, 9967, 13600, 
		    14970, 34325, 13180, 0, 13658, 32000, 7, 24717, 8704, 0, 128, 
		    18434, 0, 512, 3801, 28960, 4, 16514, 8704, 0, 2, 3941, 30720, 
		    5285, 2160, 5, 21592, 28760, 25090, -1, -1, 4058, 22400, 14694, 
		    15205, 14963, 14965, 7, 24713, 25088, 16, 0, 26626, 8, 0, 5289, 
		    20880, 12, 16541, 8199, 0, 2048, 16542, 8198, 0, 2048, 16540, 
		    8192, 0, 2048, 5295, 30600, 4, 16510, 25088, 4224, 0, 6767, 0, 4, 
		    16473, 18434, 4, 0, 6779, 8522, 4, 16515, 8192, 0, 2, 7129, 22840,
		    14922, 14485, 31321, 19695, 4, 16520, 25088, 256, 0, 7135, 25600,
		    29012, 8059, 11, 17553, 16896, -1, -1, 24721, 16896, -1, -1, 
		    25093, -1, -1, 8060, 0, 5414, 31253, 11802, 3685, 21654, 5120, 
		    32059, 32200, 4, 16519, 31232, 1024, 0, 8980, 14967, 7021, 30600, 
		    4, 16508, 31232, 64, 0, 11582, 8000, 12854, 6400, 7014, 2405, 11, 
		    29842, 8708, 32, 0, 26770, 8704, 32, 0, 25088, -1, -1, 13012, 
		    19800, 13160, 0, 2, 1175, 20631, 3695, 36800, 15, 25702, 25095, 
		    -1, -1, 25090, 4, 0, 16496, 25095, -1, -1, 16501, 25093, -1, -1, 
		    14966, 19260, 4, 28774, 25090, 4, 0, 16853, 25600, 19401, 25600, 
		    5, 91, 16475, 25089, -1, -1, 17972, 19200, 21658, 6618, 30881, 
		    40000, 31201, 3200, 6779, 25660, 7, 24715, 8704, 0, 128, 18434, 0,
		    512, 18175, 5240, 28856, 0, 12, 17526, 25091, -1, -1, 16502, 
		    25098, -1, -1, 16525, 9734, 32, 0, 19567, 13600, 11, 17531, 31232,
		    64, 0, 24713, 25088, 64, 0, 22530, 8, 0, 19803, 17600, 4, 16476, 
		    8192, -1, -1, 19815, 17600, 19200, 0, 31201, 29000, 11266, 8000, 
		    13, 119, 16503, 24579, -1, -1, 16537, 25096, -1, -1, 16536, 24581,
		    -1, -1, 21012, 32000, 19577, 33966, 4, 28773, 25090, 8, 0, 21422,
		    8000, 4, 16506, 8192, -1, -1, 26452, 19200, 32847, 0, 8, 17530, 
		    8704, -1, -1, 16506, 8714, -1, -1, 21654, 11200, 12843, 17600, 
		    10335, 3200, 6453, 1885, 5, 21642, 28810, 18434, -1, -1, 24645, 
		    22400, 11, 17533, 25088, 4224, 0, 24701, 25088, 4224, 0, 22530, 4,
		    512, 25963, 17600, 4, 16516, 25095, 8192, 32, 26101, 11200, 
		    11701, 8000, 25660, 5120, 4, 28778, 25090, -1, -1, 26211, 8000, 
		    3925, 2040, 16042, 0, 7, 24714, 8704, 0, 128, 18434, 0, 512, 
		    26221, 28800, 31049, 19680, 11, 17555, 17408, 256, 0, 24723, 
		    17408, 256, 0, 24581, -1, -1, 26453, 25600, 4, 24730, 24583, -1, 
		    -1, 26460, 0, 14979, 8740, 31221, 9840, 26081, 5000, 8, 29840, 
		    25093, -1, -1, 16529, 25094, -1, -1, 28849, 30600, 19566, 32000, 
		    5, 21613, 16493, 25095, -1, -1, 29001, 6400, 30849, 20800, 11, 
		    17508, 29184, 16384, 0, 24676, 29184, 16384, 0, 25090, -1, -1, 
		    31218, 14845, 12, 24717, 9728, 32, 0, 18434, 0, 512, 17549, 9728, 
		    32, 0, 20603, 31329, 22680, 32338, 34380, 7, 24716, 18432, 0, 512,
		    8707, 0, 128, 32051, 8000, 11420, 0, 13412, 6400, 4858, 29800, 
		    29013, 24885, 4, 16516, 25088, 8192, 32, 32212, 19200, 5413, 
		    20854, 29017, 33819, 4, 16527, 8192, 0, 1024, 32338, 24920, 13658,
		    19200, 5141, 5240, 14, 24724, 18432, -1, -1, 8707, 32, 0, 24724, 
		    18432, -1, -1, 8706, 32, 0, 32365, 0, 9659, 32214, 11, 28786, 
		    25092, -1, -1, 24691, 8704, 32, 0, 27138, 4, 0, 32858, 22400, 
		    30620, 0, 22, 25716, 25088, 2, 0, 26626, 4, 0, 16507, 31242, 64, 
		    0, 16508, 31243, 64, 0, 24735, 25088, 2, 0, 8196, -1, -1, 34172, 
		    24131, 7, 24669, 8704, -1, -1, 30722, 4, 0, 36851, 8000, 31258, 
		    26329, 2081, 29320, 31201, 29612, 8, 17512, 8192, 32, 0, 16488, 
		    8199, 32, 0, 36862, 8000, 10081, 34180, 3921, 22569, 4, 16492, 
		    16384, -1, -1, 37174, 6400, 5, 20635, 16539, 25095, -1, -1, -1 }
//	#endif
		;

	/* OBJECTS--	MAPS OBJECTS TO OBJECT INDICES */

	/* SAME FORMAT AS AVOC. */

	/*   THE FOLLOWING DATA STATEMENT WAS ORIGINALLY: */

	/* 	DATA OVOC1/3RBAG,0,1,25,100,3RSAC,1RK,1,3RGAR,3RLIC,2, */
	/* &	 3RCLO,2RVE,2,3RFOO,1RD,3,3RSAN,3RDWI,3,3RLUN,2RCH,3, */
	/* &	 3RDIN,3RNER,3, */
	/* &	 3RGUN,1RK,4,55,3RPIE,2RCE,4,143,186,3RSLA,1RG,4,3RCOA,1RL,5, */
	/* &	 3RPIL,1RE,5,18,38,78,87,88,122,3RHEA,1RP,5, */
	/* &	 3RFIG,3RURI,6, */
	/* &	 3RMAC,3RHIN,7,3RPDP,2R10,7,3RPDP,2R11,7,3RDRY,2RER,7, */
	/* &	 3RLID,0,7,3RDIA,3RMON,8,3RCAS,1RE,9,123,3RBOT,3RTLE,10,121, */
	/* &	 3RCON,3RTAI,10,3RWAT,2RER,11,209,3RQUA,3RNTI,11,209, */
	/* &	 3RLIQ,3RUID,11,209,3RH2O,0,11,209, */
	/* &	 3RROP,1RE,12,101,3RHEM,1RP,12,3RCOI,1RL,12,110, */
	/* &	 3RKNI,2RFE,13,21,3RBLA,2RDE,13,14,3RSWO,2RRD,14,3RORC,3RHRI,14, */
	/* &	 3RGLA,3RMDR,14,3RLAM,1RP,15,16,22,3RLAN,3RTER,15,16,22, */
	/* &	 3RRUG,0,17,3RCAR,3RPET,17, */
	/* &	 3RLEA,3RVES,18,3RLEA,1RF,18,3RTRO,2RLL,19, */
	/* &	 3RAXE,0,20,3RDIN,3RNER,3/ */

	/* 	DATA OVOC2/3RKEY,1RS,23,3RKEY,0,23, */
	/* &	 3RSET,0,23,3RBON,2RES,24,3RSKE,3RLET,24,3RBOD,1RY,24,73, */
	/* &	 3RCOI,2RNS,25,3RBAR,0,26,165,168, */
	/* &	 3RNEC,3RKLA,27,3RPEA,3RRLS,27,3RMIR,3RROR,28,29,212, */
	/* &	 3RICE,0,30,3RMAS,1RS,30,3RGLA,3RCIE,30,3RRUB,1RY,31, */
	/* &	 3RTRI,3RDEN,32,3RFOR,1RK,32,3RCOF,3RFIN,33,3RCAS,3RKET,33, */
	/* &	 3RTOR,2RCH,34,3RCAG,1RE,35,36,124,125,3RDUM,3RBWA,35,36, */
	/* &	 3RBAS,3RKET,35,36,98,113,3RBRA,3RCEL,37, */
	/* &	 3RJEW,2REL,37,3RTIM,3RBER,38,3RBOX,0,39,53,105,3RSTR,3RADI,40, */
	/* &	 3RVIO,3RLIN,40,3RENG,3RRAV,41,3RINS,3RCRI,41,44,3RGHO,2RST,42, */
	/* &	 3RSPI,3RRIT,42,3RFIE,2RND,42,3RGRA,2RIL,43,3RPRA,3RYER,44,47, */
	/* &	 3RTRU,2RNK,45,3RCHE,2RST,45,3RBEL,1RL,46, */
	/* &	 3RBOO,1RK,47,49,114,115,116,117,3RBIB,2RLE,47/ */

	/* 	DATA OVOC3/3RGOO,3RDBO,47,3RCAN,3RDLE,48,3RPAI,1RR,48, */
	/* &	 3RGUI,3RDEB,49, */
	/* &	 3RGUI,2RDE,49,3RPAP,2RER,50,122,143,186,3RNEW,3RSPA,50, */
	/* &	 3RISS,2RUE,50,3RREP,3RORT,50,3RMAG,3RAZI,50,3RNEW,1RS,50, */
	/* &	 3RMAT,3RCHB,51, */
	/* &	 3RMAT,2RCH,51,3RMAT,3RCHE,51,3RADV,3RERT,52,3RPAM,3RPHL,52, */
	/* &	 3RLEA,3RFLE,52,3RBOO,3RKLE,52,3RMAI,3RLBO,53, */
	/* &	 3RTUB,1RE,54,3RTOO,3RTHP,54,3RPUT,2RTY,55,3RMAT,3RERI,55, */
	/* &	 3RGLU,1RE,55,3RWRE,3RNCH,56,3RSCR,3REWD,57, */
	/* &	 3RCYC,3RLOP,58,3RMON,3RSTE,58,3RCHA,3RLIC,59,3RCUP,0,59, */
	/* &	 3RGOB,3RLET,59,3RPAI,3RNTI,60,149,3RART,0,60,149, */
	/* &	 3RCAN,3RVAS,60,3RPIC,3RTUR,60,3RWOR,1RK,60, */
	/* &	 3RMAS,3RTER,60,215,3RTHI,2REF,61,3RROB,3RBER,61, */
	/* &	 3RCRI,3RMIN,61,3RBAN,3RDIT,61,3RCRO,2ROK,61,3RGEN,1RT,61, */
	/* &	 3RGEN,3RTLE,61,3RMAN,0,61,3RTHU,1RG,61, */
	/* &	 3RBAG,3RMAN,61,3RSTI,3RLLE,62/ */

	/* 	DATA OVOC4/3RWIN,3RDOW,63,3RBOL,1RT,64,3RNUT,0,64, */
	/* &	 3RGRA,2RTE,65,3RGRA,3RTIN,65,3RDOO,1RR,66,67,68,69, */
	/* &	 164,172,173,174,175,189,3RTRA,3RPDO,66, */
	/* &	 3RTRA,3RP$D,66,3RSWI,3RTCH,70,76,79,80,81,82,170, */
	/* &	 3RHEA,1RD,71,120,3RCOR,3RPSE,72,73,3RBOD,3RIES,73, */
	/* &	 3RDAM,0,74,3RGAT,2RES,74,76,3RGAT,1RE,74,76, */
	/* &	 3RFCD,0,74,3RRAI,1RL,75,3RRAI,3RLIN,75, */
	/* &	 3RBUT,3RTON,76,79,80,81,82,127,128,129,170,176, */
	/* &	 3RBUB,3RBLE,77,3RLEA,1RK,78,3RDRI,1RP,78, */
	/* &	 3RHOL,1RE,78,107, */
	/* &	 3RBAT,0,83,3RRAI,3RNBO,84, */
	/* &	 3RPOT,0,85,3RSTA,3RTUE,86,3RSCU,3RLPT,86,3RROC,1RK,86, */
	/* &	 3RBOA,1RT,87,88,90,3RPLA,3RSTI,87,88, */
	/* &	 3RPUM,1RP,89/ */

	/* 	DATA OVOC5/3RAIR,3RPUM,89,3RAIR,3R$PU,89,3RLAB,2REL,91,112, */
	/* &	 3RFIN,3REPR,91,3RSTI,2RCK,92,3RBAR,3RREL,93,3RBUO,1RY,94, */
	/* &	 3REME,3RRAL,95,3RSHO,3RVEL,96,3RGUA,2RNO,97,3RCRA,1RP,97, */
	/* &	 3RSHI,1RT,97,3RHUN,1RK,97,3RBAL,3RLOO,98,113, */
	/* &	 3RREC,3REPT,99,3RWIR,1RE,101,110, */
	/* &	 3RHOO,1RK,102,103,3RZOR,3RKMI,104,148,3RCOI,1RN,104, */
	/* &	 3RSAF,1RE,105,3RCAR,1RD,106,188,3RNOT,1RE,106,186, */
	/* &	 3RSLO,1RT,107,187,3RCRO,2RWN,108,3RBRI,2RCK,109, */
	/* &	 3RFUS,1RE,110,3RGNO,2RME,111,152, */
	/* &	 3RSTA,2RMP,118, */
	/* &	 3RTOM,1RB,119,3RCRY,2RPT,119,3RGRA,2RVE,119,3RHEA,2RDS,120, */
	/* &	 3RPOL,2RES,120,3RIMP,3RLEM,120/ */

	/* 	DATA OVOC6/3RLOS,3RERS,120,3RCOK,2RES,121, */
	/* &	 3RLIS,3RTIN,122,3RSTA,2RCK,122, */
	/* &	 3RPRI,3RNTO,122, */
	/* &	 3RSPH,3RERE,126,3RBAL,1RL,126, */
	/* &	 3RETC,3RHIN,130,131, */
	/* &	 3RWAL,2RLS,130,131,198,205,206,207,208,3RWAL,1RL, */
	/* &	 130,131,159,160,161,162,163,164,198,205,206,207,208, */
	/* &	 3RFLA,2RSK,132,3RPOO,1RL,133,3RSEW,3RAGE,133, */
	/* &	 3RTIN,0,134,3RSAF,3RFRO,134,3RSPI,3RCES,134,3RTAB,2RLE,135, */
	/* &	 3RPOS,1RT,136,166,167,3RPOS,2RTS,136,3RBUC,3RKET,137, */
	/* &	 3RCAK,1RE,138,139,140,141,3RICI,2RNG,139,140,141, */
	/* &	 3RROB,2ROT,142,3RROB,2RBY,142, */
	/* &	 3RC3P,1RO,142,3RR2D,1R2,142/ */

	/* 	DATA OVOC6A/3RPAN,2REL,159,160,161,162,163,164,213, */
	/* &	 3RPOL,1RE,166,167,3RTBA,1RR,168,3RT$B,2RAR,168, */
	/* &	 3RARR,2ROW,169,3RPOI,2RNT,169,3RBEA,1RM,171, */
	/* &	 3RDIA,1RL,177,3RSUN,3RDIA,177,1R1,0,178, */
	/* &	 3RONE,0,178,1R2,0,179,3RTWO,0,179,1R3,0,180, */
	/* &	 3RTHR,2REE,180,1R4,0,181,3RFOU,1RR,181,1R5,0,182, */
	/* &	 3RFIV,1RE,182,1R6,0,183,3RSIX,0,183,1R7,0,184, */
	/* &	 3RSEV,2REN,184,1R8,0,185,3REIG,2RHT,185, */
	/* &	 3RWAR,3RNIN,186,3RSLI,1RT,187, */
	/* &	 2RIT,0,192,3RTHA,1RT,192,3RTHI,1RS,192/ */

	/* 	DATA OVOC7/2RME,0,193,3RMYS,3RELF,193,3RCRE,3RTIN,193, */
	/* &	 3RALL,0,194,3REVE,3RRYT,194, */
	/* &	 3RTRE,3RASU,195,3RVAL,3RUAB,195,3RSAI,3RLOR,196,3RTEE,2RTH,197, */
	/* &	 3RGRU,1RE,199,3RHAN,1RD,200,3RHAN,2RDS,200, */
	/* &	 3RLUN,2RGS,201,3RAIR,0,201,3RAVI,3RATO,202, */
	/* &	 3RFLY,2RER,202,3RTRE,1RE,144,145,204, */
	/* &	 3RCLI,2RFF,146,147,3RLED,2RGE,146,147,3RPOR,3RTRA,149, */
	/* &	 3RSTA,2RCK,148,3RBIL,2RLS,148, */
	/* &	 3RVAU,2RLT,150,3RCUB,1RE,150,3RLET,3RTER,67,150, */
	/* &	 3RCUR,3RTAI,151,3RLIG,2RHT,151,3RNES,1RT,153, */
	/* &	 3REGG,0,154,155,3RBAU,3RBLE,156,3RCAN,3RARY,157,158, */
	/* &	 3RBIR,1RD,203,3RSON,3RGBI,203, */
	/* &	 3RGUA,2RRD,210,3RGUA,3RRDI,210,3RROS,1RE,211, */
	/* &	 3RSTR,3RUCT,212,3RCHA,3RNNE,214, */
	/* &	 3RKEE,3RPER,215,3RLAD,3RDER,216/ */

	public int ovoc[]
//	#ifdef INIT
		= new int[]{ 3247, 0, 1, 25, 100, 30443, 17600, 1, 11258, 19563, 2, 5295,
		    35400, 2, 10215, 6400, 3, 30454, 7329, 3, 20054, 5120, 3, 6774, 
		    22618, 3, 12054, 17600, 4, 55, 25965, 5000, 4, 143, 186, 30881, 
		    11200, 4, 5401, 19200, 5, 25972, 8000, 5, 18, 38, 78, 87, 88, 122,
		    13001, 25600, 5, 9967, 34329, 6, 20843, 13174, 7, 25776, 50800, 
		    7, 25776, 50840, 7, 7145, 8720, 7, 19564, 0, 7, 6761, 21414, 8, 
		    4859, 8000, 9, 123, 3820, 32485, 10, 121, 5414, 32049, 10, 36860, 
		    8720, 11, 209, 28041, 23209, 11, 209, 19577, 33964, 11, 209, 
		    14095, 0, 11, 209, 29416, 8000, 12, 101, 13013, 25600, 12, 5409, 
		    19200, 12, 110, 18169, 9800, 13, 21, 3681, 6600, 13, 14, 31335, 
		    28960, 14, 24723, 13529, 14, 11681, 20978, 14, 19253, 25600, 15, 
		    16, 22, 19254, 32218, 15, 16, 22, 29647, 0, 17, 4858, 25820, 17, 
		    19401, 35419, 18, 19401, 9600, 18, 32735, 19680, 19, 2565, 0, 20, 
		    6774, 22618, 3, 17825, 30400, 23, 17825, 0, 23, 30620, 0, 23, 
		    3814, 8760, 24, 30845, 19420, 24, 3804, 40000, 24, 73, 5409, 
		    23160, 25, 3258, 0, 26, 165, 168, 22603, 18081, 27, 25801, 29299, 
		    27, 21178, 29418, 28, 29, 212, 14525, 0, 30, 20859, 30400, 30, 
		    11681, 5165, 30, 29642, 40000, 31, 32729, 6614, 32, 10218, 17600, 
		    32, 5406, 9974, 33, 4859, 17820, 33, 32618, 5120, 34, 4847, 8000, 
		    35, 36, 124, 125, 7253, 4121, 35, 36, 3259, 17820, 35, 36, 98, 
		    113, 3921, 5012, 37, 16223, 8480, 37, 32373, 3418, 38, 3824, 0, 
		    39, 53, 105, 31218, 1769, 40, 35575, 19574, 40, 8567, 28862, 41, 
		    14979, 5529, 41, 44, 11535, 31200, 42, 31049, 29180, 42, 9965, 
		    22560, 42, 11921, 14880, 43, 26321, 40218, 44, 47, 32741, 22840, 
		    45, 5125, 31200, 45, 3412, 19200, 46, 3815, 17600, 47, 49, 114, 
		    115, 116, 117, 3562, 19400, 47, 11815, 6495, 47, 4854, 6885, 48, 
		    25649, 28800, 48, 12049, 6602, 49, 12049, 6600, 49, 25656, 8720, 
		    50, 122, 143, 186, 22623, 31041, 50, 15179, 33800, 50, 29016, 
		    24740, 50, 20847, 2649, 50, 22623, 30400, 50, 20860, 5122, 51, 
		    20860, 5120, 51, 20860, 5125, 51, 1782, 8740, 52, 25653, 25932, 
		    52, 19401, 10085, 52, 3815, 18085, 52, 20849, 19295, 53, 32842, 
		    8000, 54, 32615, 32336, 54, 26460, 33000, 55, 20860, 8729, 55, 
		    11701, 8000, 55, 37525, 22528, 56, 30538, 8924, 57, 5803, 19816, 
		    58, 21414, 31205, 58, 5121, 19563, 59, 5656, 0, 59, 11802, 19420, 
		    59, 25649, 23209, 60, 149, 2340, 0, 60, 149, 4854, 35259, 60, 
		    25963, 32858, 60, 37418, 17600, 60, 20859, 32218, 60, 215, 32329, 
		    8240, 61, 29402, 3418, 61, 5529, 21175, 61, 3254, 6780, 61, 5535, 
		    24440, 61, 11414, 32000, 61, 11414, 32485, 61, 20854, 0, 61, 
		    32341, 11200, 61, 3247, 20854, 61, 31209, 19685, 62, 37174, 7023, 
		    63, 3812, 32000, 64, 23260, 0, 64, 11921, 32200, 65, 11921, 32374,
		     65, 7015, 28800, 66, 67, 68, 69, 164, 172, 173, 174, 175, 189, 
		    32721, 25775, 66, 32721, 26684, 66, 31329, 32128, 70, 76, 79, 80, 
		    81, 82, 170, 13001, 6400, 71, 120, 5418, 26365, 72, 73, 3804, 
		    14619, 73, 6453, 0, 74, 11260, 8760, 74, 76, 11260, 8000, 74, 76, 
		    9724, 0, 74, 28849, 19200, 75, 28849, 19574, 75, 4060, 32614, 76, 
		    79, 80, 81, 82, 127, 128, 129, 170, 176, 4042, 3685, 77, 19401, 
		    17600, 78, 7129, 25600, 78, 13412, 8000, 78, 107, 3260, 0, 83, 
		    28849, 22495, 84, 26220, 0, 85, 31201, 32845, 86, 30541, 19860, 
		    86, 29403, 17600, 86, 3801, 32000, 87, 88, 90, 26081, 31209, 87, 
		    88, 26453, 25600, 89, 1978, 26453, 89, 1978, 43861, 89, 19242, 
		    8480, 91, 112, 9974, 8658, 91, 31209, 5240, 92, 3258, 29012, 93, 
		    4055, 40000, 94, 8525, 28852, 95, 30735, 35412, 96, 12041, 23000, 
		    97, 5521, 25600, 97, 30729, 32000, 97, 13654, 17600, 97, 3252, 
		    19815, 98, 113, 29003, 8660, 99, 37178, 8000, 101, 110, 13415, 
		    17600, 102, 103, 42218, 18129, 104, 148, 5409, 22400, 104, 30446, 
		    8000, 105, 4858, 6400, 106, 188, 23020, 8000, 106, 186, 30895, 
		    32000, 107, 187, 5535, 37360, 108, 3929, 5240, 109, 10459, 8000, 
		    110, 11775, 21000, 111, 152, 31201, 21440, 118, 32613, 3200, 119, 
		    5545, 26400, 119, 11921, 35400, 119, 13001, 7160, 120, 26212, 
		    8760, 120, 14936, 19413, 120, 19819, 8739, 120, 5411, 8760, 121, 
		    19579, 32374, 122, 31201, 5240, 122, 26329, 23215, 122, 31048, 
		    8725, 126, 3252, 19200, 126, 8803, 13174, 130, 131, 36852, 19960, 
		    130, 131, 198, 205, 206, 207, 208, 36852, 19200, 130, 131, 159, 
		    160, 161, 162, 163, 164, 198, 205, 206, 207, 208, 10081, 30840, 
		    132, 26215, 19200, 133, 30623, 1885, 133, 32374, 0, 134, 30446, 
		    10335, 134, 31049, 5019, 134, 32042, 19400, 135, 26219, 32000, 
		    136, 166, 167, 26219, 32760, 136, 4043, 17820, 137, 4851, 8000, 
		    138, 139, 140, 141, 14529, 22680, 139, 140, 141, 29402, 24800, 
		    142, 29402, 4200, 142, 6136, 24000, 142, 30084, 51200, 142, 25654,
		    8480, 159, 160, 161, 162, 163, 164, 213, 26212, 8000, 166, 167, 
		    32081, 28800, 168, 33082, 2320, 168, 2338, 24920, 169, 26209, 
		    23200, 169, 3401, 20800, 171, 6761, 19200, 177, 31254, 6761, 177, 
		    49600, 0, 178, 24565, 0, 178, 51200, 0, 179, 32935, 0, 179, 52800,
		    0, 180, 32338, 8200, 180, 54400, 0, 181, 10221, 28800, 181, 
		    56000, 0, 182, 9982, 8000, 182, 57600, 0, 183, 30784, 0, 183, 
		    59200, 0, 184, 30622, 8560, 184, 60800, 0, 185, 8367, 13600, 185, 
		    36858, 22774, 186, 30889, 32000, 187, 15200, 0, 192, 32321, 32000,
		    192, 32329, 30400, 192, 21000, 0, 193, 21819, 8486, 193, 5525, 
		    32374, 193, 2092, 0, 194, 8885, 29820, 194, 32725, 2381, 195, 
		    35252, 33642, 195, 30449, 19818, 196, 32205, 32320, 197, 11941, 
		    8000, 199, 12854, 6400, 200, 12854, 7160, 200, 20054, 11960, 201, 
		    1978, 0, 201, 2489, 2415, 202, 10105, 8720, 202, 32725, 8000, 144,
		    145, 204, 5289, 9840, 146, 147, 19404, 11400, 146, 147, 26218, 
		    32721, 149, 31201, 5240, 148, 3572, 19960, 148, 35261, 20000, 150,
		    5642, 8000, 150, 19420, 32218, 67, 150, 5658, 32049, 151, 19567, 
		    13600, 151, 22619, 32000, 153, 8287, 0, 154, 155, 3261, 3685, 156,
		    4854, 2345, 157, 158, 3578, 6400, 203, 31014, 11289, 203, 12041, 
		    28960, 210, 12041, 28969, 210, 29419, 8000, 211, 31218, 33740, 
		    212, 5121, 22965, 214, 17805, 25818, 215, 19244, 6618, 216, -1 }
//	#endif
		;

//	#endif

}