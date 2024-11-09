package es.caib.avaedi.at4forms.front.util;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class ImageConstraints {

	public static final int NOT_VALIDATED = 0;
	public static final int VALID = 1;
	public static final int INVALID = 2;
	public static final int WARNING = 3;

	int xRecommended, yRecommended;
	boolean xRecommendedMandatory, yRecommendedMandatory;
	int xMax, yMax;
	boolean xMaxMandatory, yMaxMandatory;
	int xMin, yMin;
	boolean xMinMandatory, yMinMandatory;
	
	public ImageConstraints (
			int xrec, int yrec, boolean xRecommendedMandatory, boolean yRecommendedMandatory, 
			int xmax, int ymax, boolean xMaxMandatory, boolean yMaxMandatory, 
			int xmin, int ymin, boolean xMinMandatory, boolean yMinMandatory
			) {
		
		this.setXRecommended(xrec);
		this.setYRecommended(yrec);
		this.setXRecommendedMandatory(xRecommendedMandatory);
		this.setYRecommendedMandatory(yRecommendedMandatory);
		this.setXMax(xmax);
		this.setYMax(ymax);
		this.setXMaxMandatory(xMaxMandatory);
		this.setYMaxMandatory(yMaxMandatory);
		this.setXMin(xmin);
		this.setYMin(ymin);
		this.setXMinMandatory(xMinMandatory);
		this.setYMinMandatory(yMinMandatory);
	}

	public ImageConstraints (
			int xmax, int ymax, boolean xMaxMandatory, boolean yMaxMandatory, 
			int xmin, int ymin, boolean xMinMandatory, boolean yMinMandatory
			) {
		
		this.setXMax(xmax);
		this.setYMax(ymax);
		this.setXMaxMandatory(xMaxMandatory);
		this.setYMaxMandatory(yMaxMandatory);
		this.setXMin(xmin);
		this.setYMin(ymin);
		this.setXMinMandatory(xMinMandatory);
		this.setYMinMandatory(yMinMandatory);
	}

	public ImageConstraints (int xrec, int yrec, boolean xRecommendedMandatory, boolean yRecommendedMandatory ) {
		
		this.setXRecommended(xrec);
		this.setYRecommended(yrec);
		this.setXRecommendedMandatory(xRecommendedMandatory);
		this.setYRecommendedMandatory(yRecommendedMandatory);
	}
	
	public ImageConstraints() {
	}

	/**
	 * @return the xRecommended
	 */
	public int getXRecommended() {
		return xRecommended;
	}

	/**
	 * @param recommended the xRecommended to set
	 */
	public void setXRecommended(int recommended) {
		xRecommended = recommended;
	}

	/**
	 * @return the yRecommended
	 */
	public int getYRecommended() {
		return yRecommended;
	}

	/**
	 * @param recommended the yRecommended to set
	 */
	public void setYRecommended(int recommended) {
		yRecommended = recommended;
	}

	/**
	 * @return the xRecommendedMandatory
	 */
	public boolean isXRecommendedMandatory() {
		return xRecommendedMandatory;
	}

	/**
	 * @param recommendedMandatory the xRecommendedMandatory to set
	 */
	public void setXRecommendedMandatory(boolean recommendedMandatory) {
		xRecommendedMandatory = recommendedMandatory;
	}

	/**
	 * @return the yRecommendedMandatory
	 */
	public boolean isYRecommendedMandatory() {
		return yRecommendedMandatory;
	}

	/**
	 * @param recommendedMandatory the yRecommendedMandatory to set
	 */
	public void setYRecommendedMandatory(boolean recommendedMandatory) {
		yRecommendedMandatory = recommendedMandatory;
	}

	/**
	 * @return the xMax
	 */
	public int getXMax() {
		return xMax;
	}

	/**
	 * @param max the xMax to set
	 */
	public void setXMax(int max) {
		xMax = max;
	}

	/**
	 * @return the yMax
	 */
	public int getYMax() {
		return yMax;
	}

	/**
	 * @param max the yMax to set
	 */
	public void setYMax(int max) {
		yMax = max;
	}

	/**
	 * @return the xMaxMandatory
	 */
	public boolean isXMaxMandatory() {
		return xMaxMandatory;
	}

	/**
	 * @param maxMandatory the xMaxMandatory to set
	 */
	public void setXMaxMandatory(boolean maxMandatory) {
		xMaxMandatory = maxMandatory;
	}

	/**
	 * @return the yMaxMandatory
	 */
	public boolean isYMaxMandatory() {
		return yMaxMandatory;
	}

	/**
	 * @param maxMandatory the yMaxMandatory to set
	 */
	public void setYMaxMandatory(boolean maxMandatory) {
		yMaxMandatory = maxMandatory;
	}

	/**
	 * @return the xMin
	 */
	public int getXMin() {
		return xMin;
	}

	/**
	 * @param min the xMin to set
	 */
	public void setXMin(int min) {
		xMin = min;
	}

	/**
	 * @return the yMin
	 */
	public int getYMin() {
		return yMin;
	}

	/**
	 * @param min the yMin to set
	 */
	public void setYMin(int min) {
		yMin = min;
	}

	/**
	 * @return the xMinMandatory
	 */
	public boolean isXMinMandatory() {
		return xMinMandatory;
	}

	/**
	 * @param minMandatory the xMinMandatory to set
	 */
	public void setXMinMandatory(boolean minMandatory) {
		xMinMandatory = minMandatory;
	}

	/**
	 * @return the yMinMandatory
	 */
	public boolean isYMinMandatory() {
		return yMinMandatory;
	}

	/**
	 * @param minMandatory the yMinMandatory to set
	 */
	public void setYMinMandatory(boolean minMandatory) {
		yMinMandatory = minMandatory;
	}
	
}