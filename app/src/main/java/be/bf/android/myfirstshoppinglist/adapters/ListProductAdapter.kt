package be.bf.android.myfirstshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.db.entities.ListProduct

class ListProductAdapter(private val data : List<ListProduct>, private val onItemClickListener : (id : Long) -> Unit) : RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>() {

    private val _data : MutableList<ListProduct> = data.toMutableList()

    class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the the ViewHolder's View.
        val tvShowItem : TextView = view.findViewById(R.id.tv_show_item)
        val btnUpdate : Button = view.findViewById(R.id.btn_show_product_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.show_product_item, parent, false)

        return ListProductAdapter.ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.tvShowItem.text = _data[position].name
        holder.btnUpdate.setOnClickListener {
            _data[position].id?.let {
                    onItemClickListener(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    fun clear() {
        _data.clear()
        notifyDataSetChanged()
    }

    fun addData(data : List<ListProduct>) {
        _data.addAll(data)
        notifyDataSetChanged()
    }
}