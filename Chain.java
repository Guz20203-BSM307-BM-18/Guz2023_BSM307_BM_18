package BlockChain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chain {

	private List<Block> chain;
	int NodeSayisi;

	Chain() {
		chain = new ArrayList<Block>();
		chain.add(generateGenesis());
	}
	
	
	private Block generateGenesis() {

		Block genesis = new Block("A", new java.util.Date());
		genesis.setPreviousHash(null);
		genesis.computeHash();
		return genesis;
	}

	void addBlock(Block block) {
		Block newBlock = block;
		newBlock.setPreviousHash((chain.get(chain.size() - 1).getHash()));
		newBlock.computeHash();
		newBlock.getTimeStamp();
		newBlock.setdurum(true);
		this.chain.add(newBlock);
	}

	Scanner input = new Scanner(System.in);

	// public static final int NodeSayisi ;
	int counter = 0;
	int counter2 = 0;

	void yanars(int NodeSayisi, ArrayList<Integer> bakiyeler, String[] baglantı, String[][] nodeVeIndisler) {

		// int bakiye = 0;

		for (int i = 0; i < NodeSayisi; i++) {
			char node = (char) ('A' + i);
			nodeVeIndisler[i][0] = String.valueOf(node);
		}

		System.out.println("\n\n");
		for (int i = 0; i < NodeSayisi; i++) {

			if (counter2 < NodeSayisi) {
				System.err.print(nodeVeIndisler[i][0] + "  KULLANICININ BAKIYESI KAC ILE BASLASIN : ");
				bakiyeler.add(input.nextInt());
				counter2++;
				nodeVeIndisler[i][1] = String.valueOf(bakiyeler.get(i));
			}

			// bakiye = input.nextInt();

		}
		int index = 0;
		for (int i = 0; i < NodeSayisi; i++) {

			for (int j = i + 1; j < NodeSayisi; j++) {

				String baglanti = nodeVeIndisler[i][0] + "-" + nodeVeIndisler[j][0]; // A-B
				String baglanti2 = nodeVeIndisler[j][0] + "-" + nodeVeIndisler[i][0];
				baglantı[index++] = baglanti;
				baglantı[index++] = baglanti2;

			}
		}
		for (int counter = 0; counter < baglantı.length; counter++) {

			System.out.println("\n\n" + "****************************************");

			System.out.println("\n\n" + "BLOCK : " + baglantı[counter]);
			System.out.println();

			String[] splitBaglanti = baglantı[counter].split("-");

			String yol1 = splitBaglanti[0];
			String yol2 = splitBaglanti[1];

			int kacinciIndex = -1; // BURASI BLOĞUMUZA HANGİ NODELARIN NE KADAR BAKİYESİ OLDUĞUNU YAZMAK İCİN
									// BLOĞUMUZUN NODELARINI ALIP İKİBOYUTLUDİZİ İCİNDE NERDE OLDUĞUNU BULDUGUMUZ
									// KISIM.
			for (int v = 0; v < NodeSayisi; v++) {
				if (nodeVeIndisler[v][0].equals(yol1)) {
					kacinciIndex = v;
					break;
				}

			}

			int kacinciNode = -1;
			for (int v = 0; v < NodeSayisi; v++) {
				if (nodeVeIndisler[v][0].equals(yol2)) {
					kacinciNode = v;
					break;
				}
			}

			System.out.println("HASH : " + chain.get(counter).getHash());
			System.out.println();

			System.out.println("ONCEKI BLOGUN HASH'I : " + chain.get(counter).getPreviousHash());
			System.out.println();

			System.out.println("TIME : " + chain.get(counter).getTimeStamp());
			System.out.println();
			
			System.out.println("DURUM : " + chain.get(counter).getdurum());
			System.out.println();

			System.out.println(nodeVeIndisler[kacinciIndex][0] + "  KULLANICISININ BAKIYE BILGISI : "
					+ nodeVeIndisler[kacinciIndex][1]);
			System.out.println();
			System.out.println(nodeVeIndisler[kacinciNode][0] + "  KULLANICISININ BAKIYE BILGISI : "
					+ nodeVeIndisler[kacinciNode][1]);
			System.out.println();

			System.out.println("\n\n" + "****************************************");

		}
	}

	/*
	 * void islem() {
	 * 
	 * 
	 * input.nextLine(); System.out.println("\n\n\n");
	 * System.out.print("HANGI NODE(DUGUM)'LER ARASI ISLEM YAPILSIN : "); String
	 * islemYolu = input.nextLine(); System.out.print("MIKTAR GIRINIZ : "); int
	 * miktar = input.nextInt();
	 * 
	 * System.out.println(islemYolu+"   "+ miktar);
	 * 
	 * 
	 * }
	 */

	/*
	 * void print(){
	 * 
	 * for (int counter = 0; counter < chain.size(); counter++) {
	 * 
	 * System.out.println("BLOCK : " + counter); System.out.println();
	 * 
	 * System.out.println("ISLEM(VERI) : " + chain.get(counter).getData());
	 * System.out.println();
	 * 
	 * System.out.println("HASH : " + chain.get(counter).getHash());
	 * System.out.println();
	 * 
	 * System.out.println("ONCEKI BLOGUN HASH'I : " +
	 * chain.get(counter).getPreviousHash()); System.out.println();
	 * 
	 * System.out.println("TIME : " + chain.get(counter).getTimeStamp());
	 * System.out.println();
	 * 
	 * System.out.println("\n\n"+
	 * "*********************************************************************");
	 * 
	 * }
	 * 
	 * }
	 */

}
