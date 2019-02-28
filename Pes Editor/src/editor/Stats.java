/*
 * Copyright 2008-9 Compulsion
 * <pes_compulsion@yahoo.co.uk>
 * <http://www.purplehaze.eclipse.co.uk/>
 * <http://uk.geocities.com/pes_compulsion/>
 *
 * This file is part of PES Editor.
 *
 * PES Editor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PES Editor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PES Editor.  If not, see <http://www.gnu.org/licenses/>.
 */

package editor;

public class Stats {

	final static Stat hair = new Stat(0, 45, 0, 4095, "Hair");

	final static Stat faceUnknown = new Stat(0, 52, 0, 0xFFFF, "Face unknown");

	final static Stat faceType = new Stat(10, 55, 0, 0x3, "Face Type");
	
	final static Stat FACE_TYPE = new Stat(0, 53, 4, 4095, "Face Type");

	final static Stat skin = new Stat(0, 41, 6, 0x3, "Skin");
	
	final static Stat SKIN = new Stat(5, 68, 0, 0x7, "Skin");
	
	final static Stat SKIN2 = new Stat(11, 68, 0, 0x7, "Skin");
	
	final static Stat SH2 = new Stat(0, 52, 6, 1, "Is Special Hairstyles2");

	//final static Stat face = new Stat(0, 53, 5, 0x1FF, "Face");

	final static Stat face = new Stat(0, 53, 0, 0x1FF, "Face");
	
	final static Stat face2 = new Stat(0, 54, 0, 0x1FF, "face2");

	final static Stat nameEdited = new Stat(0, 3, 0, 0x1, "Name Edited");

	final static Stat callEdited = new Stat(0, 3, 2, 0x1, "Call Edited");

	final static Stat shirtEdited = new Stat(0, 3, 1, 0x1, "Shirt Edited");

	final static Stat abilityEdited = new Stat(0, 40, 4, 0x1, "Ability Edited");

	final static Stat callName = new Stat(0, 1, 0, 0xFFFF, "Call Name");
	
	final static Stat callNameT = new Stat(13, 1, 0, 0xFFFF, "Call Name");
	
	final static Stat fama = new Stat(0, 38, 0, 0xffff, "Fama");

	final static Stat height = new Stat(1, 41, 0, 0x3F, "Height");

	final static Stat foot = new Stat(4, 5, 0, 0x01, "Foot");

	final static Stat favSide = new Stat(0, 33, 14, 0x03, "Fav side");

	final static Stat wfa = new Stat(5, 33, 11, 0x07, "W Foot Acc");

	final static Stat wff = new Stat(5, 33, 3, 0x07, "W Foot Freq");

	final static Stat injury = new Stat(6, 33, 6, 0x03, "Injury T");

	final static Stat dribSty = new Stat(5, 6, 0, 0x03, "Dribbling Style");

	final static Stat freekick = new Stat(5, 5, 1, 0x0f, "Free Kick");

	final static Stat pkStyle = new Stat(5, 5, 5, 0x07, "Penalty Kick");

	final static Stat dkSty = new Stat(5, 6, 2, 0x03, "DK Style");

	final static Stat age = new Stat(2, 65, 9, 0x1F, "Age");
	
	final static Stat cel1 = new Stat(0, 36, 0, 255, "cel1");
	
	final static Stat cel2 = new Stat(0, 37, 0, 255, "cel2");
	
	final static Stat CEL1 = new Stat(12, 36, 0, 255, "cel1");
	
	final static Stat CEL2 = new Stat(12, 37, 0, 255, "cel2");

	final static Stat weight = new Stat(0, 41, 8, 0x7F, "Weight");

	final static Stat nationality = new Stat(3, 65, 0, 0xFF, "Nationality");

	final static Stat consistency = new Stat(5, 33, 0, 0x07, "Consistency");

	final static Stat condition = new Stat(5, 33, 8, 0x07, "Condition");

	final static Stat regPos = new Stat(0, 6, 4, 0xF, "Registered Position");

	final static Stat gk = new Stat(0, 7, 7, 1, "GK");

	final static Stat cwp = new Stat(0, 7, 15, 1, "SW");

	final static Stat cbt = new Stat(0, 9, 7, 1, "CB");

	final static Stat sb = new Stat(0, 9, 15, 1, "SB");

	final static Stat dm = new Stat(0, 11, 7, 1, "DMF");

	final static Stat wb = new Stat(0, 11, 15, 1, "WB");

	final static Stat cm = new Stat(0, 13, 7, 1, "CMF");

	final static Stat sm = new Stat(0, 13, 15, 1, "SMF");

	final static Stat am = new Stat(0, 15, 7, 1, "AMF");

	final static Stat wg = new Stat(0, 15, 15, 1, "WF");

	final static Stat ss = new Stat(0, 17, 7, 1, "SS");

	final static Stat cf = new Stat(0, 17, 15, 1, "CF");

	final static Stat[] roles = { gk, new Stat(0, 7, 15, 1, "?"), cwp, cbt, sb,
			dm, wb, cm, sm, am, wg, ss, cf };

	final static Stat attack = new Stat(0, 7, 0, 0x7F, "Attack");

	final static Stat defence = new Stat(0, 8, 0, 0x7F, "Defense");

	final static Stat balance = new Stat(0, 9, 0, 0x7F, "Balance");

	final static Stat stamina = new Stat(0, 10, 0, 0x7F, "Stamina");

	final static Stat speed = new Stat(0, 11, 0, 0x7F, "Speed");

	final static Stat accel = new Stat(0, 12, 0, 0x7F, "Accel");

	final static Stat response = new Stat(0, 13, 0, 0x7F, "Response");

	final static Stat agility = new Stat(0, 14, 0, 0x7F, "Agility");

	final static Stat dribAcc = new Stat(0, 15, 0, 0x7F, "Drib Acc");

	final static Stat dribSpe = new Stat(0, 16, 0, 0x7F, "Drib Spe");

	final static Stat sPassAcc = new Stat(0, 17, 0, 0x7F, "S Pass Acc");

	final static Stat sPassSpe = new Stat(0, 18, 0, 0x7F, "S Pass Spe");

	final static Stat lPassAcc = new Stat(0, 19, 0, 0x7F, "L Pass Acc");

	final static Stat lPassSpe = new Stat(0, 20, 0, 0x7F, "L Pass Spe");

	final static Stat shotAcc = new Stat(0, 21, 0, 0x7F, "Shot Acc");

	final static Stat shotPow = new Stat(0, 22, 0, 0x7F, "Shot Power");

	final static Stat shotTec = new Stat(0, 23, 0, 0x7F, "Shot Tech");

