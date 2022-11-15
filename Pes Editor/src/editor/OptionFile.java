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

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;

public class OptionFile {
	//public static final int LENGTH = 1095680;
	public static final int LENGTH = 1086464; //offset

	public byte[] data = new byte[LENGTH];

	private byte[] headerData;

	public String fileName;

	public String gameID;

	private final static byte[] sharkport = { 13, 0, 0, 0, 83, 104, 97, 114,
			107, 80, 111, 114, 116, 83, 97, 118, 101, 0, 0, 0, 0 };

	private final static String magicMax = "Ps2PowerSave";

	String gameName;

	String saveName;

	String notes;

	public String filePath;

	/*final static int[] block = { 12, 5144, 7608, 12092, 34920, 649560, 739800,
		751252, 914696, 1070332, 1074144 };*/
	final static int[] block = { 12, 5144, 7608, 11844, 34672, 640632, 730872,
		742324, 905768, 1061404, 1065212 }; //offset

	/*final static int[] blockSize = { 4852, 2296, 4472, 22816, 613800, 90227,
		11440, 163432, 155624, 2600, 20752 };*/
	final static int[] blockSize = { 4852, 2296, 4224, 22816, 605120, 90227,
		11440, 163432, 155624, 2596, 20456 }; //offset

	private final static int[] key = { 2058578050, 2058578078, 2058578109,
		2058578079, 2058578084, 2058578115, 2058578073, 2058578105,
		2058578068, 2058578101, 2058578095, 2058578045, 2058578100,
		2058578111, 2058578096, 2058578068, 2058578101, 2058578117,
		2058578115, 2058578071, 2058578064, 2058578045, 2058578078,
		2058578085, 2058578062, 2058578116, 2058578109, 2058578045,
		2058578115, 2058578076, 2058578049, 2058578093, 2058578066,
		2058578051, 2058578082, 2058578114, 2058578045, 2058578093,
		2058578052, 2058578112, 2058578073, 2058578063, 2058578100,
		2058578102, 2058578103, 2058578053, 2058578085, 2058578078,
		2058578077, 2058578115, 2058578076, 2058578086, 2058578116,
		2058578111, 2058578083, 2058578109, 2058578072, 2058578047,
		2058578081, 2058578049, 2058578074, 2058578048, 2058578086,
		2058578110, 2058578098, 2058578102, 2058578105, 2058578050,
		2058578046, 2058578086, 2058578095, 2058578083, 2058578065,
		2058578062, 2058578047, 2058578116, 2058578109, 2058578100,
		2058578068, 2058578100, 2058578109, 2058578104, 2058578079,
		2058578084, 2058578084, 2058578083, 2058578084, 2058578098,
		2058578096, 2058578070, 2058578068, 2058578110, 2058578094,
		2058578045, 2058578114, 2058578082, 2058578116, 2058578068,
		2058578114, 2058578097, 2058578085, 2058578115, 2058578072,
		2058578068, 2058578047, 2058578099, 2058578076, 2058578101,
		2058578086, 2058578117, 2058578052, 2058578109, 2058578070,
		2058578050, 2058578118, 2058578046, 2058578109, 2058578098,
		2058578099, 2058578064, 2058578048, 2058578103, 2058578069,
		2058578075, 2058578068, 2058578085, 2058578110, 2058578111,
		2058578114, 2058578110, 2058578081, 2058578084, 2058578077,
		2058578073, 2058578084, 2058578100, 2058578104, 2058578063,
		2058578083, 2058578049, 2058578065, 2058578109, 2058578105,
		2058578099, 2058578105, 2058578062, 2058578069, 2058578070,
		2058578065, 2058578066, 2058578047, 2058578100, 2058578107,
		2058578077, 2058578062, 2058578050, 2058578113, 2058578080,
		2058578065, 2058578083, 2058578095, 2058578111, 2058578096,
		2058578044, 2058578116, 2058578053, 2058578084, 2058578077,
		2058578118, 2058578100, 2058578072, 2058578044, 2058578073,
		2058578104, 2058578117, 2058578074, 2058578069, 2058578110,
		2058578050, 2058578045, 2058578045, 2058578047, 2058578047,
		2058578106, 2058578064, 2058578099, 2058578095, 2058578063,
		2058578067, 2058578068, 2058578049, 2058578108, 2058578098,
		2058578115, 2058578099, 2058578097, 2058578106, 2058578097,
		2058578116, 2058578116, 2058578110, 2058578118, 2058578099,
		2058578111, 2058578106, 2058578109, 2058578101, 2058578093,
		2058578077, 2058578053, 2058578061, 2058578098, 2058578050,
		2058578086, 2058578104, 2058578098, 2058578113, 2058578102,
		2058578065, 2058578077, 2058578082, 2058578044, 2058578050,
		2058578085, 2058578117, 2058578045, 2058578117, 2058578113,
		2058578082, 2058578051, 2058578110, 2058578103, 2058578096,
		2058578069, 2058578052, 2058578114, 2058578046, 2058578044,
		2058578047, 2058578108, 2058578083, 2058578075, 2058578077,
		2058578069, 2058578050, 2058578101, 2058578063, 2058578082,
		2058578052, 2058578108, 2058578106, 2058578109, 2058578112,
		2058578062, 2058578071, 2058578051, 2058578047, 2058578097,
		2058578062, 2058578100, 2058578048, 2058578080, 2058578080,
		2058578077, 2058578047, 2058578048, 2058578096, 2058578100,
		2058578118, 2058578105, 2058578096, 2058578072, 2058578085,
		2058578084, 2058578061, 2058578114, 2058578044, 2058578049,
		2058578053, 2058578093, 2058578064, 2058578049, 2058578083,
		2058578069, 2058578073, 2058578104, 2058578080, 2058578098,
		2058578103, 2058578093, 2058578049, 2058578044, 2058578099,
		2058578094, 2058578070, 2058578103, 2058578070, 2058578062,
		2058578078, 2058578102, 2058578104, 2058578109, 2058578068,
		2058578067, 2058578108, 2058578108, 2058578076, 2058578086,
		2058578053, 2058578104, 2058578093, 2058578070, 2058578105,
		2058578110, 2058578094, 2058578112, 2058578086, 2058578049,
		2058578101, 2058578086, 2058578108, 2058578071, 2058578095,
		2058578079, 2058578097, 2058578116, 2058578111, 2058578046,
		2058578103, 2058578071, 2058578067, 2058578063, 2058578096,
		2058578048, 2058578079, 2058578103, 2058578068, 2058578114,
		2058578079, 2058578072, 2058578102, 2058578115, 2058578053,
		2058578047, 2058578084, 2058578046, 2058578110, 2058578044,
		2058578108, 2058578101, 2058578078, 2058578073, 2058578086,
		2058578049, 2058578107, 2058578069, 2058578077, 2058578086,
		2058578079, 2058578110, 2058578048, 2058578116, 2058578101,
		2058578108, 2058578081, 2058578093, 2058578113, 2058578065,
		2058578045, 2058578080, 2058578109, 2058578075, 2058578097,
		2058578071, 2058578049, 2058578053, 2058578078, 2058578050,
		2058578075, 2058578067, 2058578083, 2058578061, 2058578116,
		2058578116, 2058578075, 2058578093, 2058578116, 2058578100,
		2058578093, 2058578052, 2058578085, 2058578047, 2058578095,
		2058578081, 2058578045, 2058578044, 2058578101, 2058578097,
		2058578110, 2058578115, 2058578096, 2058578069, 2058578053,
		2058578050, 2058578112, 2058578085, 2058578104, 2058578082,
		2058578073, 2058578099, 2058578081, 2058578045, 2058578079,
		2058578071, 2058578080, 2058578047, 2058578113, 2058578076,
		2058578082, 2058578117, 2058578086, 2058578046, 2058578099,
		2058578068, 2058578074, 2058578108, 2058578064, 2058578077,
		2058578115, 2058578066, 2058578074, 2058578104, 2058578082,
		2058578115, 2058578117, 2058578082, 2058578117, 2058578048,
		2058578053, 2058578107, 2058578079, 2058578116, 2058578081,
		2058578086, 2058578064, 2058577996 };

