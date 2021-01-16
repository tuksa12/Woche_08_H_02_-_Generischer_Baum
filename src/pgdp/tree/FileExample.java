package pgdp.tree;

import java.util.List;

/**
 * You can modify the code in here, this will not be tested.
 */
public class FileExample {

	/**
	 * Very basic text file abstraction. More details on checking the invariants and
	 * handling invalid input as well as real files are topic of future lectures.
	 * TODO: Comment out the below to try the implementation of Segmentable
	 */
	public static class TextFile implements Segmentable<String> {

		private final List<String> path;
		private final String content;

		public TextFile(List<String> path, String content) {
			this.path = path;
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public String getFileName() {
			return path.get(path.size() - 1);
		}

		public int getSize() {
			return content.length();
		}

		@Override
		public List<String> getSegments() {
			return path;
		}
	}

	public static void main(String[] args) {
		/*
		 * TODO: Comment out the code below to try tree creation, insertion and iteration
		 */
		Tree<String, TextFile> fileTree = new Tree<>(String::compareTo);
//		fileTree.add(new TextFile(List.of("penguins.txt"), "Pinguine sind super!"));
//		fileTree.add(new TextFile(List.of("archive", "pgdp", "kranzuin.txt"), "Es war ein mal ein Kranzuin..."));
//		fileTree.add(new TextFile(List.of("archive", "pgdp", "homework", "blatt01.pdf"), "Geben Sie Hello World aus"));
//		fileTree.add(new TextFile(List.of("archive", "pgdp", "homework", "blatt03.pdf"), "Glücksbaumblätterpinguin"));
//		fileTree.add(new TextFile(List.of("archive", "pgdp", "homework", "blatt02.pdf"), "PinguArt und PinguRacing"));
//		fileTree.add(new TextFile(List.of("archive", "eidi", "vorlesungsfolien.pdf"), "PinguArt und PinguRacing"));
//		fileTree.add(new TextFile(List.of("woche08h02", "pgdp", "tree", "FileExample.java"), "StackOverflowError"));

		for (TextFile textFile : fileTree) {
			System.out.print(textFile.getFileName());
			System.out.print(": ");
			System.out.println(textFile.getContent());
		}

		/*
		 * TODO: Comment out the code below to try tree map
		 */
//		System.out.println();
//
//		List<StringBuilder> lines = fileTree.map(textFile -> {
//			StringBuilder line = new StringBuilder();
//			line.append(textFile.getFileName());
//			line.append(" (");
//			line.append(textFile.getSize());
//			line.append(")");
//			return List.of(line);
//		}, (folderName, childrensLines) -> {
//			List<StringBuilder> newLines = new ArrayList<>();
//			newLines.add(new StringBuilder(folderName == null ? "/" : folderName + "/"));
//			for (int i = 0; i < childrensLines.size(); i++) {
//				boolean isLast = i == childrensLines.size() - 1;
//				List<StringBuilder> linesOfCurrentChild = childrensLines.get(i);
//				newLines.add(linesOfCurrentChild.get(0).insert(0, isLast ? " +-- " : " |-- "));
//				for (int j = 1; j < linesOfCurrentChild.size(); j++) {
//					newLines.add(linesOfCurrentChild.get(j).insert(0, isLast ? "     " : " |   "));
//				}
//			}
//			return newLines;
//		});
//		for (StringBuilder line : lines) {
//			System.out.println(line);
//		}
	}
}
