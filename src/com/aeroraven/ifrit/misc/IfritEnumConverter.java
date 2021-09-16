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
			return new IfritVectord(127.,127.,127.);
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
}