	private int[] key5 = { 5734, 5777, 5777, 5701,
		5758, 5780, 5786, 5783, 5701, 5752, 5780, 5768, 5768,
		5770, 5783, 5701, 5740, 5766, 5778, 5770, 5701, 5734,
		5783, 5770, 5701, 5735, 5770, 5777, 5780, 5779, 5772,
		5701, 5753, 5780, 5701, 5756, 5738, 5715, 5542, 5733,
		5554, 5610, 5556, 5550, 5543, 5617, 5562, 5595, 5543,
		5618, 5543, 5581, 5563, 5654, 5558, 5582, 5543, 5613,
		5572, 5586, 5564, 5555, 5543, 5610, 5542, 5735, 5543,
		5612, 5543, 5577, 5543, 5639, 5543, 5644, 5544, 5738,
		5544, 5736, 5544, 5736, 5544, 5553, 5543, 5617, 5544,
		5771, 5542, 5760, 5544, 5763, 5543, 5653, 5550, 5665,
		5558, 5575, 5543, 5594, 5543, 5609, 5544, 5742, 5542,
		5760, 5544, 5747, 5544, 5755, 5544, 5548, 5544, 5560,
		5543, 5610, 5556, 5577, 5561, 5545, 5543, 5594, 5543,
		5609, 5543, 5575, 5543, 5646, 5561, 5790, 5543, 5583,
		5552, 5556, 5543, 5646, 5543, 5644, 5543, 5594, 5543,
		5575, 5542, 5734, 5552, 5637, 5558, 5744, 5543, 5583,
		5564, 5554, 5543, 5633, 5543, 5613, 5543, 5575, 5553,
		5607, 5557, 5777, 5543, 5639, 5542, 5734, 5544, 5547,
		5542, 5760, 5544, 5754, 5542, 5760, 5551, 5625, 5543,
		5617, 5544, 5792, 5544, 5550, 5544, 5560, 5544, 5770,
		5544, 5735, 5544, 5734, 5543, 5610, 5544, 5771, 5542,
		5760, 5544, 5763, 5543, 5617, 5543, 5639, 5543, 5645,
		5555, 5643, 5543, 5645, 5543, 5653, 5543, 5596, 5543,
		5646, 5543, 5617, 5543, 5618, 5544, 5750, 5542, 5760,
		5544, 5541, 5543, 5614, 5558, 5619, 5543, 5596, 5543,
		5646, 5556, 5651, 5561, 5746, 5543, 5653, 5551, 5593,
		5543, 5595, 5543, 5646, 5543, 5594, 5542, 5734, 5543,
		5590, 5543, 5604, 5543, 5644, 5543, 5611, 5543, 5594,
		5543, 5609, 5543, 5637, 5551, 5653, 5543, 5594, 5543,
		5575, 5553, 5605, 5543, 5645, 5543, 5603, 5543, 5588,
		5543, 5612, 5542, 5734, 5556, 5577, 5561, 5545, 5555,
		5779, 5543, 5636, 5543, 5644, 5543, 5647, 5543, 5646,
		5543, 5611, 5543, 5590, 5543, 5604, 5543, 5644, 5543,
		5611, 5543, 5594, 5543, 5609, 5543, 5637, 5558, 5791,
		5559, 5645, 5543, 5594, 5543, 5609, 5543, 5613, 5543,
		5575, 5555, 5563, 5543, 5614, 5543, 5613, 5543, 5646,
		5543, 5617, 5543, 5610, 5544, 5772, 5544, 5550, 5544,
		5786, 5544, 5552, 5563, 5773, 5555, 5795, 5543, 5617,
		5543, 5602, 5543, 5636, 5543, 5614, 5549, 5608, 5554,
		5547, 5550, 5600, 5543, 5594, 5543, 5633, 5543, 5596,
		5542, 5735, 5669 };

	byte format = -1;

	int fileCount;

	public static final int LENGTH13 = 1095680;
	public byte[] data13 = new byte[LENGTH13];
	private byte[] headerData13;
	public boolean newVersion;
	public boolean version13;
	final static int[] block13 = { 12, 5144, 7608, 12092, 34920, 649560, 739800,
		751252, 914696, 1070332, 1074144 };
	final static int[] blockSize13 = { 4852, 2296, 4472, 22816, 613800, 90227,
		11440, 163432, 155624, 2600, 20752 };

	public static final int LENGTH12 = 1106944;
	public byte[] data12 = new byte[LENGTH12];
	private byte[] headerData12;
	public boolean version12;
	final static int[] block12 = { 12, 5144, 7608, 12280, 35108, 654708, 747248,
		759140, 925824, 1081460, 1085276 };
	final static int[] blockSize12 = { 4852, 2296, 4658, 22816, 618760, 92527,
		11880, 166672, 155624, 2604, 20944 };

	public static final int LENGTH11 = 1120256;
	public byte[] data11 = new byte[LENGTH11];
	private byte[] headerData11;
	public boolean version11;
	final static int[] block11 = { 12, 5144, 7608, 12404, 35232, 664752, 758672,
		770828, 939456, 1095092, 1098748 };
	final static int[] blockSize11 = { 4852, 2296, 4782, 22816, 628680, 93907,
		12144, 168616, 155624, 2604, 21284 };

	public static final int LENGTH10 = 1111040;
	public byte[] data10 = new byte[LENGTH10];
	private byte[] headerData10;
	public boolean version10;
	final static int[] block10 = { 12, 5144, 7504, 12276, 35104, 659664, 753488,
		765644, 930992, 1086628, 1089228 };
	final static int[] blockSize10 = { 4852, 2192, 4760, 22816, 623720, 93811,
		12144, 165336, 155624, 2588, 21124 };

	public static final int LENGTH09 = 1086464;
	public byte[] data09 = new byte[LENGTH09];
	private byte[] headerData09;
	public boolean version09;
	final static int[] block09 = { 12, 5144, 7300, 11904, 34732, 655572, 748476,
		760456, 906676, 1062312, 1065040 };
	final static int[] blockSize09 = { 4852, 1988, 4592, 22816, 620000, 92891,
		11968, 146208, 155624, 2716, 20996 };

	public static final int LENGTH08 = 1118208;
	public byte[] data08 = new byte[LENGTH08];
	private byte[] headerData08;
	public boolean version08;
	final static int[] block08 = { 12, 5144, 7196, 11876, 34704, 676624, 773820,
		786856, 938548, 1094184, 1096380 };
	final static int[] blockSize08 = { 4852, 1884, 4668, 22816, 641080, 97181,
		13024, 151680, 155624, 2184, 21740 };

	public static final int LENGTH6 = 1191936;
	public byte[] data6 = new byte[LENGTH6];
	private byte[] headerData6;
	public boolean version6;
	final static int[] block6 = { 12, 5144, 9544, 14288, 37116, 657956, 751472,
		763804, 911144, 1170520 };
	final static int[] blockSize6 = { 4844, 1268, 4730, 22816, 620000, 93501,
		12320, 147328, 259364, 21032 };

	public static final int LENGTH5 = 1250304;
	public byte[] data5 = new byte[LENGTH5];
	private byte[] headerData5;
	public boolean version5;
	final static int[] block5 = { 12, 5144, 9508, 14044, 36872, 657712, 803608,
		822940, 969192, 1228568 };
	final static int[] blockSize5 = { 4948, 1232, 4522, 22816, 620000, 145882,
		19320, 146240, 259364, 21016 };

	public OptionFile() {
		for (int i = 0; i < key5.length; i++) {
			key5[i] += 1815543808;
		}
	}

