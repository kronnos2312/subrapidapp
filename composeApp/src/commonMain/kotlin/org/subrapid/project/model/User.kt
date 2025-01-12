package org.subrapid.project.model

data class User(val id:Long?,
                val name:String,
                val email:String,
                val createAt: String,
                val photo:String,
                val message:String,
                val result:String )
val users = (1..100).map{
    User(id = it.toLong(),
        name="Usuario $it",
        email = "jjoyaquintero@gmail.com",
        createAt = "",
        photo = "https://picsum.photos/200/300?random=$it",
        message = "prueba",
        result = "200"
        )
}