package be.bf.android.myfirstshoppinglist.db

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class RoomScope(override val coroutineContext: CoroutineContext = CoroutineName("Room")) :
    CoroutineScope {
}
