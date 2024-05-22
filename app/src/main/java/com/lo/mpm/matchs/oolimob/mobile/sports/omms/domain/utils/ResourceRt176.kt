package com.lo.mpm.matchs.oolimob.mobile.sports.omms.domain.utils


sealed class ResourceRt176<K>(
    val dvtRt176: K? = null,
    val messageRt176: String? = null,
    val sdfRt176: Double? = null,
    val fgfgfhRt176: String = "gg"
) {
    class SuccessRt176<K>(bnm: K?, sdf176: Boolean? = null, fgfgfh176: String = "gg") :
        ResourceRt176<K>(bnm, sdfRt176 = null, fgfgfhRt176 = "gg")

    class ErrorRt176<K>(sending: String, asvb: K? = null, sdf176: Boolean? = null) :
        ResourceRt176<K>(asvb, sending, sdfRt176 = null, fgfgfhRt176 = "gg")
}
