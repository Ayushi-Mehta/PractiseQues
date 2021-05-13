package backTrackingII;

public class _79_WordSearch {
	static boolean ans = false;

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == word.charAt(0)) {
					wordSearch(board, 0, 0, word, 0, visited);
					if (ans == true) {
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void wordSearch(char[][] board, int row, int col, String word, int vidx, boolean[][] visited) {

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(vidx)
				|| visited[row][col] == true) {// -ve base case
			// write "board[row][col] != word.charAt(vidx) " at the end
			// as the if the other conditions are true, the next conditions are not even
			// checked
			// the other 4 always have to be false to check this last one
			return;
		}
		// write +ve base case after this so that after checking the last character it
		// matched
		if (vidx == word.length() - 1) {// +ve base case
			// checking the last character
			// System.out.println(true);
			ans = true;
			return;
		}

		visited[row][col] = true;

		wordSearch(board, row - 1, col, word, vidx + 1, visited);// top
		if (ans == true) {
			visited[row][col] = false;
			return;
		}
		wordSearch(board, row, col + 1, word, vidx + 1, visited);// right
		if (ans == true) {
			visited[row][col] = false;
			return;
		}
		wordSearch(board, row, col - 1, word, vidx + 1, visited);// left
		if (ans == true) {
			visited[row][col] = false;
			return;
		}
		wordSearch(board, row + 1, col, word, vidx + 1, visited);// bottom

		visited[row][col] = false;// undo
		
	}
}
