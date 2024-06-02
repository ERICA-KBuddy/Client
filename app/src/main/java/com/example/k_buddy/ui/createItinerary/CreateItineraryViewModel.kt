import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.k_buddy.ui.createItinerary.Place
import com.example.k_buddy.ui.createItinerary.Transport

class CreateItineraryViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItineraryItem>>()
    val items: LiveData<List<ItineraryItem>> get() = _items

    private val currentItems = mutableListOf<ItineraryItem>()

    private val _containerVisibility = MutableLiveData<Boolean>()
    val containerVisibility: LiveData<Boolean> get() = _containerVisibility

    init {
        _containerVisibility.value = false
    }

    fun addPlace(place: Place) {
        currentItems.add(ItineraryItem.PlaceItem(place))
        _items.value = currentItems
    }

    fun addTransport(transport: Transport) {
        currentItems.add(ItineraryItem.TransportItem(transport))
        _items.value = currentItems
    }

    fun toggleContainerVisibility() {
        _containerVisibility.value = !_containerVisibility.value!!
    }
}

sealed class ItineraryItem {
    data class PlaceItem(val place: Place) : ItineraryItem()
    data class TransportItem(val transport: Transport) : ItineraryItem()
}
