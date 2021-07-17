## Recycler View

### Data Class
```kotlin
class Languages(
    val language : String,
    val year : Int,
    val logo : Int) : Serializable {
}
```
### and Singleton Class
```kotlin
object Singleton {
    var chosenLanguage : Languages? = null
}
```
### Recycle View Adapter Class
```kotlin
class RecycleViewAdapter(private val languageList : ArrayList<Languages>) : RecyclerView.Adapter<RecycleViewAdapter.LanguageHolder>() {

    class LanguageHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) { }

    // View holder ile olusturuldugunda yurut. (Layout ile bagla.)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LanguageHolder(binding)
    }

    // Baglandiktan sonra yurut. (Data-View baglantisi.)
    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.binding.textViewRecycleItem.text = languageList[position].language
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            Singleton.chosenLanguage =languageList[position]
            holder.itemView.context.startActivity(intent)
        }
    }

    // Item sayisini al.
    override fun getItemCount(): Int {
        return languageList.size
    }
}
```
