package kz.android.androidlab2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.android.androidlab2.databinding.ItemFigureBinding
import kz.android.androidlab2.models.Figure

class FigureAdapter : ListAdapter<Figure, FigureAdapter.HistoricalFigureViewHolder>(FigureDiffUtils()) {


    class FigureDiffUtils:DiffUtil.ItemCallback<Figure>(){
        override fun areItemsTheSame(oldItem: Figure, newItem: Figure): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Figure, newItem: Figure): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricalFigureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFigureBinding.inflate(layoutInflater, parent, false)
        return HistoricalFigureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoricalFigureViewHolder, position: Int) {
        val historicalFigure = getItem(position)
        holder.bind(historicalFigure)
    }

    class HistoricalFigureViewHolder(private val binding: ItemFigureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(figure: Figure) {
            with(binding) {
                tvName.text = figure.name
                tvTitle.text = figure.title
                tvBornDied.text = "Born: ${figure.info.born} - Died: ${figure.info.died}"
                tvOffice.text = "Office: ${figure.info.office.joinToString()}"
                tvNotableWork.text = "Notable Work: ${figure.info.notableWork.joinToString()}"
            }
        }
    }
}