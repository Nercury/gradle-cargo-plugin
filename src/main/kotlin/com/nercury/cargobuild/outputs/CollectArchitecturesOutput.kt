package com.nercury.cargobuild.outputs

import com.nercury.cargobuild.model.ProjectArch

/**
 * Holds collected architectures from project.
 *
 * This information is produced by CollectArchitecturesTask.
 */
open class CollectArchitecturesOutput(
        val archs: Array<ProjectArch>
)