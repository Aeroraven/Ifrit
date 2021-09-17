package com.aeroraven.ifrit.misc;

import com.aeroraven.ifrit.constant.*;
import com.aeroraven.ifrit.core.*;

public class IfritEnumConverter {
	public static IfritVectord Col16toVec3(IfritColor16 arg) {
		switch(arg) {
		case BLACK:
			return new IfritVectord(0.,0.,0.);
		case RED:
			return new IfritVectord(127.,0.,0.);
		case GREEN:
			return new IfritVectord(0.,127.,0.);
		case BLUE:
			return new IfritVectord(0.,0.,127.);
		case YELLOW:
			return new IfritVectord(127.,127.,0.);
		case MAGENTA:
			return new IfritVectord(127.,0.,127.);
		case CYAN:
			return new IfritVectord(0.,127.,127.);
		case GRAY:
			return new IfritVectord(192.,192.,192.);
		case LIGHT_RED:
			return new IfritVectord(255.,0.,0.);
		case LIGHT_GREEN:
			return new IfritVectord(0.,255.,0.);
		case LIGHT_BLUE:
			return new IfritVectord(0.,0.,255.);
		case LIGHT_YELLOW:
			return new IfritVectord(255.,255.,0.);
		case LIGHT_MAGENTA:
			return new IfritVectord(255.,0.,255.);
		case LIGHT_CYAN:
			return new IfritVectord(0.,255.,255.);
		case WHITE:
			return new IfritVectord(255.,255.,255.);
		default:
			return new IfritVectord(255.,255.,255.);
		}
	}
	public static int Col16toWin32Int(IfritColor16 arg) {
		switch(arg) {
		case BLACK:
			return 0;
		case RED:
			return 4;
		case GREEN:
			return 2;
		case BLUE:
			return 1;
		case YELLOW:
			return 6;
		case MAGENTA:
			return 5;
		case CYAN:
			return 3;
		case GRAY:
			return 7;
		case LIGHT_RED:
			return 0xc;
		case LIGHT_GREEN:
			return 0xa;
		case LIGHT_BLUE:
			return 0x9;
		case LIGHT_YELLOW:
			return 0xe;
		case LIGHT_MAGENTA:
			return 0xd;
		case LIGHT_CYAN:
			return 0xb;
		case WHITE:
			return 0xf;
		default:
			return 0xf;
		}
	}
}
