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

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Emblems {
	static final byte total = 30; //offset

	//static final int startAdr = 914800;
	static final int startAdr = 905872; //offset

	static final int size = 5184; //offset

	static final int paletteSize = 128; //offset

	static final int raster = 4096; //offset

	static final byte totalB = 60; //offset

	// static final int startAdrB = 1167500;

	static final int sizeB = 2176; //offset

	static final int paletteSizeB = 16; //offset

	static final int rasterB = 2048; //offset

	static final int startAdr13 = 914800;

	static final int startAdr12 = 925928;

	static final int startAdr11 = 939560;

	static final int startAdr10 = 931096;

	static final int startAdr09 = 906780;

	static final int startAdr08 = 938652;

	static final byte total6 = 50;
	static final int startAdr6 = 911308;
	static final byte totalB6 = 100;

	static final byte total5 = 50;
	static final int startAdr5 = 969356;
	static final byte totalB5 = 100;

	/*
	 * static boolean flag128Here(OptionFile of, int slot) { boolean used =
	 * false; if (of.data[startAdr + (slot size)] == 1) { used = true; } return
	 * used; }
	 * 
	 * static boolean flag16Here(OptionFile of, int slot) { boolean used =
	 * false; if (of.data[(startAdr + (49 size)) - ((slot / 2) size) + ((slot %
	 * 2) sizeB)] == 1) { used = true; } return used; }
	 */

	static Image get128(OptionFile of, int slot, boolean opaque, boolean small) {
		byte[] red = new byte[paletteSize];
		byte[] green = new byte[paletteSize];
		byte[] blue = new byte[paletteSize];
		byte[] alpha = new byte[paletteSize];
		byte[] pixel = new byte[raster];
		int a;
		if (of.version6) {
			if (slot >= 0 && slot < total6) {
				for (int c = 0; c < paletteSize; c++) {
					a = startAdr6 + 64 + (slot * size) + (c * 4);
					red[c] = of.data6[a];
					green[c] = of.data6[a + 1];
					blue[c] = of.data6[a + 2];
					alpha[c] = of.data6[a + 3];
				}
				a = startAdr6 + 1088 + (slot * size);
				System.arraycopy(of.data6, a, pixel, 0, raster);
				if (opaque) {
					for (int i = 0; i < paletteSize; i++) {
						alpha[i] = -1;
					}
				}
			}
		} if (of.version5) {
			if (slot >= 0 && slot < total5) {
				for (int c = 0; c < paletteSize; c++) {
					a = startAdr5 + 64 + (slot * size) + (c * 4);
					red[c] = of.data5[a];
					green[c] = of.data5[a + 1];
					blue[c] = of.data5[a + 2];
					alpha[c] = of.data5[a + 3];
				}
				a = startAdr5 + 1088 + (slot * size);
				System.arraycopy(of.data5, a, pixel, 0, raster);
				if (opaque) {
					for (int i = 0; i < paletteSize; i++) {
						alpha[i] = -1;
					}
				}
			}
		} else {
			if (slot >= 0 && slot < total) {
				for (int c = 0; c < paletteSize; c++) {
					if (of.newVersion) {
						a = startAdr + 64 + (slot * size) + (c * 4);
						red[c] = of.data[a];
						green[c] = of.data[a + 1];
						blue[c] = of.data[a + 2];
						alpha[c] = of.data[a + 3];
					} else if (of.version13) {
						a = startAdr13 + 64 + (slot * size) + (c * 4);
						red[c] = of.data13[a];
						green[c] = of.data13[a + 1];
						blue[c] = of.data13[a + 2];
						alpha[c] = of.data13[a + 3];
					} else if (of.version12) {
						a = startAdr12 + 64 + (slot * size) + (c * 4);
						red[c] = of.data12[a];
						green[c] = of.data12[a + 1];
						blue[c] = of.data12[a + 2];
						alpha[c] = of.data12[a + 3];
					} else if (of.version11) {
						a = startAdr11 + 64 + (slot * size) + (c * 4);
						red[c] = of.data11[a];
						green[c] = of.data11[a + 1];
						blue[c] = of.data11[a + 2];
						alpha[c] = of.data11[a + 3];
					} else if (of.version10) {
						a = startAdr10 + 64 + (slot * size) + (c * 4);
						red[c] = of.data10[a];
						green[c] = of.data10[a + 1];
						blue[c] = of.data10[a + 2];
						alpha[c] = of.data10[a + 3];
					} else if (of.version09) {
						a = startAdr09 + 64 + (slot * size) + (c * 4);
						red[c] = of.data09[a];
						green[c] = of.data09[a + 1];
						blue[c] = of.data09[a + 2];
						alpha[c] = of.data09[a + 3];
					} else if (of.version08) {
						a = startAdr08 + 64 + (slot * size) + (c * 4);
						red[c] = of.data08[a];
						green[c] = of.data08[a + 1];
						blue[c] = of.data08[a + 2];
						alpha[c] = of.data08[a + 3];
					}
				}
				if (of.newVersion) {
					a = startAdr + 1088 + (slot * size);
					System.arraycopy(of.data, a, pixel, 0, raster);
				} else if (of.version13) {
					a = startAdr13 + 1088 + (slot * size);
					System.arraycopy(of.data13, a, pixel, 0, raster);
				} else if (of.version12) {
					a = startAdr12 + 1088 + (slot * size);
					System.arraycopy(of.data12, a, pixel, 0, raster);
				} else if (of.version11) {
					a = startAdr11 + 1088 + (slot * size);
					System.arraycopy(of.data11, a, pixel, 0, raster);
				} else if (of.version10) {
					a = startAdr10 + 1088 + (slot * size);
					System.arraycopy(of.data10, a, pixel, 0, raster);
				} else if (of.version09) {
					a = startAdr09 + 1088 + (slot * size);
					System.arraycopy(of.data09, a, pixel, 0, raster);
				} else if (of.version08) {
					a = startAdr08 + 1088 + (slot * size);
					System.arraycopy(of.data08, a, pixel, 0, raster);
				}
				if (opaque) {
					for (int i = 0; i < paletteSize; i++) {
						alpha[i] = -1;
					}
				}
			}
		}
		IndexColorModel colorModel = new IndexColorModel(8, paletteSize, red,
				green, blue, alpha);
		DataBufferByte dbuf = new DataBufferByte(pixel, raster, 0);
		MultiPixelPackedSampleModel sampleModel = new MultiPixelPackedSampleModel(
				DataBuffer.TYPE_BYTE, 64, 64, 8);
		WritableRaster rasters = Raster.createWritableRaster(sampleModel, dbuf,
				null);
		BufferedImage bi = new BufferedImage(colorModel, rasters, false, null);
		Image image;
		if (small) {
			image = bi.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
		} else {
			image = bi;
		}
		return image;
	}

	static Image get16(OptionFile of, int slot, boolean opaque, boolean small) {
		byte[] red = new byte[paletteSizeB];
		byte[] green = new byte[paletteSizeB];
		byte[] blue = new byte[paletteSizeB];
		byte[] alpha = new byte[paletteSizeB];
		byte[] pixel = new byte[rasterB];
		int a;
		int startPos = 0;
		if (of.newVersion)
			startPos = (startAdr + ((total - 1) * size)) - ((slot / 2) * size)
				+ ((slot % 2) * sizeB);
		else if (of.version13)
			startPos = (startAdr13 + ((total - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version12)
			startPos = (startAdr12 + ((total - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version11)
			startPos = (startAdr11 + ((total - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version10)
			startPos = (startAdr10 + ((total - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version09)
			startPos = (startAdr09 + ((total - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version08)
			startPos = (startAdr08 + ((total - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version6)
			startPos = (startAdr6 + ((total6 - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		else if (of.version5)
			startPos = (startAdr5 + ((total5 - 1) * size)) - ((slot / 2) * size)
			+ ((slot % 2) * sizeB);
		// System.out.println(startPos);
		if (of.version6) {
			if (slot >= 0 && slot < totalB6) {
				for (int c = 0; c < paletteSizeB; c++) {
					a = startPos + 64 + (c * 4);
					red[c] = of.data6[a];
					green[c] = of.data6[a + 1];
					blue[c] = of.data6[a + 2];
					alpha[c] = of.data6[a + 3];
				}
				a = startPos + 128;
				System.arraycopy(of.data6, a, pixel, 0, rasterB);
				if (opaque) {
					for (int i = 0; i < paletteSizeB; i++) {
						alpha[i] = -1;
					}
				}
			}
		} else if (of.version5) {
			if (slot >= 0 && slot < totalB5) {
				for (int c = 0; c < paletteSizeB; c++) {
					a = startPos + 64 + (c * 4);
					red[c] = of.data5[a];
					green[c] = of.data5[a + 1];
					blue[c] = of.data5[a + 2];
					alpha[c] = of.data5[a + 3];
				}
				a = startPos + 128;
				System.arraycopy(of.data5, a, pixel, 0, rasterB);
				if (opaque) {
					for (int i = 0; i < paletteSizeB; i++) {
						alpha[i] = -1;
					}
				}
			}
		} else {
			if (slot >= 0 && slot < totalB) {
				for (int c = 0; c < paletteSizeB; c++) {
					a = startPos + 64 + (c * 4);
					if (of.newVersion) {
						red[c] = of.data[a];
						green[c] = of.data[a + 1];
						blue[c] = of.data[a + 2];
						alpha[c] = of.data[a + 3];
					} else if (of.version13) {
						red[c] = of.data13[a];
						green[c] = of.data13[a + 1];
						blue[c] = of.data13[a + 2];
						alpha[c] = of.data13[a + 3];
					} else if (of.version12) {
						red[c] = of.data12[a];
						green[c] = of.data12[a + 1];
						blue[c] = of.data12[a + 2];
						alpha[c] = of.data12[a + 3];
					} else if (of.version11) {
						red[c] = of.data11[a];
						green[c] = of.data11[a + 1];
						blue[c] = of.data11[a + 2];
						alpha[c] = of.data11[a + 3];
					} else if (of.version10) {
						red[c] = of.data10[a];
						green[c] = of.data10[a + 1];
						blue[c] = of.data10[a + 2];
						alpha[c] = of.data10[a + 3];
					} else if (of.version09) {
						red[c] = of.data09[a];
						green[c] = of.data09[a + 1];
						blue[c] = of.data09[a + 2];
						alpha[c] = of.data09[a + 3];
					} else if (of.version08) {
						red[c] = of.data08[a];
						green[c] = of.data08[a + 1];
						blue[c] = of.data08[a + 2];
						alpha[c] = of.data08[a + 3];
					}
				}
				a = startPos + 128;
				if (of.newVersion)
					System.arraycopy(of.data, a, pixel, 0, rasterB);
				else if (of.version13)
					System.arraycopy(of.data13, a, pixel, 0, rasterB);
				else if (of.version12)
					System.arraycopy(of.data12, a, pixel, 0, rasterB);
				else if (of.version11)
					System.arraycopy(of.data11, a, pixel, 0, rasterB);
				else if (of.version10)
					System.arraycopy(of.data10, a, pixel, 0, rasterB);
				else if (of.version09)
					System.arraycopy(of.data09, a, pixel, 0, rasterB);
				else if (of.version08)
					System.arraycopy(of.data08, a, pixel, 0, rasterB);
				if (opaque) {
					for (int i = 0; i < paletteSizeB; i++) {
						alpha[i] = -1;
					}
				}
			}
		}
		IndexColorModel colorModel = new IndexColorModel(4, paletteSizeB, red,
				green, blue, alpha);
		DataBufferByte dbuf = new DataBufferByte(pixel, rasterB, 0);
		MultiPixelPackedSampleModel sampleModel = new MultiPixelPackedSampleModel(
				DataBuffer.TYPE_BYTE, 64, 64, 4);
		WritableRaster rasters = Raster.createWritableRaster(sampleModel, dbuf,
				null);
		BufferedImage bi = new BufferedImage(colorModel, rasters, false, null);
		Image image;
		if (small) {
			image = bi.getScaledInstance(32, 32, Image.SCALE_DEFAULT);
		} else {
			image = bi;
		}
		return image;
	}

	static boolean set128(OptionFile of, int slot, BufferedImage image) {
		boolean ok = false;
		try {
			byte[] red = new byte[256];
			byte[] green = new byte[256];
			byte[] blue = new byte[256];
			byte[] alpha = new byte[256];
			int[] pix = new int[raster];
			int a;
			Raster rast = image.getData();
			ColorModel colorMod = image.getColorModel();

			if (colorMod instanceof IndexColorModel) {
				IndexColorModel index = (IndexColorModel) colorMod;
				if (image.getWidth() == 64 && image.getHeight() == 64) {
					rast.getPixels(0, 0, 64, 64, pix);
					index.getReds(red);
					index.getGreens(green);
					index.getBlues(blue);
					index.getAlphas(alpha);

					if (alpha[0] != 0) {
						int swap = 0;
						byte tr;
						byte tg;
						byte tb;
						byte ta;
						for (int c = 1; c < 128; c++) {
							if (swap == 0 && alpha[c] == 0) {
								swap = c;
							}
						}
						if (swap != 0) {
							tr = red[0];
							tg = green[0];
							tb = blue[0];
							ta = alpha[0];
							// System.out.println(red[3] + ", " + green[3] + ",
							// " + blue[3]);
							red[0] = red[swap];
							green[0] = green[swap];
							blue[0] = blue[swap];
							alpha[0] = 0;
							red[swap] = tr;
							green[swap] = tg;
							blue[swap] = tb;
							alpha[swap] = ta;

							for (int p = 0; p < raster; p++) {
								if (pix[p] == 0) {
									pix[p] = swap;
								} else if (pix[p] == swap) {
									pix[p] = 0;
								}
							}
							// System.out.println(swap);
						}
					}

					for (int c = 0; c < paletteSize; c++) {
						a = startAdr + 64 + (slot * size) + (c * 4);
						of.data[a] = red[c];
						of.data[a + 1] = green[c];
						of.data[a + 2] = blue[c];
						of.data[a + 3] = alpha[c];
						if (alpha[c] != -1) {
						}
					}

					for (int p = 0; p < raster; p++) {
						a = startAdr + 1088 + (slot * size) + p;
						of.data[a] = of.toByte(pix[p]);
					}
					of.data[startAdr + (slot * size)] = 1;

					if (slot == count128(of)) {
						setCount128(of, (byte) (count128(of) + 1));

					boolean done = false;
					for (int i = 0; !done && i < total; i++) {
							a = startAdr - 98 + i;
							if (of.data[a] == 93) {
								of.data[a] = of.toByte(slot);
								int id = Clubs.firstFlag + i;
								System.arraycopy(of.getBytes(id), 0, of.data,
										startAdr + (slot * size) + 4, 2);
							}
						}
						ok = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	static boolean set16(OptionFile of, int slot, BufferedImage image) {
		boolean ok = false;
		try {
			byte[] red = new byte[256];
			byte[] green = new byte[256];
			byte[] blue = new byte[256];
			byte[] alpha = new byte[256];
			int[] pix = new int[raster];
			int a;
			int startPos = 0;
				startPos= (startAdr + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
			Raster rast = image.getData();
			ColorModel colorMod = image.getColorModel();

			if (colorMod instanceof IndexColorModel) {
				IndexColorModel index = (IndexColorModel) colorMod;
				if (image.getWidth() == 64 && image.getHeight() == 64) {
					rast.getPixels(0, 0, 64, 64, pix);
					index.getReds(red);
					index.getGreens(green);
					index.getBlues(blue);
					index.getAlphas(alpha);

					if (alpha[0] != 0) {
						int swap = 0;
						byte tr;
						byte tg;
						byte tb;
						byte ta;
						for (int c = 1; c < 16; c++) {
							if (swap == 0 && alpha[c] == 0) {
								swap = c;
							}
						}
						if (swap != 0) {
							tr = red[0];
							tg = green[0];
							tb = blue[0];
							ta = alpha[0];
							// System.out.println(red[3] + ", " + green[3] + ",
							// " + blue[3]);
							red[0] = red[swap];
							green[0] = green[swap];
							blue[0] = blue[swap];
							alpha[0] = 0;
							red[swap] = tr;
							green[swap] = tg;
							blue[swap] = tb;
							alpha[swap] = ta;

							for (int p = 0; p < raster; p++) {
								if (pix[p] == 0) {
									pix[p] = swap;
								} else if (pix[p] == swap) {
									pix[p] = 0;
								}
							}
							// System.out.println(swap);
						}
					}

					for (int c = 0; c < paletteSizeB; c++) {
						a = startPos + 64 + (c * 4);
						of.data[a] = red[c];
						of.data[a + 1] = green[c];
						of.data[a + 2] = blue[c];
						of.data[a + 3] = alpha[c];
						if (alpha[c] != -1) {
						}
					}

					for (int p = 0; p < raster; p = p + 2) {
						a = startPos + 128 + (p / 2);
						of.data[a] = of.toByte((pix[p] << 4) | (pix[p + 1]));
					}
					of.data[startPos] = 1;

					if (slot == count16(of)) {
						setCount16(of, (byte) (count16(of) + 1));

						boolean done = false;
						for (int i = 0; !done && i < totalB; i++) {
							a = startAdr - 68 + i;
							if (of.data[a] == 93) {
								of.data[a] = of.toByte(total + slot);
								int id = Clubs.firstFlag + total + i;
								System.arraycopy(of.getBytes(id), 0, of.data,
										startPos + 4, 2);
							}
							done = true;
						}
					}
					ok = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	/*
	 * static void importFlag(OptionFile ofS, int slotS, OptionFile ofD, int
	 * slotD) { int aS = startAdr + (slotS size); int aD = startAdr + (slotD
	 * size); System.arraycopy(ofS.data, aS, ofD.data, aD, size); }
	 */

	static byte count128(OptionFile of) {
		if (of.newVersion)
			return of.data[startAdr - 100];
		else if (of.version13)
			return of.data13[startAdr13 - 100];
		else if (of.version12)
			return of.data12[startAdr12 - 100];
		else if (of.version11)
			return of.data11[startAdr11 - 100];
		else if (of.version10)
			return of.data10[startAdr10 - 100];
		else if (of.version09)
			return of.data09[startAdr09 - 100];
		else if (of.version08)
			return of.data08[startAdr08 - 100];
		else if (of.version6)
			return of.data6[startAdr6 - 160];
		else if (of.version5)
			return of.data5[startAdr5 - 160];
		return 0;
	}

	static byte count16(OptionFile of) {
		if (of.newVersion)
			return of.data[startAdr - 99];
		else if (of.version13)
			return of.data13[startAdr13 - 99];
		else if (of.version12)
			return of.data12[startAdr12 - 99];
		else if (of.version11)
			return of.data11[startAdr11 - 99];
		else if (of.version10)
			return of.data10[startAdr10 - 99];
		else if (of.version09)
			return of.data09[startAdr09 - 99];
		else if (of.version08)
			return of.data08[startAdr08 - 99];
		else if (of.version6)
			return of.data6[startAdr6 - 159];
		else if (of.version5)
			return of.data5[startAdr5 - 159];
		return 0;
	}

	static void setCount16(OptionFile of, byte c) {
		if (of.newVersion)
			of.data[startAdr - 99] = c;
		else if (of.version13)
			of.data13[startAdr13 - 99] = c;
		else if (of.version12)
			of.data12[startAdr12 - 99] = c;
		else if (of.version11)
			of.data11[startAdr11 - 99] = c;
		else if (of.version10)
			of.data10[startAdr10 - 99] = c;
		else if (of.version09)
			of.data09[startAdr09 - 99] = c;
		else if (of.version08)
			of.data08[startAdr08 - 99] = c;
		else if (of.version6)
			of.data6[startAdr6 - 159] = c;
		else if (of.version5)
			of.data6[startAdr5 - 159] = c;
	}

	static void setCount128(OptionFile of, byte c) {
		if (of.newVersion)
			of.data[startAdr - 100] = c;
		else if (of.version13)
			of.data13[startAdr13 - 100] = c;
		else if (of.version12)
			of.data12[startAdr12 - 100] = c;
		else if (of.version11)
			of.data11[startAdr11 - 100] = c;
		else if (of.version10)
			of.data10[startAdr10 - 100] = c;
		else if (of.version09)
			of.data09[startAdr09 - 100] = c;
		else if (of.version08)
			of.data08[startAdr08 - 100] = c;
		else if (of.version6)
			of.data6[startAdr6 - 160] = c;
		else if (of.version5)
			of.data6[startAdr5 - 160] = c;
	}

	static byte getFree16(OptionFile of) {
		if (of.version6)
			return (byte) (totalB6 - (count128(of) * 2) - count16(of));
		else if (of.version5)
			return (byte) (totalB5 - (count128(of) * 2) - count16(of));
		else
			return (byte) (totalB - (count128(of) * 2) - count16(of));
	}

	static byte getFree128(OptionFile of) {
		if (of.version6)
			return (byte) ((totalB6 - (count128(of) * 2) - count16(of)) / 2);
		else if (of.version5)
			return (byte) ((totalB5 - (count128(of) * 2) - count16(of)) / 2);
		else
			return (byte) ((totalB - (count128(of) * 2) - count16(of)) / 2);
	}

	static Image getImage(OptionFile of, int e) {
		Image image = null;
		int a = 0;
		if (of.newVersion)
			a = startAdr - 98 + e;
		else if (of.version13)
			a = startAdr13 - 98 + e;
		else if (of.version12)
			a = startAdr12 - 98 + e;
		else if (of.version11)
			a = startAdr11 - 98 + e;
		else if (of.version10)
			a = startAdr10 - 98 + e;
		else if (of.version09)
			a = startAdr09 - 98 + e;
		else if (of.version08)
			a = startAdr08 - 98 + e;
		else if (of.version6)
			a = startAdr6 - 98 + e;
		else if (of.version5)
			a = startAdr5 - 158 + e;
		if (of.version6) {
			if (e < total6) {
				image = get128(of, of.data6[a], false, false);
			} else {
				int slot = of.toInt(of.data6[a]) - total6;
				image = get16(of, slot, false, false);
			}
		} else if (of.version5) {
			if (e < total5) {
				image = get128(of, of.data5[a], false, false);
			} else {
				int slot = of.toInt(of.data5[a]) - total5;
				image = get16(of, slot, false, false);
			}
		} else {
			if (e < total) {
				if (of.newVersion)
					image = get128(of, of.data[a], false, false);
				else if (of.version13)
					image = get128(of, of.data13[a], false, false);
				else if (of.version12)
					image = get128(of, of.data12[a], false, false);
				else if (of.version11)
					image = get128(of, of.data11[a], false, false);
				else if (of.version10)
					image = get128(of, of.data10[a], false, false);
				else if (of.version09)
					image = get128(of, of.data09[a], false, false);
				else if (of.version08)
					image = get128(of, of.data08[a], false, false);
			} else {
				int slot = 0;
				if (of.newVersion)
					slot = of.toInt(of.data[a]) - total;
				else if (of.version13)
					slot = of.toInt(of.data13[a]) - total;
				else if (of.version12)
					slot = of.toInt(of.data12[a]) - total;
				else if (of.version11)
					slot = of.toInt(of.data11[a]) - total;
				else if (of.version10)
					slot = of.toInt(of.data10[a]) - total;
				else if (of.version09)
					slot = of.toInt(of.data09[a]) - total;
				else if (of.version08)
					slot = of.toInt(of.data08[a]) - total;
				image = get16(of, slot, false, false);
			}
		}
		return image;
	}

	static int getLoc(OptionFile of, int e) {
		int a = 0;
		if (of.newVersion)
			a = startAdr - 98 + e;
		else if (of.version13)
			a = startAdr13 - 98 + e;
		else if (of.version12)
			a = startAdr12 - 98 + e;
		else if (of.version11)
			a = startAdr11 - 98 + e;
		else if (of.version10)
			a = startAdr10 - 98 + e;
		else if (of.version09)
			a = startAdr09 - 98 + e;
		else if (of.version08)
			a = startAdr08 - 98 + e;
		else if (of.version6)
			a = startAdr6 - 158 + e;
		else if (of.version5)
			a = startAdr5 - 158 + e;
		if (of.newVersion)
			return of.toInt(of.data[a]);
		else if (of.version13)
			return of.toInt(of.data13[a]);
		else if (of.version12)
			return of.toInt(of.data12[a]);
		else if (of.version11)
			return of.toInt(of.data11[a]);
		else if (of.version10)
			return of.toInt(of.data10[a]);
		else if (of.version09)
			return of.toInt(of.data09[a]);
		else if (of.version08)
			return of.toInt(of.data08[a]);
		else if (of.version6)
			return of.toInt(of.data6[a]);
		else if (of.version5)
			return of.toInt(of.data5[a]);
		return (Integer) null;
	}

	static void deleteImage(OptionFile of, int e) {
		int a = startAdr - 98 + e;
		if (e < total) {
			delete128(of, of.data[a]);
		} else {
			int slot = of.toInt(of.data[a]) - total;
			delete16(of, slot);
		}
	}

	static byte[] getIndex(OptionFile of, int slot) {
		byte[] index = new byte[2];
		if (of.version6) {
			if (slot < total6) {
				System.arraycopy(of.data6, startAdr6 + (slot * size) + 4, index, 0,
						2);
			} else {
				slot = slot - total6;
				int startPos = 0;
				startPos = (startAdr6 + ((total6 - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				System.arraycopy(of.data6, startPos + 4, index, 0, 2);
			}
		} else if (of.version5) {
			if (slot < total5) {
				System.arraycopy(of.data5, startAdr5 + (slot * size) + 4, index, 0,
						2);
			} else {
				slot = slot - total5;
				int startPos = 0;
				startPos = (startAdr5 + ((total5 - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				System.arraycopy(of.data5, startPos + 4, index, 0, 2);
			}
		} else {
			if (slot < total) {
				if (of.newVersion)
					System.arraycopy(of.data, startAdr + (slot * size) + 4, index, 0,
								2);
				else if (of.version13)
					System.arraycopy(of.data13, startAdr13 + (slot * size) + 4, index, 0,
							2);
				else if (of.version12)
					System.arraycopy(of.data12, startAdr12 + (slot * size) + 4, index, 0,
							2);
				else if (of.version11)
					System.arraycopy(of.data11, startAdr11 + (slot * size) + 4, index, 0,
							2);
				else if (of.version10)
					System.arraycopy(of.data10, startAdr10 + (slot * size) + 4, index, 0,
							2);
				else if (of.version09)
					System.arraycopy(of.data09, startAdr09 + (slot * size) + 4, index, 0,
							2);
				else if (of.version08)
					System.arraycopy(of.data08, startAdr08 + (slot * size) + 4, index, 0,
							2);
			} else {
				slot = slot - total;
				int startPos = 0;
				if (of.newVersion)
					startPos = (startAdr + ((total - 1) * size))
						- ((slot / 2) * size) + ((slot % 2) * sizeB);
				else if (of.version13)
					startPos = (startAdr13 + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				else if (of.version12)
					startPos = (startAdr12 + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				else if (of.version11)
					startPos = (startAdr11 + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				else if (of.version10)
					startPos = (startAdr10 + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				else if (of.version09)
					startPos = (startAdr09 + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				else if (of.version08)
					startPos = (startAdr08 + ((total - 1) * size))
					- ((slot / 2) * size) + ((slot % 2) * sizeB);
				if (of.newVersion)
					System.arraycopy(of.data, startPos + 4, index, 0, 2);
				else if (of.version13)
					System.arraycopy(of.data13, startPos + 4, index, 0, 2);
				else if (of.version12)
					System.arraycopy(of.data12, startPos + 4, index, 0, 2);
				else if (of.version11)
					System.arraycopy(of.data11, startPos + 4, index, 0, 2);
				else if (of.version10)
					System.arraycopy(of.data10, startPos + 4, index, 0, 2);
				else if (of.version09)
					System.arraycopy(of.data09, startPos + 4, index, 0, 2);
				else if (of.version08)
					System.arraycopy(of.data08, startPos + 4, index, 0, 2);
			}
		}
		return index;
	}

	static void delete16(OptionFile of, int slot) {
		byte[] index = getIndex(of, slot + total);

		int si = getInt(of, index) - (Clubs.firstFlag + total);
		of.data[startAdr - 68 + si] = 93;
		Clubs.unAssEmblem(of, si + total);
		/*
		 * for (int i = 0; i < 138; i++) { byte[] tb = new byte[2]; int a =
		 * 797484 + 6236 + (i 140); int sa = 797492 + 6236 + (i 140); int d =
		 * 111 + i; System.arraycopy(of.data, a, tb, 0 , 2); if (tb[0] ==
		 * index[0] && tb[1] == index[1]) { System.arraycopy(of.getBytes(d), 0,
		 * of.data, a, 2); System.arraycopy(of.getBytes(d), 0, of.data, a + 4,
		 * 2); of.data[sa] = 0; of.data[sa + 1] = 0; } }
		 */
		int source = (startAdr + ((total - 1) * size))
				- (((count16(of) - 1) / 2) * size)
				+ (((count16(of) - 1) % 2) * sizeB);
		if (slot != count16(of) - 1) {

			int dest = (startAdr + ((total - 1) * size))
					- (((slot) / 2) * size) + ((slot % 2) * sizeB);
			System.arraycopy(of.data, source, of.data, dest, sizeB);
			si = getInt(of, getIndex(of, slot + total))
					- (Clubs.firstFlag + total);
			of.data[startAdr - 68 + si] = of.toByte(slot + total);
		}

		for (int i = source; i < source + sizeB; i++) {
			of.data[i] = 0;
		}
		setCount16(of, of.toByte(count16(of) - 1));
	}

	static void delete128(OptionFile of, int slot) {
		byte[] index = getIndex(of, slot);
		int si = getInt(of, index) - Clubs.firstFlag;
		of.data[startAdr - 98 + si] = 93;
		Clubs.unAssEmblem(of, si);
		/*
		 * for (int i = 0; i < 138; i++) { byte[] tb = new byte[2]; int a =
		 * 797484 + 6236 + (i 140); int sa = 797492 + 6236 + (i 140); int d =
		 * 111 + i; System.arraycopy(of.data, a, tb, 0 , 2); if (tb[0] ==
		 * index[0] && tb[1] == index[1]) { System.arraycopy(of.getBytes(d), 0,
		 * of.data, a, 2); System.arraycopy(of.getBytes(d), 0, of.data, a + 4,
		 * 2); of.data[sa] = 0; of.data[sa + 1] = 0; } }
		 */
		int source = startAdr + ((count128(of) - 1) * size);
		if (slot != count128(of) - 1) {
			int dest = startAdr + (slot * size);
			System.arraycopy(of.data, source, of.data, dest, size);
			si = getInt(of, getIndex(of, slot)) - Clubs.firstFlag;
			of.data[startAdr - 98 + si] = of.toByte(slot);
		}

		for (int i = source; i < source + size; i++) {
			of.data[i] = 0;
		}
		setCount128(of, of.toByte(count128(of) - 1));
	}

	static int getInt(OptionFile of, byte[] b) {
		int i = 0;
		if (b.length == 2) {
			i = (of.toInt(b[1]) << 8) | (of.toInt(b[0]) & 0xFF);
		}
		return i;
	}

	static void import16(OptionFile of1, int slot1, OptionFile of2, int slot2) {
		int startPos1 = (startAdr + ((total - 1) * size))
				- ((slot1 / 2) * size) + ((slot1 % 2) * sizeB);
		int startPos2;
		if (of2.newVersion) {
			startPos2 = (startAdr + ((total - 1) * size))
				- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version13) {
			startPos2 = (startAdr13 + ((total - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data13, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version12) {
			startPos2 = (startAdr12 + ((total - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data12, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version11) {
			startPos2 = (startAdr11 + ((total - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data11, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version10) {
			startPos2 = (startAdr10 + ((total - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data10, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version09) {
			startPos2 = (startAdr09 + ((total - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data09, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version08) {
			startPos2 = (startAdr08 + ((total - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data08, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version6) {
			startPos2 = (startAdr6 + ((total6 - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data6, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		} else if (of2.version5) {
			startPos2 = (startAdr5 + ((total5 - 1) * size))
			- ((slot2 / 2) * size) + ((slot2 % 2) * sizeB);
			System.arraycopy(of2.data5, startPos2 + 64, of1.data, startPos1 + 64,
					sizeB - 64);
		}

		if (slot1 == count16(of1)) {
			of1.data[startPos1] = 1;
			setCount16(of1, (byte) (count16(of1) + 1));

			boolean done = false;
			for (int i = 0; !done && i < totalB; i++) {
				int a = startAdr - 68 + i;
				if (of1.data[a] == 93) {
					of1.data[a] = of1.toByte(total + slot1);
					int id = (Clubs.firstFlag + total) + i;
					System.arraycopy(of1.getBytes(id), 0, of1.data,
							startPos1 + 4, 2);
					done = true;
				}
			}
		}
	}

	static void import128(OptionFile of1, int slot1, OptionFile of2, int slot2) {
		int startPos1 = startAdr + (slot1 * size);
		int startPos2;
		if (of2.newVersion) {
			startPos2 = startAdr + (slot2 * size);
			System.arraycopy(of2.data, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version13) {
			startPos2 = startAdr13 + (slot2 * size);
			System.arraycopy(of2.data13, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version12) {
			startPos2 = startAdr12 + (slot2 * size);
			System.arraycopy(of2.data12, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version11) {
			startPos2 = startAdr11 + (slot2 * size);
			System.arraycopy(of2.data11, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version10) {
			startPos2 = startAdr10 + (slot2 * size);
			System.arraycopy(of2.data10, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version09) {
			startPos2 = startAdr09 + (slot2 * size);
			System.arraycopy(of2.data09, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version08) {
			startPos2 = startAdr08 + (slot2 * size);
			System.arraycopy(of2.data08, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version6) {
			startPos2 = startAdr6 + (slot2 * size);
			System.arraycopy(of2.data6, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		} else if (of2.version5) {
			startPos2 = startAdr5 + (slot2 * size);
			System.arraycopy(of2.data5, startPos2 + 64, of1.data, startPos1 + 64,
					size - 64);
		}

		if (slot1 == count128(of1)) {
			of1.data[startPos1] = 1;
			setCount128(of1, (byte) (count128(of1) + 1));
			boolean done = false;
			for (int i = 0; !done && i < total; i++) {
				int a = startAdr - 98 + i;
				if (of1.data[a] == 93) {
					of1.data[a] = of1.toByte(slot1);
					int id = Clubs.firstFlag + i;
					System.arraycopy(of1.getBytes(id), 0, of1.data,
							startPos1 + 4, 2);
					done = true;
				}
			}
		}
	}

}