	final static Stat fk = new Stat(0, 24, 0, 0x7F, "FK Acc");

	final static Stat curling = new Stat(0, 25, 0, 0x7F, "Swerve");

	final static Stat heading = new Stat(0, 26, 0, 0x7F, "Heading");

	final static Stat jump = new Stat(0, 27, 0, 0x7F, "Jump");

	final static Stat tech = new Stat(0, 29, 0, 0x7F, "Tech");

	final static Stat aggress = new Stat(0, 30, 0, 0x7F, "Aggression");

	final static Stat mental = new Stat(0, 31, 0, 0x7F, "Mentality");

	final static Stat gkAbil = new Stat(0, 32, 0, 0x7F, "GK");

	final static Stat team = new Stat(0, 28, 0, 0x7F, "Team Work");

	final static Stat[] ability99 = { attack, defence, balance, stamina, speed,
			accel, response, agility, dribAcc, dribSpe, sPassAcc, sPassSpe,
			lPassAcc, lPassSpe, shotAcc, shotPow, shotTec, fk, curling,
			heading, jump, tech, aggress, mental, gkAbil, team };

	final static Stat[] abilitySpecial = { new Stat(0, 21, 7, 1, "Dribbling"),
			new Stat(0, 21, 15, 1, "Tactical Drib"),
			new Stat(0, 23, 7, 1, "Positioning"),
			new Stat(0, 23, 15, 1, "Reaction"),
			new Stat(0, 25, 7, 1, "Playmaking"),
			new Stat(0, 25, 15, 1, "Passing"),
			new Stat(0, 27, 7, 1, "Scoring"),
			new Stat(0, 27, 15, 1, "1-1 Scoring"),
			new Stat(0, 29, 7, 1, "Post"),
			new Stat(0, 29, 15, 1, "Line Position"),
			new Stat(0, 31, 7, 1, "Mid shooting"),
			new Stat(0, 31, 15, 1, "Side"), new Stat(0, 19, 15, 1, "Centre"),
			new Stat(0, 19, 7, 1, "Penalties"),
			new Stat(0, 35, 0, 1, "1-T Pass"),
			new Stat(0, 35, 1, 1, "Outside"), new Stat(0, 35, 2, 1, "Marking"),
			new Stat(0, 35, 3, 1, "Sliding"), new Stat(0, 35, 4, 1, "Cover"),
			new Stat(0, 35, 5, 1, "D-L Control"),
			new Stat(0, 35, 6, 1, "Penalty GK"),
			new Stat(0, 35, 7, 1, "1-on-1 GK"),
			new Stat(0, 37, 7, 1, "Long Throw") };

	//final static Stat heightOld = new Stat(8, 41, 0, 0x3F, "Height");

	final static Stat abilityEdited5 = new Stat(0, 39, 7, 0x1, "Ability Edited");
	final static Stat favSide5 = new Stat(0, 20, 6, 0x03, "Fav side");
	final static Stat wfa5 = new Stat(5, 34, 5, 0x07, "W Foot Acc");
	final static Stat wff5 = new Stat(5, 35, 0, 0x07, "W Foot Freq");
	final static Stat injury5 = new Stat(6, 35, 3, 0x03, "Injury T");
	final static Stat age5 = new Stat(2, 62, 5, 0x1F, "Age");
	final static Stat weight5 = new Stat(0, 41, 6, 0x7F, "Weight");
	final static Stat nationality5 = new Stat(3, 63, 2, 0xFF, "Nationality");
	final static Stat consistency5 = new Stat(5, 33, 7, 0x07, "Consistency");
	final static Stat condition5 = new Stat(5, 34, 2, 0x07, "Condition");
	final static Stat gk5 = new Stat(0, 8, 6, 1, "GK");
	final static Stat cwp5 = new Stat(0, 8, 7, 1, "SW");
	final static Stat cbt5 = new Stat(0, 12, 4, 1, "CB");
	final static Stat sb5 = new Stat(0, 12, 5, 1, "SB");
	final static Stat dm5 = new Stat(0, 12, 6, 1, "DMF");
	final static Stat wb5 = new Stat(0, 12, 7, 1, "WB");
	final static Stat cm5 = new Stat(0, 16, 4, 1, "CMF");
	final static Stat sm5 = new Stat(0, 16, 5, 1, "SMF");
	final static Stat am5 = new Stat(0, 16, 6, 1, "AMF");
	final static Stat wg5 = new Stat(0, 16, 7, 1, "WF");
	final static Stat ss5 = new Stat(0, 20, 4, 1, "SS");
	final static Stat cf5 = new Stat(0, 20, 5, 1, "CF");
	final static Stat[] roles5 = { gk5, new Stat(0, 7, 15, 1, "?"), cwp5, cbt5, sb5, dm5, wb5, cm5, sm5, am5, wg5, ss5, cf5 };
	final static Stat defence5 = new Stat(0, 7, 7, 0x7F, "Defense");
	final static Stat stamina5 = new Stat(0, 9, 7, 0x7F, "Stamina");
	final static Stat speed5 = new Stat(0, 10, 6, 0x7F, "Speed");
	final static Stat accel5 = new Stat(0, 11, 5, 0x7F, "Accel");
	final static Stat agility5 = new Stat(0, 13, 7, 0x7F, "Agility");
	final static Stat dribAcc5 = new Stat(0, 14, 6, 0x7F, "Drib Acc");
	final static Stat dribSpe5 = new Stat(0, 15, 5, 0x7F, "Drib Spe");
	final static Stat sPassSpe5 = new Stat(0, 17, 7, 0x7F, "S Pass Spe");
	final static Stat lPassAcc5 = new Stat(0, 18, 6, 0x7F, "L Pass Acc");
	final static Stat lPassSpe5 = new Stat(0, 19, 5, 0x7F, "L Pass Spe");
	final static Stat shotPow5 = new Stat(0, 21, 7, 0x7F, "Shot Power");
	final static Stat shotTec5 = new Stat(0, 22, 6, 0x7F, "Shot Tech");
	final static Stat fk5 = new Stat(0, 23, 5, 0x7F, "FK Acc");
	final static Stat heading5 = new Stat(0, 25, 7, 0x7F, "Heading");
	final static Stat jump5 = new Stat(0, 26, 6, 0x7F, "Jump");
	final static Stat aggress5 = new Stat(0, 29, 7, 0x7F, "Aggression");
	final static Stat mental5 = new Stat(0, 30, 6, 0x7F, "Mentality");
	final static Stat gkAbil5 = new Stat(0, 31, 5, 0x7F, "GK");
	final static Stat team5 = new Stat(0, 3, 0, 0x7F, "Team Work");
	final static Stat[] ability995 = { attack, defence5, balance, stamina5, speed5,
		accel5, response, agility5, dribAcc5, dribSpe5, sPassAcc, sPassSpe5,
		lPassAcc5, lPassSpe5, shotAcc, shotPow5, shotTec5, fk5, curling,
		heading5, jump5, tech, aggress5, mental5, gkAbil5, team5 };
	final static Stat[] abilitySpecial5 = { new Stat(0, 24, 4, 1, "Dribbling"),
		new Stat(0, 24, 5, 1, "Tactical Drib"),
		new Stat(0, 24, 6, 1, "Positioning"),
		new Stat(0, 24, 7, 1, "Reaction"),
		new Stat(0, 28, 4, 1, "Playmaking"),
		new Stat(0, 28, 5, 1, "Passing"),
		new Stat(0, 28, 6, 1, "Scoring"),
		new Stat(0, 28, 7, 1, "1-1 Scoring"),
		new Stat(0, 32, 4, 1, "Post"),
		new Stat(0, 32, 5, 1, "Line Position"),
		new Stat(0, 32, 6, 1, "Mid shooting"),
		new Stat(0, 32, 7, 1, "Side"),
		new Stat(0, 35, 5, 1, "Centre"),
		new Stat(0, 35, 6, 1, "Penalties"),
		new Stat(0, 35, 7, 1, "1-T Pass"),
		new Stat(0, 36, 0, 1, "Outside"),
		new Stat(0, 36, 1, 1, "Marking"),
		new Stat(0, 36, 2, 1, "Sliding"),
		new Stat(0, 36, 3, 1, "Cover"),
		new Stat(0, 36, 4, 1, "D-L Control"),
		new Stat(0, 36, 5, 1, "Penalty GK"),
		new Stat(0, 36, 6, 1, "1-on-1 GK"),
		new Stat(0, 36, 7, 1, "Long Throw") };

