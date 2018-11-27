package com.nercury.cargobuild.tasks

import com.nercury.cargobuild.model.CargoBuildOutput
import com.nercury.cargobuild.model.CargoProject
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Invokes cargo build and builds the project.
 */
open class BuildTask : DefaultTask() {

    @TaskAction
    fun run() {
        val cargoConfig = ext<DiscoverCargoProjectConfigTask, CargoProject>("configuration")

        project.logger.info("-------- Build task! ---------")
        project.logger.info("config ${cargoConfig.manifestPath}")

        extensions.add("configuration", CargoBuildOutput(
            sharedLibraryPath = "??"
        ))
    }
}