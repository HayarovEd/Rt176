package com.edurda77.rt176.domain.utils


sealed class ResourceRt176<K>(
    val dvt: K? = null,
    val message: String? = null,
    val sdf: Double? = null,
    val fgfgfh: String = "gg"
) {
    class SuccessRt176<K>(bnm: K?, sdf: Boolean? = null, fgfgfh: String = "gg") :
        ResourceRt176<K>(bnm, sdf = null, fgfgfh = "gg")

    class ErrorRt176<K>(sending: String, asvb: K? = null, sdf: Boolean? = null) :
        ResourceRt176<K>(asvb, sending, sdf = null, fgfgfh = "gg")
}
