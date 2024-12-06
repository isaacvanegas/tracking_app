package ni.com.groupi.tracking_app.activity

import android.R
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import ni.com.groupi.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val entries: ArrayList<PieEntry> = ArrayList<PieEntry>()
        entries.add(PieEntry(40f,"No entregadas"))
        entries.add(PieEntry(30f, "Nuevas entregas"))
        entries.add(PieEntry(20f, "Entregadas"))
        entries.add(PieEntry(10f, "Devueltas"))

        // Asegurarse de que hay entradas en el dataset
        if (entries.isNotEmpty()) {

//            val dataSet = PieDataSet(entries, "Tasks")
//            dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
//
//
//            val data = PieData(dataSet)
//            binding.pieChart.data = data
//            binding.pieChart.invalidate() // Refresh chart



//            val colors = arrayListOf(
//                Color.RED,
//                Color.BLUE,
//                Color.GREEN,
//                Color.YELLOW
//            )

            val dataSet = PieDataSet(entries,"")
            dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
           // dataSet.colors = colors
            dataSet.valueTextColor = Color.WHITE

            val data = PieData(dataSet)
            data.setDrawValues(true) // Quitar los números del gráfico


            //data.setDrawValues(false) // Mostrar los valores en el gráfico
            data.setValueTextSize(10f) // Cambiar el tamaño del valor
            data.setValueFormatter(PercentFormatter( binding.pieChart))


            binding.pieChart.data = data


            binding.pieChart.setUsePercentValues(true) // Usar valores en porcentaje
            //binding.pieChart.description.isEnabled = false

            // Configurar la leyenda
            val legend = binding.pieChart.legend
            legend.verticalAlignment = Legend.LegendVerticalAlignment.CENTER
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            legend.orientation = Legend.LegendOrientation.VERTICAL
            legend.setDrawInside(false)


            // Agrandar el texto de la leyenda y cambiar el color
            legend.textSize = 16f
            legend.textColor = Color.BLACK

            binding.pieChart.invalidate() // Refresh chart

        } else {
            // Manejar el caso donde no hay datos
            binding.pieChart.setNoDataText("No data available")
        }
    }
}