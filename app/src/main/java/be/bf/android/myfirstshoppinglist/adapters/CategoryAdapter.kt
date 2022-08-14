package be.bf.android.myfirstshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.bf.android.myfirstshoppinglist.R
import be.bf.android.myfirstshoppinglist.enums.CategoriesEnum

/**
 * Provide a reference to the type of views that you are using (category ViewHolder).
 */
class CategoryAdapter(private val clickListener: (category : CategoriesEnum) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categories : Array<CategoriesEnum> = CategoriesEnum.values()

    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the the ViewHolder's View.
        val tvCategory : TextView = view.findViewById(R.id.tv_categories_item)
        val imgCategory : ImageView = view.findViewById(R.id.img_category_item)
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            // Create a new view, which defines the UI of the list item
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.categories_item, parent, false)
        return CategoryViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val category = categories[position]
        val categoryName = category.txt
        val categorySource = category.src

        holder.tvCategory.text = categoryName
        holder.imgCategory.setImageResource(categorySource)
        holder.view.setOnClickListener {
            clickListener(category)
        }
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return categories.size
    }
}