	public boolean readXPS(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData);
				gameID = new String(headerData, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData = new byte[(int) (in.length() - LENGTH)];
				in.read(headerData);
				gameID = new String(headerData, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					// System.out.println(chk);
					CRC32 crc = new CRC32();
					crc.update(temp);
					// System.out.println((int) crc.getValue());
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH && title.equals(gameID)) {
								p = p + 36;
								headerData = new byte[p];
								System.arraycopy(temp, 0, headerData, 0, p);
								System.arraycopy(temp, p, data, 0, LENGTH);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data);
				decrypt();
			}
			filePath = of.getParent();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData();
			newVersion = true;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPSD(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData);
				gameID = new String(headerData, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData = new byte[(int) (in.length() - LENGTH)];
				in.read(headerData);
				gameID = new String(headerData, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					// System.out.println(chk);
					CRC32 crc = new CRC32();
					crc.update(temp);
					// System.out.println((int) crc.getValue());
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH && title.equals(gameID)) {
								p = p + 36;
								headerData = new byte[p];
								System.arraycopy(temp, 0, headerData, 0, p);
								System.arraycopy(temp, p, data, 0, LENGTH);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data);
				nodecrypt();
			}
			filePath = of.getParent();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData();
			newVersion = true;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}
	
	public boolean readXPS13(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH13 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData13 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData13);
				gameID = new String(headerData13, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData13 = new byte[(int) (in.length() - LENGTH13)];
				in.read(headerData13);
				gameID = new String(headerData13, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH13 && title.equals(gameID)) {
								p = p + 36;
								headerData13 = new byte[p];
								System.arraycopy(temp, 0, headerData13, 0, p);
								System.arraycopy(temp, p, data13, 0, LENGTH13);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data13);
				decrypt13();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData13();
			newVersion = false;
			version13 = true;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS12(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH12 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData12 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData12);
				gameID = new String(headerData12, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData12 = new byte[(int) (in.length() - LENGTH12)];
				in.read(headerData12);
				gameID = new String(headerData12, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH12 && title.equals(gameID)) {
								p = p + 36;
								headerData12 = new byte[p];
								System.arraycopy(temp, 0, headerData12, 0, p);
								System.arraycopy(temp, p, data12, 0, LENGTH12);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data12);
				decrypt12();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData12();
			newVersion = false;
			version13 = false;
			version12 = true;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS11(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH11 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData11 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData11);
				gameID = new String(headerData11, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData11 = new byte[(int) (in.length() - LENGTH11)];
				in.read(headerData11);
				gameID = new String(headerData11, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH11 && title.equals(gameID)) {
								p = p + 36;
								headerData11 = new byte[p];
								System.arraycopy(temp, 0, headerData11, 0, p);
								System.arraycopy(temp, p, data11, 0, LENGTH11);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data11);
				decrypt11();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData11();
			newVersion = false;
			version13 = false;
			version12 = false;
			version11 = true;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS10(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH10 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData10 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData10);
				gameID = new String(headerData10, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData10 = new byte[(int) (in.length() - LENGTH10)];
				in.read(headerData10);
				gameID = new String(headerData10, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH10 && title.equals(gameID)) {
								p = p + 36;
								headerData10 = new byte[p];
								System.arraycopy(temp, 0, headerData10, 0, p);
								System.arraycopy(temp, p, data10, 0, LENGTH10);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data10);
				decrypt10();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData10();
			newVersion = false;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = true;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS09(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH09 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData09 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData09);
				gameID = new String(headerData09, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData09 = new byte[(int) (in.length() - LENGTH09)];
				in.read(headerData09);
				gameID = new String(headerData09, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH09 && title.equals(gameID)) {
								p = p + 36;
								headerData09 = new byte[p];
								System.arraycopy(temp, 0, headerData09, 0, p);
								System.arraycopy(temp, p, data09, 0, LENGTH09);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data09);
				decrypt09();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData09();
			newVersion = false;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = true;
			version08 = false;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS08(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH08 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData08 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData08);
				gameID = new String(headerData08, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData08 = new byte[(int) (in.length() - LENGTH08)];
				in.read(headerData08);
				gameID = new String(headerData08, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH08 && title.equals(gameID)) {
								p = p + 36;
								headerData08 = new byte[p];
								System.arraycopy(temp, 0, headerData08, 0, p);
								System.arraycopy(temp, p, data08, 0, LENGTH08);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data08);
				decrypt08();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData08();
			newVersion = false;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = true;
			version6 = false;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS6(File of) {
		format = -1;
		boolean done = true;
		String extension = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			if (extension != null && extension.equals(PESUtils.xps)) {
				long offSet = in.length() - LENGTH6 - 4;
				in.seek(21);
				byte[] temp;
				int size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				gameName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				saveName = new String(temp, "ISO-8859-1");
				size = PESUtils.swabInt(in.readInt());
				temp = new byte[size];
				in.read(temp);
				notes = new String(temp, "ISO-8859-1");

				headerData6 = new byte[(int) offSet - 33 - gameName.length()
						- saveName.length() - notes.length()];
				in.read(headerData6);
				gameID = new String(headerData6, 6, 19);
				format = 0;
			} else if (extension != null && extension.equals(PESUtils.psu)) {
				headerData6 = new byte[(int) (in.length() - LENGTH6)];
				in.read(headerData6);
				gameID = new String(headerData6, 64, 19);
				format = 2;
			} else if (extension != null && extension.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH6 && title.equals(gameID)) {
								p = p + 36;
								headerData6 = new byte[p];
								System.arraycopy(temp, 0, headerData6, 0, p);
								System.arraycopy(temp, p, data6, 0, LENGTH6);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			}
			if (done && format != -1) {
				if (format != 3)
					in.read(data6);
				decrypt6();
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData6();
			newVersion = false;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = true;
			version5 = false;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean readXPS5(File of) {
		format = -1;
		boolean done = true;
		String str = PESUtils.getExtension(of);
		try {
			RandomAccessFile in = new RandomAccessFile(of, "r");
			byte[] arrayOfByte3;
			if ((str != null) && (str.equals("xps"))) {
				long l = in.length() - LENGTH5 - 4;
				in.seek(21);
				int i = PESUtils.swabInt(in.readInt());
				arrayOfByte3 = new byte[i];
				in.read(arrayOfByte3);
				gameName = new String(arrayOfByte3, "ISO-8859-1");
				i = PESUtils.swabInt(in.readInt());
				arrayOfByte3 = new byte[i];
				in.read(arrayOfByte3);
				saveName = new String(arrayOfByte3, "ISO-8859-1");
				i = PESUtils.swabInt(in.readInt());
				arrayOfByte3 = new byte[i];
				in.read(arrayOfByte3);
				notes = new String(arrayOfByte3, "ISO-8859-1");
				headerData5 = new byte[(int)l - 33 - gameName.length() - saveName.length() - notes.length()];
				in.read(headerData5);
				gameID = new String(headerData5, 6, 19);
				format = 0;
			} else if (str != null && str.equals(PESUtils.psu)) {
				headerData5 = new byte[(int) (in.length() - LENGTH5)];
				in.read(headerData5);
				gameID = new String(headerData5, 64, 19);
				format = 2;
			} else if (str != null && str.equals(PESUtils.max)) {
				byte[] temp = new byte[(int) in.length()];
				in.read(temp);
				String magic = new String(temp, 0, 12, "ISO-8859-1");
				if (magic.equals(magicMax)) {
					int chk = byteToInt(temp, 12);
					temp[12] = 0;
					temp[13] = 0;
					temp[14] = 0;
					temp[15] = 0;
					CRC32 crc = new CRC32();
					crc.update(temp);
					if ((int) crc.getValue() == chk) {
						temp = new byte[32];
						in.seek(16);
						in.read(temp);
						gameID = new String(temp, "ISO-8859-1");
						gameID = gameID.replace("\0", "");
						in.read(temp);
						gameName = new String(temp, "ISO-8859-1");
						gameName = gameName.replace("\0", "");
						int codeSize = PESUtils.swabInt(in.readInt());
						fileCount = PESUtils.swabInt(in.readInt());
						temp = new byte[codeSize];
						in.read(temp);
						Lzari lz = new Lzari();
						temp = lz.decodeLzari(temp);
						int p = 0;
						for (int i = 0; i < fileCount && format != 3; i++) {
							int size = byteToInt(temp, p);
							String title = new String(temp, p + 4, 19,
									"ISO-8859-1");
							if (size == LENGTH5 && title.equals(gameID)) {
								p = p + 36;
								headerData5 = new byte[p];
								System.arraycopy(temp, 0, headerData5, 0, p);
								System.arraycopy(temp, p, data5, 0, LENGTH5);
								format = 3;
							} else {
								p = p + 36 + size;
								p = ((p + 23) / 16 * 16) - 8;
							}
						}
						if (format != 3) {
							done = false;
						}
					} else {
						done = false;
					}
				} else {
					done = false;
				}
			} if (done && format != -1) {
				if (format != 3)
					in.read(data5);
				decrypt5();
			} in.close();
		} catch (Exception localException) {
			localException.printStackTrace();
			done = false;
		}
		if (done) {
			fileName = of.getName();
			//saveData5();
			newVersion = false;
			version13 = false;
			version12 = false;
			version11 = false;
			version10 = false;
			version09 = false;
			version08 = false;
			version6 = false;
			version5 = true;
		} else {
			fileName = null;
		}
		return done;
	}

	public boolean saveXPS(File of) {
		//data[49] = 1;
		//data[50] = 1;
		//data[5942] = 1;
		//data[5943] = 1;
		boolean done = true;
		encrypt();
		checkSums();
		try {
			RandomAccessFile out = new RandomAccessFile(of, "rw");
			if (format == 0) {
				saveName = of.getName();
				saveName = saveName.substring(0, saveName.length() - 4);
				out.write(sharkport);
				out.writeInt(PESUtils.swabInt(gameName.length()));
				out.writeBytes(gameName);
				out.writeInt(PESUtils.swabInt(saveName.length()));
				out.writeBytes(saveName);
				out.writeInt(PESUtils.swabInt(notes.length()));
				out.writeBytes(notes);
				out.write(headerData);
			}
			if (format == 2) {
				out.write(headerData);
			}
			if (format == 3) {
				int textSize = headerData.length + LENGTH;
				textSize = ((textSize + 23) / 16 * 16) - 8;
				// System.out.println(textSize);
				byte[] temp = new byte[textSize];
				System.arraycopy(headerData, 0, temp, 0, headerData.length);
				System.arraycopy(data, 0, temp, headerData.length, data.length);
				Lzari lz = new Lzari();
				temp = lz.encodeLzari(temp);
				int codeSize = temp.length;

				byte[] temp2 = new byte[88];
				System.arraycopy(magicMax.getBytes("ISO-8859-1"), 0, temp2, 0,
						magicMax.length());
				System.arraycopy(gameID.getBytes("ISO-8859-1"), 0, temp2, 16,
						19);
				System.arraycopy(gameName.getBytes("ISO-8859-1"), 0, temp2, 48,
						gameName.length());
				System.arraycopy(getBytesInt(codeSize), 0, temp2, 80, 4);
				System.arraycopy(getBytesInt(fileCount), 0, temp2, 84, 4);

				CRC32 chk = new CRC32();
				chk.update(temp2);
				chk.update(temp);
				// System.out.println((int)chk.getValue());
				System.arraycopy(getBytesInt((int) chk.getValue()), 0, temp2,
						12, 4);
				out.write(temp2);
				out.write(temp);
			} else {
				out.write(data);
			}
			if (format == 0) {
				out.write(0);
				out.write(0);
				out.write(0);
				out.write(0);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		decrypt();
		return done;

	}
	
	public boolean saveXPS13(File of2) {
		//data[49] = 1;
		//data[50] = 1;
		//data[5942] = 1;
		//data[5943] = 1;
		boolean done = true;
		encryptD();
		checkSums();
		try {
			RandomAccessFile out = new RandomAccessFile(of2, "rw");
			if (format == 0) {
				saveName = of2.getName();
				saveName = saveName.substring(0, saveName.length() - 4);
				out.write(sharkport);
				out.writeInt(PESUtils.swabInt(gameName.length()));
				out.writeBytes(gameName);
				out.writeInt(PESUtils.swabInt(saveName.length()));
				out.writeBytes(saveName);
				out.writeInt(PESUtils.swabInt(notes.length()));
				out.writeBytes(notes);
				out.write(headerData13);
			}
			if (format == 2) {
				out.write(headerData13);
			}
			if (format == 3) {
				int textSize = headerData13.length + LENGTH13;
				textSize = ((textSize + 23) / 16 * 16) - 8;
				// System.out.println(textSize);
				byte[] temp = new byte[textSize];
				System.arraycopy(headerData13, 0, temp, 0, headerData13.length);
				System.arraycopy(data13, 0, temp, headerData13.length, data13.length);
				Lzari lz = new Lzari();
				temp = lz.encodeLzari(temp);
				int codeSize = temp.length;

				byte[] temp2 = new byte[88];
				System.arraycopy(magicMax.getBytes("ISO-8859-1"), 0, temp2, 0,
						magicMax.length());
				System.arraycopy(gameID.getBytes("ISO-8859-1"), 0, temp2, 16,
						19);
				System.arraycopy(gameName.getBytes("ISO-8859-1"), 0, temp2, 48,
						gameName.length());
				System.arraycopy(getBytesInt(codeSize), 0, temp2, 80, 4);
				System.arraycopy(getBytesInt(fileCount), 0, temp2, 84, 4);

				CRC32 chk = new CRC32();
				chk.update(temp2);
				chk.update(temp);
				// System.out.println((int)chk.getValue());
				System.arraycopy(getBytesInt((int) chk.getValue()), 0, temp2,
						12, 4);
				out.write(temp2);
				out.write(temp);
			} else {
				out.write(data13);
			}
			if (format == 0) {
				out.write(0);
				out.write(0);
				out.write(0);
				out.write(0);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		decrypt13();
		return done;

	}
	
	public boolean saveXPS12(File of2) {
		//data[49] = 1;
		//data[50] = 1;
		//data[5942] = 1;
		//data[5943] = 1;
		boolean done = true;
		encryptD();
		checkSums();
		try {
			RandomAccessFile out = new RandomAccessFile(of2, "rw");
			if (format == 0) {
				saveName = of2.getName();
				saveName = saveName.substring(0, saveName.length() - 4);
				out.write(sharkport);
				out.writeInt(PESUtils.swabInt(gameName.length()));
				out.writeBytes(gameName);
				out.writeInt(PESUtils.swabInt(saveName.length()));
				out.writeBytes(saveName);
				out.writeInt(PESUtils.swabInt(notes.length()));
				out.writeBytes(notes);
				out.write(headerData12);
			}
			if (format == 2) {
				out.write(headerData12);
			}
			if (format == 3) {
				int textSize = headerData12.length + LENGTH12;
				textSize = ((textSize + 23) / 16 * 16) - 8;
				// System.out.println(textSize);
				byte[] temp = new byte[textSize];
				System.arraycopy(headerData12, 0, temp, 0, headerData12.length);
				System.arraycopy(data12, 0, temp, headerData12.length, data12.length);
				Lzari lz = new Lzari();
				temp = lz.encodeLzari(temp);
				int codeSize = temp.length;

				byte[] temp2 = new byte[88];
				System.arraycopy(magicMax.getBytes("ISO-8859-1"), 0, temp2, 0,
						magicMax.length());
				System.arraycopy(gameID.getBytes("ISO-8859-1"), 0, temp2, 16,
						19);
				System.arraycopy(gameName.getBytes("ISO-8859-1"), 0, temp2, 48,
						gameName.length());
				System.arraycopy(getBytesInt(codeSize), 0, temp2, 80, 4);
				System.arraycopy(getBytesInt(fileCount), 0, temp2, 84, 4);

				CRC32 chk = new CRC32();
				chk.update(temp2);
				chk.update(temp);
				// System.out.println((int)chk.getValue());
				System.arraycopy(getBytesInt((int) chk.getValue()), 0, temp2,
						12, 4);
				out.write(temp2);
				out.write(temp);
			} else {
				out.write(data12);
			}
			if (format == 0) {
				out.write(0);
				out.write(0);
				out.write(0);
				out.write(0);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		decrypt12();
		return done;

	}
	
	public boolean saveXPS11(File of2) {
		//data[49] = 1;
		//data[50] = 1;
		//data[5942] = 1;
		//data[5943] = 1;
		boolean done = true;
		encryptD();
		checkSums();
		try {
			RandomAccessFile out = new RandomAccessFile(of2, "rw");
			if (format == 0) {
				saveName = of2.getName();
				saveName = saveName.substring(0, saveName.length() - 4);
				out.write(sharkport);
				out.writeInt(PESUtils.swabInt(gameName.length()));
				out.writeBytes(gameName);
				out.writeInt(PESUtils.swabInt(saveName.length()));
				out.writeBytes(saveName);
				out.writeInt(PESUtils.swabInt(notes.length()));
				out.writeBytes(notes);
				out.write(headerData11);
			}
			if (format == 2) {
				out.write(headerData11);
			}
			if (format == 3) {
				int textSize = headerData11.length + LENGTH11;
				textSize = ((textSize + 23) / 16 * 16) - 8;
				// System.out.println(textSize);
				byte[] temp = new byte[textSize];
				System.arraycopy(headerData11, 0, temp, 0, headerData11.length);
				System.arraycopy(data11, 0, temp, headerData11.length, data11.length);
				Lzari lz = new Lzari();
				temp = lz.encodeLzari(temp);
				int codeSize = temp.length;

				byte[] temp2 = new byte[88];
				System.arraycopy(magicMax.getBytes("ISO-8859-1"), 0, temp2, 0,
						magicMax.length());
				System.arraycopy(gameID.getBytes("ISO-8859-1"), 0, temp2, 16,
						19);
				System.arraycopy(gameName.getBytes("ISO-8859-1"), 0, temp2, 48,
						gameName.length());
				System.arraycopy(getBytesInt(codeSize), 0, temp2, 80, 4);
				System.arraycopy(getBytesInt(fileCount), 0, temp2, 84, 4);

				CRC32 chk = new CRC32();
				chk.update(temp2);
				chk.update(temp);
				// System.out.println((int)chk.getValue());
				System.arraycopy(getBytesInt((int) chk.getValue()), 0, temp2,
						12, 4);
				out.write(temp2);
				out.write(temp);
			} else {
				out.write(data11);
			}
			if (format == 0) {
				out.write(0);
				out.write(0);
				out.write(0);
				out.write(0);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		decrypt11();
		return done;

	}
	
	public boolean saveXPS10(File of2) {
		//data[49] = 1;
		//data[50] = 1;
		//data[5942] = 1;
		//data[5943] = 1;
		boolean done = true;
		encryptD();
		checkSums();
		try {
			RandomAccessFile out = new RandomAccessFile(of2, "rw");
			if (format == 0) {
				saveName = of2.getName();
				saveName = saveName.substring(0, saveName.length() - 4);
				out.write(sharkport);
				out.writeInt(PESUtils.swabInt(gameName.length()));
				out.writeBytes(gameName);
				out.writeInt(PESUtils.swabInt(saveName.length()));
				out.writeBytes(saveName);
				out.writeInt(PESUtils.swabInt(notes.length()));
				out.writeBytes(notes);
				out.write(headerData12);
			}
			if (format == 2) {
				out.write(headerData10);
			}
			if (format == 3) {
				int textSize = headerData10.length + LENGTH10;
				textSize = ((textSize + 23) / 16 * 16) - 8;
				// System.out.println(textSize);
				byte[] temp = new byte[textSize];
				System.arraycopy(headerData10, 0, temp, 0, headerData10.length);
				System.arraycopy(data10, 0, temp, headerData10.length, data10.length);
				Lzari lz = new Lzari();
				temp = lz.encodeLzari(temp);
				int codeSize = temp.length;

				byte[] temp2 = new byte[88];
				System.arraycopy(magicMax.getBytes("ISO-8859-1"), 0, temp2, 0,
						magicMax.length());
				System.arraycopy(gameID.getBytes("ISO-8859-1"), 0, temp2, 16,
						19);
				System.arraycopy(gameName.getBytes("ISO-8859-1"), 0, temp2, 48,
						gameName.length());
				System.arraycopy(getBytesInt(codeSize), 0, temp2, 80, 4);
				System.arraycopy(getBytesInt(fileCount), 0, temp2, 84, 4);

				CRC32 chk = new CRC32();
				chk.update(temp2);
				chk.update(temp);
				// System.out.println((int)chk.getValue());
				System.arraycopy(getBytesInt((int) chk.getValue()), 0, temp2,
						12, 4);
				out.write(temp2);
				out.write(temp);
			} else {
				out.write(data10);
			}
			if (format == 0) {
				out.write(0);
				out.write(0);
				out.write(0);
				out.write(0);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		decrypt10();
		return done;

	}
	
	public boolean saveXPSD(File of) {
		//data[49] = 1;
		//data[50] = 1;
		//data[5942] = 1;
		//data[5943] = 1;
		boolean done = true;
		encryptD();
		checkSums();
		try {
			RandomAccessFile out = new RandomAccessFile(of, "rw");
			if (format == 0) {
				saveName = of.getName();
				saveName = saveName.substring(0, saveName.length() - 4);
				out.write(sharkport);
				out.writeInt(PESUtils.swabInt(gameName.length()));
				out.writeBytes(gameName);
				out.writeInt(PESUtils.swabInt(saveName.length()));
				out.writeBytes(saveName);
				out.writeInt(PESUtils.swabInt(notes.length()));
				out.writeBytes(notes);
				out.write(headerData);
			}
			if (format == 2) {
				out.write(headerData);
			}
			if (format == 3) {
				int textSize = headerData.length + LENGTH;
				textSize = ((textSize + 23) / 16 * 16) - 8;
				// System.out.println(textSize);
				byte[] temp = new byte[textSize];
				System.arraycopy(headerData, 0, temp, 0, headerData.length);
				System.arraycopy(data, 0, temp, headerData.length, data.length);
				Lzari lz = new Lzari();
				temp = lz.encodeLzari(temp);
				int codeSize = temp.length;

				byte[] temp2 = new byte[88];
				System.arraycopy(magicMax.getBytes("ISO-8859-1"), 0, temp2, 0,
						magicMax.length());
				System.arraycopy(gameID.getBytes("ISO-8859-1"), 0, temp2, 16,
						19);
				System.arraycopy(gameName.getBytes("ISO-8859-1"), 0, temp2, 48,
						gameName.length());
				System.arraycopy(getBytesInt(codeSize), 0, temp2, 80, 4);
				System.arraycopy(getBytesInt(fileCount), 0, temp2, 84, 4);

				CRC32 chk = new CRC32();
				chk.update(temp2);
				chk.update(temp);
				// System.out.println((int)chk.getValue());
				System.arraycopy(getBytesInt((int) chk.getValue()), 0, temp2,
						12, 4);
				out.write(temp2);
				out.write(temp);
			} else {
				out.write(data);
			}
			if (format == 0) {
				out.write(0);
				out.write(0);
				out.write(0);
				out.write(0);
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		decrypt();
		return done;

	}
	
	public byte[] hexStringToByteArray(String s) {
	    byte[] data = new byte[s.length()/2];
	    for (int i = 0; i < data.length; i ++) {
	        data[i] = (byte) ((Character.digit(s.charAt(i*2), 16) << 4)
	                + Character.digit(s.charAt(i*2 + 1), 16));
	    }
	    return data;
	}

	public boolean savePara(File of, String dest) {
		boolean done = true;
		try {
			byte[] formationsBytes = new byte[10244];
			byte[] temp = new byte[53];
			byte[] ok = new byte[52];
			for (int squad = 0; squad < Kits.totalTeams; squad++) {
				System.arraycopy(data, Formations.startAdr + 118 + (Formations.size * squad), temp, 0, 53);
				System.arraycopy(temp, 21, ok, 0, 10);
				System.arraycopy(temp, 0, ok, 10, 1);
				System.arraycopy(temp, 2, ok, 11, 1);
				System.arraycopy(temp, 4, ok, 12, 1);
				System.arraycopy(temp, 6, ok, 13, 1);
				System.arraycopy(temp, 8, ok, 14, 1);
				System.arraycopy(temp, 10, ok, 15, 1);
				System.arraycopy(temp, 12, ok, 16, 1);
				System.arraycopy(temp, 14, ok, 17, 1);
				System.arraycopy(temp, 16, ok, 18, 1);
				System.arraycopy(temp, 18, ok, 19, 1);
				System.arraycopy(temp, 1, ok, 20, 1);
				System.arraycopy(temp, 3, ok, 21, 1);
				System.arraycopy(temp, 5, ok, 22, 1);
				System.arraycopy(temp, 7, ok, 23, 1);
				System.arraycopy(temp, 9, ok, 24, 1);
				System.arraycopy(temp, 11, ok, 25, 1);
				System.arraycopy(temp, 13, ok, 26, 1);
				System.arraycopy(temp, 15, ok, 27, 1);
				System.arraycopy(temp, 17, ok, 28, 1);
				System.arraycopy(temp, 19, ok, 29, 1);
				System.arraycopy(temp, 31, ok, 30, 22);
				if (formationsBytes.length <= 10244)
					System.arraycopy(ok, 0, formationsBytes, (52 * squad), 52);
			}
			byte[] nationalBytes = new byte[30552];
			byte[] clubBytes = new byte[84240];
			byte[] emptyN = new byte[108];
			byte[] emptyC = new byte[300];
			byte[] temConfigBytes = new byte[1182];
			for (int squad = 0; squad < Kits.totalN; squad++) {
				System.arraycopy(data, Kits.startAdrN + (Kits.sizeN * squad), nationalBytes, Kits.sizeN * squad, 348);
				System.arraycopy(emptyN, 0, nationalBytes, Kits.sizeN * squad + 348, 108);
			}
			for (int squad = 0; squad < Clubs.total; squad++) {
				System.arraycopy(data, Kits.startAdrC + (Kits.sizeC * squad), clubBytes, Kits.sizeC * squad, 348);
				System.arraycopy(emptyC, 0, clubBytes, Kits.sizeC * squad + 348, 300);
			}
			
			for (int squad = 0; squad < Kits.totalTeams; squad++) {
				System.arraycopy(data, Formations.startAdr + Formations.configPlayersTeamAdr + (squad * Formations.size), temConfigBytes, squad * Formations.configPlayersTeamSize, Formations.configPlayersTeamSize);
			}
			
			RandomAccessFile playersBin = new RandomAccessFile(dest + "\\unknow_00051.bin_000", "rw");
			RandomAccessFile slot23Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_001", "rw");
			RandomAccessFile slot32Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_002", "rw");
			RandomAccessFile num23Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_003", "rw");
			RandomAccessFile num32Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_004", "rw");
			RandomAccessFile bootsBin = new RandomAccessFile(dest + "\\unknow_00056.bin_000", "rw");
			RandomAccessFile teamConfigBin = new RandomAccessFile(dest + "\\unknow_00057.bin_000", "rw");
			RandomAccessFile formationsBin = new RandomAccessFile(dest + "\\unknow_00057.bin_001", "rw");
			RandomAccessFile nationalKitsBin = new RandomAccessFile(dest + "\\unknow_00058.bin_000", "rw");
			RandomAccessFile clubKitsBin = new RandomAccessFile(dest + "\\unknow_00058.bin_001", "rw");
			
			byte[] players = new byte[604128];
			byte[] slot23 = new byte[3450];
			byte[] slot32 = new byte[8896];
			byte[] num23 = new byte[1725];
			byte[] num32 = new byte[4448];
			
			byte[] teamConfig = new byte[1182];
			String teamConfigComplementString = "FFFFFFFFFF00020208020A01FFFFFFFFFF00FFFFFFFFFF00FFFFFFFFFF00FFFFFFFFFF00FFFFFFFFFF00FFFFFFFFFF00FFFFFFFFFF00";

			byte[] formations = new byte[10244];
			
			byte[] boot = new byte[828];
			
			byte[] nationalKits = new byte[30552];
			byte[] clubKits = new byte[84240];
					
			System.arraycopy(data, Player.startAdr, players, 0, players.length);
			System.arraycopy(data, Squads.slot23, slot23, 0, slot23.length);
			System.arraycopy(data, Squads.slot32, slot32, 0, slot32.length);
			System.arraycopy(data, Squads.num23, num23, 0, num23.length);
			System.arraycopy(data, Squads.num32, num32, 0, num32.length);
			System.arraycopy(data, Boots.startAdr, boot, 0, boot.length);
			System.arraycopy(temConfigBytes, 0, teamConfig, 0, teamConfig.length);
			System.arraycopy(formationsBytes, 0, formations, 0, formations.length);
			System.arraycopy(nationalBytes, 0, nationalKits, 0, nationalKits.length);
			System.arraycopy(clubBytes, 0, clubKits, 0, clubKits.length);
			playersBin.write(players);
			slot23Bin.write(slot23);
			slot32Bin.write(slot32);
			num23Bin.write(num23);
			num32Bin.write(num32);
			bootsBin.write(boot);
			teamConfigBin.write(teamConfig);
			teamConfigBin.write(hexStringToByteArray(teamConfigComplementString));
			formationsBin.write(formations);
			nationalKitsBin.write(nationalKits);
			clubKitsBin.write(clubKits);
			playersBin.close();
			slot23Bin.close();
			slot32Bin.close();
			num23Bin.close();
			num32Bin.close();
			teamConfigBin.close();
			formationsBin.close();
			bootsBin.close();
			nationalKitsBin.close();
			clubKitsBin.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}

	public boolean savePara13(File of2, String dest) {
		boolean done = true;
		try {
			byte[] formationsBytes = new byte[10244];
			byte[] temp = new byte[53];
			byte[] ok = new byte[52];
			for (int squad = 0; squad < 197; squad++) {
				System.arraycopy(data13, Formations.startAdr13 + 118 + (Formations.size * squad), temp, 0, 53);
				System.arraycopy(temp, 21, ok, 0, 10);
				System.arraycopy(temp, 0, ok, 10, 1);
				System.arraycopy(temp, 2, ok, 11, 1);
				System.arraycopy(temp, 4, ok, 12, 1);
				System.arraycopy(temp, 6, ok, 13, 1);
				System.arraycopy(temp, 8, ok, 14, 1);
				System.arraycopy(temp, 10, ok, 15, 1);
				System.arraycopy(temp, 12, ok, 16, 1);
				System.arraycopy(temp, 14, ok, 17, 1);
				System.arraycopy(temp, 16, ok, 18, 1);
				System.arraycopy(temp, 18, ok, 19, 1);
				System.arraycopy(temp, 1, ok, 20, 1);
				System.arraycopy(temp, 3, ok, 21, 1);
				System.arraycopy(temp, 5, ok, 22, 1);
				System.arraycopy(temp, 7, ok, 23, 1);
				System.arraycopy(temp, 9, ok, 24, 1);
				System.arraycopy(temp, 11, ok, 25, 1);
				System.arraycopy(temp, 13, ok, 26, 1);
				System.arraycopy(temp, 15, ok, 27, 1);
				System.arraycopy(temp, 17, ok, 28, 1);
				System.arraycopy(temp, 19, ok, 29, 1);
				System.arraycopy(temp, 31, ok, 30, 22);
				if (formationsBytes.length <= 10244)
					System.arraycopy(ok, 0, formationsBytes, (52 * squad), 52);
			}
			byte[] nationalBytes = new byte[30552];
			byte[] clubBytes = new byte[84240];
			byte[] emptyN = new byte[108];
			byte[] emptyC = new byte[300];
			for (int squad = 0; squad < 67; squad++) {
				System.arraycopy(data13, Kits.startAdrN13 + (Kits.sizeN * squad), nationalBytes, Kits.sizeN * squad, 348);
				System.arraycopy(emptyN, 0, nationalBytes, Kits.sizeN * squad + 348, 108);
			}
			for (int squad = 0; squad < 130; squad++) {
				System.arraycopy(data13, Kits.startAdrC13 + (Kits.sizeC * squad), clubBytes, Kits.sizeC * squad, 348);
				System.arraycopy(emptyC, 0, clubBytes, Kits.sizeC * squad + 348, 300);
			}
			RandomAccessFile playersBin = new RandomAccessFile(dest + "\\unknow_00047.bin_000", "rw");
			RandomAccessFile slot23Bin = new RandomAccessFile(dest + "\\unknow_00047.bin_001", "rw");
			RandomAccessFile slot32Bin = new RandomAccessFile(dest + "\\unknow_00047.bin_002", "rw");
			RandomAccessFile num23Bin = new RandomAccessFile(dest + "\\unknow_00047.bin_003", "rw");
			RandomAccessFile num32Bin = new RandomAccessFile(dest + "\\unknow_00047.bin_004", "rw");
			RandomAccessFile bootsBin = new RandomAccessFile(dest + "\\unknow_00052.bin_001", "rw");
			RandomAccessFile formationsBin = new RandomAccessFile(dest + "\\unknow_00053.bin_001", "rw");
			RandomAccessFile nationalKitsBin = new RandomAccessFile(dest + "\\unknow_00054.bin_000", "rw");
			RandomAccessFile clubKitsBin = new RandomAccessFile(dest + "\\unknow_00054.bin_001", "rw");
			byte[] players = new byte[604128];
			byte[] slot23 = new byte[3450];
			byte[] slot32 = new byte[8896];
			byte[] num23 = new byte[1725];
			byte[] num32 = new byte[4448];
			byte[] formations = new byte[10244];
			byte[] boot = new byte[828];
			byte[] nationalKits = new byte[30552];
			byte[] clubKits = new byte[84240];
			System.arraycopy(data13, Player.startAdr13, players, 0, players.length);
			System.arraycopy(data13, Squads.slot2313, slot23, 0, slot23.length);
			System.arraycopy(data13, Squads.slot3213, slot32, 0, slot32.length);
			System.arraycopy(data13, Squads.num2313, num23, 0, num23.length);
			System.arraycopy(data13, Squads.num3213, num32, 0, num32.length);
			System.arraycopy(data13, Boots.startAdr13, boot, 0, boot.length);
			System.arraycopy(formationsBytes, 0, formations, 0, formations.length);
			System.arraycopy(nationalBytes, 0, nationalKits, 0, nationalKits.length);
			System.arraycopy(clubBytes, 0, clubKits, 0, clubKits.length);
			playersBin.write(players);
			slot23Bin.write(slot23);
			slot32Bin.write(slot32);
			num23Bin.write(num23);
			num32Bin.write(num32);
			bootsBin.write(boot);
			formationsBin.write(formations);
			nationalKitsBin.write(nationalKits);
			clubKitsBin.write(clubKits);
			playersBin.close();
			slot23Bin.close();
			slot32Bin.close();
			num23Bin.close();
			num32Bin.close();
			formationsBin.close();
			bootsBin.close();
			nationalKitsBin.close();
			clubKitsBin.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}
	
	public boolean savePara12(File of2, String dest) {
		boolean done = true;
		try {
			byte[] formationsBytes = new byte[10504];
			byte[] temp = new byte[53];
			byte[] ok = new byte[52];
			for (int squad = 0; squad < 197; squad++) {
				System.arraycopy(data12, Formations.startAdr12 + 118 + (Formations.size * squad), temp, 0, 53);
				System.arraycopy(temp, 21, ok, 0, 10);
				System.arraycopy(temp, 0, ok, 10, 1);
				System.arraycopy(temp, 2, ok, 11, 1);
				System.arraycopy(temp, 4, ok, 12, 1);
				System.arraycopy(temp, 6, ok, 13, 1);
				System.arraycopy(temp, 8, ok, 14, 1);
				System.arraycopy(temp, 10, ok, 15, 1);
				System.arraycopy(temp, 12, ok, 16, 1);
				System.arraycopy(temp, 14, ok, 17, 1);
				System.arraycopy(temp, 16, ok, 18, 1);
				System.arraycopy(temp, 18, ok, 19, 1);
				System.arraycopy(temp, 1, ok, 20, 1);
				System.arraycopy(temp, 3, ok, 21, 1);
				System.arraycopy(temp, 5, ok, 22, 1);
				System.arraycopy(temp, 7, ok, 23, 1);
				System.arraycopy(temp, 9, ok, 24, 1);
				System.arraycopy(temp, 11, ok, 25, 1);
				System.arraycopy(temp, 13, ok, 26, 1);
				System.arraycopy(temp, 15, ok, 27, 1);
				System.arraycopy(temp, 17, ok, 28, 1);
				System.arraycopy(temp, 19, ok, 29, 1);
				System.arraycopy(temp, 31, ok, 30, 22);
				if (formationsBytes.length <= 10244)
					System.arraycopy(ok, 0, formationsBytes, (52 * squad), 52);
			}
			byte[] nationalBytes = new byte[30552];
			byte[] clubBytes = new byte[87480];
			byte[] emptyN = new byte[108];
			byte[] emptyC = new byte[300];
			for (int squad = 0; squad < 67; squad++) {
				System.arraycopy(data12, Kits.startAdrN12 + (Kits.sizeN * squad), nationalBytes, Kits.sizeN * squad, 348);
				System.arraycopy(emptyN, 0, nationalBytes, Kits.sizeN * squad + 348, 108);
			}
			for (int squad = 0; squad < 130; squad++) {
				System.arraycopy(data12, Kits.startAdrC12 + (Kits.sizeC * squad), clubBytes, Kits.sizeC * squad, 348);
				System.arraycopy(emptyC, 0, clubBytes, Kits.sizeC * squad + 348, 300);
			}
			RandomAccessFile playersBin = new RandomAccessFile(dest + "\\unknow_00051.bin_000", "rw");
			RandomAccessFile slot23Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_001", "rw");
			RandomAccessFile slot32Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_002", "rw");
			RandomAccessFile num23Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_003", "rw");
			RandomAccessFile num32Bin = new RandomAccessFile(dest + "\\unknow_00051.bin_004", "rw");
			//RandomAccessFile bootsBin = new RandomAccessFile(dest + "\\unknow_00052.bin_001", "rw");
			RandomAccessFile formationsBin = new RandomAccessFile(dest + "\\unknow_00057.bin_001", "rw");
			RandomAccessFile nationalKitsBin = new RandomAccessFile(dest + "\\unknow_00058.bin_000", "rw");
			RandomAccessFile clubKitsBin = new RandomAccessFile(dest + "\\unknow_00058.bin_001", "rw");
			byte[] players = new byte[612684];
			byte[] slot23 = new byte[3450];
			byte[] slot32 = new byte[9280];
			byte[] num23 = new byte[1725];
			byte[] num32 = new byte[4640];
			byte[] formations = new byte[10504];
			//byte[] boot = new byte[828];
			byte[] nationalKits = new byte[30552];
			byte[] clubKits = new byte[87480];
			System.arraycopy(data12, Player.startAdr12, players, 0, players.length);
			System.arraycopy(data12, Squads.slot2312, slot23, 0, slot23.length);
			System.arraycopy(data12, Squads.slot3212, slot32, 0, slot32.length);
			System.arraycopy(data12, Squads.num2312, num23, 0, num23.length);
			System.arraycopy(data12, Squads.num3212, num32, 0, num32.length);
			//System.arraycopy(data13, 648720, boot, 0, 828);
			System.arraycopy(formationsBytes, 0, formations, 0, formations.length);
			System.arraycopy(nationalBytes, 0, nationalKits, 0, nationalKits.length);
			System.arraycopy(clubBytes, 0, clubKits, 0, clubKits.length);
			playersBin.write(players);
			slot23Bin.write(slot23);
			slot32Bin.write(slot32);
			num23Bin.write(num23);
			num32Bin.write(num32);
			//bootsBin.write(boot);
			formationsBin.write(formations);
			nationalKitsBin.write(nationalKits);
			clubKitsBin.write(clubKits);
			playersBin.close();
			slot23Bin.close();
			slot32Bin.close();
			num23Bin.close();
			num32Bin.close();
			formationsBin.close();
			//bootsBin.close();
			nationalKitsBin.close();
			clubKitsBin.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}

	public boolean savePara11(File of2, String dest) {
		boolean done = true;
		try {
			byte[] formationsBytes = new byte[10660];
			byte[] temp = new byte[53];
			byte[] ok = new byte[52];
			for (int squad = 0; squad < 197; squad++) {
				System.arraycopy(data11, Formations.startAdr11 + 118 + (Formations.size * squad), temp, 0, 53);
				System.arraycopy(temp, 21, ok, 0, 10);
				System.arraycopy(temp, 0, ok, 10, 1);
				System.arraycopy(temp, 2, ok, 11, 1);
				System.arraycopy(temp, 4, ok, 12, 1);
				System.arraycopy(temp, 6, ok, 13, 1);
				System.arraycopy(temp, 8, ok, 14, 1);
				System.arraycopy(temp, 10, ok, 15, 1);
				System.arraycopy(temp, 12, ok, 16, 1);
				System.arraycopy(temp, 14, ok, 17, 1);
				System.arraycopy(temp, 16, ok, 18, 1);
				System.arraycopy(temp, 18, ok, 19, 1);
				System.arraycopy(temp, 1, ok, 20, 1);
				System.arraycopy(temp, 3, ok, 21, 1);
				System.arraycopy(temp, 5, ok, 22, 1);
				System.arraycopy(temp, 7, ok, 23, 1);
				System.arraycopy(temp, 9, ok, 24, 1);
				System.arraycopy(temp, 11, ok, 25, 1);
				System.arraycopy(temp, 13, ok, 26, 1);
				System.arraycopy(temp, 15, ok, 27, 1);
				System.arraycopy(temp, 17, ok, 28, 1);
				System.arraycopy(temp, 19, ok, 29, 1);
				System.arraycopy(temp, 31, ok, 30, 22);
				if (formationsBytes.length <= 10244)
					System.arraycopy(ok, 0, formationsBytes, (52 * squad), 52);
			}
			byte[] nationalBytes = new byte[30552];
			byte[] clubBytes = new byte[89424];
			byte[] emptyN = new byte[108];
			byte[] emptyC = new byte[300];
			for (int squad = 0; squad < 67; squad++) {
				System.arraycopy(data11, Kits.startAdrN11 + (Kits.sizeN * squad), nationalBytes, Kits.sizeN * squad, 348);
				System.arraycopy(emptyN, 0, nationalBytes, Kits.sizeN * squad + 348, 108);
			}
			for (int squad = 0; squad < 130; squad++) {
				System.arraycopy(data11, Kits.startAdrC11 + (Kits.sizeC * squad), clubBytes, Kits.sizeC * squad, 348);
				System.arraycopy(emptyC, 0, clubBytes, Kits.sizeC * squad + 348, 300);
			}
			RandomAccessFile playersBin = new RandomAccessFile(dest + "\\unknow_00045.bin_000", "rw");
			RandomAccessFile slot23Bin = new RandomAccessFile(dest + "\\unknow_00045.bin_001", "rw");
			RandomAccessFile slot32Bin = new RandomAccessFile(dest + "\\unknow_00045.bin_002", "rw");
			RandomAccessFile num23Bin = new RandomAccessFile(dest + "\\unknow_00045.bin_003", "rw");
			RandomAccessFile num32Bin = new RandomAccessFile(dest + "\\unknow_00045.bin_004", "rw");
			RandomAccessFile bootsBin = new RandomAccessFile(dest + "\\unknow_00050.bin_001", "rw");
			RandomAccessFile formationsBin = new RandomAccessFile(dest + "\\unknow_00051.bin_001", "rw");
			RandomAccessFile nationalKitsBin = new RandomAccessFile(dest + "\\unknow_00052.bin_000", "rw");
			RandomAccessFile clubKitsBin = new RandomAccessFile(dest + "\\unknow_00052.bin_001", "rw");
			byte[] players = new byte[627812];
			byte[] slot23 = new byte[3450];
			byte[] slot32 = new byte[9280];
			byte[] num23 = new byte[1725];
			byte[] num32 = new byte[4640];
			byte[] formations = new byte[10660];
			byte[] boot = new byte[828];
			byte[] nationalKits = new byte[30552];
			byte[] clubKits = new byte[89424];
			System.arraycopy(data11, Player.startAdr11, players, 0, players.length);
			System.arraycopy(data11, Squads.slot2311, slot23, 0, slot23.length);
			System.arraycopy(data11, Squads.slot3211, slot32, 0, slot32.length);
			System.arraycopy(data11, Squads.num2311, num23, 0, num23.length);
			System.arraycopy(data11, Squads.num3211, num32, 0, num32.length);
			System.arraycopy(data13, 663912, boot, 0, 828);
			System.arraycopy(formationsBytes, 0, formations, 0, formations.length);
			System.arraycopy(nationalBytes, 0, nationalKits, 0, nationalKits.length);
			System.arraycopy(clubBytes, 0, clubKits, 0, clubKits.length);
			playersBin.write(players);
			slot23Bin.write(slot23);
			slot32Bin.write(slot32);
			num23Bin.write(num23);
			num32Bin.write(num32);
			bootsBin.write(boot);
			formationsBin.write(formations);
			nationalKitsBin.write(nationalKits);
			clubKitsBin.write(clubKits);
			playersBin.close();
			slot23Bin.close();
			slot32Bin.close();
			num23Bin.close();
			num32Bin.close();
			formationsBin.close();
			bootsBin.close();
			nationalKitsBin.close();
			clubKitsBin.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}


	public boolean savePara10(File of2, String dest) {
		boolean done = true;
		try {
			byte[] formationsBytes = new byte[10504];
			byte[] temp = new byte[53];
			byte[] ok = new byte[52];
			for (int squad = 0; squad < 197; squad++) {
				System.arraycopy(data10, Formations.startAdr10 + 118 + (Formations.size * squad), temp, 0, 53);
				System.arraycopy(temp, 21, ok, 0, 10);
				System.arraycopy(temp, 0, ok, 10, 1);
				System.arraycopy(temp, 2, ok, 11, 1);
				System.arraycopy(temp, 4, ok, 12, 1);
				System.arraycopy(temp, 6, ok, 13, 1);
				System.arraycopy(temp, 8, ok, 14, 1);
				System.arraycopy(temp, 10, ok, 15, 1);
				System.arraycopy(temp, 12, ok, 16, 1);
				System.arraycopy(temp, 14, ok, 17, 1);
				System.arraycopy(temp, 16, ok, 18, 1);
				System.arraycopy(temp, 18, ok, 19, 1);
				System.arraycopy(temp, 1, ok, 20, 1);
				System.arraycopy(temp, 3, ok, 21, 1);
				System.arraycopy(temp, 5, ok, 22, 1);
				System.arraycopy(temp, 7, ok, 23, 1);
				System.arraycopy(temp, 9, ok, 24, 1);
				System.arraycopy(temp, 11, ok, 25, 1);
				System.arraycopy(temp, 13, ok, 26, 1);
				System.arraycopy(temp, 15, ok, 27, 1);
				System.arraycopy(temp, 17, ok, 28, 1);
				System.arraycopy(temp, 19, ok, 29, 1);
				System.arraycopy(temp, 31, ok, 30, 22);
				if (formationsBytes.length <= 10244)
					System.arraycopy(ok, 0, formationsBytes, (52 * squad), 52);
			}
			byte[] nationalBytes = new byte[29480];
			byte[] clubBytes = new byte[87216];
			byte[] emptyN = new byte[108];
			byte[] emptyC = new byte[300];
			for (int squad = 0; squad < 67; squad++) {
				System.arraycopy(data10, Kits.startAdrN10 + (Kits.sizeN * squad), nationalBytes, Kits.sizeN * squad, 348);
				System.arraycopy(emptyN, 0, nationalBytes, Kits.sizeN * squad + 348, 108);
			}
			for (int squad = 0; squad < 130; squad++) {
				System.arraycopy(data10, Kits.startAdrC10 + (Kits.sizeC * squad), clubBytes, Kits.sizeC * squad, 348);
				System.arraycopy(emptyC, 0, clubBytes, Kits.sizeC * squad + 348, 300);
			}
			RandomAccessFile playersBin = new RandomAccessFile(dest + "\\unknow_00033.bin_000", "rw");
			RandomAccessFile slot23Bin = new RandomAccessFile(dest + "\\unknow_00033.bin_001", "rw");
			RandomAccessFile slot32Bin = new RandomAccessFile(dest + "\\unknow_00033.bin_002", "rw");
			RandomAccessFile num23Bin = new RandomAccessFile(dest + "\\unknow_00033.bin_003", "rw");
			RandomAccessFile num32Bin = new RandomAccessFile(dest + "\\unknow_00033.bin_004", "rw");
			RandomAccessFile formationsBin = new RandomAccessFile(dest + "\\unknow_00037.bin_001", "rw");
			RandomAccessFile nationalKitsBin = new RandomAccessFile(dest + "\\unknow_00038.bin_000", "rw");
			RandomAccessFile clubKitsBin = new RandomAccessFile(dest + "\\unknow_00038.bin_001", "rw");
			byte[] players = new byte[622604];
			byte[] slot23 = new byte[3450];
			byte[] slot32 = new byte[9344];
			byte[] num23 = new byte[1725];
			byte[] num32 = new byte[4672];
			byte[] formations = new byte[10504];
			byte[] nationalKits = new byte[29480];
			byte[] clubKits = new byte[87216];
			System.arraycopy(data10, Player.startAdr10, players, 0, players.length);
			System.arraycopy(data10, Squads.slot2310, slot23, 0, slot23.length);
			System.arraycopy(data10, Squads.slot3210, slot32, 0, slot32.length);
			System.arraycopy(data10, Squads.num2310, num23, 0, num23.length);
			System.arraycopy(data10, Squads.num3210, num32, 0, num32.length);
			System.arraycopy(formationsBytes, 0, formations, 0, formations.length);
			System.arraycopy(nationalBytes, 0, nationalKits, 0, nationalKits.length);
			System.arraycopy(clubBytes, 0, clubKits, 0, clubKits.length);
			playersBin.write(players);
			slot23Bin.write(slot23);
			slot32Bin.write(slot32);
			num23Bin.write(num23);
			num32Bin.write(num32);
			formationsBin.write(formations);
			nationalKitsBin.write(nationalKits);
			clubKitsBin.write(clubKits);
			playersBin.close();
			slot23Bin.close();
			slot32Bin.close();
			num23Bin.close();
			num32Bin.close();
			formationsBin.close();
			nationalKitsBin.close();
			clubKitsBin.close();
		} catch (Exception e) {
			e.printStackTrace();
			done = false;
		}
		return done;
	}

	
	public byte toByte(int i) {
		byte b;
		if (i > 127) {
			b = (byte) (i - 256);
		} else {
			b = (byte) i;
		}
		return b;
	}

	public int toInt(byte b) {
		int i = b;
		if (i < 0) {
			i = i + 256;
		}
		return i;
	}
	private void decrypt() {
		for (int i = 1; i < block.length; i++) {
			int k = 0;
			for (int a = block[i]; a + 4 <= block[i] + blockSize[i]; a = a + 4) {
				int c = byteToInt(data, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data[a] = toByte(p & 0x000000FF);
				data[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}
		}
	}
	private void nodecrypt() {{}}
	private void decrypt13() {
		for (int i = 1; i < block13.length; i++) {
			int k = 0;
			for (int a = block13[i]; a + 4 <= block13[i] + blockSize13[i]; a = a + 4) {
				int c = byteToInt(data13, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data13[a] = toByte(p & 0x000000FF);
				data13[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data13[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data13[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt12() {
		for (int i = 1; i < block12.length; i++) {
			int k = 0;
			for (int a = block12[i]; a + 4 <= block12[i] + blockSize12[i]; a = a + 4) {
				int c = byteToInt(data12, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data12[a] = toByte(p & 0x000000FF);
				data12[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data12[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data12[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt11() {
		for (int i = 1; i < block11.length; i++) {
			int k = 0;
			for (int a = block11[i]; a + 4 <= block11[i] + blockSize11[i]; a = a + 4) {
				int c = byteToInt(data11, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data11[a] = toByte(p & 0x000000FF);
				data11[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data11[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data11[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt10() {
		for (int i = 1; i < block10.length; i++) {
			int k = 0;
			for (int a = block10[i]; a + 4 <= block10[i] + blockSize10[i]; a = a + 4) {
				int c = byteToInt(data10, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data10[a] = toByte(p & 0x000000FF);
				data10[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data10[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data10[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt09() {
		for (int i = 1; i < block09.length; i++) {
			int k = 0;
			for (int a = block09[i]; a + 4 <= block09[i] + blockSize09[i]; a = a + 4) {
				int c = byteToInt(data09, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data09[a] = toByte(p & 0x000000FF);
				data09[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data09[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data09[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt08() {
		for (int i = 1; i < block08.length; i++) {
			int k = 0;
			for (int a = block08[i]; a + 4 <= block08[i] + blockSize08[i]; a = a + 4) {
				int c = byteToInt(data08, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data08[a] = toByte(p & 0x000000FF);
				data08[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data08[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data08[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt6() {
		for (int i = 1; i < block6.length; i++) {
			int k = 0;
			for (int a = block6[i]; a + 4 <= block6[i] + blockSize6[i]; a = a + 4) {
				int c = byteToInt(data6, a);
				int p = ((c - key[k]) + 0x7ab3684c) ^ 0x7ab3684c;
				data6[a] = toByte(p & 0x000000FF);
				data6[a + 1] = toByte((p >>> 8) & 0x000000FF);
				data6[a + 2] = toByte((p >>> 16) & 0x000000FF);
				data6[a + 3] = toByte((p >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}

		}
	}

	private void decrypt5() {
		for (int i = 1; i < 10; i++) {
			int k = 0;
			for (int a = block5[i]; a < block5[i] + blockSize5[i]; a = a + 4) {
				int c = byteToInt5(a);
				int p = c - key5[k] + 1815549477 ^ 0x6C371625;
				data5[a] = toByte(p & 0xFF);
				data5[(a + 1)] = toByte(p >>> 8 & 0xFF);
				data5[(a + 2)] = toByte(p >>> 16 & 0xFF);
				data5[(a + 3)] = toByte(p >>> 24 & 0xFF);
				k++;
				if (k == 367) {
					k = 0;
				}
			}

		}
	}

	private void encrypt() {
		for (int i = 1; i < block.length; i++) {
			int k = 0;
			for (int a = block[i]; a + 4 <= block[i] + blockSize[i]; a = a + 4) {
				int p = byteToInt(data, a);
				int c = key[k] + ((p ^ 0x7ab3684c) - 0x7ab3684c);
				data[a] = toByte(c & 0x000000FF);
				data[a + 1] = toByte((c >>> 8) & 0x000000FF);
				data[a + 2] = toByte((c >>> 16) & 0x000000FF);
				data[a + 3] = toByte((c >>> 24) & 0x000000FF);
				k++;
				if (k == 446) {
					k = 0;
				}
			}
		}
	}
	
	private void encryptD() {
		
	}

	private int byteToInt(byte[] ba, int a) {
		int[] temp = new int[4];
		temp[0] = toInt(ba[a]);
		temp[1] = toInt(ba[a + 1]);
		temp[2] = toInt(ba[a + 2]);
		temp[3] = toInt(ba[a + 3]);
		int p = temp[0] | (temp[1] << 8) | (temp[2] << 16) | (temp[3] << 24);
		return p;
	}

	private int byteToInt5(int paramInt) {
		int[] arrayOfInt = new int[4];
		arrayOfInt[0] = toInt(data5[paramInt]);
		arrayOfInt[1] = toInt(data5[(paramInt + 1)]);
		arrayOfInt[2] = toInt(data5[(paramInt + 2)]);
		arrayOfInt[3] = toInt(data5[(paramInt + 3)]);
		int i = arrayOfInt[0] | arrayOfInt[1] << 8 | arrayOfInt[2] << 16 | arrayOfInt[3] << 24;
		return i;
	}

	public void checkSums() {
		for (int i = 0; i < block.length; i++) {
			int chk = 0;
			for (int a = block[i]; a + 4 <= block[i] + blockSize[i]; a = a + 4) {
				chk = chk + byteToInt(data, a);
			}
			data[block[i] - 8] = toByte(chk & 0x000000FF);
			data[block[i] - 7] = toByte((chk >>> 8) & 0x000000FF);
			data[block[i] - 6] = toByte((chk >>> 16) & 0x000000FF);
			data[block[i] - 5] = toByte((chk >>> 24) & 0x000000FF);
		}
	}

	public void saveData() {
		try {
			File f = new File("datadump");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData13() {
		try {
			File f = new File("datadump13");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data13);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData12() {
		try {
			File f = new File("datadump12");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data12);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData11() {
		try {
			File f = new File("datadump11");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data11);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData10() {
		try {
			File f = new File("datadump10");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data10);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData09() {
		try {
			File f = new File("datadump09");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data09);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData08() {
		try {
			File f = new File("datadump08");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data08);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData6() {
		try {
			File f = new File("datadump6");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data6);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public void saveData5() {
		try {
			File f = new File("datadump5");
			RandomAccessFile out = new RandomAccessFile(f, "rw"); out.write(data5);
			out.close(); }
		catch (Exception e)
		{
		}
	}

	public byte[] getBytes(int i) {
		byte[] bytes = new byte[2];
		bytes[0] = toByte(i & 0xFF);
		bytes[1] = toByte((i >>> 8) & 0xFF);
		return bytes;
	}

	public byte[] getBytesInt(int i) {
		byte[] bytes = new byte[4];
		bytes[0] = toByte(i & 0xFF);
		bytes[1] = toByte((i >>> 8) & 0xFF);
		bytes[2] = toByte((i >>> 16) & 0xFF);
		bytes[3] = toByte((i >>> 24) & 0xFF);
		return bytes;
	}

	public static boolean isPS2pes(String s) {
		
		//if (s.startsWith("BESLES-") && s.endsWith("2013OPT") || s.endsWith("3013OPT")) {
		if (s.startsWith("BESLES-") && s.endsWith("2014OPT") || s.endsWith("3014OPT")) { //text
			return true;
		}

		//if (s.startsWith("BASLUS-") && s.endsWith("2013OPT")) {
		if (s.startsWith("BASLUS-") && s.endsWith("2014OPT")) { //text
			return true;
		}

		return false;
	}

	public static boolean isPS2pes13(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("2013OPT") || s.endsWith("3013OPT")) { //text
			return true;
		}
		if (s.startsWith("BASLUS-") && s.endsWith("2013OPT")) { //text
			return true;
		}
		return false;
	}

	public static boolean isPS2pes12(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("2012OPT")) { //text
			return true;
		}
		if (s.startsWith("BASLUS-") && s.endsWith("2012OPT")) { //text
			return true;
		}
		return false;
	}

	public static boolean isPS2pes11(String s) {
	if (s.startsWith("BESLES-") && s.endsWith("2011OPT")) { //text
		return true;
	}
	if (s.equals("BASLUS-219182010OPT")) { //text
		return true;
	}
	return false;
	}

	public static boolean isPS2pes10(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("2010OPT")) { //text
			return true;
		}
		if (s.equals("BASLUS-219182010OPT")) { //text
			return true;
		}
		return false;
	}

	public static boolean isPS2pes09(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("P2K9OPT")) { //text
			return true;
		}
		if (s.equals("BASLUS-21821P2K9OPT")) { //text
			return true;
		}
		return false;
	}

	public static boolean isPS2pes08(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("P2K8OPT")) { //text
			return true;
		}
		if (s.equals("BASLUS-21685P2K8OPT")) { //text
			return true;
		}
		return false;
	}

	public static boolean isPS2pes6(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("PES6OPT")) { //text
			return true;
		}
		if (s.equals("BASLUS-21464W2K7OPT")) { //text
			return true;
		}
		return false;
	}

	public static boolean isPS2pes5(String s) {
		if (s.startsWith("BESLES-") && s.endsWith("PES5OPT")) { //text
			return true;
		}
		return false;
	}

	/*
	 * public boolean isWE() { if (gameID.equals("BASLUS-21464W2K7OPT") ||
	 * gameID.equals("PC_WE")) { return true; } return false; }
	 */

}
