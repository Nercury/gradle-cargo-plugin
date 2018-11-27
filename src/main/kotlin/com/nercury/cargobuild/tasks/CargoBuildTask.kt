package com.nercury.cargobuild.tasks

import com.nercury.cargobuild.outputs.CargoBuildOutput
import com.nercury.cargobuild.outputs.CollectArchitecturesOutput
import com.nercury.cargobuild.outputs.DiscoverCargoProjectConfigOutput
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Invokes cargo build and builds the project.
 */
open class CargoBuildTask : DefaultTask() {

    @TaskAction
    fun run() {
        val cargoConfig = ext<DiscoverCargoProjectConfigTask, DiscoverCargoProjectConfigOutput>("configuration")
        val architecturesConfig = ext<CollectArchitecturesTask, CollectArchitecturesOutput>("configuration")

        project.logger.info("-------- Build task! ---------")
        project.logger.info("config manifestPath: ${cargoConfig.manifestPath}, " +
                "cratePath: ${cargoConfig.cratePath}, " +
                "targetPath: ${cargoConfig.targetPath}")
        architecturesConfig.archs.forEach { it ->
            project.logger.info("arch abi: ${it.abi}")
        }

        extensions.add("configuration", CargoBuildOutput(
            sharedLibraryPath = "??"
        ))
    }
}