	//final static Stat growth = new Stat(0, 38, 7, 0x05, "Growth");

	// statX = new Stat(of, 0, 27, 5, 0x7F, "StatX");
	// gkKick = new Stat(of, 0, 33, 7, 1, "GK Kick");
	// bff = new Stat(of, 0, 29, 7, 1, "B F Feint");
	// growth = new Stat(of, 5, 6, 2, 0x03, "");

	//final static String[] nationpsd = { "Austria", "Belgium", "Bulgaria", "Croatia", "Czech Republic", "Denmark", "England", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Israel", "Italy", "Netherlands", "Northern Ireland", "Norway", "Poland", "Portugal", "Romania", "Russia", "Scotland", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "Wales", "Algeria", "Cameroon", "Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "South Africa", "Zambia", "Costa Rica", "Honduras", "Mexico", "USA", "Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay", "Peru", "Uruguay", "Australia", "China", "Japan", "North Korea", "Saudi Arabia", "South Korea", "United Arab Emirates", "New Zealand", "Kosovo", "Angola", "Benin", "Burundi", "Cape Verde", "Central African Republic", "Comoros", "Congo", "DR Congo", "Equatorial Guinea", "Gabon", "Guinea-Bissau", "Kenya", "Liberia", "Libya", "Madagascar", "Mauritania", "Mozambique", "Niger", "Gambia", "Rwanda", "Sierra Leone", "Togo", "Zimbabwe", "Antigua & Barbuda", "Aruba", "Barbados", "Canada", "CuraÃ§ao", "Dominican Republic", "Grenada", "Guadeloupe", "Guatemala", "Haiti", "Martinique", "Trinidad e Tobago", "Bahrain", "Philippines", "Syria", "New Caledonia", "Albania", "Andorra", "Armenia", "Azerbaijan", "Belarus", "Bosnia-Herzegovina", "Cyprus", "Estonia", "Faroe Islands", "Georgia", "Iceland", "Kazakhstan", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta", "Moldova", "Montenegro", "San Marino", "Burkina Faso", "Guinea", "Mali", "Morocco", "Senegal", "Tunisia", "Jamaica", "Panama", "Bolivia", "Venezuela", "Iran", "Iraq", "Jordan", "Kuwait", "Lebanon", "Oman", "Qatar", "Thailand", "Uzbekistan", "Free Nationality" }; //text

	
	final static String[] nationPSD = { "Austria", "Belgium", "Bulgaria", "Croatia", "Czech Republic", "Denmark", "England", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Netherlands", "Northern Ireland", "Norway", "Poland", "Portugal", "Romania", "Russia", "Scotland", "Serbia and Montenegro", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "Wales", "Angola", "Cameroon", "Cote d'Ivoire", "Ghana", "Nigeria", "South Africa", "Togo", "Tunisia", "Costa Rica", "Mexico", "Trinidad and Tobago", "USA", "Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay", "Peru", "Uruguay", "Iran", "Japan", "Saudi Arabia", "South Korea", "Australia", "Bosnia and Herzegovina", "Estonia", "Israel", "Honduras", "Jamaica", "Panama", "Bolivia", "Venezuela", "China", "Uzbekistan", "Albania", "Cyprus", "Iceland", "Macedonia", "Armenia", "Belarus", "Georgia", "Liechtenstein", "Lithuania", "Algeria", "Benin", "Burkina Faso", "Cape Verde", "Congo", "DR Congo", "Egypt", "Equatorial Guinea", "Gabon", "Gambia", "Guinea", "Guinea-Bissau", "Kenya", "Liberia", "Libya", "Mali", "Morocco", "Mozambique", "Senegal", "Sierra Leone", "Zambia", "Zimbabwe", "Canada", "Grenada", "Guadeloupe", "Martinique", "Netherlands Antilles", "Oman", "New Zealand", "Free Nationality" };
	
	final static String[] nation = { "Austria", "Belgium", "Bulgaria",
		    "Croatia", "Czech Republic", "Denmark", "England", "Finland",
			"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
			"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
			"Portugal", "Romania", "Russia", "Scotland",
			"Serbia", "Slovakia", "Slovenia", "Spain", "Sweden",
			"Switzerland", "Turkey", "Ukraine", "Wales", "Algeria", "Cameroon",
			"Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "South Africa",
			"Zambia", "Costa Rica", "Honduras", "Mexico", "USA",
			"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay",
			"Peru", "Uruguay", "Australia", "China", "Japan", "North Korea",
			"Saudi Arabia", "South Korea", "United Arab Emirates", "New Zealand", 

			"Kosovo", "Angola", "Benin", "Burundi", "Cape Verde", "Central African Republic",
			"Comoros", "Congo", "DR Congo", "Equatorial Guinea", "Gabon", "Guinea-Bissau", "Kenya",
			"Liberia", "Libya", "Madagascar", "Mauritania", "Mozambique", "Niger", "Gambia",
			"Rwanda", "Sierra Leone", "Togo", "Zimbabwe", "Antigua & Barbuda", "Aruba", "Barbados",
			"Canada", "CuraÃ§ao", "Dominican Republic", "Grenada", "Guadeloupe", "Guatemala", "Haiti",
			"Martinique", "Trinidad e Tobago", "Bahrain", "Philippines", "Syria", "New Caledonia",
			"Albania", "Andorra", "Armenia", "Azerbaijan", "Belarus", "Bosnia-Herzegovina", "Cyprus",
			"Estonia", "Faroe Islands", "Georgia", "Iceland", "Kazakhstan", "Latvia",
			"Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta", "Moldova",
			"Montenegro", "San Marino", "Burkina Faso", "Guinea", "Mali", "Morocco", "Senegal",
			"Tunisia", "Jamaica", "Panama", "Bolivia", "Venezuela", "Iran", "Iraq", "Jordan",
			"Kuwait", "Lebanon", "Oman", "Qatar", "Thailand", "Uzbekistan", "Edited" }; //text

	final static String[] nation13 = { "Austria", "Belgium", "Bulgaria",
	    "Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
		"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Algeria", "Cameroon",
		"Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "South Africa",
		"Zambia", "Costa Rica", "Honduras", "Mexico", "USA",
		"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay",
		"Peru", "Uruguay", "Australia", "China", "Japan", "North Korea",
		"Saudi Arabia", "South Korea", "United Arab Emirates", "New Zealand", 

		"Kosovo",  "Benin", "Burkina Faso", "Burundi",
		"Cape Verde","Central African Republic" ,"Comoros", "Congo", "DR Congo", "Equatorial Guinea",
		"Gabon", "Gambia", "Guinea-Bissau", "Kenya", "Liberia", "Libya", "Madagascar", "Mauritania",
		"Mozambique", "Niger", "Rwanda", "Sierra Leone", "Sudan", "Togo",
		"Zimbabwe", "Antigua & Barbuda", "Aruba", "Barbados", "CuraÃ§ao",
		"Grenada", "Guadeloupe", "Guatemala", "Haiti", "Jamaica",
		"Martinique", "Netherlands Antilles", "Trinidad e Tobago", "Bahrain",
		"Philippines", "Syria", "New Caledonia", "Albania", 
		"Andorra", "Armenia","Azerbaijan",  "Belarus", "Bosnia-Herzegovina", "Cyprus", "Estonia",
		"Faroe Islands", "Georgia", "Iceland","Kazakhstan",
		"Latvia", "Liechtenstein", "Lithuania", "Luxembourg",
		"Macedonia", "Malta", "Moldova", "Montenegro", "San Marino", 
		"Angola", "Guinea", "Mali", "Morocco", "Senegal", "Tunisia", "Canada",
		"Panama", "Bolivia", "Venezuela", "Iran", "Iraq", "Jordan",
		"Kuwait", "Lebanon", "Oman", "Qatar", "Thailand", "Uzbekistan", "Edited" }; //text

	final static String[] nation12 = { "Austria", "Belgium", "Bulgaria",
	    "Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
		"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Algeria", "Cameroon",
		"Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "South Africa",
		"Zambia", "Costa Rica", "Honduras", "Mexico", "USA",
		"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay",
		"Peru", "Uruguay", "Australia", "China", "Japan", "North Korea",
		"Saudi Arabia", "South Korea", "United Arab Emirates", "New Zealand", 

		"Monaco", "Benin", "Burkina Faso", "Burundi",
		"Cape Verde", "Central African Republic", "Comoros", "Congo", "DR Congo", "Equatorial Guinea",
		"Gabon", "Gambia", "Guinea-Bissau", "Kenya", "Liberia", "Libya", "Madagascar", "Mauritania",
		"Mozambique", "Niger", "Rwanda", "Sierra Leone", "Zambia", "Zimbabwe",
		"Aruba", "Barbados", "Cuba", "El Salvador", "Grenada", "Guadeloupe",
		"Guatemala", "Haiti", "Jamaica", "Martinique", "Netherlands Antilles",
		"Trinidad e Tobago", "Sint Maarten", "Oman", "Philippines", "Fiji",
		"Papua New Guinea", "Albania", "Andorra", "Armenia", "Azerbaijan",
		"Belarus", "Bosnia and Herzegovina", "Cyprus", "Estonia",
		"Faroe Islands", "Georgia", "Iceland", "Kazakhstan", "Latvia",
		"Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta",
		"Moldova", "Montenegro", "San Marino", "Angola", "Guinea", "Mali",
		"Morocco", "Senegal", "Tunisia", "Canada", "Panama", "Bolivia",
		"Venezuela", "Bahrain", "Iran", "Iraq", "Jordan", "Kuwait",
		"Qatar", "Syria", "Thailand", "Uzbekistan", "Edited" }; //text

	final static String[] nation11 = { "Austria", "Belgium", "Bulgaria",
	    "Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
		"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Algeria", "Cameroon",
		"Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "South Africa",
		"Togo", "Canada", "Honduras", "Mexico", "USA",
		"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay",
		"Peru", "Uruguay", "Australia", "China", "Japan", "North Korea",
		"Saudi Arabia", "South Korea", "United Arab Emirates", "New Zealand", 

		"Monaco", "Benin", "Burkina Faso", "Burundi",
		"Cape Verde", "Central African Republic", "Chad", "Congo", "DR Congo", "Equatorial Guinea",
		"Gabon", "Gambia", "Guinea-Bissau", "Kenya", "Liberia", "Libya", "Madagascar", "Mozambique",
		"Niger", "Rwanda", "Sierra Leone", "Zambia", "Zimbabwe",
		"Aruba", "Barbados", "Cuba", "El Salvador", "Grenada", "Guadeloupe",
		"Guatemala", "Haiti", "Jamaica", "Martinique", "Netherlands Antilles",
		"Panama", "Sint Maarten", "Philippines", "Vietnam",
		"Solomon Islands", "No Nationality", "Andorra", "Armenia", "Albania",
		"Belarus", "Bosnia and Herzegovina", "Cyprus", "Estonia",
		"Faroe Islands", "Georgia", "Iceland", "Kazakhstan", "Latvia",
		"Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta",
		"Moldova", "Montenegro", "San Marino", "Angola", "Guinea", "Mali",
		"Morocco", "Senegal", "Tunisia", "Costa Rica", "Trinidad & Tobago",
		"Bolivia", "Venezuela", "Bahrain", "Iran", "Iraq", "Kuwait", "Oman",
		"Qatar", "Syria", "Thailand", "Uzbekistan", "Edited" }; //text

	final static String[] nation10 = { "Austria", "Belgium", "Bosnia and Herzegovina",
	    "Bulgaria",	"Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
		"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia", "Slovakia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Cameroon",
		"Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "South Africa",
		"Togo", "Tunisia", "Canada", "Costa Rica", "Mexico", "USA",
		"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay",
		"Peru", "Uruguay", "Australia", "China", "Iran", "Japan",
		"North Korea", "Saudi Arabia", "South Korea", "United Arab Emirates",

		"Monaco", "Algeria", "Benin", "Burkina Faso", "Burundi",
		"Cape Verde","Central African Republic" ,"Chad", "Congo", "DR Congo", "Equatorial Guinea",
		"Gabon", "Gambia", "Guinea-Bissau", "Kenya", "Liberia", "Libya", "Madagascar",
		"Mozambique", "Niger", "Rwanda", "Sierra Leone", "Zambia",
		"Zimbabwe", "Aruba", "Barbados", "Cuba", "El Salvador", 
		"Grenada", "Guadeloupe","Guatemala", "Haiti", "Jamaica",
		"Martinique", "Netherlands Antilles", "Panama", "Sint Maarten",
		"Vietnam", "New Zealand", "Solomon Islands", "Albania", "Andorra", "Armenia",
		"Azerbaijan", "Belarus", "Cyprus", "Estonia", "Faroe Islands", "Georgia", "Iceland",
		"Kazakhstan", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg",
		"Macedonia", "Malta", "Moldova", "Montenegro", "San Marino", "Slovenia",
		"Angola", "Guinea", "Mali", "Morocco","Senegal", "Honduras", "Trinidad & Tobago",
		"Bolivia", "Venezuela", "Bahrain", "Iraq", "Kuwait","Oman", 
		"Qatar", "Syria", "Thailand", "Uzbekistan", "No Nationality" }; //text

	final static String[] nation09 = { "Austria", "Belgium", "Bulgaria",
		"Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
		"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia and Montenegro", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Cameroon",
		"Cote d'Ivoire", "Egypt", "Ghana", "Nigeria", "Senegal",
		"South Africa", "Tunisia", "Canada", "Costa Rica", "Mexico", "USA",
		"Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Paraguay",
		"Peru", "Uruguay", "Australia", "China", "Iran", "Japan",
		"Saudi Arabia", "South Korea", "Thailand", "United Arab Emirates",

		"Montenegro", "Algeria", "Benin", "Burkina Faso", "Burundi",
		"Cape Verde", "Chad", "Congo", "DR Congo", "Equatorial Guinea",
		"Gabon", "Gambia", "Guinea-Bissau", "Kenya", "Liberia", "Libya",
		"Mozambique", "Rwanda", "Sierra Leone", "Togo", "Zambia",
		"Zimbabwe", "Grenada", "Guadeloupe", "Haiti", "Jamaica",
		"Martinique", "Netherlands Antilles", "Panama", "Indonesia",
		"Malaysia", "Vietnam", "New Zealand", "Papua New Guinea",
		"Solomon Islands", "Albania", "Andorra", "Armenia", "Azerbaijan",
		"Belarus", "Bosnia and Herzegovina", "Cyprus", "Estonia",
		"Faroe Islands", "Georgia", "Iceland", "Kazakhstan", "Latvia",
		"Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta",
		"Moldova", "San Marino", "Angola", "Guinea", "Mali", "Morocco",
		"Honduras", "Trinidad & Tobago", "Bolivia", "Venezuela", "Bahrain",
		"Iraq", "Kuwait", "North Korea", "Oman", "Qatar", "Syria",
		"Uzbekistan", "No Nationality" }; //text

	final static String[] nation08 = { "Austria", "Belgium", "Bulgaria",
		"Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Israel",
		"Italy", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia and Montenegro", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Angola",
		"Cameroon", "Cote d'Ivoire", "Ghana", "Nigeria",
		"South Africa", "Togo", "Tunisia", "Costa Rica", "Mexico",
		"Trinidad and Tobago", "USA", "Argentina", "Brazil", "Chile",
		"Colombia", "Ecuador", "Paraguay", "Peru", "Uruguay",
		"Australia", "Iran", "Japan", "Saudi Arabia", "South Korea",

		"Montenegro", "Benin", "Burkina Faso", "Burundi", "Cape Verde",
		"Congo", "DR Congo", "Equatorial Guinea", "Gabon", "Gambia",
		"Guinea", "Kenya", "Liberia", "Mali", "Rwanda", "Sierra Leone",
		"Zambia", "Zimbabwe", "Canada", "Grenada", "Martinique",
		"Netherlands Antilles", "New Zealand", "Albania", "Andorra",
		"Armenia", "Azerbaijan", "Belarus", "Bosnia and Herzegovina",
		"Cyprus", "Estonia", "Faroe Islands", "Georgia", "Iceland",
		"Kazakhstan", "Latvia", "Liechtenstein", "Lithuania",
		"Luxembourg", "Macedonia", "Malta", "Moldova", "San Marino",
		"Algeria", "Egypt", "Morocco", "Senegal", "Honduras", "Jamaica",
		"Bolivia", "Venezuela", "Bahrain", "China", "Indonesia",
		"Iraq", "Malaysia", "Oman", "Qatar", "Thailand",
		"United Arab Emirates", "Uzbekistan", "Vietnam", "No Nationality" }; //text

	final static String[] nation6 = { "Austria", "Belgium", "Bulgaria",
		"Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
		"Latvia", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia and Montenegro", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Angola",
		"Cameroon", "Cote d'Ivoire", "Ghana", "Nigeria",
		"South Africa", "Togo", "Tunisia", "Costa Rica", "Mexico",
		"Trinidad and Tobago", "USA", "Argentina", "Brazil", "Chile",
		"Colombia", "Ecuador", "Paraguay", "Peru", "Uruguay",
		"Iran", "Japan", "Saudi Arabia", "South Korea", "Australia",


		"Bosnia and Herzegovina", "Estonia", "Israel", "Honduras",
		"Jamaica", "Panama", "Bolivia", "Venezuela", "China",
		"Uzbekistan", "Albania", "Cyprus", "Iceland", "Macedonia",
		"Armenia", "Belarus", "Georgia", "Liechtenstein", "Lithuania",
		"Algeria", "Benin", "Burkina Faso", "Cape Verde", "Congo",
		"DR Congo", "Egypt", "Equatorial Guinea", "Gabon", "Gambia",
		"Guinea", "Guinea-Bissau", "Kenya", "Liberia", "Libya",
		"Mali", "Morocco", "Mozambique", "Senegal", "Sierra Leone",
		"Zambia", "Zimbabwe", "Canada", "Grenada", "Guadeloupe",
		"Martinique", "Netherlands Antilles", "Oman", "New Zealand",
		"Free Nationality" }; //text

	final static String[] nation5 = { "Austria", "Belgium", "Bulgaria",
		"Croatia", "Czech Republic", "Denmark", "England", "Finland",
		"France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
		"Latvia", "Netherlands", "Northern Ireland", "Norway", "Poland",
		"Portugal", "Romania", "Russia", "Scotland",
		"Serbia and Montenegro", "Slovakia", "Slovenia", "Spain", "Sweden",
		"Switzerland", "Turkey", "Ukraine", "Wales", "Cameroon",
		"Cote d'Ivoire", "Morocco", "Nigeria", "Senegal",
		"South Africa", "Tunisia", "Costa Rica", "Mexico", "USA",
		"Argentina", "Brazil", "Chile", "Colombia", "Ecuador",
		"Paraguay", "Peru", "Uruguay", "Venezuela", "China",
		"Iran", "Japan", "Saudi Arabia", "South Korea", "Australia",


		"Albania", "Armenia", "Belarus", "Bosnia and Herzegovina",
		"Cyprus", "Georgia", "Estonia", "Faeroes Islands",
		"Iceland", "Israel", "Lithuania", "Luxembourg",
		"Macedonia", "Moldova", "Algeria", "Angola", "Burkina Faso",
		"Cape Verde", "Congo", "DR Congo", "Egypt",
		"Equatorial Guinea", "Gabon", "Gambia", "Ghana", "Guinea",
		"Guinea-Bissau", "Liberia", "Libya", "Mali", "Mauritius",  
		"Mozambique", "Namibia", "Sierra Leone", "Togo",
		"Zambia", "Zimbabwe", "Canada", "Grenada", "Guadeloupe",
		"Guatemala", "Honduras", "Jamaica", "Martinique",
		"Netherlands Antilles", "Panama", "Trinidad and Tobago",
		"Bolivia", "Guyana", "Uzbekistan", "New Zealand", 
		"Free Nationality" }; //text

	final static String[] modFoot = { "R", "L" };

	final static String[] modInjury = { "C", "B", "A" };

	final static String[] modFK = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
	
	public static final String[] MOD_FACE = {"Build", "Preset 1", "Preset"};
	
	public static final String[] MOD_SKIN = {"skin 1", "skin 2", "skin 3", "skin 4", "skin 5", "skin 6"};

	//final static String[] modG = { "7", "8", "4", "1", "3", "2" };
	//final static String[] modGString = { "early lasting", "average", "average lasting", "late", "late lasting", "early" };

	final static String[] mod18 = { "1", "2", "3", "4", "5", "6", "7", "8" };
	
	final static String[] MOD_CEL = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80" };
	
	final static String[] modcall = { "DESATIVADO", "ALMER", "DRAGOVIC", "GARICS", "FUCHS", "KAVLAK", "ALABA", "HARNIK", "ARNAUTOVIC", "JUNUZOVIC", "JANKO", "LINDNER", "ÖZCAN", "PRÖDL", "SCHIEMER", "F. KLEIN", "BAUMGARTLINGER", "JANTSCHER", "IVANSCHITZ", "A. WEIMANN", "COURTOIS", "KOMPANY" };
	
	public static int getValue(OptionFile of, int player, Stat stat) {
		int val = 0;
		if (of.newVersion) {
			int a = Player.startAdr + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit) {
				a = Player.startAdrE + 48 + ((player - Player.firstEdit) * 124)
						+ stat.offSet;
			}
			// System.out.println(a);
			val = (of.toInt(of.data[a]) << 8) | of.toInt(of.data[a - 1]);
		} else if (of.version13) {
			int a = Player.startAdr13 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit13) {
				a = Player.startAdrE13 + 48 + ((player - Player.firstEdit13) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data13[a]) << 8) | of.toInt(of.data13[a - 1]);
		} else if (of.version12) {
			int a = Player.startAdr12 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit12) {
				a = Player.startAdrE12 + 48 + ((player - Player.firstEdit12) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data12[a]) << 8) | of.toInt(of.data12[a - 1]);
		} else if (of.version11) {
			int a = Player.startAdr11 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit11) {
				a = Player.startAdrE11 + 48 + ((player - Player.firstEdit11) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data11[a]) << 8) | of.toInt(of.data11[a - 1]);
		} else if (of.version10) {
			int a = Player.startAdr10 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit10) {
				a = Player.startAdrE10 + 48 + ((player - Player.firstEdit10) * 124)
						+ stat.offSet;
			}
			if (stat.type == 8) {
				System.out.println("intero: " + (of.data10[a]));
				System.out.println("esadecimale: " + Integer.toHexString(of.data10[a]));
				System.out.println("primo carattere esadecimale: " + Integer.toHexString(of.data10[a]).charAt(0));
				if (Integer.toHexString(of.data10[a]).charAt(0) == (char) 5)
					
				System.out.println("esadecimale lavorato: ");
			}
			val = (of.toInt(of.data10[a]) << 8) | of.toInt(of.data10[a - 1]);
		} else if (of.version09) {
			int a = Player.startAdr09 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit09) {
				a = Player.startAdrE09 + 48 + ((player - Player.firstEdit09) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data09[a]) << 8) | of.toInt(of.data09[a - 1]);
		} else if (of.version08) {
			int a = Player.startAdr08 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit08) {
				a = Player.startAdrE08 + 48 + ((player - Player.firstEdit08) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data08[a]) << 8) | of.toInt(of.data08[a - 1]);
		} else if (of.version6) {
			int a = Player.startAdr6 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit6) {
				a = Player.startAdrE6 + 48 + ((player - Player.firstEdit6) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data6[a]) << 8) | of.toInt(of.data6[a - 1]);
		} else if (of.version5) {
			int a = Player.startAdr5 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit5) {
				a = Player.startAdrE5 + 48 + ((player - Player.firstEdit5) * 124)
						+ stat.offSet;
			}
			val = (of.toInt(of.data5[a]) << 8) | of.toInt(of.data5[a - 1]);
		}

		/*if (stat.name.equals("Growth"))
			System.out.println("preshift: " + stat.name + ": " + val);*/

		val = val >>> stat.shift;

		/*if (stat.name.equals("Growth"))
			System.out.println("premask: " + stat.name + ": " + val);*/

		val = val & stat.mask;

		/*if (stat.name.equals("Growth"))
			System.out.println("postmask: " + stat.name + ": " + val);*/

		if (stat.type == 3) {
			if (val == 100) {
				if (of.newVersion)
					val = nation.length - 1;
				else if (of.version13)
					val = nation13.length - 1;
				else if (of.version12)
					val = nation12.length - 1;
				else if (of.version11)
					val = nation11.length - 1;
				else if (of.version10)
					val = nation10.length - 1;
				else if (of.version09)
					val = nation09.length - 1;
				else if (of.version08)
					val = nation08.length - 1;
				else if (of.version6)
					val = nation6.length - 1;
				else if (of.version5)
					val = nation5.length - 1;
			} else if (val >= 103) {
				val = val - 3;
			}
		}

		if (stat.type == 8) {
			//v = new Integer(s);
		}

		return val;
	}

	public static void setValue(OptionFile of, int player, Stat stat, int v) {
		int a = 0;
		if (of.newVersion) {
			a = Player.startAdr + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit) {
				a = Player.startAdrE + 48 + ((player - Player.firstEdit) * 124)
						+ stat.offSet;
			}
		} /*else if (of.version13) {
			a = Player.startAdr13 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit13) {
				a = Player.startAdrE13 + 48 + ((player - Player.firstEdit13) * 124)
						+ stat.offSet;
			}
		} else if (of.version12) {
			a = Player.startAdr12 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit12) {
				a = Player.startAdrE12 + 48 + ((player - Player.firstEdit12) * 124)
						+ stat.offSet;
			}
		} else if (of.version11) {
			a = Player.startAdr11 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit11) {
				a = Player.startAdrE11 + 48 + ((player - Player.firstEdit11) * 124)
						+ stat.offSet;
			}
		} else if (of.version10) {
			a = Player.startAdr10 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit10) {
				a = Player.startAdrE10 + 48 + ((player - Player.firstEdit10) * 124)
						+ stat.offSet;
			}
		} else if (of.version09) {
			a = Player.startAdr09 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit09) {
				a = Player.startAdrE09 + 48 + ((player - Player.firstEdit09) * 124)
						+ stat.offSet;
			}
		} else if (of.version08) {
			a = Player.startAdr08 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit08) {
				a = Player.startAdrE08 + 48 + ((player - Player.firstEdit08) * 124)
						+ stat.offSet;
			}
		} else if (of.version6) {
			a = Player.startAdr6 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit6) {
				a = Player.startAdrE6 + 48 + ((player - Player.firstEdit6) * 124)
						+ stat.offSet;
			}
		} else if (of.version5) {
			a = Player.startAdr5 + 48 + (player * 124) + stat.offSet;
			if (player >= Player.firstEdit5) {
				a = Player.startAdrE5 + 48 + ((player - Player.firstEdit5) * 124)
						+ stat.offSet;
			}
		}*/

		if (stat.type == 3) {
			if (of.newVersion) {
				if (v == nation.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} /*else if (of.version13) {
				if (v == nation13.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version12) {
				if (v == nation12.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version11) {
				if (v == nation11.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version10) {
				if (v == nation10.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version09) {
				if (v == nation09.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version08) {
				if (v == nation08.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version6) {
				if (v == nation6.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			} else if (of.version5) {
				if (v == nation5.length - 1) {
					v = 100;
				} else if (v >= 100) {
					v = v + 3;
				}
			}*/
		}

		int old = 0;
		if (of.newVersion)
			old = (of.toInt(of.data[a]) << 8) | of.toInt(of.data[a - 1]);
		/*else if (of.version13)
			old = (of.toInt(of.data13[a]) << 8) | of.toInt(of.data13[a - 1]);
		else if (of.version12)
			old = (of.toInt(of.data12[a]) << 8) | of.toInt(of.data12[a - 1]);
		else if (of.version11)
			old = (of.toInt(of.data11[a]) << 8) | of.toInt(of.data11[a - 1]);
		else if (of.version10)
			old = (of.toInt(of.data10[a]) << 8) | of.toInt(of.data10[a - 1]);
		else if (of.version09)
			old = (of.toInt(of.data09[a]) << 8) | of.toInt(of.data09[a - 1]);
		else if (of.version08)
			old = (of.toInt(of.data08[a]) << 8) | of.toInt(of.data08[a - 1]);
		else if (of.version6)
			old = (of.toInt(of.data6[a]) << 8) | of.toInt(of.data6[a - 1]);
		else if (of.version5)
			old = (of.toInt(of.data5[a]) << 8) | of.toInt(of.data5[a - 1]);*/
		int oldMask = 0xFFFF & (~(stat.mask << stat.shift));
		old = old & oldMask;
		v = v & stat.mask;
		v = v << stat.shift;
		v = old | v;
		if (of.newVersion) {
			of.data[a - 1] = of.toByte(v & 0xff);
			of.data[a] = of.toByte(v >>> 8);
		} /*else if (of.version13) {
			of.data13[a - 1] = of.toByte(v & 0xff);
			of.data13[a] = of.toByte(v >>> 8);
		} else if (of.version12) {
			of.data12[a - 1] = of.toByte(v & 0xff);
			of.data12[a] = of.toByte(v >>> 8);
		} else if (of.version11) {
			of.data11[a - 1] = of.toByte(v & 0xff);
			of.data11[a] = of.toByte(v >>> 8);
		} else if (of.version10) {
			of.data10[a - 1] = of.toByte(v & 0xff);
			of.data10[a] = of.toByte(v >>> 8);
		} else if (of.version09) {
			of.data09[a - 1] = of.toByte(v & 0xff);
			of.data09[a] = of.toByte(v >>> 8);
		} else if (of.version08) {
			of.data08[a - 1] = of.toByte(v & 0xff);
			of.data08[a] = of.toByte(v >>> 8);
		} else if (of.version6) {
			of.data6[a - 1] = of.toByte(v & 0xff);
			of.data6[a] = of.toByte(v >>> 8);
		} else if (of.version5) {
			of.data5[a - 1] = of.toByte(v & 0xff);
			of.data5[a] = of.toByte(v >>> 8);
		}*/
	}

	public static void setValue(OptionFile of, int player, Stat stat, String s) {
		int v = 0;
		try {
			if (stat.type == 0) {
				v = new Integer(s).intValue();
			}
			if (stat.type == 1) {
				v = new Integer(s).intValue() - 148;
			}
			if (stat.type == 2) {
				v = new Integer(s).intValue() - 15;
			}
			if (stat.type == 3) {
				if (of.newVersion) {
					for (int i = 0; i < nation.length; i++) {
						if (s.equals(nation[i])) {
							v = i;
						}
					}
				} /*else if (of.version13) {
					for (int i = 0; i < nation13.length; i++) {
						if (s.equals(nation13[i])) {
							v = i;
						}
					}
				} else if (of.version12) {
					for (int i = 0; i < nation12.length; i++) {
						if (s.equals(nation12[i])) {
							v = i;
						}
					}
				} else if (of.version11) {
					for (int i = 0; i < nation11.length; i++) {
						if (s.equals(nation11[i])) {
							v = i;
						}
					}
				} else if (of.version10) {
					for (int i = 0; i < nation10.length; i++) {
						if (s.equals(nation10[i])) {
							v = i;
						}
					}
				} else if (of.version09) {
					for (int i = 0; i < nation09.length; i++) {
						if (s.equals(nation09[i])) {
							v = i;
						}
					}
				} else if (of.version08) {
					for (int i = 0; i < nation08.length; i++) {
						if (s.equals(nation08[i])) {
							v = i;
						}
					}
				} else if (of.version6) {
					for (int i = 0; i < nation6.length; i++) {
						if (s.equals(nation6[i])) {
							v = i;
						}
					}
				} else if (of.version5) {
					for (int i = 0; i < nation5.length; i++) {
						if (s.equals(nation5[i])) {
							v = i;
						}
					}
				}*/
			}
			if (stat.type == 4) {
				for (int i = 0; i < modFoot.length; i++) {
					if (s.equals(modFoot[i])) {
						v = i;
					}
				}
			}
			
			if (stat.type == 5) {
				v = new Integer(s).intValue() - 1;
			}
			if (stat.type == 6) {
				for (int i = 0; i < modInjury.length; i++) {
					if (s.equals(modInjury[i])) {
						v = i;
					}
				}
			}
			
			if (stat.type == 7) {
				for (int i = 0; i < modFK.length; i++) {
					if (s.equals(modFK[i])) {
						v = i;
					}
				}
			}
			if (stat.type == 10) {
				for (int i = 0; i < MOD_FACE.length; i++) {
					if (s.equals(MOD_FACE[i])) {
						v = i;
					}
				}
			}
			if (stat.type == 11) {
				for (int i = 0; i < MOD_SKIN.length; i++) {
					if (s.equals(MOD_SKIN[i])) {
						v = i;
					}
				}
			}
			
			if (stat.type == 12) {
				for (int i = 0; i < MOD_CEL.length; i++) {
					if (s.equals(MOD_CEL[i])) {
						v = i;
					}
				}
			}
			
			

			if (stat.type == 8) {
				v = new Integer(s);
			}
			
			setValue(of, player, stat, v);
		} catch (NumberFormatException nfe) {
		}
	}

	/*public static String getString(OptionFile of, int player, Stat stat) {
		String result = "";
		int val = getValue(of, player, stat);

		if (stat.type == 0) {
			result = String.valueOf(val);
		}
		if (stat.type == 1) {
			result = String.valueOf(val + 148);
		}
		if (stat.type == 2) {
			result = String.valueOf(val + 15);
		}
		if (stat.type == 3) {
			// System.out.println(val);
			if (of.newVersion) {
				if (val >= 0 && val < nation.length) {
					result = nation[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version13) {
				if (val >= 0 && val < nation13.length) {
					result = nation13[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version12) {
				if (val >= 0 && val < nation12.length) {
					result = nation12[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version11) {
				if (val >= 0 && val < nation11.length) {
					result = nation11[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version10) {
				if (val >= 0 && val < nation10.length) {
					result = nation10[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version09) {
				if (val >= 0 && val < nation09.length) {
					result = nation09[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version08) {
				if (val >= 0 && val < nation08.length) {
					result = nation08[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version6) {
				if (val >= 0 && val < nation6.length) {
					result = nation6[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version5) {
				if (val >= 0 && val < nation5.length) {
					result = nation5[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			}
		}
		if (stat.type == 4) {
			result = "R";
			if (val == 1) {
				result = "L";
			}
		}
		
		if (stat.type == 5) {
			result = String.valueOf(val + 1);
		}
		if (stat.type == 6) {
			result = "A";
			if (val == 1) {
				result = "B";
			}
			if (val == 0) {
				result = "C";
			}
		}
		
		if (stat.type == 7) {
			result = modFK[val];
		}
		
		if (stat.type == 8) {
			result = String.valueOf(val);
		}
		if (stat.type == 10) {
			result = MOD_FACE[val];
		}
		if (stat.type == 11) {
			result = MOD_SKIN[val];
		}
		if (stat.type == 12) {
			result = MOD_CEL[val];
		}
		
		return result;
	}
	*/
	public static String getString(OptionFile of, int player, Stat stat) {
		String result = "";
		int val = getValue(of, player, stat);

		if (stat.type == 0) {
			result = String.valueOf(val);
		}
		if (stat.type == 1) {
			result = String.valueOf(val + 148);
		}
		if (stat.type == 2) {
			result = String.valueOf(val + 15);
		}
		if (stat.type == 3) {
			// System.out.println(val);
			if (of.newVersion) {
				if (val >= 0 && val < nation.length) {
					result = nation[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version13) {
				if (val >= 0 && val < nation13.length) {
					result = nation13[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version12) {
				if (val >= 0 && val < nation12.length) {
					result = nation12[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version11) {
				if (val >= 0 && val < nation11.length) {
					result = nation11[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version10) {
				if (val >= 0 && val < nation10.length) {
					result = nation10[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version09) {
				if (val >= 0 && val < nation09.length) {
					result = nation09[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version08) {
				if (val >= 0 && val < nation08.length) {
					result = nation08[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version6) {
				if (val >= 0 && val < nation6.length) {
					result = nation6[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			} else if (of.version5) {
				if (val >= 0 && val < nation5.length) {
					result = nation5[val];
				} else {
					result = String.valueOf(val) + "?";
				}
			}
		}
		if (stat.type == 4) {
			result = "R";
			if (val == 1) {
				result = "L";
			}
		}
		if (stat.type == 5) {
			result = String.valueOf(val + 1);
		}
		if (stat.type == 6) {
			result = "A";
			if (val == 1) {
				result = "B";
			}
			if (val == 0) {
				result = "C";
			}
		}
		if (stat.type == 7) {
			result = modFK[val];
		}
		if (stat.type == 8) {
			result = String.valueOf(val);
		}
		if (stat.type == 10) {
			result = MOD_FACE[val];
		}
		if (stat.type == 11) {
			result = MOD_SKIN[val];
		
		}
		
		return result;
	}
}
