package be.bf.android.myfirstshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.enums.CategoriesEnum

class CategoryAdapter(private val clickListener: (category : CategoriesEnum) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categories : Array<CategoriesEnum> = CategoriesEnum.values()

    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Bind les attributs de chaque item de la liste
        val tvCategory : TextView = view.findViewById(R.id.tv_categories_item)
        val imgCategory : ImageView = view.findViewById(R.id.img_category_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.categories_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        val categoryName = category.txt
        val categorySource = category.src

        holder.tvCategory.text = categoryName
        holder.imgCategory.setImageResource(categorySource)
        holder.view.setOnClickListener {
            clickListener(category)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}