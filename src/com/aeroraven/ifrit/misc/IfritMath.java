package com.aeroraven.ifrit.misc;

import com.aeroraven.ifrit.core.*;
import com.aeroraven.ifrit.constant.*;
import java.util.*;

public class IfritMath {
	public static double getEculideanDist(IfritVectord v1,IfritVectord v2) {
		double dist=0.;
		int dimensions = v1.getDim();
		for(int i=0;i<dimensions;i++) {
			double delta = v1.get(i)-v2.get(i);
			dist = dist + delta*delta;
		}
		return Math.sqrt(dist);
	}
	public static double getHamiltonDist(IfritVectord v1,IfritVectord v2) {
		double dist=0.;
		int dimensions = v1.getDim();
		for(int i=0;i<dimensions;i++) {
			double delta = v1.get(i)-v2.get(i);
			dist = dist + Math.abs(delta);
		}
		return Math.sqrt(dist);
	}
	public static IfritVectord findApproximatePoint(IfritVectord src,ArrayList<IfritVectord> dst) {
		double shortestDist = 9E+100;
		int bestIdx = 0;
		int n=dst.size();
		for(int i=0;i<n;i++) {
			double dist=getEculideanDist(src,dst.get(i));
			if(dist<shortestDist) {
				shortestDist=dist;
				bestIdx=i;
			}
		}
		return dst.get(bestIdx);
	}
	public static int findApproximatePointIdx(IfritVectord src,ArrayList<IfritVectord> dst) {
		double shortestDist = 9E+100;
		int bestIdx = 0;
		int n=dst.size();
		for(int i=0;i<n;i++) {
			double dist=getEculideanDist(src,dst.get(i));
			if(dist<shortestDist) {
				shortestDist=dist;
				bestIdx=i;
			}
		}
		return bestIdx;
	}
	public static int findApproximatePointIdxH(IfritVectord src,ArrayList<IfritVectord> dst) {
		double shortestDist = 9E+100;
		int bestIdx = 0;
		int n=dst.size();
		for(int i=0;i<n;i++) {
			double dist=getHamiltonDist(src,dst.get(i));
			if(dist<shortestDist) {
				shortestDist=dist;
				bestIdx=i;
			}
		}
		return bestIdx;
	}
	public static IfritColor16 findApporximateColor(IfritVectord colvec3) {
		ArrayList<IfritVectord> colorset = new ArrayList<IfritVectord>();
		ArrayList<IfritColor16> colorset_n = new ArrayList<IfritColor16>();
		for(IfritColor16 i:IfritColor16.values()) {
			colorset.add(IfritEnumConverter.Col16toVec3(i));
			colorset_n.add(i);
		}
		return colorset_n.get(findApproximatePointIdxH(colvec3,colorset));
	}
	public static IfritVectord convertCol4to3(IfritVectord colvec4) {
		IfritVectord colvec3 = new IfritVectord(colvec4.get(0),colvec4.get(1),colvec4.get(2));
		return colvec3;
	}
	public static boolean isVectorEqual(IfritVectord a,IfritVectord b) {
		if(a.getDim()!=b.getDim()) {
			return false;
		}
		for(int i=0;i<a.getDim();i++) {
			if((double)a.get(i)!=(double)b.get(i)) {
				return false;
			}
		}
		return true;
	}
}
