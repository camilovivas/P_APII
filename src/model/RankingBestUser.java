package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class RankingBestUser implements Comparable<RankingBestUser>{
	
	private RankingBestUser right;
	private RankingBestUser left;
	private User player;
	
	public RankingBestUser(User player) {
		this.player=player;
	}

	public RankingBestUser getRight() {
		return right;
	}

	public void setRight(RankingBestUser right) {
		this.right = right;
	}

	public RankingBestUser getLeft() {
		return left;
	}

	public void setLeft(RankingBestUser left) {
		this.left = left;
	}
	
	
	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public String inOrden() {
		String msj = "";
		if(left != null) {
			msj += left.inOrden();
		}
		msj += " "+this.getPlayer().getRankingUser();
		if(right != null) {
			msj += right.inOrden();
		}
		return msj;
	}
	public boolean clasificationRanking(User clasi) {
		boolean menor = false;
		if(left != null) {
			if(left.getPlayer().getRankingUser()<clasi.getRankingUser()) {
				menor = true;
			}else {
				menor = left.clasificationRanking(clasi);
			}
		}if(right != null) {
			if(right.getPlayer().getRankingUser()<clasi.getRankingUser()) {
				menor = true;
			}else {
				menor = right.clasificationRanking(clasi);
			}
		}
		return menor;
	}
	public void addRankingBestUser(RankingBestUser added) {
		if(compareTo(added) == -1) {
			if(left == null) {
				setLeft(added);
			}else {
				left.addRankingBestUser(added);
			}
		}else if(compareTo(added) == 1) {
			if(right==null) {
				setRight(added);
			}else {
				right.addRankingBestUser(added);
			}
		}else {
			if(left == null) {
				setLeft(added);
			}else {
				left.addRankingBestUser(added);
			}
		}
	}
	@Override
	public int compareTo(RankingBestUser o) {
		int variable = 0;
		if(o.getPlayer().getRankingUser() < this.getPlayer().getRankingUser()) {
			variable = -1;
		}else if(o.getPlayer().getRankingUser() > this.getPlayer().getRankingUser()) {
			variable = 1;
		}
		return variable;
	}
	
	

}
