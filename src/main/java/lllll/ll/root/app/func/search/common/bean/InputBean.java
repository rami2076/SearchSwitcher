package lllll.ll.root.app.func.search.common.bean;

import lllll.ll.root.app.func.search.common.enumeration.SearchConditionalPattern;

public class InputBean {

	/** TargetKana */
	private String searchTargetName;
	/** nameCondition */
	private SearchConditionalPattern nameCondition;
	/** TargetKana */
	private String searchTargetKana;
	/** kanaCondition */
	private SearchConditionalPattern kanaCondition;


	//以降　getterとsetter

	/**
	 *
	 *
	 * @return tyoe String SearchTargetName
	 */
	public String getSearchTargetName() {
		return searchTargetName;
	}

	/**
	 * @param searchTargetName
	 */
	public void setSearchTargetName(String searchTargetName) {
		this.searchTargetName = searchTargetName;
	}

	/**
	 * @return tyoe SearchConditionalPattern NameCondition
	 */
	public SearchConditionalPattern getNameCondition() {
		return nameCondition;
	}

	/**
	 * @param nameCondition
	 */
	public void setNameCondition(SearchConditionalPattern nameCondition) {
		this.nameCondition = nameCondition;
	}

	/**
	 * @return
	 */
	public String getSearchTargetKana() {
		return searchTargetKana;
	}

	/**
	 * @param searchTargetKana
	 */
	public void setSearchTargetKana(String searchTargetKana) {
		this.searchTargetKana = searchTargetKana;
	}

	/**
	 * @return
	 */
	public SearchConditionalPattern getKanaCondition() {
		return kanaCondition;
	}

	/**
	 * @param kanaCondition
	 */
	public void setKanaCondition(SearchConditionalPattern kanaCondition) {
		this.kanaCondition = kanaCondition;
	}

}
