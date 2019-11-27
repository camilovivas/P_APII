package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

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
	
	public boolean clasification(User cla) {
		boolean menor = false;
		if(rootRanking != null) {
			if(rootRanking.getPlayer().getRankingUser()<cla.getRankingUser()) {
				menor = true;
			}else{
				menor = rootRanking.clasificationRanking(cla);
			}
		}else {
			menor=true;
		}
		return menor;
	}
	
}
