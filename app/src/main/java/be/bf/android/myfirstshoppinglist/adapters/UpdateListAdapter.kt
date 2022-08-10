package be.bf.android.myfirstshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.entities.Product

class UpdateListAdapter(private val data : List<Product>) : RecyclerView.Adapter<UpdateListAdapter.UpdateListViewHolder>() {

    class UpdateListViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val etName : EditText = view.findViewById(R.id.et_name_product_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return UpdateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpdateListViewHolder, position: Int) {
        if (position < data.size) {
            holder.etName.setText(data[position].name)
        }
        else {
            holder.etName.hint = "Nom du produit"

//            holder.btnAdd
//            notifyItemInserted(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}