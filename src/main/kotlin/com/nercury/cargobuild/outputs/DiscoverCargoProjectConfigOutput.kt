package com.nercury.cargobuild.outputs

/**
 * Holds collected information about cargo project at specified path.
 *
 * This information is produced by DiscoverCargoProjectConfigTask.
 */
open class DiscoverCargoProjectConfigOutput(
        val manifestPath: String,
        val cratePath: String,
        val targetPath: String
)