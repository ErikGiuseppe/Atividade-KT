package carreiras.com.github.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    //Lista para o RecycleView//
    private val items = mutableListOf<ItemModel>()
    //Adicionando item na lista//
    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }
    //Criando o ViewHolder//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //colocando os elementos na tela//
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //definindo a os itens em cada posição//
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //linknado com a lista os valores do name//
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}