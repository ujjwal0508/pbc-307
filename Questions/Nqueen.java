package Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nqueen {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] board = new boolean[n][n];
		
		nQueens(board, "", 0);
		System.out.println(cnt);

	}
	static int cnt=0;

	public static void nQueens(boolean[][] board, String asf, int row) {

		if (row == board.length) {
			asf+= ".";
			System.out.println(asf);
			cnt++;
			return;
		}

		for (int col = 0; col < board.length; col++) {

			if (isSafe(board, row, col)) {
				board[row][col] = true;
				nQueens(board,asf+ row + "-" + col + ",", row + 1);
				board[row][col] = false;
			}
		}

	}

	public static boolean isSafe(boolean[][] board, int row, int col) {

		// behind col

		for (int i = row - 1; i >= 0; i--)
			if (board[i][col])
				return false;

		// beind left dia
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j])
				return false;
		}

		// behind right diag

		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
			if (board[i][j])
				return false;
		
		return true;

	}

}
