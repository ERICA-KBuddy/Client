import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ItemPlaceBinding
import com.example.k_buddy.databinding.ItemTransportationBinding
import com.example.k_buddy.ui.createItinerary.Place
import com.example.k_buddy.ui.createItinerary.Transport

class ItineraryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ItineraryItem>()

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItineraryItem.PlaceItem -> R.layout.item_place
            is ItineraryItem.TransportItem -> R.layout.item_transportation
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_place -> PlaceViewHolder(ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            R.layout.item_transportation -> TransportViewHolder(ItemTransportationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ItineraryItem.PlaceItem -> (holder as PlaceViewHolder).bind(item.place)
            is ItineraryItem.TransportItem -> (holder as TransportViewHolder).bind(item.transport)
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<ItineraryItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.editTextPlaceName.setText(place.name)
            binding.editTextPlaceAddress.setText(place.address)
            binding.editTextPlaceDescription.setText(place.description)
        }
    }

    class TransportViewHolder(private val binding: ItemTransportationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transport: Transport) {
            val context = binding.root.context

            binding.editTextTransportationDescription.setText(transport.description)

            // Set up the transport type spinner
            val transportTypeAdapter = ArrayAdapter.createFromResource(
                context,
                R.array.transport_types,
                android.R.layout.simple_spinner_item
            )
            transportTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTransportType.adapter = transportTypeAdapter

            // Set up the duration units spinner
            val durationUnitsAdapter = ArrayAdapter.createFromResource(
                context,
                R.array.duration_units,
                android.R.layout.simple_spinner_item
            )
            durationUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDurationUnits.adapter = durationUnitsAdapter

            // Set selected values if needed (optional)
            binding.spinnerTransportType.setSelection(transportTypeAdapter.getPosition(transport.type))
            binding.spinnerDurationUnits.setSelection(durationUnitsAdapter.getPosition(transport.totalduration))
        }
    }
}
