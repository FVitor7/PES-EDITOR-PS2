package editor;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.*;

//import editor.HelpDialog.MyHyperlinkListener;

public class MapaCallname extends JDialog 
{
	private static final long serialVersionUID = 1L;
	

	
	//JScrollPane sp = new JScrollPane(stat);
	
	

	public MapaCallname(Frame owner, MapaCallname mapacall) 
	{
		super(owner, "Mapa de CallNames Pes 2014 PS2", true);
		
		//JLabel lbl = new JLabel("Paste PSD stat here:");
		JPanel pnl = new JPanel();
		
		// Buttons
		JButton btnclose = new JButton("Close");
			
		JTextArea stat = new JTextArea("ALMER		cod.relink:	4279\n" + 
				"DRAGOVIC		cod.relink:	3641\n" + 
				"GARICS		cod.relink:	2902\n" + 
				"FUCHS		cod.relink:	2572\n" + 
				"KAVLAK		cod.relink:	2573\n" + 
				"ALABA		cod.relink:	3750\n" + 
				"HARNIK		cod.relink:	3040\n" + 
				"ARNAUTOVIC		cod.relink:	2443\n" + 
				"JUNUZOVIC		cod.relink:	2574\n" + 
				"JANKO		cod.relink:	2548\n" + 
				"LINDNER		cod.relink:	4280\n" + 
				"ÖZCAN		cod.relink:	2549\n" + 
				"PRÖDL		cod.relink:	3039\n" + 
				"SCHIEMER		cod.relink:	3038\n" + 
				"F. KLEIN		cod.relink:	4018\n" + 
				"BAUMGARTLINGER 	cod.relink:	3640\n" + 
				"JANTSCHER		cod.relink:	3642\n" + 
				"IVANSCHITZ		cod.relink:	618\n" + 
				"A. WEIMANN		cod.relink:	3960\n" + 
				"COURTOIS		cod.relink:	4070\n" + 
				"KOMPANY		cod.relink:	625\n" + 
				"VERMAELEN		cod.relink:	657\n" + 
				"ALDERWEIRELD	cod.relink:	3247\n" + 
				"VERTONGHEN		cod.relink:	2465\n" + 
				"WITSEL		cod.relink:	3046\n" + 
				"DEMBÉLÉ		cod.relink:	2141\n" + 
				"FELLAINI		cod.relink:	3044\n" + 
				"HAZARD		cod.relink:	2859\n" + 
				"DE BRUYNE		cod.relink:	4069\n" + 
				"BENTEKE		cod.relink:	3260\n" + 
				"S. MIGNOLET		cod.relink:	3916\n" + 
				"LOMBAERTS		cod.relink:	3045\n" + 
				"VAN BUYTEN		cod.relink:	310\n" + 
				"POCOGNOLI		cod.relink:	2843\n" + 
				"SIMONS		cod.relink:	326\n" + 
				"DEFOUR		cod.relink:	2584\n" + 
				"GILLET		cod.relink:	2966\n" + 
				"MERTENS		cod.relink:	3504\n" + 
				"N. CHADLI		cod.relink:	3887\n" + 
				"MIRALLAS		cod.relink:	2182\n" + 
				"VOSSEN		cod.relink:	4061\n" + 
				"LUKAKU		cod.relink:	3512\n" + 
				"MIHAYLOV		cod.relink:	2760\n" + 
				"BODUROV		cod.relink:	4013\n" + 
				"IVAN IVANOV		cod.relink:	3447\n" + 
				"MINEV		cod.relink:	3700\n" + 
				"V. MINEV		cod.relink:	3864\n" + 
				"MANOLEV		cod.relink:	3448\n" + 
				"G. MILANOV		cod.relink:	4274\n" + 
				"POPOV		cod.relink:	3048\n" + 
				"V. STOYANOV		cod.relink:	4721\n" + 
				"KOLEV		cod.relink:	515\n" + 
				"R. DIMITROV		cod.relink:	4585\n" + 
				"ZANEV		cod.relink:	3047\n" + 
				"SARMOV		cod.relink:	2761\n" + 
				"BOJINOV		cod.relink:	698\n" + 
				"GARGOROV		cod.relink:	1019\n" + 
				"CARINIKA		cod.relink:	2580\n" + 
				"SHINANOC		cod.relink:	423\n" + 
				"SUIRA		cod.relink:	506\n" + 
				"RASNIC		cod.relink:	2781\n" + 
				"KBOYAOBIR		cod.relink:	703\n" + 
				"OLENBE		cod.relink:	4672\n" + 
				"DA SHUGA		cod.relink:	1994\n" + 
				"CECH		cod.relink:	375\n" + 
				"SIVOK		cod.relink:	498\n" + 
				"KADLEC		cod.relink:	1989\n" + 
				"GEBRE SELASSIE	cod.relink:	3094\n" + 
				"LIMBERSKY		cod.relink:	680\n" + 
				"HÜBSCHMAN		cod.relink:	419\n" + 
				"PLAŠIL		cod.relink:	439\n" + 
				"ROSICKÝ		cod.relink:	83\n" + 
				"LAFATA		cod.relink:	2469\n" + 
				"M. VYDRA		cod.relink:	4618\n" + 
				"LAŠTUVKA		cod.relink:	2026\n" + 
				"SUCHÝ		cod.relink:	2742\n" + 
				"LATKA		cod.relink:	4614\n" + 
				"DOCKAL		cod.relink:	2743\n" + 
				"KOZÁK		cod.relink:	3190\n" + 
				"PEKHART		cod.relink:	2448\n" + 
				"S. ANDERSEN		cod.relink:	931\n" + 
				"KJAER		cod.relink:	3104\n" + 
				"AGGER		cod.relink:	2219\n" + 
				"L. JACOBSEN		cod.relink:	542\n" + 
				"SIMON POULSEN	cod.relink:	2959\n" + 
				"KVIST		cod.relink:	2104\n" + 
				"ZIMLING		cod.relink:	3262\n" + 
				"ROMMEDAHL		cod.relink:	91\n" + 
				"KROHN DEHLI		cod.relink:	866\n" + 
				"ERIKSEN		cod.relink:	3674\n" + 
				"J. HANSEN		cod.relink:	4286\n" + 
				"BJELLAND		cod.relink:	4240\n" + 
				"D. WASS		cod.relink:	3160\n" + 
				"SILBERBAUER		cod.relink:	2076\n" + 
				"LORENTZEN		cod.relink:	3158\n" + 
				"SCHÖNE		cod.relink:	2188\n" + 
				"V. FISCHER		cod.relink:	4333\n" + 
				"T. MIKKELSEN		cod.relink:	3159\n" + 
				"BENDTNER		cod.relink:	2345\n" + 
				"HART		cod.relink:	2447\n" + 
				"SMALLING		cod.relink:	3531\n" + 
				"LESCOTT		cod.relink:	749\n" + 
				"JOHNSON		cod.relink:	533\n" + 
				"ASHLEY COLE		cod.relink:	185\n" + 
				"CARRICK		cod.relink:	191\n" + 
				"GERRARD		cod.relink:	25\n" + 
				"MILNER		cod.relink:	532\n" + 
				"CLEVERLEY		cod.relink:	3208\n" + 
				"ROONEY		cod.relink:	451\n" + 
				"WELBECK		cod.relink:	3164\n" + 
				"FORSTER		cod.relink:	2801\n" + 
				"JAGIELKA		cod.relink:	2429\n" + 
				"P. JONES		cod.relink:	3846\n" + 
				"CAHILL		cod.relink:	2147\n" + 
				"BAINES		cod.relink:	2129\n" + 
				"LAMPARD		cod.relink:	193\n" + 
				"ASHLEY YOUNG	cod.relink:	2428\n" + 
				"OSMAN		cod.relink:	453\n" + 
				"WALCOTT		cod.relink:	2319\n" + 
				"CHAMBERLAIN		cod.relink:	4169\n" + 
				"DEFOE		cod.relink:	392\n" + 
				"STURRIDGE		cod.relink:	2884\n" + 
				"MÄENPÄÄ		cod.relink:	596\n" + 
				"PASANEN		cod.relink:	211\n" + 
				"MOISANDER		cod.relink:	3096\n" + 
				"ARKIVUO		cod.relink:	2222\n" + 
				"TAINIO		cod.relink:	4665\n" + 
				"RING		cod.relink:	3801\n" + 
				"HETEMAJ		cod.relink:	2764\n" + 
				"PUKKI		cod.relink:	3518\n" + 
				"ROMAN EREMENKO	cod.relink:	2353\n" + 
				"HRADECKÝ		cod.relink:	4014\n" + 
				"TOIVIO		cod.relink:	2501\n" + 
				"ARAJUURI		cod.relink:	3682\n" + 
				"HALSTI		cod.relink:	2795\n" + 
				"SPARV		cod.relink:	2019\n" + 
				"KOLEHMAINEN		cod.relink:	4696\n" + 
				"FORSELL		cod.relink:	4586\n" + 
				"FORSSELL		cod.relink:	101\n" + 
				"KUQI		cod.relink:	2009\n" + 
				"LLORIS		cod.relink:	875\n" + 
				"R. VARANE		cod.relink:	3969\n" + 
				"KOSCIELNY		cod.relink:	3549\n" + 
				"JALLET		cod.relink:	2433\n" + 
				"EVRA		cod.relink:	438\n" + 
				"CABAYE		cod.relink:	2028\n" + 
				"MATUIDI		cod.relink:	2126\n" + 
				"VALBUENA		cod.relink:	2441\n" + 
				"RIBÉRY		cod.relink:	945\n" + 
				"BENZEMA		cod.relink:	914\n" + 
				"MANDANDA		cod.relink:	2864\n" + 
				"LANDREAU		cod.relink:	513\n" + 
				"MAMADOU SAKHO	cod.relink:	2862\n" + 
				"YANGA MBIWA		cod.relink:	3318\n" + 
				"DEBUCHY		cod.relink:	820\n" + 
				"CLICHY		cod.relink:	563\n" + 
				"GONALONS		cod.relink:	3625\n" + 
				"CAPOUE		cod.relink:	2946\n" + 
				"M. SISSOKO		cod.relink:	2868\n" + 
				"MENEZ		cod.relink:	955\n" + 
				"GIROUD		cod.relink:	3212\n" + 
				"GOMIS		cod.relink:	890\n" + 
				"NEUER		cod.relink:	2255\n" + 
				"MERTESACKER	cod.relink:	668\n" + 
				"HUMMELS		cod.relink:	2802\n" + 
				"HÖWEDES		cod.relink:	3792\n" + 
				"LAHM		cod.relink:	665\n" + 
				"KHEDIRA		cod.relink:	3553\n" + 
				"SCHWEINSTEIGER	cod.relink:	541\n" + 
				"MÜLLER		cod.relink:	3626\n" + 
				"REUS		cod.relink:	4238\n" + 
				"ÖZIL		cod.relink:	3144\n" + 
				"KLOSE		cod.relink:	327\n" + 
				"ADLER		cod.relink:	608\n" + 
				"BADSTUBER		cod.relink:	3627\n" + 
				"WESTERMANN		cod.relink:	2143\n" + 
				"BOATENG		cod.relink:	3554\n" + 
				"SCHMELZER		cod.relink:	3962\n" + 
				"GÜNDOGAN		cod.relink:	4239\n" + 
				"L. BENDER		cod.relink:	4020\n" + 
				"KROOS		cod.relink:	2803\n" + 
				"GÖTZE		cod.relink:	3963\n" + 
				"SCHÜRRLE		cod.relink:	3965\n" + 
				"PODOLSKI		cod.relink:	675\n" + 
				"KARNEZIS		cod.relink:	2818\n" + 
				"K. PAPADOPOULOS	cod.relink:	2806\n" + 
				"SOKRATIS		cod.relink:	2763\n" + 
				"TOROSIDIS		cod.relink:	2543\n" + 
				"J. CHOLEBAS		cod.relink:	3911\n" + 
				"TZIOLIS		cod.relink:	4613\n" + 
				"KATSOURANIS		cod.relink:	725\n" + 
				"KARAGOUNIS		cod.relink:	117\n" + 
				"SALPINGIDIS		cod.relink:	1004\n" + 
				"SAMARAS		cod.relink:	656\n" + 
				"GEKAS		cod.relink:	1988\n" + 
				"SIFAKIS		cod.relink:	2123\n" + 
				"VYNTRA		cod.relink:	723\n" + 
				"MANIATIS		cod.relink:	4152\n" + 
				"TZAVELAS		cod.relink:	3771\n" + 
				"SPIROPOULOS		cod.relink:	2794\n" + 
				"LAZAROS		cod.relink:	3148\n" + 
				"NINIS		cod.relink:	2749\n" + 
				"TAXTSIDIS		cod.relink:	2968\n" + 
				"KONE		cod.relink:	2762\n" + 
				"MITROGLOU		cod.relink:	2808\n" + 
				"ATHANASIADIS		cod.relink:	3331\n" + 
				"KIRÁLY		cod.relink:	105\n" + 
				"VANCZÁK		cod.relink:	2236\n" + 
				"VARGA		cod.relink:	3701\n" + 
				"PINTÉR		cod.relink:	3938\n" + 
				"KOMAN		cod.relink:	2608\n" + 
				"DZSUDZSÁK		cod.relink:	2952\n" + 
				"HAJNAL		cod.relink:	1018\n" + 
				"SZALAI		cod.relink:	3461\n" + 
				"BOGDAN		cod.relink:	2915\n" + 
				"MEGYERI		cod.relink:	3903\n" + 
				"JUHÁSZ		cod.relink:	1017\n" + 
				"LIPTÁK		cod.relink:	4015\n" + 
				"ELEK		cod.relink:	4016\n" + 
				"GERA		cod.relink:	619\n" + 
				"SZABICS		cod.relink:	620\n" + 
				"ST. LEDGER		cod.relink:	3630\n" + 
				"O'SHEA		cod.relink:	391\n" + 
				"COLEMAN		cod.relink:	3536\n" + 
				"M. WILSON		cod.relink:	3166\n" + 
				"HOOLAHAN		cod.relink:	4087\n" + 
				"WHELAN		cod.relink:	568\n" + 
				"MCGEADY		cod.relink:	861\n" + 
				"J. WALTERS		cod.relink:	3926\n" + 
				"COX		cod.relink:	2426\n" + 
				"ROBBIE KEANE	cod.relink:	7\n" + 
				"WESTWOOD		cod.relink:	3300\n" + 
				"RANDOLPH		cod.relink:	2197\n" + 
				"C. CLARK		cod.relink:	3244\n" + 
				"MCSHANE		cod.relink:	993\n" + 
				"O'DEA		cod.relink:	994\n" + 
				"STEPHEN KELLY	cod.relink:	933\n" + 
				"J. MCCARTHY		cod.relink:	3595\n" + 
				"MCCLEAN		cod.relink:	4168\n" + 
				"LONG		cod.relink:	2425\n" + 
				"AOUATE		cod.relink:	755\n" + 
				"BEN HAIM		cod.relink:	930\n" + 
				"R. GERSHON		cod.relink:	3620\n" + 
				"NATKHO		cod.relink:	3803\n" + 
				"MELIKSON		cod.relink:	2772\n" + 
				"HEMED		cod.relink:	2773\n" + 
				"HARUSH		cod.relink:	4041\n" + 
				"KEINAN		cod.relink:	2770\n" + 
				"B. KAYAL		cod.relink:	2771\n" + 
				"BENAYOUN		cod.relink:	756\n" + 
				"SHECHTER		cod.relink:	3463\n" + 
				"BUFFON		cod.relink:	80\n" + 
				"BARZAGLI		cod.relink:	587\n" + 
				"CHIELLINI		cod.relink:	904\n" + 
				"ABATE		cod.relink:	677\n" + 
				"PIRLO		cod.relink:	218\n" + 
				"DE ROSSI		cod.relink:	401\n" + 
				"MONTOLIVO		cod.relink:	689\n" + 
				"MARCHISIO		cod.relink:	2479\n" + 
				"GIACCHERINI		cod.relink:	3805\n" + 
				"BALOTELLI		cod.relink:	2928\n" + 
				"SIRIGU		cod.relink:	2204\n" + 
				"MARCHETTI		cod.relink:	3105\n" + 
				"ASTORI		cod.relink:	2366\n" + 
				"BONUCCI		cod.relink:	2239\n" + 
				"AQUILANI		cod.relink:	402\n" + 
				"MAGGIO		cod.relink:	907\n" + 
				"CANDREVA		cod.relink:	2933\n" + 
				"GIOVINCO		cod.relink:	2901\n" + 
				"EL SHAARAWY		cod.relink:	3263\n" + 
				"DIAMANTI		cod.relink:	2897\n" + 
				"CERCI		cod.relink:	917\n" + 
				"GILARDINO		cod.relink:	540\n" + 
				"CANAL		cod.relink:	10\n" + 
				"JACK EYDO		cod.relink:	2577\n" + 
				"COCKDEN		cod.relink:	2578\n" + 
				"BRETAIN		cod.relink:	2122\n" + 
				"S. DERICK		cod.relink:	826\n" + 
				"MANIES		cod.relink:	2575\n" + 
				"LYLETY		cod.relink:	2579\n" + 
				"HIYUNI		cod.relink:	504\n" + 
				"JARSTEIN		cod.relink:	2221\n" + 
				"HANGELAND		cod.relink:	512\n" + 
				"HØGLI		cod.relink:	3389\n" + 
				"RIISE		cod.relink:	95\n" + 
				"NORDTVEIT		cod.relink:	3533\n" + 
				"HENRIKSEN		cod.relink:	3725\n" + 
				"R. JENSSEN		cod.relink:	4008\n" + 
				"BRAATEN		cod.relink:	2106\n" + 
				"ELYOUNOUSSI		cod.relink:	3204\n" + 
				"JOSHUA KING		cod.relink:	4719\n" + 
				"A. HANSEN		cod.relink:	4584\n" + 
				"REGINIUSSEN		cod.relink:	3390\n" + 
				"DEMIDOV		cod.relink:	3154\n" + 
				"RUUD		cod.relink:	3637\n" + 
				"GRINDHEIM		cod.relink:	2220\n" + 
				"BERISHA		cod.relink:	4258\n" + 
				"HUSEKLEPP		cod.relink:	3391\n" + 
				"ABDELLAOUE		cod.relink:	3522\n" + 
				"BORUC		cod.relink:	1003\n" + 
				"PISZCZEK		cod.relink:	3384\n" + 
				"WAWRZYNIAK		cod.relink:	3041\n" + 
				"POLANSKI		cod.relink:	2027\n" + 
				"BLASZCZYKOWSKI	cod.relink:	2585\n" + 
				"RYBUS		cod.relink:	3691\n" + 
				"A. MIERZEJEWSKI	cod.relink:	4062\n" + 
				"R. LEWANDOWSKI	cod.relink:	3480\n" + 
				"SZCZESNY		cod.relink:	3692\n" + 
				"TYTON		cod.relink:	2912\n" + 
				"PERQUIS		cod.relink:	2124\n" + 
				"WASILEWSKI		cod.relink:	517\n" + 
				"K. GLIK		cod.relink:	3908\n" + 
				"BOENISCH		cod.relink:	3143\n" + 
				"OBRANIAK		cod.relink:	814\n" + 
				"GROSICKI		cod.relink:	4063\n" + 
				"SOBIECH		cod.relink:	4242\n" + 
				"RUI PATRÍCIO		cod.relink:	2457\n" + 
				"PEPE		cod.relink:	946\n" + 
				"BRUNO ALVES		cod.relink:	934\n" + 
				"JOÃO PEREIRA		cod.relink:	614\n" + 
				"FÁBIO COENTRÃO	cod.relink:	2823\n" + 
				"MIGUEL VELOSO	cod.relink:	2062\n" + 
				"JOÃO MOUTINHO	cod.relink:	947\n" + 
				"R. MEIRELES		cod.relink:	895\n" + 
				"NANI		cod.relink:	2187\n" + 
				"C. RONALDO		cod.relink:	495\n" + 
				"HÉLDER POSTIGA	cod.relink:	494\n" + 
				"EDUARDO		cod.relink:	3301\n" + 
				"BETO		cod.relink:	3562\n" + 
				"SERENO		cod.relink:	3741\n" + 
				"NETO		cod.relink:	4145\n" + 
				"MIGUEL LOPES	cod.relink:	3283\n" + 
				"CUSTÓDIO		cod.relink:	496\n" + 
				"RÚBEN MICAEL	cod.relink:	3709\n" + 
				"DANNY		cod.relink:	867\n" + 
				"CARLOS MARTINS	cod.relink:	615\n" + 
				"VARELA		cod.relink:	2155\n" + 
				"H. ALMEIDA		cod.relink:	617\n" + 
				"PANTILIMON		cod.relink:	3363\n" + 
				"D. GOIAN		cod.relink:	2223\n" + 
				"TAMAS		cod.relink:	612\n" + 
				"RAT		cod.relink:	518\n" + 
				"TORJE		cod.relink:	3338\n" + 
				"TANASE		cod.relink:	3481\n" + 
				"B. STANCU		cod.relink:	3153\n" + 
				"TATARUSANU		cod.relink:	4043\n" + 
				"GARDOS		cod.relink:	4044\n" + 
				"RADU		cod.relink:	2592\n" + 
				"LAZAR		cod.relink:	2224\n" + 
				"POPA		cod.relink:	3995\n" + 
				"MUTU		cod.relink:	113\n" + 
				"MARICA		cod.relink:	709\n" + 
				"AKINFEEV		cod.relink:	627\n" + 
				"BEREZUTSKIY V.	cod.relink:	2227\n" + 
				"IGNASHEVICH		cod.relink:	520\n" + 
				"ANYUKOV		cod.relink:	880\n" + 
				"ZHIRKOV		cod.relink:	1997\n" + 
				"DENISOV		cod.relink:	2226\n" + 
				"SHIROKOV		cod.relink:	3043\n" + 
				"FAYZULIN		cod.relink:	3089\n" + 
				"V. BYSTROV		cod.relink:	1002\n" + 
				"KOKORIN		cod.relink:	3352\n" + 
				"KERZHAKOV		cod.relink:	424\n" + 
				"GABULOV		cod.relink:	2542\n" + 
				"RYZHIKOV		cod.relink:	2769\n" + 
				"BEREZUTSKIY A.	cod.relink:	519\n" + 
				"GRANAT		cod.relink:	3350\n" + 
				"GLUSHAKOV		cod.relink:	3335\n" + 
				"SAMEDOV		cod.relink:	4671\n" + 
				"KOMBAROV D		cod.relink:	3351\n" + 
				"DZAGOEV		cod.relink:	3286\n" + 
				"SMOLOV		cod.relink:	4707\n" + 
				"MCGREGOR		cod.relink:	544\n" + 
				"GARY CALDWELL	cod.relink:	393\n" + 
				"G. HANLEY		cod.relink:	3847\n" + 
				"HUTTON		cod.relink:	545\n" + 
				"WHITTAKER		cod.relink:	2910\n" + 
				"BANNAN		cod.relink:	3243\n" + 
				"J. MCARTHUR		cod.relink:	3917\n" + 
				"SNODGRASS		cod.relink:	4067\n" + 
				"S. NAISMITH		cod.relink:	2967\n" + 
				"MALONEY		cod.relink:	543\n" + 
				"S. FLETCHER		cod.relink:	3088\n" + 
				"MARSHALL		cod.relink:	4681\n" + 
				"GILKS		cod.relink:	3806\n" + 
				"C. BERRA		cod.relink:	3087\n" + 
				"WEBSTER		cod.relink:	4676\n" + 
				"RUSSELL MARTIN	cod.relink:	4089\n" + 
				"MULGREW		cod.relink:	2437\n" + 
				"ADAM		cod.relink:	980\n" + 
				"JAMES MORRISON	cod.relink:	959\n" + 
				"COMMONS		cod.relink:	3303\n" + 
				"BURKE		cod.relink:	4675\n" + 
				"RHODES		cod.relink:	4632\n" + 
				"MILLER		cod.relink:	360\n" + 
				"SKNOMAVIC		cod.relink:	2396\n" + 
				"SRBONIC		cod.relink:	3375\n" + 
				"IKAVIC		cod.relink:	2768\n" + 
				"KORSEVIC		cod.relink:	2798\n" + 
				"BAJNA		cod.relink:	2075\n" + 
				"TOKAJIC		cod.relink:	3052\n" + 
				"BINDEC		cod.relink:	2485\n" + 
				"RUSLANA		cod.relink:	3050\n" + 
				"PERINOVAC		cod.relink:	3758\n" + 
				"STOJRONI		cod.relink:	2504\n" + 
				"KULOCIU		cod.relink:	4694\n" + 
				"SIRIKAEL		cod.relink:	2217\n" + 
				"HUCALON		cod.relink:	3054\n" + 
				"PETRALEK		cod.relink:	3376\n" + 
				"STREMAN		cod.relink:	2744\n" + 
				"SAKET		cod.relink:	4698\n" + 
				"SMALECH		cod.relink:	3240\n" + 
				"HALITAM		cod.relink:	2334\n" + 
				"HOLIKOM		cod.relink:	2218\n" + 
				"PENAROS		cod.relink:	3830\n" + 
				"DORKA		cod.relink:	2215\n" + 
				"SAGHENE		cod.relink:	3705\n" + 
				"MALOV CECF		cod.relink:	979\n" + 
				"KAVAC		cod.relink:	3327\n" + 
				"WELDEN		cod.relink:	3538\n" + 
				"JAGAUQ		cod.relink:	4689\n" + 
				"S. HANDANOVIC	cod.relink:	920\n" + 
				"BRANKO ILIC		cod.relink:	1006\n" + 
				"CESAR		cod.relink:	509\n" + 
				"BRECKO		cod.relink:	898\n" + 
				"JOKIC		cod.relink:	2582\n" + 
				"RADOSAVLJEVIC	cod.relink:	510\n" + 
				"KRHIN		cod.relink:	3309\n" + 
				"J. KURTIC		cod.relink:	3994\n" + 
				"BIRSA		cod.relink:	2464\n" + 
				"KIRM		cod.relink:	3055\n" + 
				"NOVAKOVIC		cod.relink:	2583\n" + 
				"HANDANOVIC		cod.relink:	2581\n" + 
				"OBLAK		cod.relink:	4049\n" + 
				"ŠULER		cod.relink:	3377\n" + 
				"A. BACINOVIC		cod.relink:	3948\n" + 
				"J. ILICIC		cod.relink:	3949\n" + 
				"LJUBIJANKIC		cod.relink:	3056\n" + 
				"DEDIC		cod.relink:	1005\n" + 
				"MATAVŽ		cod.relink:	2956\n" + 
				"CASILLAS		cod.relink:	35\n" + 
				"PIQUÉ		cod.relink:	881\n" + 
				"SERGIO RAMOS	cod.relink:	761\n" + 
				"ARBELOA		cod.relink:	982\n" + 
				"JORDI ALBA		cod.relink:	3566\n" + 
				"SERGIO BUSQUETS	cod.relink:	3202\n" + 
				"XAVI		cod.relink:	42\n" + 
				"A. INIESTA		cod.relink:	447\n" + 
				"PEDRO		cod.relink:	3201\n" + 
				"CESC FABREGAS	cod.relink:	827\n" + 
				"SOLDADO		cod.relink:	2331\n" + 
				"V. VALDÉS		cod.relink:	446\n" + 
				"REINA		cod.relink:	307\n" + 
				"RAÚL ALBIOL		cod.relink:	582\n" + 
				"AZPILICUETA		cod.relink:	2605\n" + 
				"MONREAL		cod.relink:	2516\n" + 
				"MARTÍNEZ		cod.relink:	2514\n" + 
				"JESÚS NAVAS		cod.relink:	760\n" + 
				"S. CAZORLA		cod.relink:	981\n" + 
				"SILVA		cod.relink:	2268\n" + 
				"JUAN MATA		cod.relink:	2800\n" + 
				"VILLA		cod.relink:	776\n" + 
				"TORRES		cod.relink:	457\n" + 
				"ISAKSSON		cod.relink:	418\n" + 
				"GRANQVIST		cod.relink:	2535\n" + 
				"OLSSON		cod.relink:	2163\n" + 
				"LUSTIG		cod.relink:	3234\n" + 
				"SAFARI		cod.relink:	3195\n" + 
				"R. ELM		cod.relink:	3302\n" + 
				"KÄLLSTRÖM		cod.relink:	507\n" + 
				"S. LARSSON		cod.relink:	992\n" + 
				"IBRAHIMOVIC		cod.relink:	320\n" + 
				"ELMANDER		cod.relink:	321\n" + 
				"WILAND		cod.relink:	3267\n" + 
				"P. NILSSON		cod.relink:	4600\n" + 
				"ANTONSSON		cod.relink:	2440\n" + 
				"MARTIN OLSSON	cod.relink:	2387\n" + 
				"A. SVENSSON		cod.relink:	99\n" + 
				"WERNBLOOM		cod.relink:	2555\n" + 
				"S. HOLMÉN		cod.relink:	3157\n" + 
				"TOIVONEN		cod.relink:	3276\n" + 
				"HYSÉN		cod.relink:	2103\n" + 
				"BENAGLIO		cod.relink:	664\n" + 
				"DJOUROU		cod.relink:	1012\n" + 
				"VON BERGEN		cod.relink:	3643\n" + 
				"LICHTSTEINER		cod.relink:	2152\n" + 
				"R. RODRÍGUEZ		cod.relink:	4023\n" + 
				"BEHRAMI		cod.relink:	1995\n" + 
				"INLER		cod.relink:	2569\n" + 
				"SHAQIRI		cod.relink:	3564\n" + 
				"STOCKER		cod.relink:	2814\n" + 
				"EMEGHARA		cod.relink:	4182\n" + 
				"DERDIYOK		cod.relink:	2813\n" + 
				"WÖLFLI		cod.relink:	3399\n" + 
				"SOMMER		cod.relink:	2782\n" + 
				"SENDEROS		cod.relink:	562\n" + 
				"KLOSE		cod.relink:	4248\n" + 
				"RETO ZIEGLER		cod.relink:	973\n" + 
				"DZEMAILI		cod.relink:	2395\n" + 
				"G. FERNANDES	cod.relink:	2885\n" + 
				"BARNETTA		cod.relink:	868\n" + 
				"G. XHAKA		cod.relink:	3865\n" + 
				"MEHMEDI		cod.relink:	3343\n" + 
				"SEFEROVIC		cod.relink:	3732\n" + 
				"GAVRANOVIC		cod.relink:	4724\n" + 
				"VOLKAN DEMIREL	cod.relink:	499\n" + 
				"SEMIH KAYA		cod.relink:	3163\n" + 
				"TOPRAK		cod.relink:	4103\n" + 
				"GÖKHAN GÖNÜL	cod.relink:	2812\n" + 
				"HASAN ALI K.		cod.relink:	4260\n" + 
				"SELÇUK INAN		cod.relink:	3359\n" + 
				"EMRE		cod.relink:	119\n" + 
				"BURAK		cod.relink:	2456\n" + 
				"ARDA TURAN		cod.relink:	972\n" + 
				"NURI SAHIN		cod.relink:	2144\n" + 
				"UMUT BULUT		cod.relink:	3360\n" + 
				"ONUR K.		cod.relink:	3362\n" + 
				"EGEMEN KORKMAZ	cod.relink:	3361\n" + 
				"BEKIR IRTEGÜN	cod.relink:	3509\n" + 
				"CANER ERKIN		cod.relink:	2748\n" + 
				"HAMIT ALTINTOP	cod.relink:	609\n" + 
				"FREI		cod.relink:	4125\n" + 
				"MEHMET EKICI		cod.relink:	3791\n" + 
				"TUNAY TORUN		cod.relink:	4002\n" + 
				"ERDING		cod.relink:	2336\n" + 
				"FIDAKO		cod.relink:	2069\n" + 
				"GLEK		cod.relink:	622\n" + 
				"ROMANIN		cod.relink:	503\n" + 
				"SEKLASOV		cod.relink:	2758\n" + 
				"GARDE		cod.relink:	2922\n" + 
				"SAN RARETTS		cod.relink:	1992\n" + 
				"CRIMS		cod.relink:	2213\n" + 
				"CHANES		cod.relink:	3639\n" + 
				"VORTON		cod.relink:	3313\n" + 
				"ERTOLIN		cod.relink:	2168\n" + 
				"MERAJ		cod.relink:	565\n" + 
				"MOERBOHA		cod.relink:	3816\n" + 
				"GUERMOUDRA		cod.relink:	3748\n" + 
				"LAWGO		cod.relink:	2173\n" + 
				"KAREMOU		cod.relink:	3577\n" + 
				"HERTHE		cod.relink:	3506\n" + 
				"BOUDOURABE		cod.relink:	3132\n" + 
				"DJAMBOU		cod.relink:	3221\n" + 
				"ITANDJE		cod.relink:	470\n" + 
				"KANA-BIYIK		cod.relink:	3142\n" + 
				"N'KOULOU		cod.relink:	3128\n" + 
				"ANGBWA		cod.relink:	911\n" + 
				"ASSOU EKOTTO	cod.relink:	809\n" + 
				"MAKOUN		cod.relink:	801\n" + 
				"MATIP		cod.relink:	3755\n" + 
				"MOUKANDJO		cod.relink:	3544\n" + 
				"ETO'O		cod.relink:	127\n" + 
				"EMANA		cod.relink:	4674\n" + 
				"KWEUKE		cod.relink:	2602\n" + 
				"ASSEMBE		cod.relink:	3136\n" + 
				"KAMENI		cod.relink:	376\n" + 
				"NOUNKEU		cod.relink:	3548\n" + 
				"BEDIMO		cod.relink:	991\n" + 
				"A. SONG		cod.relink:	941\n" + 
				"N'GUEMO		cod.relink:	2134\n" + 
				"MANDJECK		cod.relink:	3756\n" + 
				"M'BIA		cod.relink:	2015\n" + 
				"CHEDJOU		cod.relink:	2858\n" + 
				"F. OLINGA		cod.relink:	4345\n" + 
				"BARRY		cod.relink:	2229\n" + 
				"TOURÉ		cod.relink:	530\n" + 
				"BAMBA		cod.relink:	2013\n" + 
				"EBOUÉ		cod.relink:	2000\n" + 
				"TIÉNÉ		cod.relink:	2078\n" + 
				"TIOTÉ		cod.relink:	2274\n" + 
				"ZOKORA		cod.relink:	887\n" + 
				"TOURÉ YAYA		cod.relink:	2001\n" + 
				"KALOU		cod.relink:	602\n" + 
				"GERVINHO		cod.relink:	2855\n" + 
				"DROGBA		cod.relink:	589\n" + 
				"YEBOAH		cod.relink:	815\n" + 
				"LOLO		cod.relink:	3280\n" + 
				"TRAORÉ		cod.relink:	4300\n" + 
				"BOKA		cod.relink:	876\n" + 
				"SEREY DIE		cod.relink:	4590\n" + 
				"A. RAZAK		cod.relink:	4118\n" + 
				"GRADEL		cod.relink:	4195\n" + 
				"WILFRIED		cod.relink:	3328\n" + 
				"LACINA TRAORÉ	cod.relink:	4705\n" + 
				"A. KONÉ		cod.relink:	644\n" + 
				"A. WAHED		cod.relink:	4679\n" + 
				"NAGIEB		cod.relink:	4722\n" + 
				"GOMAA		cod.relink:	4677\n" + 
				"EL MOHAMADI		cod.relink:	3022\n" + 
				"HOSNI		cod.relink:	1001\n" + 
				"ABOUTRAIKA		cod.relink:	4684\n" + 
				"GEDO		cod.relink:	3751\n" + 
				"EKRAMY		cod.relink:	2136\n" + 
				"FATHALLAH		cod.relink:	3021\n" + 
				"A. FATHY		cod.relink:	3020\n" + 
				"A. EID		cod.relink:	4715\n" + 
				"MEKKY		cod.relink:	4064\n" + 
				"DAUDA		cod.relink:	4612\n" + 
				"BOYE		cod.relink:	3279\n" + 
				"VORSAH		cod.relink:	3629\n" + 
				"PANTSIL		cod.relink:	2231\n" + 
				"M. RABIU		cod.relink:	3348\n" + 
				"BADU		cod.relink:	3753\n" + 
				"K. ASAMOAH		cod.relink:	2979\n" + 
				"GYAN		cod.relink:	921\n" + 
				"D. ADJEI		cod.relink:	3769\n" + 
				"J. MENSAH		cod.relink:	3770\n" + 
				"ANNAN		cod.relink:	2978\n" + 
				"D. BOATENG		cod.relink:	2398\n" + 
				"R. BOATENG		cod.relink:	4620\n" + 
				"E. CLOTTEY		cod.relink:	4619\n" + 
				"Y. BOAKYE		cod.relink:	3975\n" + 
				"EGHITE		cod.relink:	426\n" + 
				"KHUNE		cod.relink:	3026\n" + 
				"KHUMALO		cod.relink:	3432\n" + 
				"SANGWENI		cod.relink:	3819\n" + 
				"GAXA		cod.relink:	2230\n" + 
				"MASILELA		cod.relink:	3025\n" + 
				"FURMAN		cod.relink:	4697\n" + 
				"LETSHOLONYANE	cod.relink:	3662\n" + 
				"B. PARKER		cod.relink:	3271\n" + 
				"ANELE NGCONGCA	cod.relink:	3661\n" + 
				"DIKGACOI		cod.relink:	3027\n" + 
				"TSHABALALA		cod.relink:	2596\n" + 
				"MPHELA		cod.relink:	3028\n" + 
				"MARRENO		cod.relink:	4237\n" + 
				"KERNAGOZ		cod.relink:	3405\n" + 
				"URENAS		cod.relink:	1999\n" + 
				"DEROQUEZ		cod.relink:	3067\n" + 
				"BOGAMOZ		cod.relink:	3403\n" + 
				"BORTEZ		cod.relink:	2165\n" + 
				"BELA LUIGI		cod.relink:	3069\n" + 
				"SAGOIRO		cod.relink:	631\n" + 
				"JONATAN		cod.relink:	3796\n" + 
				"MIRONE		cod.relink:	2228\n" + 
				"BATTENQUAZ		cod.relink:	2598\n" + 
				"BARANOREZ		cod.relink:	364\n" + 
				"BENTARCAZ		cod.relink:	2293\n" + 
				"MAYL FEDELA		cod.relink:	2292\n" + 
				"ELPOZCA		cod.relink:	3827\n" + 
				"OS GAREIA		cod.relink:	2303\n" + 
				"CORTANI		cod.relink:	3073\n" + 
				"ELTOGAL		cod.relink:	2290\n" + 
				"CHULITOZ		cod.relink:	3070\n" + 
				"IZTORE		cod.relink:	3072\n" + 
				"CLOSCO		cod.relink:	4704\n" + 
				"WEL PALIONZ		cod.relink:	2295\n" + 
				"MAVCHEZLO		cod.relink:	4710\n" + 
				"GIL PARTOLEZ		cod.relink:	4695\n" + 
				"CORMA		cod.relink:	548\n" + 
				"TORADA		cod.relink:	4669\n" + 
				"TORNARES		cod.relink:	3829\n" + 
				"PAOLOBANI		cod.relink:	3075\n" + 
				"HALLASO		cod.relink:	526\n" + 
				"BEYAGURRY		cod.relink:	4667\n" + 
				"JOCHIMA		cod.relink:	671\n" + 
				"BLAWNEY		cod.relink:	2344\n" + 
				"DEWLAY		cod.relink:	1998\n" + 
				"AZTORE		cod.relink:	3083\n" + 
				"GURTON		cod.relink:	3077\n" + 
				"GUSTAPHON		cod.relink:	2774\n" + 
				"PALHORSE		cod.relink:	3078\n" + 
				"KUJTOLAN		cod.relink:	3081\n" + 
				"HOLLTON		cod.relink:	2747\n" + 
				"DOTAN		cod.relink:	330\n" + 
				"GODLER		cod.relink:	3826\n" + 
				"ED JAMES		cod.relink:	4683\n" + 
				"S. ROMERO		cod.relink:	2844\n" + 
				"GARAY		cod.relink:	2363\n" + 
				"F. FERNÁNDEZ		cod.relink:	3761\n" + 
				"ZABALETA		cod.relink:	2185\n" + 
				"MARCOS ROJO		cod.relink:	3763\n" + 
				"L. BIGLIA		cod.relink:	2438\n" + 
				"MASCHERANO		cod.relink:	730\n" + 
				"DI MARÍA		cod.relink:	2886\n" + 
				"MONTILLO		cod.relink:	2777\n" + 
				"MESSI		cod.relink:	781\n" + 
				"HIGUAÍN		cod.relink:	2309\n" + 
				"A. ORIÓN		cod.relink:	3766\n" + 
				"ANDUJAR		cod.relink:	2205\n" + 
				"CAMPAGNARO		cod.relink:	2898\n" + 
				"J. M. BASANTA		cod.relink:	3774\n" + 
				"G. PERUZZI		cod.relink:	3957\n" + 
				"C. RODRÍGUEZ		cod.relink:	332\n" + 
				"P. GUIÑAZÚ		cod.relink:	740\n" + 
				"ÉVER BANEGA		cod.relink:	2544\n" + 
				"E. SOSA		cod.relink:	2609\n" + 
				"PALACIO		cod.relink:	1987\n" + 
				"LAVEZZI		cod.relink:	2171\n" + 
				"AGÜERO		cod.relink:	2321\n" + 
				"JÚLIO CÉSAR		cod.relink:	523\n" + 
				"THIAGO SILVA		cod.relink:	3294\n" + 
				"DAVID LUIZ		cod.relink:	2537\n" + 
				"DANIEL ALVES		cod.relink:	759\n" + 
				"MARCELO		cod.relink:	2467\n" + 
				"PAULINHO		cod.relink:	3919\n" + 
				"GUSTAVO		cod.relink:	3985\n" + 
				"ÓSCAR		cod.relink:	3768\n" + 
				"HULK		cod.relink:	1034\n" + 
				"NEYMAR		cod.relink:	3555\n" + 
				"FRED		cod.relink:	948\n" + 
				"JEFFERSON		cod.relink:	4007\n" + 
				"DIEGO CAVALIERI	cod.relink:	3165\n" + 
				"DANTE		cod.relink:	804\n" + 
				"RÉVER		cod.relink:	4251\n" + 
				"FILIPE		cod.relink:	956\n" + 
				"FERNANDO		cod.relink:	4034\n" + 
				"JEAN		cod.relink:	3767\n" + 
				"BERNARD		cod.relink:	4252\n" + 
				"LUCAS MOURA		cod.relink:	3952\n" + 
				"HERNANES		cod.relink:	2593\n" + 
				"JADSON		cod.relink:	2025\n" + 
				"JÔ		cod.relink:	2277\n" + 
				"BRAVO		cod.relink:	1009\n" + 
				"MEDEL		cod.relink:	3364\n" + 
				"MARCOS GONZÁLEZ	cod.relink:	633\n" + 
				"J. M. ROJAS		cod.relink:	2207\n" + 
				"M. DÍAZ		cod.relink:	3780\n" + 
				"VIDAL		cod.relink:	2791\n" + 
				"ISLA		cod.relink:	2934\n" + 
				"E. MENA		cod.relink:	3922\n" + 
				"E. VARGAS		cod.relink:	3779\n" + 
				"A. SANCHEZ		cod.relink:	2792\n" + 
				"E. PAREDES		cod.relink:	3759\n" + 
				"PINTO		cod.relink:	2404\n" + 
				"J. HERRERA		cod.relink:	413\n" + 
				"JARA		cod.relink:	2405\n" + 
				"C. CARMONA		cod.relink:	3167\n" + 
				"DAVID PIZARRO	cod.relink:	483\n" + 
				"F. SILVA		cod.relink:	3784\n" + 
				"C. ARÁNGUIZ		cod.relink:	3782\n" + 
				"M. GONZÁLEZ		cod.relink:	632\n" + 
				"BEAUSÉJOUR		cod.relink:	3365\n" + 
				"MATÍAS F.		cod.relink:	2206\n" + 
				"J. FERNANDES		cod.relink:	4226\n" + 
				"OSPINA		cod.relink:	2789\n" + 
				"CRISTIAN ZAPATA	cod.relink:	2243\n" + 
				"YÉPES		cod.relink:	134\n" + 
				"ZUNIGA		cod.relink:	2790\n" + 
				"ARMERO		cod.relink:	3366\n" + 
				"AGUILAR		cod.relink:	522\n" + 
				"A. RAMÍREZ		cod.relink:	3057\n" + 
				"SÁNCHEZ		cod.relink:	2870\n" + 
				"JACKSON M.		cod.relink:	3645\n" + 
				"JAMES RODRÍGUEZ	cod.relink:	3788\n" + 
				"FALCAO		cod.relink:	2063\n" + 
				"F. MONDRAGON	cod.relink:	4666\n" + 
				"C. VARGAS		cod.relink:	4382\n" + 
				"PEREA		cod.relink:	553\n" + 
				"A. MOSQUERA		cod.relink:	2561\n" + 
				"GUARÍN		cod.relink:	2359\n" + 
				"EDWIN VALENCIA	cod.relink:	4030\n" + 
				"ELKIN SOTO		cod.relink:	2115\n" + 
				"CUADRADO		cod.relink:	3605\n" + 
				"M. TORRES		cod.relink:	2562\n" + 
				"D. QUINTERO		cod.relink:	4708\n" + 
				"L. MURIEL		cod.relink:	4108\n" + 
				"T. GUTIÉRREZ		cod.relink:	3644\n" + 
				"GURAGURA		cod.relink:	361\n" + 
				"WAGNER		cod.relink:	429\n" + 
				"VANDIA		cod.relink:	2081\n" + 
				"CAETANA		cod.relink:	4699\n" + 
				"SAYTALA		cod.relink:	634\n" + 
				"VIREAL		cod.relink:	428\n" + 
				"DA SIUVA		cod.relink:	153\n" + 
				"RIGREJO		cod.relink:	2209\n" + 
				"BEZUROMA		cod.relink:	3367\n" + 
				"OZ CARANHO		cod.relink:	2820\n" + 
				"DALABAZC		cod.relink:	1008\n" + 
				"VILLACARAZ		cod.relink:	3058\n" + 
				"OZWAR		cod.relink:	4233\n" + 
				"SANTICREZ		cod.relink:	152\n" + 
				"R. FERNÁNDEZ	cod.relink:	3368\n" + 
				"ZAMBRANO		cod.relink:	4709\n" + 
				"A. RODRÍGUEZ		cod.relink:	1010\n" + 
				"Y. YOTÚN		cod.relink:	4275\n" + 
				"L. RAMÍREZ		cod.relink:	3407\n" + 
				"FARFÁN		cod.relink:	555\n" + 
				"VARGAS		cod.relink:	1015\n" + 
				"P. GUERRERO		cod.relink:	897\n" + 
				"PIZARRO		cod.relink:	144\n" + 
				"D. PENNY		cod.relink:	2597\n" + 
				"ACASIETE		cod.relink:	909\n" + 
				"C. RAMOS		cod.relink:	3706\n" + 
				"Á. AMPUERO		cod.relink:	4363\n" + 
				"C. LOBATÓN		cod.relink:	4011\n" + 
				"CARRILLO D.		cod.relink:	3812\n" + 
				"C. HURTADO		cod.relink:	3811\n" + 
				"Y. REYNA		cod.relink:	4606\n" + 
				"L. ADVÍNCULA		cod.relink:	4012\n" + 
				"MUSLERA		cod.relink:	2793\n" + 
				"D. LUGANO		cod.relink:	1990\n" + 
				"GODÍN		cod.relink:	2403\n" + 
				"MAXI PEREIRA		cod.relink:	2560\n" + 
				"M. CÁCERES		cod.relink:	2829\n" + 
				"ARÉVALO RÍOS		cod.relink:	2558\n" + 
				"ÁLVARO GONZÁLEZ	cod.relink:	2971\n" + 
				"C. RODRÍGUEZ		cod.relink:	985\n" + 
				"CAVANI		cod.relink:	2565\n" + 
				"FORLÁN		cod.relink:	390\n" + 
				"L. SUÁREZ		cod.relink:	2462\n" + 
				"J. CASTILLO		cod.relink:	2594\n" + 
				"M. SILVA		cod.relink:	3408\n" + 
				"S. COATES		cod.relink:	3760\n" + 
				"A. SCOTTI		cod.relink:	2595\n" + 
				"M. AGUIRREGARAY	cod.relink:	4180\n" + 
				"ALVARO PEREIRA	cod.relink:	3225\n" + 
				"GARGANO		cod.relink:	2559\n" + 
				"S. EGUREN		cod.relink:	557\n" + 
				"DIEGO PÉREZ		cod.relink:	908\n" + 
				"LODEIRO		cod.relink:	3647\n" + 
				"A. HERNÁNDEZ	cod.relink:	3287\n" + 
				"G. RAMÍREZ		cod.relink:	3951\n" + 
				"SCHWARZER		cod.relink:	374\n" + 
				"WILKSHIRE		cod.relink:	2110\n" + 
				"M. MCKAY		cod.relink:	3961\n" + 
				"J. HOLLAND		cod.relink:	4617\n" + 
				"JEDINAK		cod.relink:	3632\n" + 
				"R. KRUSE		cod.relink:	1053\n" + 
				"HOLMAN		cod.relink:	635\n" + 
				"CAHILL		cod.relink:	835\n" + 
				"ALEX BROSQUE	cod.relink:	865\n" + 
				"FEDERICI		cod.relink:	2427\n" + 
				"NEILL		cod.relink:	450\n" + 
				"MILLIGAN		cod.relink:	2388\n" + 
				"R. WILLIAMS		cod.relink:	3210\n" + 
				"M. ZULLO		cod.relink:	3857\n" + 
				"RUKAVYTSYA		cod.relink:	4615\n" + 
				"T. OAR		cod.relink:	3772\n" + 
				"ZEMA QING		cod.relink:	2099\n" + 
				"ZHANG PONG		cod.relink:	1022\n" + 
				"ZHU LAOHAN		cod.relink:	3658\n" + 
				"SOI NAN		cod.relink:	1020\n" + 
				"ZHEN GUI		cod.relink:	527\n" + 
				"ZHANG XIRUI		cod.relink:	715\n" + 
				"YUN HOWE		cod.relink:	2505\n" + 
				"GAM LANG		cod.relink:	2306\n" + 
				"WAW DALON		cod.relink:	2778\n" + 
				"MON JOUXIN		cod.relink:	4686\n" + 
				"HAU JARNAN		cod.relink:	2305\n" + 
				"YUNG HARZHAI	cod.relink:	3410\n" + 
				"LOU JIAN		cod.relink:	4685\n" + 
				"XU DEBAO		cod.relink:	1023\n" + 
				"RIM MI HAN		cod.relink:	3036\n" + 
				"PAK HAN CHON	cod.relink:	3824\n" + 
				"RI KANG CHOL		cod.relink:	2055\n" + 
				"RIM KAN HO		cod.relink:	3414\n" + 
				"RI CHANG MIN		cod.relink:	3825\n" + 
				"AN HAN YOL		cod.relink:	389\n" + 
				"PAK EUN DOK		cod.relink:	2056\n" + 
				"JAN KUN MU		cod.relink:	3413\n" + 
				"KIM MIN GON		cod.relink:	2304\n" + 
				"PAL SOK CHU		cod.relink:	3415\n" + 
				"RIK YOON BO		cod.relink:	1027\n" + 
				"CHONG JUNG WON	cod.relink:	1041\n" + 
				"WAZERNA AN		cod.relink:	2091\n" + 
				"OSLO HAMET		cod.relink:	2599\n" + 
				"AILO MOUTH		cod.relink:	2389\n" + 
				"SOMARI		cod.relink:	714\n" + 
				"AN JILAN		cod.relink:	2072\n" + 
				"AYRAHZI		cod.relink:	2201\n" + 
				"AUSAD AF		cod.relink:	2092\n" + 
				"ADOSHELTAN		cod.relink:	2377\n" + 
				"AGI PAKARANI		cod.relink:	713\n" + 
				"HAGAM		cod.relink:	3419\n" + 
				"C S KINU		cod.relink:	4688\n" + 
				"KHAMRHEH		cod.relink:	4588\n" + 
				"FEYGUAN		cod.relink:	4589\n" + 
				"KHAMLLEH		cod.relink:	3424\n" + 
				"JURAMED		cod.relink:	3422\n" + 
				"WALBUREHE		cod.relink:	3423\n" + 
				"MOULO		cod.relink:	2339\n" + 
				"I. MEITER		cod.relink:	2029\n" + 
				"AHADORAM		cod.relink:	4714\n" + 
				"SPOONLEY		cod.relink:	4723\n" + 
				"SIGMUND		cod.relink:	3650\n" + 
				"SCOTT		cod.relink:	4717\n" + 
				"ROWE		cod.relink:	4605\n" + 
				"KEAT		cod.relink:	4603\n" + 
				"A. CLAPHAM		cod.relink:	3822\n" + 
				"HOGG		cod.relink:	4602\n" + 
				"BARBAROUSES	cod.relink:	4066\n" + 
				"PAYNE		cod.relink:	4604\n" + 
				"PASTON		cod.relink:	3649\n" + 
				"MOSS		cod.relink:	3653\n" + 
				"W. REID		cod.relink:	3821\n" + 
				"T. SMITH		cod.relink:	3823\n" + 
				"VICELICH		cod.relink:	645\n" + 
				"MCGLINCHEY		cod.relink:	2358\n" + 
				"BERTOS		cod.relink:	3651\n" + 
				"ROJAS		cod.relink:	4245\n" + 
				"BROCKIE		cod.relink:	2604\n" + 
				"SMELTZ		cod.relink:	3652\n" + 
				"KILLEN		cod.relink:	2816\n" + 
				"WOOD		cod.relink:	3654\n" + 
				"SIYANEN		cod.relink:	15\n" + 
				"ADION		cod.relink:	22\n" + 
				"CALTEL		cod.relink:	247\n" + 
				"SAINTPEALER		cod.relink:	190\n" + 
				"IMGHE		cod.relink:	250\n" + 
				"STORMS		cod.relink:	20\n" + 
				"BAYTHOM		cod.relink:	19\n" + 
				"GALBONE		cod.relink:	351\n" + 
				"SHIRARE		cod.relink:	195\n" + 
				"SHELEARN		cod.relink:	347\n" + 
				"SUMERSLADE		cod.relink:	16\n" + 
				"KILCAN		cod.relink:	17\n" + 
				"SALTON		cod.relink:	348\n" + 
				"RODEN		cod.relink:	352\n" + 
				"MALMORAN		cod.relink:	26\n" + 
				"HORNER		cod.relink:	350\n" + 
				"CHIRINGBONE		cod.relink:	355\n" + 
				"SHILECON		cod.relink:	183\n" + 
				"WAROL		cod.relink:	349\n" + 
				"IL RANCE		cod.relink:	2077\n" + 
				"LINDEN		cod.relink:	353\n" + 
				"BATHEZ		cod.relink:	48\n" + 
				"DAIRSELL		cod.relink:	49\n" + 
				"BRUIN		cod.relink:	215\n" + 
				"TELIN		cod.relink:	51\n" + 
				"LIRAZAL		cod.relink:	50\n" + 
				"DEROEM		cod.relink:	200\n" + 
				"VIERUE		cod.relink:	53\n" + 
				"WAIYRIN		cod.relink:	59\n" + 
				"ZIROM		cod.relink:	55\n" + 
				"DJIUTALEFF		cod.relink:	54\n" + 
				"DERRAI		cod.relink:	210\n" + 
				"COULE		cod.relink:	371\n" + 
				"SAROMOL		cod.relink:	235\n" + 
				"CALMELA		cod.relink:	57\n" + 
				"KATANYFU		cod.relink:	366\n" + 
				"POOROE		cod.relink:	52\n" + 
				"MAYONELE		cod.relink:	58\n" + 
				"GIGEN		cod.relink:	253\n" + 
				"PROQUINEI		cod.relink:	336\n" + 
				"CALCOMA		cod.relink:	338\n" + 
				"GUYRONTIN		cod.relink:	2415\n" + 
				"PUTAM		cod.relink:	337\n" + 
				"HUBER		cod.relink:	84\n" + 
				"KOLMANN		cod.relink:	232\n" + 
				"MALETZ		cod.relink:	249\n" + 
				"ZONER		cod.relink:	1014\n" + 
				"JERNISCH		cod.relink:	236\n" + 
				"KRUGER		cod.relink:	85\n" + 
				"SLOEGER		cod.relink:	238\n" + 
				"BNARCK		cod.relink:	282\n" + 
				"MEYNO		cod.relink:	487\n" + 
				"CLANTZGAN		cod.relink:	266\n" + 
				"BILKOS		cod.relink:	88\n" + 
				"ITZMOLER		cod.relink:	244\n" + 
				"BURCKLAND		cod.relink:	281\n" + 
				"BEHRENGAUNA	cod.relink:	277\n" + 
				"ZIEDE		cod.relink:	89\n" + 
				"HAURAN		cod.relink:	4912\n" + 
				"REUNSARA		cod.relink:	405\n" + 
				"DARTLEY		cod.relink:	86\n" + 
				"HOEITOR		cod.relink:	851\n" + 
				"REWTELIZE		cod.relink:	278\n" + 
				"LISAGAWSKI		cod.relink:	283\n" + 
				"VAUNER		cod.relink:	284\n" + 
				"MJARNIE		cod.relink:	280\n" + 
				"PERUCCHI		cod.relink:	226\n" + 
				"FLIO CAMARANO	cod.relink:	73\n" + 
				"BAROINI		cod.relink:	344\n" + 
				"PANOKKI		cod.relink:	4914\n" + 
				"MAJUZHENI		cod.relink:	72\n" + 
				"ALMELINI		cod.relink:	74\n" + 
				"DINMO BRATTO	cod.relink:	227\n" + 
				"SORUA		cod.relink:	186\n" + 
				"LON BARRON		cod.relink:	260\n" + 
				"VILENI		cod.relink:	79\n" + 
				"PALUNCA		cod.relink:	243\n" + 
				"CORSACOUPE		cod.relink:	221\n" + 
				"FENORRA		cod.relink:	219\n" + 
				"BENBOLI		cod.relink:	345\n" + 
				"DE LIBRO		cod.relink:	75\n" + 
				"TAUGANI		cod.relink:	341\n" + 
				"BESNOLA		cod.relink:	2417\n" + 
				"MAROGHI		cod.relink:	346\n" + 
				"DORAMORE		cod.relink:	743\n" + 
				"FIL ILSACI		cod.relink:	77\n" + 
				"LOGGU		cod.relink:	343\n" + 
				"VERRONI		cod.relink:	265\n" + 
				"FARZEL HAAR		cod.relink:	61\n" + 
				"TYUTAU		cod.relink:	62\n" + 
				"FIL DA BUUNI		cod.relink:	63\n" + 
				"RAIGINAR		cod.relink:	64\n" + 
				"VAL BROCKOOST	cod.relink:	4910\n" + 
				"HOFU		cod.relink:	65\n" + 
				"RON DA BUUNI		cod.relink:	69\n" + 
				"BEMKAP		cod.relink:	184\n" + 
				"ORHAIMNALZ		cod.relink:	67\n" + 
				"V. MISTELROUM	cod.relink:	214\n" + 
				"VON HEIKEMEN	cod.relink:	267\n" + 
				"ROMAAL KULTAN	cod.relink:	268\n" + 
				"KJUNA		cod.relink:	272\n" + 
				"JALTANG		cod.relink:	368\n" + 
				"ZERGAIV		cod.relink:	4911\n" + 
				"WELTAR		cod.relink:	68\n" + 
				"RAUKOORES		cod.relink:	269\n" + 
				"GULAAS		cod.relink:	271\n" + 
				"CWARIM		cod.relink:	274\n" + 
				"VON BOLSEN		cod.relink:	270\n" + 
				"VAN OOIDORK		cod.relink:	312\n" + 
				"CREIBAAD		cod.relink:	66\n" + 
				"PULZATO		cod.relink:	294\n" + 
				"AMONI		cod.relink:	157\n" + 
				"SEMINI		cod.relink:	158\n" + 
				"CHIERO		cod.relink:	223\n" + 
				"SOIM		cod.relink:	163\n" + 
				"SILJOME		cod.relink:	159\n" + 
				"ROGUEIRO		cod.relink:	224\n" + 
				"OJQUERA		cod.relink:	4774\n" + 
				"MALGANI		cod.relink:	298\n" + 
				"QUERANT		cod.relink:	303\n" + 
				"BAQUISTATA		cod.relink:	161\n" + 
				"FEREM		cod.relink:	304\n" + 
				"PALTEZA		cod.relink:	300\n" + 
				"RUNZAL		cod.relink:	295\n" + 
				"CURALLE		cod.relink:	296\n" + 
				"BARENQUA		cod.relink:	297\n" + 
				"ALANENDO		cod.relink:	164\n" + 
				"ANLLEROZ		cod.relink:	301\n" + 
				"CAMIRRA		cod.relink:	359\n" + 
				"COUL LOMER		cod.relink:	4775\n" + 
				"BAZQUENI		cod.relink:	299\n" + 
				"DIORAZ		cod.relink:	302\n" + 
				"BOLIBO		cod.relink:	230\n" + 
				"TARALM		cod.relink:	245\n" + 
				"ALDAHILLA		cod.relink:	141\n" + 
				"RICALRO		cod.relink:	3186\n" + 
				"CASHOO		cod.relink:	137\n" + 
				"RODRICO CATIS	cod.relink:	136\n" + 
				"MALO SILA		cod.relink:	202\n" + 
				"DORTE		cod.relink:	252\n" + 
				"RASAN		cod.relink:	257\n" + 
				"LEYMAURO		cod.relink:	222\n" + 
				"ROMEYDA		cod.relink:	217\n" + 
				"ROZERIO		cod.relink:	140\n" + 
				"LEMON		cod.relink:	285\n" + 
				"ZALBO		cod.relink:	135\n" + 
				"JIRJONHO		cod.relink:	1028\n" + 
				"SALMAIO		cod.relink:	142\n" + 
				"TOR SERINA		cod.relink:	286\n" + 
				"FUHREN		cod.relink:	287\n" + 
				"SOLQUERAS		cod.relink:	288\n" + 
				"ZILRE		cod.relink:	289\n" + 
				"BENAR		cod.relink:	383\n" + 
				"PALM		cod.relink:	292\n" + 
				"DELIUTON		cod.relink:	4776\n" + 
				"CAMRE		cod.relink:	291\n" + 
				"SAGNA		cod.relink:	799\n" + 
				"KIERAN GIBBS		cod.relink:	3112\n" + 
				"WILSHERE		cod.relink:	3209\n" + 
				"RAMSEY		cod.relink:	3113\n" + 
				"FABIANSKI		cod.relink:	2397\n" + 
				"FRIMPONG		cod.relink:	3532\n" + 
				"DIABY		cod.relink:	988\n" + 
				"ARTETA		cod.relink:	311\n" + 
				"PARK CHU YOUNG	cod.relink:	1030\n" + 
				"Y. SANOGO		cod.relink:	3892\n" + 
				"R. MIYAICHI		cod.relink:	3978\n" + 
				"GUZAN		cod.relink:	3076\n" + 
				"VLAAR		cod.relink:	2090\n" + 
				"BAKER		cod.relink:	3245\n" + 
				"LUNA		cod.relink:	3890\n" + 
				"WESTWOOD		cod.relink:	4352\n" + 
				"EL AHMADI		cod.relink:	951\n" + 
				"DELPH		cod.relink:	3591\n" + 
				"AGBONLAHOR		cod.relink:	2355\n" + 
				"STEER		cod.relink:	4090\n" + 
				"J. BENNETT		cod.relink:	3246\n" + 
				"HERD		cod.relink:	3242\n" + 
				"GARDNER		cod.relink:	4126\n" + 
				"ALBRIGHTON		cod.relink:	3535\n" + 
				"L. BACUNA		cod.relink:	3678\n" + 
				"GIVEN		cod.relink:	194\n" + 
				"N'ZOGBIA		cod.relink:	2023\n" + 
				"IRELAND		cod.relink:	2170\n" + 
				"TURNER		cod.relink:	4651\n" + 
				"CAULKER		cod.relink:	4115\n" + 
				"M. CONNOLLY		cod.relink:	2347\n" + 
				"BELLAMY		cod.relink:	14\n" + 
				"KIM BO KYUNG		cod.relink:	1051\n" + 
				"CAMPBELL		cod.relink:	2335\n" + 
				"LEWIS		cod.relink:	4800\n" + 
				"HUDSON		cod.relink:	455\n" + 
				"ANDREW TAYLOR	cod.relink:	960\n" + 
				"COWIE		cod.relink:	4235\n" + 
				"MUTCH		cod.relink:	4827\n" + 
				"T. SMITH		cod.relink:	2528\n" + 
				"MAYNARD		cod.relink:	4268\n" + 
				"S. MOORE		cod.relink:	4755\n" + 
				"KISS		cod.relink:	4653\n" + 
				"MATHURIN-HARRIS	cod.relink:	4654\n" + 
				"LAPPIN		cod.relink:	4088\n" + 
				"MASON		cod.relink:	4652\n" + 
				"TERRY		cod.relink:	317\n" + 
				"IVANOVIC		cod.relink:	2767\n" + 
				"RAMIRES		cod.relink:	3505\n" + 
				"BERTRAND		cod.relink:	4170\n" + 
				"M. VAN GINKEL		cod.relink:	3859\n" + 
				"ESSIEN		cod.relink:	594\n" + 
				"MIKEL		cod.relink:	2135\n" + 
				"MOSES		cod.relink:	3304\n" + 
				"DEMBA BA		cod.relink:	3285\n" + 
				"HILARIO		cod.relink:	490\n" + 
				"BLACKMAN		cod.relink:	4922\n" + 
				"SPERONI		cod.relink:	903\n" + 
				"GABBIDON		cod.relink:	4778\n" + 
				"DAMIEN DELANEY	cod.relink:	4831\n" + 
				"J. WARD		cod.relink:	3623\n" + 
				"DOBBIE		cod.relink:	4098\n" + 
				"WILBRAHAM		cod.relink:	4881\n" + 
				"GAYLE		cod.relink:	4659\n" + 
				"NEIL ALEXANDER	cod.relink:	546\n" + 
				"MARANGE		cod.relink:	2111\n" + 
				"J. CAMAPAÑA		cod.relink:	4175\n" + 
				"J. THOMAS		cod.relink:	829\n" + 
				"GRANDIN		cod.relink:	2875\n" + 
				"MURRAY		cod.relink:	4655\n" + 
				"CHAMAKH		cod.relink:	630\n" + 
				"PHILLIPS		cod.relink:	28\n" + 
				"PRICE		cod.relink:	2210\n" + 
				"MCCARTHY		cod.relink:	4779\n" + 
				"BOATENG		cod.relink:	4660\n" + 
				"APPIAH		cod.relink:	4656\n" + 
				"HOWARD		cod.relink:	525\n" + 
				"DISTIN		cod.relink:	209\n" + 
				"BARKLEY		cod.relink:	4117\n" + 
				"PIENAAR		cod.relink:	397\n" + 
				"JELAVIC		cod.relink:	3633\n" + 
				"JOEL		cod.relink:	3874\n" + 
				"ALCARAZ		cod.relink:	2836\n" + 
				"HEITINGA		cod.relink:	396\n" + 
				"HIBBERT		cod.relink:	452\n" + 
				"OVIEDO		cod.relink:	3746\n" + 
				"GIBSON		cod.relink:	2322\n" + 
				"M. GUEYE		cod.relink:	3915\n" + 
				"ANICHEBE		cod.relink:	2356\n" + 
				"DUFFY		cod.relink:	3621\n" + 
				"KENNEDY		cod.relink:	4353\n" + 
				"HOPE		cod.relink:	4753\n" + 
				"C. LONG		cod.relink:	4754\n" + 
				"STEKELENBURG	cod.relink:	381\n" + 
				"A. HUGHES		cod.relink:	11\n" + 
				"RIETHER		cod.relink:	673\n" + 
				"RICHARDSON		cod.relink:	560\n" + 
				"SIDWELL		cod.relink:	2422\n" + 
				"KASAMI		cod.relink:	3862\n" + 
				"DUFF		cod.relink:	8\n" + 
				"TAARABT		cod.relink:	2534\n" + 
				"BERBATOV		cod.relink:	116\n" + 
				"DAVID STOCKDALE	cod.relink:	3111\n" + 
				"AMOREBIETA		cod.relink:	2267\n" + 
				"BRIGGS		cod.relink:	2881\n" + 
				"PARKER		cod.relink:	501\n" + 
				"DEJAGAH		cod.relink:	901\n" + 
				"BRYAN RUIZ		cod.relink:	3068\n" + 
				"RODALLEGA		cod.relink:	2208\n" + 
				"D. BENT		cod.relink:	2101\n" + 
				"ETHERIDGE		cod.relink:	3530\n" + 
				"TROTTA		cod.relink:	4314\n" + 
				"CURTIS DAVIES	cod.relink:	2272\n" + 
				"CHESTER		cod.relink:	4845\n" + 
				"MAYNOR FIGUEROA	cod.relink:	2291\n" + 
				"D. MEYLER		cod.relink:	3199\n" + 
				"ALUKO		cod.relink:	2271\n" + 
				"GRAHAM		cod.relink:	997\n" + 
				"SAGBO		cod.relink:	3129\n" + 
				"HARPER		cod.relink:	196\n" + 
				"BRUCE		cod.relink:	4808\n" + 
				"ROSENIOR		cod.relink:	4805\n" + 
				"DIAGNE FAYE		cod.relink:	468\n" + 
				"J. LIVERMORE		cod.relink:	3871\n" + 
				"HUDDLESTONE	cod.relink:	2150\n" + 
				"STEPHEN QUINN	cod.relink:	2430\n" + 
				"ENRIQUE		cod.relink:	2166\n" + 
				"LUCAS LEIVA		cod.relink:	2607\n" + 
				"J. HENDERSON	cod.relink:	3540\n" + 
				"P. COUTINHO		cod.relink:	3907\n" + 
				"I. ASPAS		cod.relink:	4288\n" + 
				"JONES		cod.relink:	746\n" + 
				"ŠKRTEL		cod.relink:	2216\n" + 
				"WISDOM		cod.relink:	4188\n" + 
				"KELLY		cod.relink:	2882\n" + 
				"A. CISSOKHO		cod.relink:	3257\n" + 
				"ALLEN		cod.relink:	4096\n" + 
				"STERLING		cod.relink:	4187\n" + 
				"L. ALBERTO		cod.relink:	4882\n" + 
				"ASSAIDI		cod.relink:	3192\n" + 
				"BORINI		cod.relink:	3719\n" + 
				"WARD		cod.relink:	4211\n" + 
				"FLANAGAN		cod.relink:	4121\n" + 
				"D. PACHECO		cod.relink:	4859\n" + 
				"J. SINCLAIR		cod.relink:	4364\n" + 
				"MORGAN		cod.relink:	4909\n" + 
				"FERNANDINHO	cod.relink:	2066\n" + 
				"DŽEKO		cod.relink:	2993\n" + 
				"NASTASIC		cod.relink:	4131\n" + 
				"MICAH RICHARDS	cod.relink:	2149\n" + 
				"KOLAROV		cod.relink:	2797\n" + 
				"JAVI GARCIA		cod.relink:	983\n" + 
				"BARRY		cod.relink:	18\n" + 
				"RODWELL		cod.relink:	2919\n" + 
				"NASRI		cod.relink:	915\n" + 
				"JOVETIC		cod.relink:	3102\n" + 
				"NEGREDO		cod.relink:	2372\n" + 
				"WRIGHT		cod.relink:	314\n" + 
				"J. GUIDETTI		cod.relink:	3974\n" + 
				"DE GEA		cod.relink:	3596\n" + 
				"VIDIC		cod.relink:	550\n" + 
				"FERDINAND		cod.relink:	23\n" + 
				"VALENCIA		cod.relink:	2080\n" + 
				"GIGGS		cod.relink:	13\n" + 
				"VAN PERSIE		cod.relink:	398\n" + 
				"A. LINDEGAARD	cod.relink:	3987\n" + 
				"JONNY EVANS		cod.relink:	2576\n" + 
				"RAFAEL		cod.relink:	3207\n" + 
				"FLETCHER		cod.relink:	561\n" + 
				"KAGAWA		cod.relink:	1042\n" + 
				"ANDERSON		cod.relink:	2157\n" + 
				"J. HERNÁNDEZ		cod.relink:	2776\n" + 
				"AMOS		cod.relink:	3282\n" + 
				"G. VARELA		cod.relink:	4379\n" + 
				"BÜTTNER		cod.relink:	2963\n" + 
				"FÁBIO		cod.relink:	3206\n" + 
				"POWELL		cod.relink:	4310\n" + 
				"A. HENRÍQUEZ		cod.relink:	4225\n" + 
				"MACHEDA		cod.relink:	3305\n" + 
				"BÉBÉ		cod.relink:	3927\n" + 
				"KRUL		cod.relink:	2169\n" + 
				"TAYLOR		cod.relink:	957\n" + 
				"COLOCCINI		cod.relink:	456\n" + 
				"BEN ARFA		cod.relink:	913\n" + 
				"JONÁS GUTIÉRREZ	cod.relink:	2195\n" + 
				"GOUFFRAN		cod.relink:	886\n" + 
				"P. CISSE		cod.relink:	2788\n" + 
				"R. ELLIOT		cod.relink:	2196\n" + 
				"WILLIAMSON		cod.relink:	3622\n" + 
				"SANTON		cod.relink:	3222\n" + 
				"RYAN TAYLOR		cod.relink:	2154\n" + 
				"ANITA		cod.relink:	2367\n" + 
				"GOSLING		cod.relink:	2918\n" + 
				"OBERTAN		cod.relink:	2486\n" + 
				"MARVEAUX		cod.relink:	2453\n" + 
				"SAMMY AMEOBI		cod.relink:	4172\n" + 
				"H. VUCKIC		cod.relink:	3912\n" + 
				"AMALFITANO		cod.relink:	4264\n" + 
				"REMY		cod.relink:	2493\n" + 
				"RUDDY		cod.relink:	2148\n" + 
				"TURNER		cod.relink:	831\n" + 
				"J. GARRIDO		cod.relink:	862\n" + 
				"HOWSON		cod.relink:	4208\n" + 
				"B. JOHNSON		cod.relink:	4116\n" + 
				"E. BENNETT		cod.relink:	3541\n" + 
				"VAN WOLFSWINKEL	cod.relink:	3174\n" + 
				"BUNN		cod.relink:	3241\n" + 
				"BASSONG		cod.relink:	2181\n" + 
				"R. BENNETT		cod.relink:	4316\n" + 
				"AYALA		cod.relink:	4857\n" + 
				"TETTEY		cod.relink:	2105\n" + 
				"FER		cod.relink:	2953\n" + 
				"FOX		cod.relink:	2008\n" + 
				"PILKINGTON		cod.relink:	4124\n" + 
				"G. HOOPER		cod.relink:	3891\n" + 
				"L. BECCHIO		cod.relink:	4371\n" + 
				"NASH		cod.relink:	449\n" + 
				"J. BUTTERFIELD	cod.relink:	4317\n" + 
				"LOVREN		cod.relink:	3162\n" + 
				"SHAW		cod.relink:	4324\n" + 
				"SCHNEIDERLIN	cod.relink:	2877\n" + 
				"WARD-PROWSE	cod.relink:	4271\n" + 
				"LALLANA		cod.relink:	4269\n" + 
				"J. RODRIGUEZ		cod.relink:	3314\n" + 
				"LAMBERT		cod.relink:	4270\n" + 
				"KELVIN DAVIS		cod.relink:	2117\n" + 
				"YOSHIDA		cod.relink:	1044\n" + 
				"HOOIVELD		cod.relink:	655\n" + 
				"CLYNE		cod.relink:	4336\n" + 
				"D. FOX		cod.relink:	3590\n" + 
				"CORK		cod.relink:	3747\n" + 
				"STEVEN DAVIS		cod.relink:	825\n" + 
				"OSVALDO		cod.relink:	2332\n" + 
				"BEGOVIC		cod.relink:	2920\n" + 
				"SHAWCROSS		cod.relink:	2880\n" + 
				"HUTH		cod.relink:	531\n" + 
				"G. CAMERON		cod.relink:	4276\n" + 
				"PIETERS		cod.relink:	2506\n" + 
				"N'ZONZI		cod.relink:	3534\n" + 
				"ETHERINGTON		cod.relink:	2133\n" + 
				"CROUCH		cod.relink:	437\n" + 
				"SØRENSEN		cod.relink:	92\n" + 
				"BUTLAND		cod.relink:	4278\n" + 
				"MUNIESA		cod.relink:	3940\n" + 
				"SHOTTON		cod.relink:	3119\n" + 
				"WILKINSON		cod.relink:	3118\n" + 
				"WILSON PALACIOS	cod.relink:	2294\n" + 
				"KIGHTLY		cod.relink:	3310\n" + 
				"PENNANT		cod.relink:	529\n" + 
				"JEROME		cod.relink:	2832\n" + 
				"KENWYNE JONES	cod.relink:	932\n" + 
				"M. EDU		cod.relink:	3079\n" + 
				"NESS		cod.relink:	3255\n" + 
				"ROBERGE		cod.relink:	3355\n" + 
				"CELUSTKA		cod.relink:	3511\n" + 
				"COLBACK		cod.relink:	3539\n" + 
				"CABRAL		cod.relink:	2815\n" + 
				"ADAM JOHNSON	cod.relink:	2198\n" + 
				"SESSEGNON		cod.relink:	2449\n" + 
				"ALTIDORE		cod.relink:	3082\n" + 
				"MANNONE		cod.relink:	2348\n" + 
				"W. BROWN		cod.relink:	182\n" + 
				"DIAKITÉ		cod.relink:	2475\n" + 
				"CUÉLLAR		cod.relink:	768\n" + 
				"EL-HADJI BA		cod.relink:	4657\n" + 
				"CATERMOLE		cod.relink:	2357\n" + 
				"DAVID VAUGHAN	cod.relink:	2211\n" + 
				"CRAIG GARDNER	cod.relink:	2354\n" + 
				"JI DONG WON		cod.relink:	3967\n" + 
				"WICKHAM		cod.relink:	4112\n" + 
				"MAVRIAS		cod.relink:	3902\n" + 
				"VORM		cod.relink:	937\n" + 
				"A. WILLIAMS		cod.relink:	3392\n" + 
				"CHICO		cod.relink:	3189\n" + 
				"ÀNGEL RANGEL	cod.relink:	4095\n" + 
				"BEN DAVIES		cod.relink:	4171\n" + 
				"BRITTON		cod.relink:	4093\n" + 
				"J. CAÑAS		cod.relink:	3278\n" + 
				"DYER		cod.relink:	4097\n" + 
				"ROUTLEDGE		cod.relink:	893\n" + 
				"J. SHELVEY		cod.relink:	3913\n" + 
				"MICHU		cod.relink:	4150\n" + 
				"TREMMEL		cod.relink:	667\n" + 
				"AMAT		cod.relink:	3739\n" + 
				"MONK		cod.relink:	4094\n" + 
				"TAYLOR		cod.relink:	4100\n" + 
				"KI SUNG YUENG	cod.relink:	3297\n" + 
				"RICHARDS		cod.relink:	4099\n" + 
				"PABLO		cod.relink:	2827\n" + 
				"LAMAH		cod.relink:	995\n" + 
				"A. POZUELO		cod.relink:	4200\n" + 
				"MOORE		cod.relink:	571\n" + 
				"SITU BUYENTE		cod.relink:	3316\n" + 
				"OBENG		cod.relink:	4212\n" + 
				"LUCAS		cod.relink:	4101\n" + 
				"DONNELLY		cod.relink:	4209\n" + 
				"LITA		cod.relink:	2424\n" + 
				"DAWSON		cod.relink:	2020\n" + 
				"K. WALKER		cod.relink:	3749\n" + 
				"D. ROSE		cod.relink:	2908\n" + 
				"G. SIGURÐSSON	cod.relink:	4017\n" + 
				"LENNON		cod.relink:	567\n" + 
				"FRIEDEL		cod.relink:	329\n" + 
				"KABOUL		cod.relink:	989\n" + 
				"NAUGHTON		cod.relink:	3592\n" + 
				"SANDRO		cod.relink:	3277\n" + 
				"CARROLL		cod.relink:	4343\n" + 
				"BALE		cod.relink:	2570\n" + 
				"HOLTBY		cod.relink:	3964\n" + 
				"ADEBAYOR		cod.relink:	808\n" + 
				"GOMES		cod.relink:	733\n" + 
				"FOSTER		cod.relink:	2162\n" + 
				"MCAULEY		cod.relink:	3090\n" + 
				"JONES		cod.relink:	4113\n" + 
				"RIDGEWELL		cod.relink:	570\n" + 
				"MULUMBU		cod.relink:	2496\n" + 
				"DORRANS		cod.relink:	3116\n" + 
				"ANELKA		cod.relink:	56\n" + 
				"BOAZ MYHILL		cod.relink:	3117\n" + 
				"CRAIG DAWSON	cod.relink:	4189\n" + 
				"REID		cod.relink:	414\n" + 
				"POPOV		cod.relink:	726\n" + 
				"THORNE		cod.relink:	4119\n" + 
				"BRUNT		cod.relink:	2121\n" + 
				"ROSENBERG		cod.relink:	2073\n" + 
				"ODEMWINGIE		cod.relink:	712\n" + 
				"DANIELS		cod.relink:	3115\n" + 
				"DANIELS		cod.relink:	4658\n" + 
				"O'NEILL		cod.relink:	4213\n" + 
				"ROOFE		cod.relink:	4214\n" + 
				"SINCLAIR		cod.relink:	2374\n" + 
				"NABI		cod.relink:	4210\n" + 
				"JÄÄSKELÄINEN		cod.relink:	102\n" + 
				"J. COLLINS		cod.relink:	1007\n" + 
				"DEMEL		cod.relink:	323\n" + 
				"JOEY O'BRIEN		cod.relink:	996\n" + 
				"DIAMÉ		cod.relink:	2257\n" + 
				"MARK NOBLE		cod.relink:	2130\n" + 
				"JOE COLE		cod.relink:	27\n" + 
				"JARVIS		cod.relink:	3311\n" + 
				"NOLAN		cod.relink:	824\n" + 
				"MAIGA		cod.relink:	2853\n" + 
				"ADRIÁN		cod.relink:	4339\n" + 
				"S. HENDERSON	cod.relink:	4318\n" + 
				"TOMKINS		cod.relink:	2923\n" + 
				"MCCARTNEY		cod.relink:	324\n" + 
				"ALOU DIARRA		cod.relink:	406\n" + 
				"COLLISON		cod.relink:	2924\n" + 
				"DOWNING		cod.relink:	747\n" + 
				"M. TAYLOR		cod.relink:	748\n" + 
				"ANDY CARROLL	cod.relink:	2530\n" + 
				"OCHOA		cod.relink:	2382\n" + 
				"ZUBAR		cod.relink:	885\n" + 
				"ANDRÉ		cod.relink:	4092\n" + 
				"BONNART		cod.relink:	790\n" + 
				"PIERAZZI		cod.relink:	4091\n" + 
				"PEDRETTI		cod.relink:	514\n" + 
				"CAVALLI		cod.relink:	2536\n" + 
				"O. SISSOKO		cod.relink:	2872\n" + 
				"HENGBART		cod.relink:	884\n" + 
				"BEGEORGI		cod.relink:	2310\n" + 
				"RICARDO FATY		cod.relink:	2176\n" + 
				"BELGHAZOUANI	cod.relink:	3086\n" + 
				"S. DIARRA		cod.relink:	806\n" + 
				"EDUARDO		cod.relink:	3551\n" + 
				"OLIECH		cod.relink:	2325\n" + 
				"SCRIBE		cod.relink:	4854\n" + 
				"POPESCU		cod.relink:	4132\n" + 
				"ARRACHE		cod.relink:	4918\n" + 
				"SQUILLACI		cod.relink:	395\n" + 
				"DRISSA DIAKITÉ	cod.relink:	2361\n" + 
				"PALMIERI		cod.relink:	4301\n" + 
				"YATABARÉ		cod.relink:	3308\n" + 
				"ILAN		cod.relink:	949\n" + 
				"T. MAOULIDA		cod.relink:	787\n" + 
				"LECA		cod.relink:	943\n" + 
				"SANS		cod.relink:	3808\n" + 
				"MODESTO		cod.relink:	872\n" + 
				"SABLÉ		cod.relink:	889\n" + 
				"ROMARIC		cod.relink:	2158\n" + 
				"ANDRÉ		cod.relink:	4887\n" + 
				"KESERU		cod.relink:	821\n" + 
				"BRUNO		cod.relink:	4158\n" + 
				"CARRASSO		cod.relink:	440\n" + 
				"SANÉ		cod.relink:	3545\n" + 
				"PLANUS		cod.relink:	535\n" + 
				"MARIANO		cod.relink:	4031\n" + 
				"MAURICE BELAY	cod.relink:	818\n" + 
				"OLIMPA		cod.relink:	2494\n" + 
				"V. SAVIC		cod.relink:	4850\n" + 
				"HENRIQUE		cod.relink:	2273\n" + 
				"FAUBERT		cod.relink:	940\n" + 
				"BRÉCHET		cod.relink:	463\n" + 
				"D. ROLÁN		cod.relink:	4230\n" + 
				"BEN KHALFALLAH	cod.relink:	3211\n" + 
				"SERTIC		cod.relink:	3256\n" + 
				"JUSSIE		cod.relink:	736\n" + 
				"BELLION		cod.relink:	559\n" + 
				"C. DIABATÉ		cod.relink:	3430\n" + 
				"L. ORBÁN		cod.relink:	3306\n" + 
				"CHALMÉ		cod.relink:	793\n" + 
				"A. TRAORÉ		cod.relink:	2943\n" + 
				"CASTRO		cod.relink:	4735\n" + 
				"LAQUAIT		cod.relink:	2518\n" + 
				"MONGONGU		cod.relink:	2495\n" + 
				"SORLIN		cod.relink:	786\n" + 
				"EHRET		cod.relink:	789\n" + 
				"BARBOSA		cod.relink:	783\n" + 
				"FOFANA		cod.relink:	4734\n" + 
				"B. DJA DJÉDJÉ		cod.relink:	4082\n" + 
				"D. KONE		cod.relink:	3575\n" + 
				"BLANC		cod.relink:	4733\n" + 
				"F. BERTOGLIO		cod.relink:	3786\n" + 
				"ESCOBAR		cod.relink:	4896\n" + 
				"SOUGOU		cod.relink:	3024\n" + 
				"DURAND		cod.relink:	4081\n" + 
				"THOMASSON		cod.relink:	4320\n" + 
				"SAMASSA		cod.relink:	4591\n" + 
				"SORBON		cod.relink:	2024\n" + 
				"PEREIRA		cod.relink:	4810\n" + 
				"LEMAÎTRE		cod.relink:	4798\n" + 
				"MATHIS		cod.relink:	4777\n" + 
				"GIRESSE		cod.relink:	4801\n" + 
				"LANGIL		cod.relink:	4822\n" + 
				"YATABARÉ		cod.relink:	3429\n" + 
				"CERDAN		cod.relink:	2119\n" + 
				"SANKOH		cod.relink:	4597\n" + 
				"ATIK		cod.relink:	4792\n" + 
				"MANDANNE		cod.relink:	4083\n" + 
				"FAURÉ		cod.relink:	4790\n" + 
				"ALIOUI		cod.relink:	4598\n" + 
				"DOS SANTOS		cod.relink:	4599\n" + 
				"KEITA		cod.relink:	4761\n" + 
				"ELANA		cod.relink:	883\n" + 
				"BAŠA		cod.relink:	2159\n" + 
				"BÉRIA		cod.relink:	800\n" + 
				"SOUARÉ		cod.relink:	3728\n" + 
				"MAVUBA		cod.relink:	822\n" + 
				"BALMONT		cod.relink:	464\n" + 
				"I. GUÈYE		cod.relink:	3893\n" + 
				"MARTIN		cod.relink:	3130\n" + 
				"MOUKO		cod.relink:	3578\n" + 
				"ROZEHNAL		cod.relink:	717\n" + 
				"SIDIBÉ		cod.relink:	4267\n" + 
				"MEITÉ		cod.relink:	4176\n" + 
				"ROUX		cod.relink:	3315\n" + 
				"DE MELO		cod.relink:	2161\n" + 
				"ENYEAMA		cod.relink:	427\n" + 
				"RUÍZ		cod.relink:	4196\n" + 
				"AUDARD		cod.relink:	873\n" + 
				"B. ECUELE MANGA	cod.relink:	3894\n" + 
				"L. KONÉ		cod.relink:	3895\n" + 
				"GASSAMA		cod.relink:	3229\n" + 
				"MONNET-PAQUET	cod.relink:	2482\n" + 
				"BARTHELME		cod.relink:	3550\n" + 
				"JOUFFRÉ		cod.relink:	812\n" + 
				"V. ABOUBAKAR		cod.relink:	3820\n" + 
				"BOURILLON		cod.relink:	811\n" + 
				"PEDRINHO		cod.relink:	4045\n" + 
				"BACA		cod.relink:	3140\n" + 
				"COUTADEUR		cod.relink:	2450\n" + 
				"R. MULUMBA		cod.relink:	3930\n" + 
				"ALAIN TRAORÉ		cod.relink:	2419\n" + 
				"RÉALE		cod.relink:	4161\n" + 
				"F. ROBERT		cod.relink:	2871\n" + 
				"QUERCIA		cod.relink:	2337\n" + 
				"G. SUNU		cod.relink:	3973\n" + 
				"ALIADIERE		cod.relink:	436\n" + 
				"B. LECOMTE		cod.relink:	3929\n" + 
				"C. DOUKOURÉ		cod.relink:	4870\n" + 
				"VERCOUTRE		cod.relink:	465\n" + 
				"BIŠEVAC		cod.relink:	2484\n" + 
				"FOFANA		cod.relink:	3284\n" + 
				"MVUEMBA		cod.relink:	816\n" + 
				"FERRI		cod.relink:	4202\n" + 
				"GOURCUFF		cod.relink:	990\n" + 
				"GRENIER		cod.relink:	3230\n" + 
				"LACAZETTE		cod.relink:	3579\n" + 
				"A. LOPES		cod.relink:	3715\n" + 
				"KONÉ		cod.relink:	4177\n" + 
				"MOUHAMADOU DABO	cod.relink:	2178\n" + 
				"GHEZZAL		cod.relink:	4321\n" + 
				"DANIC		cod.relink:	2125\n" + 
				"MALBRANQUE		cod.relink:	454\n" + 
				"BRIAND		cod.relink:	819\n" + 
				"FRICK		cod.relink:	4203\n" + 
				"SARR		cod.relink:	4662\n" + 
				"S. KONÉ		cod.relink:	4162\n" + 
				"BAHLOULI		cod.relink:	4762\n" + 
				"LUCAS MENDES	cod.relink:	4261\n" + 
				"FANNI		cod.relink:	469\n" + 
				"MOREL		cod.relink:	2413\n" + 
				"ROMAO		cod.relink:	2232\n" + 
				"PAYET		cod.relink:	2421\n" + 
				"ANDRE AYEW		cod.relink:	2865\n" + 
				"GIGNAC		cod.relink:	2492\n" + 
				"BRACIGLIANO		cod.relink:	2107\n" + 
				"DIAWARA		cod.relink:	528\n" + 
				"MENDY		cod.relink:	4736\n" + 
				"B. CHEYROU		cod.relink:	795\n" + 
				"K. OSEI		cod.relink:	3600\n" + 
				"KADIR		cod.relink:	3576\n" + 
				"JORDAN AYEW		cod.relink:	3896\n" + 
				"KHELIFA		cod.relink:	4111\n" + 
				"SAMBA		cod.relink:	4358\n" + 
				"SUBAŠIC		cod.relink:	3299\n" + 
				"R. CARVALHO		cod.relink:	491\n" + 
				"ABIDAL		cod.relink:	380\n" + 
				"RAGGI		cod.relink:	2109\n" + 
				"OBBADI		cod.relink:	2439\n" + 
				"TOULALAN		cod.relink:	803\n" + 
				"WOLF		cod.relink:	870\n" + 
				"NDINGA		cod.relink:	3127\n" + 
				"G. COULIBALY		cod.relink:	4794\n" + 
				"DIRAR		cod.relink:	4833\n" + 
				"L. OCAMPOS		cod.relink:	4183\n" + 
				"RIVIÈRE		cod.relink:	3180\n" + 
				"FABINHO		cod.relink:	4908\n" + 
				"MALONGA		cod.relink:	2852\n" + 
				"BARAZITE		cod.relink:	4920\n" + 
				"MARTIAL		cod.relink:	4376\n" + 
				"JOURDREN		cod.relink:	3317\n" + 
				"HILTON		cod.relink:	784\n" + 
				"EL KAOUTARI		cod.relink:	3319\n" + 
				"CONGRE		cod.relink:	2017\n" + 
				"B. STAMBOULI		cod.relink:	3898\n" + 
				"MARVEAUX		cod.relink:	2412\n" + 
				"CABELLA		cod.relink:	3718\n" + 
				"S. CAMARA		cod.relink:	363\n" + 
				"MOUNIER		cod.relink:	2316\n" + 
				"E. HERRERA		cod.relink:	4223\n" + 
				"PIONNIER		cod.relink:	797\n" + 
				"BOCALY		cod.relink:	2442\n" + 
				"MEZAGUE		cod.relink:	4159\n" + 
				"DABO		cod.relink:	4332\n" + 
				"SAÏHI		cod.relink:	3320\n" + 
				"MARTIN		cod.relink:	4160\n" + 
				"AÏT FANA		cod.relink:	3321\n" + 
				"BAKAR		cod.relink:	2861\n" + 
				"VÍCTOR MONTAÑO	cod.relink:	905\n" + 
				"TINHAN		cod.relink:	3599\n" + 
				"KOITA		cod.relink:	3322\n" + 
				"VIZCARRONDO		cod.relink:	2401\n" + 
				"ISSA CISSOKHO	cod.relink:	4793\n" + 
				"VEIGNEAU		cod.relink:	4806\n" + 
				"EUDELINE		cod.relink:	4799\n" + 
				"BESSAT		cod.relink:	2874\n" + 
				"GAKPE		cod.relink:	2275\n" + 
				"F. DJORDJEVIC	cod.relink:	2909\n" + 
				"DJIDJI		cod.relink:	4596\n" + 
				"GABRIEL CICHERO	cod.relink:	2296\n" + 
				"PANCRATE		cod.relink:	4791\n" + 
				"BANGOURA		cod.relink:	2120\n" + 
				"F. ARISTEGUIETA	cod.relink:	3810\n" + 
				"PEJCINOVIC		cod.relink:	3270\n" + 
				"N. MENDY		cod.relink:	3924\n" + 
				"DIGARD		cod.relink:	2863\n" + 
				"PIED		cod.relink:	3231\n" + 
				"BAUTHÉAC		cod.relink:	4084\n" + 
				"CVITANICH		cod.relink:	3095\n" + 
				"KOLODZIEJCZAK	cod.relink:	3226\n" + 
				"ANIN		cod.relink:	3141\n" + 
				"ABRIEL		cod.relink:	2432\n" + 
				"MAHAMANE TRAORE	cod.relink:	2498\n" + 
				"BRÜLS		cod.relink:	4895\n" + 
				"BRUINS		cod.relink:	2408\n" + 
				"PENTECÔTE		cod.relink:	2114\n" + 
				"HASSEN		cod.relink:	4348\n" + 
				"FOFANA		cod.relink:	4359\n" + 
				"ALEX		cod.relink:	738\n" + 
				"MAXWELL		cod.relink:	319\n" + 
				"THIAGO MOTTA		cod.relink:	445\n" + 
				"PASTORE		cod.relink:	3523\n" + 
				"DOUCHEZ		cod.relink:	944\n" + 
				"CAMARA		cod.relink:	207\n" + 
				"MARQUINHOS		cod.relink:	4247\n" + 
				"VAN DER WIEL		cod.relink:	2754\n" + 
				"BODMER		cod.relink:	798\n" + 
				"SISSOKO		cod.relink:	583\n" + 
				"CHANTÔME		cod.relink:	2497\n" + 
				"MAURICE		cod.relink:	3546\n" + 
				"COMAN		cod.relink:	4737\n" + 
				"AGASSA		cod.relink:	785\n" + 
				"WEBER		cod.relink:	2879\n" + 
				"SIGNORINO		cod.relink:	796\n" + 
				"M. ALBÆK		cod.relink:	4876\n" + 
				"ONIANGUE		cod.relink:	4835\n" + 
				"PLACIDE		cod.relink:	3138\n" + 
				"FOFANA		cod.relink:	2113\n" + 
				"GLOMBARD		cod.relink:	4110\n" + 
				"PEUGET		cod.relink:	4265\n" + 
				"CA		cod.relink:	2011\n" + 
				"GHISOLFI		cod.relink:	817\n" + 
				"DEVAUX		cod.relink:	3323\n" + 
				"DIEGO		cod.relink:	4349\n" + 
				"F. AYITÉ		cod.relink:	3433\n" + 
				"K. GHILAS		cod.relink:	3593\n" + 
				"PEREIRA		cod.relink:	4277\n" + 
				"COSTIL		cod.relink:	882\n" + 
				"CATHERINE		cod.relink:	3581\n" + 
				"DANZÉ		cod.relink:	2454\n" + 
				"JEBBOUR		cod.relink:	4163\n" + 
				"PITROIPA		cod.relink:	899\n" + 
				"A. DIALLO		cod.relink:	3716\n" + 
				"APAM		cod.relink:	2488\n" + 
				"ARMAND		cod.relink:	792\n" + 
				"FÉRET		cod.relink:	3126\n" + 
				"CHEICK DIARRA	cod.relink:	4178\n" + 
				"SAÏD		cod.relink:	4740\n" + 
				"SANÉ		cod.relink:	4322\n" + 
				"C. NDIAYE		cod.relink:	2258\n" + 
				"MOREIRA		cod.relink:	4741\n" + 
				"DOUCOURÉ		cod.relink:	4360\n" + 
				"ALLÉE		cod.relink:	4763\n" + 
				"RUFFIER		cod.relink:	2487\n" + 
				"M. B. SALL		cod.relink:	2489\n" + 
				"PERRIN		cod.relink:	888\n" + 
				"CLERC		cod.relink:	595\n" + 
				"BRISON		cod.relink:	2108\n" + 
				"J. GUILAVOGUI		cod.relink:	3923\n" + 
				"LEMOINE		cod.relink:	2857\n" + 
				"COHADE		cod.relink:	939\n" + 
				"R. HAMOUMA		cod.relink:	3842\n" + 
				"TABANOU		cod.relink:	3134\n" + 
				"BRANDÃO		cod.relink:	2018\n" + 
				"MOULIN		cod.relink:	2177\n" + 
				"ZOUMA		cod.relink:	4157\n" + 
				"MIGNOT		cod.relink:	462\n" + 
				"BAYSSE		cod.relink:	2420\n" + 
				"F. GHOULAM		cod.relink:	3971\n" + 
				"CLEMENT		cod.relink:	813\n" + 
				"CORGNET		cod.relink:	4085\n" + 
				"NICOLITA		cod.relink:	2225\n" + 
				"RAVET		cod.relink:	3213\n" + 
				"I. SAADI		cod.relink:	3972\n" + 
				"ALEKSIC		cod.relink:	3720\n" + 
				"POUPLIN		cod.relink:	2014\n" + 
				"PEYBERNES		cod.relink:	3712\n" + 
				"KANTÉ		cod.relink:	788\n" + 
				"CORCHIA		cod.relink:	3307\n" + 
				"CARLÃO		cod.relink:	3179\n" + 
				"BOUDEBOUZ		cod.relink:	3131\n" + 
				"CONTOUT		cod.relink:	2010\n" + 
				"C. BAKAMBU		cod.relink:	3925\n" + 
				"PRIVAT		cod.relink:	2945\n" + 
				"P. CAMARA		cod.relink:	4165\n" + 
				"ZOUMA		cod.relink:	4883\n" + 
				"SAUGET		cod.relink:	942\n" + 
				"L. POUJOL		cod.relink:	3547\n" + 
				"NOGUEIRA		cod.relink:	2866\n" + 
				"RAFAËL DIAS		cod.relink:	3897\n" + 
				"ROUDET		cod.relink:	874\n" + 
				"A. CAMARA		cod.relink:	3580\n" + 
				"BUTIN		cod.relink:	3133\n" + 
				"CROS		cod.relink:	3711\n" + 
				"TRAORE		cod.relink:	4024\n" + 
				"AHAMADA		cod.relink:	4166\n" + 
				"AURIER		cod.relink:	3714\n" + 
				"SPAJIC		cod.relink:	4663\n" + 
				"ABDENNOUR		cod.relink:	3793\n" + 
				"AKPA-AKPRO		cod.relink:	4179\n" + 
				"SYLLA		cod.relink:	4664\n" + 
				"DIDOT		cod.relink:	802\n" + 
				"SIRIEIX		cod.relink:	461\n" + 
				"A. REGATTIN		cod.relink:	3931\n" + 
				"W. BEN YEDDER	cod.relink:	3833\n" + 
				"VIDAL		cod.relink:	3713\n" + 
				"BLONDEL		cod.relink:	3139\n" + 
				"ZÉBINA		cod.relink:	229\n" + 
				"NINKOV		cod.relink:	2975\n" + 
				"M'BENGUE		cod.relink:	2869\n" + 
				"ROMAN		cod.relink:	4894\n" + 
				"TREJO		cod.relink:	2523\n" + 
				"SOUKOUNA		cod.relink:	4841\n" + 
				"PENNETEAU		cod.relink:	794\n" + 
				"ANGOUA		cod.relink:	3729\n" + 
				"BONG		cod.relink:	2338\n" + 
				"MATER		cod.relink:	2410\n" + 
				"SAEZ		cod.relink:	954\n" + 
				"DUCOURTIOUX	cod.relink:	2409\n" + 
				"ENZA YAMISSI		cod.relink:	2167\n" + 
				"DOSSEVI		cod.relink:	3178\n" + 
				"G. PUJOL		cod.relink:	791\n" + 
				"NOVAES		cod.relink:	4266\n" + 
				"ROSE		cod.relink:	4361\n" + 
				"L. NÉRY		cod.relink:	3970\n" + 
				"MODY TRAORÉ		cod.relink:	2411\n" + 
				"P. CAMARA		cod.relink:	4071\n" + 
				"T. DOUMBIA		cod.relink:	4902\n" + 
				"LE TALLEC		cod.relink:	564\n" + 
				"LALA		cod.relink:	4167\n" + 
				"ÐURIC		cod.relink:	3341\n" + 
				"CONSIGLI		cod.relink:	965\n" + 
				"STENDARDO		cod.relink:	2237\n" + 
				"CANINI		cod.relink:	687\n" + 
				"SCALONI		cod.relink:	205\n" + 
				"DEL GROSSO		cod.relink:	2189\n" + 
				"CIGARINI		cod.relink:	2241\n" + 
				"BRIENZA		cod.relink:	695\n" + 
				"BONAVENTURA	cod.relink:	3168\n" + 
				"G. DENIS		cod.relink:	2977\n" + 
				"POLITO		cod.relink:	2434\n" + 
				"LUCCHINI		cod.relink:	691\n" + 
				"CONTINI		cod.relink:	974\n" + 
				"BELLINI		cod.relink:	686\n" + 
				"BRIVIO		cod.relink:	2351\n" + 
				"MIGLIACCIO		cod.relink:	1973\n" + 
				"RAIMONDI		cod.relink:	958\n" + 
				"GIORGI		cod.relink:	2246\n" + 
				"M. MORALEZ		cod.relink:	2610\n" + 
				"MARILUNGO		cod.relink:	3197\n" + 
				"FREZZOLINI		cod.relink:	586\n" + 
				"CAPELLI		cod.relink:	1974\n" + 
				"MOUSSA KONÉ		cod.relink:	4234\n" + 
				"TROISI		cod.relink:	2531\n" + 
				"PETTINARI		cod.relink:	2892\n" + 
				"ARDEMAGNI		cod.relink:	4899\n" + 
				"CURCI		cod.relink:	919\n" + 
				"CHERUBIN		cod.relink:	2891\n" + 
				"A. MORLEO		cod.relink:	3904\n" + 
				"F. DELLA ROCCA	cod.relink:	2315\n" + 
				"ROLANDO BIANCHI	cod.relink:	892\n" + 
				"AGLIARDI		cod.relink:	578\n" + 
				"NATALI		cod.relink:	575\n" + 
				"F. SØRENSEN		cod.relink:	3993\n" + 
				"ANGEL		cod.relink:	4812\n" + 
				"M. ABERO		cod.relink:	3798\n" + 
				"PAZIENZA		cod.relink:	597\n" + 
				"CASARINI		cod.relink:	3205\n" + 
				"ALIBEC		cod.relink:	4864\n" + 
				"D. MOSCARDELLI	cod.relink:	3934\n" + 
				"ACQUAFRESCA	cod.relink:	2245\n" + 
				"MAINI		cod.relink:	4742\n" + 
				"A. FERRARI		cod.relink:	4743\n" + 
				"M. CECH		cod.relink:	978\n" + 
				"MARTÍ RIVEROLA	cod.relink:	3979\n" + 
				"H. GIMÉNEZ		cod.relink:	3612\n" + 
				"AGAZZI		cod.relink:	3726\n" + 
				"ROSSETTINI		cod.relink:	2932\n" + 
				"PISANO		cod.relink:	976\n" + 
				"CONTI		cod.relink:	891\n" + 
				"DESSENA		cod.relink:	2065\n" + 
				"NAINGGOLAN		cod.relink:	3727\n" + 
				"COSSU		cod.relink:	2142\n" + 
				"SAU		cod.relink:	2895\n" + 
				"S. IBARBO		cod.relink:	3275\n" + 
				"AVRAMOV		cod.relink:	2431\n" + 
				"ARIAUDO		cod.relink:	3264\n" + 
				"G. PERICO		cod.relink:	3933\n" + 
				"EKDAL		cod.relink:	3106\n" + 
				"M. CABRERA		cod.relink:	3797\n" + 
				"RUI SAMPAIO		cod.relink:	4056\n" + 
				"S. ERIKSSON		cod.relink:	3156\n" + 
				"NENÊ		cod.relink:	3526\n" + 
				"PINILLA		cod.relink:	554\n" + 
				"LEGROTTAGLIE	cod.relink:	476\n" + 
				"SPOLLI		cod.relink:	3604\n" + 
				"P. ÁLVAREZ		cod.relink:	729\n" + 
				"FABIÁN MONZÓN	cod.relink:	2972\n" + 
				"IZCO		cod.relink:	2471\n" + 
				"ALMIRON		cod.relink:	485\n" + 
				"BARRIENTOS		cod.relink:	2006\n" + 
				"L. CASTRO		cod.relink:	4329\n" + 
				"BERGESSIO		cod.relink:	2822\n" + 
				"FRISON		cod.relink:	3733\n" + 
				"A. ROLÍN		cod.relink:	3958\n" + 
				"BELLUSCI		cod.relink:	3556\n" + 
				"CAPUANO		cod.relink:	924\n" + 
				"BIAGIANTI		cod.relink:	2472\n" + 
				"LETO		cod.relink:	2916\n" + 
				"F. FREIRE		cod.relink:	4378\n" + 
				"CATELLANI		cod.relink:	3172\n" + 
				"MAXI LOPEZ		cod.relink:	411\n" + 
				"E. LLAMA		cod.relink:	2889\n" + 
				"BOATENG		cod.relink:	4771\n" + 
				"KEKO		cod.relink:	3742\n" + 
				"PETKOVIC		cod.relink:	4770\n" + 
				"PUGGIONI		cod.relink:	2567\n" + 
				"DAINELLI		cod.relink:	473\n" + 
				"SARDO		cod.relink:	2470\n" + 
				"PAMIC		cod.relink:	3325\n" + 
				"RADOVANOVIC		cod.relink:	2930\n" + 
				"L. RIGONI		cod.relink:	2194\n" + 
				"SESTU		cod.relink:	2175\n" + 
				"PELLISSIER		cod.relink:	478\n" + 
				"THEREAU		cod.relink:	2759\n" + 
				"SQUIZZI		cod.relink:	2203\n" + 
				"CLAITON		cod.relink:	4917\n" + 
				"PAPP		cod.relink:	4102\n" + 
				"N. FREY		cod.relink:	3171\n" + 
				"DRAMÉ		cod.relink:	2180\n" + 
				"CALELLO		cod.relink:	3269\n" + 
				"A. MAXWELL		cod.relink:	4851\n" + 
				"LAZAREVIC		cod.relink:	4330\n" + 
				"SAMASSA		cod.relink:	2451\n" + 
				"PALOSCHI		cod.relink:	2913\n" + 
				"M. SILVESTRI		cod.relink:	4905\n" + 
				"BENTIVOGLIO		cod.relink:	3107\n" + 
				"GUANA		cod.relink:	474\n" + 
				"NETO		cod.relink:	3992\n" + 
				"TOMOVIC		cod.relink:	2976\n" + 
				"GONZALO		cod.relink:	847\n" + 
				"S. SAVIC		cod.relink:	4004\n" + 
				"B. VALERO		cod.relink:	2373\n" + 
				"PASQUAL		cod.relink:	2200\n" + 
				"GOMEZ		cod.relink:	977\n" + 
				"LJAJIC		cod.relink:	3529\n" + 
				"MUNÚA		cod.relink:	373\n" + 
				"RONCAGLIA		cod.relink:	2973\n" + 
				"COMPPER		cod.relink:	2131\n" + 
				"AMBROSINI		cod.relink:	78\n" + 
				"JOAQUÍN		cod.relink:	415\n" + 
				"WOLSKI		cod.relink:	4241\n" + 
				"EL HAMDAOUI		cod.relink:	838\n" + 
				"ROSSI		cod.relink:	896\n" + 
				"LUPATELLI		cod.relink:	231\n" + 
				"IAKOVENKO		cod.relink:	2965\n" + 
				"RUBEN OLIVERA	cod.relink:	539\n" + 
				"M. VECINO		cod.relink:	4231\n" + 
				"MATOS		cod.relink:	4872\n" + 
				"PERIN		cod.relink:	3585\n" + 
				"PORTANOVA		cod.relink:	922\n" + 
				"T. MANFREDINI		cod.relink:	480\n" + 
				"VRSALJKO		cod.relink:	3672\n" + 
				"ANTONELLI		cod.relink:	2931\n" + 
				"LODI		cod.relink:	692\n" + 
				"KUCKA		cod.relink:	3326\n" + 
				"A. BERTOLACCI	cod.relink:	3936\n" + 
				"SANTANA		cod.relink:	601\n" + 
				"DE MAIO		cod.relink:	3832\n" + 
				"MARCHESE		cod.relink:	2202\n" + 
				"F. SEYMOUR		cod.relink:	3778\n" + 
				"BIONDINI		cod.relink:	2193\n" + 
				"STRASSER		cod.relink:	3272\n" + 
				"TÖZSÉR		cod.relink:	2765\n" + 
				"C. JORQUERA		cod.relink:	3781\n" + 
				"FLORO FLORES	cod.relink:	682\n" + 
				"POLENTA		cod.relink:	3191\n" + 
				"J. MARTÍNEZ		cod.relink:	4153\n" + 
				"ZÉ EDUARDO		cod.relink:	4038\n" + 
				"RANOCCHIA		cod.relink:	3345\n" + 
				"JUAN		cod.relink:	3866\n" + 
				"CAMBIASSO		cod.relink:	408\n" + 
				"KUZMANOVIC		cod.relink:	2564\n" + 
				"NAGATOMO		cod.relink:	1048\n" + 
				"R. ÁLVAREZ		cod.relink:	3787\n" + 
				"CARRIZO		cod.relink:	731\n" + 
				"ANDREOLLI		cod.relink:	2112\n" + 
				"SAMUEL		cod.relink:	156\n" + 
				"ROLANDO		cod.relink:	3146\n" + 
				"JONATHAN		cod.relink:	3765\n" + 
				"JAVIER ZANETTI	cod.relink:	160\n" + 
				"WALLACE		cod.relink:	4621\n" + 
				"S. TAÏDER		cod.relink:	4173\n" + 
				"KOVACIC		cod.relink:	3986\n" + 
				"BELFODIL		cod.relink:	3624\n" + 
				"M. ICARDI		cod.relink:	4282\n" + 
				"D. MILITO		cod.relink:	702\n" + 
				"CASTELLAZZI		cod.relink:	577\n" + 
				"CHIVU		cod.relink:	112\n" + 
				"MUDINGAYI		cod.relink:	552\n" + 
				"OBI		cod.relink:	3524\n" + 
				"MARIGA		cod.relink:	2552\n" + 
				"OLSEN		cod.relink:	4772\n" + 
				"SCHELOTTO		cod.relink:	3804\n" + 
				"CAPELLO		cod.relink:	4768\n" + 
				"VUCINIC		cod.relink:	699\n" + 
				"TÉVEZ		cod.relink:	412\n" + 
				"STORARI		cod.relink:	894\n" + 
				"OGBONNA		cod.relink:	2478\n" + 
				"DE CEGLIE		cod.relink:	2480\n" + 
				"PELUSO		cod.relink:	3261\n" + 
				"MARRONE		cod.relink:	3607\n" + 
				"PADOIN		cod.relink:	2907\n" + 
				"QUAGLIARELLA	cod.relink:	2128\n" + 
				"MATRI		cod.relink:	2894\n" + 
				"LLORENTE		cod.relink:	2007\n" + 
				"RUBINHO		cod.relink:	2783\n" + 
				"M. MOTTA		cod.relink:	1975\n" + 
				"PEPE		cod.relink:	404\n" + 
				"J. MARTINEZ		cod.relink:	556\n" + 
				"BIAVA		cod.relink:	701\n" + 
				"ANDRÉ DIAS		cod.relink:	2376\n" + 
				"KONKO		cod.relink:	2476\n" + 
				"C. LEDESMA		cod.relink:	697\n" + 
				"LULIC		cod.relink:	4003\n" + 
				"BIZZARRI		cod.relink:	762\n" + 
				"CIANI		cod.relink:	925\n" + 
				"STANKEVICIUS		cod.relink:	580\n" + 
				"CAVANDA		cod.relink:	3928\n" + 
				"CANA		cod.relink:	590\n" + 
				"B. PEREIRINHA		cod.relink:	2349\n" + 
				"MAURI		cod.relink:	585\n" + 
				"EDERSON		cod.relink:	2012\n" + 
				"FLOCCARI		cod.relink:	2341\n" + 
				"VINÍCIUS		cod.relink:	4357\n" + 
				"FELIPE ANDERSON	cod.relink:	4104\n" + 
				"E. ALFARO		cod.relink:	4035\n" + 
				"B. PEREA		cod.relink:	4649\n" + 
				"KEITA		cod.relink:	4769\n" + 
				"BARDI		cod.relink:	3603\n" + 
				"A. BERNARDINI		cod.relink:	2242\n" + 
				"LUCI		cod.relink:	4784\n" + 
				"GRECO		cod.relink:	2199\n" + 
				"GEMITI		cod.relink:	482\n" + 
				"PAULINHO		cod.relink:	4807\n" + 
				"DIONISI		cod.relink:	4858\n" + 
				"DE LUCIA		cod.relink:	384\n" + 
				"MAZZONI		cod.relink:	4797\n" + 
				"BENASSI		cod.relink:	4342\n" + 
				"SILIGARDI		cod.relink:	4852\n" + 
				"ABBIATI		cod.relink:	220\n" + 
				"MEXÉS		cod.relink:	460\n" + 
				"EMANUELSON		cod.relink:	1981\n" + 
				"DE JONG		cod.relink:	604\n" + 
				"MUNTARI		cod.relink:	486\n" + 
				"K. P. BOATENG		cod.relink:	2145\n" + 
				"AMELIA		cod.relink:	683\n" + 
				"SILVESTRE		cod.relink:	728\n" + 
				"ZACCARDO		cod.relink:	472\n" + 
				"CONSTANT		cod.relink:	2491\n" + 
				"POLI		cod.relink:	2900\n" + 
				"NOCERINO		cod.relink:	2342\n" + 
				"B. TRAORE		cod.relink:	3543\n" + 
				"ROBINHO		cod.relink:	739\n" + 
				"PAZZINI		cod.relink:	690\n" + 
				"F. COPPOLA		cod.relink:	471\n" + 
				"GABRIEL		cod.relink:	4029\n" + 
				"BONERA		cod.relink:	443\n" + 
				"J. VERGARA		cod.relink:	4748\n" + 
				"ANTONINI		cod.relink:	681\n" + 
				"CRISTANTE		cod.relink:	4888\n" + 
				"PAOLO CANNAVARO	cod.relink:	431\n" + 
				"CALLEJÓN		cod.relink:	3120\n" + 
				"HAMSIK		cod.relink:	2333\n" + 
				"RAFAEL CABRAL	cod.relink:	4037\n" + 
				"M. BRITOS		cod.relink:	3198\n" + 
				"GAMBERINI		cod.relink:	574\n" + 
				"DONADEL		cod.relink:	572\n" + 
				"MESTO		cod.relink:	696\n" + 
				"PANDEV		cod.relink:	693\n" + 
				"CALAIO		cod.relink:	2785\n" + 
				"R. COLOMBO		cod.relink:	3108\n" + 
				"BRUNO UVINI		cod.relink:	4281\n" + 
				"DOSSENA		cod.relink:	2244\n" + 
				"MIRANTE		cod.relink:	566\n" + 
				"BENALOUANE		cod.relink:	2867\n" + 
				"PALETTA		cod.relink:	2385\n" + 
				"A. LUCARELLI		cod.relink:	906\n" + 
				"VALDES		cod.relink:	967\n" + 
				"MARCHIONNI		cod.relink:	448\n" + 
				"PAROLO		cod.relink:	3528\n" + 
				"BIABIANY		cod.relink:	2568\n" + 
				"GOBBI		cod.relink:	975\n" + 
				"CASSANO		cod.relink:	261\n" + 
				"AMAURI		cod.relink:	611\n" + 
				"PAVARINI		cod.relink:	877\n" + 
				"FELIPE		cod.relink:	484\n" + 
				"P. MENDES		cod.relink:	4206\n" + 
				"CASSANI		cod.relink:	2435\n" + 
				"ROSI		cod.relink:	2087\n" + 
				"D. MESBAH		cod.relink:	3815\n" + 
				"GALLOPPA		cod.relink:	2477\n" + 
				"MUNARI		cod.relink:	3110\n" + 
				"PALLADINO		cod.relink:	685\n" + 
				"SANSONE		cod.relink:	4154\n" + 
				"OKAKA		cod.relink:	2088\n" + 
				"L. PETKOVIC		cod.relink:	4750\n" + 
				"RISPOLI		cod.relink:	4867\n" + 
				"A. ACQUAH		cod.relink:	3947\n" + 
				"F. JANKOVIC		cod.relink:	4749\n" + 
				"DE SANCTIS		cod.relink:	479\n" + 
				"BENATIA		cod.relink:	2311\n" + 
				"MAICON		cod.relink:	734\n" + 
				"BALZARETTI		cod.relink:	2127\n" + 
				"PJANIC		cod.relink:	2947\n" + 
				"STROOTMAN		cod.relink:	3194\n" + 
				"LAMELA		cod.relink:	3628\n" + 
				"TOTTI		cod.relink:	76\n" + 
				"DESTRO		cod.relink:	3525\n" + 
				"LOBONT		cod.relink:	114\n" + 
				"BURDISSO		cod.relink:	242\n" + 
				"A. ROMAGNOLI		cod.relink:	4334\n" + 
				"DODÔ		cod.relink:	3764\n" + 
				"BRADLEY		cod.relink:	2343\n" + 
				"TADDEI		cod.relink:	400\n" + 
				"MARQUINHO		cod.relink:	4032\n" + 
				"BORRIELLO		cod.relink:	569\n" + 
				"JÚLIO SÉRGIO		cod.relink:	2474\n" + 
				"G. TALLO		cod.relink:	3935\n" + 
				"A. DA COSTA		cod.relink:	3909\n" + 
				"GASTALDELLO		cod.relink:	600\n" + 
				"PALOMBO		cod.relink:	399\n" + 
				"ANDREA COSTA	cod.relink:	2314\n" + 
				"KRSTICIC		cod.relink:	3223\n" + 
				"ERAMO		cod.relink:	4901\n" + 
				"PEDRO OBIANG	cod.relink:	3910\n" + 
				"DE SILVESTRI		cod.relink:	2238\n" + 
				"REGINI		cod.relink:	4844\n" + 
				"ÉDER		cod.relink:	2327\n" + 
				"MUSTAFI		cod.relink:	4114\n" + 
				"M. RODRÍGUEZ		cod.relink:	3777\n" + 
				"BERARDI		cod.relink:	3831\n" + 
				"CASTELLINI		cod.relink:	684\n" + 
				"GENTSOGLOU		cod.relink:	4819\n" + 
				"SORIANO		cod.relink:	3584\n" + 
				"RENAN		cod.relink:	4055\n" + 
				"POZZI		cod.relink:	678\n" + 
				"SANSONE		cod.relink:	3170\n" + 
				"LACZKÓ		cod.relink:	2807\n" + 
				"MARESCA		cod.relink:	316\n" + 
				"TERRANOVA		cod.relink:	4847\n" + 
				"GAZZOLA		cod.relink:	4824\n" + 
				"LONGHI		cod.relink:	4636\n" + 
				"MISSIROLI		cod.relink:	4804\n" + 
				"BERARDI		cod.relink:	4637\n" + 
				"ALEXE		cod.relink:	3616\n" + 
				"ZAZA		cod.relink:	4853\n" + 
				"ROSATI		cod.relink:	966\n" + 
				"MARZORATTI		cod.relink:	2352\n" + 
				"J. ROSSINI		cod.relink:	2899\n" + 
				"VALERI		cod.relink:	2980\n" + 
				"D. FARIAS		cod.relink:	4839\n" + 
				"PADELLI		cod.relink:	918\n" + 
				"BOVO		cod.relink:	403\n" + 
				"MORETTI		cod.relink:	315\n" + 
				"DARMIAN		cod.relink:	2893\n" + 
				"D'AMBROSIO		cod.relink:	2473\n" + 
				"A. FARNERUD		cod.relink:	810\n" + 
				"BRIGHI		cod.relink:	442\n" + 
				"GAZZI		cod.relink:	2566\n" + 
				"IMMOBILE		cod.relink:	3734\n" + 
				"GILLET		cod.relink:	3344\n" + 
				"L. GOMIS		cod.relink:	2906\n" + 
				"G. RODRÍGUEZ		cod.relink:	986\n" + 
				"S. MASIELLO		cod.relink:	2191\n" + 
				"M. BASHA		cod.relink:	4073\n" + 
				"VIVES		cod.relink:	3109\n" + 
				"O. EL KADDOURI	cod.relink:	3905\n" + 
				"BARRETO		cod.relink:	2100\n" + 
				"LARRONDO		cod.relink:	3224\n" + 
				"MEGGIORINI		cod.relink:	3602\n" + 
				"KELAVA		cod.relink:	2766\n" + 
				"T. HEURTAUX		cod.relink:	3835\n" + 
				"DANILO L.		cod.relink:	4155\n" + 
				"DOMIZZI		cod.relink:	679\n" + 
				"ALLAN		cod.relink:	4222\n" + 
				"R. PEREYRA		cod.relink:	3684\n" + 
				"LAZZARI		cod.relink:	688\n" + 
				"BASTA		cod.relink:	2074\n" + 
				"DI NATALE		cod.relink:	500\n" + 
				"BRKIC		cod.relink:	3757\n" + 
				"NALDO		cod.relink:	4259\n" + 
				"PASQUALE		cod.relink:	538\n" + 
				"PINZI		cod.relink:	481\n" + 
				"A. MERKEL		cod.relink:	3946\n" + 
				"MAICOSUEL		cod.relink:	4249\n" + 
				"RANÉGIE		cod.relink:	2554\n" + 
				"N. LÓPEZ		cod.relink:	4197\n" + 
				"BENUSSI		cod.relink:	2240\n" + 
				"CODA		cod.relink:	2132\n" + 
				"JADSON		cod.relink:	4250\n" + 
				"RAFAEL		cod.relink:	4634\n" + 
				"MORAS		cod.relink:	724\n" + 
				"MAIETTA		cod.relink:	4785\n" + 
				"CACCIATORE		cod.relink:	3583\n" + 
				"AGOSTINI		cod.relink:	322\n" + 
				"DONATI		cod.relink:	313\n" + 
				"HALLFREDSSON	cod.relink:	2021\n" + 
				"GÓMEZ TALEB		cod.relink:	4635\n" + 
				"TONI		cod.relink:	475\n" + 
				"NÍCOLAS		cod.relink:	4633\n" + 
				"A. GONZÁLEZ		cod.relink:	4036\n" + 
				"RÔMULO		cod.relink:	3920\n" + 
				"S. LANER		cod.relink:	4871\n" + 
				"J. SALA		cod.relink:	4906\n" + 
				"R. MARTINHO		cod.relink:	3906\n" + 
				"RAGATZU		cod.relink:	4826\n" + 
				"JANKOVIC		cod.relink:	2507\n" + 
				"CACIA		cod.relink:	2925\n" + 
				"A. CIRIGLIANO		cod.relink:	3991\n" + 
				"LONGO		cod.relink:	4319\n" + 
				"COUTINHO		cod.relink:	643\n" + 
				"WORMGOOR		cod.relink:	3220\n" + 
				"MEIJERS		cod.relink:	3100\n" + 
				"HOLLA		cod.relink:	2308\n" + 
				"VAN HAAREN		cod.relink:	3850\n" + 
				"K. JANSEN		cod.relink:	4127\n" + 
				"CABRAL		cod.relink:	3851\n" + 
				"ZWINKELS		cod.relink:	537\n" + 
				"C. SUPUSEPA		cod.relink:	3876\n" + 
				"M. SCHET		cod.relink:	2954\n" + 
				"M. ESAJAS		cod.relink:	4643\n" + 
				"KRAMER		cod.relink:	4821\n" + 
				"VERMEER		cod.relink:	1982\n" + 
				"BLIND		cod.relink:	3248\n" + 
				"POULSEN		cod.relink:	417\n" + 
				"DE JONG		cod.relink:	2950\n" + 
				"BOJAN		cod.relink:	2799\n" + 
				"K. SIGTHÓRSSON	cod.relink:	3886\n" + 
				"CILLESSEN		cod.relink:	3215\n" + 
				"BOILESEN		cod.relink:	3881\n" + 
				"ENOH		cod.relink:	3232\n" + 
				"L. ANDERSEN		cod.relink:	4351\n" + 
				"T. SANA		cod.relink:	3265\n" + 
				"E. ALVARADO		cod.relink:	3849\n" + 
				"J. WUYTENS		cod.relink:	2139\n" + 
				"M. JOHANSSON	cod.relink:	3354\n" + 
				"VIERGEVER		cod.relink:	3559\n" + 
				"GUDELJ		cod.relink:	3568\n" + 
				"V. ELM		cod.relink:	3250\n" + 
				"BEERENS		cod.relink:	2251\n" + 
				"J. GUDMUNDSSON	cod.relink:	3885\n" + 
				"HEIJBLOK		cod.relink:	2845\n" + 
				"REIJNEN		cod.relink:	3988\n" + 
				"MARCELLIS		cod.relink:	2249\n" + 
				"GORTER		cod.relink:	2839\n" + 
				"ORTÍZ		cod.relink:	3610\n" + 
				"OVERTOOM		cod.relink:	3233\n" + 
				"MARTENS		cod.relink:	516\n" + 
				"F. LEWIS		cod.relink:	4312\n" + 
				"H. VERHULST		cod.relink:	3883\n" + 
				"W. HOEDT		cod.relink:	4645\n" + 
				"P. KOK		cod.relink:	4886\n" + 
				"E. BABALJ		cod.relink:	4644\n" + 
				"L. NIENHUIS		cod.relink:	4891\n" + 
				"R. LEEUWIN		cod.relink:	2317\n" + 
				"VAN DER LAAN		cod.relink:	4814\n" + 
				"R. SWINKELS		cod.relink:	4313\n" + 
				"ZEINSTRA		cod.relink:	4838\n" + 
				"BROEKHOF		cod.relink:	4840\n" + 
				"M. DIJKSTRA		cod.relink:	4860\n" + 
				"M. PEREIRA		cod.relink:	4903\n" + 
				"J. DE VRIES		cod.relink:	4868\n" + 
				"VAN BRAKEL		cod.relink:	4820\n" + 
				"J. DE GRAAF		cod.relink:	4744\n" + 
				"MULDER		cod.relink:	2840\n" + 
				"DE VRIJ		cod.relink:	3676\n" + 
				"MATHIJSEN		cod.relink:	652\n" + 
				"JANMAAT		cod.relink:	3099\n" + 
				"MARTINS INDI		cod.relink:	3852\n" + 
				"CLASIE		cod.relink:	3868\n" + 
				"IMMERS		cod.relink:	3098\n" + 
				"SCHAKEN		cod.relink:	2089\n" + 
				"PELLÈ		cod.relink:	923\n" + 
				"GRAAFLAND		cod.relink:	331\n" + 
				"LAMPROU		cod.relink:	3611\n" + 
				"NELOM		cod.relink:	3814\n" + 
				"VORMER		cod.relink:	2459\n" + 
				"H. SINGH		cod.relink:	4257\n" + 
				"GOOSSENS		cod.relink:	2951\n" + 
				"VERHOEK		cod.relink:	1976\n" + 
				"CISSÉ		cod.relink:	936\n" + 
				"ARMENTEROS		cod.relink:	2911\n" + 
				"E. MANU		cod.relink:	4181\n" + 
				"E. ROOM		cod.relink:	3177\n" + 
				"VAN DER LINDEN	cod.relink:	4855\n" + 
				"OVERGOOR		cod.relink:	2851\n" + 
				"X. HOUTKOOP		cod.relink:	4837\n" + 
				"J. POT		cod.relink:	4884\n" + 
				"J. RIJSDIJK		cod.relink:	4856\n" + 
				"E. FALKENBURG	cod.relink:	3181\n" + 
				"J. GODEE		cod.relink:	3182\n" + 
				"G. PHILIPS		cod.relink:	4610\n" + 
				"R. LUCAS		cod.relink:	4745\n" + 
				"BIZOT		cod.relink:	3880\n" + 
				"BOTTEGHIN		cod.relink:	4123\n" + 
				"G. WIJNALDUM		cod.relink:	3884\n" + 
				"LINDGREN		cod.relink:	1979\n" + 
				"VAN DER VELDEN	cod.relink:	650\n" + 
				"CHERY		cod.relink:	3503\n" + 
				"D. TEXEIRA		cod.relink:	4184\n" + 
				"LUCIANO		cod.relink:	2838\n" + 
				"S. MAGNASCO		cod.relink:	4224\n" + 
				"KIEFTENBELD		cod.relink:	3853\n" + 
				"HIARIEJ		cod.relink:	2502\n" + 
				"H. BOS		cod.relink:	4134\n" + 
				"M. JONES		cod.relink:	4133\n" + 
				"ZEEFUIK		cod.relink:	2755\n" + 
				"E. JOHANSSON	cod.relink:	2553\n" + 
				"KRUISWIJK		cod.relink:	649\n" + 
				"VANDENBUSSCHE	cod.relink:	841\n" + 
				"C. KRAMER		cod.relink:	4647\n" + 
				"KUM		cod.relink:	928\n" + 
				"ZOMER		cod.relink:	660\n" + 
				"VAN DEN BERG	cod.relink:	1984\n" + 
				"VAN LA PARRA		cod.relink:	3135\n" + 
				"FAZLI		cod.relink:	3569\n" + 
				"PASVEER		cod.relink:	950\n" + 
				"SCHENKEVELD	cod.relink:	3675\n" + 
				"B. RIENSTRA		cod.relink:	3873\n" + 
				"KOENDERS		cod.relink:	2444\n" + 
				"QUANSAH		cod.relink:	863\n" + 
				"DUARTE		cod.relink:	3560\n" + 
				"BRUNS		cod.relink:	3989\n" + 
				"B. LINSSEN		cod.relink:	3861\n" + 
				"AMOAH		cod.relink:	641\n" + 
				"TELGENKAMP		cod.relink:	4842\n" + 
				"VELDMATE		cod.relink:	2955\n" + 
				"M. TE WIERIK		cod.relink:	3717\n" + 
				"L. VAN DIJK		cod.relink:	4120\n" + 
				"DAVIDSON		cod.relink:	4147\n" + 
				"VUJICEVIC		cod.relink:	3570\n" + 
				"M. BROUWER		cod.relink:	4374\n" + 
				"D. RIENSTRA		cod.relink:	4746\n" + 
				"TEN ROUWELAAR	cod.relink:	433\n" + 
				"H.DROST		cod.relink:	1983\n" + 
				"KWAKMAN		cod.relink:	646\n" + 
				"DE ROOVER		cod.relink:	2446\n" + 
				"GILISSEN		cod.relink:	842\n" + 
				"BUIJS		cod.relink:	2841\n" + 
				"SARPONG		cod.relink:	2313\n" + 
				"BABOS		cod.relink:	106\n" + 
				"SWERTS		cod.relink:	4780\n" + 
				"LOOMS		cod.relink:	844\n" + 
				"BODOR		cod.relink:	4898\n" + 
				"HADOUIR		cod.relink:	651\n" + 
				"D. VERBEEK		cod.relink:	4346\n" + 
				"LURLING		cod.relink:	441\n" + 
				"POEPON		cod.relink:	2500\n" + 
				"K. JOHNSSON		cod.relink:	4362\n" + 
				"R. VAN EIJDEN		cod.relink:	2250\n" + 
				"M. BREUER		cod.relink:	837\n" + 
				"D. BOVENBERG	cod.relink:	2848\n" + 
				"R. KOOLWIJK		cod.relink:	2849\n" + 
				"M. HIGDON		cod.relink:	4296\n" + 
				"D. GENTENAAR	cod.relink:	661\n" + 
				"J. SMITS		cod.relink:	4128\n" + 
				"P. CMOVŠ		cod.relink:	3510\n" + 
				"G. ROORDA		cod.relink:	2837\n" + 
				"S. DIARRA		cod.relink:	4747\n" + 
				"ZOET		cod.relink:	3293\n" + 
				"J. BRUMA		cod.relink:	4865\n" + 
				"ARIAS		cod.relink:	4138\n" + 
				"J. WILLEMS		cod.relink:	4185\n" + 
				"SCHAARS		cod.relink:	642\n" + 
				"A. MAHER		cod.relink:	3882\n" + 
				"WIJNALDUM		cod.relink:	2756\n" + 
				"Z. BAKKALI		cod.relink:	4646\n" + 
				"ZANKA		cod.relink:	2809\n" + 
				"MARCELO		cod.relink:	3337\n" + 
				"JOZEFZOON		cod.relink:	3932\n" + 
				"NARSINGH		cod.relink:	3249\n" + 
				"VAN MOSSELVELD	cod.relink:	654\n" + 
				"LAMEY		cod.relink:	435\n" + 
				"R. AMIEUX		cod.relink:	3856\n" + 
				"DUITS		cod.relink:	850\n" + 
				"K. ANDERSON		cod.relink:	4880\n" + 
				"BRABER		cod.relink:	1016\n" + 
				"JOACHIM		cod.relink:	2732\n" + 
				"VAN DIJK		cod.relink:	2463\n" + 
				"VAN DEN KIEBOOM	cod.relink:	3571\n" + 
				"J. IVENS		cod.relink:	3854\n" + 
				"JUNGSCHLÄGER	cod.relink:	929\n" + 
				"D. LEMKE		cod.relink:	4370\n" + 
				"KURTO		cod.relink:	3582\n" + 
				"LUIJCKX		cod.relink:	2458\n" + 
				"BIEMANS		cod.relink:	3296\n" + 
				"VAN PEPPEN		cod.relink:	2407\n" + 
				"PLUIM		cod.relink:	3175\n" + 
				"HUPPERTS		cod.relink:	3588\n" + 
				"FLEDDERUS		cod.relink:	935\n" + 
				"DONALD		cod.relink:	2846\n" + 
				"DEMOUGE		cod.relink:	663\n" + 
				"G. RAMOS		cod.relink:	4068\n" + 
				"H. DIJKHUIZEN		cod.relink:	4648\n" + 
				"BONEVACIA		cod.relink:	3848\n" + 
				"SUTCHUIN		cod.relink:	3251\n" + 
				"NÉMETH		cod.relink:	2883\n" + 
				"A. ŠECEROVIC		cod.relink:	4861\n" + 
				"HÖCHER		cod.relink:	843\n" + 
				"R. BENGTSSON	cod.relink:	3888\n" + 
				"R. ROSALES		cod.relink:	3369\n" + 
				"F. GUTIÉRREZ		cod.relink:	3785\n" + 
				"Q. PROMES		cod.relink:	4885\n" + 
				"D. TADIC		cod.relink:	3855\n" + 
				"BOSCHKER		cod.relink:	599\n" + 
				"WISGERHOF		cod.relink:	662\n" + 
				"BREUKERS		cod.relink:	3173\n" + 
				"C. MARTINA		cod.relink:	4135\n" + 
				"KUIPER		cod.relink:	3176\n" + 
				"BRAMA		cod.relink:	2174\n" + 
				"SCHILDER		cod.relink:	2365\n" + 
				"JANSSEN		cod.relink:	2086\n" + 
				"JOHN		cod.relink:	2847\n" + 
				"T. BOUMA		cod.relink:	4921\n" + 
				"L. DJORDJEVIC	cod.relink:	4335\n" + 
				"RUITER		cod.relink:	3183\n" + 
				"DERIJCK		cod.relink:	2137\n" + 
				"M. V. D. MAAREL	cod.relink:	3681\n" + 
				"J. MÅRTENSSON	cod.relink:	4129\n" + 
				"TAKAGI		cod.relink:	1052\n" + 
				"TOORNSTRA		cod.relink:	3673\n" + 
				"VERHOEVEN		cod.relink:	647\n" + 
				"M. NILSSON		cod.relink:	4139\n" + 
				"A. SAROTA		cod.relink:	3858\n" + 
				"DE RIDDER		cod.relink:	3193\n" + 
				"DUPLAN		cod.relink:	2961\n" + 
				"VAN DER GUN		cod.relink:	213\n" + 
				"VELTHUIZEN		cod.relink:	2138\n" + 
				"G. KASHIA		cod.relink:	3954\n" + 
				"VAN DER HEIJDEN	cod.relink:	2949\n" + 
				"LEERDAM		cod.relink:	3295\n" + 
				"P. VAN AANHOLT	cod.relink:	3914\n" + 
				"VEJINOVIC		cod.relink:	2958\n" + 
				"JANSSEN		cod.relink:	832\n" + 
				"R. IBARRA		cod.relink:	4130\n" + 
				"KAKUTA		cod.relink:	3281\n" + 
				"LUCAS PIAZÓN		cod.relink:	4122\n" + 
				"JONATHAN REIS	cod.relink:	2842\n" + 
				"D. MORI		cod.relink:	4350\n" + 
				"VAN DER STRUIJK	cod.relink:	653\n" + 
				"PRÖPPER		cod.relink:	3558\n" + 
				"W. VINK		cod.relink:	4201\n" + 
				"M. PEDERSEN		cod.relink:	3955\n" + 
				"HAVENAAR		cod.relink:	1037\n" + 
				"BOER		cod.relink:	648\n" + 
				"VAN DER WERFF	cod.relink:	3200\n" + 
				"BROERSE		cod.relink:	659\n" + 
				"VAN POLEN		cod.relink:	2445\n" + 
				"ACHENTEH		cod.relink:	2252\n" + 
				"MOKOTJO		cod.relink:	3813\n" + 
				"J. DROST		cod.relink:	4255\n" + 
				"BENSON		cod.relink:	1978\n" + 
				"BEGOIS		cod.relink:	4795\n" + 
				"L. TER WIELEN		cod.relink:	3677\n" + 
				"D. LACHMAN		cod.relink:	3679\n" + 
				"GRAVENBEEK		cod.relink:	3589\n" + 
				"B. VAN HINTUM		cod.relink:	4254\n" + 
				"NARSINGH		cod.relink:	3101\n" + 
				"RENIERS		cod.relink:	2964\n" + 
				"NIJLAND		cod.relink:	4825\n" + 
				"G. FERNANDEZ	cod.relink:	3097\n" + 
				"ESTEBAN		cod.relink:	47\n" + 
				"PELLERANO		cod.relink:	3147\n" + 
				"RAFITA		cod.relink:	4789\n" + 
				"DUBARBIER		cod.relink:	4830\n" + 
				"VERZA		cod.relink:	4788\n" + 
				"ALEIX VIDAL		cod.relink:	4624\n" + 
				"SUSO		cod.relink:	4186\n" + 
				"SORIANO		cod.relink:	4787\n" + 
				"Ó. USTARI		cod.relink:	2393\n" + 
				"M. SILVA		cod.relink:	3877\n" + 
				"M. TORSIGLIERI	cod.relink:	4904\n" + 
				"NÉLSON		cod.relink:	2276\n" + 
				"CHRISTIAN		cod.relink:	2511\n" + 
				"RAÚL		cod.relink:	4873\n" + 
				"CORONA		cod.relink:	2261\n" + 
				"JONATHAN ZONGO	cod.relink:	4623\n" + 
				"OSCAR DIAZ		cod.relink:	4834\n" + 
				"RUBÉN		cod.relink:	4796\n" + 
				"IRAIZOZ		cod.relink:	751\n" + 
				"GURPEGI		cod.relink:	772\n" + 
				"BORJA EKIZA		cod.relink:	3981\n" + 
				"IRAOLA		cod.relink:	771\n" + 
				"BALENZIAGA		cod.relink:	3227\n" + 
				"ITURRASPE		cod.relink:	3217\n" + 
				"BEÑAT		cod.relink:	2515\n" + 
				"SUSAETA		cod.relink:	2905\n" + 
				"MUNIAIN		cod.relink:	3608\n" + 
				"ANDER HERRERA	cod.relink:	3572\n" + 
				"ENRIQUE SOLA	cod.relink:	2938\n" + 
				"MIKEL SAN JOSÉ	cod.relink:	2917\n" + 
				"ETXEITA		cod.relink:	4843\n" + 
				"AURTENETXE		cod.relink:	3722\n" + 
				"IÑIGO PÉREZ		cod.relink:	3721\n" + 
				"DE MARCOS		cod.relink:	3609\n" + 
				"ERIK MORÁN		cod.relink:	4758\n" + 
				"TOQUERO		cod.relink:	3121\n" + 
				"IBAI GÓMEZ		cod.relink:	3867\n" + 
				"ADURIZ		cod.relink:	2324\n" + 
				"M. RICO		cod.relink:	4107\n" + 
				"JOÃO MIRANDA		cod.relink:	2184\n" + 
				"JUANFRAN		cod.relink:	780\n" + 
				"MARIO SUÁREZ	cod.relink:	2266\n" + 
				"GABI		cod.relink:	758\n" + 
				"KOKE		cod.relink:	3736\n" + 
				"DIEGO COSTA		cod.relink:	2828\n" + 
				"ARANZUBIA		cod.relink:	770\n" + 
				"JOSÉ GIMÉNEZ		cod.relink:	4627\n" + 
				"DEMICHELIS		cod.relink:	409\n" + 
				"INSÚA		cod.relink:	2533\n" + 
				"TIAGO		cod.relink:	489\n" + 
				"OLIVER TORRES	cod.relink:	4341\n" + 
				"RAÚL GARCÍA		cod.relink:	963\n" + 
				"LEO		cod.relink:	4338\n" + 
				"ADRIÁN		cod.relink:	2510\n" + 
				"ADRIANO		cod.relink:	2004\n" + 
				"PINTO		cod.relink:	458\n" + 
				"BARTRA		cod.relink:	3941\n" + 
				"PUYOL		cod.relink:	41\n" + 
				"MONTOYA		cod.relink:	3942\n" + 
				"JONATHAN		cod.relink:	3613\n" + 
				"S. ROBERTO		cod.relink:	3950\n" + 
				"CUENCA		cod.relink:	4199\n" + 
				"C. TELLO		cod.relink:	4236\n" + 
				"SERGI GÓMEZ		cod.relink:	3945\n" + 
				"AFELLAY		cod.relink:	658\n" + 
				"PAULÃO		cod.relink:	3618\n" + 
				"CHICA		cod.relink:	2509\n" + 
				"NACHO		cod.relink:	926\n" + 
				"MATILLA		cod.relink:	4866\n" + 
				"JOAN VERDÚ		cod.relink:	2375\n" + 
				"J. MOLINA		cod.relink:	4076\n" + 
				"G. SARA		cod.relink:	4725\n" + 
				"JORDI FIGUERAS	cod.relink:	3802\n" + 
				"A. AMAYA		cod.relink:	3594\n" + 
				"STEINHÖFER		cod.relink:	2547\n" + 
				"DÍDAC		cod.relink:	3252\n" + 
				"X. TORRES		cod.relink:	3573\n" + 
				"NONO		cod.relink:	4356\n" + 
				"Á. VADILLO		cod.relink:	4191\n" + 
				"JUAN CARLOS		cod.relink:	3984\n" + 
				"S. SEVILLA		cod.relink:	4074\n" + 
				"RUBÉN CASTRO	cod.relink:	910\n" + 
				"B. RODRÍGUEZ		cod.relink:	4380\n" + 
				"L. REYES		cod.relink:	4381\n" + 
				"YOEL		cod.relink:	4816\n" + 
				"CABRAL		cod.relink:	2974\n" + 
				"FONTÀS		cod.relink:	3614\n" + 
				"H. MALLO		cod.relink:	4289\n" + 
				"TONI		cod.relink:	4292\n" + 
				"BORJA OUBIÑA		cod.relink:	598\n" + 
				"Á. LÓPEZ		cod.relink:	4293\n" + 
				"A. FERNÁNDEZ		cod.relink:	2360\n" + 
				"NOLITO		cod.relink:	3943\n" + 
				"SERGIO ÁLVAREZ	cod.relink:	2269\n" + 
				"SAMUEL		cod.relink:	4327\n" + 
				"A. TÚÑEZ		cod.relink:	4290\n" + 
				"JONI		cod.relink:	4354\n" + 
				"JONATHAN VILA	cod.relink:	2527\n" + 
				"CHISPA		cod.relink:	2186\n" + 
				"RAFINHA		cod.relink:	4337\n" + 
				"F. ORELLANA		cod.relink:	3274\n" + 
				"D. RODRÍGUEZ		cod.relink:	3184\n" + 
				"BERMEJO		cod.relink:	2834\n" + 
				"RUBÉN BLANCO	cod.relink:	4767\n" + 
				"MANU		cod.relink:	4892\n" + 
				"BOTÍA		cod.relink:	3574\n" + 
				"LOMBÁN		cod.relink:	4893\n" + 
				"SAPUNARU		cod.relink:	3196\n" + 
				"CISMA		cod.relink:	2833\n" + 
				"GENERELO		cod.relink:	775\n" + 
				"RIVERA		cod.relink:	308\n" + 
				"CARLES GIL		cod.relink:	4595\n" + 
				"AARÓN ÑÍGUEZ	cod.relink:	4815\n" + 
				"COROMINAS		cod.relink:	4786\n" + 
				"MANU DEL MORAL	cod.relink:	859\n" + 
				"TOÑO		cod.relink:	857\n" + 
				"D. SUÁREZ		cod.relink:	4144\n" + 
				"BÉRANGER		cod.relink:	4832\n" + 
				"RUBÉN PÉREZ		cod.relink:	3875\n" + 
				"JAVI MÁRQUEZ		cod.relink:	3519\n" + 
				"STEVANOVIC		cod.relink:	4272\n" + 
				"JAVI FLORES		cod.relink:	4594\n" + 
				"CASILLA		cod.relink:	2370\n" + 
				"COLOTTO		cod.relink:	3219\n" + 
				"MORENO		cod.relink:	2957\n" + 
				"JAVI LÓPEZ		cod.relink:	3723\n" + 
				"JUAN FUENTES	cod.relink:	4626\n" + 
				"DAVID LÓPEZ		cod.relink:	4874\n" + 
				"V. SÁNCHEZ		cod.relink:	3203\n" + 
				"STUANI		cod.relink:	2927\n" + 
				"SIMÃO		cod.relink:	33\n" + 
				"SERGIO GARCÍA	cod.relink:	576\n" + 
				"RAÚL RODRÍGUEZ	cod.relink:	3983\n" + 
				"FELIPE MATTIONI	cod.relink:	3273\n" + 
				"CAPDEVILA		cod.relink:	204\n" + 
				"ABRAHAM		cod.relink:	4625\n" + 
				"C. GÓMEZ		cod.relink:	4204\n" + 
				"S. TEJERA		cod.relink:	3597\n" + 
				"J. ALBÍN		cod.relink:	2512\n" + 
				"SIDNEI		cod.relink:	4900\n" + 
				"MOYÀ		cod.relink:	964\n" + 
				"ALEXIS		cod.relink:	927\n" + 
				"RAFA		cod.relink:	765\n" + 
				"JUAN VALERA		cod.relink:	757\n" + 
				"SERGIO ESCUDERO	cod.relink:	4285\n" + 
				"MÍCHEL		cod.relink:	3125\n" + 
				"LACEN		cod.relink:	2172\n" + 
				"PEDRO LEÓN		cod.relink:	2787\n" + 
				"DIEGO CASTRO	cod.relink:	2265\n" + 
				"SARABIA		cod.relink:	3999\n" + 
				"A. COLUNGA		cod.relink:	3188\n" + 
				"CODINA		cod.relink:	2824\n" + 
				"LOPO		cod.relink:	752\n" + 
				"ARROYO		cod.relink:	4328\n" + 
				"ROBERTO LAGO	cod.relink:	2526\n" + 
				"BORJA		cod.relink:	394\n" + 
				"JUAN RODRÍGUEZ	cod.relink:	779\n" + 
				"LAFITA		cod.relink:	2260\n" + 
				"J. GAVILÁN		cod.relink:	579\n" + 
				"PEDRO MOSQUERA	cod.relink:	4869\n" + 
				"MIKU		cod.relink:	3372\n" + 
				"ÁLVARO		cod.relink:	3878\n" + 
				"ROBERTO		cod.relink:	853\n" + 
				"DIAKHATÉ		cod.relink:	2079\n" + 
				"JEISON MURILLO	cod.relink:	4764\n" + 
				"B. ANGULO		cod.relink:	3520\n" + 
				"ITURRA		cod.relink:	2406\n" + 
				"YEBDA		cod.relink:	593\n" + 
				"BRAHIMI		cod.relink:	2856\n" + 
				"D. BENITEZ		cod.relink:	4106\n" + 
				"PITI		cod.relink:	4078\n" + 
				"EL-ARABI		cod.relink:	3807\n" + 
				"D. MAINZ		cod.relink:	4105\n" + 
				"COEFF		cod.relink:	4919\n" + 
				"G. SIQUEIRA		cod.relink:	2364\n" + 
				"F. RICO		cod.relink:	4151\n" + 
				"BUONANOTTE		cod.relink:	2887\n" + 
				"ARANDA		cod.relink:	767\n" + 
				"RIKI		cod.relink:	938\n" + 
				"K. NAVAS		cod.relink:	3404\n" + 
				"HÉCTOR RODAS	cod.relink:	3841\n" + 
				"D. NAVARRO		cod.relink:	534\n" + 
				"PEDRO LÓPEZ		cod.relink:	961\n" + 
				"JUANFRAN		cod.relink:	420\n" + 
				"SIMÃO		cod.relink:	4828\n" + 
				"PINTO		cod.relink:	4781\n" + 
				"RUBÉN GARCÍA	cod.relink:	4355\n" + 
				"EL ZHAR		cod.relink:	2532\n" + 
				"BARRAL		cod.relink:	2371\n" + 
				"JAVI JIMÉNEZ		cod.relink:	4628\n" + 
				"EL ADOUA		cod.relink:	3552\n" + 
				"LELL		cod.relink:	605\n" + 
				"KARABELAS		cod.relink:	3507\n" + 
				"PALLARDÓ		cod.relink:	2517\n" + 
				"PAPAKOULI DIOP	cod.relink:	2455\n" + 
				"PEDRO RÍOS		cod.relink:	3347\n" + 
				"ÁNGEL		cod.relink:	3346\n" + 
				"BABA		cod.relink:	4058\n" + 
				"R. GOMIS		cod.relink:	2876\n" + 
				"HIGÓN		cod.relink:	4305\n" + 
				"W. CABALLERO	cod.relink:	385\n" + 
				"ANGELERI		cod.relink:	4846\n" + 
				"ROBERTO CHEN	cod.relink:	4739\n" + 
				"JESÚS GÁMEZ		cod.relink:	2264\n" + 
				"ANTUNES		cod.relink:	2914\n" + 
				"TISSONE		cod.relink:	2307\n" + 
				"SERGI DARDER	cod.relink:	4757\n" + 
				"DUDA		cod.relink:	778\n" + 
				"MORALES		cod.relink:	3161\n" + 
				"SANTA CRUZ		cod.relink:	151\n" + 
				"WELIGTON		cod.relink:	3123\n" + 
				"SERGIO SÁNCHEZ	cod.relink:	2256\n" + 
				"ELISEU		cod.relink:	3124\n" + 
				"CAMACHO		cod.relink:	2936\n" + 
				"RECIO		cod.relink:	3976\n" + 
				"BOBLEY ANDERSON	cod.relink:	4730\n" + 
				"PORTILLO		cod.relink:	3743\n" + 
				"S. FERNÁNDEZ		cod.relink:	3646\n" + 
				"JUANMI		cod.relink:	3744\n" + 
				"SAMUEL		cod.relink:	4765\n" + 
				"B. PAWLOWSKI		cod.relink:	4732\n" + 
				"A. FERNÁNDEZ		cod.relink:	2937\n" + 
				"ARRIBAS		cod.relink:	4080\n" + 
				"BERTRÁN		cod.relink:	753\n" + 
				"JOAN ORIOL		cod.relink:	3740\n" + 
				"PUÑAL		cod.relink:	769\n" + 
				"R. LOE		cod.relink:	4308\n" + 
				"ÁLVARO CEJUDO	cod.relink:	3980\n" + 
				"DE LAS CUEVAS	cod.relink:	2513\n" + 
				"ARMENTEROS		cod.relink:	3598\n" + 
				"J. A. NÚÑEZ		cod.relink:	3818\n" + 
				"RIESGO		cod.relink:	969\n" + 
				"FLAÑO		cod.relink:	962\n" + 
				"LOLO		cod.relink:	2520\n" + 
				"OIER		cod.relink:	3253\n" + 
				"DAMIA		cod.relink:	1021\n" + 
				"ECHAIDE		cod.relink:	3745\n" + 
				"R. TORRES		cod.relink:	4309\n" + 
				"SISI		cod.relink:	2786\n" + 
				"NINO		cod.relink:	2519\n" + 
				"RIERA		cod.relink:	4809\n" + 
				"E. SATRUSTEGUI	cod.relink:	4907\n" + 
				"COBEÑO		cod.relink:	2369\n" + 
				"Á. GÁLVEZ		cod.relink:	4207\n" + 
				"L. GALEANO		cod.relink:	4060\n" + 
				"TITO		cod.relink:	4079\n" + 
				"NACHO		cod.relink:	4365\n" + 
				"TRASHORRAS		cod.relink:	4174\n" + 
				"JOSÉ CARLOS		cod.relink:	3617\n" + 
				"L. BANGOURA		cod.relink:	4190\n" + 
				"A. BUENO		cod.relink:	2826\n" + 
				"LARRIVEY		cod.relink:	2896\n" + 
				"RUBÉN		cod.relink:	984\n" + 
				"JOHAN MOJICA		cod.relink:	4731\n" + 
				"RAÚL BAENA		cod.relink:	3685\n" + 
				"ADRIÁN GONZÁLEZ	cod.relink:	2825\n" + 
				"NERY CASTILLO	cod.relink:	407\n" + 
				"DIEGO LÓPEZ		cod.relink:	968\n" + 
				"MODRIC		cod.relink:	2381\n" + 
				"ISCO		cod.relink:	3889\n" + 
				"XABI ALONSO		cod.relink:	459\n" + 
				"CASEMIRO		cod.relink:	3918\n" + 
				"ILLARRAMENDI		cod.relink:	3939\n" + 
				"KAKÁ		cod.relink:	416\n" + 
				"JESÉ RODRÍGUEZ	cod.relink:	4639\n" + 
				"MORATA		cod.relink:	3977\n" + 
				"ADÁN		cod.relink:	3615\n" + 
				"ANSOTEGUI		cod.relink:	2368\n" + 
				"I. MARTÍNEZ		cod.relink:	4192\n" + 
				"C. MARTÍNEZ		cod.relink:	3837\n" + 
				"ALBERTO		cod.relink:	2524\n" + 
				"GORKA E.		cod.relink:	2739\n" + 
				"PARDO		cod.relink:	4304\n" + 
				"C. VELA		cod.relink:	2320\n" + 
				"G. CASTRO		cod.relink:	2903\n" + 
				"ZURUTUZA		cod.relink:	3839\n" + 
				"ZUBIKARAI		cod.relink:	3836\n" + 
				"MIKEL GONZÁLEZ	cod.relink:	2262\n" + 
				"ESTRADA		cod.relink:	2740\n" + 
				"JOSÉ ÁNGEL		cod.relink:	3254\n" + 
				"M. BERGARA		cod.relink:	3838\n" + 
				"XABI PRIETO		cod.relink:	860\n" + 
				"GRIEZMANN		cod.relink:	3840\n" + 
				"IFRÁN		cod.relink:	3937\n" + 
				"AGIRRETXE		cod.relink:	2263\n" + 
				"GRANERO		cod.relink:	2904\n" + 
				"FEDERICO FAZIO	cod.relink:	2522\n" + 
				"N. PAREJA		cod.relink:	2539\n" + 
				"COKE		cod.relink:	4077\n" + 
				"ALBERTO MORENO	cod.relink:	4629\n" + 
				"IBORRA		cod.relink:	2939\n" + 
				"RAKITIC		cod.relink:	2780\n" + 
				"PEROTTI		cod.relink:	3565\n" + 
				"MARKO MARIN		cod.relink:	3169\n" + 
				"BACCA		cod.relink:	3795\n" + 
				"JAVI VARAS		cod.relink:	2521\n" + 
				"DANIEL CARRIÇO	cod.relink:	3185\n" + 
				"F. NAVARRO		cod.relink:	444\n" + 
				"J. SAMPERIO		cod.relink:	4194\n" + 
				"TROCHOWSKI		cod.relink:	606\n" + 
				"B. MELLA		cod.relink:	3783\n" + 
				"RUSESCU		cod.relink:	3349\n" + 
				"REYES		cod.relink:	828\n" + 
				"GAMEIRO		cod.relink:	2016\n" + 
				"CALA		cod.relink:	3187\n" + 
				"CICINHO		cod.relink:	4256\n" + 
				"GUARENTE		cod.relink:	2929\n" + 
				"MADURO		cod.relink:	1980\n" + 
				"S. CRISTÓFORO	cod.relink:	4232\n" + 
				"DIEGO ALVES		cod.relink:	2835\n" + 
				"RAMI		cod.relink:	2860\n" + 
				"RICARDO COSTA	cod.relink:	492\n" + 
				"BERNAT		cod.relink:	4143\n" + 
				"JAVI FUEGO		cod.relink:	854\n" + 
				"MÍCHEL		cod.relink:	3567\n" + 
				"VICENTE GUAITA	cod.relink:	3214\n" + 
				"VÍCTOR RUIZ		cod.relink:	3606\n" + 
				"BARRAGÁN		cod.relink:	2270\n" + 
				"MATHIEU		cod.relink:	805\n" + 
				"ORIOL ROMEU		cod.relink:	3944\n" + 
				"A. GUARDADO		cod.relink:	2383\n" + 
				"FEGHOULI		cod.relink:	3137\n" + 
				"PAREJO		cod.relink:	3238\n" + 
				"CANALES		cod.relink:	3218\n" + 
				"PIATTI		cod.relink:	3122\n" + 
				"JONAS		cod.relink:	2326\n" + 
				"D. MARIÑO		cod.relink:	4193\n" + 
				"M. VALIENTE		cod.relink:	3724\n" + 
				"JESÚS RUEDA		cod.relink:	2941\n" + 
				"RUKAVINA		cod.relink:	3049\n" + 
				"PEÑA		cod.relink:	2064\n" + 
				"ÁLVARO RUBIO		cod.relink:	766\n" + 
				"L. SASTRE		cod.relink:	4340\n" + 
				"OMAR		cod.relink:	3735\n" + 
				"Ó. GONZÁLEZ		cod.relink:	763\n" + 
				"JAVI GUERRA		cod.relink:	2741\n" + 
				"JAIME		cod.relink:	4294\n" + 
				"JAVIER BARAJA		cod.relink:	855\n" + 
				"BARMETTLER		cod.relink:	3342\n" + 
				"GILBERTO GARCÍA	cod.relink:	4638\n" + 
				"V. PÉREZ		cod.relink:	4295\n" + 
				"RUBÉN PEÑA		cod.relink:	4368\n" + 
				"LOLO		cod.relink:	4344\n" + 
				"VALDET RAMA		cod.relink:	4369\n" + 
				"D. LARSSON		cod.relink:	4026\n" + 
				"MANUCHO		cod.relink:	2563\n" + 
				"HUMBERTO OSORIO	cod.relink:	4751\n" + 
				"SERGIO ASENJO	cod.relink:	2940\n" + 
				"MUSACCHIO		cod.relink:	2888\n" + 
				"MARIO		cod.relink:	3872\n" + 
				"BRUNO		cod.relink:	2508\n" + 
				"PINA		cod.relink:	3738\n" + 
				"H. PÉREZ		cod.relink:	3586\n" + 
				"CANI		cod.relink:	774\n" + 
				"G. DOS SANTOS	cod.relink:	2318\n" + 
				"UCHE		cod.relink:	858\n" + 
				"JUAN CARLOS		cod.relink:	4890\n" + 
				"DORADO		cod.relink:	4075\n" + 
				"A. PANTIC		cod.relink:	4727\n" + 
				"FARINOS		cod.relink:	216\n" + 
				"J. AQUINO		cod.relink:	4229\n" + 
				"J. PEREIRA		cod.relink:	1011\n" + 
				"PROTO		cod.relink:	1996\n" + 
				"NUYTINCK		cod.relink:	3587\n" + 
				"DESCHACHT		cod.relink:	497\n" + 
				"DE ZEEUW		cod.relink:	2190\n" + 
				"KLJESTAN		cod.relink:	3080\n" + 
				"BRUNO		cod.relink:	4323\n" + 
				"M. SUÁREZ		cod.relink:	3150\n" + 
				"G. B. CYRIAC		cod.relink:	3514\n" + 
				"KOUYATÉ		cod.relink:	3513\n" + 
				"VANDEN BORRE	cod.relink:	840\n" + 
				"LUKAKU		cod.relink:	4284\n" + 
				"F. CANESIN		cod.relink:	4283\n" + 
				"O. ÁLVAREZ		cod.relink:	4661\n" + 
				"MITROVIC		cod.relink:	4766\n" + 
				"R. VARGAS		cod.relink:	3151\n" + 
				"U. PARDO		cod.relink:	4849\n" + 
				"M. OLIVEIRA		cod.relink:	4611\n" + 
				"GUILHERME		cod.relink:	4059\n" + 
				"MÁRIO SÉRGIO		cod.relink:	4782\n" + 
				"CHRISTIAN		cod.relink:	4726\n" + 
				"NUNO MORAIS		cod.relink:	4803\n" + 
				"T. GOMES		cod.relink:	3152\n" + 
				"MANDUCA		cod.relink:	4813\n" + 
				"CHIOTIS		cod.relink:	4889\n" + 
				"VINICIUS		cod.relink:	3982\n" + 
				"ALONEFTIS		cod.relink:	2678\n" + 
				"SHERIDAN		cod.relink:	4817\n" + 
				"ELIA		cod.relink:	2677\n" + 
				"H. CABRAL		cod.relink:	4046\n" + 
				"SATSIAS		cod.relink:	2680\n" + 
				"ŠVEJDÍK		cod.relink:	2461\n" + 
				"HOLEK		cod.relink:	3845\n" + 
				"VÁCHA		cod.relink:	2745\n" + 
				"VACEK		cod.relink:	2362\n" + 
				"M. CECH		cod.relink:	3336\n" + 
				"UJFALUŠI		cod.relink:	365\n" + 
				"ZÁPOTOCNÝ		cod.relink:	2384\n" + 
				"GIL		cod.relink:	4325\n" + 
				"MATEJOVSKÝ		cod.relink:	2468\n" + 
				"MARECEK		cod.relink:	3731\n" + 
				"KADERÁBEK		cod.relink:	3869\n" + 
				"BEDNÁR		cod.relink:	3114\n" + 
				"SKALÁK		cod.relink:	3870\n" + 
				"JAKUB BRABEC	cod.relink:	4156\n" + 
				"POLOM		cod.relink:	3665\n" + 
				"V. KADLEC		cod.relink:	3329\n" + 
				"STADSGAARD		cod.relink:	2926\n" + 
				"MELLBERG		cod.relink:	97\n" + 
				"P. BENGTSSON	cod.relink:	2550\n" + 
				"DELANEY		cod.relink:	3515\n" + 
				"T. KRISTENSEN	cod.relink:	3237\n" + 
				"C. BOLAÑOS		cod.relink:	2164\n" + 
				"GÍSLASON		cod.relink:	721\n" + 
				"C. SANTIN		cod.relink:	3236\n" + 
				"K. CHRISTENSEN	cod.relink:	3235\n" + 
				"R. SIGURÐSSON	cod.relink:	2556\n" + 
				"CLAUDEMIR		cod.relink:	2962\n" + 
				"JØRGENSEN		cod.relink:	4022\n" + 
				"MOS ABDELLAOUE	cod.relink:	4215\n" + 
				"M. JAKOBSEN		cod.relink:	603\n" + 
				"MTILIGA		cod.relink:	823\n" + 
				"VINGAARD		cod.relink:	3266\n" + 
				"A. CHRISTIANSEN	cod.relink:	4367\n" + 
				"NORDSTRAND		cod.relink:	2810\n" + 
				"M. HANSEN		cod.relink:	4823\n" + 
				"JOÃO PEREIRA		cod.relink:	4141\n" + 
				"C. O'BRIEN		cod.relink:	4373\n" + 
				"ISSAH		cod.relink:	4164\n" + 
				"CHRISTENSEN		cod.relink:	4287\n" + 
				"JENSEN		cod.relink:	4331\n" + 
				"JENS LARSEN		cod.relink:	3516\n" + 
				"BECH		cod.relink:	4366\n" + 
				"SPAHIC		cod.relink:	2288\n" + 
				"G. DONATI		cod.relink:	4863\n" + 
				"REINARTZ		cod.relink:	4019\n" + 
				"SAM		cod.relink:	4021\n" + 
				"SON HEUNG MIN	cod.relink:	3966\n" + 
				"CASTRO		cod.relink:	2003\n" + 
				"KIEßLING		cod.relink:	871\n" + 
				"A. PALOP		cod.relink:	201\n" + 
				"YELLDELL		cod.relink:	573\n" + 
				"HILBERT		cod.relink:	2606\n" + 
				"STAFYLIDIS		cod.relink:	4001\n" + 
				"ROLFES		cod.relink:	488\n" + 
				"CAN		cod.relink:	4307\n" + 
				"ROBBEN		cod.relink:	434\n" + 
				"MANDŽUKIC		cod.relink:	2811\n" + 
				"STARKE		cod.relink:	382\n" + 
				"RAFINHA		cod.relink:	2254\n" + 
				"CONTENTO		cod.relink:	3790\n" + 
				"THIAGO		cod.relink:	3752\n" + 
				"WEISER		cod.relink:	4311\n" + 
				"HILDEBRAND		cod.relink:	640\n" + 
				"UCHIDA		cod.relink:	1040\n" + 
				"JONES		cod.relink:	670\n" + 
				"CLEMENS		cod.relink:	4641\n" + 
				"HUNTELAAR		cod.relink:	864\n" + 
				"SANTANA		cod.relink:	4875\n" + 
				"MEYER		cod.relink:	4372\n" + 
				"OBASI		cod.relink:	3754\n" + 
				"AYHAN		cod.relink:	4640\n" + 
				"HOOGLAND		cod.relink:	4802\n" + 
				"A. PAPADOPOULOS	cod.relink:	3216\n" + 
				"L. SALINO		cod.relink:	3834\n" + 
				"FEJSA		cod.relink:	2873\n" + 
				"DAVID FUSTER		cod.relink:	970\n" + 
				"DOMINGUEZ		cod.relink:	410\n" + 
				"CARROLL		cod.relink:	9\n" + 
				"MANOLAS		cod.relink:	3508\n" + 
				"MIGUEL TORRES	cod.relink:	2525\n" + 
				"PAULO MACHADO	cod.relink:	1986\n" + 
				"WEISS		cod.relink:	3537\n" + 
				"IBAGAZA		cod.relink:	588\n" + 
				"FETFATZIDIS		cod.relink:	3670\n" + 
				"J. CAMPBELL		cod.relink:	4072\n" + 
				"SAVIOLA		cod.relink:	240\n" + 
				"ROBERTO		cod.relink:	2323\n" + 
				"P. CONTRERAS	cod.relink:	145\n" + 
				"JACOBO SANZ		cod.relink:	764\n" + 
				"MIGUEL VÍTOR		cod.relink:	2821\n" + 
				"I. LOPEZ		cod.relink:	4109\n" + 
				"KONSTANTINIDIS	cod.relink:	4216\n" + 
				"LINO		cod.relink:	2804\n" + 
				"P. GARCÍA		cod.relink:	155\n" + 
				"SEKOU OLISEH	cod.relink:	4025\n" + 
				"NECID		cod.relink:	2746\n" + 
				"GIAKOUMIS		cod.relink:	3959\n" + 
				"KACE		cod.relink:	4000\n" + 
				"GEORGIADIS		cod.relink:	4773\n" + 
				"STOCH		cod.relink:	3239\n" + 
				"VUKIC		cod.relink:	511\n" + 
				"GLYKOS		cod.relink:	3330\n" + 
				"LIAM LAWRENCE	cod.relink:	2116\n" + 
				"JUAN PABLO		cod.relink:	836\n" + 
				"CARLOS GARCIA	cod.relink:	754\n" + 
				"ZIV		cod.relink:	4818\n" + 
				"ZAHAVI		cod.relink:	4042\n" + 
				"ITZHAKI		cod.relink:	4829\n" + 
				"PRICA		cod.relink:	508\n" + 
				"MANUEL ORTIZ		cod.relink:	2005\n" + 
				"MITROVIC		cod.relink:	4756\n" + 
				"BEN HAIM		cod.relink:	4877\n" + 
				"JODLOWIEC		cod.relink:	4878\n" + 
				"RZEZNICZAK		cod.relink:	4862\n" + 
				"KUCHARCZYK		cod.relink:	4879\n" + 
				"RADOVIC		cod.relink:	718\n" + 
				"SAGANOWSKI		cod.relink:	4848\n" + 
				"HELIO PINTO		cod.relink:	4783\n" + 
				"ASTIZ		cod.relink:	4836\n" + 
				"ARTUR		cod.relink:	732\n" + 
				"LUISÃO		cod.relink:	524\n" + 
				"BRUNO CORTEZ	cod.relink:	4244\n" + 
				"MATIC		cod.relink:	3527\n" + 
				"RUBEN AMORIM	cod.relink:	3145\n" + 
				"ENZO PÉREZ		cod.relink:	3762\n" + 
				"GAITÁN		cod.relink:	2970\n" + 
				"FILIP DJURICIC	cod.relink:	3680\n" + 
				"LIMA		cod.relink:	3844\n" + 
				"JARDEL		cod.relink:	4057\n" + 
				"L. LÓPEZ		cod.relink:	4217\n" + 
				"SÍLVIO		cod.relink:	3843\n" + 
				"MELGAREJO		cod.relink:	4148\n" + 
				"SALVIO		cod.relink:	3737\n" + 
				"SULEJMANI		cod.relink:	2503\n" + 
				"O. JOHN		cod.relink:	3990\n" + 
				"ÓSCAR CARDOZO	cod.relink:	2819\n" + 
				"RODRIGO		cod.relink:	3879\n" + 
				"STEFAN MITROVIC	cod.relink:	4630\n" + 
				"FUNES MORI		cod.relink:	3683\n" + 
				"VINÍCIUS		cod.relink:	4048\n" + 
				"NUNO A. COELHO	cod.relink:	3561\n" + 
				"BAIANO		cod.relink:	4052\n" + 
				"MAURO		cod.relink:	4142\n" + 
				"LUÍZ CARLOS		cod.relink:	4146\n" + 
				"ALAN		cod.relink:	2156\n" + 
				"É. PARDO		cod.relink:	3794\n" + 
				"EDINHO		cod.relink:	3085\n" + 
				"CRISTIANO		cod.relink:	3996\n" + 
				"ELDERSON		cod.relink:	2942\n" + 
				"LUÍS SILVA		cod.relink:	4728\n" + 
				"RAFA SILVA		cod.relink:	4729\n" + 
				"HÉLDER BARBOSA	cod.relink:	2350\n" + 
				"ÉDER		cod.relink:	4047\n" + 
				"YAZALDE		cod.relink:	3557\n" + 
				"HANIN		cod.relink:	4302\n" + 
				"JOÃO PEDRO		cod.relink:	4051\n" + 
				"ANUNCIAÇÃO		cod.relink:	4053\n" + 
				"GREGORY ARNOLIN	cod.relink:	3542\n" + 
				"RODRIGO ANTÔNIO	cod.relink:	4303\n" + 
				"LEÃO		cod.relink:	3091\n" + 
				"M. JOSÉ		cod.relink:	3093\n" + 
				"CAETANO		cod.relink:	4054\n" + 
				"ROBERTO DIAS	cod.relink:	4738\n" + 
				"TONY		cod.relink:	3092\n" + 
				"FERNANDO		cod.relink:	4642\n" + 
				"PEDRO SOUSA		cod.relink:	4752\n" + 
				"RICARDO		cod.relink:	4198\n" + 
				"HELTON		cod.relink:	239\n" + 
				"OTAMENDI		cod.relink:	3631\n" + 
				"MANGALA		cod.relink:	3259\n" + 
				"DANILO		cod.relink:	4040\n" + 
				"ALEX SANDRO		cod.relink:	4039\n" + 
				"FERNANDO		cod.relink:	2805\n" + 
				"LUCHO		cod.relink:	521\n" + 
				"JOSUÉ		cod.relink:	3860\n" + 
				"FABIANO		cod.relink:	4149\n" + 
				"MAICON		cod.relink:	3563\n" + 
				"ABDOULAYE		cod.relink:	4140\n" + 
				"FUCILE		cod.relink:	2538\n" + 
				"MARAT IZMAYLOV	cod.relink:	372\n" + 
				"ITURBE		cod.relink:	3817\n" + 
				"J. QUINTERO		cod.relink:	4227\n" + 
				"RICARDO		cod.relink:	4306\n" + 
				"GHILAS		cod.relink:	4263\n" + 
				"KADÚ		cod.relink:	4137\n" + 
				"SINAN BOLAT		cod.relink:	3258\n" + 
				"D. REYES		cod.relink:	4028\n" + 
				"CARLOS EDUARDO	cod.relink:	4262\n" + 
				"KELVIN		cod.relink:	4136\n" + 
				"MÁRIO FERNANDES	cod.relink:	4033\n" + 
				"SCHENNIKOV		cod.relink:	3339\n" + 
				"HONDA		cod.relink:	1026\n" + 
				"A. MUSA		cod.relink:	3956\n" + 
				"RAHIMIC		cod.relink:	2541\n" + 
				"TOŠIC		cod.relink:	3051\n" + 
				"CAUNA		cod.relink:	3707\n" + 
				"DOUMBIA		cod.relink:	1043\n" + 
				"HUBOCAN		cod.relink:	3053\n" + 
				"ANSALDI		cod.relink:	3333\n" + 
				"ZYRYANOV		cod.relink:	3042\n" + 
				"MALAFEEV		cod.relink:	626\n" + 
				"CRISCITO		cod.relink:	2784\n" + 
				"RODIC		cod.relink:	4375\n" + 
				"LUKOVIC		cod.relink:	2436\n" + 
				"TYMOSHCHUK		cod.relink:	328\n" + 
				"ARSHAVIN		cod.relink:	628\n" + 
				"BUKHAROV		cod.relink:	3334\n" + 
				"ZHEVNOV		cod.relink:	2712\n" + 
				"AMBROSE		cod.relink:	4065\n" + 
				"E. IZAGUIRRE		cod.relink:	3071\n" + 
				"LEDLEY		cod.relink:	2399\n" + 
				"BROWN		cod.relink:	2214\n" + 
				"JAMES FORREST	cod.relink:	3953\n" + 
				"BOERRIGTER		cod.relink:	2247\n" + 
				"ANTHONY STOKES	cod.relink:	2346\n" + 
				"ZALUSKA		cod.relink:	3383\n" + 
				"MOUYOKOLO		cod.relink:	3324\n" + 
				"F. TWARDZIK		cod.relink:	3998\n" + 
				"HERRON		cod.relink:	4377\n" + 
				"WATT		cod.relink:	4315\n" + 
				"FISHER		cod.relink:	4759\n" + 
				"HENDERSON		cod.relink:	4760\n" + 
				"P. TWARDZIK		cod.relink:	3997\n" + 
				"HUTCHINSON		cod.relink:	4297\n" + 
				"MCMANUS		cod.relink:	4897\n" + 
				"LAWSON		cod.relink:	4811\n" + 
				"MCFADDEN		cod.relink:	430\n" + 
				"G. NIELSEN		cod.relink:	2830\n" + 
				"CUMMINS		cod.relink:	4299\n" + 
				"MURRAY		cod.relink:	4298\n" + 
				"KERR		cod.relink:	4347\n" + 
				"ERWIN		cod.relink:	4326\n" + 
				"GÖKHAN ZAN		cod.relink:	722\n" + 
				"RIERA		cod.relink:	592\n" + 
				"FELIPE MELO		cod.relink:	735\n" + 
				"SNEIJDER		cod.relink:	536\n" + 
				"UFUK CEYLAN		cod.relink:	3619\n" + 
				"SABRI SARIOGLU	cod.relink:	613\n" + 
				"HAKAN BALTA		cod.relink:	2969\n" + 
				"CEYHUN G.		cod.relink:	3358\n" + 
				"KÂZIM KÂZIM		cod.relink:	2529\n" + 
				"ENGIN BAYTAR		cod.relink:	3968\n" + 
				"EMRE ÇOLAK		cod.relink:	3730\n" + 
				"AMRABAT		cod.relink:	2850\n" + 
				"YIGIT GÖKOGLAN	cod.relink:	4205\n" + 
				"E. KILIÇ		cod.relink:	3517\n" + 
				"PYATOV		cod.relink:	2394\n" + 
				"KUCHER		cod.relink:	2571\n" + 
				"RAKYTSKYI		cod.relink:	3666\n" + 
				"SRNA		cod.relink:	505\n" + 
				"SHEVCHUK		cod.relink:	551\n" + 
				"ALEX TEIXEIRA		cod.relink:	3686\n" + 
				"DOUGLAS COSTA	cod.relink:	3671\n" + 
				"FRED		cod.relink:	4622\n" + 
				"TAISON		cod.relink:	3155\n" + 
				"LUIZ ADRIANO		cod.relink:	2546\n" + 
				"CHYGRYNSKIY		cod.relink:	2067\n" + 
				"KRYVTSOV		cod.relink:	3901\n" + 
				"STEPANENKO		cod.relink:	3900\n" + 
				"ILSINHO		cod.relink:	2545\n" + 
				"WELLINGTON NEM	cod.relink:	4221\n" + 
				"EDUARDO		cod.relink:	1993\n" + 
				"F. FERREYRA		cod.relink:	3789\n" + 
				"ISMAILY		cod.relink:	4050\n" + 
				"KOBIN		cod.relink:	3521\n" + 
				"MAICON		cod.relink:	4650\n" + 
				"PAULINO		cod.relink:	4581\n" + 
				"GAMRANELLA		cod.relink:	4582\n" + 
				"JERTHSKI		cod.relink:	4583\n" + 
				"COOPER		cod.relink:	4388\n" + 
				"PALMIERI		cod.relink:	4429\n" + 
				"SCHMIDT		cod.relink:	4426\n" + 
				"KIM JONG YEOL	cod.relink:	4545\n" + 
				"DUFFY		cod.relink:	4532\n" + 
				"KOOISTRA		cod.relink:	4436\n" + 
				"OSCAR		cod.relink:	4526\n" + 
				"SHIMIZU		cod.relink:	4542\n" + 
				"PELAEZ		cod.relink:	4445\n" + 
				"ZARATE		cod.relink:	4496\n" + 
				"RIBEIRO		cod.relink:	4501\n" + 
				"FATECHA		cod.relink:	4505\n" + 
				"MATTSSON		cod.relink:	4477\n" + 
				"CERVANTES		cod.relink:	4490\n" + 
				"COCIO		cod.relink:	4503\n" + 
				"SAHAFI		cod.relink:	4511\n" + 
				"AHMET		cod.relink:	4478\n" + 
				"JASINSKI		cod.relink:	4466\n" + 
				"SZALAI		cod.relink:	4463\n" + 
				"BILIC		cod.relink:	4456\n" + 
				"NIKOLOV		cod.relink:	4455\n" + 
				"MCKENZIE		cod.relink:	4473\n" + 
				"SOUSA		cod.relink:	4468\n" + 
				"CAMACHO		cod.relink:	4439\n" + 
				"ALEXEEV		cod.relink:	4470\n" + 
				"THIJS		cod.relink:	4454\n" + 
				"NIKOLIC		cod.relink:	4476\n" + 
				"JACOBS		cod.relink:	4434\n" + 
				"GUEGAN		cod.relink:	4407\n" + 
				"REEVES		cod.relink:	4394\n" + 
				"CHACON		cod.relink:	4488\n" + 
				"SCHWARZ		cod.relink:	4427\n" + 
				"IVYGHASEK		cod.relink:	4553\n" + 
				"STRAMBERG		cod.relink:	4554\n" + 
				"JACOMORAC		cod.relink:	4555\n" + 
				"PACCINI		cod.relink:	4556\n" + 
				"MACOVSHIRE		cod.relink:	4557\n" + 
				"VOLEIMANN		cod.relink:	4558\n" + 
				"COYNBOROUGH	cod.relink:	4559\n" + 
				"VAN BORAAD		cod.relink:	4560\n" + 
				"HOULEIGEU		cod.relink:	4561\n" + 
				"GELLAZCA		cod.relink:	4562\n" + 
				"MINANDINHO		cod.relink:	4563\n" + 
				"LEISSENTHAR		cod.relink:	4564\n" + 
				"IOLECHIA		cod.relink:	4565\n" + 
				"EL MOUGHAOUET	cod.relink:	4566\n" + 
				"HUDALESKI		cod.relink:	4567\n" + 
				"RICHARD HARTY	cod.relink:	4568\n" + 
				"VOLDJEK		cod.relink:	4569\n" + 
				"MYRHEIM		cod.relink:	4570\n" + 
				"EBORCANY		cod.relink:	4571\n" + 
				"ORELAINE		cod.relink:	4572\n" + 
				"CASTOLIS		cod.relink:	4573\n" + 
				"AAKOEBJERG		cod.relink:	4574\n" + 
				"VRATOKOV		cod.relink:	4575\n" + 
				"FEISSERZELN		cod.relink:	4576\n" + 
				"BAJSZOROS		cod.relink:	4577\n" + 
				"HEAUDERBAIX		cod.relink:	4578\n" + 
				"RUSTWYTH		cod.relink:	4579\n" + 
				"ZALSZTYN		cod.relink:	4580\n" + 
				"ELKAMA		cod.relink:	128\n" + 
				"RONA KIRA		cod.relink:	845\n" + 
				"AMEYO HONAM		cod.relink:	4916\n" + 
				"ALAINPAU		cod.relink:	2414\n" + 
				"WIEGO		cod.relink:	208\n" + 
				"NAIMET		cod.relink:	124\n" + 
				"OYLEH		cod.relink:	125\n" + 
				"OTOKA		cod.relink:	126\n" + 
				"MACCORLY		cod.relink:	4913\n" + 
				"DAHOO		cod.relink:	168\n" + 
				"NIRASAKI		cod.relink:	166\n" + 
				"DELYE		cod.relink:	169\n" + 
				"HEJUMOK		cod.relink:	104\n" + 
				"SCIRENI		cod.relink:	258\n" + 
				"PJIROMEL		cod.relink:	246\n" + 
				"NIMOLE		cod.relink:	60\n" + 
				"BALANOV		cod.relink:	115\n" + 
				"SKORIMILOV		cod.relink:	263\n" + 
				"BORAMIKKI		cod.relink:	108\n" + 
				"BOHREN		cod.relink:	225\n" + 
				"SHURAK		cod.relink:	107\n" + 
				"NETRET		cod.relink:	81\n" + 
				"POPOCHSKI		cod.relink:	82\n" + 
				"LANDROAM		cod.relink:	741\n" + 
				"MIL LANDELEF		cod.relink:	259\n" + 
				"CARRIO		cod.relink:	189\n" + 
				"FIPPO NERILLE	cod.relink:	24\n" + 
				"KIUDEN		cod.relink:	354\n" + 
				"ANDY SCOLME		cod.relink:	21\n" + 
				"LE TECELA		cod.relink:	852\n" + 
				"LIKONAREN		cod.relink:	100\n" + 
				"GILLONAI		cod.relink:	334\n" + 
				"TERMOU		cod.relink:	335\n" + 
				"ALGAUEI		cod.relink:	199\n" + 
				"FRUTES		cod.relink:	422\n" + 
				"SIOM		cod.relink:	87\n" + 
				"VARD		cod.relink:	276\n" + 
				"EFERVOLTZ		cod.relink:	237\n" + 
				"MALDOR		cod.relink:	275\n" + 
				"NOGLAU		cod.relink:	90\n" + 
				"RINTELLO		cod.relink:	233\n" + 
				"NEJULER		cod.relink:	279\n" + 
				"MESSENGER		cod.relink:	234\n" + 
				"BEITHNER		cod.relink:	2416\n" + 
				"PURSEL		cod.relink:	377\n" + 
				"LAW KIT		cod.relink:	6\n" + 
				"ZORU		cod.relink:	339\n" + 
				"PETOCCA		cod.relink:	477\n" + 
				"CHINEZAL		cod.relink:	228\n" + 
				"DORDO		cod.relink:	71\n" + 
				"CORTHAN		cod.relink:	342\n" + 
				"PURSARI		cod.relink:	878\n" + 
				"SIMANE		cod.relink:	262\n" + 
				"DI CANPO		cod.relink:	192\n" + 
				"SHIRME		cod.relink:	340\n" + 
				"MAZEKACCI		cod.relink:	4915\n" + 
				"SARTERIC		cod.relink:	254\n" + 
				"MIRAKENIC		cod.relink:	110\n" + 
				"MAHAALI		cod.relink:	206\n" + 
				"REZENGREISE		cod.relink:	273\n" + 
				"HOTTEUBENIK		cod.relink:	187\n" + 
				"BENUKI		cod.relink:	333\n" + 
				"SOLASAL		cod.relink:	94\n" + 
				"FSOW		cod.relink:	93\n" + 
				"DEROS		cod.relink:	103\n" + 
				"BONSAK		cod.relink:	2084\n" + 
				"FILLCO		cod.relink:	32\n" + 
				"CORSO		cod.relink:	29\n" + 
				"PARL SALSA		cod.relink:	251\n" + 
				"LOO CORNA		cod.relink:	30\n" + 
				"BARRILA		cod.relink:	421\n" + 
				"SELCE COLERTON	cod.relink:	31\n" + 
				"PATENCA		cod.relink:	34\n" + 
				"HANUE		cod.relink:	255\n" + 
				"POTELK		cod.relink:	248\n" + 
				"MOWKERAI		cod.relink:	123\n" + 
				"KAYUKIN		cod.relink:	122\n" + 
				"OLOVTO		cod.relink:	121\n" + 
				"DELY RUN		cod.relink:	357\n" + 
				"DURLMINTS		cod.relink:	356\n" + 
				"HEYCORY		cod.relink:	12\n" + 
				"MINILOVIC		cod.relink:	109\n" + 
				"STJANORIC		cod.relink:	2\n" + 
				"DJURIC		cod.relink:	111\n" + 
				"ISLERO		cod.relink:	36\n" + 
				"ECHIENTXA		cod.relink:	370\n" + 
				"GULANGIALA		cod.relink:	38\n" + 
				"ROOTZ ELIQUELO	cod.relink:	197\n" + 
				"CALZAIR		cod.relink:	198\n" + 
				"DE SQUERAN		cod.relink:	369\n" + 
				"BUSSARANA		cod.relink:	2083\n" + 
				"BAROOL		cod.relink:	846\n" + 
				"ZUGNALENI		cod.relink:	2418\n" + 
				"NAVAJO		cod.relink:	325\n" + 
				"MEYELENA		cod.relink:	39\n" + 
				"MORAZENTEZ		cod.relink:	46\n" + 
				"ALVANDO		cod.relink:	2466\n" + 
				"RUMEL BAILA		cod.relink:	45\n" + 
				"BEGRSTARON		cod.relink:	848\n" + 
				"SEIRON		cod.relink:	37\n" + 
				"HEMNARA		cod.relink:	43\n" + 
				"GUELLERMO		cod.relink:	44\n" + 
				"ARANO		cod.relink:	849\n" + 
				"URANAZ		cod.relink:	40\n" + 
				"LARCAN		cod.relink:	98\n" + 
				"BURNOLEN		cod.relink:	744\n" + 
				"DALSHIR		cod.relink:	745\n" + 
				"PAL ARSELON		cod.relink:	96\n" + 
				"SFORGA		cod.relink:	70\n" + 
				"HALAH SUMUL		cod.relink:	118\n" + 
				"BETLAV		cod.relink:	2330\n" + 
				"BKHALIN		cod.relink:	2329\n" + 
				"SHALTENKO		cod.relink:	120\n" + 
				"IWAM RUSSEL		cod.relink:	358\n" + 
				"MILE HEALY		cod.relink:	2328\n" + 
				"CALMEN		cod.relink:	129\n" + 
				"HUNO SAMETZ		cod.relink:	378\n" + 
				"SUNAREZ		cod.relink:	130\n" + 
				"YORB		cod.relink:	181\n" + 
				"PANEUMO		cod.relink:	241\n" + 
				"BUROS		cod.relink:	165\n" + 
				"POTEQUINO		cod.relink:	162\n" + 
				"VIROTA		cod.relink:	170\n" + 
				"DJERAIGHO		cod.relink:	203\n" + 
				"LIDOANHO		cod.relink:	290\n" + 
				"JIONALGIO		cod.relink:	293\n" + 
				"JIL PANISKA		cod.relink:	139\n" + 
				"ENELKON		cod.relink:	138\n" + 
				"ARMEYSON		cod.relink:	143\n" + 
				"SAGATZ		cod.relink:	146\n" + 
				"FIRQUELA		cod.relink:	4086\n" + 
				"INAN COLDONA	cod.relink:	133\n" + 
				"HIGORE		cod.relink:	737\n" + 
				"VERDONAN		cod.relink:	256\n" + 
				"AZPNIRA		cod.relink:	264\n" + 
				"AL AUMERA		cod.relink:	362\n" + 
				"CHIMRAL		cod.relink:	147\n" + 
				"ALNE		cod.relink:	149\n" + 
				"GARAMA		cod.relink:	148\n" + 
				"CARDORO		cod.relink:	150\n" + 
				"FROEQUERTOLI	cod.relink:	379\n" + 
				"RUNAN DONA		cod.relink:	1013\n" + 
				"MORTENO		cod.relink:	154\n" + 
				"ANDREWS		cod.relink:	4385\n" + 
				"BAKER		cod.relink:	4386\n" + 
				"CARTER		cod.relink:	4387\n" + 
				"GIBSON		cod.relink:	4389\n" + 
				"JACKSON		cod.relink:	4390\n" + 
				"MITCHELL		cod.relink:	4391\n" + 
				"MURRAY		cod.relink:	4392\n" + 
				"NEWMAN		cod.relink:	4393\n" + 
				"ROWLAND		cod.relink:	4395\n" + 
				"SHAW		cod.relink:	4396\n" + 
				"SIMPSON		cod.relink:	4397\n" + 
				"WALTON		cod.relink:	4398\n" + 
				"WILKINS		cod.relink:	4399\n" + 
				"WOOD		cod.relink:	4400\n" + 
				"ADAM		cod.relink:	4401\n" + 
				"ANDRE		cod.relink:	4402\n" + 
				"BOUQUET		cod.relink:	4403\n" + 
				"CLEMENT		cod.relink:	4404\n" + 
				"DUPONT		cod.relink:	4405\n" + 
				"FERNANDEZ		cod.relink:	4406\n" + 
				"JEAN		cod.relink:	4408\n" + 
				"LECLERC		cod.relink:	4409\n" + 
				"MARCHAND		cod.relink:	4410\n" + 
				"MARTEL		cod.relink:	4411\n" + 
				"PERRIN		cod.relink:	4412\n" + 
				"RENARD		cod.relink:	4413\n" + 
				"RIOU		cod.relink:	4414\n" + 
				"TRAORE		cod.relink:	4415\n" + 
				"BERGER		cod.relink:	4416\n" + 
				"DIETRICH		cod.relink:	4417\n" + 
				"ECKSTEIN		cod.relink:	4418\n" + 
				"FISCHER		cod.relink:	4419\n" + 
				"HOFFMANN		cod.relink:	4420\n" + 
				"HOLZER		cod.relink:	4421\n" + 
				"KAISER		cod.relink:	4422\n" + 
				"KREMER		cod.relink:	4423\n" + 
				"LINDNER		cod.relink:	4424\n" + 
				"LORENZ		cod.relink:	4425\n" + 
				"WOLF		cod.relink:	4428\n" + 
				"ARTS		cod.relink:	4430\n" + 
				"BOS		cod.relink:	4431\n" + 
				"DOESBURG		cod.relink:	4432\n" + 
				"HOEKSTRA		cod.relink:	4433\n" + 
				"KOEMAN		cod.relink:	4435\n" + 
				"POSTMA		cod.relink:	4437\n" + 
				"VAN DER MEER	cod.relink:	4438\n" + 
				"CHAPI		cod.relink:	4440\n" + 
				"HERRERO		cod.relink:	4441\n" + 
				"MENENDEZ		cod.relink:	4442\n" + 
				"MERINO		cod.relink:	4443\n" + 
				"NAVARRO		cod.relink:	4444\n" + 
				"PRIETO		cod.relink:	4446\n" + 
				"RUBIO		cod.relink:	4447\n" + 
				"SANZ		cod.relink:	4448\n" + 
				"SERRANO		cod.relink:	4449\n" + 
				"SOLER		cod.relink:	4450\n" + 
				"WEBER		cod.relink:	4451\n" + 
				"CUYPERS		cod.relink:	4452\n" + 
				"MERTENS		cod.relink:	4453\n" + 
				"BOSNJAK		cod.relink:	4457\n" + 
				"SIEGL		cod.relink:	4458\n" + 
				"JACOBSEN		cod.relink:	4459\n" + 
				"AALTONEN		cod.relink:	4460\n" + 
				"DELIOS		cod.relink:	4461\n" + 
				"IOANNIDIS		cod.relink:	4462\n" + 
				"O'SULLIVAN		cod.relink:	4464\n" + 
				"CLARKE		cod.relink:	4465\n" + 
				"ANDRE		cod.relink:	4467\n" + 
				"BUGA		cod.relink:	4469\n" + 
				"ZAKHAROV		cod.relink:	4471\n" + 
				"GRAHAM		cod.relink:	4472\n" + 
				"FRANOVIC		cod.relink:	4474\n" + 
				"JOVANCEVIC		cod.relink:	4475\n" + 
				"CEM		cod.relink:	4479\n" + 
				"ENGIN		cod.relink:	4480\n" + 
				"STOYANOV		cod.relink:	4481\n" + 
				"GRIFFITHS		cod.relink:	4482\n" + 
				"KOMOL		cod.relink:	4483\n" + 
				"ABDEL SALAM		cod.relink:	4484\n" + 
				"SHITTU		cod.relink:	4485\n" + 
				"KHUMALO		cod.relink:	4486\n" + 
				"MOKRANI		cod.relink:	4487\n" + 
				"SAMUELS		cod.relink:	4489\n" + 
				"BUCHANAN		cod.relink:	4491\n" + 
				"ACOSTA		cod.relink:	4492\n" + 
				"BUSTOS		cod.relink:	4493\n" + 
				"JUAREZ		cod.relink:	4494\n" + 
				"RIVERO		cod.relink:	4495\n" + 
				"BORGES		cod.relink:	4497\n" + 
				"GUIMARAES		cod.relink:	4498\n" + 
				"MACHADO		cod.relink:	4499\n" + 
				"NASCIMENTO		cod.relink:	4500\n" + 
				"SOARES		cod.relink:	4502\n" + 
				"ROLONG		cod.relink:	4504\n" + 
				"PRANDINI		cod.relink:	4506\n" + 
				"WANG MINGWEI	cod.relink:	4507\n" + 
				"NOUSHEVAR		cod.relink:	4508\n" + 
				"YAMADA		cod.relink:	4509\n" + 
				"KIM CYUN HI		cod.relink:	4510\n" + 
				"BOFFA		cod.relink:	4512\n" + 
				"BRADLEY		cod.relink:	4513\n" + 
				"OLIVER		cod.relink:	4514\n" + 
				"SPENCER		cod.relink:	4515\n" + 
				"BENON		cod.relink:	4516\n" + 
				"MOULIN		cod.relink:	4517\n" + 
				"WIART		cod.relink:	4518\n" + 
				"GUNTHER		cod.relink:	4519\n" + 
				"HUBER		cod.relink:	4520\n" + 
				"KRUGER		cod.relink:	4521\n" + 
				"GAMBINO		cod.relink:	4522\n" + 
				"NIJKAMP		cod.relink:	4523\n" + 
				"VAN DIJK		cod.relink:	4524\n" + 
				"ESPINOSA		cod.relink:	4525\n" + 
				"RAMON		cod.relink:	4527\n" + 
				"FEURER		cod.relink:	4528\n" + 
				"MATIC		cod.relink:	4529\n" + 
				"GOTTWALD		cod.relink:	4530\n" + 
				"FREDERIKSEN		cod.relink:	4531\n" + 
				"HUGO		cod.relink:	4533\n" + 
				"YEGOROV		cod.relink:	4534\n" + 
				"FREDRIKSSON		cod.relink:	4535\n" + 
				"SHUBIN		cod.relink:	4536\n" + 
				"ORELLANO		cod.relink:	4537\n" + 
				"SOLIMAR		cod.relink:	4538\n" + 
				"KOBAYASHI		cod.relink:	4539\n" + 
				"MATSUMOTO		cod.relink:	4540\n" + 
				"SASAKI		cod.relink:	4541\n" + 
				"TAKAHASHI		cod.relink:	4543\n" + 
				"KIM U DON		cod.relink:	4544\n" + 
				"KIM MYON U		cod.relink:	4546\n" + 
				"I GYON FUN		cod.relink:	4547\n" + 
				"I CHOL YON		cod.relink:	4548\n" + 
				"PARK JYUN HI		cod.relink:	4549\n" + 
				"CHE HYON HON	cod.relink:	4550\n" + 
				"HONG YON NAM	cod.relink:	4551\n" + 
				"CHO JIN WHA		cod.relink:	4552\n" + 
				"DULIC		cod.relink:	171\n" + 
				"CELNILI		cod.relink:	172\n" + 
				"BAROTA		cod.relink:	173\n" + 
				"KELSEN		cod.relink:	180\n" + 
				"VORNANDER		cod.relink:	174\n" + 
				"EDINGSON		cod.relink:	175\n" + 
				"NACHDECAL		cod.relink:	176\n" + 
				"HARTY		cod.relink:	177\n" + 
				"OSTWAUT		cod.relink:	178\n" + 
				"NJORGO		cod.relink:	179\n" + 
				"			\n" + 
				"", 30, 43);
		JScrollPane sp = new JScrollPane(stat);
		PlayerDialog retForm;

		//	lbl.setBounds(0, 0, 400, 30);
			//pnl.add(lbl);

			sp.setBounds(0, 30, 500, 530);
			pnl.add(sp);
			

			// JPanel bounds
			pnl.setBounds(0, 0, 500, 530);

			// Adding to JFrame
			//pnl.add(btnclose);
			add(pnl);

			// JFrame properties
			setSize(500, 530);
			setResizable(false);
			setBackground(Color.BLACK);
			setTitle("Mapa de CallNames Pes 2014 PS2");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setVisible(true);
		}

	}
	