package lllll.ll.root.app.func.search.common.contol;

import lllll.ll.root.app.func.search.common.bean.InputBean;
import lllll.ll.root.app.func.search.common.enumeration.Pattern;
import lllll.ll.root.app.func.search.common.enumeration.SearchConditionalPattern;

public class SerchContol {

	/*
	 * 氏名とカナはアンド条件
	 *
	 * 1 氏名 2カナ 3氏名の検索条件 4カナの検索条件
	 *
	 * Forward,Backward,Partial,Perfect
	 *
	 */

	InputBean inputBean = new InputBean();;

	public void setup(String[] args) throws InstantiationException, IllegalAccessException {

		// 処理の選択*今回は処理は一つだけ。
		// 検索機能はS
		// 受取
		// 分離
		// valid
		// 状態決定
		// daoへ

		// ここまで情報が来ていると仮定する。
		String[] str = args;
		String jobName = str[0];
		String targetnName = str[1];
		String targetnKana = str[2];
		String pattern_name = str[3];
		String pattern_kana = str[4];

		inputBean.setNameCondition(getpattern(pattern_name));
		inputBean.setKanaCondition(getpattern(pattern_kana));
		inputBean.setSearchTargetName(targetnName);
		inputBean.setSearchTargetKana(targetnKana);

		Pattern pattern=getState(inputBean);


		//以下はSQL処置クラスで行ってもよいのではと考えている。
		//渡す前にするかどうか審議中。
		switch(pattern){
		case N_Back_K_BACK:
		case N_Back_K_Front:
		case N_Back_K_Nothing:
		case N_Back_K_Partial:
		case N_Back_K_Perfect:
		case N_Front_K_BACK:
		case N_Front_K_Front:
		case N_Front_K_Nothing:
		case N_Front_K_Partial:
		case N_Front_K_Perfect:
		case N_Nothing_K_BACK:
		case N_Nothing_K_Front:
		case N_Nothing_K_Nothing:
		case N_Nothing_K_Partial:
		case N_Nothing_K_Perfect:
		case N_Partial_K_BACK:
		case N_Partial_K_Front:
		case N_Partial_K_Nothing:
		case N_Partial_K_Partial:
		case N_Partial_K_Perfect:
		case N_Perfect_K_BACK:
		case N_Perfect_K_Front:
		case N_Perfect_K_Nothing:
		case N_Perfect_K_Partial:
		case N_Perfect_K_Perfect:

		}



	}

	private SearchConditionalPattern getpattern(String inputPattern) {

		switch (inputPattern) {
		case "Forward":
			return SearchConditionalPattern.Forward_Matching;

		case "Backward":
			return SearchConditionalPattern.Backward_Matching;

		case "Partial":
			return SearchConditionalPattern.Partial_Matching;

		case "Perfect":
			return SearchConditionalPattern.Perfect_Matching;

		}
		return null;

	}

	/*
	 * //NFornt、 N_Front_K_Front, N_Front_K_BACK, N_Front_K_Partial,
	 * N_Front_K_Perfect, N_Front_K_Nothing, //NBack N_Back_K_Front,
	 * N_Back_K_BACK, N_Back_K_Partial, N_Back_K_Perfect, N_Back_K_Nothing,
	 * //NPartial N_Partial_K_Front, N_Partial_K_BACK, N_Partial_K_Partial,
	 * N_Partial_K_Perfect, N_Partial_K_Nothing, //NPerfect N_Perfect_K_Front,
	 * N_Perfect_K_BACK, N_Perfect_K_Partial, N_Perfect_K_Perfect,
	 * N_Perfect_K_Nothing, //NNothing N_Nothing_K_Front, N_Nothing_K_BACK,
	 * N_Nothing_K_Partial, N_Nothing_K_Perfect, N_Nothing_K_Nothing,
	 */

	public Pattern getState(InputBean inputBean) {
		// なし なし
		if (inputBean.getSearchTargetName().isEmpty() && inputBean.getSearchTargetKana().isEmpty()) {
			return Pattern.N_Nothing_K_Nothing;
		}

		// なし あり
		if (inputBean.getSearchTargetName().isEmpty() && NotEmpty(inputBean.getSearchTargetKana())) {
			switch (inputBean.getKanaCondition()) {
			case Forward_Matching:
				return Pattern.N_Nothing_K_Front;
			case Backward_Matching:
				return Pattern.N_Nothing_K_BACK;
			case Partial_Matching:
				return Pattern.N_Nothing_K_Partial;
			case Perfect_Matching:
				return Pattern.N_Nothing_K_Perfect;
			}
		}

		// あり なし
		if (NotEmpty(inputBean.getSearchTargetName()) && inputBean.getSearchTargetKana().isEmpty()) {
			switch (inputBean.getNameCondition()) {
			case Forward_Matching:
				return Pattern.N_Front_K_Nothing;
			case Backward_Matching:
				return Pattern.N_Back_K_Nothing;
			case Partial_Matching:
				return Pattern.N_Partial_K_Nothing;
			case Perfect_Matching:
				return Pattern.N_Perfect_K_Nothing;
			}

		}

		// あり、あり
		if (NotEmpty(inputBean.getSearchTargetName()) && NotEmpty(inputBean.getSearchTargetKana())) {
			String context = String.join(":", inputBean.getNameCondition().name(), inputBean.getKanaCondition().name());

			switch (context) {
			// 未自動生成。 pattern文字列。
			case "Partial_Matching:Partial_Matching":
				return Pattern.N_Partial_K_Partial;
			case "Partial_Matching:Perfect_Matching":
				return Pattern.N_Partial_K_Perfect;
			case "Partial_Matching:Backward_Matching":
				return Pattern.N_Partial_K_BACK;
			case "Partial_Matching:Forward_Matching":
				return Pattern.N_Partial_K_Front;
			case "Perfect_Matching:Partial_Matching":
				return Pattern.N_Perfect_K_Partial;
			case "Perfect_Matching:Perfect_Matching":
				return Pattern.N_Perfect_K_Perfect;
			case "Perfect_Matching:Backward_Matching":
				return Pattern.N_Perfect_K_BACK;
			case "Perfect_Matching:Forward_Matching":
				return Pattern.N_Perfect_K_Front;
			case "Backward_Matching:Partial_Matching":
				return Pattern.N_Back_K_Partial;
			case "Backward_Matching:Perfect_Matching":
				return Pattern.N_Back_K_Perfect;
			case "Backward_Matching:Backward_Matching":
				return Pattern.N_Back_K_BACK;
			case "Backward_Matching:Forward_Matching":
				return Pattern.N_Back_K_Front;
			case "Forward_Matching:Partial_Matching":
				return Pattern.N_Front_K_Partial;
			case "Forward_Matching:Perfect_Matching":
				return Pattern.N_Front_K_Perfect;
			case "Forward_Matching:Backward_Matching":
				return Pattern.N_Front_K_BACK;
			case "Forward_Matching:Forward_Matching":
				return Pattern.N_Front_K_Front;
			}

		}

		return null;
	}

	public boolean NotEmpty(String str) {
		return !str.isEmpty();
	}

}
