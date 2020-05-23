package DataStructures;

public class HuffmanEncoderClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String code = "aaaaaaaaaaaabbbbbbbbbcccccdddddddeee";
		
		HuffmanEncoder huffman = new HuffmanEncoder(code);
		
//		huffman.display();
		
		
		String encoded = huffman.encode("bacce");
		System.out.println(encoded);
		String decoded = huffman.decode(encoded);
		System.out.println(decoded);
	}

}
