package com.nercury.cargobuild

import org.gradle.api.Plugin
import org.gradle.api.Project

class CargoPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.logger.info("Applying!")
//        def extension = project.android.externalNativeBuild.extensions.create('cargo', CargoPluginExtension, project)
//        def cargoBuildTask = project.tasks.create('cargoBuild', CargoBuild) {
//            manifestPath = extension.manifestPath
//            splits = project.android.splits
//        }
//
//        def updateCargoConfigTask = project.tasks.create('updateCargoConfig', UpdateCargoConfig) {
//            manifestPath = extension.manifestPath
//        }
//
//        project.tasks.whenTaskAdded { t ->
//            logger.info "#### TASK ADDED " + t.name
//
//            if (t.name == 'assembleDebug') {
//                t.dependsOn cargoBuildTask
//                        cargoBuildTask.dependsOn updateCargoConfigTask
//            }
//        }
    }
}