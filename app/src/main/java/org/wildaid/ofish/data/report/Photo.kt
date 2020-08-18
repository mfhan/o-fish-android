// Please note : @LinkingObjects and default values are not represented in the schema and thus will not be part of the generated models
package org.wildaid.ofish.data.report

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId
import java.util.Date

open class Photo : RealmObject() {
    @PrimaryKey
    var _id: ObjectId = ObjectId.get()
    var thumbNail: ByteArray? = null
    var picture: ByteArray? = null
    var pictureURL: String = ""
    var referencingReportID: String = ""
    var date: Date = Date()

    fun getResourceForLoading(): Any? {
        return pictureURL.ifBlank { null }
            ?: picture
            ?: thumbNail
    }
}