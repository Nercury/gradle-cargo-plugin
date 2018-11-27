package com.nercury.cargobuild.tasks

import com.android.build.gradle.AppExtension
import com.nercury.cargobuild.model.ProjectArch
import com.nercury.cargobuild.outputs.CollectArchitecturesOutput
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Invokes cargo build and builds the project.
 */
open class CollectArchitecturesTask : DefaultTask() {

    @TaskAction
    fun run() {
        val android = project.properties["android"] as AppExtension
        val splits = android.splits

        val configuration = CollectArchitecturesOutput(
                archs = splits.abi.applicableFilters.map {
                    it -> ProjectArch(it)
                }.toTypedArray()
        )

        extensions.add("configuration", configuration)
    }
}