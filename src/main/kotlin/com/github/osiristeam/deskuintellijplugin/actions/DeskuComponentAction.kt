package com.github.osiristeam.deskuintellijplugin.actions

import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.ide.actions.CreateFromTemplateAction
import com.intellij.ide.fileTemplates.FileTemplateManager
import com.intellij.ide.fileTemplates.FileTemplateUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.util.IncorrectOperationException
import icons.MyIcons


class DeskuComponentAction : CreateFromTemplateAction<PsiFile>("Desku Component", "Creates a new Desku Component", null) {

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle("Create Desku Component")
            .addKind("Class", null, "DeskuComponentClass.java")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String {
        return "Create Desku Component"
    }

    @Throws(IncorrectOperationException::class)
    override fun createFile(name: String, templateName: String, dir: PsiDirectory): PsiFile? {
        val fileTemplate = FileTemplateManager.getInstance().getInternalTemplate(templateName)
        val properties = FileTemplateManager.getInstance().defaultProperties
        val psiElement = FileTemplateUtil.createFromTemplate(fileTemplate, name, properties, dir)
        return psiElement as? PsiFile
    }
}

