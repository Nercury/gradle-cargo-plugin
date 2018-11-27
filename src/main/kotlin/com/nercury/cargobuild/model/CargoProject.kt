package com.nercury.cargobuild.model

/**
 * Holds collected information about cargo project at specified path.
 *
 * This information is produced by DiscoverCargoProjectConfigTask.
 */
open class CargoProject(
        val manifestPath: String
)