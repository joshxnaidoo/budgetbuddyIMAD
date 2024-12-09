import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetbuddy.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var dailySpending: DoubleArray
    private lateinit var detailsListView: ListView
    private lateinit var averageSpendingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve daily spending data from the intent
        dailySpending = intent.getDoubleArrayExtra("dailySpending") ?: DoubleArray(7)

        detailsListView = findViewById(R.id.details_list_view)
        averageSpendingTextView = findViewById(R.id.average_spending)

        // Set up ListView to display daily spending details
        val detailsAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, getDailySpendingDetails())
        detailsListView.adapter = detailsAdapter

        // Calculate and display average spending
        displayAverageSpending()

        // Set up button to show the day with the highest expense
        val buttonHighestExpense: Button = findViewById(R.id.button_highest_expense)
        buttonHighestExpense.setOnClickListener {
            showDayWithHighestExpense()
        }

        // Set up button to navigate back to the main screen
        val buttonBack: Button = findViewById(R.id.button_back)
        buttonBack.setOnClickListener {
            finish() // Navigate back to the previous activity
        }
    }

    private fun showDayWithHighestExpense() {
        TODO("Not yet implemented")
    }

    // Method to get daily spending details as strings
    private fun getDailySpendingDetails(): Array<String> {
        val daysOfWeek =
            arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        return Array(daysOfWeek.size) { index ->
            "${daysOfWeek[index]}: $${dailySpending[index]} - Morning: $${dailySpending[index] * 0.4}, Afternoon: $${dailySpending[index] * 0.6}, Notes: Example note"
        }
    }

    // Method to calculate and display average spending
    private fun displayAverageSpending() {
        dailySpending.sum()
    }
}
