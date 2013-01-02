package org.eclipse.vjet.dsf.jst.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.vjet.dsf.jst.FileBinding;
import org.eclipse.vjet.dsf.jst.IJstType;
import org.eclipse.vjet.dsf.jst.JstCommentLocation;
import org.eclipse.vjet.dsf.jst.SimpleBinding;
import org.eclipse.vjet.dsf.jst.JstSource.IBinding;

public class JstCommentHelper {

	public static List<String> getCommentsAsString(IJstType jstType,
			List<JstCommentLocation> commentLocations) {
		return getCommentsAsString(jstType, commentLocations, false);
	}
	
	public static List<String> getCommentsAsString(IJstType jstType,
			List<JstCommentLocation> commentLocations, boolean includeVjetDocs){	// locate file
		List<String> comments = new ArrayList<String>();
		if(jstType.getSource()==null){
			return Collections.EMPTY_LIST;
		}
		IBinding binding = jstType.getSource().getBinding();
		if (binding instanceof SimpleBinding) {
			handleSimpleBinding(commentLocations, comments, (SimpleBinding)binding, includeVjetDocs);
		}

		if (binding instanceof FileBinding) {
			handleFileBinding(commentLocations, comments, binding, includeVjetDocs);

		}
		return comments;
	}

	private static void handleSimpleBinding(
			List<JstCommentLocation> commentLocations, List<String> comments,
			SimpleBinding binding, boolean includeVjetDocs) {
		String source = binding.toText();
		for (JstCommentLocation jstCommentLocation : commentLocations) {
			if(!jstCommentLocation.isVjetDoc() || (includeVjetDocs && jstCommentLocation.isVjetDoc())){
				comments.add(source.substring(jstCommentLocation.getStartOffset(),
						jstCommentLocation.getEndOffset()));
			}

		}

	}

	private static void handleFileBinding(
			List<JstCommentLocation> commentLocations, List<String> comments,
			IBinding binding, boolean includeVjetDocs) {
		FileBinding fileBinding = (FileBinding) binding;
		RandomAccessFile random = null;
		try {
			random = new RandomAccessFile(fileBinding.getFile(), "r");
			for (JstCommentLocation jstCommentLocation : commentLocations) {
				random.seek(jstCommentLocation.getStartOffset());
				String line = null;
				while ((line = random.readLine()) != null) {
					// process each line in some way
					comments.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				random.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
