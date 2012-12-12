package org.eclipse.vjet.eclipse.javatojs.ui.commands;

import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class WorkspaceUtil {
//	private static final Logger logger = Logger.getLogger(WorkspaceUtil.class); 
	public WorkspaceUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	static public String getSemiColonDelimitedWorkspaceProjects() {

		IProject[] workspaceProjects = getWorkspaceProjects();

		StringBuilder projectString = new StringBuilder(2048);
		for (IProject project : workspaceProjects) {
			projectString.append(project.getName());
			projectString.append(";");
		}
		return projectString.substring(0, projectString.length() - 1);
	}

	static public IProject[] getWorkspaceProjects() {
		return ResourcesPlugin.getWorkspace().getRoot().getProjects();

	}

	public static List<IJavaProject> getAllProjects() throws JavaModelException {

		IProject[] workspaceProjects = WorkspaceUtil.getWorkspaceProjects();

		List<IJavaProject> javaProjectList = new ArrayList<IJavaProject>();

		for (IProject workspaceProject : workspaceProjects) {
			try {

				if (isJavaProject(workspaceProject)) {
					IJavaProject codeGenJavaProject = JavaCore
							.create(workspaceProject);
//					logger.info("project="+codeGenJavaProject.getElementName());
					if (!codeGenJavaProject.isOpen()) {
						codeGenJavaProject.open(null);
					}
					if (codeGenJavaProject.exists()) {
						javaProjectList.add(codeGenJavaProject);
					}
				}

			} catch (JavaModelException e) {
				// Ignore projects that we can not open
				continue;
			} catch (CoreException e) {
				// Ignore projects that we can not open
				continue;
			}

		}
		return javaProjectList;
	}

	public static boolean isJavaProject(IProject workspaceProject) throws CoreException {
		return workspaceProject
				.getNature("org.eclipse.jdt.core.javanature") != null;
	}

}
