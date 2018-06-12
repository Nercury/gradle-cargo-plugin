package com.nercury.cargobuild

import com.android.build.gradle.AndroidConfig
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.DynamicObjectAware
import org.gradle.api.internal.plugins.DefaultExtraPropertiesExtension
import org.gradle.api.plugins.*
import org.gradle.internal.metaobject.PropertyAccess
import javax.naming.spi.ObjectFactory
import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.allSupertypes
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.instanceParameter

class CargoPlugin: Plugin<Project> {
    override fun apply(project: Project): Unit = project.run {
        project.logger.info("Applying!")
        project.allprojects.forEach {
            project.logger.info("Project " + it.name)
        }
        project.childProjects.forEach {
            project.logger.info("Child project " + it.key)
        }
        project.subprojects.forEach {
            project.logger.info("Sub project " + it.name)
        }
        project.properties.forEach {
            project.logger.info("Sub property " + it.key)
        }
        project.components.forEach {
            project.logger.info("Sub component " + it.name)
        }
        project.plugins.forEach {
            project.logger.info("Sub plugin " + it.javaClass.name)
        }

        val appExtension = (project.properties["android"] as AppExtension);

        appExtension::class.declaredMembers.forEach {
            if (it.name == "getProperty") {
                project.logger.info("Waaau")
                val res = it.call(project.properties["android"], "externalNativeBuild"); // OMFG found it
                project.logger.info(res.toString())
            }
            project.logger.info("M " + it.name + " " + it.instanceParameter.toString())
        }

        appExtension::class.allSuperclasses.forEach {
            project.logger.info("Superclass " + it)
        }

        appExtension::class.allSupertypes.forEach {
            project.logger.info("Supertype " + it)
        }



        project.extensions.schema.forEach {
            project.logger.info("S " + it.key + " = " + it.value)
        }
        val extraProperties = extensions.extraProperties;
        extraProperties.properties.forEach {
            project.logger.info("EP " + it.key + " = " + it.value)
        }

//        project.logger.info(project.properties["android"] as com.android.tools.gradle.AppExtension);

        val externalNativeBuild = project.properties["android"] as ExtensionAware;

        if (externalNativeBuild == null) {
            project.logger.error("Failed!!!")
        } else {

            val extension = externalNativeBuild.extensions.create("cargo", CargoPluginExtension::class.java, project);
        }


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