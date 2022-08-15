package be.bf.android.myfirstshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.db.entities.Product

class UpdateListAdapter(private val data : MutableList<Product>, private val onItemClick : (btn: ClickType, produit: Product) -> Unit) : RecyclerView.Adapter<UpdateListAdapter.UpdateListViewHolder>() {

    enum class ClickType {
        PLUS, MINUS
    }

    class UpdateListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val etName : EditText = view.findViewById(R.id.et_name_product_item)
        val btn_plus : Button = view.findViewById(R.id.btn_plus)
        val btn_minus : Button = view.findViewById(R.id.btn_minus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)

        return UpdateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpdateListViewHolder, position: Int) {
        if (position < data.size) {
            holder.btn_plus.visibility = View.INVISIBLE
            holder.btn_minus.visibility = View.VISIBLE
            holder.etName.setText(data[position].name)
            holder.btn_minus.setOnClickListener {
                val produit = Product(name = holder.etName.text.toString())
                onItemClick(ClickType.MINUS, produit)
            }
        }
        else {
            holder.btn_plus.visibility = View.VISIBLE
            holder.btn_minus.visibility = View.INVISIBLE
            holder.etName.hint = "Product's Name"

            holder.btn_plus.setOnClickListener {
                val produit = Product(name = holder.etName.text.toString())
                onItemClick(ClickType.PLUS, produit)
            }
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