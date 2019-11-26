package model;

public class TreeRanking {
	
	private RankingBestUser rootRanking;
	
	
	public RankingBestUser getRootRanking() {
		return rootRanking;
	}
	public void setRootRanking(RankingBestUser rootRanking) {
		this.rootRanking = rootRanking;
	}
	
	//-------------------
	public String inOrden() {
		String msj = "";
		if(rootRanking != null) {
			msj += rootRanking.inOrden();
		}
		return msj;
	}
	
	public void addRanking(RankingBestUser add) {
		if(rootRanking==null) {
			setRootRanking(add);
		}else {
			rootRanking.addRankingBestUser(add);
		}
	}
	
}
